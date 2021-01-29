package com.spring.mvc1;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
@RequestMapping("/dept/*")
public class DeptController {
//public class DeptController extends MultiActionController {
	Logger logger = LoggerFactory.getLogger(DeptController.class);
	//아래 변수명은 property name에 들어갈 값과 일치해야 하므로 줄여쓰지 않아야 함.
	private DeptLogic deptLogic = null;
	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}
	@RequestMapping("deptList.test")
	public String deptList() {
		logger.info("deptList 호출");
		List<Map<String,Object>> deptList = null;
		//deptList = deptLogic.deptList();
		return "redirect:deptList.jsp";//res.sendRedirect("deptList.jsp")
	}
}
