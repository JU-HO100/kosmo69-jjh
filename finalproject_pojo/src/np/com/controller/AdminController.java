package np.com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import np.admin.model.AdminDao;
import np.com.util.HashMapBinder;

//admin/*.np
public class AdminController implements Action{
	Logger logger = Logger.getLogger(MemberController.class);

	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		ModelAndView mav = new ModelAndView(req, res);
		PrintWriter out = res.getWriter();
		String pageName = (String)req.getAttribute("pageName");
		AdminDao adMinDao = AdminDao.getInstance();
		
		Gson g = null;
	    Map<String,Object> pmap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pmap);
		
		String forJson = null;	//json 을 위한 String
		
		logger.info("AdminC map>>>>>>"+pmap);
		
		
		//			=== 관리자 전용 검색기능 ===
		
		if(pageName.equals("rightList")) {//관리자 리스트 보기
			pmap.put("field","ADMIN_RIGHT");
			List<Map<String, Object>> list =adMinDao.adminSearch(pmap);
			logger.info("AdminC -  rightList >>>> "+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		else if(pageName.equals("boardList")) {//게시판검색 관련 기능
			pmap.put("field","ADMIN_BOARD");
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
			List<Map<String, Object>> list =adMinDao.adminSearch(pmap);
			logger.info("AdminC -  boardList >>>> "+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		else if(pageName.equals("memList")) {//멤버검색 관련 기능
			pmap.put("field","ADMIN_MEMBER");
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
			List<Map<String, Object>> list =adMinDao.adminSearch(pmap);
			logger.info("AdminC -  memList >>>> "+list);
			g = new Gson();
			forJson = g.toJson(list);
		}
		else if(pageName.equals("classList")) {//쿠킹클래스검색 관련 기능
			pmap.put("field","ADMIN_CLASS");
			List<Map<String, Object>> list =adMinDao.adminSearch(pmap);
			logger.info("AdminC -  classList >>>> "+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		
		//			=== 총 관리자, 멤버관리자 전용 ===
		
		else if(pageName.equals("giveRight")) {//(총관리자only) 권한 위임
			pmap.put("field","GIVE_RIGHT");
			List<Map<String, Object>> list =adMinDao.adminMemDao(pmap);
			String msg = null;
			for(Map<String,Object> rmap : list) {
				msg = (String)rmap.get("MSG");//String으로 받기
			}
			logger.info("AdminC -  giveRight >>>> "+msg);
			mav.addObject("msg", msg); //String 형식으로 msg 에 담음
		}
		else if(pageName.equals("delRight")) {//(총관리자only) 권한 삭제
			pmap.put("field","DELETE");
			List<Map<String, Object>> list =adMinDao.adminMemDao(pmap);
			String msg=null;
			for(Map<String,Object> rmap : list) {
				msg = (String)rmap.get("MSG");//String으로 받기
			}
			logger.info("AdminC -  delRight >>>> "+msg);
			mav.addObject("msg", msg); //String 형식으로 msg 에 담음
		}
		else if(pageName.equals("addBlack")) {//(멤버관리자) 블랙리스트 추가
			pmap.put("field","PUT_BLACK");
			pmap.put("right","");
			List<Map<String, Object>> list =adMinDao.adminMemDao(pmap);
			String msg=null;
			for(Map<String,Object> rmap : list) {
				msg = (String)rmap.get("MSG");//String으로 받기
			}
			logger.info("AdminC -  addBlack >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("addPause")) {//(멤버관리자) 일시정지리스트 추가
			pmap.put("field","PUT_PAUSE");
			List<Map<String, Object>> list =adMinDao.adminMemDao(pmap);
			String msg=null;
			for(Map<String,Object> rmap : list) {
				msg = (String)rmap.get("MSG");//String으로 받기
			}
			logger.info("AdminC -  addPause >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("releasePause")) {//(멤버관리자) 일시정지회원 풀어주기
			pmap.put("field","RELEASE_PAUSE_MEM");
			List<Map<String, Object>> list =adMinDao.adminMemDao(pmap);
			String msg=null;
			for(Map<String,Object> rmap : list) {
				msg = (String)rmap.get("MSG");//String으로 받기
			}
			logger.info("AdminC -  releasePause >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("readWritting")) {//(멤버관리자) 셰프신청글 보기
			pmap.put("field","READ_WRITTING");
			pmap.put("right","");
			List<Map<String, Object>> list =adMinDao.adminMemDao(pmap);
			logger.info("AdminC -  readWritting >>>> "+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		else if(pageName.equals("commitChef")) {//(멤버관리자) 셰프로 승격시켜주기
			pmap.put("field","COMMIT_CHEF");
			List<Map<String, Object>> list =adMinDao.adminMemDao(pmap);
			String msg=null;
			for(Map<String,Object> rmap : list) {
				msg = (String)rmap.get("MSG");//String으로 받기
			}
			logger.info("AdminC -  commitChef >>>> "+msg);
			mav.addObject("msg", msg);
		}
		
		//			=== 게시판, 쿠킹클래스 관리자 전용 ===
		
		
		else if(pageName.equals("delClass")) {//(쿠킹클래스관리자) 쿠킹클래스 강제 제거
			pmap.put("field","DELETE_COOKCLASS");
			String list =adMinDao.adminBCDao(pmap);
			logger.info("AdminC -  delClass >>>> "+list);
			mav.addObject("list", list);
		}
		else if(pageName.equals("kickPerClass")) {//(쿠킹클래스관리자) 쿠킹클래스내 회원 제거
			pmap.put("field","KICK_PERSON_CC");
			String list =adMinDao.adminBCDao(pmap);
			logger.info("AdminC -  kickPerClass >>>> "+list);
			mav.addObject("list", list);
		}
		else if(pageName.equals("delBoard")) {//(게시판관리자)		게시글 강제 삭제
			pmap.put("field","DELETE_BOARD");
			String list =adMinDao.adminBCDao(pmap);
			logger.info("AdminC -  delBoard >>>> "+list);
			mav.addObject("list", list);
		}
		
		if(g == null) {
			mav.setViewName(pageName+".jsp");
		}else {
			res.setContentType("application/json; charset=utf-8");
			out.print(forJson);
		}
		
		return mav;
	}
}
