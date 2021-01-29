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
<title>typeD.jsp[비동기통신 체험하기]</title>

</head>
<body>
<script type="text/javascript">
	$.ajax({
	    url:'./a3.do'
// 	    url:'./a3.do?mem_id=test&mem_pw=123'
	   ,method:'post'
	   ,success:function(data){
// 			alert(data);
			$('#d_msg').html(data);
// 			$('#d_msg').text(data);/* text의 경우 태그들도 text로 인식해서 태그도 다 보여준다. */
	   }
	 });
</script>
<!-- <div class="easyui-datagrid" data-options="url:'./a3.do', method:'post', title:'사원관리'"> -->
<div id="d_msg">

</div>
</body>
</html>