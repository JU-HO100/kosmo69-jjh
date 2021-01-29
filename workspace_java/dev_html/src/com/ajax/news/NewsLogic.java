package com.ajax.news;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class NewsLogic {
	Logger logger = Logger.getLogger(NewsLogic.class);
	/*********************************************************************************************************
	 * 
	 * @param i : 뉴스 번호
	 * @return List<Map<>> : 조회 결과 담기
	 ************************************************************************************************************/
	public List<Map<String, Object>> getNewsList() {
		logger.info("getNewsList 호출 성공");
		List<Map<String,Object>> newsList = null;
		
		
		
			
		return newsList;
	}
	public List<Map<String, Object>> getNewsDetail(int n_no) {
		logger.info("getNewsDetail 호출 성공");
		List<Map<String,Object>> newsDetail = null;
		
		
		return newsDetail;
	}
	public List<Map<String, Object>> getNewsContente(String title) {
		logger.info("getNewsContente 호출 성공");
		List<Map<String,Object>> newsCon = null;
		
		
		return newsCon;
	}
	public int NewsInsert(Map<String, Object> pmap) {
		
		return 0;
	}
	public int NewsUpdate(Map<String, Object> pmap) {
		
		return 0;
	}
	public int NewsDelete(int num) {
		
		return 0;
	}
	public static void main(String[] args) {
//		NewsLogic nl = new NewsLogic();
//		List<Map<String,Object>> newsList = null;
//		newsList = nl.getNewsList();
//		System.out.println(newsList);
		
	}
}
