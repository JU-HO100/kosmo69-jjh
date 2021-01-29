package np.com.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;

import np.mem.model.KakaoDao;
import np.mem.model.MemberDao;

@Controller
@RequestMapping("/*")
public class LoginController {
	Logger logger = Logger.getLogger(LoginController.class);
//	private final static String K_CLIENT_ID = "15f5287d753e527b86e1f231f7128313";
//	private final static String K_REDIRECT_URI = "http://192.168.0.38:8000/member/index.np";
	
	String index = null;
	String kakaoNick = null;
	
	
		@RequestMapping(value="/")
	    public String index() {
	        logger.info("Con index");
	        return "index";
	    }
	    
		@RequestMapping(value="kLogin.np")
		public String login(HttpSession session, HttpServletRequest req) throws Exception {
			
			String kNick = (String)req.getAttribute("kNick");
			logger.info("@@@ 이름 : "+kNick);
			System.out.println("@@@ 이름 : "+kNick);
	        if(kakaoNick==null) {
	        	kakaoNick = kNick;
	        	logger.info("kakaoNick = null");
	        	logger.info("이름 안넘어옴");
	        	index = "redirect:login.jsp";
	        } else {//
	        	logger.info("이름 넘어옴");
	        	index = "forward:index.jsp";
	        }
	        logger.info("kakaoNick"+kakaoNick);
	        session.setAttribute("kakaoNick", kakaoNick);
	        
	        if (kakaoNick != null) {
	        	logger.info("Con 세션 도착");
	        	index = "forward:index.jsp";
	        } 
	         else {
	        	logger.info("con 세션 도착 실패");
	        	index = "redirect:/member/loginFail.jsp";
	        }
	        return index;
	    }
		
}
