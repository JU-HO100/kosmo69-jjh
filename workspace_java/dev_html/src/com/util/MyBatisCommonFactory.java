package com.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;
//공통팀에서 하는 작업이다. 
public class MyBatisCommonFactory {
	//선언부
	//xml문서로 부터 객체를 주입받아야 하니까 절대로 단독으로 인스턴스화를 하면 안된다.
	//객체 생성은 MapperConfig.xml파일로부터 생성이 되기 때문에 지금 하면 안된다.
	public SqlSessionFactory sqlSessionFactory = null;//서버와 연결이 먼저이기 때문에 Factory가 먼저 선언(메모리에 로딩)이 되어야 한다. //무리군주
	//물리적으로 떨어져 있는 오라클과 연결통로
	//오라클서버에 요청을 할때(DNL)
	//SqlSession(MyBatis)은 커밋과 롤백을 지원해준다.
	public SqlSession sqlSession = null;//공생충
	//SqlSessionFactory와 의존관계에 있다.
	//생성자
	
	//초기화
	public void init() {
		try {
			String resource = "com/util/Configuration.xml";
			Reader reader = Resources.getResourceAsReader(resource);//io가 들어가 있기 때문에 반드시 예외처리해야 한다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development2");
			//sqlession 어디감?
			System.out.println("SqlSessionFactory(SqlSessionFactoryBean)"+sqlSessionFactory);
		} catch (FileNotFoundException fe) {//좀더 포괄적이다. 하지만 어떤것이 문제 인지 알 수 없다.
			System.out.println("Exception"+fe.getMessage());
		} catch (IOException ie) {
			System.out.println("Exception"+ie.getMessage());
		}catch (Exception e) {
		System.out.println("Exception"+e.getMessage());
	} 
	}
	//싱글톤 패턴으로 개발을 전개해야 할 때는 메소드로 객체 주입 받도록 한다.
	//한번 생성한 후 서버가 유지되는 동안에는 계속 사용할 수 있도록 한다.
	//scope: app
	public SqlSessionFactory getSqlSessionFactory() {
		init();//객체 생성이 일어났다.
		return sqlSessionFactory; //리턴만 썻을 경우 null상태이다
	}
}
