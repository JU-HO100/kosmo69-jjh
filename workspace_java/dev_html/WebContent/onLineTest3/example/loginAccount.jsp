<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%
	String msg = (String)session.getAttribute("smsg");
%>

     <form class="navbar-form navbar-right">
      <label for="msg">
         <font color="white"><%=msg %>님 환영합니다.</font>
      </label>
      <button type="button" class="btn btn-dark" onclick="logoutAction()">Logout</button>
    </form>

