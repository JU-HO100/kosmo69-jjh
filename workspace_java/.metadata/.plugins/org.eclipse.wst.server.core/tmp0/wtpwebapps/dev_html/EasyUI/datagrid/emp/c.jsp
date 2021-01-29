<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String ord_no = (String)request.getAttribute("ord_no");
	out.print("ord_no:"+ord_no);
%>
