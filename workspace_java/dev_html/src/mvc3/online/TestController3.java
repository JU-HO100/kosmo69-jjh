package mvc3.online;

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

import mvc2.online.ModelAndView;


public class TestController3 implements Controller3 {
	Logger logger = Logger.getLogger(TestController3.class);
	String requestName = null;// login/memberList.sp2 -> memberList가 담긴다
	
	
	//*********************************** 생성자
	public TestController3() {}
	public TestController3(String requestName) {
		logger.info("TestController 호출");
		this.requestName = requestName;//응답페이지의 이름
	}
	
	
	//*********************************** execute2 메소드
	@Override
	public ModelAndView3 execute2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("execute 호출");
		List<Map<String,Object>> testList = new ArrayList<>();
		ModelAndView3 mav = null;
		if("isOk".equals(requestName)) {
			logger.info("응시 여부 확인 호출");
			String msg = null;
			Map<String,Object> pmap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(request);
			hmb.bind(pmap);
			mav = new ModelAndView3(request, response);
			mav.addObject("testList", testList);// 닮은꼴 = req(session).setAttribute("deptList", deptList); 
			mav.setViewName(requestName+".jsp");// WEB-INF/views/[[dept/deptList]].jsp
		}
		else if("swDesignExam".equals(requestName)) {
			logger.info("응시 여부 확인 호출");
		}
		else if("subjectList".equals(requestName)) {
			logger.info("시험과목 조회 성공");
			List<Map<String,Object>> subList = null;
			mav = new ModelAndView3(request,response);
			mav.addObject("subList", subList);
			mav.setViewName("jsonSubjectList.jsp");
		}
		return mav;
	}
	
	//****************************************** execute 메소드
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = null;
		if("zipCodeList".equals(requestName)) {
			List<Map<String,Object>> list = null;
			
			Map<String,Object> pmap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(request);
			hmb.bind(pmap);
			request.setAttribute("list", list);
			//아래와 같을 경우 배포 위치는 어디로 해야 할까요?
			//ModelAndView와는 동일하게 가져 가야 할까요?
			//스프링에서는 어떻게 하고 있죠?
			
			path = "forward:/member/jsonZipcodeList.jsp";
			
		}
		return path;
	}

}
