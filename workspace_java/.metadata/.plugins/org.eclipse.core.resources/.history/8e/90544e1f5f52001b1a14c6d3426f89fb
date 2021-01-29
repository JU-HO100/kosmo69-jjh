<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript">
	function findIdAction() {
		//이름 공백 확인
		 if($("#M_NAME").val() == ""){
		      alert("이름 입력바람");
		      $("#M_NAME").focus();
		      return false;
		    }
		//생년월일 공백 확인
		    if($("#M_BIRTH").val() == ""){
		      alert("생년월일을 입력해주세요");
		      $("#M_BIRTH").focus();
		      return false;
		    }
	}
</script>
</head>
<body>
<table align="center" style="width: 70% ; height: 100%;">
	<tr>
		<td>
			<%@ include file="./loginHeader.jsp"%>
		</td>
	</tr>
	<tr>
		<td>
			<%@ include file="./navbar.jsp"%>
		</td>
	</tr>
	<tr>
		<td style="height: 550px;">
			<%@ include file="./findIdContent.jsp" %>
		</td>	
	</tr>
	<tr>
		<td>	
			<%@ include file="./footer.jsp" %>
		</td>
	</tr>	
</table>
</body>