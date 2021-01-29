<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.mvc.BbsDAO" %>
	<%
		request.setCharacterEncoding("utf-8"); // post 방식으로 전달된 값의 인코딩 타입 설정
	%>

<jsp:useBean id="board" class="web.mvc.BbsDAO" />
<jsp:setProperty property="*" name="board" />

<%
	BbsDAO bdao = new BbsDAO();
%>
<script>
	alert("입력 완료");
	location.href = "list.jsp";
</script> 
	
%>