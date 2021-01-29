package com.mvc3.board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//서블릿을 직접 상속받는 대신에 어노테이션을 사용해서 결합도를 낮추었다.
//두번째는 메소드의  파라미터 자리에 request와 response가 없는대도 메소드가 호출되었다.
//이것은 더이상 request객체나 response객체에 의존적이지 않다는 것이다. 없어도 웹 서비스를 제공할 수 있다.
@RequestMapping("/board/*")
public class BoardController {
	Logger logger = Logger.getLogger(BoardController.class);
	//Autowired는 setter메소드를 굳이 쓰지 않더라도 객체주입을 받을 수 있게 해줌.
	//@Autowired
	//public BoardLogic bLogic = null;
	
	public BoardLogic boardLogic = null;
	//setter객체 주입법으로 IoC하기-java로 
	//생성자 객체 주입법은 xml으로 
	public void setBoardLogic(BoardLogic boardLogic) {
		this.boardLogic = boardLogic;
	}
	
	@RequestMapping("/boardList2.sp3")
	public String boardList(HttpServletRequest req) {
		logger.info("boardList 호출 성공");
		String pmem_id = req.getParameter("mem_id");
		String pmem_pw = req.getParameter("mem_pw");
		String pmem_name = req.getParameter("mem_name");
		logger.info(pmem_id+","+pmem_pw+", "+pmem_name);
		List<Map<String,Object>> bList = null;
		bList = boardLogic.boardList(null);
		return "forward:list.jsp";
	}
	@RequestMapping("/boardList.sp3")
	public String boardList(@RequestParam Map<String,Object> pMap) {
		logger.info("boardList 호출 성공"+pMap);
		List<Map<String,Object>> bList = null;
		bList = boardLogic.boardList(pMap);
		return "forward:list.jsp";
	}
}
