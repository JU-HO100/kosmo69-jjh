<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String msg = (String)request.getAttribute("msg");%>
<%if(msg!=null){%>
<script>
alert("<%=msg%>");
location.href="/cookclass/cookingClassList.jsp";
</script>
<%}%>