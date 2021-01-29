<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.mvc.BbsVO"%>
<%@ page import="web.mvc.BbsDAO,java.util.*"%>
<%@ page import="com.google.gson.Gson"%>


<%
	BbsDAO bdao = new BbsDAO();
	BbsVO bVO = new BbsVO();
	int result = 0;
	int b_num = 0;
	int b_hits = 0;
	String b_title = request.getParameter("title");
	String b_mem = request.getParameter("name");
	String b_pw = request.getParameter("pass1");
	String b_contente = request.getParameter("contente");
	String b_day = null;
	
// 	int b_num = 11;
// 	int b_hits = 11;
//  	String b_title = "테스트";
//  	String b_day = "2020-11-11";
//  	String b_mem = "작성자";
//  	String b_pw = "123";
//  	String b_contente = "내용";
	
	bVO.setB_TITLE(b_title);
	bVO.setB_MEM(b_mem);
	bVO.setB_PW(b_pw);
	bVO.setB_DAY(b_day);
	bVO.setB_HITS(b_hits);
	bVO.setB_NUM(b_num);
	bVO.setB_CONTENTE(b_contente);
	result = bdao.insertBbs(bVO);
	if(result == 1){
		response.sendRedirect("./list.jsp");
	}
%>