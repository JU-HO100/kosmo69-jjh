<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3번 문제[testForm3.jsp]</title>
<script type="text/javascript">
	function test(pcb){
		
		
	}
	function next(){
		location.href="testForm4.jsp";
	}
</script>
</head>
<body>
<script type="text/javascript">
	alert("3번 문제입니다");
</script>
<form action="f_test3" method="get" action="testForm4.jsp">
<input type="hidden" name="htest1"/>
<input type="hidden" name="htest2"/>
<input type="hidden" name="htest3"/>
	문제3. 다음 중 DCL구문으로 맞는 것을 고르시오.<br>
	<input type="checkbox" name="cb" onChange="test(0)">grant<br>
	<input type="checkbox" name="cb" onChange="test(1)">drop<br>
	<input type="checkbox" name="cb" onChange="test(2)">alter<br>
	<input type="checkbox" name="cb" onChange="test(3)">delete<br>
	<br>
	<input id="btn_next" type="button" value="다음문제" onclick="next()">
</form>
</body>
</html>