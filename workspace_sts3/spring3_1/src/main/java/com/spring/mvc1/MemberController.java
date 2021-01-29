package com.spring.mvc1;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController {
	Logger logger = Logger.getLogger(MemberController.class);
	//전체 인스턴스화를 다하면 순제어가 되는 거니까 일단 널로 해두었다가
	//아래서 추가한 setter메소드를 통하여 필요한 순간에 객체를 주입받는다.
	private MemberLogic memberLogic = null;
	public void setMemberLogic(MemberLogic memberLogic) {
		this.memberLogic = memberLogic;
	}
	public ModelAndView login(HttpServletRequest req, HttpServletResponse rest) {
		logger.info("login 호출 성공");
		Map<String,Object> pMap = new HashMap<>();
		pMap.put("mem_id", req.getParameter("mem_id"));
		pMap.put("mem_pw", req.getParameter("mem_pw"));
		memberLogic.login(pMap);
		ModelAndView mav = new ModelAndView();
		return mav;
	}
}
