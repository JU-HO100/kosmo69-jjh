<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>    
<%@ page import="java.lang.*" %>    
<%@ page import="com.google.gson.Gson" %>    
<%@ page import="web.mvc.*" %> 
<%
 		String startYear = request.getParameter("startYear");
 		String endYear = request.getParameter("endYear");
 		String startMonth = request.getParameter("startMonth");
 		String endMonth = request.getParameter("endMonth");
 		String ondogubun = request.getParameter("ondogubun");
 		String underover = request.getParameter("underover");
 		String value = request.getParameter("value");
 		Map<String,Object> pMap = new HashMap<>();
 		
 		   if(startMonth!=null){
 		    	pMap.put("startMonth",startMonth);
 		    }
 		   if(endMonth!=null){
 		    	pMap.put("endMonth",endMonth);
 		    }
 		   if(ondogubun!=null){
 		    	pMap.put("ondogubun",ondogubun);
 		    }
 		   if(underover.equals("이상")){
 		    	pMap.put("underover","이상");
 		    } else if(underover.equals("이하")){  // null이면 이하고 !=null 이면 이상이다
 		    	pMap.put("underover", null);
 		    }
 		   if(value!=null){
 		    	pMap.put("value",value);
 		    }
 	tempDao tDao = new tempDao();
 	List<Map<String,Object>> yearList = tDao.getConTempList(pMap);
 	Gson g = new Gson();
 	String imsi = g.toJson(yearList); 
 	out.print(imsi);
 %>