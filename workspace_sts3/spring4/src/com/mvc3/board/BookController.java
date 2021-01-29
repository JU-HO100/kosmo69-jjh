package com.mvc3.board;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/*
 *  Controller 어노테이션을 사용하지 않은 경우에는 반드시 spring-servlet.xml문서안에
 *  url패턴에 대응되는 클래스 정보를 작성해 주어야 함.
 *  문제 
 *  27번 book까지 로그에 출력되었는데 28번 즉 BookLogic객체를 주입 받지 못하는 이유에 대해 생각해 보세요.
 */

public class BookController implements Controller{
	Logger logger = Logger.getLogger(BookController.class);
	public BookLogic bookLogic = null;
	public void setBookLogic(BookLogic bookLogic) {
		this.bookLogic = bookLogic;
	}
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		logger.info("book Controller 호출");
		bookLogic.bookList();//왜 나는 NullPointerException인가요? 
		return null;
	}
}
