<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String msg = (String)request.getAttribute("msg"); %>
<% String nick = (String)session.getAttribute("nick"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<script>
<%if(msg.equals("정상적으로 탈퇴되었습니다")){%>
alert("<%=msg%>");
location.href="/member/index.jsp";
<%}else{%>
alert("<%=msg%>");
history.go(-1);
<%}%>
</script>
</body>
</html>