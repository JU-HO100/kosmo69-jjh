<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test2 = request.getParameter("htest2");
	out.print("2번 문제 답안 - "+test2);
	Cookie c = new Cookie("test2",test2);
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
		for(var i=0;i<document.f_test3.cb.length;i++){
			if(pcb == i) {
				document.f_test3.cb[i].checked=1;
			} else{
				document.f_test3.cb[i].checked=0;
			}
		}
	}
	function next(){
		var temp = 1;//정답은 1번부터 시작이므로 1로 초기화
		for(var i=0;i<document.f_test3.cb.length;i++){
			if(document.f_test3.cb[i].checked == 1) {
				document.f_test3.htest3.value=temp;
			}else{
				temp = temp + 1;
			}
		}
		document.f_test3.submit();//다음문제로 이동
	}
	function prev(){
		location.href="./testForm2.jsp";		
	}
</script>
</head>
<body>
<form name="f_test3" method="get" action="testForm4.jsp">
<input type="hidden" name="htest3"/>
	문제3. 다음 중 DCL구문으로 맞는 것을 고르시오.<br>
	<input type="checkbox" name="cb" onChange="test(0)">grant<br>
	<input type="checkbox" name="cb" onChange="test(1)">drop<br>
	<input type="checkbox" name="cb" onChange="test(2)">alter<br>
	<input type="checkbox" name="cb" onChange="test(3)">delete<br>
<input type="button" value="이전문제" onClick="prev()"/>
<input type="button" value="다음문제" onClick="next()"/>
</form>
</body>
</html>