<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String msg = (String)request.getAttribute("msg"); %>
<% String nick = (String)session.getAttribute("nick"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
<%if(msg.equals("닉네임이 이미 존재합니다") || msg.equals("패스워드가 틀렸습니다")){%>
alert("<%=msg%>");
location.href="/member/mypage.jsp";
<%}else{%>
location.href="/member/index.jsp";
<%}%>
</script>
</body>
</html>