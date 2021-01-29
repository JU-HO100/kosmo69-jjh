<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.mvc.BbsDAO, java.util.*"%>
<%@ page import="java.util.Map, java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%
	BbsDAO bdao = new BbsDAO();
	String u_num = request.getParameter("b_num");
	Map<String,Object> pmap = new HashMap<>();
	if(u_num!=null){ //g_empno가 null 아닐때 실행 null이면 15번 라인으로 넘어가라
		int b_num = Integer.parseInt(u_num);//사용자가 입력한값(text타입이) int타입으로 바뀐다.
		pmap.put("b_num", b_num);
	}	
	
	List<Map<String,Object>> num = bdao.getContente(pmap);
	Gson g = new Gson();
	String imsi = g.toJson(num);
	out.print(imsi);
	

%>