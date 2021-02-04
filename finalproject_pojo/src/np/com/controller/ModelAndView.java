package np.com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ModelAndView {
	Logger logger = Logger.getLogger(ModelAndView.class);
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	private List<Map<String,Object>> reqList = new ArrayList<>();
	
	public ModelAndView(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	//member/memberlList.sp
	public void setViewName(String viewName) {//응답페이지로 나갈 페이지 이름 결정하기
		logger.info("viewName : "+viewName);		
		String strTemp="";
		int intTemp=0;
		//	아스키 코드를 활용하여 대문자를 소문자로 변형 memberList ->memberlist
		for(int i=0;i <viewName.length();i++) {
			intTemp = (int)viewName.charAt(i);						//아스키코드 변환  (문자 ->숫자)
			if((65<=intTemp)&&intTemp<=90) {							//아스키코드 65(A) <= intTemp <= 90(Z)  대문자인경우
				strTemp+=(char)(intTemp+32);							//32를 더해서 대문자 -> 소문자로 변환	(숫자코드 => 문자)
			}
			else {
				strTemp+=(char)intTemp;										//나머지 문자 그대로 두기 (이것 없으면 문자 다 안 찍힘)
			}
		}
		logger.info("strTemp = "+strTemp);
		
		
		///////////////////////[[ 응답 페이지 처리 관련 ]]/////////////////////////////
		
		
		
		try {
			if(strTemp.indexOf("select") >=0 || strTemp.indexOf("list")>=0 || strTemp.indexOf("login")>=0) {							//문자열중에 select 나 list 가 있으면 포워드
				RequestDispatcher view = request.getRequestDispatcher(viewName);
				view.forward(request, response);
				logger.info("나는 디스패처");
			}
			else {
				response.sendRedirect(viewName);
				logger.info("나는 리다이렉트");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void addObject(String name, Object obj) {//scope가 request일때 값을 유지하기
		//여러개의 값을 추가하는 코드
		Map<String,Object> rMap = new HashMap<>();
		rMap.put(name,obj);
		reqList.add(rMap);	
		//아래 코드는 오직 한 개만 처리 가능
		request.setAttribute(name, obj);
		request.setAttribute("reqList", reqList);
	}
}









