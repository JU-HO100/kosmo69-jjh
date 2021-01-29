<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제하기</title>
</head>
<body>
<%
	Cookie c_dap1 = new Cookie("c_dap1","");
	Cookie c_dap2 = new Cookie("c_dap2","");
	Cookie c_dap3 = new Cookie("c_dap3","");
	c_dap3.setMaxAge(0);
	response.addCookie(c_dap3);
%>
</body>
</html>