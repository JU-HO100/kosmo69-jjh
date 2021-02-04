<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	var jaelyo = [];
</script>
<script type="text/javascript">
function aa() {
jaelyo.push("안녕?");
alert(jaelyo);
}
function bb() {
	jaelyo.push("메롱?");
	alert(jaelyo);
}
</script>
<input type="button" onclick="javascript:aa()" value="버튼">
<input type="button" onclick="javascript:bb()" value="버튼2">
</body>
</html>