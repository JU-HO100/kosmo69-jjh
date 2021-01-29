<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String MSG = (String)request.getAttribute("msg"); %>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 먹지?</title>
</head>
<body>
<table align="center" >
	<tr>
		<td>
			<%=MSG %>
		</td>	
	</tr>
</table>
</body>