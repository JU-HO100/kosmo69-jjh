<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String id = (String)session.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 먹지?</title>
<%@ include file="/common/bootstrap_common.jsp"%>
<script type="text/javascript" src="<%=path.toString() %>js/registerRecipe.js"></script> 
<script type="text/javascript">
function logout() {
	location.href="/member/logout.jsp";
}
var g_i=0;
function del(data){
	for(var x=0;x<g_i;x++){
		if(x==data){
			$("#d"+x).text("");
		}
	}
}
function adjustHeight() {
	  var textEle = $('textarea');
	  textEle[0].style.height = 'auto';
	  var textEleHeight = textEle.prop('scrollHeight');
	  textEle.css('height', textEleHeight);
	};
function add(){
	var cnt = 0;
	//g_i = g_i + 1;
	$.ajax({
		//url:'b.jsp',
		success:function (data){
			$("#g_main").append("<div id=d"+g_i+">"
			+"<table class='table' style='width:80%' align='center'><tr><td colspan='2' style='border:none'><p style='font-family: Jua', sans-serif;'>조리법</p><textarea class='form-control' onkeyup='adjustHeight();'style='overflow: hidden;width:100%' placeholder='해당 순서의 조리법을 작성해주세요.' name='recipe' id='recipe'></textarea></td></tr><tr><td><p style='font-family: Jua', sans-serif;'>조리법 사진</p></td><td><input type='file'  name='sub_img'></td></tr><tr><td colspan='3'><input type='button' class='btn btn-outline-danger' style='float:right' value='삭제' onClick='del("+g_i+")'></td></tr></table></div><br>");
			g_i=g_i+1;
		}
	});
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
<%if(id!=null){ %>
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
		</tr>			<!-- END Header -->
			
			<!-- NavBar -->
		<tr>
			<td style="width: 100%;">
				<%@ include file="/navbar.jsp" %>
			</td>
		</tr>
			<!-- END NavBar -->
			<!-- Content -->
		<tr>
			<td style="padding-top: 5%; text-align: center" >
				<%@include file="/registerRecipeContent.jsp" %>
			</td>
		</tr>
			<!-- End Content -->	
			<!-- Footer -->
		<tr>
			<td style="padding-top: 8%">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
	</table>
	<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
	<%}else{ %>
	<script type="text/javascript">
		alert("로그인 후 레시피를 등록해주세요");
		history.go(-1);
	</script>
	<%} %>
</body>
</html>