<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../../common/easyui_common.jsp" %>
<style type="text/css">
	div#d_news{
		position: absolute; /* 원하는 위치에 정의 */
	}
</style>
<script type="text/javascript">
	function autoReload(){
// 		alert("autoReload 호출");
		$.ajax({
			url:'jsonNewslist.jsp?'
			,data:'post'
			,dataType:'html'
			,success:function(data){
// 				alert("서버에서 가져오는 뉴스 정보");
				$("#d_news").html(data);//html 태그는 번역, 내용만 출력
			}
			,error:function(e){
				$("d_msg").show();
				$("#d_msg").text(e.responseText);
			}
		});//////////////////////// end of ajax
		$("#d_news").css("left","300px");
		$("#d_news").css("top","100px");
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function () {
		$("d_msg").hide();
		var watch;
		function start(){
			watch = setInterval(autoReload, 10000);/* 원하는 시간만큼 정의 */
		}/////////////////////////////////// end of start
		function stop(){
			setTimeout(function(){
				clearInterval(watch);
			},100000);
		}///////////////////////////////////// end of stop
		start();
		stop();
	});
</script>
<h3>자동 갱신 페이지 구현</h3>
<!-- 뉴스 목록이 출력될 위치(좌표값 이용 원하는 위치 -css) -->
<div id="d_news" width="250px" height="50px">1</div>
<div id="d_msg" width="400px" height="200px" border="1"></div>

</body>
</html>