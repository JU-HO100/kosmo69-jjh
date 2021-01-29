package np.com.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import np.mem.model.RecipeDao;

@Controller

@RequestMapping("/recipe/*")
public class RecipeController {
	Logger logger = LogManager.getLogger(RecipeController.class);

	@Autowired
	public RecipeDao recipeDao;

	// 글쓰기
	@RequestMapping("recipeInsert.np")
	public String recipeInsert(Model model, @RequestParam(value = "main_img", required = false) MultipartFile mainFile,
			@RequestParam(value = "sub_img", required = false) MultipartFile[] sub_img,
			@RequestParam Map<String, Object> pmap) throws Exception {
		logger.info("recipeInsert 호출");
		logger.info(pmap);
		logger.info(mainFile);
		logger.info(sub_img);
		// 파일 업로더
		String id = pmap.get("m_id").toString();
		// 고유번호를 위한 날짜와 시간
		String today = DateTimeFormatter.ofPattern("yyMMddhhmmss").format(LocalDateTime.now());
		// 파일 저장 경로
		String savePath = "C:\\june\\work\\nullpointer\\src\\main\\webapp\\images";
		// 메인 이미지 고유번호+파일이름
		String MainMiddlePath = null;
		// 메인 이미지 파일 저장 경로+고유번호+파일 이름
		String MainFullPath = null;
		// 메인 파일 고유 이름
		String mainFileName = null;

		// 고유번호+파일이름
		String middlePath = null;
		// 파일 저장 경로+고유번호+파일 이름
		String fullPath = null;
		// 파일 고유 이름
		String originalName = null;
		// db로 보낼 파일 경로 리스트
		List<String> fileList = new ArrayList<>();

		mainFileName = mainFile.getOriginalFilename();
		MainMiddlePath = id+today + mainFileName;
		MainFullPath = savePath + "\\" + MainMiddlePath;
		logger.info(MainMiddlePath);
		File mfile = new File(MainFullPath);
		mainFile.transferTo(mfile);
		logger.info(MainFullPath);
		pmap.put("main_img", MainFullPath);

		for (MultipartFile file : sub_img) {
			// 업로드되는 파일이 있다면
			if (!file.getOriginalFilename().isEmpty()) {
				originalName = file.getOriginalFilename();
				logger.info("originalName : " + originalName);
				middlePath = today + originalName;
				fullPath = savePath + "\\" + middlePath;
				logger.info(middlePath);
				// 로컬 경로에 파일 저장
				File dest = new File(fullPath);
				file.transferTo(dest);

				// 파일 경로 리스트에 저장
				fileList.add(fullPath);
			}
		}

		String fileListString = StringUtils.join(fileList, ",");

		logger.info(fileListString);
		pmap.put("sub_img", fileListString);

		String msg = recipeDao.boardWrite(pmap);
		logger.info("RecipeC - boardWrite >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:ok.jsp";
	}

	// 글수정
	@RequestMapping("recipeUpdate.np")
	public String recipeUpdate(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("recipeUpdate 호출");
		String msg = recipeDao.boardUpdate(pmap);
		logger.info("RecipeC - boardUpdate >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

	// 글삭제
	@RequestMapping("recipeDelete.np")
	public String recipeDelete(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("recipeDelete 호출");
		String msg = recipeDao.boardDelete(pmap);
		logger.info("RecipeC - boardDelete >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

	// 게시글 목록
	@ResponseBody
	@RequestMapping("recipeList.np")
	public List<Map<String, Object>> recipeList(@RequestParam Map<String, Object> pmap) {
		logger.info("recipeList 호출");
		pmap.put("field", "BOARD_LIST");
		pmap.put("menucd", "");
		List<Map<String, Object>> list = recipeDao.boardView(pmap);
		logger.info("RecipeC - recipeList >>>> " + list);
		return list;
	}

	// 인기 게시물 목록
	@ResponseBody
	@RequestMapping("popRecipeList.np")
	public List<Map<String, Object>> popRecipeList(@RequestParam Map<String, Object> pmap) {
		logger.info("popRecipeList 호출");
		pmap.put("field", "POP_BOARD_LIST");
		pmap.put("menucd", "");
		List<Map<String, Object>> list = recipeDao.boardView(pmap);
		logger.info("RecipeC - recipeList >>>> " + list);
		return list;
	}

	// 단일 게시글 내용
	@RequestMapping("recipeContent.np")
	public String recipeContent(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("recipeContent 호출");
		pmap.put("field", "BOARD_CONTENT");
		List<Map<String, Object>> list = recipeDao.boardView(pmap);
		logger.info("RecipeC - recipeContent >>>> " + list);
		model.addAttribute("list", list);
		return "forward:member/IMSI.jsp";
	}

	// 게시자 검색
	@ResponseBody
	@RequestMapping("nickSearch.np")
	public List<Map<String, Object>> nickSearch(@RequestParam Map<String, Object> pmap) {
		logger.info("nickSearch 호출");
		pmap.put("field", "M_NICK");
		List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
		logger.info("RecipeC - nickSearch >>>> " + list);
		return list;
	}

	// 제목 검색
	@ResponseBody
	@RequestMapping("subjectSearch.np")
	public List<Map<String, Object>> subjectSearch(@RequestParam Map<String, Object> pmap) {
		logger.info("subjectSearch 호출");
		pmap.put("field", "FOODNAME");
		List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
		logger.info("RecipeC - subjectSearch >>>> " + list);
		return list;
	}

	// 본문 내용 검색
	@ResponseBody
	@RequestMapping("contentSearch.np")
	public List<Map<String, Object>> contentSearch(@RequestParam Map<String, Object> pmap) {
		logger.info("contentSearch 호출");
		pmap.put("field", "RECIPE_INFO");
		List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
		logger.info("RecipeC - contentSearch >>>> " + list);
		return list;
	}

	// 재료 검색
	@ResponseBody
	@RequestMapping("ingredSearch.np")
	public List<Map<String, Object>> ingredSearch(@RequestParam Map<String, Object> pmap) {
		logger.info("ingredSearch 호출");
		pmap.put("field", "JAELYO");
		List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
		logger.info("RecipeC - ingredSearch >>>> " + list);
		return list;
	}

	// 대분류 검색 [버튼] 한식, 양식, 일식, 중식
	@RequestMapping("mainSearch.np")
	public String mainSearch(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("mainSearch 호출");
		pmap.put("field", "CATEGORY");
		List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
		logger.info("RecipeC - mainSearch >>>> " + list);
		model.addAttribute("list", list);
		return "forward:member/IMSI.jsp";
	}

	// 소분류 검색 [버튼] 찜, 구이, 디저트, 면, etc..
	@RequestMapping("smallSearch.np")
	public String smallSearch(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("smallSearch 호출");
		pmap.put("field", "FOODGROUP");
		List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
		logger.info("RecipeC - smallSearch >>>> " + list);
		model.addAttribute("list", list);
		return "forward:member/IMSI.jsp";
	}

	// 대분류리스트
	@ResponseBody
	@RequestMapping("lageCategory.np")
	public List<Map<String, Object>> lageCategory(@RequestParam Map<String, Object> pmap) {
		logger.info("lageCategory 호출");
		pmap.put("field", "LAGE_CATEGORY");
		List<Map<String, Object>> list = recipeDao.listForGiveInfo(pmap);
		logger.info("RecipeC - lageCategory >>>> " + list);
		return list;
	}

	// 소분류리스트
	@ResponseBody
	@RequestMapping("smallCategory.np")
	public List<Map<String, Object>> smallCategory(@RequestParam Map<String, Object> pmap) {
		logger.info("smallCategory 호출");
		pmap.put("field", "SMALL_CATEGORY");
		List<Map<String, Object>> list = recipeDao.listForGiveInfo(pmap);
		logger.info("RecipeC - smallCategory >>>> " + list);
		return list;
	}

	// 재료리스트
	@ResponseBody
	@RequestMapping("jaelyoList.np")
	public List<Map<String, Object>> jaelyoList(@RequestParam Map<String, Object> pmap) {
		logger.info("jaelyoList 호출");
		pmap.put("field", "JAELYO_LIST");
		List<Map<String, Object>> list = recipeDao.listForGiveInfo(pmap);
		logger.info("RecipeC - jaelyoList >>>> " + list);
		return list;
	}

	// 좋아요 등록, 취소
	@RequestMapping("clickLike.np")
	public String clickLike(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("clickLike 호출");
		pmap.put("field", "CLICK_LIKE");
		String msg = recipeDao.boardLikes(pmap);
		logger.info("RecipeC - clickLike >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

	// 좋아요 확인
	@RequestMapping("checkLike.np")
	public String checkLike(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("checkLike 호출");
		pmap.put("field", "CHECK_LIKE");
		String msg = recipeDao.boardLikes(pmap);
		logger.info("RecipeC - checkLike >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

	// //좋아요 모두 확인
	@RequestMapping("checkAllLikes.np")
	public String checkAllLikes(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("clickLike 호출");
		pmap.put("field", "ALL_LIKES");
		String msg = recipeDao.boardLikes(pmap);
		logger.info("RecipeC - checkAllLikes >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:member/IMSI.jsp";
	}

}
