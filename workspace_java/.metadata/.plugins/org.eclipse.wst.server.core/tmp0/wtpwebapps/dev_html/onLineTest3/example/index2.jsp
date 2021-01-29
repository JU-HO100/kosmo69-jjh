<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/common/bootstrap_common.jsp" %>
<script type="text/javascript">
   function loginAction(){//로그인 할 때
// 	   alert("로그인버튼");
	   var u_id = $("#mem_id").val();
	   var u_pw = $("#mem_pw").val();
	   var param="mem_id="+u_id+"&mem_pw="+u_pw;
	   $.ajax({
	         url:'/member/login.test'	
	             ,data:param
	             ,type:'post'
	             ,dataType:'text'
	             ,success:function(data){
	            	$("#loginForm").html(data);
	            	alert(data);
	             }
	   });
   }
   function logoutAction(){//로그아웃 일때 
		$("#mem_id").textbox('setValue','');
		$("#mem_pw").textbox('setValue','');
   }
</script>
</head>
<body>

<style>
   .jumbotron {
      background-image: url('/images/phpCode.jpg');
      background-size: cover;
      color: white;
   }
</style>
<!--=======================================================================================
                                  메뉴 바 시작
  ========================================================================================-->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">한소아</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Front-End노트
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">HTML</a></li>
          <li><a href="#">CSS</a></li>
          <li><a href="#">JavaScript</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Back-End노트
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">JAVA</a></li>
          <li><a href="#">JSP</a></li>
          <li><a href="#">Spring</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">자격시험
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">시험 접수</a></li>
          <li><a href="#">시험 응시</a></li>
        </ul>
      </li>
    </ul>
    <!--######################## [[ 로그인 폼 추가 시작 ]]  #######################-->
    <div id="loginForm" class="nav navbar-nav navbar-right">
     <form class="navbar-form navbar-right">
      <div class="form-group">
        <input type="text" class="form-control" id="mem_id" name="mem_id" 
               size="10" placeholder="아이디">
      </div>
      <div class="form-group">
        <input type="text" class="form-control" id="mem_pw" name="mem_pw" 
               size="10" placeholder="비밀번호">
      </div>
      <button type="button" class="btn btn-dark" onclick="loginAction()">Login</button>
    </form>
    </div>   
    <!--######################## [[ 로그인 폼 추가   끝  ]]  #######################-->
  </div>
</nav>
<!--=======================================================================================
                                                                                    메뉴 바 끝
  ========================================================================================-->
<!--=======================================================================================
                                                                                    점보트론 시작 
  ========================================================================================-->
<div class="container">
   <div class="jumbotron">
   <h1 class="text-center">온라인 시험을 소개 합니다.</h1>
   <p class="text-center">부트스트랩을 이용하여 화면을 디자인해 봅시다.</p>
   <p class="text-center">
   <a href="#" class="btn-primary btn-lg" role="button">자격시험</a>
   </p>
   </div>
<!--=======================================================================================
                                                                                    점보트론  끝
  ========================================================================================-->
      <!--######################## [[ 사이트 소개 시작  ]]  #######################-->
   <div class="row">
      <div class="col-sm-4">
         <h4>회사소개</h4>
      </div>
      <div class="col-sm-4">
         <h4>회사연혁</h4>
      </div>
      <div class="col-sm-4">
         <h4>자격시험 이용안내</h4>
      </div>
   </div>      
      <!--######################## [[ 사이트 소개   끝   ]]  #######################-->
</div>
<!--=======================================================================================
                                       footer 시작
  ========================================================================================-->
<footer style="background-color: #CEF6F5; color: #ffffff;">
   <div class="container">
   <br>
   <div class="row">
      <div class="col-sm-2"><h5>Copyright &copy; 2020</h5><h5>한소아</h5></div>
      <div class="col-sm-4"><h4>대표자 소개</h4><p>한소아에서 자바과정을 담당하고 있습니다.</div>
      <div class="col-sm-2"><h4 style="text-align: center">내비게이션</h4>
         <div class="list-group">
            <a href="#" class="list-group-item">소개</a>
            <a href="#" class="list-group-item">강사진</a>
            <a href="#" class="list-group-item">강의</a>
         </div>
      </div>
      <div class="col-sm-2"><h4 style="text-align: center">SNS</h4>
         <div class="list-group">
            <a href="#" class="list-group-item">페이스북</a>
            <a href="#" class="list-group-item">유튜브</a>
            <a href="#" class="list-group-item">네이버 TV</a>
         </div>
      </div>
   </div>
   </div>
</footer>
</body>
</html>






