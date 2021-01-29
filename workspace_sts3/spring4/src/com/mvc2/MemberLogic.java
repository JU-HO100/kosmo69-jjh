package com.mvc2;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	@Autowired
	private SqlMemberDao smDao = null;//선언시에는 null로 하였다가 필요한 시점에서 객체주입 받는다.-권장사항
	public String login(Map<String,Object> pmap) {
		logger.info("login 호출 성공");
		String mem_name = null;
		Map<String,Object> rmap = null;
		smDao = new SqlMemberDao();
		
		mem_name =  smDao.login(rmap);
		logger.info("오라클에서 꺼낸 이름:"+mem_name);
		return mem_name;
	}
}
