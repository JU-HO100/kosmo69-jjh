package web.mvc;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;




public class BbsDAO {
	Logger logger  = Logger.getLogger(BbsDAO.class);
	//MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	String resource = "com/util/Configuration.xml";
	SqlSessionFactory sqlMapper = null;	
	
	public List<Map<String,Object>> getBbsList(){
		List<Map<String,Object>> bbsList = null;
		SqlSession session = null;
		try {
//			logger.info("다오실행");
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper "+sqlMapper);
			session = sqlMapper.openSession();
			bbsList = session.selectList("getBbsList");
			logger.info("bbsList : "+bbsList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}	
		return bbsList;
	}
	
	public int insertBbs(BbsVO bVO){
		System.out.println(bVO.toString());
		SqlSession session = null;
		int result = 0;
		try {
			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어와야 함.Reader<->Writer
			//문서를 읽는데 필요한 클래스
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper "+sqlMapper);
			//커넥션 연결 위한 사전 코드
			//아래서 생성한 session은 insert(), update(), delete(), selectOne, selectList, selectMap
			session = sqlMapper.openSession();
			result = session.insert("insertBbs", bVO);
			session.commit();
			logger.info("insertbbs : "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}	
		return result;
	}
	public List<Map<String,Object>> getContente(Map<String,Object> pmap){
		Map<String,Object> contente = null;
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper "+sqlMapper);
			session = sqlMapper.openSession();
			contente = session.selectOne("getContente", pmap);
			logger.info("contente : "+contente);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		
		return null;
	}
	
//	public int insert(BbsDTO bbs) {
//		SqlSession session = null;
//		int result = 0;
//		try {
//			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어와야 함.Reader<->Writer
//			//문서를 읽는데 필요한 클래스
//			Reader reader = Resources.getResourceAsReader(resource);
//			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
//			logger.info("sqlMapper "+sqlMapper);
//			//커넥션 연결 위한 사전 코드
//			//아래서 생성한 session은 insert(), update(), delete(), selectOne, selectList, selectMap
//			session = sqlMapper.openSession();
//			result = session.insert("insert", bbs);
//			session.commit();
//			logger.info("insertbbs : "+result);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			session.close();
//		}	
//		return result;
//	}
	
	public static void main(String[] args) {
		BbsDAO bDao = new BbsDAO();
//		int result =0;
		List<Map<String,Object>> list = bDao.getBbsList();
		System.out.println(list);
//		BbsVO bVO = new BbsVO();
//		bVO.setB_NUM(3);
//		bVO.setB_TITLE("스트링");
//		bVO.setB_HITS(0);
//		bVO.setB_DAY("11월14일");
//		bVO.setB_MEM("테스터");
//		bVO.setB_PW("123");
//		
//		System.out.println(bVO);
		
		
	}
}