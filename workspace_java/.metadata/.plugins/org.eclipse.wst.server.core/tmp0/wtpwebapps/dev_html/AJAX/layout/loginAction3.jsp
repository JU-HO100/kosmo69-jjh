<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String db_id = "test";
	String db_pw = "123";
	String db_name = "이순신";
	String msg = null;
	String u_id = request.getParameter("mem_id");
	String u_pw = request.getParameter("mem_pw");
	if(u_id.equals(db_id)){
		if(u_pw.equals(db_pw)){
			msg= db_name+"님 환영합니다.";
		} else {
			msg="비밀번호가 맞지않습니다.";
		}
	} else {
		msg="아이디가 존재하지 않습니다.";
	}
	
%>
<%=msg %>
