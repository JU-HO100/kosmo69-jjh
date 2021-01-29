<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<script>
	alert("로그아웃 되었습니다");
</script>
	<a href="http://developers.kakao.com/logout"></a>
<%
	response.sendRedirect("./index.jsp");
%>