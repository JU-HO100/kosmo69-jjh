package com.di;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;
//main메소드가 없는 대신 url로 요청할 수 있다. -Web Service제공할 수 있다. 
//request와 response를 누릴 수 있다.
//외부 서버와 통신 또는 처리 결과에 대한 자원(json, xml포맷) 공유
//public class SonataController extends AbstractController {
public class SonataController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
