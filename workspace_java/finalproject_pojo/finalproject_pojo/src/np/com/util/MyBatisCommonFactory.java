package np.com.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisCommonFactory {
	//선언부
	//xml 문서로부터 객체를 주입받아야 하니까 절대로 단독으로 인스턴스화 하면 안됨.
	private static final String  resource = "np/com/util/Configuration.xml";
	private static SqlSessionFactory 		sqlSessionFactory = null;
	//오라클 서버에 요청할 때(DML) : S/I/U/D
	//SqlSessionFactory 와 의존관계 있다.
	

	//생성자  //직접 인스턴스화를 막기위해 private 걸어둠
	private MyBatisCommonFactory() {}


	/*
	getter 메소드의 synchronized 선언
	synchronized 를 선언 하지 않았을 때의 문제점 :
	     -  2개의 thread가 동시에 getSqlSessionFactory()를 호출한다면 동시에 2개의 객체가 생성되어 버릴 수도 있다.
	     
	 *******************************************형식********************************************
	 
	 					public static synchronized SqlSessionFactory getSqlSessionFactory(){}
	 
	 *******************************************************************************************
	 
	 하지만
		이 구현법의 단점을 생각해보자면 아래와 같다.
		
			- 1. locking overhead 로 인한 성능 저하
			-	2. 일단 인스턴스가 초기화되고나면 필요없는 synchronization이 계속해서 발생함으로써 효율성이 저하된다.
		
		2의 단점을 상쇄하기 위해서 synchronized 키워드를 if 블록 안으로 이동시킨다면,
		 synchronization이 초기화시점에서만 진행되게 되어 퍼포먼스가 훨씬 향상될것이다.

	  ------------------------------ locking overhead 란?-------------------------------
	  - 오버헤드란?(overhead)
	   		오버헤드(overhead)는 어떤 처리를 하기 위해 들어가는 간접적인 처리 시간 · 메모리 등을 말한다.
			예를 들어 A라는 처리를 단순하게 실행한다면 10초 걸리는데, 
			안전성을 고려하고 부가적인 B라는 처리를 추가한 결과 처리시간이 15초 걸렸다면, 오버헤드는 5초가 된다.
			또한 이 처리 B를 개선해 B'라는 처리를 한 결과, 처리시간이 12초가 되었다면, 이 경우 오버헤드가 3초 단축되었다고 말한다
	 
	  - 락킹이란? (locking)
			하나의 트랜잭션이 데이터를 액세스하는 동안 다른 트랜잭션은 그 데이터를 액세스할 수 없게 하는 방법
			트랙잭션은 데이터를 액세스하기 전에 Lock을 요청하고 액세스를 마치고 Lock을 해제
			이미 Lock이 걸려 있을 때는 Lock이 풀리기 전에는 액세스할 수 없음
			Locking 단위가 작으면 병행성 수준이 높아지며 대신 Locking 오버헤드는 증가합니다.
	 */
	
	
	
	//싱글톤 패턴으로 개발을 전개해야 할 때는 메소드로 객체 주입 받도록 한다.
	//한번 생성한 후 서버가 유지되는 동안에는 계속 사용할 수 있도록 함.
	//scope : application scope를 갖도록 한다.
	public static  SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory==null) {
			synchronized (SqlSessionFactory.class)
			{
				if(sqlSessionFactory==null) {
					Reader reader = null;
					try {
						//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어와야 함. Reader <-> Writer
						//문서를 읽는데 필요한 클래스
						reader = Resources.getResourceAsReader(resource);
						// 리더를 박고 어디서 읽을건지?? -> (리더기, environment id = " 이곳 ")
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
					}catch(FileNotFoundException fe) {
						System.out.println("Exception : "+fe.getMessage());
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return sqlSessionFactory;
	}
}
