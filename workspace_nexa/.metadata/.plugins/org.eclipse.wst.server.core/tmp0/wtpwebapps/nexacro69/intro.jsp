<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>넥사크로화면과 JSP화면 공존</title>
<script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
인트로페이지 입니다<br>
<hr>
<script type="text/javascript">
	$.ajax({
		url:'top.jsp'
		,success:function(data){
			$("#d_test").html(data);
		}
	});
</script>

<script type="text/javascript">
// 	location.href="http://localhost:8000/nexa/quickview.html?screenid=Desktop_screen&formname=Base::DeptManager";
	location.replace("http://localhost:8000/nexa/quickview.html?screenid=Desktop_screen&formname=Base::DeptManager");
</script>


</body>
</html>