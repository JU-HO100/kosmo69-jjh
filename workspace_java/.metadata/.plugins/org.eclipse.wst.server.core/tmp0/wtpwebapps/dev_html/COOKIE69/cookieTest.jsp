<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookie관리[jquery API활용하기]</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- <script src="https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js"></script> --><!-- 리액트용 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<style type="text/css">
	#d_cookie{
		border: 1px solid black;
		background: pink;
		width: 500px;
		height: 250px;
		overflow:auto;
		
	}
</style>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		$("#btn_make").click(function(){
			$.cookie('c_id','tomato');
			//현재 내가 바라보는 경로에서만 유지된다. 즉 COOKIE69안에서만 유지된다. AJAX에서는 유지 불가하다. 왜? path가 다르니까.- path정보를 관리하기 때문에
			$.cookie('c_gender','남자',{expires:1, path:'/dev_html/ajax', domain:'localhost', secure: false});
			/* c_gender의 경우 확인을 할 수가 없다. path가 다르기 때문이다. */
			$.cookie('c_name','이순신',{expires:7, path:'/', domain:'localhost', secure:false});

		});
		$("#btn_update").click(function(){
			$.cookie('c_id','apple');
		});
		$("#btn_delete").click(function(){
			$.cookie('c_id',null);
		});
		$("#btn_move").click(function(){
			location.href="cookieMove.jsp";
		});
		$("#btn_confirm").click(function(){
			$("#d_cookie").append('c_id:'+$.cookie('c_id')+"<br>");
			$("#d_cookie").append('c_gender:'+$.cookie('c_gender')+"<br>");
			$("#d_cookie").append('c_name:'+$.cookie('c_name')+"<br>");
		});
	});
</script>
<div id="d_cookie">쿠키정보 전광판<br><br></div>
<button id="btn_make">쿠키생성</button>
<button id="btn_update">쿠키수정</button>
<button id="btn_delete">쿠키삭제</button>
<button id="btn_move">페이지이동</button>
<button id="btn_confirm">쿠키값 확인</button>


</body>
</html>