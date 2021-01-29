package oracle.mybatis;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.vo.EmpVO;

public class EmpDAO2 {
		//서버의 물리적인 정보를 받아오기
		//XML문서가 물리적으로 어디에 있는지 알아야 한다.
		String resource = "oracle/mybatis/MapperConfig2.xml";//2강의장에서 쓰기위해 주소를 바꿈
		Reader reader = null;
		//mybatis에서 지원하는 클래스로 
		SqlSessionFactory sqlMapper = null;
		//쿼리문의 아이디와 메소드 이름은 일치시켜야한다. - 통일을 해준다.
		public List<Map<String,Object>> getJobSumList(){
			List<Map<String,Object>> empList = null;
			SqlSession session = null;
			try {
				//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader <-> Writer
				//Reader = 문서를 읽는대 필요한 클래스
				reader = Resources.getResourceAsReader(resource);//io가 들어가 있기 때문에 반드시 예외처리해야 한다.
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);//
				session = sqlMapper.openSession();
				empList = session.selectList("getJobSumList");
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			if(empList == null) {
				empList = new ArrayList<>();
			}
			return empList;
		}
		public EmpVO getJobSumList2(){
			EmpVO reVO = null;
			SqlSession session = null;
			try {
				//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader <-> Writer
				//Reader = 문서를 읽는대 필요한 클래스
				reader = Resources.getResourceAsReader(resource);//io가 들어가 있기 때문에 반드시 예외처리해야 한다.
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);//
				session = sqlMapper.openSession();
				reVO = session.selectOne("getJobSumList2");
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			if(reVO == null) {
				reVO = new EmpVO();
			}
			return reVO;
		}
		public static void main(String[] args) {
			EmpDAO2 eDao =new EmpDAO2();
			List<Map<String,Object>> empList = eDao.getJobSumList();
			System.out.println("empList.size() ===> "+empList.size());
			for(int i=0;i<empList.size();i++) {
				Map rmap = empList.get(i);
				System.out.println(rmap);
				System.out.println(rmap.get("EMPNO"));
				System.out.println(rmap.get("ENAME"));
				System.out.println(rmap.get("SAL"));//여기서 쓸때는 대문자로 써야한다.
			}
			/////////////////////// before ///////////////////////////////
			/*
			EmpVO empList = eDao.getJobSumList2();
			System.out.println("jobLst.size() ===> "+empList.size());
			for(int i=0;i<empList.size();i++) {
				Map rmap = empList.get(i);
				System.ou.purintln(rmap);
				System.out.println(rmap.get("CLERK_SUM"));
				System.out.println(rmap.get("SALESMAN_SUM"));
				System.out.println(rmap.get("ETC_SUM"));//여기서 쓸때는 대문자로 써야한다.
			}
			*/
			///////////////////////// before ///////////////////////////////
			///////////////////////// after ////////////////////////////////
//			EmpVO reVO = eDao.getJobSumList2();
//			System.out.println("reVO() ===> "+reVO);
//			System.out.println("reVO() ===> "+reVO.getEtc_sum());
//			System.out.println(reVO.getClerk_sum());
//			System.out.println(reVO.getSalesman_sum());
//			System.out.println(reVO.getEtc_sum());
	}
}

