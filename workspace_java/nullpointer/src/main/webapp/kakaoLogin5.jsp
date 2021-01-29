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
    <a href="https://kauth.kakao.com/oauth/authorize?client_id=15f5287d753e527b86e1f231f7128313&redirect_uri=http://192.168.0.38:8000/kLogin.np&response_type=code">
          <img src="https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile28.uf.tistory.com%2Fimage%2F99BEE8465C3D7D12140EAC">
    </a>
    
<!-- <div id="d_test">d_test</div> -->


<script type='text/javascript'>
	Kakao.init('15f5287d753e527b86e1f231f7128313');
   	console.log(Kakao.isInitialized());
   	// 카카오 로그인 버튼을 생성합니다.
   	Kakao.Auth.createLoginButton({
		container: '#kakao-login-btn',
		success: function(authObj) {
//     	alert(JSON.stringify(authObj));

    	// 세션이 종료된 이후에도 토큰을 유지.
		persistAccessToken: true,
		// 세션이 종료된 이후에도 refresh토큰을 유지.
// 		persistRefreshToken: true,
		
//     	로그인 성공시, API를 호출합니다.
    	Kakao.API.request({
	 	    url: '/v2/user/me',
	 	    success: function(response) {
    	    var user = response.kakao_account //계정 정보
    	    user.host = 'kakao'
    	    kakaoMail = response.kakao_account.email; //유저의 이메일
    	    kakaoNick = response.properties.nickname; //유저가 등록한 별명
//     	    kakaoAge = response.properties.age_range; //유저가 등록한 성별
// 			kakaoGender = response.kakao_account.gender; //유저가 등록한 나이
// 			kakaobirthday = repons.kakao_account.birthday; //유저가 등록한 생일
//  		alert("이름 : "+kakaoNick); //로그인한 유저 이름
			var image = response.properties.profile_image;
			alert(user);
    	    
    	    },
    	    fail: function(error) {
    	        alert("에러1"+JSON.stringify(error));
    	    }
    	})
	    	var token = authObj.access_token;
	    	console.log(token);
	    	
// 	    	$.ajax({
//     	    	url:"/kLogin.np?s_name="+kakaoNick
// //     	    	url:"/index.jsp?s_name="+kakaoNick
//     	    	,success: function(data) {
//     	    		alert("data"+data);
//     	    	}
//     	    });
 	
//      		Kakao.Auth.authorize({
// 				redirectUri: 'http://192.168.0.38:8000/kLogin.np?kakaoNick='+kakaoNick
// // 				redirectUri: 'http://192.168.0.38:8000/kLogin.np'
// 			});

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