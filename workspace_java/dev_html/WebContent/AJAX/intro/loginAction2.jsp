<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mem_name = (String)request.getAttribute("mem_name");
%>
<script type="text/javascript">
//쿠키에 이름을 저장하기 - 보안상 중요하지 않는 정보 담기 - 예)장바구니 , 찜한 상품, 오늘하루 보지않기
	$.cookie("cname","<%=mem_name %>");
</script>
<%=mem_name %>



