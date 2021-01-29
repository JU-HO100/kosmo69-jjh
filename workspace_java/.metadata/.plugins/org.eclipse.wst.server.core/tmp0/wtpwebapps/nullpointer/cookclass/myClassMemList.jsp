<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("id");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function cookclassMember() {
		var url = "/cookclass/myClassMemList.np?c_classcd=<%=request.getParameter("c_classcd")%>&chef_id=<%=request.getParameter("chef_id")%>&m_id=<%=id%>"
		var left = Math.ceil((window.screen.width - 700)/2);
	    var top = Math.ceil((window.screen.height - 700)/2);
  		var option = "width = 600, height = 600, top="+top+", left="+left+", location = no"
		window.open(url, name, option);
}
$.ajax({
	url: "/cookclass/myClassMemList.np?c_classcd=<%=request.getParameter("c_classcd")%>&chef_id=<%=request.getParameter("chef_id")%>"
	,success : function (result) { 
		$.each(result, function (index, item) {
			if(item.M_ID != null){
				var str = '<tr><td>';
				str += '';
				$('memberList').append(str);
						}
				   });
				}
			});
</script>
<table>
	<tr>
		<td>
			<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">신청 회원</h1>
		</td>
	</tr>
	<div id="memberList"></div>
	<tr>
		<td>
			회원1
		</td>
		<td>
			<input type="button" value="수락"><input type="button" value="반려">
		</td>				
	</tr>
	<tr>
		<td>
			회원2
		</td>
		<td>
			수락 완료
		</td>				
	</tr>
</table>
</body>
</html>