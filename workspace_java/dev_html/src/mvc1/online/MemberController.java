package mvc1.online;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ajax.member.MemberLogic;

public class MemberController implements Action {
	Logger logger = Logger.getLogger(MemberController.class);
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		logger.info("execute 호출");
		ActionForward af = new ActionForward();
		String viewName = null;
	    boolean isRedirect = false;
	    MemberLogic mLogic = new MemberLogic();
	    String command = (String)req.getAttribute("command");//memberList
	    logger.info("command>>>"+command);
	    //여전히 url과 메소드 이름을 1:1로 매칭하는 것은 해결이 안되고 있다.
	    if("login".equals(command)) {
	    	logger.info("로그인 --- 여기는 MVC1 memController");
	    	logger.info("mem_id = "+req.getParameter("mem_id"));
	    	logger.info("mem_pw = "+req.getParameter("mem_pw"));
	    	
	    	Map<String,Object> pmap = new HashMap<>();
	    	String msg = null;
	    	pmap.put("mem_id", req.getParameter("mem_id"));
	    	pmap.put("mem_pw", req.getParameter("mem_pw"));
//	    	pmap.put("mem_name", req.getParameter("mem_name"));
	    	msg = mLogic.login(pmap);//Logic에서는 mem_name을 return해 줬다.
	    	
	    	logger.info("msg 검사지점"+msg);
	         HttpSession session = req.getSession();
	         session.setAttribute("smsg", msg);
	         viewName="/onLineTest/loginAccount.jsp";
	         //세션에 값을 저장하므로 요청이 유지 되지 않아도 된다.
	         isRedirect = false;
	         af.setRedirect(isRedirect);
	         af.setViewName(viewName); 
	    	
	    }
	    else {
		    viewName = "/onLineTest/index.jsp";
		    isRedirect = true;
		    af.setRedirect(isRedirect);
		    af.setViewName(viewName);
	    }
	    return af;
	}

}
