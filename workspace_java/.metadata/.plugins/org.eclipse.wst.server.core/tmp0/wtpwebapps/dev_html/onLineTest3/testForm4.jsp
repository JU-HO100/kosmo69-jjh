<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4번 문제[testForm4.jsp]</title>
<script type="text/javascript">
	function test(pcb){
		
		
	}
	function next(){
		location.href="testForm5.jsp";
	}
</script>
</head>
<body>
<script type="text/javascript">
	alert("4번 문제입니다");
</script>
<form action="f_test4" method="get" action="testForm5.jsp">
<input type="hidden" name="htest1"/>
<input type="hidden" name="htest2"/>
<input type="hidden" name="htest3"/>
<input type="hidden" name="htest4"/>
	문제4. 다음 중 테이블에 대한 설명으로 틀린 것을 고르시오.<br>
	<input type="checkbox" name="cb" onChange="test(0)">
	row와 column으로 구성되어있다.<br>
	<input type="checkbox" name="cb" onChange="test(1)">
	테이블에는 반드시 index가 있어야 한다.<br>
	<input type="checkbox" name="cb" onChange="test(2)">
	컬럼에는 적당한 타입을 선택하고 담을 수 있는 크기도 설정할 수 있다.<br>
	<input type="checkbox" name="cb" onChange="test(3)">
	<br>
	<input id="btn_next" type="button" value="다음문제" onclick="next()">
</form>
</body>
</html>