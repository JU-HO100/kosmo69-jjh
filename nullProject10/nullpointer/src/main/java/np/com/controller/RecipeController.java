package np.com.controller;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import np.com.util.CsvWriter;
import np.mem.model.RecipeDao;

@Controller

@RequestMapping("/recipe/*")
public class RecipeController {
	Logger logger = LogManager.getLogger(RecipeController.class);

	@Autowired
	public RecipeDao recipeDao;

	// 글쓰기
	@RequestMapping("recipeInsert.np")
	public String recipeInsert(Model model, @RequestParam(required = false) MultipartFile mainFile,
			@RequestParam(required = false) MultipartFile[] sub_img, @RequestParam String[] recipe,
			@RequestParam Map<String, Object> pmap, @SessionAttribute("id") String id) throws Exception {
		logger.info("recipeInsert 호출");
		logger.info(pmap.get("jaelyo"));
		logger.info(mainFile);

		pmap.put("m_id", id);

		String token = pmap.get("jaelyo").toString();
		StringTokenizer st = new StringTokenizer(token, ",");

		StringBuilder jaelyo1 = new StringBuilder();
		StringBuilder weight1 = new StringBuilder();
		StringBuilder unit1 = new StringBuilder();

		int i = 0;
		while (st.hasMoreTokens()) {
			String gongback[] = st.nextToken().split(" ");
			if (i == 0) {
				jaelyo1.append(gongback[0]);
				weight1.append(gongback[1]);
				unit1.append(gongback[2]);
			} else {
				jaelyo1.append("," + gongback[0]);
				weight1.append("," + gongback[1]);
				unit1.append("," + gongback[2]);
			}
			i += 1;
		}

		System.out.println("jaelyo>>>" + jaelyo1);
		System.out.println("weight>>>" + weight1);
		System.out.println("unit>>>" + unit1);

		String jaelyo = jaelyo1.toString();
		String weight = weight1.toString();
		String unit = unit1.toString();

		pmap.put("jaelyo", jaelyo);
		pmap.put("weight", weight);
		pmap.put("unit", unit);

		// 파일 업로더

		// 고유번호를 위한 날짜와 시간
		String today = DateTimeFormatter.ofPattern("yyMMddhhmmss").format(LocalDateTime.now());
		// 파일 저장 경로
		String savePath = "C:\\Users\\kosmo_12\\Desktop\\nullpr11564o\\nullProject10\\nullpointer\\src\\main\\webapp\\images";
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

		String mainDBpath = null;

		// 메인 이미지 저장, 경로 db 저장
		if (!mainFile.getOriginalFilename().isEmpty()) {
			mainFileName = mainFile.getOriginalFilename();
			MainMiddlePath = id + today + mainFileName;
			MainFullPath = savePath + "\\" + MainMiddlePath;
			mainDBpath = "images\\" + MainMiddlePath;
			logger.info(MainMiddlePath);
			File mfile = new File(MainFullPath);
			mainFile.transferTo(mfile);
			logger.info(MainFullPath);
			pmap.put("main_img", mainDBpath);
		} else if (mainFile.getOriginalFilename().isEmpty()) {
			mainFileName = "-";
			logger.info(MainMiddlePath);
			File mfile = new File(mainFileName);
			mainFile.transferTo(mfile);
			logger.info(mainFileName);
			pmap.put("main_img", mainFileName);
		}

		String subDBpath = null;
		// 서브 이미지 저장, 경로 db 저장
		for (MultipartFile file : sub_img) {
			// 업로드되는 파일이 있다면
			if (!file.getOriginalFilename().isEmpty()) {
				originalName = file.getOriginalFilename();
				logger.info("originalName : " + originalName);
				middlePath = id + today + originalName;
				fullPath = savePath + "\\" + middlePath;
				subDBpath = "images\\" + middlePath;
				// 로컬 경로에 파일 저장
				File dest = new File(fullPath);
				file.transferTo(dest);

				// 파일 경로 리스트에 저장
				fileList.add(subDBpath);
			} else if (file.getOriginalFilename().isEmpty()) {
				originalName = "-";
				logger.info("originalName : " + originalName);
				fileList.add(originalName);
			}
		}
		String fileListString = StringUtils.join(fileList, ",");
		logger.info(fileListString);
		pmap.put("sub_img", fileListString);

		// 레시피 내용
		String recipe_info = StringUtils.join(recipe, ",");
		logger.info(recipe_info);
		pmap.put("recipe_info", recipe_info);

		// dao 호출
		String msg = recipeDao.boardWrite(pmap);
		logger.info("RecipeC - boardWrite >>>> " + msg);
		model.addAttribute("msg", msg);
		return "forward:recipe.jsp";
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
		Map<String,Object> change = new HashMap<String,Object>();

		// 리스트에서 sub_img 컬럼 값만 뽑기
		String tmpStr = "";
		Map<String, Object> img = (Map<String, Object>) list.get(0);
		tmpStr = img.get("SUB_IMG").toString();
		logger.info(tmpStr);

		// sub_img를 split해서 각 이미지 주소별로 나누기
		String[] imgList = tmpStr.split(",");

		// 이미지 주소별로 나눈걸 다시 list에 넣기
		for (int i = 0; i < imgList.length; i++) {
			change.put("sub_img" + i, imgList[i]);
		}
		
		// 리스트에서 RECIPE_INFO 컬럼 값만 뽑기
		String tmpStr2 = "";
		Map<String, Object> info = (Map<String, Object>) list.get(0);
		tmpStr2 = info.get("RECIPE_INFO").toString();
		logger.info(tmpStr2);

		String[] infoList = tmpStr2.split(",");

		for (int i = 0; i < infoList.length; i++) {
			change.put("recipe_info" + i, infoList[i]);
		}
	
		change.put("UNIT", list.get(0).get("UNIT").toString());
		change.put("WEIGHT", list.get(0).get("WEIGHT").toString());
		change.put("MAIN_IMG", list.get(0).get("MAIN_IMG").toString());
		change.put("CREATION_DATE", list.get(0).get("CREATION_DATE").toString());
		change.put("M_ID", list.get(0).get("M_ID").toString());
		change.put("JAELYO", list.get(0).get("JAELYO").toString());
		change.put("M_NICK", list.get(0).get("M_NICK").toString());
		change.put("HIT", list.get(0).get("HIT").toString());
		change.put("HASHTAG", list.get(0).get("HASHTAG").toString());
		change.put("MENUCD", list.get(0).get("MENUCD").toString());
		change.put("CATEGORY", list.get(0).get("CATEGORY").toString());
		change.put("FOODGROUP", list.get(0).get("FOODGROUP").toString());
		change.put("FOODNAME", list.get(0).get("FOODNAME").toString());
		change.put("leng", infoList.length);
		list.set(0, change);

		model.addAttribute("list", list);

		return "forward:recipeDetailList.jsp";

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
	@RequestMapping("jaelyoList.np")
	public String jaelyoList(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("jaelyoList 호출");
		pmap.put("field", "JAELYO_LIST");
		List<Map<String, Object>> list = recipeDao.listForGiveInfo(pmap);
		logger.info("RecipeC - jaelyoList >>>> " + list);
		model.addAttribute("list", list);
		return "forward:registeringredientList.jsp";
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

	// 차트 출력
	@ResponseBody
	@RequestMapping("forChart.np")
	public List<Map<String, Object>> forChart(@RequestParam Map<String, Object> pmap) {
		logger.info("forChart 호출");
		List<Map<String, Object>> list = recipeDao.forChart(pmap);
		logger.info("RecipeC - forChart >>>> " + list);
		return list;
	}

	// 검색
	@ResponseBody
	@RequestMapping("nickSearch.np")
	public List<Map<String, Object>> nickSearch(@RequestParam Map<String, Object> pmap) {
		logger.info("nickSearch 호출");
		pmap.put("m_id", "");
		List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
		logger.info("메인이미지! : " + list);
		logger.info("RecipeC - nickSearch >>>> " + list);
		return list;
	}

	// 대분류 검색 [버튼] 한식, 양식, 일식, 중식
	@ResponseBody
	@RequestMapping("mainSearch.np")
	public List<Map<String, Object>> mainSearch(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("mainSearch 호출");
		pmap.put("field", "CATEGORY");
		List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
		logger.info("RecipeC - mainSearch >>>> " + list);
		model.addAttribute("list", list);
		return list;
	}

	// 소분류 검색 [버튼] 찜, 구이, 디저트, 면, etc..
	@ResponseBody
	@RequestMapping("smallSearch.np")
	public List<Map<String, Object>> smallSearch(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("smallSearch 호출");
		pmap.put("field", "FOODGROUP");
		List<Map<String, Object>> list = recipeDao.boardSearch(pmap);
		logger.info("RecipeC - smallSearch >>>> " + list);
		model.addAttribute("list", list);
		return list;
	}

	@RequestMapping("getGeneralWord.np")
	public String getGeneralWord(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("getGeneralWord 호출");
		String filepath = "C:\\june\\work\\nullpointer\\src\\main\\webapp\\csvcollect";
		String title = "words";
		pmap.put("field", "GENERAL_WORDCLOUD");
		List<Map<String, Object>> list = recipeDao.getWord_bySearch(pmap);
		logger.info("RecipeC - getGeneralWord >>>> " + list);
		CsvWriter writer = new CsvWriter();
		writer.createCSV(list, title, filepath);
		model.addAttribute("CSV", title);
		return "forward:recommendation.jsp";
	}

	@RequestMapping("getMyWord.np")
	public String getMyWord(Model model, @RequestParam Map<String, Object> pmap) {
		logger.info("getMyWord 호출");
		String filepath = "C:\\june\\work\\nullpointer\\src\\main\\webapp\\csvcollect";
		String title = "mywords";
		pmap.put("field", "MY_WORDCLOUD");
		List<Map<String, Object>> list = recipeDao.getWord_bySearch(pmap);
		logger.info("RecipeC - getGeneralWord >>>> " + list);
		CsvWriter writer = new CsvWriter();
		writer.createCSV(list, title, filepath);
		model.addAttribute("CSV", title);
		return "forward:wordsSelect.jsp";
	}
}
