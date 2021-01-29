<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>5번 문제[testForm5.jsp]</title>
<%
	String test5 = request.getParameter("htest5");
	Cookie c = new Cookie("test5",test5);
	c.setMaxAge(60*60);
	response.addCookie(c);
	response.sendRedirect("./testFormSend.jsp");
%>
<script type="text/javascript">
	function test(pcb){
		
		
	}
	function next(){
		location.href="testForm6.jsp";
	}
</script>
</head>
<body>
<script type="text/javascript">
	alert("5번 문제입니다");
</script>
<form action="f_test5" method="get" action="testFormSend.jsp">
<input type="hidden" name="htest1"/>
<input type="hidden" name="htest2"/>
<input type="hidden" name="htest3"/>
<input type="hidden" name="htest4"/>
<input type="hidden" name="htest5"/>
	문제5. 다음 중 프로시저에 대한 설명으로 틀린 것을 고르시오.<br>
	<input type="checkbox" name="cb" onChange="test(0)">
	프로시저를 생성할 때 파라미터를 선언할 수 있다.<br>
	<input type="checkbox" name="cb" onChange="test(1)">
	파라미터에 여러 변수를 선언할 수 있다.<br>
	<input type="checkbox" name="cb" onChange="test(2)">
	프로시저안에서 SELECT,INSERT,UPDATE, DELETE 모두 사용 할 수 있다.<br>
	<input type="checkbox" name="cb" onChange="test(3)">
	프로시저 안에서 commit할 수 없다.
	<br>
	<input id="btn_next" type="button" value="제출하기" onclick="next()">
</form>
</body>
</html>