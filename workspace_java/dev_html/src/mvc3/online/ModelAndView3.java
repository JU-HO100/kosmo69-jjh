package mvc3.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//ModelAndView3의 scope는 request이다.
public class ModelAndView3 {
	Logger logger = Logger.getLogger(ModelAndView3.class);
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	String viewName = null;
	List<Map<String,Object>> reqList = new ArrayList<>();
	public ModelAndView3() {}
	public ModelAndView3(HttpServletRequest request) {
		this.request = request;
	}
	public ModelAndView3(HttpServletRequest request,HttpServletResponse response) {
		this.request = request;//디폴트는 request일거 같다
		this.response = response;
	}
	/************************************************************************************************************
	 * ModelAndView mav = ModelAndView();
	 * mav.setViewName(login/login);
	 * @param viewName
	 *************************************************************************************************************/
	public void setViewName(String viewName) {//응답페이지로 나갈 페이지 이름 결정
		logger.info("viewName : "+viewName);
		this.viewName = viewName;
	}
	public String getViewName() {
		return viewName;
	}
	public void addObject(String name, Object obj) {//scope가 request일 때 값을 유지
		//여러개의 값을 추가하는 코드
		Map<String,Object> rmap = new HashMap<>();
		rmap.put(name, obj);
		reqList.add(rmap);
		request.setAttribute("reqList", reqList);//scope를 request로 하였다. - 세션이 아니다.
		
	}
}
		