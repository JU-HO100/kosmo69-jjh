package np.com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import np.mem.model.MemberDao;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberDao memDao;
	HttpSession session = null;

	Logger logger = LogManager.getLogger(MemberController.class);
	
	// 로그인
	@RequestMapping("memLogin.np")
	public String memLogin(HttpSession session, @RequestParam Map<String, Object> pmap) {
		String path = null;
		logger.info("memLogin 호출");
		List<Map<String, Object>> list = memDao.Login(pmap);
		logger.info("MemberC - nick, id list or msg" + list);
		for (Map<String, Object> map : list) {
			if (map.get("MSG") == null) { 
				session.setAttribute("id", map.get("M_ID"));
				session.setAttribute("nick", map.get("M_NICK"));
				session.setMaxInactiveInterval(300);// 세션유지시간 30분
				path = "forward:index.jsp";
			} else {
				path = "forward:/recipe/ok.jsp";//로그인 안됐을때 보낼 페이지
			}
		}
		logger.info(session.getAttribute("id"));
		logger.info(session.getAttribute("nick"));
		
		return path;
	}
	
	
	
	
	//카카오톡 관련 로그아웃 메소드
//    @RequestMapping("klogout.np")
//    public String kakao_logout(HttpSession session, HttpServletRequest request) {
//        
//        //세션에 담긴값 초기화
//        session.invalidate();
//        
//        
//        return "redirect:member/index.jsp";
//    }

	

	// 회원가입
	@RequestMapping("memRegi.np")
	public String memRegi(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("memRegi 호출");
		pmap.put("field", "REGISTER");
		String msg = memDao.memRegister(pmap);
		logger.info("MemberC - memRegiMsg >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

	// 회원가입창 내 id중복검사
	@RequestMapping("idCheckRegi.np")
	public String idCheckRegi(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("idCheckRegi 호출");
		pmap.put("field", "ID_CHECK");
		String msg = memDao.memRegister(pmap);
		logger.info("MemberC - idCheckMsg >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

	// 회원가입창 내 닉네임중복검사
	@RequestMapping("nickCheckRegi.np")
	public String nickCheckRegi(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("nickCheckRegi 호출");
		pmap.put("field", "NICK_CHECK");
		String msg = memDao.memRegister(pmap);
		logger.info("MemberC - nickCheckRegiMsg >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}
	//회원가입창 내 주소검색
//	@RequestMapping("/jusoPopup")
//	public String jusoPopup(@ModelAttribute("paramVO")) throws Exception {

//        return " forward:zipcode/jusoPopup";

//    }

	// 마이페이지 - 회원
	@RequestMapping("myPage.np")
	public String myPage(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("myPage 호출");
		pmap.put("field", "MY_PAGE");
		List<Map<String, Object>> list = memDao.myPage(pmap);
		logger.info("MemberC - myPage >>>> " + list);
		model.addAttribute("list", list);
		return "forward:member/IMSI.jsp";
	}

	// 마이페이지 - 쿠킹클래스
	@ResponseBody
	@RequestMapping("checkCookClass.np")
	public List<Map<String, Object>> checkCookClass(@RequestParam Map<String, Object> pmap) {
		logger.info("checkCookClass 호출");
		pmap.put("field", "CHECK_COOKCLASS");
		List<Map<String, Object>> list = memDao.myPage(pmap);
		logger.info("MemberC -  checkCookClass >>>> " + list);
		return list;
	}

	// 회원정보수정
	@RequestMapping("memUpd.np")
	public String memUpd(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("memUpd 호출");
		String msg = memDao.updateMypage(pmap);
		logger.info("MemberC - memUpdMsg >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

	// 회원 탈퇴
	@RequestMapping("withDrawal.np")
	public String withDrawal(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("withDrawal 호출");
		String msg = memDao.withDraw(pmap);
		logger.info("MemberC - nickCheckRegiMsg >>>> " + msg);
		model.addAttribute("msg", msg);
		return "redirect:member/IMSI.jsp";
	}

	// 아이디 찾기
	@RequestMapping("idSearch.np")
	public String idSearch(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("idSearch 호출");
		pmap.put("field", "ID_SEARCH");
		pmap.put("m_id", "");
		String msg = memDao.forgotID_PW(pmap);
		logger.info("MemberC - idSearchMsg >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

	// 비밀번호 찾기
	@RequestMapping("pwSearch.np")
	public String pwSearch(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("pwSearch 호출");
		pmap.put("field", "PW_SEARCH");
		String msg = memDao.forgotID_PW(pmap);
		logger.info("MemberC -  pwSearchMsg >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

	// 회원신고
	@RequestMapping("memReport.np")
	public String memReport(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("memReport 호출");
		String msg = memDao.memReport(pmap);
		logger.info("MemberC -  memReport >>>> " + msg);
		model.addAttribute("msg", msg);
		return "redirect:member/IMSI.jsp";
	}

	// 쉐프 양식서 제출
	@RequestMapping("submitResume.np")
	public String submitResume(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("submitResume 호출");
		pmap.put("field", "SUBMIT_RESUME");
		String msg = memDao.chefResume(pmap);
		logger.info("MemberC -  submitResume >>>> " + msg);
		model.addAttribute("msg", msg);
		return "redirect:member/IMSI.jsp";
	}

	// 내 인기게시물 개수 (3개이상 or 3개미만)
	@RequestMapping("popRecipeNum.np")
	public String popRecipeNum(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("popRecipeNum 호출");
		pmap.put("field", "POP_RECIPE_NUM");
		String msg = memDao.chefResume(pmap);
		logger.info("MemberC -  popRecipeNum >>>> " + msg);
		model.addAttribute("msg", msg);
		return "redirect:member/IMSI.jsp";
	}

	// 쉐프 랭킹
	@ResponseBody
	@RequestMapping("chefRanking.np")
	public List<Map<String, Object>> chefRanking(@RequestParam Map<String, Object> pmap) {
		logger.info("chefRanking 호출");
		pmap.put("field", "CHEF_RANKING");
		pmap.put("m_id", "");
		List<Map<String, Object>> list = memDao.chefDetail(pmap);
		logger.info("MemberC -  chefRanking >>>> " + list);
		return list;
	}

	// 셰프 클릭했을때 해당 셰프의 게시글 보여줌
	@ResponseBody
	@RequestMapping("chefBoard.np")
	public List<Map<String, Object>> chefBoard(@RequestParam Map<String, Object> pmap) {
		logger.info("chefBoard 호출");
		pmap.put("field", "CHECK_CHEF");
		List<Map<String, Object>> list = memDao.chefDetail(pmap);
		logger.info("MemberC -  chefBoard >>>> " + list);
		return list;
	}

}
