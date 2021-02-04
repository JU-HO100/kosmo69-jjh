<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/bootstrap_common.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="g_main"></div>
<input type="button"   class="btn btn-outline-secondary"  onclick="add()"  value="조리법 추가">
<script type="text/javascript">
	var g_i=0;
	function del(data){
		alert("data:"+data);
	
		for(var x=0;x<g_i;x++){
			if(x==data){
				$("#d"+x).text("");
			}
		}
	}
	function add(){
		var cnt = 0;
		var temp="<table><tr><td>조리법<textarea onkeyup='adjustHeight();'style='overflow: hidden;width:100%' placeholder='해당 순서의 조리법을 작성해주세요.' name='recipe_info'></textarea></td></tr><tr><td>조리법사진</td></tr><tr><td><input type='file' id='file' name='file'><img name='sub_img'alt='이미지를 선택해주세요.' width='150px' height='100px' ></td></tr></table>"
		//g_i = g_i + 1;
		$.ajax({
			//url:'b.jsp',
			success:function (data){
				$("#g_main").append("<div id=d"+g_i+">"
				+"<table><tr><td>조리법<textarea onkeyup='adjustHeight();'style='overflow: hidden;width:100%' placeholder='해당 순서의 조리법을 작성해주세요.' name='recipe_info'></textarea></td></tr><tr><td>조리법사진</td></tr><tr><td><input type='file' id='file' name='file'><img name='sub_img'alt='이미지를 선택해주세요.' width='150px' height='100px' ></td></tr></table><input type='button' value='삭제' onClick='del("+g_i+")'></div>");
				g_i=g_i+1;
			}
		});
	}
</script>
</body>
</html>