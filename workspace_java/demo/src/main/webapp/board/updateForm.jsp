<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.HashMap, java.util.Map" %>    
<%
   int tot = 0;
   List<Map<String,Object>> boardList = null;
   boardList = (List<Map<String,Object>>)request.getAttribute("boardDetail");
   Map<String,Object> rMap = new HashMap<>();
   if(boardList !=null){
      rMap = boardList.get(0);
   }
   
%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정화면[webapp]</title>
<%@ include file="/common/easyUI_common.jsp" %>
<script>
   function updAction(){
	   alert("수정 화면");
      //$("#f_write").attr("method","post");
      //$("#f_write").attr("action","/board/boardInsert.sp");
      $("#f_update").submit();
   }
   function writeClose(){
      window.close();
   }
</script>
</head>
<body>
<div id="dlg_boardUpd" class="easyui-panel" 
style="width:650px;height:450px;padding:10px" data-options="footer:'#tbar_boardUpd'">   
   <form id="f_update" action="/board/boardUpdate.sp" method="get">
   <input type="hidden" name="bm_no" value="<%=rMap.get("BM_NO")%>">
   <input type="hidden" name="bm_group" value="<%=rMap.get("BM_GROUP")%>">
   <input type="hidden" name="bm_pos" value="<%=rMap.get("BM_POS")%>">
   <input type="hidden" name="bm_step" value="<%=rMap.get("BM_STEP")%>">
   <input type="hidden" name="hbs_file" value="<%=rMap.get("BS_FILE")%>">
   <table>
      <tr>
         <td width="100px">제목</td>
         <td width="500px">
            <input class="easyui-textbox" value="<%=rMap.get("BM_TITLE")%>" data-options="width:'350px'" id="bm_title" name="bm_title" required>
         </td>
      </tr>
      <tr>   
         <td width="100px">작성자</td>
         <td width="500px">
            <input class="easyui-textbox" value="<%=rMap.get("BM_WRITER")%>" data-options="width:'150px'" id="bm_writer" name="bm_writer" required>
         </td>
      </tr>
      <tr>
         <td width="100px">이메일</td>
         <td width="500px">
            <input class="easyui-textbox"  value="<%=rMap.get("BM_EMAIL")%>" data-options="width:'250px'" id="bm_email" name="bm_email">
         </td>
      </tr>
      <tr>         
         <td width="100px">내용</td>
         <td width="500px">
            <input class="easyui-textbox" id="bm_content"  value="<%=rMap.get("BM_CONTENT")%>" name="bm_content" data-options="multiline:'true',width:'400px',height:'90px'" required>
         </td>
      </tr>
      <tr>         
         <td width="100px">비번</td>
         <td width="500px">
            <input class="easyui-textbox" value="<%=rMap.get("BM_PW")%>" data-options="width:'100px'" id="bm_pw" name="bm_pw" required>
         </td>
      </tr>
      <tr>         
         <td width="100px">첨부파일</td>
         <td width="500px">
            <input class="easyui-filebox" value="<%=rMap.get("BS_FILE")%>" data-options="width:'450px'" id="bs_file" name="bs_file">
         </td>
      </tr>
   </table>
   </form>
</div>   
   <!-- 입력 화면 버튼 추가 -->
   <div id="#tbar_boardUpd" align="right">
      <a href="javascript:updAction()" class="easyui-linkbutton" iconCls="icon-save">저장</a>
      <a href="javascript:writeClose()" 
         class="easyui-linkbutton" iconCls="icon-cancel">닫기</a>
   </div>   
</body>
</html>