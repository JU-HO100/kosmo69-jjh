<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<% List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("list");%>
<%
String aa = list.get(0).toString();
out.print(aa);
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>