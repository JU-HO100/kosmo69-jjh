<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript" src="<%=path.toString() %>js/admin.js"></script>
<script type="text/javascript">
function addChef(){
	var row = $('#member').datagrid('getSelected');
	$("#member").datagrid({
	   url: "/admin/commitChef.np?admin_id=admin&m_id="+row.아이디
	  ,toolbar:'#tbar_member'
	  ,rownumbers:true
	  ,method:'get'
   	  ,columns:[[
   				 {field:'CK',checkbox:true, width:50, align:'center'}	
                ,{field:'아이디',title:'아이디',width:150, editor:'text'}
                ,{field:'닉네임',title:'닉네임',width:100, editor:'text'}
                ,{field:'주소',title:'주소',width:220, editor:'text'}
                ,{field:'전화번호',title:'전화번호',width:130, editor:'text'}
                ,{field:'이름',title:'이름',width:80, editor:'text'}
                ,{field:'생성일',title:'생성일',width:130, editor:'text'}
                ,{field:'성별',title:'성별',width:60, editor:'text'}
                ,{field:'생년월일',title:'생년월일',width:120, editor:'text'}
                ,{field:'만 나이',title:'만 나이',width:50, editor:'text'}
                ,{field:'메일주소',title:'메일주소',width:220, editor:'text'}
                ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
                ,{field:'블랙리스트',title:'블랙리스트',width:80, editor:'text'}
                ,{field:'누적신고량',title:'누적신고량',width:80, editor:'text'}
                ,{field:'게시물개수',title:'게시물개수',width:80, editor:'text'}
                ,{field:'인기게시물개수',title:'인기게시물개수',width:110, editor:'text'}
       ]]	
	});	
history.go(0);
} 
function addBlack(){
	var row = $('#member').datagrid('getSelected');
		$("#member").datagrid({
		   url: "/admin/addBlack.np?admin_id=admin&m_id="+row.아이디
		  ,toolbar:'#tbar_member'
		  ,rownumbers:true
		  ,method:'get'
	   	  ,columns:[[
	   				 {field:'CK',checkbox:true, width:50, align:'center'}	
	                ,{field:'아이디',title:'아이디',width:150, editor:'text'}
	                ,{field:'닉네임',title:'닉네임',width:100, editor:'text'}
	                ,{field:'주소',title:'주소',width:220, editor:'text'}
	                ,{field:'전화번호',title:'전화번호',width:130, editor:'text'}
	                ,{field:'이름',title:'이름',width:80, editor:'text'}
	                ,{field:'생성일',title:'생성일',width:130, editor:'text'}
	                ,{field:'성별',title:'성별',width:60, editor:'text'}
	                ,{field:'생년월일',title:'생년월일',width:120, editor:'text'}
	                ,{field:'만 나이',title:'만 나이',width:50, editor:'text'}
	                ,{field:'메일주소',title:'메일주소',width:220, editor:'text'}
	                ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
	                ,{field:'블랙리스트',title:'블랙리스트',width:80, editor:'text'}
	                ,{field:'누적신고량',title:'누적신고량',width:80, editor:'text'}
	                ,{field:'게시물개수',title:'게시물개수',width:80, editor:'text'}
	                ,{field:'인기게시물개수',title:'인기게시물개수',width:110, editor:'text'}
	       ]]	
		});	
	history.go(0);
	} 
	
function removeBoard() {
	var row = $('#board').datagrid('getSelected');
	$("#board").datagrid({
	   url: "/admin/delBoard.np?admin_id=admin&m_id="+row.아이디+"&b_c_num="+row.게시번호
	  ,toolbar:'#tbar_board'
	  ,rownumbers:true
	  ,method:'get'
   	  ,columns:[[
			 {field:'CK',checkbox:true, width:50, align:'center'}	
              ,{field:'게시번호',title:'게시번호',width:65, editor:'text'}
              ,{field:'대분류',title:'대분류',width:75, editor:'text'}
              ,{field:'소분류',title:'소분류',width:85, editor:'text'}
              ,{field:'글제목',title:'글제목',width:200, editor:'text'}
              ,{field:'해시태그',title:'해시태그',width:200, editor:'text'}
              ,{field:'게시일',title:'게시일',width:160, editor:'text'}
              ,{field:'좋아요수',title:'좋아요수',width:60, editor:'text'}
              ,{field:'조회수',title:'조회수',width:60, editor:'text'}
              ,{field:'게시물상태',title:'게시물상태',width:120, editor:'text'}
              ,{field:'아이디',title:'아이디',width:220, editor:'text'}
              ,{field:'닉네임',title:'닉네임',width:80, editor:'text'}
              ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
       ]]	
	});	
history.go(0);
}
function removeCookclass() {
	var row = $('#cookclass').datagrid('getSelected');
	$("#cookclass").datagrid({
	   url: "/admin/delClass.np?admin_id=admin&m_id="+row.아이디+"&b_c_num="+row.쿠킹클래스번호
	  ,toolbar:'#tbar_cookclass'
	  ,rownumbers:true
	  ,method:'get'
   	  ,columns:[[
				 {field:'CK',checkbox:true, width:50, align:'center'}	
	                ,{field:'쿠킹클래스번호',title:'쿠킹클래스번호',width:110, editor:'text'}
	                ,{field:'회원아이디',title:'회원아이디',width:130, editor:'text'}
	                ,{field:'회원닉네임',title:'회원닉네임',width:100, editor:'text'}
	                ,{field:'신청현황',title:'신청현황',width:100, editor:'text'}
	                ,{field:'셰프아이디',title:'셰프아이디',width:150, editor:'text'}
	                ,{field:'셰프닉네임',title:'셰프닉네임',width:150, editor:'text'}
	                ,{field:'쿠킹클래스이름',title:'쿠킹클래스이름',width:250, editor:'text'}
	                ,{field:'준비물',title:'준비물',width:250, editor:'text'}
	                ,{field:'현재인원',title:'현재인원',width:60, editor:'text'}
	                ,{field:'최대인원',title:'최대인원',width:60, editor:'text'}
	                ,{field:'쿠킹클래스주소',title:'쿠킹클래스주소',width:185, editor:'text'}
	                ,{field:'상세주소',title:'상세주소',width:90, editor:'text'}
       ]]	
	});	
history.go(0);
}
</script>
</head>
<body>
			    <div class="easyui-tabs" style="width:100%;height:1000px;">
			        <div title="회원관리">
			        	<%@include file="./memberControlContent.jsp" %>
			        </div>
			        <div title="게시판 관리">
			        	<%@ include file="./boardControlContent.jsp" %>
			        </div>
			        <div title="쿠킹클래스 관리">
			        	<%@ include file="./cookingClassControlContent.jsp" %>
		  	     	</div>
		    	</div>
</body>
</html>