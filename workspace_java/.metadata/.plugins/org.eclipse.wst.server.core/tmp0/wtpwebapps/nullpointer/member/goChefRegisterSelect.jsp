<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String msg = (String)request.getAttribute("msg");%>
<%if(msg.equals("이미 셰프인 회원입니다")||msg.equals("셰프 신청 중인 상태입니다")){%>
<script>
alert("<%=msg%>");
history.go(-1);
</script>
<%}else{%>
<script>
alert("<%=msg%>");
location.href="/member/index.jsp";
</script>
<%} %>