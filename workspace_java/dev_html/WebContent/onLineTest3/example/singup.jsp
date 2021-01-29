<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@ include file="/common/bootstrap.jsp" %>
</head>
<body>
<nav class="navbar navbar-default">
		<div class ="navbar-header">
			<button type ="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			<a class = "navbar-brand" href="bbs.jsp">JSP 게시판 웹사이트</a>
		</div>
		
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href = "bbs.jsp">게시판</a></li>
			</ul>
			<ul class = "nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class = "dropdown-toggle"
					data-toggle ="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class ="dropdown-menu">
				<li class="active"><a href ="login.jsp">로그인</a></li>
				<li ><a href ="join.jsp">회원가입</a></li>
					</ul> 
				</li>
			</ul>
		</div>
	</nav>
	<div class="col-lg-4"></div>
	<div class="col-lg-4">
		<form method="post" action = "loginAction.jsp">
			<h3 style="text-align : center;">회원가입 화면</h3>
			<div class="form-group">
				<input type="text" class="form-control" placeholder ="아이디" name="userID" maxlength="20">
			</div>
	<div class="col-lg-4"></div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder ="비밀번호" name="userPassword" maxlength="10">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder ="비밀번호 확인" name="userPassword2" maxlength="10">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder ="이름" name="userName" maxlength="10">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder ="핸드폰번호" name="userHP" maxlength="12">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder ="우편번호" name="userZipcode" maxlength="10">
			</div>
			<div class="form-group">
				<input type="password" class="form-control" placeholder ="주소" name="userArrdess" maxlength="20">
			</div>
			<div>
			<input type="submit" class="btn btn-primary form-control" value="가입하기" style="width:100px">
			<input type="submit" class="btn btn-primary form-control" value="취소" style="width:100px">
			</div>
		</form> 
	</div>	
</body>
</html>