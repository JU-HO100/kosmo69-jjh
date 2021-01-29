package com.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class SelectZipCode {
	Logger logger = Logger.getLogger(PrintJson.class);
	//XML문서가 물리적으로 어디에 있는지 알아야 한다.
	String resource = "com/util/Configration.xml";
	//mybatis에서 지원하는 클래스로 
	SqlSessionFactory sqlMapper = null;
	/**************************************************
	 * 조회 결과를 JSON 포맷으로 내보내기 구현
	 * url-pattern:web.xml에 먼저 등록 할것.
	 * common/toJson.do -url패턴
	 **************************************************/
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException
	{
		logger.info("doGet 호출 성공");
		PrintWriter out = res.getWriter();
		res.setContentType("application/json; charset=UTF-8");
		SqlSession session = null;
		List<Map<String,Object>> zipcodeList = null;
		String imsi = null;
		try {
			//물리적으로 떨어져 있는 소스에서 필요한 정보를 읽어오기. - Reader <-> Writer
			//Reader = 문서를 읽는대 필요한 클래스
			Reader reader = Resources.getResourceAsReader(resource);//io가 들어가 있기 때문에 반드시 예외처리해야 한다.
			sqlMapper = new SqlSessionFactoryBuilder().build(reader,"development");//
			logger.info("sqlMapper"+sqlMapper);
			session = sqlMapper.openSession();
			logger.info("session"+session);
			Map<String,Object> target = new HashMap<>();
			zipcodeList = session.selectList("getZipCodeList",target);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(zipcodeList == null) {//조회결과가 없을 때
			zipcodeList = new ArrayList<>();
		}else {//조회결과가 있을 경우
			Gson g = new Gson();
			imsi = g.toJson(zipcodeList);
		}
		out.print(imsi);
	}
}
