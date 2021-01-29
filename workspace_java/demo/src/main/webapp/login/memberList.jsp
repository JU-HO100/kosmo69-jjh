<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List , java.util.Map" %>

<!-- /login/memberList.sp2 ==> login/memberList.jsp
그러나 forward이니까 주소 URL은 바뀌지 않는다.
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 페이지</title>
</head>
<body>
회원목록 페이지
<%
	List<Map<String,Object>> memList =
		(List<Map<String,Object>>)request.getAttribute("memList");
	out.print(memList);
%>
</body>
</html>