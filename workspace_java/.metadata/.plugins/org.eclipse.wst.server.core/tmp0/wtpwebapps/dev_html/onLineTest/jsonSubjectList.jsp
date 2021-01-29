<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List , java.util.Map" %>
<%@ page import="com.google.gson.Gson" %>
<%
	List<Map<String,Object>> subList = null;
	subList = (List<Map<String,Object>>)request.getAttribute("subList");
	String imsi = null;
	if(subList.size()>0){
		Gson g = new Gson();
		imsi = g.toJson(subList);
	}
	else {
		imsi="";
	}
	out.print(imsi);
%>