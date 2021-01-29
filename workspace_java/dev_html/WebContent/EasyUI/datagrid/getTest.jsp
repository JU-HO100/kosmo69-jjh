<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="java.util.ArrayList, java.util.HashMap" %>	
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> testInfo = new ArrayList<>();
	Map<String,Object> rmap = new HashMap<>();
	rmap.put("code",2560);
	rmap.put("name","완수킹");
	rmap.put("loc","근처어딘가");
	testInfo.add(rmap);
	rmap = new HashMap<>();
	rmap.put("code",3560);
	rmap.put("name","전래인");
	rmap.put("loc","아냥어딘가");
	testInfo.add(rmap);
	rmap = new HashMap<>();
	rmap.put("code",5560);
	rmap.put("name","호철갓");
	rmap.put("loc","서울어딘가");
	testInfo.add(rmap);
	Gson g = new Gson();
	String temp = g.toJson(testInfo);
	out.print(temp);
%>