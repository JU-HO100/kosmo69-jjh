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
<script type="text/javascript">
	$(document).ready(function (){
		$.ajax({
// 			url:"innerStep1.jsp"
			url:"innerStep1.jsp?mem_id=apple&mem_pw=123"
			,dataType:"html" //json , xml or text 올수 있다.
			,surcess:function(data){
// 				document.getElementById("d_result1").innerText="";
// 				document.getElementById("d_result1").innerHTML="";
// 				$("#d_result").text(data);
				$("#d_result").html(data);
				
			}
			
		});
	});
</script>
<div id="d_result">여기</div>
</body>
</html>