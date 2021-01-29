<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sendRedirect</title>
<script type="text/javascript">
<%
	response.sendRedirect("b.jsp");
	out.print("그냥 사라진다.");
%>
</script>
</head>
<body>
sendRedirect 1번화면
</body>
</html>