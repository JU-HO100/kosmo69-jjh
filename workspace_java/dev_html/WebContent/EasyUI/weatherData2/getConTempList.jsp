<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>    
<%@ page import="java.lang.*" %>    
<%@ page import="com.google.gson.Gson" %>    
<%@ page import="web.mvc.tempDao2" %> 
<%
 	String gubun = request.getParameter("gubun");
 	String eYear = request.getParameter("eYear");
 	String sYear = request.getParameter("sYear");
 	String search = request.getParameter("search");
 	Map<String,Object> pmap = new HashMap<>();
 		if(gubun!=null){
 	pmap.put("gubun",gubun);
 		}
 		if(eYear!=null){
 	pmap.put("eYear",eYear);
 		}
 		if(sYear!=null){
 	pmap.put("sYear",sYear);
 		}
 		if(search!=null){
 	pmap.put("search",search);
 		}
 	
 	tempDao2 tDao = new tempDao2();
 	List<Map<String,Object>> yearList = tDao.getConTempList(pmap);
 	Gson g = new Gson();
 	String imsi = g.toJson(yearList); 
 	out.print(imsi);
 %>