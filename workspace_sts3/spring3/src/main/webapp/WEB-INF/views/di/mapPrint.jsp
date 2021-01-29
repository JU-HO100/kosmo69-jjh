<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Iterator, java.util.Map" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>di/mapPrint</title>
</head>
<body>
<!-- servlet-context.xml문서에 ViewResolver활용하여 
응답페이지에 대한 URL을 완성하는데 설정이 추가됨.
접두어 /WEB-INF/views/
접미어 .jsp
 -->
 <%
 	Map<String,String> mapBean = (Map<String,String>)request.getAttribute("mapBean");
	Iterator<String> iter = mapBean.keySet().iterator();
	while(iter.hasNext()) {
		out.print(mapBean.get(iter.next()));
		out.print("<br>");
	}
 %>
</body>
</html>