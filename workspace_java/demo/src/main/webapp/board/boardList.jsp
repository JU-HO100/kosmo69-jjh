<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.HashMap, java.util.Map" %>    
<%@ page import="com.util.PageBar" %>
<%
	int tot = 0;
	int numPerPage = 5;
	int nowPage = 0;
	if(request.getParameter("nowPage")!=null){
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
	
	List<Map<String,Object>> boardList = null;
	boardList = (List<Map<String,Object>>)request.getAttribute("boardList");
	if(boardList !=null){
      tot = boardList.size();
   }
   
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록[webapp]</title>
<%@ include file="/common/easyUI_common.jsp" %>
<script type="text/javascript">
//상세보기 페이지 이동 - read.jsp - 오라클 경유 - select인데 조건절이 포함.
//로직과 Dao는 동일하게 사용하더라도 컨트롤계층의 메소드는 다르게 정의함.
//왜냐하면 응답페이지가 다르니까 boardList.jsp, read.jsp
   function boardDetail(p_bmno){
      location.href="/board/boardDetail.sp?bm_no="+p_bmno+"&gubun=detail";
   }
   function refresh(){
      alert("refresh호출");
      location.href="/board/boardList.sp";      
   }
   function downlaod(pbs_file){
      location.href="./downLoad.jsp?bs_file="+pbs_file;
   }
   function updForm(){
	   alert("updForm 호출");
	   location.href="/board/.sp?bm_no="+bm_no;
   }
</script>
</head>
<body>
<script type="text/javascript">
   function addForm(){
      let url="writeForm.sp";//var대신 ECMAScript제안한 let예약어 사용할것.- Reat.js, Vue.js, TypeScript.js
      cmm_window_popup(url,"700px","500px","writeForm");      
   }
</script>
<!-- 
======================== [[글목록 화면 시작]] =========================
JEasyUI의 DataGrid API를 활용하여 작성
1)익스프레션을 이용해서 화면 처리
  :tr, td태그를 직접 작성해서 처리하는 방식
2)json포맷으로 처리해서 매핑
  :field명만 맞춰주면 자동으로 매핑
 -->
 
 <table id="dg_board" title="글목록" style="width:950px;height:500px" class="easyui-datagrid" data-options="singleSelect:'true',toolbar:'#tb_search,#tb_board'">
    <!--헤더부분 추가 -->
    <thead>
       <tr>
          <th data-options="field:'BM_TITLE',width:'350px'">제목</th>
            <th data-options="field:'BM_WRITER',width:'100px'">작성자</th>
            <th data-options="field:'BM_DATE',width:'110px'">작성일</th>
            <th data-options="field:'BS_FILE',width:'280px'">첨부파일</th>
            <th data-options="field:'BM_HIT',width:'100px'">조회수</th>
       </tr>
    </thead>
    <tbody>
<!--==================== 조회결과가 없는 경우 ==================-->    
<%
   if(tot==0){
%>
       <tr>
          <td colspan="5">&nbsp;조회 결과가 없습니다.</td>
       </tr>
       
<!--==================== 조회결과가 있는 경우 ==================-->    
<%
   }else if(tot > 0){
		int num = tot-(numPerPage*nowPage);
// 		for(int i=0;i<tot;i++){
		for(int i=nowPage*numPerPage;i<(nowPage*numPerPage)+numPerPage;i++){
         Map<String,Object> rmap = boardList.get(i);
         if(i==(tot-1)){
        	 break;//마지막페이지에는 데이터가 없기 때문에 넣어줘야한다.
         }
%>
       <tr>
          <td>
<!-- 너 댓글이니? -->
<%
   String imgPath = "\\images\\";
   if(Integer.parseInt(rmap.get("BM_POS").toString ()) > 0){
      for(int j=0;j<Integer.parseInt(rmap.get("BM_POS").toString());j++){
         out.print("&nbsp;&nbsp;");
      }
%>
<img src="<%=imgPath %>reply.gif" border="0">
<%
   }
%>          
          <a href="javascript:boardDetail('<%=rmap.get("BM_NO")%>')">
          <%=rmap.get("BM_TITLE") %>
          </a>
          
          </td>
            <td><%=rmap.get("BM_WRITER")%></td>
            <td><%=rmap.get("BM_DATE") %></td>
            <td>
            <%
            if(!"첨부파일이 없습니다.".equals(rmap.get("BS_FILE").toString())){
            %>
            <a href="javascript:downlaod('<%=rmap.get("BS_FILE") %>')">
            <%=rmap.get("BS_FILE") %>
            </a>
         <%
            }
         else{
         %>            
            <%="첨부파일이 없습니다."%>
         <%
         }
         %>            
            
            </td>
            <td><%=rmap.get("BM_HIT") %></td>
       </tr>       
<%
      }
   }
%>       
    </tbody>
 </table>
 <!--=========================[[ 페이지 네이션 추가 ]] ========================-->
 <table id="dg_board" title="글목록" style="width:950px;height:20px">
	<tr>
	<td align="center">
       
		<font size="14">1 2 3 4 5 6 7 8 9 10</font>
		<br>
		<font size="14">
<%
		String pagePath = "boardList.sp";
//int numPerPage(한페이지에 몇개씩), int totalRecord(전체로우수), int nowPage(내가 바라보는 페이지), String pagePath(어떤 페이지에 적용할거니? newList.jsp, boardList.jsp)
		PageBar pb = new PageBar(numPerPage, tot, nowPage, pagePath);
		out.print(pb.getPageBar());
%>       
       
       </font>
       </td>
    </tr>
 </table>
 <!-- 조건검색 추가(툴바하기) -->
 <div id="tb_search" style="padding:2px 5px;">
    <select id="cb_search" name="cb_search" class="easyui-combobox" panelHeight="auto" style="width:100px">
       <option selected value="">선택</option>
       <option value="bm_title">제목</option>
       <option value="bm_content">내용</option>
       <option value="bm_writer">작성자</option>
    </select>
    <input class="easyui-textbox" id="keyword" name="keyword" style="width:320px">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    작성일:<input class="easyui-datebox" id="bm_date" name="bm_date" style="width:120px">
 </div>
 <div id="tb_board" style="padding:2px 5px;">
    <a href="javascript:boardList()" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
    <a href="javascript:addForm()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">입력</a>
    <a href="javascript:updForm()" class="easyui-linkbutton" iconCls="icon-add" plain="true">수정</a>
    <a href="javascript:delForm()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>
</div>    
<!--======================[[ 글쓰기 화면 추가 시작 ]]=====================-->
    <!-- 
    <div id="dlg_write" class="easyui-dialog" title="글쓰기" data-options="iconCls:'icon-save'" style="width:700px;height:500px;padding:10px">
        The dialog content.
    </div>
     -->
<!--======================[[ 글쓰기 화면 추가   끝  ]]=====================-->
</body>
</html>

















