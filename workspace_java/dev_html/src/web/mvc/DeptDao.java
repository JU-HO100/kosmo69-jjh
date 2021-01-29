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


public class DeptDao {
	Logger logger  = Logger.getLogger(EmpDao.class);
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	String resource = "com/util/Configuration.xml";//자우너정보를 담고 있는 xml문서
	SqlSessionFactory sqlMapper = null;	
	public List<Map<String,Object>> getDeptList(Map<String,Object> pmap){
		List<Map<String,Object>> deptList = null;

		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper "+sqlMapper);
			session = sqlMapper.openSession();
			logger.info("session "+session);
			deptList = session.selectList("getDeptList", pmap);
			logger.info("deptList : "+deptList);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}	
		return deptList;
	}
}
