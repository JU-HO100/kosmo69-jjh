<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String msg = (String)request.getAttribute("msg");%>
<%if(msg.equals("셰프로 등록되어 있는 유저만 사용할 수 있습니다")){%>
<script>
alert("<%=msg%>");
history.go(-1);
</script>
<%}else{%>
<script>
location.href="/cookclass/cookingClassRegisterContent.jsp";
</script>
<%} %>