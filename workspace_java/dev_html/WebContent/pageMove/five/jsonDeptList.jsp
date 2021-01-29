<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*"%>
<%@ page import="com.google.gson.Gson"%>
<%
	List<Map<String,Object>> deptList = null;
	deptList = (List<Map<String,Object>>)request.getAttribute("deptList");
	Gson g = new Gson();
	String imsi = g.toJson(deptList);
	out.print(imsi);
%>