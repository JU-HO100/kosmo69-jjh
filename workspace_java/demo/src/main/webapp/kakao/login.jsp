<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name = "viewport" content = "user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0,
width=device-width" />
 <title>kakao 로그인 Test</title>
<script src = "//developers.kakao.com/sdk/js/kakao.min.js"></script>
<a id="kakao-login-btn"></a>
<a href="http://developers.kakao.com/logout"></a>
<script type='text/javascript'>
 
Kakao.init('f61c36ee28b1fe4d00e270bcf75d344d'); //아까 카카오개발자홈페이지에서 발급받은 자바스크립트 키를 입력함
 
//카카오 로그인 버튼을 생성합니다. 
Kakao.Auth.createLoginButton({
	container: '#kakao-login-btn',
	success: function(authObj){
		//로그인 성공시 API를 호출
		Kakao.API.request({
			alert(res.properties.nickname+'님 환영합니다');
			location.href="./result?name="+res.properties.nickname;
		},
		fail: function(error){
			alert(JSON.stringify(err));
		}
	});
});
function ktout(){
	Kakao.Auth.logout(function (){
		setTimeout(function(){
			location.href="http://192.168.0.38:9000/pe/board/test"
		},1000);//로그아웃 처리되는 시간을 1초로 설정
	});
}

</script>
</head>
<body>

</body>
</html>