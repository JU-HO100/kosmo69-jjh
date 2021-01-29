package oracle.mybatis;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sun.media.jfxmedia.logging.Logger;

public class EmpDAO {
		//서버의 물리적인 정보를 받아오기
		//XML문서가 물리적으로 어디에 있는지 알아야 한다.
		String resource = "oracle/mybatis/MapperConfig.xml";
		Reader reader = null;
		//mybatis에서 지원하는 클래스로 
		SqlSessionFactory sqlMapper = null;
		//쿼리문의 아이디와 메소드 이름은 일치시켜야한다. - 통일을 해준다.
		public List<Map<String,Object>> getJobSumList(){
			List<Map<String,Object>> jobList = null;
			SqlSession session = null;
			try {
				//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader <-> Writer
				//Reader = 문서를 읽는대 필요한 클래스
				reader = Resources.getResourceAsReader(resource);//io가 들어가 있기 때문에 반드시 예외처리해야 한다.
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);//
				session = sqlMapper.openSession();
				
				jobList = session.selectList("getJobSumList");
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			if(jobList == null) {
				jobList = new ArrayList<>();
			}
			return jobList;
			
		}
		public static void main(String[] args) {
			EmpDAO eDao =new EmpDAO();
			List<Map<String,Object>> jobList = eDao.getJobSumList();
			System.out.println("jobLst.size() ===> "+jobList.size());
		}
	}

