package com.mycompany.online;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> memberList() {
		logger.info("memberList호출 성공");
		List<Map<String,Object>> memberList = null;
		memberList = sqlSessionTemplate.selectList("memberList");
		return memberList;
	}
	
}
