<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("id"); %>
<%String indexNick =  (String)session.getAttribute("nick");%>
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
			
			<!-- Content -->
		<tr>
			<td style="width: 19%; vertical-align: top;">
				<div class="btn-group-vertical" style="width: 100%; margin-top: 12%">
					 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="reload()">쿠킹 클래스 신청</button>
					 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="location.href='/member/checkChef.np?m_id=<%=id%>'">쿠킹 클래스 등록</button>
				</div>
			</td>
			<td style="width: 70%; padding-top:3% ;padding-left: 5%; padding-right: 5%;">
<table style="width: 100%">
	<tr>
		<td style="width: 80%; border: none;">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"
						data-toggle="tab" href="#home">등록</a></li>
				</ul>
				<div class="tab-content">
					<div id="home" class="container tab-pane active"  >
					<form name="cookclassRegister" action="/cookclass/createClass.np" method="get">
					<input type="hidden" id="m_id" name="m_id" value="<%=session.getAttribute("id")%>">
						<br>
						<div class="form-group">
							<label>제목:</label>
							 <input type="text"  value="어어엄청나게 맛있는 볶음밥" class="form-control" placeholder="어떤 요리인지 알 수 있도록 입력해 주세요. ex)누구나 쉽게 배울 수 있는 김치찜"  id="c_cook" name="c_cook">
						</div>
						<div class="form-group">
							<label>준비물:</label> 
							<input type="text" class="form-control"  value="밥,기름,파,베이컨,계란,다진마늘,후추,소금,설탕" placeholder="요리에 필요한 준비물을 입력해주세요."  id="c_ingredients" name="c_ingredients">
						</div>
						<div class="form-group">
							<label>실습주소:</label>
							 <input type="text" class="form-control" value="인천광역시 부평구 선청동 240-1" placeholder="실습주소를 입력해주세요." id="c_zip" name="c_zip">
						</div>
						<div class="form-group">
							<label>상세주소:</label>
							 <input type="text" class="form-control" value="oo아파트 00동 000호" placeholder="상세주소를 입력해주세요." id="c_zipdetail" name="c_zipdetail">
						</div>
						<div class="form-group">
							<label>날짜,시간:</label>
							 <input type="datetime-local" class="form-control"  value="2021-01-22 오후 03:17" placeholder="실습날짜를 입력해주세요." id="c_date" name="c_date">
						</div>
						<div class="form-group">
							<label>수강 최대 인원:</label>
							 <input type="text" class="form-control"  value="4" placeholder="수강 최대 인원을 입력해주세요." id="c_member" name="c_member">
						</div>
						<input class="btn btn-outline-dark" type="button" value="쿠킹클래스 등록" onclick="check()">
					</form>
					</div>
				</div>
		</td>	
	</tr>
</table>
<tr>
			<td colspan="2" style="width: 100%;">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
</table>
</body>
</html>
