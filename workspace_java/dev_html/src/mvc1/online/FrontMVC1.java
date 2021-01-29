package mvc1.online;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.omg.CORBA.Request;

import mvc1.online.ActionForward;

//서블릿 URL mapping  (*.test)
	public class FrontMVC1 extends HttpServlet {//서블릿을 상속받았기 때문에 서블릿이 되었다.
	Logger logger = Logger.getLogger(FrontMVC1.class);
	ActionForward af = null;
	MemberController memCtrl = new MemberController();
	TestController testCtrl = new TestController();
	/*
	 * doService는 표준서블릿에서 제공되는 메소드가 아니다.
	 * doGet과 doPost만이 표준서블릿에서 제공된다. 
	 * 그렇기 때문에 @Override라는 어노테이션(컴파일대상)은 쓸수 없다. - 문법체크
	 * 그렇다면 어디서 왔나? 밑의 doGet과 doPost 메소드에서 doServiec에게 보내줬다.
	 * 원본이 넘어 왔다.
	 * 
	 * */
	public void doService(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
			{
				logger.info("doService 호출");
				//
				String uri = req.getRequestURI();
				//서블릿으로 넘어올때 정보자체를 가져오는 것이다. - 따로 파라미터값이 필요없다. 
				//업무이름 과 업무내용이름을 가져왔다. 예)/member/memberList.test 	
				String context = req.getContextPath();
				//루트 정보를 가져온다. localhost:/이런건 다 contextpath에 루트정보로 담긴다.
				String command = uri.substring(context.length()+1);
				//루트 정보의 길이 +1 만큼 건너뛰어서 자른다. - 
				//서브스트링 안에 파라미터에 따라 길이가 나뉜다. 
				int end = command.lastIndexOf('.');//.까지의 길이를 측정해서 자른다
				command = command.substring(0,end);// 0번부터 .의 전까지 자른내용 member/memberList 을 command변수에 담는다
				logger.info("command: "+command);
				String upmu[] = null;
				upmu = command.split("/");
				//split 자체가 리턴타입이 배열이다. 그래서 알아서 잘린거 앞에서부터 순서대로 담긴다.
				logger.info("upmu"+upmu);
				//
				//MemberController에서 객체 주입을 받아온다. 그래야 null이 아닐테니까
				//viewName은 누가 어디서 결정하나?
				//어떻게 가져오지?
				if("member".equals(upmu[0])) {//	member / memberList     upmu[0] : member   upmu[1] : memberList
					logger.info("member MVC1");
					req.setAttribute("command", upmu[1]);
					//MemberController에 값을 넘길 때 request를 사용한다
					//왜냐하면 원본이 넘어가니까.
					af = memCtrl.execute(req, res);
				}////////////////////////// end of 회원관리
				else if("OnLineTest".equals(upmu[0])) {//login은어디?
			        req.setAttribute("command", upmu[1]);
			        logger.info("test 호출 성공");
			        //MemberController에 값을 넘길 때 request사용한다.
			        //왜냐하면 원본이 넘어가니까
			        af = memCtrl.execute(req, res);
			     }///////////////end of 회원관리
				////////////////////////////////// [[ 응답 페이지 처리 관련 ]] /////////////////////////////////////////
				try {
					if(af != null) {
						if(af.isRedirect()) {
							//sendRedirect 파라미터 자리에 null이 오더라도 익셉션이 발생하지 않는다.
							//res.sendRedirect(null);이 코드에 대해서 문제발생없음.
							res.sendRedirect(af.getViewName());
//							res.sendRedirect(null);
						}
						else {
							RequestDispatcher view = req.getRequestDispatcher(af.getViewName());
							view.forward(req, res);
							
						}
					}////////////////////////// end of 페이지 이동처리
				} catch (Exception e) {
					e.printStackTrace();
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
	//사용자 정의 메소드
	public void methodA(HttpServletRequest req, HttpServletResponse res)
		throws ServletException,IOException
		{
		//메소드 앞에는 소유주가 온다.
		//그런데 지역변수이다. 왜냐하면 파라미터 자리에 선언되어 있으니까
		//지금 현제 상태로 쓴다면 NullPointExection을 만난다.
		//초기화가 되어 있지 않다.
		//HttpServlet안에 있는 메소드 doGet과 doPost에게 내장되어 있지만
		//그 외의 메소드의 경우 문법적으로 오류는 없지만
		//실행 했을 때 찾지를 못한다? 실행을 하지 못한다?
//		res.sendRedirect("/onlineTest/index2.jsp");
			doService(req,res);
		}
}
