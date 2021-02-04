<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function abc(){
	let abc="abc";
	let bcd=`\${abc}`;
	alert(bcd);
}
</script>
</head>
<body>
<input type="button" value="버튼" onclick="javascript:abc();">
</body>
</html>