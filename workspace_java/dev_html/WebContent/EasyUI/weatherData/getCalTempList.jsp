<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>    
<%@ page import="java.lang.*" %>    
<%@ page import="com.google.gson.Gson" %>    
<%@ page import="web.mvc.*" %> 
<%
 		String sYear = request.getParameter("sYear");
 		String eYear = request.getParameter("eYear");
 		String sMonth = request.getParameter("sMonth");
 		String eMonth = request.getParameter("eMonth");
 		String gubun = request.getParameter("gubun");
 		Map<String,Object> pMap = new HashMap<>();
 		   if(sYear!=null){
 		    	pMap.put("sYear",sYear);
 		    }
 		   if(eYear!=null){
 		    	pMap.put("eYear",eYear);
 		    }
 		   if(sMonth!=null){
 		    	pMap.put("sMonth",sMonth);
 		    }
 		   if(eMonth!=null){
 		    	pMap.put("eMonth",eMonth);
 		    }
 		   if(gubun!=null){
 		    	pMap.put("gubun",gubun);
 		    }
 		   
 	tempDao tDao = new tempDao();
 	List<Map<String,Object>> yearList = tDao.getCalTempList(pMap);
 	Gson g = new Gson();
 	String imsi = g.toJson(yearList); 
 	out.print(imsi);
 %>