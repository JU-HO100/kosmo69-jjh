package com.mvc.dept;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro17.xapi.tx.PlatformException;

@Controller
@RequestMapping("/nexa/*")
public class DeptController {
	   Logger logger = Logger.getLogger(DeptController.class);
	   
	   @GetMapping("deptXML.kosmo")
	   public void deptXML() throws PlatformException {
	      logger.info("deptXML 호출 성공");
	   }

}
