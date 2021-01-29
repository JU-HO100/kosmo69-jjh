<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../../common/easyui_common.jsp" flush="false"/>
<script type="text/javascript">
document.getElementById("d_result1").innerText="";
document.getElementById("d_result2").innerText="";

</script>
</head>
<body>
<div id="result1">여기</div>
<script type="text/javascript">
$("#d_result2").hide();
</script>
<div id="d_result2">저기</div>
</body>
</html>