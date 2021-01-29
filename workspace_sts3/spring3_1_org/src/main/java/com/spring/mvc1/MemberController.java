package com.spring.mvc1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController {
	Logger logger = Logger.getLogger(MemberController.class);
	
	public ModelAndView login() {
		logger.info("login 호출");
		ModelAndView mav = new ModelAndView();
		
		
		return mav;
	}//////////////////////////// end of login
}
