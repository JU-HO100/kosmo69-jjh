<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>    
<%@ page import="java.lang.*" %>    
<%@ page import="com.google.gson.Gson" %>    
<%@ page import="web.mvc.*" %> 
<%
 	tempDao tDao = new tempDao();
 	List<Map<String,Object>> tempList = tDao.getTempList();
 	Gson g = new Gson();
 	String imsi = g.toJson(tempList); 
 	out.print(imsi);
 %>