<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.HashMap, java.util.Map" %>    
<%
/*
 UI를 무엇으로 하는가?
		 js기반인 경우:json으로 처리한다. jsonBoardList.jsp 생성하기
		 아래코드는 필요없다.:부트스트랩, 시맨틱UI, EasyUI
		 , 안드로이드(특별한 경우를 제외하면 오라클과 매번 연동하지 않는다, 오라클 대신 NoSQL제품과 연동한다.)
		xml기반인 경우 : 넥사크로, 플렉스, 트러스트 폼....
		조회결과를 xml문서로 출력해준다. - contentType:text/xml
	넥사크로에서는 조회된 결과를 넥사크로 에서 제공하는 DataSet객체에 담아준다
	화면을 지원하는 Grid와 DataSet을 매핑하여 출력함.
		xmlBoardList.jsp가 필요하다. - xml로 만들어지는 별도의 jsp
	그러나 넥사크로측에서는 이러한 불편함을 해소하기 위해 직접 자바단에서 xml포맷을 생성해주는 api를 지원하고 있다.
*/
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
<title>상세보기[WEB-INF]</title>
<%@ include file="/common/easyUI_common.jsp" %>
<script type="text/javascript">
/* 댓글과 새글의 차이는 뭘까?
   새글에는 없지만 댓글에는 있다?
  글번호 : 새글이나 댓글 이나 모두 새로 채번되어야 한다. - 생각 정리 - 기능설계 -  필요한 정보선택
  글그룹번호 : 댓글에 또 댓글을 달수 있다. - 업무요구사항 - 새로 채번되는 것이 아니라 있는 번호를 가져온다.
  댓글의 경우 
  read.jsp 시작된다.
  select가 한 건이 되었다.
  내 뒤에 댓글이 존재할 경우 b_step의 값을 1씩 증가시켜야 한다. - 공감
  update 테이블명
     set bm_step = bm_step + 1
   where bm_group = 5  read.jsp
      and bm_step > 화면에서 가져온 bm_step값 read.jsp
*/
	function repleForm(){
		let url="repleForm.sp?bm_no="+<%=rMap.get("BM_NO").toString()%>;//var대신 ECMAScript제안한 let예약어 사용할것.- Reat.js, Vue.js, TypeScript.js
		cmm_window_popup(url,"700px","500px","repleForm");				
	}
  	function refresh(){
		//alert("refresh호출");
		location.href="/board/boardList.sp";		
	}      
  	function deleteView(){
  		$('#dlg_boardDel').dialog({
  			buttons: btn_boardDel,
  		    title: '글 삭제',
  		    width: 400,
  		    height: 250,
  		    closed: true,
  		    cache: false,
  		    href: 'boardDelForm.jsp?bm_no=<%=rMap.get("BM_NO")%>&bm_pw<%=rMap.get("BM_PW")%>',
  		    modal: true
  		});
  		$('#dlg_boardDel').dialog('open');
  	}
  	function deleteboard(){
  		//DB에서 받아온 비번을 담기
  		//자바스크립트 변수 선언시 앞으로는 var대신에 let함수를 사용하자 - ES5추천
  		//전변과 지변차이, 버그에 대한 예방 - 스크립트는 컴파일을 하지 않음.
  		//타입이 런타임시에 결정이된다. - 파이썬도 동일한 구조를 가지고 있다. - 모두가 객체이면서 타입을 정하지 않아도 들어오는 값에 따라 결정이 된다.
  		//파이썬 같은 경우 순차적으로 실행이 된다.
  		let db_pw = <%=rMap.get("BM_PW") %>
  		//사용자가 입력한 비번 담기
  		let u_pw = $("#u_pw").textbox('getValue');
		if(db_pw == u_pw){
			//자바스크립트에서는 0이 아니면 모두가 true 이다
			$.messager.confirm('Confirm','정말 삭제할거니?',function(r){
				if(r){
// 					alert('ok');
					location.href="boardDelete.sp?bm_no=<%=rMap.get("BM_NO")%>&bs_file=<%=rMap.get("BS_FILE")%>";
				}
			});
		}	
  	}
</script>
</head>
<body>
<!--===========================[[ 글상세 보기 화면 ]]===========================-->
<table id="pan_read" class="easyui-panel" title="글상세보기" data-options="footer:'#tb_read'"
 style="width:670px;height:380px;padding:10px;background:#fafafa;">
   <tr>
      <td>제목</td>
      <td><input class="easyui-textbox" value="<%=rMap.get("BM_TITLE") %>" id="bm_title" data-options="width:'450px'"></td>
   </tr>
   <tr>
      <td>작성자</td>
      <td><input class="easyui-textbox" value="<%=rMap.get("BM_WRITER") %>" id="bm_writer" data-options="width:'450px'"></td>
   </tr>
   <tr>
      <td>이메일</td>
      <td><input class="easyui-textbox" value="<%=rMap.get("BM_EMAIL") %>" id="bm_email" data-options="width:'450px'"></td>
   </tr>
   <tr>
      <td>내용</td>
      <td><input class="easyui-textbox" value="<%=rMap.get("BM_CONTENT") %>" id="bm_content" data-options="multiline:'true',width:'450px', height:'90px'"></td>
   </tr>
   <tr>
      <td>비밀번호</td>
      <td><input class="easyui-textbox" value="<%=rMap.get("BM_PW") %>" id="bm_pw" data-options="width:'450px'"></td>
   </tr>
</table>
<!--===========================[[ 글상세 보기 화면 버튼 ]]===========================-->
 <div id="tb_read" style="padding:2px 5px;" align="center">
    <a href="javascript:repleForm()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">댓글쓰기</a>
    <a href="javascript:updateForm()" class="easyui-linkbutton" iconCls="icon-add" plain="true">수정</a>
    <a href="javascript:deleteboard()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>
    <a href="javascript:boardList()" class="easyui-linkbutton" iconCls="icon-search" plain="true">목록</a>
</div>
<!--===========================[[ 댓글쓰기 화면 시작  ]]===========================-->

<!--===========================[[ 댓글쓰기 화면  끝   ]]===========================-->
<!--===========================[[ 글삭제 화면 시작  ]]===========================-->
<div id="dlg_boardDel" closed="true" class="easyui-dialog" style="padding:20px 50px">
	<div id="btn_boardDel" align="right">
		<a href="javascript:deleteBoard()" class="easyui-linkbutton" iconCls="icon-ok" plain="true">확인</a>
		<a href="javascript:deleteClose()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">닫기</a>
	</div>

</div>
<!--===========================[[ 글삭제 화면  끝   ]]===========================-->
</body>
</html>