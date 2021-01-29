<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%
/*
rmap에 대한 정보를 session으로 부터 가져오므로 로그인 이전 상태에서는 세션값을 가지고 있찌 않다.
이럴 경우 rmap.get().toString()을 붙이는 구조에서는 rmap.get()의 리턴타입이 null이므로
이 부분에서 NullPointException이 발생한다.
세션이나 쿠키에서 값을 가져오는 경우 항상 Null일 가능성이 있다는 것을 염두에 두어야한다.
주소번지.메소드이름().메소드이름 과 같은 꼴을 사용할 때는 반드니 Null체크를 하도록 해야한다. - 에러방지(개발자가 주의해야할 행동)
*/
	Map<String,Object> rmap = (Map<String, Object>)session.getAttribute("rmap");
	String smem_name = null;
	String smem_id = null;
	if(rmap!=null){
	    smem_name = rmap.get("smem_name").toString();
	    smem_id   = rmap.get("smem_id").toString();
	}else{
	    smem_name = "";
	    smem_id = "";
// 	    smem_name.length();/* 주소번지의 하나의 메소드를 호출하는 꼴에서도 NullPoint는 발생할 수 있다.*/
//		MemberVo.java
//		private String mem_id=null;

	}	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp" %>
<title>Insert title here</title>
<script type="text/javascript">
	function testStart(){
		cmm_window_popup("./reGoTest.jsp","800","600","reGoTest");		
	}
	function loginAction(){//로그인 할 때
		var mem_id =$("#mem_id").val();
		var mem_pw =$("#mem_pw").val();
		var param = 'mem_id='+mem_id+'&mem_pw='+mem_pw;
		$.ajax({
			url:'/member/login.test' //MVC1
		   ,data:param
		   ,type:'post'
		   ,success:function(data){
			   $("#loginForm").html(data);
		   }
		   ,error:function(e){
			   alert(e.responseText);
		   }
		});
		
	}
	function logoutAction(){//로그아웃 일때 
		$.ajax({
			url:'logout.jsp'
		   ,success:function(data){
			   $("#loginForm").html(data);
		   }
		   ,error:function(e){
			   alert(e.responseText);
		   }
		});		
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
          <li><a href="javascript:testStart()">시험 응시</a></li>
        </ul>
      </li>
    </ul>
    <!--######################## [[ 로그인 폼 추가 시작 ]]  #######################-->
    <div id="loginForm" class="nav navbar-nav navbar-right">
     <form class="navbar-form navbar-right">
      <div class="form-group">
        <input type="text" class="form-control" id="mem_id" name="mem_id" value="test"
               size="10" placeholder="아이디">
      </div>
      <div class="form-group">
        <input type="text" class="form-control" id="mem_pw" name="mem_pw"  value="123"
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
			<p>
What is Lorem Ipsum?
Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
when an unknown printer took a galley of type and scrambled it to make a type specimen book. 
It has survived not only five centuries, but also the leap into electronic typesetting, 
remaining essentially unchanged. It was popularised in the 1960s with the release of 
Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing 
software like Aldus PageMaker including versions of Lorem Ipsum.			
			</p>
		</div>
		<div class="col-sm-4">
			<h4>회사연혁</h4>
			<p>
Why do we use it?
It is a long established fact that a reader will be distracted by the readable content of 
a page when looking at its layout. The point of using Lorem Ipsum is that it has a 
more-or-less normal distribution of letters, as opposed to using 'Content here, 
content here', making it look like readable English. Many desktop publishing packages 
and web page editors now use Lorem Ipsum as their default model text, and a search for 
'lorem ipsum' will uncover many web sites still in their infancy. Various versions have 
evolved over the years, sometimes by accident, sometimes on purpose 
(injected humour and the like).			
			</p>
		</div>
		<div class="col-sm-4">
			<h4>자격시험 이용안내</h4>
			<p>
Where can I get some?
There are many variations of passages of Lorem Ipsum available, but the majority have 
suffered alteration in some form, by injected humour, or randomised words which don't look 
even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to 
be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem 
Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this 
the first true generator on the Internet. It uses a dictionary of over 200 Latin words, 
combined with a handful of model sentence structures, to generate Lorem Ipsum which looks 
reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected 
humour, or non-characteristic words etc.			
			</p>
		</div>
	</div>      
      <!--######################## [[ 사이트 소개   끝   ]]  #######################-->
</div>
<!--=======================================================================================
                                       footer 시작
  ========================================================================================-->
<footer style="background-color: #000000; color: #ffffff;">
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







