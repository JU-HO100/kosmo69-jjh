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
	
	@Autowired
    private KakaoDao kakao;
	
	@Autowired
	private MemberDao memDao;
	
	
		@RequestMapping(value="/")
	    public String index() {
	        logger.info("Con index");
	        return "index";
	    }
	    
		@RequestMapping(value="kLogin.np")
		public String login(HttpSession session, HttpServletRequest req) throws Exception {
			
			String kNick = (String)req.getAttribute("kakaoNick");
			logger.info("@@@ 이름 : "+kNick);
			System.out.println("@@@ 이름 : "+kNick);
	        if(kakaoNick!=null) {
	        	kakaoNick = kNick;
	        } else {//
	        	logger.info("kakaoNick = null");
	        	logger.info("이름 안넘어옴");
	        	index = "redirect:login.jsp";
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
		
		@RequestMapping(value="kakaoLogin.np")
//		public String kLogin(HttpSession session,  @RequestParam("code") String code, HttpServletRequest req) throws Exception {
		public String kLogin(@RequestParam(value="pbNum", required=false) String pbNum, HttpServletResponse response) 
			throws Exception {
			String access_Token = kakao.getAccessToken(pbNum);
			logger.info("Con Token"+pbNum);
			
			return index;
		}
		
		
		@RequestMapping(value = "/memberloginform.do", method = RequestMethod.GET) 
		public ModelAndView memberLoginForm(HttpSession session) 
		{ 
			ModelAndView mav = new ModelAndView(); 
			/* 네아로 인증 URL을 생성하기 위하여 getAuthorizationUrl을 호출 */ 
//			String naverAuthUrl = naverLoginDTO.getAuthorizationUrl(session); 
			String kakaoUrl = KakaoController.getAuthorizationUrl(session); 
			/* 생성한 인증 URL을 View로 전달 */ 
			mav.setViewName("memberloginform"); 
			
			// 네이버 로그인 
//			mav.addObject("naver_url", naverAuthUrl); 
			
			// 카카오 로그인 
			mav.addObject("kakao_url", kakaoUrl);
			
			return mav; 
			
		}// end memberLoginForm()
		
		@RequestMapping(value = "/kakaologin.do", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView kakaoLogin(@RequestParam("code") String code, HttpServletRequest request
				, HttpServletResponse response, HttpSession session) throws Exception 
				{ 
				ModelAndView mav = new ModelAndView(); 
				// 결과값을 node에 담아줌 
				JsonNode node = KakaoController.getAccessToken(code); 
				// accessToken에 사용자의 로그인한 모든 정보가 들어있음 
				JsonNode accessToken = node.get("access_token");
				// 사용자의 정보 	
				JsonNode userInfo = KakaoController.getKakaoUserInfo(accessToken);
				//사용자의 정보를 담을 변수
				String kemail = null; 
				String kname = null;
				String kgender = null; 
				String kbirthday = null; 
				String kage = null; 
				String kimage = null; 
				
				// 유저정보 카카오에서 가져오기 Get properties 
				JsonNode properties = userInfo.path("properties"); 
				JsonNode kakao_account = userInfo.path("kakao_account"); 
				kemail = kakao_account.path("email").asText(); 
				kname = properties.path("nickname").asText(); 
				kimage = properties.path("profile_image").asText();
				kgender = kakao_account.path("gender").asText(); 
				kbirthday = kakao_account.path("birthday").asText(); 
				kage = kakao_account.path("age_range")	.asText(); 
				session.setAttribute("kemail", kemail); 	
				session.setAttribute("kname", kname); 
				session.setAttribute("kimage", kimage); 
				session.setAttribute("kgender", kgender); 
				session.setAttribute("kbirthday", kbirthday); 
				session.setAttribute("kage", kage); 
				mav.setViewName("main"); 
				return mav; 
		}// end kakaoLogin()
}
