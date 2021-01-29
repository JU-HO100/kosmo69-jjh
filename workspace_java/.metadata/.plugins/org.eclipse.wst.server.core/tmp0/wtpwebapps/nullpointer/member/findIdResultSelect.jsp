<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript">
	function goLogin() {
		location.href="/member/login.jsp";
	}
	function goFindPw() {
		location.href="/findPw.jsp";
	}
	function back() {
		location.href="../findId.jsp";
	}
</script>
</head>
<body>
<table align="center" style="width: 70% ; height: 100%;">
	<tr>
		<td>
			<%@ include file="/loginHeader.jsp"%>
		</td>
	</tr>
	<tr>
		<td>
			<%@ include file="/navbar.jsp"%>
		</td>
	</tr>
	<tr>
		<td style="height: 550px;">
			<%@ include file="/findIdResultContent.jsp" %>
		</td>	
	</tr>
	<tr>
		<td>
			<%@ include file="/footer.jsp" %>
		</td>
	</tr>	
</table>
</body>