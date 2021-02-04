<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript">
	function findPwAction() {
		//아이디 공백 확인
		    if($("#M_ID").val() == ""){
		      alert("아이디 입력바람");
		      $("#M_ID").focus();
		      return false;
		    }
		 //전화번호 공백 확인
		    if($("#m_hp").val() == ""){
		      alert("전화번호를 입력해주세요");
		      $("#m_hp").focus();
		      return false;
		    }
		//메일 공백 확인
		    if($("#m_mail").val() == ""){
		      alert("메일을 입력해주세요");
		      $("#m_mail").focus();
		      return false;
		    }
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
			<%@ include file="/findPwContent.jsp" %>
		</td>	
	</tr>
	<tr>
		<td>
			<%@ include file="/footer.jsp" %>
		</td>
	</tr>	
</table>
</body>