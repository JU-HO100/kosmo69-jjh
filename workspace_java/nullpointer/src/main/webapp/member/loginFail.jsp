<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<% String msg = (String)request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<script type="text/javascript">
	alert("<%=msg%>");
	if(msg != null){
		alert("<%=msg%>");
		location.href="./index.jsp";
	}else{
		alert("로그인에 실패하였습니다");
		location.href="./index.jsp";
	}
</script>
</body>
</html>
