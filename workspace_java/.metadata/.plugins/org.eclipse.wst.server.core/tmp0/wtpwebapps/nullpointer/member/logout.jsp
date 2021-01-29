<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<script>
	location.href="http://developers.kakao.com/logout";
	location.href="http://nid.naver.com/nidlogin.logout";
</script>
<%
	response.sendRedirect("./index.jsp");
%>