package web.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class DeptServlet extends HttpServlet {
	Logger logger = Logger.getLogger(DeptServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException 
	{
		logger.info("get방식 호출");
		DeptDao dDao = new DeptDao();
		List<Map<String,Object>> deptList = new ArrayList<>();
		deptList = dDao.getDeptList(null);
		req.setAttribute("getDeptList", deptList);
		RequestDispatcher view = 
				req.getRequestDispatcher("/ch17/imsi/a5.jsp");
		view.forward(req,res);
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		logger.info("doPost 호출");
		
	}
}
