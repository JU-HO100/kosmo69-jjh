package candedata;

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

import com.util.MyBatisCommonFactory;


public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	MyBatisCommonFactory mcf = new MyBatisCommonFactory();
	SqlSessionFactory sqlMapper = null;
	String resource = "com/util/Configuration.xml";
	
	public void memberDao() {
		sqlMapper = mcf.getSqlSessionFactory();
	}
	
	public List<Map<String, Object>> getDeptList() {
		List<Map<String, Object>> memList = null;
		SqlSession session = null;
		try {
			// 물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader <-> Writer
			// Reader = 문서를 읽는대 필요한 클래스
//			reader = Resources.getResourceAsReader(resource);// io가 들어가 있기 때문에 반드시 예외처리해야 한다.
//			sqlMapper = new SqlSessionFactoryBuilder().build(reader);//
			session = sqlMapper.openSession(true);
			memList = session.selectList("");
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (memList == null) {
			memList = new ArrayList<>();
		}
		return memList;
	}

	public String Login(Map<String,Object> pmap){
		String mem_name = null;
		String msg = null;
		SqlSession session = null;
		try {
			// 물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader <-> Writer
			// Reader = 문서를 읽는대 필요한 클래스
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			session = sqlMapper.openSession(true);
			session.selectOne("proc_ajaxLogin", pmap);
			logger.info("이름:"+pmap.get("msg"));
			mem_name = pmap.get("msg").toString();
			
		} catch (Exception e) {
			logger.info("Exception:"+e.toString());
		} finally {
			session.close();
		}
		return mem_name;
	}
	
	public static void main(String[] args) {
		MemberDao mdao = new MemberDao();
		Map<String,Object> pmap = new HashMap<>();
//		pmap.put("mem_id", "test");
//		pmap.put("mem_pw", "123");
		System.out.println(mdao.Login(pmap));
	}
}
