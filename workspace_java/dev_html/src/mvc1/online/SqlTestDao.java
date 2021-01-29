package mvc1.online;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class SqlTestDao {
	Logger logger = Logger.getLogger(SqlTestDao.class);
	String resource = "com/util/Configuration.xml";
	SqlSessionFactory sqlMapper = null;
	
	public List<Map<String, Object>> subjectList() {
		logger.info("시험과목 목록 호출");
		List<Map<String, Object>> subList = null;
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);// io가 들어가 있기 때문에 반드시 예외처리해야 한다.
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");//
			logger.info("sqlMapper"+sqlMapper);
			session = sqlMapper.openSession();
			subList = session.selectList("subjectList");
		} catch (Exception e) {
			logger.info("Execption : "+e.toString());
		} finally {
			session.close();
		}
		if (subList == null) {
			subList = new ArrayList<>();
		}
		return subList;
	}///////////////////////end of subjectList
	
}
