package web.mvc;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.util.MyBatisCommonFactory;
import com.vo.DeptVO;

public class SqlMapDeptDAO {
	Logger logger = Logger.getLogger(SqlMapDeptDAO.class);
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	
	
//	String resource = "com/util/Configration.xml";
//	String resource = "oracle/mybatis/MapperConfig.xml";
	// xml문서가 물리적으로 어디 있는지 알아야한다.
//	Reader reader = null;
	// mybatis에서 지원하는 클래스로
	SqlSessionFactory sqlMapper = null;
	// 서버의 물리적인 정보를 받아오기

	public SqlMapDeptDAO() {
		sqlMapper = mcf.getSqlSessionFactory();
		
	}

	public List<Map<String, Object>> getDeptList() {
		List<Map<String, Object>> deptList = null;
		SqlSession session = null;
		try {
			// 물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader <-> Writer
			// Reader = 문서를 읽는대 필요한 클래스
//			reader = Resources.getResourceAsReader(resource);// io가 들어가 있기 때문에 반드시 예외처리해야 한다.
//			sqlMapper = new SqlSessionFactoryBuilder().build(reader);//
			session = sqlMapper.openSession(true);
			deptList = session.selectList("getDeptList");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (deptList == null) {
			deptList = new ArrayList<>();
		}
		return deptList;
	}

	public int deptInsert(int deptno, String dname, String loc) {
		int result = 0;// 1이면 성공 0이면 실패
		SqlSession session = null;
		try {
			// 물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader <-> Writer
			// Reader = 문서를 읽는대 필요한 클래스
//			reader = Resources.getResourceAsReader(resource);// io가 들어가 있기 때문에 반드시 예외처리해야 한다.
//			sqlMapper = new SqlSessionFactoryBuilder().build(reader);//
			// 마이바티스에서는 setAutoCommit(true)대신에 openSession(ture)을 사용할 수 있다.
			// 자동 커밋 모드를 켜두었으므로 따로 커밋을 하지 않더라도 자동으로 커밋이 실행된다.
			// 만일 파라미터를 비워두면 (아래처럼) 디폴트값이 false여서 커밋을 반드시 따로 해주어야 한다.
			// 결과적으로 자바에서는 true가 디폴트이고 mtbatis에서는 디폴트가 false이다.
			session = sqlMapper.openSession();
//			session = sqlMapper.openSession(true);	//autoCommit이 자동으로 된다.
//			session = sqlMapper.openSession(false);	//autoCommit을 따로 써주어야한다.
			Map<String, Object> pMap = new HashMap<>();
			pMap.put("deptno", deptno);
			pMap.put("dname", dname);
			pMap.put("loc", loc);
			result = session.insert("deptInsert", pMap);
			session.commit();// 꼭 써야한다. 디폴트가 꺼져 있기 때문에
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public int multiDeptInsert(List<Map<String, Object>> list) {
		int result = 0;// 넣은 숫자만큼 나오면 성공 0이면 실패
		SqlSession session = null;
		try {
//			reader = Resources.getResourceAsReader(resource);// io가 들어가 있기 때문에 반드시 예외처리해야 한다.
//			sqlMapper = new SqlSessionFactoryBuilder().build(reader);//

			result = session.insert("multiDeptInsert", list);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			session.close();
		}
		return result;
	}
	
	public int deptDelete(Map<String, Object> dMap) {
		int result = 0;// 넣은 숫자만큼 나오면 성공 0이면 실패
		SqlSession session = sqlMapper.openSession();
		try {
			
			result = session.delete("deptDelete", dMap);
			logger.info("result :" + result);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	public int deptDelete1(int deptno) {
		int result = 0;// 넣은 숫자만큼 나오면 성공 0이면 실패
		SqlSession session = sqlMapper.openSession();
		try {
			
			result = session.delete("deptDelete1", deptno);
			logger.info("result :" + result);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public int deptDelete2(DeptVO dVO) {
		int result = 0;// 넣은 숫자만큼 나오면 성공 0이면 실패
		SqlSession session = sqlMapper.openSession();
		try {
			dVO = new DeptVO();
			dVO.setDeptno(11);
			result = session.delete("deptDelete2", dVO);
			logger.info("result :" + result);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public int deptDelete3(Map<String, Object> dMap) {
		int result = 0;// 넣은 숫자만큼 나오면 성공 0이면 실패
		SqlSession session = sqlMapper.openSession();
		try {
			dMap = new HashMap<>();
			dMap.put("deptno", 43);
			result = session.delete("deptDelete3", dMap);
			logger.info("result :" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}


	public int deptDeleteList(List<Map<String, Object>> dlist) {
//		List<Map<String,Object>> ddlist = null;
		int result = 0;// 넣은 숫자만큼 나오면 성공 0이면 실패
		SqlSession session = sqlMapper.openSession();
		;
		try {
//			reader = Resources.getResourceAsReader(resource);// io가 들어가 있기 때문에 반드시 예외처리해야 한다.
//			sqlMapper = new SqlSessionFactoryBuilder().build(reader);//
			result = session.delete("deptDeleteList", dlist);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	public int deptUpdate(DeptVO dVO) {
		int result = 0;// 넣은 숫자만큼 나오면 성공 0이면 실패
		SqlSession sqlSession = sqlMapper.openSession();
		try {
			dVO = new DeptVO();
			dVO.setDeptno(51);//여기만 존재하면 나머지 2군대가 빈 문자열이더라도 상관없다.
			dVO.setDname("운영2팀");
			dVO.setLoc	("강남");
			result = sqlSession.update("deptUpdate", dVO);
			sqlSession.commit();
			logger.info("result :" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	public static void main(String[] args) {
		SqlMapDeptDAO dDao = new SqlMapDeptDAO();
		List<Map<String,Object>> deptList = dDao.getDeptList();
		dDao.deptUpdate(null);
		Gson g = new Gson();
		String temp = g.toJson(deptList);
		System.out.println(temp);
//		DeptVO dVO = new DeptVO();
		////////////////////// 입력 시작///////////////////////////
		List<Map<String,Object>> List = dDao.getDeptList();
		System.out.println("deptList.size() ===> "+deptList.size());
		int result = dDao.deptInsert(43, "부", "동");
		System.out.println("result ===> :"+result);
		////////////////////// 입력 끝////////////////////////////////
		////////////////////// 다중 입력 시작////////////////////////////////
//		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
//		Map<String,Object> pMap = new HashMap<String, Object>();
//		pMap.put("deptno",41);
//		pMap.put("dname","해외영업2팀");
//		pMap.put("loc","인천");
//		list.add(pMap);
//		pMap = new HashMap<>();
//		pMap.put("deptno",42);
//		pMap.put("dname","연구소");
//		pMap.put("loc","천안");
//		list.add(pMap);
//		pMap = new HashMap<>();
//		pMap.put("deptno",33);
//		pMap.put("dname","연구소2");
//		pMap.put("loc","여수");
//		list.add(pMap);
//		int result = 0;
//		result = dDao.multiDeptInsert(list);//I,U,D의 리턴값은 int이다
//		System.out.println("result ====>" +result);
		///////////////////// 다중 입력 끝//////////////////////////////
		///////////////////// 삭제 시작////////////////////////////////
//		Map<String,Object> dMap = new HashMap<>();
//		dMap.put("deptno", 51);
//		int result = 0;
//		result = dDao.deptDelete(dMap);
//		
//		System.out.println("result ===> "+result);
		///////////////////// 삭제 끝//////////////////////////////////
		///////////////////// 삭제 int,VO,Map/////////////////////////
//		int result = 0;
//		result = dDao.deptDelete1(41);
//		System.out.println("result intDelete ===>" +result);
//		result = 0;
//		dVO.setDeptno(42);
//		result = dDao.deptDelete2(dVO);
//		System.out.println("result VODelete===>" +result);
		
//		Map<String,Object> dMap = new HashMap<>();
//		dDao.deptDelete3(dMap);
//		dMap.put("deptno", 43);
		///////////////////// 삭제 int,VO,Map 끝/////////////////////////
		///////////////////// 다중 삭제 시작/////////////////////////////
//		String deptnos[] = {"71","72","73"};
//		int result = dDao.deleteDeptALL(deptnos);
//		System.out.println("result ===>" +result);
///////////////////////////// 다중 삭제 끝 ////////////////////////////////
/////////////////////////////// 업데이트 시작 //////////////////////////////
		
//		int result = dDao.deptUpdate();
//		System.out.println("result ===>" +result);
/////////////////////////////// 업데이트 끝 ////////////////////////////////		
} /////////////////////////////end of main /////////////////////////////
	
//		public int deleteDeptALL(String[] deptnos) {
//			int result = 0;// 
//			SqlSession sqlSession = sqlMapper.openSession();
//			try {
//				result = sqlSession.delete("deleteDeptALL", deptnos);
//				sqlSession.commit();
//				logger.info("result :" + result);
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				sqlSession.close();
//			}
//			return result;
//		}
		///////////////////// 다중 삭제 끝///////////////////////////////
	
	
	
}
