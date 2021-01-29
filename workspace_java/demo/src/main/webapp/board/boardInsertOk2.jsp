<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String gubun = null;
	if(request.getParameter("gubun")!=null){
		gubun = request.getParameter("gubun");
	}
	if(gubun == null){
%>    
<script>
	alert("등록 되었습니다.");
	opener.location.href="javascript:refresh()";		
	self.close();
	//opener.location.href="javascript:refresh()";
</script>
<%
	}
	else{
%>
<script>
	alert("등록 되었습니다.");
	location.href="/board/boardList.sp";		
</script>
<%
	}
%>

