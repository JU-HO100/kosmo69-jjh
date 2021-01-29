package com.mycompany.online;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ListController extends AbstractController {
	Logger logger = Logger.getLogger(ListController.class);
	List<String> listBean = null;// DI 하려면 무조건 null로 줘야한다.
	// setter 객체 주입법 - 직접 인스턴스화 하면 라이프 사이클을 직접 관리해야 하므로
	// 스프링에서는 대신 관리 해주니까 그가 원하는 방법으로 등록해 둔다.
	public void setListBean(List<String> listBean) {
		this.listBean = listBean;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("ListController 호출 성공");
		ModelAndView mav = new ModelAndView();
		for(int i=0; i<listBean.size(); i++) {
			logger.info(listBean.get(i));
		}
		return null;
	}

}
