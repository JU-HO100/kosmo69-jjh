package com.mycompany.online;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController {
	Logger logger = Logger.getLogger(MemberController.class);
	private MemberLogic memberLogic = null;
	public void setMemberLogic(MemberLogic memberLogic) {
		this.memberLogic = memberLogic;
	}

	public void memberInsert(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		logger.info("memberInsert 호출 성공");
		res.sendRedirect("memberList.jsp");
	}
	
	public ModelAndView memberList(HttpServletRequest req, HttpServletResponse res) {
		logger.info("memberList 호출 성공");
		List<Map<String, Object>> memList = null;
		// MemberController 가 처리한 결과를 DispatherServlet 에게 전달할 때 사용하는클래스이다.
		memList = memberLogic.memberList();
		// MemberController 가 처리한 결과를 DispatcherServlet에게 전달할 때 사용하는 클래스이다.
		ModelAndView mav = new ModelAndView(); // request scope, forward
		mav.setViewName("a.jsp");
		return mav;
	}
}
