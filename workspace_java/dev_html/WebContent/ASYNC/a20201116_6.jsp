<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"  %>
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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" borderColor="green">
<!-- header 영역 시작 -->
   <tr>
      <th>이름</th>
      <th>성별</th>
   </tr>
<!-- header 영역 끝 -->
<%
   for(int i=0; i<empList.size();i++){
      Map rmap = empList.get(i);
%>   
   <tr>
      <td><%=rmap.get("ename") %></td>
      <!-- 1이면 남자 0이면 여자 -->
      <td>
<%
      if("1".equals(rmap.get("gender").toString())){
//          rmap.put("gender", "남자");
%>
남자
<%
      }
      else if("0".equals(rmap.get("gender").toString())){
//          rmap.put("gender", "여자");
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