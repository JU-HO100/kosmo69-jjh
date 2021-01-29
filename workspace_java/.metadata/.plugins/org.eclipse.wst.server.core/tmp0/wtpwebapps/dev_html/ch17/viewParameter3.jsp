<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map, com.util.HashMapBinder" %>
<%
//viewParameterVer2.jsp로 저장해주세요.
//HashMapBinder를 사용하여 사용자가 입력한 값을 출력해 보세요.
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head><title>요청 파라미터 출력</title></head>
<body>
	<b>request.getParameter() 메서드 사용</b><br>
<% 
	HashMapBinder hmb = new HashMapBinder(request);
	Map<String,Object> pmap = new HashMap<>();
	hmb.bind(pmap);
	Object obj[] = null;
	obj = pmap.keySet().toArry();
	for(int i=0;i<obj.length;i++){
		String key = (String)obj[i];
		if("name".equals(key)){
			out.print("name 파라미터 ="+pmap.get(key)+"<br>");
		} 
		if("address".equals(key)){
			out.print("address 파라미터 ="+pmap.get(key)+"<br>");
		}
		if("h_imsi".equals(key)){
			out.print("h_imsi 파라미터 ="+pmap.get(key)+"<br>");
		}
	}///////////////////////////// end of for
%>

	
	<p>
	<b>request.getParameterValues() 메서드 사용</b><br>
<%
	String[] values = request.getParameterValues("pet");
	if (values != null) {
	for (int i = 0 ; i < values.length ; i++) {
%>
	<%= values[i] %>
<%
		}
	}
%>
<p>
<b>request.getParameterNames() 메서드 사용</b><br>
<%
	Enumeration paramEnum = request.getParameterNames();
	while(paramEnum.hasMoreElements()) {
		String name = (String)paramEnum.nextElement();
%>
		<%= name %>
<%
	}
%>
<p>
<b>request.getParameterMap() 메서드 사용</b><br>
<%
	Map parameterMap = request.getParameterMap();
	String[] nameParam = (String[])parameterMap.get("name");
	if (nameParam != null) {
%>
	name = <%= nameParam[0] %>
<%
	}
%>
</body>
</html>