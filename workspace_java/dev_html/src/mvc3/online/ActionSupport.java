package mvc3.online;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ActionSupport extends HttpServlet {
		Logger logger = Logger.getLogger(ActionSupport.class);
	   
	   public void doService(HttpServletRequest req, HttpServletResponse res)
	   throws ServletException,IOException
	   {
	      logger.info("doService 호출 성공");
	      
	      //url ==> /dev_html/onLineTest/isOk.sp3
	      String requestURI = req.getRequestURI();
	      String contextPath = req.getContextPath();//==> /dev_html of /
	      String command = requestURI.substring(contextPath.length()+1);
	      int end = command.lastIndexOf('.');
	      command = command.substring(0,end);//onLineTest/isOk가 남는다.
	      Controller3 controller = null;
	      try {
	    	  controller = HandlerMapping3.getController(command);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	      
	   }
	   @Override
	   public void doGet(HttpServletRequest req, HttpServletResponse res)
	         throws ServletException,IOException
	   {
	      doService(req,res);
	   }
	   @Override
	   public void doPost(HttpServletRequest req, HttpServletResponse res)
	         throws ServletException,IOException
	   {
	      doService(req,res);
	   }

}
