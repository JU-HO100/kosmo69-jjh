<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../../common/easyui_common.jsp" flush="false"/>
$(document).ready({
	$("#d_result1").show();
	$("#d_result2").show();
});

</head>
<body>
<div id="d_result1">여기</div>
<script type="text/javascript">
</script>
<div id="d_result2">저기</div>
</body>
</html>