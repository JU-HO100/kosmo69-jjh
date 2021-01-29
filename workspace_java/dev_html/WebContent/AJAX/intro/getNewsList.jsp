<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ajax.news.NewsLogic"%>
<%@page import="java.util.List, java.util.Map" %>
<%@page import="com.google.gson.Gson" %>
<%
	NewsLogic nl = new NewsLogic();
	List<Map<String,Object>> newsList = nl.getNewsList();
	Gson g = new Gson();
	String imsi = g.toJson(newsList);
	out.print(imsi);

%>