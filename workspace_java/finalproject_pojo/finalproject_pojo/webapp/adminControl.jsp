<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript" src="<%=path.toString() %>js/admin.js"></script>
</head>
<body>

	<table align="center" style="width: 100%;">
		<tr>
			<td>
			    <div class="easyui-tabs" style="width:100%;height:1000px;">
			        <div title="회원관리">
			        	<%@include file="./memberControlContent.jsp" %>
			        </div>
			        <div title="게시판 관리">
			        	<%@ include file="./boardControlContent.jsp" %>
			        </div>
			        <div title="쿠킹클래스 관리">
			        	<%@ include file="./cookingClassControlContent.jsp" %>
		  	     	</div>
		    	</div>
		    </td>
		</tr>
	</table>
</body>
</html>