<%@page import="java.util.ArrayList"%>
<%@page import="web.mvc.DeptDao"%>
<%@page import="java.util.List, java.util.Map" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Map<String,Object>> deptList = null;
	deptList = (List<Map<String,Object>>)request.getAttribute("getDeptList");

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<title>a5.jsp</title>
</head>
<body>

<select id="dept" class="easyui-combobox" name="dept">
<%if(deptList!=null){
	out.print("deptList.size():"+deptList.size());
	for(int i=0;i<deptList.size();i++){
		Map<String,Object> rmap = deptList.get(i);
%>
	<option><%=rmap.get("LOC")%></option>
<%
	}
}
%>
</select>

</body>
</html>