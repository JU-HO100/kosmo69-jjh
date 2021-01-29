package web.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class TestController extends HttpServlet {//HttpServlet을 상속받았기 때문에 서블릿이다.
	Logger logger = Logger.getLogger(TestController.class);
	private static final long serialVersionUID = 1L;
	/*****************************************************************************************
	 * @param1 : req - 톰캣 서버가 제공해주는 객체- servlet-api.jar
	 * @param2 : res - 톰캣 서버가 제공해주는 객체- servlet-api.jar
	 * 메소드 이름 뒤에 throws로 예외를 던지면 예외가 발생되었을 때 나를 호출한 곳에서 처리해 주세요. - 간접처리
	 * 서블릿은 톰캣 서버가 싱글톤 패턴으로 직접 관리 하니까 내가 예외처리 불가하다.
	 * doGet은 일종의 콜백메소드이다.
	 * 질문:나는 자바코드인데 브라우저에서 실행시키고 싶다면 어떻게 해야하나?
	 * 힌트:나는 메인메소드가 없다.
	 * 	   나는 URL도 없다.
	 * 	   나는 doGet메소드만 있다.(현재)
	 *****************************************************************************************/
	public void doGet(HttpServletRequest req, HttpServletResponse res)//mime 타입이 html일 경우 doGet
			throws ServletException, IOException
	{
		logger.info("doGet 호출 성공");
		//응답객체를 통해서 마임타입을 지정할 수 있고 한글 인코딩도 추가할 수 있음.
		res.setContentType("text/html;charset=utf-8");//브라우저는 mime타입에 따라 결정이 달라진다. -모르면 무조건 다운로드 합니다. 
		PrintWriter out = res.getWriter();
		out.print("<b>서블릿으로 그린 웹페이지.</b>");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)//mime 타입이 json인 경우 doPost
			throws ServletException, IOException
	{
		logger.info("doPost 호출 성공");
		//응답객체를 통해서 마임타입을 지정할 수 있고 한글 인코딩도 추가할 수 있음.
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<b>Post전송으로 요청된 웹페이지.</b>");
	}
	
}
