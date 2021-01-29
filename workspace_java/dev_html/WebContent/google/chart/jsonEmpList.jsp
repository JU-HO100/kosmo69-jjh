<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="web.mvc.EmpDao"%>
<%
	//SELECT empno, sal, NVL(comm,0) as "comm" FROM emp // null이 나오지않게 하는 안정장치
	EmpDao edao = new EmpDao();
// 	List<Map<String,Object>> empList = null;
	List<Map<String,Object>> empList = new ArrayList();//empList.size()=0 이다.	
		empList = edao.getEmpList3(null);
// 	out.print(empList);//변종이 나온다. 이름에 더블쿼테이션이 없다.
	Gson g = new Gson();
	String imsi = g.toJson(empList);
	out.print(imsi);
	
%>