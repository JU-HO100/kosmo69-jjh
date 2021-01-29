<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹서버에서 쿠키 생성하기</title>
</head>
<body>
<%
	Cookie c_dap1 = new Cookie("c_dap1", "3");
	c_dap1.setDomain("Http://192.168.0.38:9000/cookie");
	c_dap1.setMaxAge(60*60);
	response.addCookie(c_dap1);
	Cookie c_dap2 = new Cookie("c_dap2", "1");
	c_dap2.setMaxAge(60*60);
	response.addCookie(c_dap2);
	Cookie c_name = new Cookie("c_name",URLEncoder.encode("이순신"));
	c_name.setMaxAge(60*60);
	response.addCookie(c_name);
	
%>
</body>
</html>