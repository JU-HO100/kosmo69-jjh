package com.mycompany.online;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	private MemberDao memberDao = null;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	List<Map<String, Object>> memList = null;
	public List<Map<String, Object>> memberList() {
		logger.info("MemberLogic 호출 성공");
		List<Map<String, Object>> memList = null;
		memList = memberDao.memberList();
		return memList;
	}

}
