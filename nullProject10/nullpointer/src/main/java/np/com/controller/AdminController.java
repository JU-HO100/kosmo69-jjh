package np.com.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import np.admin.model.AdminDao;

@Controller

@RequestMapping("/admin/*")
public class AdminController {

	@Autowired
	public AdminDao adminDao;

	Logger logger = LogManager.getLogger(MemberController.class);

	// === 관리자 전용 검색기능 ===

	// 관리자 리스트 보기
	@ResponseBody
	@RequestMapping("rightList.np")
	public List<Map<String, Object>> rightList(@RequestParam Map<String, Object> pmap) {
		logger.info("rightList 호출");
		pmap.put("field", "ADMIN_RIGHT");
		List<Map<String, Object>> list = adminDao.adminSearch(pmap);
		logger.info("AdminC -  rightList >>>> " + list);
		return list;
	}

	// 게시판검색 관련 기능
	@ResponseBody
	@RequestMapping("boardList.np")
	public List<Map<String, Object>> boardList(@RequestParam Map<String, Object> pmap) {
		logger.info("boardList 호출");
		pmap.put("field", "ADMIN_BOARD");
		if(pmap.get("option_keyword1") ==null&& pmap.get("option_keyword2")==null &&pmap.get("keyword")==null) {//전체검색처리
			pmap.put("option_keyword1","");
			pmap.put("option_keyword2","");
			pmap.put("keyword", "");
		}
		if(pmap.get("option_keyword1") ==null&& pmap.get("option_keyword2")==null) {//범위검색안할때
			pmap.put("option_keyword1","");
			pmap.put("option_keyword2","");
		}else {//범위검색할때
			pmap.put("keyword", "");
		}
		List<Map<String, Object>> list = adminDao.adminSearch(pmap);
		logger.info("AdminC -  boardList >>>> " + list);
		return list;
	}

	// 회원 리스트
	@ResponseBody
	@RequestMapping("memList.np")
	public List<Map<String, Object>> memList(@RequestParam Map<String, Object> pmap) {
		logger.info("memList 호출");
		pmap.put("field", "ADMIN_MEMBER");
		if(pmap.get("option_keyword1") ==null&& pmap.get("option_keyword2")==null &&pmap.get("keyword")==null) {//전체검색처리
			pmap.put("option_keyword1","");
			pmap.put("option_keyword2","");
			pmap.put("keyword", "");
		}
		if(pmap.get("option_keyword1") ==null&& pmap.get("option_keyword2")==null) {//범위검색안할때
			pmap.put("option_keyword1","");
			pmap.put("option_keyword2","");
		}else {//범위검색할때
			pmap.put("keyword", "");
		}
		List<Map<String, Object>> list = adminDao.adminSearch(pmap);
		logger.info("AdminC -  memList >>>> "+list);
		return list;
	}

	// 쿠킹클래스검색 관련 기능
	@ResponseBody
	@RequestMapping("classList.np")
	public List<Map<String, Object>> classList(@RequestParam Map<String, Object> pmap) {
		logger.info("classList 호출");
		pmap.put("field", "ADMIN_CLASS");
		List<Map<String, Object>> list = adminDao.adminSearch(pmap);
		logger.info("list" + list);
		return list;
	}

	// === 총 관리자, 멤버관리자 전용 ===

	// (총관리자only) 권한 위임
	@RequestMapping("giveRight.np")
	public String giveRight(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("giveRight 호출");
		pmap.put("field", "GIVE_RIGHT");
		List<Map<String, Object>> list = adminDao.adminMemDao(pmap);
		String msg = null;
		for (Map<String, Object> rmap : list) {
			msg = (String) rmap.get("MSG");// String으로 받기
		}
		logger.info("AdminC -  giveRight >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/memList.jsp";
	}

	// (총관리자only) 권한 삭제
	@RequestMapping("delRight.np")
	public String delRight(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("delRight 호출");
		pmap.put("field", "DELETE");
		List<Map<String, Object>> list = adminDao.adminMemDao(pmap);
		String msg = null;
		for (Map<String, Object> rmap : list) {
			msg = (String) rmap.get("MSG");// String으로 받기
		}
		logger.info("AdminC -  delRight >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/memList.jsp";
	}

	// (멤버관리자) 블랙리스트 추가
	@RequestMapping("addBlack.np")
	public String addBlack(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("addBlack 호출");
		pmap.put("field", "PUT_BLACK");
		List<Map<String, Object>> list = adminDao.adminMemDao(pmap);
		String msg = null;
		for (Map<String, Object> rmap : list) {
			msg = (String) rmap.get("MSG");// String으로 받기
		}
		logger.info("AdminC -  addBlack >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/memList.jsp";
	}

	// (멤버관리자) 일시정지리스트 추가
	@RequestMapping("addPause.np")
	public String addPause(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("addBlack 호출");
		pmap.put("field", "PUT_PAUSE");
		List<Map<String, Object>> list = adminDao.adminMemDao(pmap);
		String msg = null;
		for (Map<String, Object> rmap : list) {
			msg = (String) rmap.get("MSG");// String으로 받기
		}
		logger.info("AdminC -  addPause >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/memList.jsp";
	}

	// (멤버관리자) 일시정지회원 풀어주기
	@RequestMapping("releasePause.np")
	public String releasePause(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("releasePause 호출");
		pmap.put("field", "RELEASE_PAUSE_MEM");
		List<Map<String, Object>> list = adminDao.adminMemDao(pmap);
		String msg = null;
		for (Map<String, Object> rmap : list) {
			msg = (String) rmap.get("MSG");// String으로 받기
		}
		logger.info("AdminC -  releasePause >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/memList.jsp";
	}

	// (멤버관리자) 셰프신청글 보기
	@ResponseBody
	@RequestMapping("readWritting.np")
	public List<Map<String, Object>> readWritting(@RequestParam Map<String, Object> pmap) {
		logger.info("readWritting 호출");
		pmap.put("field", "READ_WRITTING");
		List<Map<String, Object>> list = adminDao.adminMemDao(pmap);
		logger.info("AdminC -  readWritting >>>> " + list);
		return list;
	}

	// (멤버관리자) 셰프로 승격시켜주기
	@RequestMapping("commitChef.np")
	public String commitChef(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("commitChef 호출");
		pmap.put("field", "COMMIT_CHEF");
		List<Map<String, Object>> list = adminDao.adminMemDao(pmap);
		String msg = null;
		for (Map<String, Object> rmap : list) {
			msg = (String) rmap.get("MSG");// String으로 받기
		}
		logger.info("AdminC -  commitChef >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/memList.jsp";
	}

//				=== 게시판, 쿠킹클래스 관리자 전용 ===

	// (쿠킹클래스관리자) 쿠킹클래스 강제 제거
	@RequestMapping("delClass.np")
	public String delClass(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("delClass 호출");
		pmap.put("field", "DELETE_COOKCLASS");
		String list = adminDao.adminBCDao(pmap);
		logger.info("AdminC -  delClass >>>> " + list);
		model.addAttribute("msg", list);
		return "forward:member/memList.jsp";
	}

	// (쿠킹클래스관리자) 쿠킹클래스내 회원 제거
	@RequestMapping("kickPerClass.np")
	public String kickPerClass(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("kickPerClass 호출");
		pmap.put("field", "KICK_PERSON_CC");
		String list = adminDao.adminBCDao(pmap);
		logger.info("AdminC -  kickPerClass >>>> " + list);
		model.addAttribute("msg", list);
		return "forward:member/memList.jsp";
	}

	// (게시판관리자) 게시글 강제 삭제
	@RequestMapping("delBoard.np")
	public String delBoard(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("delBoard 호출");
		pmap.put("field", "DELETE_BOARD");
		String list = adminDao.adminBCDao(pmap);
		logger.info("AdminC -  delBoard >>>> " + list);
		model.addAttribute("msg", list);
		return "forward:member/memList.jsp";
	}

}
