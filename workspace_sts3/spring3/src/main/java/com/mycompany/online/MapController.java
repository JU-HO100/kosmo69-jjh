package com.mycompany.online;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class MapController extends AbstractController {
	Logger logger = Logger.getLogger(MapController.class);
	Map<String,String> mapBean = null;
	public void setMapBean(Map<String, String> mapBean) {
		this.mapBean = mapBean;
	}	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("handleRequestInternal 호출 성공");
		ModelAndView mav = new ModelAndView();
		Iterator<String> iter = mapBean.keySet().iterator();
		while(iter.hasNext()) {
			logger.info(mapBean.get(iter.next()));
		}
		mav.setViewName("di/mapPrint");
		mav.addObject("mapBean", mapBean);//scope - request
		return mav;
	}

}
