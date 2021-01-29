package book.ch17;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class JsonServlet extends HttpServlet {
	Logger logger = Logger.getLogger(JsonServlet.class);
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException
	{
		logger.info("doGet 호출 성공");
		res.setContentType("application/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("[");
		out.print("{empno:7566, sal:3500, comm:500}");
		out.print("{empno:7688, sal:3000, comm:300}");
		out.print("{empno:7733, sal:2500, comm:200}");
		out.print("]");
	}
	//doPost는 단위테스트가 불가능하다.
	//왜냐하면 url에서 직접 호출한느 것은 모두 get방식이니까...
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
	{
		logger.info("doPost 호출 성공");
		res.setContentType("application/json;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("[");
		out.print("{empno:7566, sal:3500, comm:500}");
		out.print("{empno:7688, sal:3000, comm:300}");
		out.print("{empno:7733, sal:2500, comm:200}");
		out.print("]");
		
	}
}
