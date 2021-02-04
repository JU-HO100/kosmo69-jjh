<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<meta charset="UTF-8">
</head>
<body>
<script type="text/javascript">	
	$(document).ready(function (){
		$.ajax({
		url:'/recipe/recipeList.np'
			,datatype:'json'
			,success:function(data){
				   var result = JSON.stringify(data);
				   var arr = JSON.parse(result);
				   for(var i=0;i<arr.length;i++){
					//   $("#u_empno").numberbox('setValue',arr[i].EMPNO);//초기화
						if(arr[i].MSG != null){//값을 못불러옴
							alert(arr[i].MSG);
						}
						else{//값 불러옴
							$("#c_cook").textbox('setValue',arr[i].C_COOK);//초기화
						}
				   }
			}
			});
	})
</script>
	<input class ="easyui-textbox"  id="c_cook" name="c_cook"  label = "제목" data-options="prompt:'Enter a ENAME'" style="width:250px"/>
</body>
</html>