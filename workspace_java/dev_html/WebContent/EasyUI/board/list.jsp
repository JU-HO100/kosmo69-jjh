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
<title>list.jsp</title>
<!-- *************************************************** 테이블 위치 ********************************************************** -->
    
    <script type="text/javascript">
    	var b_num;
    	var g_num;
		function contente(){
				$.ajax({
	   				url:'./getContente.js?b_num'+b_num 
	   				,datatype:'json'
	   				,method:'Get'
	   				,success:function(data){
	   					var result = JSON.stringify(data);
	   					 g_num = JSON.parse(result);
	   					<% 
	   					RequestDispatcher view = request.getRequestDispatcher("contente.jsp");
	   					view.forward(request, response); 
	   					%>
	   				}
	   			});
				location.href 
		}
    </script>

</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		$('#b_list').datagrid({
			url:"./getlist.jsp"
			,singleSelect:true
			,columns:[[
					    {field:'B_NUM'	 ,title:'글번호'	,width:100, editor:'text', align:'center'}
					   ,{field:'B_TITLE' ,title:'글제목'	,width:500, editor:'text', align:'center'}
					   ,{field:'B_DAY'	 ,title:'날짜'	,width:250, editor:'text', align:'center'}
					   ,{field:'B_HITS'	 ,title:'조회수'	,width:100, editor:'text', align:'center'}
					   ,{field:'B_MEM'	 ,title:'작성자'	,width:200, editor:'text', align:'center'}
					 ]]
			,onClickRow: function(index, row){
				b_num = document.getElementById("b_num").value=row.B_NUM;
				if(b_num != null){
					href:"contente()"
				}
			}
		});
	});
</script>
	
    <div id="topForm">
            <a class="easyui-linkbutton" href="./writing.jsp">글쓰기</a>
    </div>
    <div>
        <table id="b_list" class="easyui-datagrid" style="height:600; width:80%;">
        </table>
    </div>
    <br>
    <div id="pageForm">
        페이지 번호
    </div>
    <br>
    <div id="searchForm">
			<select id="opt">
				<option>제목</option>
				<option>제목+내용</option>
				<option>내용</option>
				<option>작성자</option>
			</select>
            <input type="text" size="20" name="condition" />&nbsp;
            <input type="submit" value="검색"/>
    </div>    
<form action="getContente.jsp">
	        <input id="b_num" name="b_num" type="text" hidden/>
</form>
</body>
</html>