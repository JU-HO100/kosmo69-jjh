<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>  
<%
	//response.setIntHeader("Refresh",5);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 로그인</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script> -->
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
<!-- =============================== 카카오 로그인 ================================================== -->
<div id="kakao-login-btn"></div>
<!-- <div id="d_test">d_test</div> -->
<script type='text/javascript'>
	var kakaoNick = "";
	var kakaoMail = "";
//     <![CDATA[
   // 사용할 앱의 JavaScript 키를 설정해 주세요.
	   Kakao.init('15f5287d753e527b86e1f231f7128313');
	   
	   // 카카오 로그인 버튼을 생성합니다.
	   Kakao.Auth.createLoginButton({
	     container: '#kakao-login-btn',
	     success: function(authObj) {
	//     	alert(JSON.stringify(authObj));
	
	//     	로그인 성공시, API를 호출합니다.
	    	Kakao.API.request({
		 	    url: '/v2/user/me',
		 	    success: function(response) {
		    	    var user = response.kakao_account //계정 정보
		    	    kakaoMail = response.kaccount_email;   //유저의 이메일
		    	    kakaoNick = response.properties.nickname; //유저가 등록한 별명
	
// 		     		Kakao.Auth.authorize({
// 						redirectUri: 'http://192.168.0.38:8000/kLogin.np?s_name='+kakaoNick
// 						redirectUri: 'http://192.168.0.38:8000/kLogin.np'
// 					});
		    	    
		    	    $.ajax({
		    	    	url:"/kLogin.np?s_name="+kakaoNick
		    	    	,success: function(data) {
		    	    		alert("data"+data);
		    	    	}
		    	    });
	    	    },
	    	    fail: function(error) {
	    	        alert("에러1"+JSON.stringify(error));
	    	    }
	    	});
// 			alert(kakaoNick);
	
	
	    	  },
	    	  fail: function(err) {
	    	  	alert("에러2"+JSON.stringify(err));//카카오개발자홈피에 등록이 되지 않았을때 자주 나타남
	    	  	
	    	  }
	    });
   
	
</script>
<!-- =============================== 카카오 로그인 ================================================== -->
<!-- =============================== 카카오 로그아웃 ================================================== -->
<a href="http://developers.kakao.com/logout"></a>

<!-- =============================== 카카오 로그아웃 ================================================== -->

</body>
</html>