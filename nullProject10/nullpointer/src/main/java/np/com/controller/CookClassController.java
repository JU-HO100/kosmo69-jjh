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

import np.mem.model.CookClassDao;

@Controller

@RequestMapping("/cookclass/*")
public class CookClassController {

	@Autowired
	public CookClassDao cookClassDao;

	Logger logger = LogManager.getLogger(MemberController.class);

	// 쿠킹 클래스 생성 (셰프전용)
	@RequestMapping("createClass.np")
	public String createClass(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("createClass 호출");
		pmap.put("field", "OPEN_COOKCLASS");
		String msg = cookClassDao.cookingClass(pmap);
		logger.info("CookClassC - createClass" + msg);
		model.addAttribute("msg", msg);
		return "forward:cookingClassList.jsp";
	}
	
	// 쿠킹 클래스 수정(셰프전용)
			@RequestMapping("updClass.np")
			public String updClass(Model model, @RequestParam Map<String, Object> pmap) {
				logger.info("updClass 호출");
				pmap.put("field", "UPD_COOKCLASS");
				String msg = cookClassDao.cookingClass(pmap);
				logger.info("CookClassC - updClass" + msg);
				model.addAttribute("msg", msg);
				return "forward:goUpdateList.jsp";
			}

	// 쿠킹 클래스 참가
	@RequestMapping("joinClass.np")
	public String joinClass(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("joinClass 호출");
		pmap.put("field", "ATTEND_COOKCLASS");
		pmap.put("c_cook", "");
		pmap.put("c_ingredients", "");
		pmap.put("c_zip", "");
		pmap.put("c_zipdetail", "");
		pmap.put("c_member", "");
		pmap.put("c_date", "");
		String msg = cookClassDao.cookingClass(pmap);
		logger.info("CookClassC - joinClass" + msg);
		model.addAttribute("msg", msg);
		return "forward:goCookingClassApplicationSelect.jsp";
	}
	
	// 쿠킹클래스 삭제 or 취소
		@RequestMapping("cancelClass.np")
		public String cancelClass(Model model, @RequestParam Map<String, Object> pmap) {
			logger.info("cancelClass 호출");
			String msg = cookClassDao.cancelClass(pmap);
			logger.info("CookClassC - cancelClass" + msg);
			model.addAttribute("msg", msg);
			return "forward:goCancelList.jsp";
		}
		
		// 쿠킹클래스 전부 보기
		@ResponseBody
		@RequestMapping("showClass.np")
		public List<Map<String, Object>> showClass(@RequestParam Map<String, Object> pmap) {
			logger.info("showClass 호출");
			List<Map<String, Object>> list = cookClassDao.showClass(pmap);
			logger.info("CookClassC - showClass" + list);
			return list;
		}



	// 내 쿠킹클래스 전체의 신청 회원 보기
	@ResponseBody
	@RequestMapping("myClassMemList.np")
	public List<Map<String, Object>> myClassMemList(@RequestParam Map<String, Object> pmap) {
		logger.info("checkCookClass 호출");
		pmap.put("field", "SHOW_APPLY_USERS");
		pmap.put("m_id", "");
		List<Map<String, Object>> list = cookClassDao.classForChef(pmap);
		logger.info("CookClassC - myClassMemList" + list);
		return list;
	}

	// 쿠킹클래스 회원 수락
	@RequestMapping("myClassMemAccept.np")
	public String myClassMemAccept(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("myClassMemAccept 호출");
		pmap.put("field", "ACCEPT_MYCLASS");
		List<Map<String, Object>> list = cookClassDao.classForChef(pmap);
		logger.info("CookClassC - myClassMemAccept" + list);
		model.addAttribute("list", list);
		return "forward:goAcceptList.jsp";
	}

	// 쿠킹클래스 회원 반려
	@RequestMapping("myClassMemDeny.np")
	public String myClassMemDeny(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("myClassMemDeny 호출");
		pmap.put("field", "DENY_MYCLASS");
		List<Map<String, Object>> list = cookClassDao.classForChef(pmap);
		logger.info("CookClassC - myClassMemDeny" + list);
		model.addAttribute("list", list);
		return "forward:goDenyList.jsp";
	}
	
	

}
