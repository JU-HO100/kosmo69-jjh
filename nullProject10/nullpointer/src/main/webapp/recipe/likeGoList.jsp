<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% String msg = (String)request.getAttribute("msg"); %>
<% String menucd = (String)request.getAttribute("menucd"); %>
<% String id = (String)session.getAttribute("id");%>
<script type="text/javascript">
function like() {
	var id = "<%=id%>";
	var menucd="<%=menucd%>";
	$.ajax({
		type : "GET"
		,url : "/recipe/clickLike.np?m_id="+id+"&menucd="+menucd
		,dataType : "html"
		,success : function(data){
			 $('#dolike').html(data);
		}
	});
}
</script>
</head>
<body>
<%if(msg.equals("1") || msg.equals("좋아요를 눌렀습니다")){%>
<img src="/images/likeOn.png" style="width: 15px; cursor: pointer;" onclick="javascript:like();">
<%}else{%>
<img src="/images/likeOff.png" style="width: 15px; cursor: pointer;" onclick="javascript:like();">
<%} %>
</body>
</html>
