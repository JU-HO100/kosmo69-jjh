package com.spring.mvc1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller	
public class DeptController  {
	Logger logger = Logger.getLogger(DeptController.class);
	//아래 변수명은 property name에 들어갈 값과 일치해야 하므로 줄여쓰지 않아야 한다.
	private DeptLogic deptLogic = null;
	public void setDeptLogic(DeptLogic deptLogic) {
		this.deptLogic = deptLogic;
	}
	@RequestMapping("deptList.test")
	public ModelAndView deptList() {
		logger.info("deptList 호출 Controller");
		List<Map<String,Object>> deptList = null;
//		deptList = deptLogic.deptList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("deptList", deptList);
		mav.setViewName("dept/deptList");//WEB-INF/views/[[dept/deptList]].jsp
		
		return mav;
	}
	
}
