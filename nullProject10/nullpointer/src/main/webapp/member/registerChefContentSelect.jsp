<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<% String id = (String)session.getAttribute("id"); %>
<% String msg = (String)request.getAttribute("msg"); %>
<script type="text/javascript" src="<%=path.toString() %>js/mypage.js"></script>
<script type="text/javascript">
function registerChefContent(){
	location.href="/member/popRecipeNum.np?m_id=<%=id%>";
  }
</script>
<title>오늘 뭐 먹지?</title>
</head>
<body>
<%if(msg.equals("3개이상")){ %>
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
					 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="reload()">회원정보 수정</button>
					 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="cookingClassCheckContent()">쿠킹클래스 확인</button>
					 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="registerChefContent()">셰프 등록</button>
					 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="memberOutContent()">회원 탈퇴</button>
				</div>
			</td>
			<td style="width: 70%; padding-top:3% ;padding-left: 5%; padding-right: 5%;">
			<div  id="tb_ajax">
			<form name="joinchef" method="get" action="/member/submitResume.np">
				<table align="center" style="width: 70%; ">
					<tr style="height: 50px;">
						<td>
							자기소개서
						</td>
					</tr>
					<tr>
						<td>주력 요리:
							<div class="easyui-panel" style="width: 20%; max-width: 400px;" >
								<select class="easyui-combobox" name="main_food"  id="main_food" style="width: 100%;">
									<option value="한식" >한식</option>
									<option value="중식">중식</option>
									<option value="일식">일식</option>
									<option value="양식">양식</option>
								</select>
							</div>
						</td>
					</tr>	
					<tr>
						<td>
							ex) 지역, 주로 하시는 요리
						</td>
					</tr>
					<tr>
						<td style="margin-top: 4%">
							<textarea rows="8" cols="70" id="writting" name="writting"></textarea>
						</td>
					</tr>
					<tr>
						<td style="text-align: right;">
							<input class="btn btn-outline-dark" type="reset" value="다시 작성">
							<input class="btn btn-outline-dark" type="button" value="등록" onclick="joinChefCheck()">
							<input type="hidden"  id="m_id" name="m_id" value="<%=id%>">
						</td>
					</tr>	
				</table>	
			</form>
			</div>
		</td>
	</tr>
				<!-- Footer -->
		<tr>
			<td colspan="2">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
</table>
<%}else{ %>
 <script type="text/javascript">
 	alert("셰프 등록 권한이 없습니다(인기 게시물 3개 이상).");
 	history.go(-1);
 </script>
<%} %>
</body>
</html>