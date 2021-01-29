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
<title>Insert title here</title>
<script type="text/javascript">
	function login(){
		var id = $("#l_id").val();
		var pw = $("#l_pw").val();
		if(id == null||id.length<1||pw ==null||pw.length<1){
			 $.messager.alert('INFO','ID와 PW를 확인해주세요.');
		} else {
// 			if()
		}
		
	}


</script>

</head>
<body>

	<div id="d_date" style="width:150px; align:center;">
		<input id="l_id" class="easyui-textbox" label="I.D" style="width:200px">
		<br>
		<input id="l_pw" class="easyui-textbox" label="P.W" style="width:200px">
		<a id="b_login" class="easyui-linkbutton">로그인</a>
	</div>

</body>
</html>