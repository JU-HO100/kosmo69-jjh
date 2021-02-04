package np.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import np.com.util.HashMapBinder;
import np.mem.model.MemberDao;

//member/*.np
public class MemberController implements Action{
	Logger logger = Logger.getLogger(MemberController.class);

	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		
		ModelAndView mav = new ModelAndView(req, res);
		
		PrintWriter out = res.getWriter();
		String pageName = (String)req.getAttribute("pageName");//memberList
		MemberDao memDao = MemberDao.getInstance();
		
		Gson g = null;
	    Map<String,Object> pmap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pmap);
		
		String forJson = null;	//json 을 위한 String
		
		logger.info("MemC map>>>>>>"+pmap);
		
	      if(pageName.equals("memLogin")) {//로그인
	          List<Map<String, Object>> list = memDao.Login(pmap);
	          logger.info("MemberC - nick, id list or msg"+list);
	          for(Map<String,Object> map:list) {
	             if(map.get("MSG") == null) {
	                session.setAttribute("id", map.get("M_ID"));
	                session.setAttribute("nick", map.get("M_NICK"));
	                pageName="index"; // 로그인 됐을때 보낼 페이지
	             }
	             else {
	            	 logger.info("--------MSG가 존재할때----");
	     			mav.addObject("msg", map.get("MSG"));
	     			logger.info("msg>>>>"+map.get("MSG"));
	            	pageName="login";//로그인 안됐을때 보낼 페이지
	             }
	          }
	       }
		else if(pageName.equals("memRegi")) {//회원가입
			pageName = "index";
			pmap.put("field","REGISTER");//회원가입 필드 설정
			String msg =memDao.memRegister(pmap);
			logger.info("MemberC - memRegiMsg >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("idCheckRegi")) {//회원가입창 ID중복검사
			pageName="idCheckRegiSelect";
			pmap.put("field","ID_CHECK");
			pmap.put("m_pw","");
			pmap.put("m_zip","");
			pmap.put("m_hp","");
			pmap.put("m_name","");
			pmap.put("m_nick","");
			pmap.put("m_gender","");
			pmap.put("m_birth","");
			pmap.put("m_mail","");
			String msg =memDao.memRegister(pmap);
			logger.info("MemberC - idCheckMsg >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("nickCheckRegi")) {//회원가입창 닉네임 중복검사
			pageName="nickCheckRegiSelect";
			pmap.put("field","NICK_CHECK");
			pmap.put("m_id","");
			pmap.put("m_pw","");
			pmap.put("m_zip","");
			pmap.put("m_hp","");
			pmap.put("m_name","");
			pmap.put("m_gender","");
			pmap.put("m_birth","");
			pmap.put("m_mail","");
			String msg =memDao.memRegister(pmap);
			logger.info("MemberC - nickCheckRegiMsg >>>> "+msg);
			mav.addObject("msg", msg);
		}
		//new
		else if(pageName.equals("myPage")) {//마이페이지
			pageName="memberUpdateContentSelect";
			pmap.put("field","MY_PAGE");
			List<Map<String, Object>> list =memDao.myPage(pmap);
			logger.info("MemberC - myPage >>>> "+list);
			mav.addObject("list", list);
		}
		//new(미구현)
		else if(pageName.equals("checkCookClass")) {//나의 쿠킹클래스 확인하기(마이페이지부분)
			pageName="cookingClassCheckContent";
			pmap.put("field","CHECK_COOKCLASS");
			List<Map<String, Object>> list =memDao.myPage(pmap);
			logger.info("MemberC - checkCookClass >>>> "+list);
			g = new Gson();
			forJson = g.toJson(list);
		}
		else if(pageName.equals("memUpd")) {//회원정보수정
			pageName="updateResultSelect";
			String msg =memDao.updateMypage(pmap);
			logger.info("MemberC - memUpdMsg >>>> "+msg);
			if(msg.equals("닉네임이 이미 존재합니다")||msg.equals("패스워드가 틀렸습니다")) {//회원정보 수정실패
			}
			else {//회원 정보수정 성공
				session.removeAttribute("nick");
				session.setAttribute("nick",msg);
			}
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("withDrawal")) {//회원탈퇴
			pageName="goMemberOutSelect";
			String msg =memDao.withDraw(pmap);
			logger.info("MemberC - nickCheckRegiMsg >>>> "+msg);
			if(msg.equals("정상적으로 탈퇴되었습니다")) {
				session.invalidate();
			}
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("idSearch")) {//id찾기
			pageName="findIdResultSelect";
			pmap.put("field","ID_SEARCH");
			pmap.put("m_id","");
			logger.info("MemberC - idSearchpmap>>>> "+pmap);
			String msg =memDao.forgotID_PW(pmap);
			logger.info("MemberC - idSearchMsg >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("pwSearch")) {//pw찾기
			pageName="findPwResultSelect";
			pmap.put("field","PW_SEARCH");
			String msg =memDao.forgotID_PW(pmap);
			logger.info("MemberC -  pwSearchMsg >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("memReport")) {//회원 신고
			pageName="reportList";
			String msg =memDao.memReport(pmap);
			logger.info("MemberC -  memReport >>>> "+msg);
			mav.addObject("msg", msg);
		}
		//new
		else if(pageName.equals("submitResume")) {//셰프 양식서 제출
			pageName="goChefRegisterSelect";
			pmap.put("field","SUBMIT_RESUME");
			String msg =memDao.chefResume(pmap);
			logger.info("MemberC -  submitResume >>>> "+msg);
			mav.addObject("msg", msg);
		}
		//new
		else if(pageName.equals("popRecipeNum")) {//내 인기게시물 개수 (3개이상 or 3개미만)
			pageName="registerChefContentSelect";
			pmap.put("main_food","");
			pmap.put("writting","");
			pmap.put("field","POP_RECIPE_NUM");
			String msg =memDao.chefResume(pmap);
			logger.info("MemberC -  popRecipeNum >>>> "+msg);
			mav.addObject("msg", msg);
		}
		//new
		else if(pageName.equals("chefRanking")) {//셰프들의 랭킹
			pmap.put("field","CHEF_RANKING");
			pmap.put("m_id","");
			List<Map<String, Object>> list =memDao.chefDetail(pmap);
			logger.info("MemberC -  chefRanking >>>> "+list);
			g = new Gson();
			forJson = g.toJson(list);
		}
		//new
		else if(pageName.equals("chefBoard")) {//셰프 클릭했을때 해당 셰프의 게시글 보여줌
			pmap.put("field","CHECK_CHEF");
			List<Map<String, Object>> list =memDao.chefDetail(pmap);
			logger.info("MemberC -  chefBoard >>>> "+list);
			g = new Gson();
			forJson = g.toJson(list);
		}
	      else if(pageName.equals("checkChef")) {//셰프인지 아닌지 체크
	    	  pageName="goCookingClassRegisterSelect";
	          String msg =memDao.checkChef(pmap);
	          logger.info("MemberC -  popRecipeNum >>>> "+msg);
	          mav.addObject("msg", msg);
	       }
	      

		
	      session.setMaxInactiveInterval(30*60);//세션유지시간 찐 30분
	      logger.info(session.getLastAccessedTime());//세션 마지막 요청시간
	      
	      
		if(g == null) {
			mav.setViewName(pageName+".jsp");
		}else {
			res.setContentType("application/json; charset=utf-8");
			out.print(forJson);
		}
		
		return mav;
	}
	
	
}
