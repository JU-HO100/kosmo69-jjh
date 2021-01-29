package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;


@Controller
public class DeptController {
	private static final Logger logger = LogManager.getLogger(DeptController.class);
	@RequestMapping("dept/reactMain")
	public String reactMain() {
		logger.info("reactMain 호출 성공");
		return "redirect:resTest.jsp";
	}
}
