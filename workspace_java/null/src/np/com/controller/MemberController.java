package np.com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class MemberController implements Action{
	Logger logger = Logger.getLogger(MemberController.class);
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView(req, res);
		String name = req.getParameter("kakao");
		String pageName = (String)req.getAttribute("pageName");//memberList
		HttpSession session = req.getSession();
		
//		MemberDao memDao = MemberDao.getInstance();
//		AdminMemDao adMemDao = AdminMemDao.getInstance();
	    Map<String,Object> pmap = new HashMap<>();
//		HashMapBinder hmb = new HashMapBinder(req);
//		hmb.bind(pmap);
//		MemberVO memberVO = (MemberVO)pmap.get("memberVO");
//		ResumeVO resumeVO = (ResumeVO)pmap.get("resumeVO");
		
		if(pageName.equals("login")) {
//			session = req.setAttribute("name",pmap.get("name"));
			session = req.setAttribute("name",name);
		}
//		else if(pageName.equals("register")) {
//			memDao.memRegister(memberVO);
//		}
//		else if(pageName.equals("memberUpdate")) {
//			memDao.myPage(memberVO);
//		}
//		else if(pageName.equals("memberDelete")) {
//			memDao.withDraw(memberVO);
//		}
//		else if(pageName.equals("chefApply")) {					//셰프 신청
//			memDao.chefResume(resumeVO);
//		}
//		
//		// admin ----
//		else if(pageName.equals("memberList")) {
//			adMemDao.memList(memberVO);
//		}
		//member/memeberList.sp
		mav.setViewName(pageName+".jsp");
		
		return mav;
	}
}
