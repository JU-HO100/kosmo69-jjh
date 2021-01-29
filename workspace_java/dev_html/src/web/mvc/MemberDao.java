package web.mvc;

import java.io.Reader;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;


public class MemberDao {
	Logger logger = Logger.getLogger(EmpDao.class);
	//반복되는 코드는 개선해 본다.
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	String resource = "com/util/Configuration.xml";
	SqlSessionFactory sqlMapper = null;
	public List<Map<String,Object>> getMemberList(Map<String,Object>pmap){
		List<Map<String,Object>> memList = null;
		SqlSession session = null;
		try {
			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어와야 함
			//문서를 읽는데 필요한 클래스
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper"+sqlMapper);
			//커넥션 연결 위한 사전 코드
			//아래에서 생성한 session은 insert(), delete(), selectOne(), selectList, selectMap
			session = sqlMapper.openSession();
			memList = session.selectList("getMemberList",pmap);
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return memList;
	}
	public List<Map<String,Object>> getMemberList2(){
		List<Map<String,Object>> memList = null;
		SqlSession session = null;
		try {
			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어와야 함
			//문서를 읽는데 필요한 클래스
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper"+sqlMapper);
			//커넥션 연결 위한 사전 코드
			//아래에서 생성한 session은 insert(), delete(), selectOne(), selectList, selectMap
			session = sqlMapper.openSession();
			memList = session.selectList("getMemberList2");
			session.close();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return memList;
	}
}
