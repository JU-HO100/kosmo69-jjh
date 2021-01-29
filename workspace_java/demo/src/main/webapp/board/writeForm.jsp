<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기화면[webapp]</title>
<%@ include file="../common/easyUI_common.jsp" %>
<script>
	function addAction(){
		//$("#f_write").attr("method","post");
		//$("#f_write").attr("action","/board/boardInsert.sp");
		$("#f_write").submit();
	}
	function writeClose(){
		window.close();
	}
</script>
</head>
<body>
<div id="dlg_boardAdd" title="글쓰기" class="easyui-panel" 
style="width:650px;height:450px;padding:10px" data-options="footer:'#tbar_boardAdd'">	
	<form id="f_write" action="/board/boardInsert.sp" method="post" enctype="multipart/form-data">
	<input type="hidden" name="bm_no" value="0">
	<input type="hidden" name="bm_group" value="0">
	<input type="hidden" name="bm_pos" value="0">
	<input type="hidden" name="bm_step" value="0">
	<table>
		<tr>
			<td width="100px">제목</td>
			<td width="500px">
				<input class="easyui-textbox" data-options="width:'350px'" id="bm_title" name="bm_title" required>
			</td>
		</tr>
		<tr>	
			<td width="100px">작성자</td>
			<td width="500px">
				<input class="easyui-textbox" data-options="width:'150px'" id="bm_writer" name="bm_writer" required>
			</td>
		</tr>
		<tr>
			<td width="100px">이메일</td>
			<td width="500px">
				<input class="easyui-textbox" data-options="width:'250px'" id="bm_email" name="bm_email">
			</td>
		</tr>
		<tr>			
			<td width="100px">내용</td>
			<td width="500px">
				<input class="easyui-textbox" id="bm_content" name="bm_content" data-options="multiline:'true',width:'400px',height:'90px'" required>
			</td>
		</tr>
		<tr>			
			<td width="100px">비번</td>
			<td width="500px">
				<input class="easyui-textbox" data-options="width:'100px'" id="bm_pw" name="bm_pw" required>
			</td>
		</tr>
		<tr>			
			<td width="100px">첨부파일</td>
			<td width="500px">
				<input class="easyui-filebox" data-options="width:'450px'" id="bs_file" name="bs_file">
			</td>
		</tr>
	</table>
	</form>
</div>	
	<!-- 입력 화면 버튼 추가 -->
	<div id="tbar_boardAdd" align="right">
		<a href="javascript:addAction()" class="easyui-linkbutton" iconCls="icon-save">저장</a>
		<a href="javascript:writeClose()" 
		   class="easyui-linkbutton" iconCls="icon-cancel">닫기</a>
	</div>	
</body>
</html>