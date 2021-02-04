<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 먹지?</title>
<%@ include file="/common/bootstrap_common.jsp"%>
<%String indexNick =  (String)session.getAttribute("nick");%>
<script type="text/javascript">
function logout() {
	location.href="/member/logout.jsp";
}
</script>
</head>
<body>
<table align="center" style="width: 70% ; height: 100%;">
			<!-- Header -->
		<tr>
			<%if(indexNick!=null && indexNick.equals("총관리자")){ %>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/adminHeader.jsp"%>
			</td>		
			<%}else if(indexNick!=null && indexNick.length() >0 && ! indexNick.equals("총관리자")){ %>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/loginOkHeader.jsp"%>
			</td>
			<%}else{ %>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/header.jsp"%>
			</td>
			<%} %>
		</tr>
			<!-- END Header -->
			
			<!-- NavBar -->
		<tr>
			<td style="width: 100%;">
				<%@ include file="/navbar.jsp" %>
			</td>
		</tr>
			<!-- END NavBar -->
		<tr>
			<td>
				<%@ include file="/recipe/recommendationContent.jsp" %>
			</td>		
		</tr>
			<!-- Footer -->
		<tr>
			<td style="padding-top: 8%">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
	</table>
</body>
</html>