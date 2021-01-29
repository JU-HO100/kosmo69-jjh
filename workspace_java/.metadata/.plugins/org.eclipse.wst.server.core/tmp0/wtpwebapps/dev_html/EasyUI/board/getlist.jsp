<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.mvc.BbsDAO, java.util.*"%>
<%@ page import="com.google.gson.Gson" %>
<%
	BbsDAO bdao = new BbsDAO();
	List<Map<String,Object>> blist = bdao.getBbsList();
	
	Gson g = new Gson();
	String imsi = g.toJson(blist);
	out.print(imsi);
%>