<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	out.print("<b>before</b>");
	out.print("<hr>");
	RequestDispatcher view = request.getRequestDispatcher("b.jsp");
	view.include(request,response);
	out.print("<b>after</b>");/* a.jsp페이지이지만 b.jsp의 화면도 보여주고 있으며 제어권이 a.jsp에 그대로 가지고 있다. */
	
%>