package com.example.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
//서블릿을 직접 상속받는 대신에 어노테이션을 사용해서 결합도를 낮추었다.
//두번째는 메소드의 파라미터 자리에 request와 response가 없는데도 메소드가 호출되었다.
//이것은 더이상 request 객체나 response객체에 의존적이지 않다는 것이다.  없어도 웹서비스를 제공할 수 있다.

@RequestMapping("/board/*")
public class BoardController {
	//상속을 받으면 req와 res에 의존적인 코딩을 전개해야 한다.
	//용청객체와 응답객체에 의존적이다. - 독립적이지 못하다.
//public class 
   Logger logger = LogManager.getLogger(BoardController.class);
   
   //Autowired는 setter메소드를 굳이 쓰지 않더라도 객체주입을 받을 수 있게 해준다.
   @Autowired(required=false)//처음 테스트 할때 false를 넣어놓는게 안전하다 - 안그러면 터짐
   public BoardLogic boardLogic = null;
   
   ///////////////////////////////////////////////////////////////////////////////////////////
   @RequestMapping("writeForm.sp")
   public String writeForm() 
   {
      logger.info("writeForm 메소드 호출 성공! ");
      return "redirect:writeForm.jsp";
   }
   /////////////////////////////////////////////////////////////////////////////////////////// 
  
//   @RequestMapping("/boardInsert.sp")   
   @PostMapping("boardInsert.sp")
   public String boardInsert(@RequestParam(value="bs_file", required=false) MultipartFile bs_file
		   				   , @RequestParam Map<String,Object> pMap) {      
      logger.info("Con boardInsert 호출성공 !"+pMap);
     //////////////////////////////////////////////////////////////////
        //첨부파일을 처리할 땐 반드시 post 여야 한다.              
        //주의사항:request 로는 사용자가 입력한 값을 받을 수가 없다.                
        //따라서 cos.jar 에서 제공하는 MulitpartRequest 를 사용해야만 값을 요청할 수 있다.        
		//밑의 Map과 HashMap의 역할을 @RequestParam이 대신 해준다
//	    Map<String,Object> pmap = new HashMap<>();
//		HashMapBinder hmb = new HashMapBinder(req);
//		hmb.multiBind(pmap);
		///////////////////////////////////////////////////////////////
      
      //첨부파일 추가하기
		String path = null;
      	String savePath = "C:\\workspace_java\\demo\\src\\main\\webapp\\pds";
		String fullPath = null;
		String filename = null;
		//프레임워크가 반복되는 코드를 줄여 줄 수 있다.
		//예)사용자가 입력한 값 전달(req.getParameter(여기만 달라)) - @RequestParam
		//예)select의 경우 유지[jsp와 자바사이의 - forward선택(페이지 이동)] 처리하기 - 화면
		// Model과 ModelMap을 지원하고 있다. (ui지원하기 위한 api)
		// POJO: req.setAttribute("이름","값");
		// 자료구조 = 컬렉션 프레임워크 = 파이썬(리스트[List], 튜플[상수리스트:순서는 있지만 변경불가], 딕셔너리(Map), 집합[Set])
		// JSON(Web, 안드로이드), 넥사크로(xml그리고 js변환해줌) - DataSet지원 - Post(디폴트)
		//파라미터의 값이 널일 때를 고려하면 required=false 로 해줘야한다. - 그렇지 않으면 에러가 발생
		if(bs_file !=null) {
			filename = bs_file.getOriginalFilename();
			fullPath = savePath+"\\"+filename;//물리적인 경로와 파일명을 연결한다. - 위치 정보를 다시 저장함
		}
		int result = 0;
		if(bs_file!=null) {
			try {
				//파일명을 객체로 만들 때 사용하는 api이다.
				//두번째는 파일 객체를 호라용하여 파일의 크기를 계산 해준다.
				File file = new File(fullPath);
				//위에서 받아온 파일의 바이트 정보를 담아주는 부분
				byte[] bytes = bs_file.getBytes();
				//파일을 쓰기위한 객체를 생성하는 코드
				//BufferedOutputStream은 버퍼의 기능을 담당하는 클래스이다. - 단독객체 생성은 불가능하다. - 일종의 필터클래스
				BufferedOutputStream bos = 
						new BufferedOutputStream(new FileOutputStream(file));
				//위에서 만든 출력 객체를 활용하여 읽어들인 파일 내용을 새로 생성한 File객체에 쓰기 - 다운로드처리
				bos.write(bytes);
				//사용한 출력스트림은 io에 대한 변조, 복제 등 보안을 이유로 반드시 닫아줘야한다.
				bos.close();
				//79번에서 생성한 파일 객체의 length라는 함수를 통하여 크기를 계산한다.
				//파일 크기
				long size = file.length();
				double d_size = Math.floor(size/1024.0);
				pMap.put("bs_file", filename);
				pMap.put("bs_size", d_size);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
      	 result = 0;
		logger.info("bs_file :"+bs_file+", pMap"+pMap.get("bs_file"));
		result = boardLogic.boardInsert(pMap);
		if(result == 1) {//등록 성공한거니?
			path = "redirect:boardInsertOk2.jsp";
		}else {//등록에 실패했니?
			path = "redirect:boardInsertFail.jsp";
		}
//		result = boardLogic.boardInsert(pMap);
		return path;
   }
   
   /************************************************************************************************
    * 게시판 글 조회 목록 구현
    * @param pMap - get방식이나 post방식으로 전송시 자동으로 담김, 반복되는 코드를 줄였다
    * @return "redirect:XXX.jsp" or "forward:XXX.jsp"(webapp) or XXX[WEB-INF:viewResolver사용]
    * 
    **************************************************************************************************/
   @RequestMapping("/boardList.sp")   
   public String boardList(Model mod,ModelMap rmap,@RequestParam Map<String,Object> pMap) {      //@RequestParam을 사용하면  url에 입력한 값을 읽어올 수 있다.
      logger.info("Con boardList 호출성공 !"+pMap);            //Map을 찍기 떄문에 {} 안에 출력된다.               
      //String pmem_id = req.getParameter("mem_id");                  // request.getParameter대신 사용하는것. 반복되는 코드를 줄여준다.
      List<Map<String,Object>> bList = null;
      bList = boardLogic.boardList(pMap);
      rmap.addAttribute("boardList", bList);
//      mod.addAttribute("boardList2",bList);
//      return "redirect:boardList.jsp";
      return "forward:boardList.jsp";
   }
   @RequestMapping("/updateForm.sp")   
   public String boardUpdate(Model mod,ModelMap rmap,@RequestParam Map<String,Object> pMap)  //@RequestParam을 사용하면  url에 입력한 값을 읽어올 수 있다.
   throws Exception
   	{     
	   logger.info("Con Update 호출");
	   String path = null;
	      int result = 0;
	      //첨부 파일이 존재하니?
	      result = boardLogic.boardUpdate(pMap);
	      if(result == 1) {//업데이트 성공한거니?
	         path="redirect:/board/boardUpdateOk.jsp";
	      }else {
	         path="redirect:/board/boardUpdateFail.sp";         
	      }
	      return path;
   	}
   
   @RequestMapping("/boardDetail.sp")
   public String boardDetail(@RequestParam Map<String,Object> pMap) {
	   logger.info("Con Detail 호출");
	   List<Map<String,Object>> boardList = null;
	   pMap.put("gubun", "detail");
	   boardList = boardLogic.boardList(pMap);
//	   mod.addAttribute("boardDetail", boardList);
	   return "board/read";
   }
   @RequestMapping("/boardDelete.sp")
   public String boardDelete(@RequestParam Map<String,Object> pMap){
	   logger.info("Con Delete 호출");//detail
	      String path = null;
	      int result = 0;
	      //첨부 파일이 존재하니?
	      result = boardLogic.boardDelete(pMap);
	      if(result == 1) {//등록 성공한거니?
	         path = "redirect:/board/boardDeleteOk.jsp";
	      }else {
	         path = "/board/boardDeleteFail.sp";         
	      }
	      return path;
	}
   
   
}