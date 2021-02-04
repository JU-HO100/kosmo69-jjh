package np.com.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



//*.np
//servlet
//init() - service() - destroy() 
public class FrontController extends HttpServlet {
	Logger logger = Logger.getLogger(FrontController.class);
	
	Map<String, Object> contList = null;
	
	public void init(ServletConfig sc) throws ServletException{
		contList = new HashMap<>();
		// *(여기에 해당)  / XXX.np
		contList.put("member",new MemberController());
		contList.put("recipe",new RecipeController());
		contList.put("cookclass",new CookClassController());
		contList.put("admin",new AdminController());
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException {
		res.setContentType("text/html;charset=utf-8");
	    res.setCharacterEncoding("utf-8"); 
		Action action = null;
		ModelAndView mav = null;
		
	    String uri = req.getRequestURI();								// ==> /test/isTest.test
	    String context = req.getContextPath();							//==> 루트 정보를 가져옴. server.xml에서    = ""  빈 문자열이 담김
	    String command = uri.substring(context.length()+1);				// 루트가 "/" 이기에 0+1 --> test/isTest.test
	    int end = command.lastIndexOf('.');								// command = ".test" 의 바로 전 위치의 번호
	    command = command.substring(0,end);								// test/isTest
		
	    String split[] = null;  										//     업무이름/ 페이지이름     
	    split = command.split("/"); 									//	 업무별로 나눠야 하기에 분류함	split[0] = test 	||	 split[1] = isTest
	    
	    String upmu = split[0];
	    String pageName = split[1];
	    
	    for(String match :contList.keySet()) {							// list의 key  갯수만큼 반복문 돌리기
	    	if(match.equals(upmu)) {									// list 에 있는 key 이름과 URI 로 들어온 업무명이 같은지??
		    	req.setAttribute("pageName", pageName);
		    	action = (Action)contList.get(upmu);
		    	mav = action.execute(req, res);
	    	}
		}


	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException {
		doProcess(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException,IOException {
		doProcess(req, res);
	}
}
