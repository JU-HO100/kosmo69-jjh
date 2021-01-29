<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	session.invalidate();//세션에 있는 값 모두 삭제하기
%>
<%@ include file="/common/bootstrap_common.jsp" %>
			<div id="loginForm" class="nav navbar-nav navbar-right">
				<form class="navbar-form navbar-right">
					<div class="form-grop">
						<input type="text" class="form-control" id="mem_id" name="mem_id"
								size="10" placeholder="아이디">
						<input type="text" class="form-control" id="mem_pw" name="mem_pw"
								size="10" placeholder="비밀번호">
						<button type="button" class="btn btn-dark" onclick="loginAction()">Login</button>
					</div>
				</form>
			</div>