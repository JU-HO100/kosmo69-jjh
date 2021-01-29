package mvc2.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class TestDao {
	Logger logger = Logger.getLogger(TestDao.class);
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	SqlSessionFactory sqlSessionFactory = null;
	public TestDao() {
		mcf = new MyBatisCommonFactory();
		sqlSessionFactory = mcf.getSqlSessionFactory();
	}
	public List<Map<String, Object>> swDesignExam() {
		logger.info("tDao swDesignExam 호출");
		List<Map<String,Object>> testList = null;
		Map<String,Object> pmap = new HashMap<>();
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			testList = sqlSession.selectList("swDesignExam",pmap);
			logger.info("testList.size() : "+testList);
			System.out.println("pmap : "+pmap.get("key"));
			testList.add(pmap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			//아래 코드를 하지 않고 테스트를 할 경우 오라클 서버의 세션이 갯수가 Max로 차게 되어서
			//오라클 서버를 재기동해야 한다. - 주의할것!!!
			if(sqlSession !=null) {
				sqlSession.close();
			}
		} 
		return testList;
	}
	public List<Map<String, Object>> subjectList() {
		logger.info("tDao subjectList 호출");
		List<Map<String,Object>> subList = new ArrayList<>();
		Map<String,Object> pmap = new HashMap<>();
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			subList = sqlSession.selectList("subjectList",pmap);
			logger.info("subjectList.size() : "+subList);
			subList.add(pmap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			sqlSession.close();
			//아래 코드를 하지 않고 테스트를 할 경우 오라클 서버의 세션이 갯수가 Max로 차게 되어서
			//오라클 서버를 재기동해야 한다. - 주의할것!!!
			if(sqlSession !=null) {
				sqlSession.close();
			}
		} 
		return subList;
	}
	
	public String isOk(Map<String, Object> pmap) {
		logger.info("tDao isOk 호출");
	      String msg = null;
	      SqlSession sqlSession = null;
	      try {
	         sqlSession = sqlSessionFactory.openSession();
	         msg = sqlSession.selectOne("isOk", pmap);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return msg;

	}

}
