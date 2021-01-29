package com.mycompany.online;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MapController extends AbstractController {
	Logger logger = Logger.getLogger(MapController.class);
	Map<String,String> mapBean = null;// DI 하려면 무조건 null로 줘야한다.
	// setter 객체 주입법 - 직접 인스턴스화 하면 라이프 사이클을 직접 관리해야 하므로
	// 스프링에서는 대신 관리 해주니까 그가 원하는 방법으로 등록해 둔다.
	public void setMapBean(Map<String,String> mapBean) {
		this.mapBean = mapBean;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("MapController 호출 성공");
		ModelAndView mav = new ModelAndView();
		Iterator<String> iter = mapBean.keySet().iterator();
		while(iter.hasNext()) {
			logger.info(mapBean.get(iter.next()));
		}
	      mav.setViewName("di/mapPrint");
//	      mav.setViewName("di/mapPrint.jsp"); // 붙으면 .jsp 가 두번 붙게 된다.
	      mav.addObject("mapBean", mapBean);//scope - request
		return mav;
	}

}
