<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<script type="text/javascript">
//게시판불러오기 스크립트
$(document).ready(function (){
$("#cookclassMember").datagrid({
		url:"/cookclass/myClassMemList.np"
	  ,toolbar:'#tbar_ingredient'
	  ,rownumbers:true
	  ,method:'get'
	  ,columns:[[
             {field:'JAELYO',title:'재료명',width:220, editor:'text'}
             ,{field:'WEIGHT',title:'계량',width:220, editor:'text'}
             ,{field:'UNIT',title:'단위',width:220,editor:'text'}
    	]]	
	});	
});
</script>
<title>오늘 뭐 먹지?</title>
</head>
<body>
	<table id="cookclassMember"  title="재료등록" style="width: 100%; height: 1000px" >
	</table>
	<div id="tbar_ingredient">
		<script>
			function doSearch(value,name){
			alert('You input: ' + value+'('+name+')');
			}
		</script>
	</div>
</body>
</html>