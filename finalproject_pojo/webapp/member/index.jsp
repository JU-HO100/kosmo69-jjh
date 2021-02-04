<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 먹지?</title>
<%@ include file="/common/bootstrap_common.jsp"%>
<%String indexNick =  (String)session.getAttribute("nick");%>
<script>
//Get the button
var mybutton = document.getElementById("myBtn");

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}

function logout() {
		location.href="/member/logout.jsp";
}
</script>
<style>
#myBtn {
  position: fixed;
  bottom: 45px;
  right: 45px;
  z-index: 99;
  font-size: 18px;
  border: 1px solid black;
  outline: none;
  background-color: white;
  color: black;
  cursor: pointer;
  padding: 15px;
  border-radius: 8px;
}

</style>

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
			<td colspan="3" style="width: 100%;">
				<%@ include file="/navbar.jsp" %>
			</td>
		</tr>
			<!-- END NavBar -->
			
			
			<!-- Carousel -->
		<tr>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/carousel.jsp"%>
			</td>
		</tr>
			<!-- End Carousel -->
			
			
			
			<!--  Carousel 2 -->
		<tr>
			<td colspan="3" style="width: 100%;">
				<%@ include file="/carousel2.jsp"%>
			</td>
		</tr>
			<!-- End Carousel 2 -->
			<!-- Content -->
		<tr>
<!-- 			<td style="width: 55%"> -->
<%-- 				<%@ include file="/content.jsp" %> --%>
<!-- 			</td> -->
			<td style="width: 100%;">
				<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: px;">좋아요 분포도</h1>
				<table class="table">
					<tr>
						<td>
							<%@ include file="/member/google1.jsp" %>
						</td>
						<td>
							<%@ include file="/member/google2.jsp" %>
						</td>
					</tr>
				</table>
			</td>
		</tr>
			<!-- End Content -->
			
			<!-- Footer -->
		<tr>
			<td colspan="3" style="padding-top: 8%">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
	</table>
	<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
</body>
</html>