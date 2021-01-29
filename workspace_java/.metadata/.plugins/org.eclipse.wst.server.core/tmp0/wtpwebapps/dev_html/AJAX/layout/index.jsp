<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매 시스템</title>
<!-- 공통 코드 추가하기 -->
<%@ include file="../../common/easyui_common.jsp" %>
	<style type="text/css">
		#d_login{
			border : 1px solid #FFFF00;
         	background : #2EFEF7;
         	width : 192px;
         	height : 105px;
		
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
    
    <!-- ==================================== 로그인 영역 ============================================================== -->
    	<div id="login" align="center">
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
    <!-- ==================================== 로그인 영역 ============================================================== -->
    
    <!-- ==================================== 로그아웃 영역 ============================================================== -->
    	<div id="logout" align="center">
<!-- 	    	<a id="btn_logout" class="easyui-linkbutton" onclick="logout()">로그아웃</a> -->
				<div style="margin:5px 0;"></div>
				<div id="d_ok">이순심님 환영합니다.</div>
				<div style="margin:3px 0;"></div>
			    	<a id="btn_logout" class="easyui-linkbutton" href="javascript:logoutAction()" >로그아웃</a>
			    	<a id="btn_update" class="easyui-linkbutton" href="javascript:updateAction()">정보수정</a>
			    	
    	</div>
    <!-- ==================================== 로그아웃 영역 ============================================================== -->
    
    <!-- ==================================== 메뉴 영역 시작 ============================================================== -->
    	
    <!-- ==================================== 메뉴 영역 끝 ============================================================== -->
    
    </div>
    <div data-options="region:'center',title:'영화예매 시스템'" style="padding:5px;background:#eee;">

    </div>
</div>

</body>
</html>