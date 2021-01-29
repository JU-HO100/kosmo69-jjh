<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test.jsp</title>
<jsp:include page="../../../common/easyui_common.jsp" flush="false"/>
<script type="text/javascript">
<%String test = "t";%>
	function test(){
		if($('#test').val() != null){
			<%@ include file="../../../include/sub.jsp"%>
			$('#test').textbox('setValue',"<%= test1 %>");
		}
	}

</script>
</head>
<body>
<input id="test" name="test" class="easyui-textbox" value="<%=test %>" style="widht:200">
<input type="button" onClick="test()">
</body>
</html>