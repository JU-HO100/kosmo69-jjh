<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//직접 인스턴스화 하는 경우 scope가 없다.
//page|request|session|application = scope 4가지
//파라미터값은 절대로 id는 불가하다. -UI쪽에서만 사용할것.
	String ord_no = new String("E202011030005");
//요청객체에 데이터를 담을 수 있음.
	request.setAttribute("ord_no:",ord_no);
	RequestDispatcher view = request.getRequestDispatcher("c.jsp");
	view.forward(request,response);
%>
