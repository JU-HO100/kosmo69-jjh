<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String user = (String)session.getAttribute("kakaoUser");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b페이지</title>
</head>
<body>
빈 페이지
이름은 : <%=user %>

</body>
</html>