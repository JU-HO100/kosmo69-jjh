package mvc2.online;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.util.HashMapBinder;

public class TestController implements Controller {
	Logger logger = Logger.getLogger(TestController.class);
	String requestName = null;// login/memberList.sp2 -> memberList가 담긴다
	private TestLogic testLogic = null;
	public TestController(String requestName) {
		logger.info("TestController 호출");
		this.requestName = requestName;//응답페이지의 이름
		testLogic = new TestLogic();
	}

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("execute 호출");
		List<Map<String,Object>> testList = new ArrayList<>();
		testList = testLogic.swDesignExam();
		ModelAndView mav = null;
		if("isOk".equals(requestName)) {
			logger.info("응시 여부 확인 호출");
			String msg = null;
			Map<String,Object> pmap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(request);
			hmb.bind(pmap);
			msg = testLogic.isOk(pmap);//승인 여부를 반환해주는 메소드
			mav = new ModelAndView(request, response);
			mav.addObject("testList", testList);// 닮은꼴 = req(session).setAttribute("deptList", deptList); 
			mav.setViewName(requestName+".jsp");// WEB-INF/views/[[dept/deptList]].jsp
		}
		else if("swDesignExam".equals(requestName)) {
			logger.info("응시 여부 확인 호출");
		}
		else if("subjectList".equals(requestName)) {
			logger.info("시험과목 조회 성공");
			List<Map<String,Object>> subList = null;
			subList = testLogic.subList();
			mav = new ModelAndView(request,response);
			mav.addObject("subList", subList);
			mav.setViewName("jsonSubjectList.jsp");
			
		}
		return mav;
	}

}
