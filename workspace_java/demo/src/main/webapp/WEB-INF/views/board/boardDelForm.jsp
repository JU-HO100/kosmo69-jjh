<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/easyUI_common.jsp" %>
<%
	//easyui 공통코드 넣어주기.
	//앞의 화면에서 결정된 정보를 받아오기
	//insert here
	String pbm_no = request.getParameter("bm_no");
	String pbm_pw = request.getParameter("bm_pw");

%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
</head>
<body>
<div style="margin-boattom:20px">
	<input id="u_pw" name="u_pw" class="easyui_textbox" label="비밀번호" style="width:200px;height:25px">

</div>
</body>
</html>