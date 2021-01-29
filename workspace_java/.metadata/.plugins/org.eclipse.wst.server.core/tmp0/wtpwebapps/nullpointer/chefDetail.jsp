<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div id="dlg_chefDetail" closed="true" class="easyui_dialog" >
<table style="width: 100%;" class="table table-hover">
<tbody>
<%
			for(int i=0;i<7;i++){
			//Map<String,Object> rmap = boardList.get(i);
%>
		      <tr style="cursor: pointer;">
		      	<td style="width: 20%;">
		      		<input type="image" src="./images/food.jpg" style="width: 100%;">
		      	</td>
		        <td style="width: 60%">한식 요리<%=i+1 %></td>
		        <td style="width: 20%">____셰프</td>
		      </tr>
<%
			}
%>
</tbody>
</table>
</div>
</body>
</html>