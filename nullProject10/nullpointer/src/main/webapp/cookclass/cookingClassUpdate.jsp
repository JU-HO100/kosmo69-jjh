<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String indexNick =  (String)session.getAttribute("nick");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript" src="<%=path.toString() %>js/cookclass.js"></script>
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
				<script type="text/javascript">
				var c_classcd = <%=request.getParameter("c_classcd")%>;
				var id = '<%=(String)session.getAttribute("id")%>';
				$.ajax({
					url : "/cookclass/showClass.np?m_id="+id
					,success : function (result) {
					$.each(result, function (index, item) {
					//table에 출력   
					 if(item.C_CLASSCD == c_classcd){
// 						 alert(c_classcd+id+item.C_COOK+item.C_INGREDIENTS+ item.C_ZIP+item.C_ZIPDETAIL+item.C_DATE+item.MAXPERSONS);
							 var str = '<table style="width:100%;"><tr><td style="width: 80%; border: none;">';
								str += '<ul class="nav nav-tabs"><li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#home">수정</a></li>';
								str +='</ul><div class="tab-content"><div id="home" class="container tab-pane active"  >';
								str +='<form name="cookclassUpdate" action="/cookclass/updClass.np">';
								str +='<br><div class="form-group"><label>제목:</label>';
								str +='<input type="text"  value="'+item.C_COOK+'" class="form-control"  id="c_cook" name="c_cook">';
								str +='<input type="hidden"  value="'+c_classcd+'" class="form-control"  id="c_classcd" name="c_classcd">';
								str +='<input type="hidden"  value="'+id+'" class="form-control"  id="m_id" name="m_id">';
								str +='</div><div class="form-group"><label>준비물:</label>';
								str +='<input type="text" class="form-control"  value="'+ item.C_INGREDIENTS +'"  id="c_ingredients" name="c_ingredients">';
								str +='</div><div class="form-group"><label>실습주소:</label>';
								str +='<input type="text" class="form-control" value="' + item.C_ZIP + '" id="c_zip" name="c_zip">';
								str +='</div><div class="form-group"><label>상세주소:</label>';
								str +='<input type="text" class="form-control" value="' + item.C_ZIPDETAIL + '"  id="c_zipdetail" name="c_zipdetail">';
								str +='</div><div class="form-group"><label>날짜,시간:</label>';
								str +='<input type="datetime-local" class="form-control"  value="'+ item.C_DATE +'"  id="c_date" name="c_date">';
								str +='</div><div class="form-group"><label>수강 최대 인원:</label>';
								str +='<input type="text" class="form-control"  value="' + item.MAXPERSONS + '"  id="c_member" name="c_member">';
								str +='</div><input class="btn btn-outline-dark" type="button" value="쿠킹클래스 수정" onclick="checkUpdate()">'
								str +='</form></div></div></td></tr></table>';
								$('#updateclass').append(str);
								}
							});
						}
					});
				</script>
				<div id="updateclass"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="width: 100%;">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
</table>
</body>
</html>
