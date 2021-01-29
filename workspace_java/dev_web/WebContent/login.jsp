<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//스크립틀릿 -- 이안에 자바코드를 써도 된다.
	String user_id = request.getParameter("mem_id");
	out.print("<b>"+user_id+"</b>");
%>