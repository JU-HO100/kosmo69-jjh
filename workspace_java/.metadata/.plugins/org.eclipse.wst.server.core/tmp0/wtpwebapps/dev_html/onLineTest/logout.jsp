<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();//세션에 있는 값 모두 삭제하기
%>
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