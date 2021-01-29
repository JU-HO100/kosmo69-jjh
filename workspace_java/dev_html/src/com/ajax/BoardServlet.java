package com.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpRetryException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import book.ch17.JsonServlet;

public class BoardServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BoardServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
		{
			logger.info("doGet 호출 성공");
			res.setContentType("text/html;charset=utf-8");
			String command = req.getParameter("command");
			//board/bsell.do?command=ajax&pageName=AJAX/common/typeA/test
			String pageName = req.getParameter("pageName");
//			String pageName = "AJAX/common/typeA/test";
		    PrintWriter out = res.getWriter();
		    out.print(60);
		    if("ajax".equals(command)) { //command가 ajax와 같으면 실행
		    	logger.info("ajax 밑");
		    	String url = "/WEB-INF/jsp/"+pageName+".jsp";
		    	RequestDispatcher view = req.getServletContext().getRequestDispatcher(url);//메소드.메소드
		    	view.forward(req, res);
		    }
		      
		}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws HttpRetryException,IOException
	{
		logger.info("doPost 호출 성공");
		
	}
		
}
