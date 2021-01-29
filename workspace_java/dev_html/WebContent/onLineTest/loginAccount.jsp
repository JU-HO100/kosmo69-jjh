<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>    
<%
	Map<String,Object> rmap = (Map<String,Object>)session.getAttribute("rmap");
	String smem_name = null;
	String smem_id = null;
	if(rmap!=null){
	    smem_name = rmap.get("smem_name").toString();
	    smem_id   = rmap.get("smem_id").toString();
	}else{
	    smem_name = "";
	    smem_id = "";
	}
	
%>
     <form class="navbar-form navbar-right">
      <label for="msg">
      	<font color="white"><%=smem_name %>님 환영합니다.</font>
      </label>
      <button type="button" class="btn btn-dark" onclick="logoutAction()">Logout</button>
    </form>