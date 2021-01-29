<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String isPass = request.getParameter("isPass");
	out.print(isPass);
	boolean b_pass = Boolean.parseBoolean(isPass);
	if(b_pass){
		out.print("당신은 합격하였습니다.");
	} else{
		out.print("당신은 불합격하였습니다.");
	}
	
	
%>