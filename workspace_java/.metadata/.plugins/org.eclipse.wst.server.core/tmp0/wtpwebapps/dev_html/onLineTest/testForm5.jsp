<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test4 = request.getParameter("htest4");
	out.print("4번 문제 답안 - "+test4);
	Cookie c = new Cookie("test4",test4);
	c.setMaxAge(100);
	response.addCookie(c);//이코드가 없으면 저장이 안된다. 주의할것.!
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function test(pcb){
		for(var i=0;i<document.f_test5.cb.length;i++){
			if(pcb == i) {
				document.f_test5.cb[i].checked=1;
			} else{
				document.f_test5.cb[i].checked=0;
			}
		}
	}
	function next(){
		var temp = 1;//정답은 1번부터 시작이므로 1로 초기화
		for(var i=0;i<document.f_test5.cb.length;i++){
			if(document.f_test5.cb[i].checked == 1) {
				document.f_test5.htest5.value=temp;
			}else{
				temp = temp + 1;
			}
		}
		document.f_test5.submit();//다음문제로 이동	
	}
	function prev(){
		location.href="./testForm4.jsp";		
	}
</script>
</head>
<body>
<form name="f_test5" method="get" action="testForm6.jsp">
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
<input type="button" value="이전문제" onClick="prev()"/>
<input type="button" value="다음문제" onClick="next()"/>
</form>
</body>
</html>