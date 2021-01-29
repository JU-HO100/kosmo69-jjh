package web.mvc;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import book.ch17.JsonServlet;

public class ErpServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ErpServlet.class);
	
	
	
	public void doService(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException
		{ 
		//요청 URL: /erp/empCRUD.kos?work=empAction
		//요청 URL: /erp/empCRUD.kos?work=empUpdate
		//요청 URL: /erp/empCRUD.kos?work=empDelete
		//요청 URL: /erp/empCRUD.kos?work=empInsert
		//요청 URL: /erp/empCRUD.kos?work=empSelect
			String uri = req.getRequestURI(); 	
			String context = req.getContextPath();
			String command = uri.substring(context.length()+1);
			int end = command.lastIndexOf('.');
			command = command.substring(0,end);
			String works[] = null;
			works = command.split("/");
			
			String work = req.getParameter("work");
			logger.info(work);
			//사원등록 할거니?
			if("empAction".equals(work)) {
				logger.info("사원등록 요청 성공");
				List<Map<String,Object>> empInfo = new ArrayList<>();
				Map<String,Object> remp = new HashMap<>();
				remp.put("ename","이순신");
				remp.put("gender",1);
				empInfo.add(remp);
				remp = new HashMap<>();
				remp.put("ename","선덕여왕");
				remp.put("gender",0);
				empInfo.add(remp);
				remp = new HashMap<>();
				req.setAttribute("empInfo", empInfo);
				RequestDispatcher view = req.getRequestDispatcher("/ASYNC/a20201116_6.jsp");
				view.forward(req, res);
				//위의 RequestDispatcher에서 받아온 값을 유지하기 위해 forward를 썻고 요청과 응답이기 때문에 req와 res을 썻다
			} else if("empAction2".equals(work)) {
				logger.info("사원등록 요청 성공");
				List<Map<String,Object>> empInfo = new ArrayList<>();
				Map<String,Object> remp = new HashMap<>();
				remp.put("ename","이순신");
				remp.put("gender",1);
				empInfo.add(remp);
				remp = new HashMap<>();
				remp.put("ename","선덕여왕");
				remp.put("gender",0);
				empInfo.add(remp);
				remp = new HashMap<>();
				req.setAttribute("empInfo", empInfo);
				RequestDispatcher view = req.getRequestDispatcher("/ASYNC/jsonResult.jsp");
				view.forward(req, res);
				//위의 RequestDispatcher에서 받아온 값을 유지하기 위해 forward를 썻고 요청과 응답이기 때문에 req와 res을 썻다
			}
//			if("empAction".equals(work)) {
//				logger.info("사원등록 요청 성공");
//				List<Map<String,Object>> empInfo = new ArrayList<>();
//				Map<String,Object> remp = new HashMap<>();
//				remp.put("ename","이순신");
//				remp.put("gender",1);
//				empInfo.add(remp);
//				remp = new HashMap<>();
//				remp.put("ename","선덕여왕");
//				remp.put("gender",0);
//				empInfo.add(remp);
////				req.setAttribute("empInfo", empInfo);
//				res.sendRedirect(empInfo);
//			}
			else if("empInsert".equals(work)) {
				logger.info("사원등록 성공");
			}
			else if("empInsert".equals(work)) {
				logger.info("사원등록 성공");
			}
			//사원수정 할거니?
			else if("empUpdate".equals(work)) {
				logger.info("사원수정 성공");
			}
			//사원삭제 할거니?
			else if("empDelete".equals(work)) {
				logger.info("사원삭제 성공");
			}
			//사원찾기 할거니?w
			else if("empSelect".equals(work)) {
				logger.info("사원찾기 성공");
			}
	
	
	
			}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		logger.info("doGet 호출 성공");
		doService(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		logger.info("doPost 호출 성공");
		doService(req,res);
		
	}
}
