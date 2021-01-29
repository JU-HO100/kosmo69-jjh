package web.android;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);
	@RequestMapping(value="test.ko",method=RequestMethod.GET)
	public String test() {
		logger.info("test 호출");
//		return "test";//단위 테스트 할 때에는 반드시 먼저 선 예측 후 결과 확인 
//		return "redirect:test";//404, 
		//원인 - ViewResolver를 사용하지 않는 경우 - redirect가 있으니 .jsp를 붙여야 한다.
		return "forward:test.jsp";//404 - 배포위치의 문제 - 현제 WEB-INF 이니까 - webapp에 있다면 200
		//forward일 경우 webapp에 있어야한다.
		
	}
}
