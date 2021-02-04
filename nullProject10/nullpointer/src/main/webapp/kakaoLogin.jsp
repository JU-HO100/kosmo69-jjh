<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>  
<%@ page import="java.util.*" %>
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
<form method="post" action="/member/kLogin.np">
   <div id="kakao-login-btn"></div>
</form>
<!-- 카카오 로그인 -->
<script type='text/javascript'>
   var userInfo = "";
   //사용할 앱의 JavaScript 키를 설정하기
   Kakao.init('15f5287d753e527b86e1f231f7128313');
   //카카오 로그인 버튼을 생성하기
   Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
//        alert(JSON.stringify(authObj));
         //로그인 성공시 
         Kakao.API.request({
           url: '/v2/user/me',
           success: function(res) {
//             alert(res.properties.nickname+'님 환영합니다.');
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
//               kakaogender = res.kakao_account.gender; //사용자 성별
//               console.log(kakaogender);
              
              if(kakaoage==null){
                 kakaoage = '-';
              } 
              if(kakaobirth==null){
                 kakaobirth = '-';
              }
          
              if(kakaoNick==null){
                 kakaoNick = '-';
              }
              var kakaogender = 0;
            
              location.href="/member/kLogin.np?m_name="+kakaoNick+'&m_id='+kakaoMail+'&m_birth='+kakaobirth
                    +'&m_gender='+kakaogender+'&m_pw=1234'+'&m_zip=-'+'&m_hp=-'+'&m_nick='+kakaoNick+'&m_mail='+kakaoMail+'&msg=-';

           },
           fail: function(error){
              alert("에러1"+JSON.stringify(error));   
           }
           });
      },
      fail: function(err){
         alert("에러2"+JSON.stringify(err));
      }
   });
   
</script>
<!-- =============================== 카카오 로그인 ================================================== -->
</body>
</html>