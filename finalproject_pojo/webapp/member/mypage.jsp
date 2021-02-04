<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<% String id = (String)session.getAttribute("id"); %>
<script type="text/javascript" src="<%=path.toString() %>js/mypage.js"></script>
<script type="text/javascript">
function registerChefContent(){
	location.href="/member/popRecipeNum.np?m_id=<%=id%>";
  }
function check() {
	//아이디 공백 확인
    if($("#m_id").val() == ""){
      alert("아이디 입력바람");
      $("#m_id").focus();
      return false;
    }
  //비밀번호 공백 확인
    if($("#m_pw").val() == ""){
      alert("비밀번호를 입력해주세요");
      $("#m_pw").focus();
      return false;
    }
   if($("#m_id").val()!="<%=id%>"){
    alert("탈퇴할 아이디와 로그인한 아이디가 다릅니다.");
    $("#m_id").focus();
    return false;
   }
    memberOutForm.submit();
}
</script>
<title>오늘 뭐 먹지?</title>
</head>
<body>
	<table align="center" style="width: 70% ; height: 100%;">
			<!-- Header -->
		<tr>
			<%if(session.getAttribute("nick")!=null){ %>
			<td colspan="2" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/loginOkHeader.jsp"%>
			</td>
			<%}else{ %>
			<td colspan="2" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/header.jsp"%>
			</td>
			<%} %>
		</tr>
			<!-- END Header -->
			
			<!-- NavBar -->
		<tr>
			<td colspan="2" style="width: 100%;">
				<%@ include file="/navbar.jsp" %>
			</td>
		</tr>
			<!-- END NavBar -->
			
			<!--  Mypage -->
		<tr>
			<td style="width: 19%; vertical-align: top;">
				<div class="btn-group-vertical" style="width: 100%; margin-top: 12%">
					 <button type="button" class="btn btn-outline-dark" style="text-align: left; white-space: nowrap;" onclick="reload()">회원정보 수정</button>
					 <button type="button" class="btn btn-outline-dark" style="text-align: left; white-space: nowrap;" onclick="cookingClassCheckContent()">쿠킹클래스 확인</button>
					 <button type="button" class="btn btn-outline-dark" style="text-align: left; white-space: nowrap;" onclick="registerChefContent()">셰프 등록</button>
					 <button type="button" class="btn btn-outline-dark" style="text-align: left; white-space: nowrap;" onclick="memberOutContent()">회원 탈퇴</button>
				</div>
			</td>
			<td style="width: 70%; padding-top:3% ;padding-left: 5%; padding-right: 5%;">
				<div  id="tb_ajax" >
					<script type="text/javascript">
					    $.ajax({
						      type : "GET",
						      url : "/member/myPage.np?m_id="+"<%=id%>",
						      dataType : "text",
						      success : function(data) {
						        $('#tb_ajax').html(data);
						      },
						      error : function() {
						        alert('통신실패!!');
						      }
						    });
					</script>
				</div>
			</td>
		</tr>
			<!-- END Mypage -->
			
			<!-- Footer -->
		<tr>
			<td colspan="2">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
	</table>
</body>
</html>