<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매 시스템2</title>
<!-- 공통 코드 추가하기 -->
<%@ include file="../../common/easyui_common.jsp" %>
	<style type="text/css">
		#d_login{
		 border: 1px solid #FFFF00;
         background:  #2EFEF7;
         width: 192px;
         height: 105px;
			
		}
	</style>

</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		var cname=null;//쿠키에서 가져온 이름 담기
		cname = $.cookie('cname');
		//너 로그인 한거니?
		if(cname == null){//로그인 안했다.
			$("#login").show();
			$("#logout").hide();
		} else {//로그인 했다
			$("#logout").show();
			$("#login").hide();
			
		}
				
	});
</script>
<!-- EasyUI layout -->
<div id="cc" class="easyui-layout" style="width:1000px;height:500px;">
    <div data-options="region:'west',title:'CCV'" style="width:200px;">
    
    <!-- ==================================== [[로그인 영역]] ============================================================== -->
    	<div id="d_login" align="center">
	    	<input id="mem_id" class="easyui-textbox" width="100" >
			<script type="text/javascript">
				$("#mem_id").textbox({
					iconCls:'icon-man'
					,iconAlign:'right'
					,prompt:'아이디'
				});
			</script>
	    	<input id="mem_pw" class="easyui-passwordbox" width="100" >
			<script type="text/javascript">
				$("#mem_pw").textbox({
					prompt: '비밀번호'
			        ,showEye: true
					
				});
			</script>
			<br>
			    	<a id="btn_login" class="easyui-linkbutton" href="javascript:loginAction()" >로그인</a>
			    	<a id="btn_singup" class="easyui-linkbutton" href="javascript:singupAction()">회원가입</a>
    	</div>
    <!-- ==================================== [[로그인 영역]] ============================================================== -->
    <!-- ==================================== [[로그아웃 영역]] ============================================================== -->
    	<div id="d_logout" align="center">
<!-- 	    	<a id="btn_logout" class="easyui-linkbutton" onclick="logout()">로그아웃</a> -->
				<div style="margin:5px 0;"></div>
				<div id="d_ok">이순심님 환영합니다.</div>
				<div style="margin:3px 0;"></div>
			    	<a id="btn_logout" class="easyui-linkbutton" href="javascript:logoutAction()" >로그아웃</a>
			    	<a id="btn_update" class="easyui-linkbutton" href="javascript:updateAction()">정보수정</a>
			    	
    	</div>
    <!-- ==================================== [[로그아웃 영역]] ============================================================== -->
    <!-- ==================================== [[메뉴 영역 시작]] ============================================================== -->
    	<!-- ====================================== [[회원정보 메뉴 시작]] ===================================================================== -->
    	<div>
    		<ul id="tre_movie" class="easyui-tree">
           	 	<li data-option="state:'closed'">
			        <span>회원관리</span>
			        	<ul>
		                    <li>
		                    	<span>회원목록</span>
		                    </li>
		                    <li>
		                    	<span>회원등록</span>
		                    </li>
				            <li>
				            	<span>회원수정</span>
				            </li>
				            <li>
				            	<span>회원삭제</span>
				            </li>
			        	</ul>
		         </li>
           	 	<li data-option="state:'closed'">
	                <span>예매관리</span>
				        <ul>
		                    <li>
		                    	<span>예매목록</span>
		                    </li>
		                    <li>
		                    	<span>예매등록</span>
		                    </li>
				            <li>
				            	<span>예매수정</span>
				            </li>
				            <li>
				            	<span>예매삭제</span>
				            </li>
				        </ul>
			    </li>
	       </ul>
    	</div>
    	<!-- ====================================== [[회원정보 메뉴 끝]] ===================================================================== -->
    	<!-- ====================================== [[예매정보 메뉴 시작]] ==================================================================== -->
    	<div>
    	
    	</div>
    	
    	<!-- ======================================= [[예매정보 메뉴 끝]] ==================================================================== -->
    <!-- =========================================== [[메뉴 영역 끝]] ======================================================================= -->
<!--     "state":"closed" -->
    </div>
    <div data-options="region:'center',title:'영화예매 시스템'" style="padding:5px;background:#E0F8F7;">
    	<div style="margin:5px 0;"></div>
    	<!-- ====================================================== 시스템 메뉴 단계 시작 ====================================================== -->
    	Home > 회원관리 > 회원목록
    	<hr>
    	<!-- ====================================================== 콘텐츠 추가 시작 ========================================================== -->
    	<!-- =================================================== 조건검색 추가 시작 ============================================================ -->
    	<label>이름:</label>
    	<input id="sb_name" class="easyui-searchbox">
    	<label>HP:</label>
    	<input id="sb_hp" class="easyui-maskedbox" mask="(999) 9999-9999" style="width:140px">
    	<label>생년월일:</label>
		<input id="db_birth" type="text" class="easyui-datebox" required="required">
    	<br>
    	<a id="btn_select" class="easyui-linkbutton" iconCls="icon-search" 	onclick="select()">조회</a>
    	<a id="btn_insert" class="easyui-linkbutton" iconCls="icon-add" 	onclick="insert()">등록</a>
    	<a id="btn_update" class="easyui-linkbutton" iconCls="icon-edit" 	onclick="update()">수정</a>
    	<a id="btn_delete" class="easyui-linkbutton" iconCls="icon-remove" 	onclick="delete()">삭제</a>
		
    	<!-- =================================================== 조건검색 추가 끝 ============================================================= -->
    	<!-- ====================================================== 콘텐츠 추가 끝 ============================================================ -->
    	<!-- ====================================================== 시스템 메뉴 단계 끝 ======================================================== -->
    	<!--     	<div id="dg_movie"></div> -->
    	<table id="dg_mem"></table>
    	<script type="text/javascript">
	    	$('#dg_mem').datagrid({
// 			    url:'.json' //XXX.do or jsonXXX.jsp
			    data: [//이 부분이 위의 url을 대신할 수 있다.
					 {mem_id:'test',  mem_name:'이순신', mem_addr:'서울시 어딘가', hp:'010-1234-5678'}
					,{mem_id:'test1', mem_name:'허준',  mem_addr:'서울시 어딘가', hp:'010-4567-8901'}
					,{mem_id:'test2', mem_name:'김유신', mem_addr:'서울시 어딘가', hp:'010-7890-1234'}
					]
			    ,columns:[[
			         {field:'mem_id'	,title:'id'	,width:150,align:'center'}
			        ,{field:'mem_name'	,title:'이름'	,width:120,align:'center'}
			        ,{field:'mem_addr'	,title:'주소'	,width:300,align:'center'}
			        ,{field:'hp'		,title:'폰번호',width:150,align:'center'}
			    ]]
			});
    	</script>
    	<div id="pp" class="easyui-pagination" style="background:#efefef;border:1px solid #ccc;"
        data-options="total:100,pageSize:10">
		</div>
    </div>
</div>

</body>
</html>