<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	StringBuilder sb = new StringBuilder();
	String imsi="[{EMPNO=7369, ENAME=SMITH, SAL=800, DEPTNO=20},{EMPNO=7566, ENAME=JONS, SAL=3000, DEPTNO=30}]";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
		var result = JSON.stringify("<%=imsi%>");
		var jsonDoc = JSON.parse(result);
		for(var i=0;i<jsonDoc.length;i++){
// 			alert("empno:"+jsonDoc[i].EMPNO);
			out.print();
		}
</script>
</body>
</html>