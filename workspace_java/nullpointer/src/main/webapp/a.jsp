<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String s_name = request.getParameter("s_name");
	session.setAttribute("s_name",s_name);
// 	out.print("세션이름:"+s_name);
%>