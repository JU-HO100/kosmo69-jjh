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

<!-- 카카오 로그인 -->
<script type='text/javascript'>
	var userInfo = "";
	//사용할 앱의 JavaScript 키를 설정하기
	Kakao.init('15f5287d753e527b86e1f231f7128313');
	//카카오 로그인 버튼을 생성하기
	Kakao.Auth.createLoginButton({
		container: '#kakao-login-btn',
		success: function(authObj) {
//     	alert(JSON.stringify(authObj));
			//로그인 성공시 
			Kakao.API.request({
	 	    url: '/v2/user/me',
	 	    success: function(res) {
// 				alert(res.properties.nickname+'님 환영합니다.');
				var user = res.properties;//유저 정보 담기
				user.host = 'kakao'
				console.log(user);
	    	    kakaoNick = res.properties.nickname; //유저가 등록한 별명
	    	    console.log(kakaoNick);
	    	    kakaoMail = res.kakao_account.email; //유저의 이메일
	    	    console.log(kakaoMail);
	    	    kakaoage = res.kakao_account.age_range; //사용자 연령
	    	    console.log(kakaoage);
	    	    kakaobirth = res.kakao_account.birthyear; //사용자 생일
	    	    console.log(kakaobirth);
	    	    kakaogender = res.kakao_account.gender; //사용자 성별
	    	    console.log(kakaogender);
	    	    
	    	    if(kakaoage==null){
	    	    	kakaoage = '-';
	    	    } 
	    	    if(kakaobirth==null){
	    	    	kakaobirth = '-';
	    	    }
	    	    if(kakaogender==null){
	    	    	kakaogender = '-';
	    	    }
	    	    if(kakaoMail==null){
	    	    	kakaoMail = '-';
	    	    }
// 	    	    userInfo = kakaoNick+kakaoMail+kakaoage+kakaobirth+kakaogender;
// 	    	    location.href="/member/memLogin.np?userInfo="+userInfo;
	    	    
	    	    location.href="/member/memLogin.np?m_name="+kakaoNick+'&m_id='+kakaoMail+'&m_birth='+kakaobirth
	    	    		+'&m_gender='+kakaogender+'&m_pw=-'+'&m_zip=-'+'&m_hp=-'+'&m_nick=-'+'&m_nick='+kakaoNick+'&m_mail='+kakaoMail+'&msg=-';
	    	    
// 				location.href="/member/kakaoindex.jsp?kakaoNick="+res.properties.nickname;//index
				
				
	 	    },
	 	    fail: function(error){
	 	    	alert(JSON.stringify(error));	
	 	    }
	 	    });
		},
		fail: function(err){
			alert(JSON.stringify(err));
		}
	});
	//로그아웃
	function logout(){
		Kakao.Auth.logout(function () {
			setTimeout(function(){
				loction.href="http://192.168.0.38:8000/member/index.jsp"
			},1000);//1초뒤에 로그아웃
		});
	}
	
</script>
<!-- =============================== 카카오 로그인 ================================================== -->
<!-- =============================== 카카오 로그아웃 ================================================== -->
<!-- <a href="http://developers.kakao.com/logout"></a> -->
<!-- <input type="button" value="로그아웃" onclick="logout()"> -->
<!-- =============================== 카카오 로그아웃 ================================================== -->

</body>
</html>