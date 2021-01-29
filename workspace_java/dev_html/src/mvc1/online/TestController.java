package mvc1.online;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class TestController implements Action{
	Logger logger = Logger.getLogger(TestController.class);
	//개발자가 라이프 사이클을 직접 관리하기
	//객체 주입도 개발자가 직접 처리
	TestLogic tLogic = new TestLogic();//직접 인스턴스하는 경우
	//외부에서 필요한 순간에 객체를 주입해 준다.
	TestLogic tLogic2 = null;//외부에서 주입받는경우
	//tLogic2 = new TestLogic()하는것 대신 아래 코드를 사용함.
	//둘의 차이점은 무엇인가? - 
	//아래는 객체 주입을 외부에서 따로 해준다. - 라이프사이클을 관리 받는다.
	public void settLogic2(TestLogic tLogic2) {
		this.tLogic2 = tLogic2;
	}
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward af = new ActionForward();
		String viewName = null;
	    boolean isRedirect = false;
		String command = (String)request.getAttribute("command");//Object Type이기 때문애 캐스팅 연산자을 붙인다.
		 if("member/subjectList".equals(command)) {
			 	String msg = null;
		    	logger.info("로그인 목록 호출 성공");
		    	List<Map<String,Object>> subList = null;
		    	subList = tLogic.subjectList();//select한다
		    	request.setAttribute("subList", subList);//forward고려
		         viewName="/onLineTest/loginAccount.jsp";
//		         isRedirect = false;//falser이면 forward이다.
		         af.setRedirect(isRedirect);
		         af.setViewName(viewName); 
		    	
		    }
		return null;
	}

}
