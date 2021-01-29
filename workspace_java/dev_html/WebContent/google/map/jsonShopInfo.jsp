<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%
	//jsonShopInfo.jsp파일을 추가 합니다.
	List<Map<String,Object>> shopList = new ArrayList<>();
	Map<String,Object> info = new HashMap<>();
	/* 37.479545, 126.864089 철산역 도미노피자 */
	info.put("loc","도미노피자");
	info.put("lat","37.479545");
	info.put("lng","126.864089");
	shopList.add(info);
	info = new HashMap<>();
	/* 37.480135, 126.881012 가산역 맥도날드 */
	info.put("loc","맥도날드");
	info.put("lat","37.480135");
	info.put("lng","126.881012");
	shopList.add(info);
	info = new HashMap<>();
	/* 37.468975, 126.895577 독산역 스타벅스 */
	info.put("loc","스타벅스");
	info.put("lat","37.468975");
	info.put("lng","126.895577");
	shopList.add(info);
	info = new HashMap<>();
	Gson g = new Gson();
	String temp = g.toJson(shopList);
	out.print(temp);
%>