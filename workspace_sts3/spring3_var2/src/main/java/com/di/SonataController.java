package com.di;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;
import org.w3c.dom.views.AbstractView;
// main 메소드가 없는 대신 URL 로 요청할 수 있다. - Web Service 제공할 수 있다.
// request 와 response 를 누릴 수 있다.
// 외부 서버 와 통신 또는 처리 결과 에 대한 자원 (Json,xml 포맷) 공유
//public class SonataController extends AbstractController {
public class SonataController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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
