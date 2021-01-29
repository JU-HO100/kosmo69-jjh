<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//직접 인스턴스화 하는 경우 scope가 없다.
//page|request|session|application = scope 4가지
//파라미터값은 절대로 id는 불가하다. -UI쪽에서만 사용할것.
	String ord_no = new String("E202011030005");
	request.setAttribute("ord_no:",ord_no);
%>
<!DOCTYPE html>
<!-- 
get방식과 post방식을 구분할 수 있는가?
위 2가지의 차이점은 무엇인가?

 -->
<html>
<head>
<meta charset="UTF-8">
<title>a2.jsp[시작 페이지]</title>
<script type="text/javascript">
	function move(){
		location.href="b2.jsp?";//이것 자체가 get방식이다.
	}
</script>
</head>
<body>
여기가 시작페이지 입니다.<br>
<input type="button" value="이동" onclick="move()">

</body>
</html>