<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, web.mvc.*" %>
<%@ page import="com.google.gson.Gson" %>
<% 
	Map<String,Object> pmap = new HashMap<>();
	String zdo = request.getParameter("zdo");
	String dong = request.getParameter("dong");
	dong = "가산";
// 	if("zdo".equals(zdo)){
// 		pmap.put("zdo",zdo);	
// 	} else 
	if("dong".equals(dong)){
		pmap.put("dong",dong);
	}
	
	
	
	ZipCodeDao zDao = new ZipCodeDao();
// 	List<Map<String,Object>> zList = zDao.getZipCodeList(dong);
	List<Map<String,Object>> zList = zDao.getAddress(pmap);
	Gson g = new Gson();
	String imsi = g.toJson(zList);
	out.print(imsi);
	
%>
