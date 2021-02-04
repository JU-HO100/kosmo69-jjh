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

import np.com.util.CsvWriter;
import np.com.util.HashMapBinder;
import np.mem.model.RecipeDao;

//recipe/*.np
public class RecipeController implements Action{
	Logger logger = Logger.getLogger(RecipeController.class);

	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ModelAndView mav = new ModelAndView(req, res);
		PrintWriter out = res.getWriter();
		String pageName = (String)req.getAttribute("pageName");
		RecipeDao recipeDao = RecipeDao.getInstance();
		
		Gson g = null;
	    Map<String,Object> pmap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pmap);
		
		String forJson = null;
		
		logger.info("RecpC map>>>>>>"+pmap);
		
		if(pageName.equals("recipeInsert")) {	//글쓰기
			String msg = recipeDao.boardWrite(pmap);
			logger.info("RecipeC - boardWrite >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("recipeUpdate")) {	//글수정
			String msg = recipeDao.boardUpdate(pmap);
			logger.info("RecipeC - boardUpdate >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("recipeDelete")) {	//글삭제
			String msg = recipeDao.boardDelete(pmap);
			logger.info("RecipeC - boardDelete >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("recipeList")) {	//게시글 목록
			pmap.put("field","BOARD_LIST");
			pmap.put("menucd","");
			List<Map<String, Object>> list = recipeDao.boardView(pmap);
			logger.info("RecipeC - recipeList >>>> "+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		//new
		else if(pageName.equals("popRecipeList")) {	//인기 게시글 목록
			pmap.put("field","POP_BOARD_LIST");
			pmap.put("menucd","");
			List<Map<String, Object>> list = recipeDao.boardView(pmap);
			logger.info("RecipeC - popRecipeList >>>> "+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		else if(pageName.equals("recipeContent")) {	//단일 게시글 내용
			pmap.put("field","BOARD_CONTENT");
			List<Map<String, Object>> list = recipeDao.boardView(pmap);
			logger.info("RecipeC - recipeContent >>>> "+list);
			mav.addObject("list", list);
		}
		else if(pageName.equals("boardSearch")) {	//검색
			pmap.put("field","M_NICK");
			List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
			logger.info("RecipeC - Search >>>> "+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		else if(pageName.equals("mainSearch")) {	//대분류 검색   [버튼] 한식, 양식, 일식, 중식
			pmap.put("field","CATEGORY");
			List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
			logger.info("RecipeC - mainSearch >>>> "+list);
			mav.addObject("list", list);
		}
		else if(pageName.equals("smallSearch")) {	//소분류 검색	[버튼] 찜, 구이, 디저트, 면, etc..
			pmap.put("field","FOODGROUP");
			List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
			logger.info("RecipeC - smallSearch >>>> "+list);
			mav.addObject("list", list);
		}
		else if(pageName.equals("lageCategory")) {	//대분류리스트
			pmap.put("field","LAGE_CATEGORY");
			List<Map<String, Object>> list = recipeDao.listForGiveInfo(pmap);
			logger.info("RecipeC - lageCategory"+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		else if(pageName.equals("smallCategory")) {	//소분류리스트
			pmap.put("field","SMALL_CATEGORY");
			List<Map<String, Object>> list = recipeDao.listForGiveInfo(pmap);
			logger.info("RecipeC - smallCategory"+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		else if(pageName.equals("jaelyoList")) {	//재료리스트
			pmap.put("field","JAELYO_LIST");
			List<Map<String, Object>> list = recipeDao.listForGiveInfo(pmap);
			logger.info("RecipeC - jaelyoList"+list);
	        g = new Gson();
	        forJson = g.toJson(list);
		}
		else if(pageName.equals("clickLike")) {	//좋아요 등록, 취소하기
			pmap.put("field","CLICK_LIKE");
			String msg = recipeDao.boardLikes(pmap);
			logger.info("RecipeC - clickLike >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("checkLike")) {	//좋아요 확인
			pmap.put("field","CHECK_LIKE");
			String msg = recipeDao.boardLikes(pmap);
			logger.info("RecipeC - checkLike >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("checkAllLikes")) {	//글의 모든 좋아요 확인
			pmap.put("field","ALL_LIKES");
			String msg = recipeDao.boardLikes(pmap);
			logger.info("RecipeC - checkAllLikes >>>> "+msg);
			mav.addObject("msg", msg);
		}
		else if(pageName.equals("forChart")) {//차트 출력용
			List<Map<String, Object>> list =recipeDao.forChart(pmap);
			logger.info("RecipeC -  forChart >>>> "+list);
			g = new Gson();
			forJson = g.toJson(list);
		}
		else if(pageName.equals("getGeneralWord")) {
			pmap.put("field","GENERAL_WORDCLOUD");
			String filepath = "C:\\workspace_java\\finalproject_pojo\\webapp\\csvcollect";
			String title = "words";
			List<Map<String, Object>> list =recipeDao.getWord_bySearch(pmap);
			logger.info("TestC -  testtList >>>> "+list);
			CsvWriter writer = new CsvWriter();
			writer.createCSV(list, title, filepath);
			pageName = "/testeststes/wordsSelect";
			mav.addObject("CSV", title);
		}
		else if(pageName.equals("getMyWord")) {
			pmap.put("field","MY_WORDCLOUD");
			pmap.put("m_id","aabbccdd13");
			String filepath = "C:\\workspace_java\\finalproject_pojo\\webapp\\csvcollect";
			String title = "mywords";
			List<Map<String, Object>> list =recipeDao.getWord_bySearch(pmap);
			logger.info("TestC -  testtList >>>> "+list);
			CsvWriter writer = new CsvWriter();
			writer.createCSV(list, title, filepath);
			pageName = "/testeststes/wordsSelect";
			mav.addObject("CSV", title);
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
