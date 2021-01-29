package com.mvc2;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class SqlMemberDao {
	Logger logger  = Logger.getLogger(SqlMemberDao.class);
	SqlSessionTemplate sqlSessionTemplate = null;
	public String login(Map<String,Object> pmap) {//프로시저의 파라미터 맵은 파라미터이면서 리절트이다. *중요*
		String mem_name = null;
		Map<String,Object> rmap = new HashMap<>();
		try {
			logger.info("sqlSessionTemplate:"+sqlSessionTemplate);
			sqlSessionTemplate.selectOne("proc_ajaxLogin", pmap);//파라미터 이면서 result 이다. IN과 OUT을 동시에 받아준다.
			logger.info("이름:"+pmap.get("msg"));
			mem_name = pmap.get("msg").toString();
			rmap.put("smem_name",pmap.get("msg"));
			rmap.put("smem_id",pmap.get("rstatus"));
			
		}catch (Exception e) {
			logger.info("Exception:"+e.toString());
		}
		return mem_name;
	}
}
