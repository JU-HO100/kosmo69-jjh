package com.recipe;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//서블릿을 직접 상속받는 대신에 어노테이션을 사용해서 결합도를 낮추었다.
//두번째는 메소드의 파라미터 자리에 request와 response가 없는데도 메소드가 호출되었다.
//이것은 더이상 request 객체나 response객체에 의존적이지 않다는 것이다.  없어도 웹서비스를 제공할 수 있다.

@RequestMapping("/recipe/*")
public class RecipeController {
   Logger logger = LogManager.getLogger(RecipeController.class);
   
   //Autowired는 setter메소드를 굳이 쓰지 않더라도 객체주입을 받을 수 있게 해준다.
   @Autowired
   public RecipeLogic recipeLogic = null;
   
   ///////////////////////////////////////////////////////////////////////////////////////////
   @RequestMapping("writeForm.sp3")
   public String writeForm() 
   {
      logger.info("writeForm 메소드 호출 성공! ");
      return "recipe/writeForm";
   }
   /////////////////////////////////////////////////////////////////////////////////////////// 
  
   @RequestMapping("/recipeInsert.sp3")   
   public String boardInsert(@RequestParam Map<String,Object> pMap) {      
      logger.info("Con recipeInsert 호출성공 !"+pMap);                     
      int result = 0;
      result = recipeLogic.recipeInsert(pMap);
      logger.info("최종 result >> "+result);               
      return "redirect:boardInsertOk.jsp";
   }
   
   /************************************************************************************************
    * 게시판 글 조회 목록 구현
    * @param pMap - get방식이나 post방식으로 전송시 자동으로 담김, 반복되는 코드를 줄였다
    * @return "redirect:XXX.jsp" or "forward:XXX.jsp"(webapp) or XXX[WEB-INF:viewResolver사용]
    * 
    **************************************************************************************************/
   @RequestMapping("/recipeList.sp3")   
   public String boardList(Model mod,ModelMap rmap,@RequestParam Map<String,Object> pMap) {      //@RequestParam을 사용하면  url에 입력한 값을 읽어올 수 있다.
      logger.info("BoardController boardList 호출성공 !"+pMap);            //Map을 찍기 떄문에 {} 안에 출력된다.               
      //String pmem_id = req.getParameter("mem_id");                  // request.getParameter대신 사용하는것. 반복되는 코드를 줄여준다.
      List<Map<String,Object>> rList = null;
      rList = recipeLogic.boardList(pMap);
      rmap.addAttribute("boardList", rList);
      mod.addAttribute("boardList2",rList);
      return "forward:boardList.jsp";
   }
   
   
}