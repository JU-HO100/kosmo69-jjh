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

import candedata.MemberLogic;

public class MemberController3 implements Controller3 {
	Logger logger = Logger.getLogger(MemberController3.class);
	String requestName = null;
	MemberLogic mLogic = null;
	public MemberController3(String requestName) {
		logger.info("MemberController 호출");
		// login/memberList.sp2
		// 확장자.sp2는 떼어내고 앞의 이름만 담아야한다.
		this.requestName = requestName;//응답페이지의 이름입니다.
	}
	public MemberController3(MemberLogic mLogic) {
		this.mLogic = mLogic;
	}

	@Override
	public ModelAndView3 execute2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("execute 호출"+requestName);
		List<Map<String,Object>> memList = new ArrayList<>();
		Map<String, Object> rmap = new HashMap<>();
		rmap.put("mem_id", request.getParameter("mem_id"));
		rmap.put("mem_pw", request.getParameter("mem_pw"));
//		rmap.put("mem_name", request.getParameter("mem_name"));
		logger.info("Controller.rmap : "+rmap);
//		rmap.put("mem_id", "tomato");
//		rmap.put("mem_id", "test");
		memList.add(rmap);
		ModelAndView3 mav = new ModelAndView3(request, response);
		memList.add(rmap);
		mav.addObject("memList", memList);// 닮은꼴 = req(session).setAttribute("deptList", deptList); 
		mav.setViewName(requestName+".jsp");// WEB-INF/views/[[dept/deptList]].jsp
		return mav;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
