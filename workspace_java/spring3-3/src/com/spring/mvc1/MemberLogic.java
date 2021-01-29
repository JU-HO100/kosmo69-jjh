package com.spring.mvc1;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	private SqlMemberDao sqlMemberDao = null;//선언시에는 null로 하였다가 필요한 시점에 객체 주입받는것.- 권장사항
	public void setSqlMemberDao(SqlMemberDao sqlMemberDao) {
		this.sqlMemberDao = sqlMemberDao;
	}
	
	public String login(Map<String,Object> pMap) {
		logger.info("login 호출 성공");
		String mem_name = null;
		mem_name = sqlMemberDao.login1(pMap);
		logger.info("오라클에서 꺼낸 이름 : "+mem_name);
		return mem_name;
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\spring\\mvc1\\MemberBean.xml");
		SqlMemberDao login = (SqlMemberDao)context.getBean("login1");
		System.out.println(login);
		
	}
	
}
