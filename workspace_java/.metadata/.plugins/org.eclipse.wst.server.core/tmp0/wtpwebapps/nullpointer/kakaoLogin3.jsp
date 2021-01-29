<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>  
<%@ page import="java.util.*" %>
<%
	//response.setIntHeader("Refresh",5);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 로그인</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
<!-- =============================== 카카오 로그인 ================================================== -->
<div id="kakao-login-btn"></div>
<!-- <div id="d_test">d_test</div> -->
<script type='text/javascript'>
	var kakaoNick = "";
	var kakaoMail = "";
	var Token = "";
//     <![CDATA[
   // 사용할 앱의 JavaScript 키를 설정해 주세요.
   Kakao.init('f61c36ee28b1fe4d00e270bcf75d344d');
//    kakao.isInitialized();
   // 카카오 로그인 버튼을 생성합니다.
   Kakao.Auth.createLoginButton({
     container: '#kakao-login-btn',
     success: function(authObj) {
//     	alert(JSON.stringify(authObj));
		persistAccessToken: true,
//     	로그인 성공시, API를 호출합니다.
    	Kakao.API.request({
	 	    url: '/v2/user/me',
	 	    success: function(result) {
    	    var user = result.kakao_account //계정 정보
			Token = Kakao.Auth.getAccessToken(); //토큰 생성
    	    Kakao.Auth.setAccessToken(Token); //토큰 등록
    	    var name = result.properties.nickname;
    	    alert("name : "+name);
    	    
    	    
    	    },
    	    fail: function(error) {
    	        alert("에러1"+JSON.stringify(error));
    	        console.log('1 - 카카오톡 연결 실패!');
    	    }
    	});
    	
//      		Kakao.Auth.authorize({
// 				redirectUri: 'http://192.168.0.38:8000/member/index.np'
// 			});

    	  },
    	  fail: function(err) {
    	  	alert("에러2"+JSON.stringify(err));//카카오개발자홈피에 등록이 되지 않았을때 자주 나타남
    	  	console.log('2 - 카카오톡 연결 실패!')
    	  }
    });
  
//   	alert("ajax test");	
// 	$.ajax({
// 		url:'../a.jsp?s_name='+kakaoNick
//        ,success:function(data){
//     	   alert("data:"+data);
//     	   $("#d_test").text(data);
//        }
// 	});
	
</script>
<!-- =============================== 카카오 로그인 ================================================== -->
<!-- =============================== 카카오 로그아웃 ================================================== -->
<a href="http://developers.kakao.com/logout"></a>

<!-- =============================== 카카오 로그아웃 ================================================== -->

</body>
</html>