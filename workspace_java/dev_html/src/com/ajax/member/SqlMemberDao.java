package com.ajax.member;

import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
//클래스 조립해 보기
//myBatis에서 프로시저 사용 단위테스트 코딩 전개해 보기

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import web.mvc.EmpDao;


public class SqlMemberDao {
	Logger logger  = Logger.getLogger(SqlMemberDao.class);
	String resource = "com/util/Configuration.xml";
	SqlSessionFactory sqlMapper = null;
	public String login(Map<String,Object> pmap) {//프로시저의 파라미터 맵은 파라미터이면서 리절트이다. *중요*
		String mem_name = null;
		SqlSession session = null;
		Map<String,Object> rmap = new HashMap<>();
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development2");
			logger.info("sqlMapper:"+sqlMapper);
			session = sqlMapper.openSession();
			logger.info("session:"+session);
			session.selectOne("proc_ajaxLogin", pmap);//파라미터 이면서 result 이다. IN과 OUT을 동시에 받아준다.
			//
			logger.info("이름:"+pmap.get("msg"));
			rmap.put("smem_id",pmap.get("rstatus"));
			rmap.put("smem_name",pmap.get("msg"));
			mem_name = pmap.get("msg").toString();
			
		}catch (Exception e) {
			logger.info("Exception:"+e.toString());
		}finally {
			session.close();
		}
		return mem_name;
	}
	public static void main(String[] args) {
		SqlMemberDao mdao = new SqlMemberDao();
		Map<String,Object> pmap = new HashMap<>();
		pmap.put("mem_id", "test1");
		pmap.put("mem_pw", "123");
		mdao.login(pmap);
		
	}
}
