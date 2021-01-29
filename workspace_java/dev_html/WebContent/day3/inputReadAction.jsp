<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
//여기는 자바영역
	String name = request.getParameter("t_name");
	String addr = request.getParameter("t_addr");
	String good = request.getParameter("t_good");
	out.print("이글자 : "+"<b>"+name+"</b>");
	//document.write()
%>	
<!-- 여기는 html영역 -->
<table border="1">
	<tr>
		<td><%out.print(addr); %></td> <!-- %를 쓴 이유는 자바의 코드를 사용하기 위해서이다. -->
		<td><%out.print(good); %></td>
	</tr>
</table>
	