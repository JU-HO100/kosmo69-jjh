<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="web.mvc.BbsDAO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%-- <jsp:useBean id="list" class="web.mvc.BbsVO" scope="page"/> --%>
<%-- <jsp:setProperty name="list" property="title"/> --%>
<%-- <jsp:setProperty name="list" property="contente"/> --%>
<% 
	Date nowTime = new Date(); 
	SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>
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
<%@ page import="java.text.SimpleDateFormat" %>

<title>list.jsp</title>
<style type="text/css">
	 #wrap {
            width: 800px;
            margin: 0 auto 0 auto;
        }
</style>
<script type="text/javascript">
		var p1 = $('#pass1');
		var p2 = $('#pass2');
		var t_title = $('#title');
		var t_name = $('#name'); 
		var t_contente = $('#contente');
		
	function ins(){
		if(t_title==null||t_name==null||t_contente==null){
			alert('내용을 확인해주세요.');	
		} else {
			if(p1 == p2){
				alert('비밀번호를 확인해주세요.');
			} else {
				alert('확인되었습니다.');
				
			}
		}
	}
	
</script>
</head>
<body>
<script type="text/javascript">
	
</script>
<form name="f_writing" action="insertwriting.jsp" method="post">
	<div id="wrap" name="wrap" style="width:700px;">
		<table id="t_head" name="t_head" title="글쓰기" border="1">
			<tr>
				<td>
			   		<input class="easyui-textbox" id="title" name="title" label="제목" style="width:550px; border:'1';" data-options="prompt:'제목을 지어주세요'">
			   		<br>
			   		<input class="easyui-textbox" id="name" name="name" label="작성자" style="width:550px; border:'1';" data-options="prompt:'이름을 적어주세요'">
			    	<br>
<!-- 			    	<label style="width:100px; border:0;">날짜</label> -->
<!-- 			    	<input  id="day" name="day" type="date"  style="width:300px; border:'1';" readonly/> -->
			   <br>
<!-- 			   		<input class="text" id="contente" name="contente" style="width:550px; height:600px " > -->
			    <textarea id="contente" name="contente" rows="30" cols="75" ></textarea>
			    <div id="d_pass" align="left">
			    	<input id="pass1" name="pass1" class="easyui-passwordbox" prompt="Password" data-options="prompt:'p.s'">
			    	<input id="pass2" class="easyui-passwordbox" prompt="Password" data-options="prompt:'p.s확인'">
			    </div>
		    	<div id="d_btn" align="right">
<!-- 		        <a id="btn_ins" class="easyui-linkbutton" href="javascript:ins()">등록</a> -->
				<input id="btn_ins" name="btn_ins" type="submit" value="입력"/> 
		        <a id="btn_cancel" class="easyui-linkbutton" href="./list.jsp">등록취소</a>    
			    </div>
			    </td>
			 </tr>
		</table>
	</div>    
</form>

</body>
</html>