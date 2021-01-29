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
   Kakao.Auth.loginFom({
     success: function(authObj) {
//     	alert(JSON.stringify(authObj));

    	// 세션이 종료된 이후에도 토큰을 유지.
// 		persistAccessToken: true,
		// 세션이 종료된 이후에도 refresh토큰을 유지.
// 		persistRefreshToken: true,
		
//     	로그인 성공시, API를 호출합니다.
    	Kakao.API.request({
	 	    url: '/v2/user/me',
	 	    success: function(response) {
	 	    	console.log(response);
// 	    	    user.host = 'kakao'
				kakaoId = rewponse.id; //id
	    	    kakaoMail = response.kakao_account.email; //유저의 이메일
	    	    var user = response.kakao_account //계정 정보
	    	    kakaoNick = response.properties.nickname; //유저가 등록한 별명
	    	    
	    	    console.log(kakaoNick);
	    	    console.log(kakaoMail);
	//  		alert("이름 : "+kakaoNick); //로그인한 유저 이름
	//     	    session.setAttribute("email",kakaoMail);
	//     	    sessionStorage.setItem("email",kakaoMail);
	// 			session.setAttribute("kakaoNick",kakaoNick);
	//     	    sessionStorage.setItem("kakaoNick",kakaoNick);
				
// 				$('').append(html);
//     	    	location.href='/member/index.jsp?'
	 	    
	 	    },
    	    fail: function(error) {
    	        alert("에러1"+JSON.stringify(error));
    	    }
    	});
 	
//    		Kakao.Auth.authorize({
// 			redirectUri: 'http://localhost:9000/member/index.np?kakaoNick='+kakaoNick
// 			redirectUri: 'http://localhost:8000/member/index.np'
// 		});

		},
   	  	fail: function(err) {
   	  		alert("에러2"+JSON.stringify(err));//카카오개발자홈피에 등록이 되지 않았을때 자주 나타남
   	  	
   	  	}
    });
   
//   	alert("ajax test");	
// 	$.ajax({
// 		url:'../a.jsp?s_name='+kakaoNick
//        ,success:function(data){
// //     	   alert("data:"+data);
//     	   $("#d_test").text(data);
//        }
// 	});
	
</script>
<!-- =============================== 카카오 로그인 ================================================== -->
<!-- =============================== 카카오 로그아웃 ================================================== -->
<!-- <a href="http://developers.kakao.com/logout"></a> -->

<!-- =============================== 카카오 로그아웃 ================================================== -->

</body>
</html>