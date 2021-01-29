<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test1 = request.getParameter("htest1");//
	out.print("1번 문제 답안 - "+test1);//
	Cookie c = new Cookie("test1",test1);//쿠키 String "test1"에 , test1을 담겠다
	c.setMaxAge(100);//최대 100초동안 저장
	response.addCookie(c);//이코드가 없으면 저장이 안된다. 주의할것.!
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2번문제[testForm2.jsp]</title>
<script type="text/javascript">
	function test(pcb){
		
		
	}
	function reverse(){
		
		location.href="testForm1.jsp";
	}
	function next(){
		
		
		
		location.href="testForm3.jsp";
	}

</script>
</head>
<body>
<script type="text/javascript">
	alert("2번 문제입니다.");
</script>
<form action="f_test2" method="get" action="testForm3.jsp">
<input type="hidden" name="htest1"/>
<input type="hidden" name="htest2"/>
	문제2. 다음 중 DDL구문이 아닌 것을 고르시오.<br>
	<input type="checkbox" name="cb" onChange="test(0)">create<br>
	<input type="checkbox" name="cb" onChange="test(1)">drop<br>
	<input type="checkbox" name="cb" onChange="test(2)">alter<br>
	<input type="checkbox" name="cb" onChange="test(3)">delete<br>
	<br>
	<input id="btn_next" type="button" value="이전문제" onclick="reverse()">
	<input id="btn_next" type="button" value="다음문제" onclick="next()">
</form>
</body>
</html>