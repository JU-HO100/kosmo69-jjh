<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>    
<%@ page import="java.lang.*" %>    
<%@ page import="com.google.gson.Gson" %>    
<%@ page import="web.mvc.*" %> 
<%
 	tempDao2 tDao = new tempDao2();
 	List<Map<String,Object>> yearList = tDao.getYearList();
 	Gson g = new Gson();
 	String imsi = g.toJson(yearList); 
 	out.print(imsi);
 %>