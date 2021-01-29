package oracle.mybatis;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapDeptDAO2 {
	//서버의 물리적인 정보를 받아오기
	//XML문서가 물리적으로 어디에 있는지 알아야 한다.
	String resource = "oracle/mybatis/MapperConfig2.xml";//xml파일의 정보가 담긴 주소
	Reader reader = null;//읽어오기 위한 클래스(IO클래스)
	//mybatis에서 지원하는 클래스로 
	SqlSessionFactory sqlMapper = null;
	//연결통로
	//SqlSessionFactory과 SqlSession은 서로 의존관계이다 
	//SqlSessionFactor가 먼저 메모리(인스턴스화)에 저장이 되어야한다.
	
	public List<Map<String,Object>> getDeptList(){
		//Map과 VO는 1개의 row만 담을 수 있다. 여러개의 row를 담으려면 Map과 VO를 List에 담으면 된다.
		List<Map<String,Object>> deptList = null;
		SqlSession session = null;//연결된 통로로 들어온 정보를 처리해주는 작업
		try {
			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader(읽기) <-> Writer(쓰기)
			//Reader = 문서를 읽는대 필요한 클래스
			reader = Resources.getResourceAsReader(resource);//io가 들어가 있기 때문에 반드시 예외처리(try-catch)해야 한다.
			//reader = resoutce에 정보를 읽어오는 작업
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);//
			//sqlMapper = resoutce에서 가져온 정보를 저장해서 쌓는 작업 
			session = sqlMapper.openSession();
			//session = sqlMapper을 통해 쌓아놨던 정보를 유저가 원하는 작업을 처리해준다.
			deptList = session.selectList("getDeptList");
			
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(deptList == null) {
			deptList = new ArrayList<>();
		}
		return deptList;
	}
	public static void main(String[] args) {
		SqlMapDeptDAO dDao =new SqlMapDeptDAO();
		List<Map<String,Object>> deptList = dDao.getDeptList();
		System.out.println("deptList.size() ===> "+deptList.size());
			
		
	}
}
