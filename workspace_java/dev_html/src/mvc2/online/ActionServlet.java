package mvc2.online;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//init():시스템:서블릿 컨테이너-톰캣 0 service():개발자가 - destroy():시스템
public class ActionServlet extends HttpServlet {
	Logger logger = Logger.getLogger(ActionServlet.class);
	
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		//해당 서블릿의 초기화를 담당한다. -예를 들면 오라클 서버의 물리적인 정보들 Connection 물리기 위한 사전 정보를 초기화하는 작업
		logger.info("init 호출");
	}
	
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
			{
				logger.info("doService 호출");
				String uri = req.getRequestURI();//url을 가져옴 - member/memberList
				String context = req.getContextPath();//가져온 url의 루트를 담는다.
				String command = uri.substring(context.length()+1);//루트의 문자열+1의 길이만큼 자른다. /dev_html/을 잘라낸다..
				int end = command.lastIndexOf(".");//.까지의 길이를 재서 end에 담기
				command = command.substring(0,end);//0번부터 end까지 담은 길이만큼 잘라서 command에 담기
				logger.info("command : "+command);
				Controller controller = null;
				try {
					logger.info("doService try 진입");
					controller = ControllerMapper.getController(command);
					logger.info("controller = "+controller);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//instanceof는 뒤에 있는 애가 앞에 있는 애안테 속해 있냐? - controller에 MemberController가 인스턴스화 되어있니?
				if(controller instanceof MemberController) {
					logger.info("회원 컨트롤 계층 호출");
					ModelAndView mav = controller.execute(req, res);
					logger.info("mav : "+mav+": viewName : "+mav.viewName);
					RequestDispatcher view = req.getRequestDispatcher(mav.viewName);
					view.forward(req, res);
				}
				//instanceof는 뒤에 있는 애가 앞에 있는 애안테 속해 있냐? - controller에 TestController가 인스턴스화 되어있니?
				else if(controller instanceof TestController) {
					logger.info("시험 컨트롤 계층 호출");
					ModelAndView mav = controller.execute(req, res);
					logger.info("mav : "+mav+": viewName : "+mav.viewName);
					RequestDispatcher view = req.getRequestDispatcher(mav.viewName);
					view.forward(req, res);
				}
				else {
					logger.info("호출 실패");
					return;
				}
				
			}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
			{
				logger.info("doGet 호출 성공");
				doService(req,res);
			}
	//사용자가 정의한 메소드이다. - 서블릿을 상속받지 않았기 때문이다. - 무늬만 같다.
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
			{
				logger.info("doPost 호출 성공");
				doService(req,res);
			}
	
	
}
