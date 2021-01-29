<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map , java.util.List"%>>
<%@ page import="com.google.gson.Gson" %>>
<%
	List<Map<String,Object>> loginList = new ArrayList<>();
	Map<String,Object> pmap = new HashMap<>();
	String id = getInitParameter("id");
	String pw = getInitParameter("pw");
	if(id.length()>0 || pw.length()>0){
		pmap.put("id", id);
		pmap.put("pw", pw);
	}
	Gson g = new Gson();
	
%>