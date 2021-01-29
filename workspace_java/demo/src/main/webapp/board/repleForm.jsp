<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.HashMap, java.util.Map" %>    
<%
	int tot = 0;
	List<Map<String,Object>> boardList = null;
	boardList = (List<Map<String,Object>>)request.getAttribute("repleForm");
	Map<String,Object> rMap = new HashMap<>();
	if(boardList !=null){
		rMap = boardList.get(0);
		out.print("그룹번호 : "+rMap.get("BM_GROUP"));
		out.print("차수 : "+rMap.get("BM_POS"));
		out.print("순번 : "+rMap.get("BM_STEP"));
	}
	
%>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글쓰기화면[webapp]</title>
<%@ include file="../common/easyUI_common.jsp" %>
<script>
	function addAction(){
		$("#f_reple").attr("method","post");
		$("#f_reple").attr("action","/board/boardInsert.sp");//새글과 댓글
		//$("#f_reple").attr("action","/board/boardInsert.sp?id=test");//새글과 댓글
		$("#f_reple").submit();
	}
	function writeClose(){
		window.close();
	}
</script>
</head>
<body>
<div id="dlg_boardAdd" title="글쓰기" class="easyui-panel" 
style="width:650px;height:450px;padding:10px" data-options="footer:'#tbar_boardAdd'">	
	<form id="f_reple">
	<!-- 페이지를 출력하기 전에 오라클을 경유한 결과값은 hidden에서 사용되고 -->
	<input type="hidden" name="bm_no" value="<%=rMap.get("BM_NO")%>">
	<input type="hidden" name="bm_group" value="<%=rMap.get("BM_GROUP")%>">
	<input type="hidden" name="bm_pos" value="<%=rMap.get("BM_POS")%>">
	<input type="hidden" name="bm_step" value="<%=rMap.get("BM_STEP")%>">
	<!-- 사용자가 화면에서 입력한 값은 폼 전송으로 처리함. -->
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