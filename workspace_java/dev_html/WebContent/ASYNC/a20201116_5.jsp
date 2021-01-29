<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   	List<Map<String,Object>> empList = new ArrayList<>();
	Map<String,Object> remp = new HashMap<>();
	remp.put("ename","이순신");
	remp.put("gender",1);
	empList.add(remp);
	remp = new HashMap<>();
	remp.put("ename","선덕여왕");
	remp.put("gender",0);
	empList.add(remp);
	remp = new HashMap<>();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<!-- header 영역 시작 -->
   <tr>
      <th>이름</th>
      <th>성별</th>
   </tr>
<!-- header 영역 끝 -->
<%
   for(int i=0;i<empList.size();i++){
	   Map<String,Object> rmap = empList.get(i);
%>   
   <tr><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String v_name="이순신";
	String v_gender="남자";
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
<script type="text/javascript">
	var g_dname='영업부';
	function refresh(){
		document.write("<%=v_name%>"+"님 <b>안녕</b>하세요.");
		document.write("<br>");
		document.write(g_dname);
		document.write("<br>");
		document.write(v_dname);
	}
</script>
</head>
<body>
<input type="button" value="전송" onclick="refresh()">
<script type="text/javascript">
		
		v_dname='총무부';
		document.write("<table width='350px' border='1' borderColor='green'>");
		document.write("<tr>");
		document.write("<td>");
		document.write("<%=v_name%>");
		document.write("</td>");
		document.write("<td>");
		document.write("<%=v_gender%>");
		document.write("</td>");
		document.write("</tr>");
		document.write("</table>");
</script>
</body>
</html>
      <td><%=rmap.get("ename")%></td>
      <td>
      <%
		if("1".equals(rmap.get("gender").toString())){
      %>
	  남자
	  <%
		} else if("0".equals(rmap.get("gender").toString())){
	  %>
      여자
      <%
		}
      %>
      </td>
   </tr>
<%
   }///////////////////////end of for
%>
</table>
</body>
</html>