<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String test5 = request.getParameter("htest5");
	out.print("5번 문제 답안 - "+test5);
	Cookie c = new Cookie("test5",test5);
	c.setMaxAge(100);
	response.addCookie(c);//이코드가 없으면 저장이 안된다. 주의할것.!
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	location.href="testFormSend.jsp";
</script>

</head>
<body>

</body>
</html>