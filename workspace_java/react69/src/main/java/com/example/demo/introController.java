package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class introController {
	Logger logger = LogManager.getLogger(introController.class);
	@GetMapping("/intro.kosmo")
	public String intro(Model model) {
		logger.info("Con intro 호출");
		
		return "redirect:intro.jsp";
	}
}
