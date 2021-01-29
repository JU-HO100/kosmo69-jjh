<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<%@ include file="/common/bootstrap_common.jsp" %>

<script type="text/javascript">
		function logOut(){
		    $.cookie('cname',null, {expires:-1});
		      $("#mem_id").textbox('setValue','');
		       $("#mem_pw").passwordbox('setValue','');
// 		       $("#d_login").show();
// 		       $("#d_logout").hide();        
		}
		function loginAction(){
		   var u_id = $("#mem_id").val();
		   var u_pw = $("#mem_pw").val();
		//http://localhost:9000/AJAX/layout/loginAction3.jsp?mem_id=test&mem_pw=123
		//     request.getParameter("mem_id");         
		   var param="mem_id="+u_id+"&mem_pw="+u_pw;
		   $.ajax({
		         url:'loginAccount.jsp'
		             ,data:param
		             ,type:'post'
		             ,dataType:'text'
		             ,success:function(data){
		            	 
		                if(){
		                   alert("아이디를 확인해주세요.");
		                   return;//함수 탈출하기-처음부터 다시 사용할것.
		                }
		                else if(){
		                   alert("비밀번호를 확인해주세요.");
		                   return;//함수 탈출하기-처음부터 다시 사용할것.
		                }
		                else{
		                   $.cookie("cname",data);
		                   $("#d_ok").text(data);
		                   $("#d_login").hide();
		                   $("#d_logout").show();
		                }
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

<!-- ================================================================================================================
													메뉴바 시작
 ===================================================================================================================-->
<nav class="navbar navbar-default">
		<div class ="navbar-header">
			<button type ="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			<a class = "navbar-brand" href="index.jsp">JSP 웹사이트</a>
			<ul class = "nav navbar-nav navbar">
				<li class="dropdown">
					<a href="#" class = "dropdown-toggle"
					data-toggle ="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">시험과목<span class="caret"></span></a>
					<ul class ="dropdown-menu">
					<li class="active"><a href ="">Java</a></li>
					<li ><a href ="">Html</a></li>
					<li ><a href ="">JSP</a></li>
					</ul> 
			</li>
			</ul>
			<ul class = "nav navbar-nav navbar">
				<li class="dropdown">
					<a href="#" class = "dropdown-toggle"
					data-toggle ="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">시험응시<span class="caret"></span></a>
					<ul class ="dropdown-menu">
					<li class="active"><a href ="login.jsp">응시번호</a></li>
					<li ><a href ="singup.jsp">응시결과</a></li>
					</ul> 
			</li>
			</ul>
		</div>
	
			<!-- \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ [ 로그인 폼 추가 시작 ] \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ -->
				<form class="navbar-form navbar-right">
					<div class="form-grop">
						<input type="text" class="form-control" id="mem_id" name="mem_id"
								size="10" placeholder="아이디">
						<input type="text" class="form-control" id="mem_pw" name="mem_pw"
								size="10" placeholder="비밀번호">
						<button type="button" class="btn btn-dark" onclick="loginAction()">Login</button>
					</div>
				</form>
			<!-- \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ [ 로그인 폼 추가 끝 ] \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ -->
	</nav>
<!-- ================================================================================================================
													메뉴바 끝
 ===================================================================================================================-->
<!-- ================================================================================================================
													점보트론 시작
 ===================================================================================================================-->
 <div class="container">
   <div class="jumbotron">
   <h1 class="text-center">온라인 시험을 소개 합니다.</h1>
   <p class="text-center">부트스트랩을 이용하여 화면을 디자인해 봅시다.</p>
   <p class="text-center"><a href="">자격시험</a></p>
   </div>
</div>
<!-- ================================================================================================================
													점보트론 끝
 ===================================================================================================================-->
<!-- ================================================================================================================
													사이트 소개 시작
 ===================================================================================================================-->
 <div>
 	<div class="col-am4">
 		<p>
 		“현재 초·중등 교육과정에서 컴퓨팅사고력, 기초수학과 통계학적 개념 같은 소프트웨어 기초소양 교육이 매우 부족합니다. 대다수 학생이 알고리즘 기본개념과 코딩 능력을 거의 갖추지 못한 채 대학에 진학하다 보니 인공지능 융합교육은 사실상 불가능하죠.” (서정연 한국정보과학교육연합회 의장·서강대 컴퓨터공학과 교수)

미래 사회에 대비해 소프트웨어 기초 소양 교육을 강화해야 한다는 목소리가 높아지고 있는 가운데, 초·중등 교육현장에 적용할 차세대 소프트웨어 교육과정 표준모델이 제시됐다. 14일 오후 2시 국회의원회관에서 열린 ‘차세대 인공지능 융합형 정보인재 양성을 위한 소프트웨어 교육 혁신 포럼’에서다. 이번 포럼은 박경미 국회 교육위원회 위원(더불어민주당 의원), 한국정보과학교육연합회, 한국정보교육학회, 한국컴퓨터교육학회, 한국정보과학회가 공동으로 주최했다. 특히 이번 포럼은 과학기술정보통신부의 지원을 바탕으로 3년간 연구·개발 끝에 마련된 차세대 소프트웨어(SW) 교육과정 표준모델에 대한 산·학·연 전문가들의 의견을 수렴하는 취지에서 열렸다. 이날 SW 교육 관련 산·학·연 전문가 100여명이 참석해 객석을 빼곡히 메웠다. 오는 10월에는 차세대 SW교육과정 표준모델에 대한 대국민 공청회를 열고 더욱 폭넓은 의견을 수렴할 예정이다.

◇‘인공지능 융합 인재’ 필요…“초·중·고교서 기초 소양 길러야”

포럼에 참석한 전문가들은 미래 사회에 필요한 인재로 ‘인공지능 융합 인재’를 강조했다. 인공지능 융합 인재는 인공지능 기술을 기반으로 자신이 전공한 분야의 전문 지식을 더해 해당 분야에서 새로운 지능형 상품이나 서비스를 창출하거나 생산성을 향상하는 인재를 의미한다. 발제를 맡은 서 의장은 “미래 사회에는 인공지능 융합 능력을 갖춘 사람들과 그렇지 못한 사람들 사이의 불공정 경쟁이 가속할 것”이라며 “정부는 정보교육 격차를 줄이기 위해 공교육을 통해 모든 학생에게 인공지능의 기초 소양을 교육해야 한다”고 강조했다.

이러한 문제점을 개선하고자 새롭게 개발한 차세대 SW 교육과정 표준모델은 다음 발제에서 공개됐다. 이날 발표된 차세대 SW 교육과정 표준모델 인재상은 정보와 컴퓨팅 소양을 갖추고 더불어 살아가는 창의융합적인 사람이다. 인재상 실현에 필요한 역량은 ▲컴퓨팅사고력 ▲정보문화 소양 ▲디지털 협업능력 ▲융합적 문제해결력 등 4가지다. 초·중등 교육과정에서 배워야 할 지식은 ▲정보 문화 ▲자료와 정보 ▲알고리즘과 프로그래밍 ▲컴퓨팅 시스템 ▲인공지능과 융합 등 5개 영역으로 구성했다.

올해 연구 책임자인 김갑수 서울교대 컴퓨터교육과 교수는 “특히 기존 SW교육은 초·중·고 3단계로만 나뉘어 있었지만, 새 표준모델에서는 초등 1~3단계, 중등 1~3단계, 고등 1~2단계로 세분화해 나선형 교육모델을 실현하고자 한다”며 “학교급별로 초등은 체험 중심, 중등은 간단한 실습과 적용 중심, 고등 단계에서는 실생활 문제해결을 중심으로 운영할 방침”이라고 설명했다. SW 지식을 바탕으로 한 실천 활동은 영역별 기대수준으로 정의했다. “예를 들어, 인공지능 영역에서 초등 1단계는 가정·학교생활에서 인공지능을 체험하고, 인공지능이 무엇인지 이해할 수 있는 수준입니다. 다음 단계는 간단한 인공지능 프로그램을 체험하고, 인공지능의 개념을 이해하는 정도죠. 초등 3단계에서는 기계학습 체험을 통해 인공지능의 활용 가능성을 탐색하는 수준으로 단계적으로 나아갑니다.”
 		
 		</p>
 	</div>
 	
 	<div class="col-am4">
 		<p>
 		
 		
 		</p>
 	</div>
 	
 	
 </div>
<!-- ================================================================================================================
													사이트 소개 끝
 ===================================================================================================================-->
<!-- ================================================================================================================
													footer 시작
 ===================================================================================================================-->
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
            <a href="#" class="list-group-item">트위터</a>
         </div>
      </div>
   </div>
   </div>
</footer>

<!-- ================================================================================================================
													footer 끝
 ===================================================================================================================-->
</body>
</html>