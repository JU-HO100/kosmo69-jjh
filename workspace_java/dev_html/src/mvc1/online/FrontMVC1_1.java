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

public class FrontMVC1_1 {//서블릿을 상속받지 않아서 서블릿이 아니다
//	public class FrontMVC1 extends HttpServlet {//서블릿을 상속받았기 때문에 서블릿이 되었다.
	Logger logger = Logger.getLogger(FrontMVC1.class);
	ActionForward af = null;
	MemberController memCtrl = new MemberController();
	/*
	 * doService는 표준서블릿에서 제공되는 메소드가 아니다.
	 * doGet과 doPost만이 표준서블릿에서 제공된다. 
	 * 그렇기 때문에 @Override라는 어노테이션(컴파일대상)은 쓸수 없다. - 문법체크
	 * 그렇다면 어디서 왔나? 밑의 doGet과 doPost 메소드에서 doServiec에게 보내줬다.
	 * 원본이 넘어 왔다.
	 * 
	 * */
	//상속이 아닌경우 @Override는 생각하지 말자. 해당사항이 없다. 어림 없다.
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
				int end = command.lastIndexOf('.');
				command = command.substring(0,end);// member/memberList
				String upmu[] = null;
				upmu = command.split("/");
				//split 자체가 리턴타입이 배열이다. 그래서 알아서 잘린거 앞에서부터 순서대로 담긴다.
				logger.info(upmu);
				//
				//MemberController에서 객체 주입을 받아온다. 그래야 null이 아닐테니까
				//viewName은 누가 어디서 결정하나?
				//어떻게 가져오지?
				if("member".equals(upmu[0])) {
					req.setAttribute("command", command);
					//MemberController에 값을 넘길 때 request를 사용한다
					//왜냐하면 원본이 넘어가니까.
					af = memCtrl.execute(req, res);
				}////////////////////////// end of 회원관리
				////////////////////////////////// [[ 응답 페이지 처리 관련 ]] /////////////////////////////////////////
				if(af != null) {
					if(af.isRedirect()) {
						res.sendRedirect(af.getViewName());
						
					}
					else {
						RequestDispatcher view = req.getRequestDispatcher(af.getViewName());
						view.forward(req, res);
						
					}
				}////////////////////////// end of 페이지 이동처리
			}
	
//	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException
			{
				logger.info("doGet 호출 성공");
				doService(req,res);
			}
	//사용자가 정의한 메소드이다. - 서블릿을 상속받지 않았기 때문이다. - 무늬만 같다.
//	@Override
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
		res.sendRedirect("a.jsp");
		
		}
	public static void main(String[] args) {
		FrontMVC1 fm = new FrontMVC1();//순제어
		fm.methodA(null, null);//null을 넘겨받는 것이다.
		
	}
}
