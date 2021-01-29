<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<title>글 내용</title>


</head>
<body>
<script type="text/javascript">
	$(documet).ready({
		$('#dg_contente').datagrid({
			
			
		});
	});
</script>
<div>
<form action="./getContente.jsp">
	<table id="dg_contente" name="dg_contente" class="esayui-datagrid" style="border:'1';align:'center'">
		<tr>
			<td style="align:'left'">
				<label width="50">글번호:</label>
				<input id="num" name="num" style="width:100; border:none;" type="text" readonly/>
			</td>
			<td style="align:'left'">
				<label width="50">제목:</label>
				<input id="title" name="title" style="width:200; border:none;" type="text" readonly/>
			</td>
			<td style="align:'left'">
				<label width="50">조회수:</label>
				<input id="hits" name="hits" style="width:100; border:none;" type="text" readonly/>
			</td>
			<td style="align:'left'">
				<label width="50">등록일:</label>
				<input id="uday" name="uday" style="width:100; border:none;" type="text" readonly/>
			</td>
			<td style="align:'left'">
				<label width="50">작성자:</label>
				<input id="uname" name="uname" style="width:100; border:none;" type="text" readonly/>
			</td>
		</tr>
	<tr>
<!-- 		<td id="ucontente" name="ucontente" width="600" colspan="2" height="500"> -->
		<td>
			<textarea id="ucontente" name="ucontente" rows="20" cols="60"></textarea>
		
		</td>
	</tr>
	</table>
</form>
</div>

</body>
</html>