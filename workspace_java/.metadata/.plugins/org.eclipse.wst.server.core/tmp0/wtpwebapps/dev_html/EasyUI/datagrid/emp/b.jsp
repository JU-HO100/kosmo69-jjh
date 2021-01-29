<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//직접 인스턴스화 하는 경우 scope가 없다.
//page|request|session|application = scope 4가지
//파라미터값은 절대로 id는 불가하다. -UI쪽에서만 사용할것.
	String b_no = request.getParameter("b_no");
	out.print("b_no:"+b_no);
	String ord_no = (String)request.getAttribute("ord_no");
	out.print("ord_no:"+ord_no);
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp[종료 페이지]</title>
<script type="text/javascript">
	function move(){
		location.href="a.jsp";
	}
</script>
</head>
<body>
여기는 결과페이지 입니다.<br>
<input type="button" value="이동" onclick="move()">

</body>
</html>