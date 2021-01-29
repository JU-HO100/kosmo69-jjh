<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, web.mvc.ZipCodeDao" %>
<%@ page import="com.google.gson.Gson" %>
<%

	ZipCodeDao zdao = new ZipCodeDao();
	List<Map<String,Object>> zList = zdao.getZdo();
	Gson g = new Gson();
	String imsi = g.toJson(zList);
	out.print(imsi);
%>

