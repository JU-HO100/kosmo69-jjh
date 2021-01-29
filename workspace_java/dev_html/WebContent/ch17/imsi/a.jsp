<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//session에 담으면 값이 일정 시간동안 유지가 된다.
	out.print(session.getAttribute("s_id"));//apple
	out.print("<br>");
	out.print(request.getAttribute("r_id"));//null - forward가 아니라 값이 유지가 되지 않는다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>location</title>
<script type="text/javascript">
	function move(){
		location.href="./b.jsp"
	}
</script>
</head>
<body>
1번화면
<a href="javascript:move()">넘기기</a>
</body>
</html>