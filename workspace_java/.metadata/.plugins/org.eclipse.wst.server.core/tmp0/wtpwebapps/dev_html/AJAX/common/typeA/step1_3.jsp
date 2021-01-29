<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../../common/easyui_common.jsp" flush="false"/>

</head>
<body>
<div id="d_result1"></div>
<script type="text/javascript">
	$(document).ready({
		$("#d_result1").show();
		$("#d_result2").show();
	});
</script>
<div id="d_result2"></div>
</body>
</html>