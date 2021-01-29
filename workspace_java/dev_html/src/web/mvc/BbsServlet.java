package web.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns = "/web/mvc/Bbs")
public class BbsServlet extends HttpServlet {
	Logger logger = Logger.getLogger(BbsServlet.class);
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
		logger.info("get방식 호출");
		BbsDAO bdao = new BbsDAO();
		Map<String,Object> pmap = new HashMap<>();
		pmap = (Map<String, Object>) bdao.getContente(pmap);
		req.setAttribute("getContente", pmap);
		RequestDispatcher view = 
				req.getRequestDispatcher("/EasyUI/board/contente.jsp");
		view.forward(req,res);
		}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException
		{
			logger.info("doPost방식 호출");
		
		}
	
}
