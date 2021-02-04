
function logout() {
	location.href="/member/logout.jsp";
}

function out(){
	location.href="/member/index.jsp";
}

//===================================memberControl===========================
function memberall() {
	$("#member").datagrid({
		   url: "/admin/memList.np?category="+"GENERAL"	
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
	}
	
	
function foreverstop() {
	var keyword=$("#foreverstop").val();
	$("#member").datagrid({
		   url: "/admin/memList.np?category="+"CHECKBLIST"+"&keyword="+keyword	
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
	}
	
	
function pause() {
	var keyword=$("#pause").val();
	$("#member").datagrid({
		   url: "/admin/memList.np?category="+"CHECKBLIST"+"&keyword="+keyword	
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
	}	


function normal() {
	var keyword=$("#normal").val();
	$("#member").datagrid({
		   url: "/admin/memList.np?category="+"CHECKBLIST"+"&keyword="+keyword	
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
	}	
	
	
function man() {
	var keyword=$("#man").val();
	$("#member").datagrid({
		   url: "/admin/memList.np?category="+"M_GENDER"+"&keyword="+keyword	
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
	}
	
	
function lady() {
	var keyword=$("#lady").val();
	$("#member").datagrid({
		   url: "/admin/memList.np?category="+"M_GENDER"+"&keyword="+keyword	
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
	}
	

function chefapply() {
	var keyword=$("#chefapply").val();
	$("#member").datagrid({
		   url: "/admin/memList.np?category="+"CHEF_APPLY"+"&keyword="+keyword	
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
	}
	
	
function chef() {
	var keyword=$("#chef").val();
	$("#member").datagrid({
		   url: "/admin/memList.np?category="+"CHEF_APPLY"+"&keyword="+keyword	
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
	}
	
//===================================memberControl END===========================

//===================================memberControl===========================
function boardall(){
			$("#board").datagrid({
	 			   url: "/admin/boardList.np?category="+"GENERAL"	
	 			  ,toolbar:'#tbar_board'
	 			  ,rownumbers:true
	 			  ,method:'get'
	 		   	  ,columns:[[
	 		   				 {field:'CK',checkbox:true, width:50, align:'center'}	
	 		                ,{field:'게시번호',title:'게시번호',width:150, editor:'text'}
	 		                ,{field:'대분류',title:'대분류',width:100, editor:'text'}
	 		                ,{field:'소분류',title:'소분류',width:220, editor:'text'}
	 		                ,{field:'글제목',title:'글제목',width:130, editor:'text'}
	 		                ,{field:'해시태그',title:'해시태그',width:80, editor:'text'}
	 		                ,{field:'게시일',title:'게시일',width:130, editor:'text'}
	 		                ,{field:'조회수',title:'조회수',width:60, editor:'text'}
	 		                ,{field:'게시물상태',title:'게시물상태',width:120, editor:'text'}
	 		                ,{field:'아이디',title:'아이디',width:50, editor:'text'}
	 		                ,{field:'닉네임',title:'닉네임',width:220, editor:'text'}
	 		                ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
	 		       ]]	
	 			});	
}
function korea(){
	var keyword=$("#korea").val();
	$("#board").datagrid({
	 			   url: "/admin/boardList.np?category="+"CATEGORY"+"&keyword="+keyword	
	 			  ,toolbar:'#tbar_board'
	 			  ,rownumbers:true
	 			  ,method:'get'
	 		   	  ,columns:[[
	 		   				 {field:'CK',checkbox:true, width:50, align:'center'}	
	 		                ,{field:'게시번호',title:'게시번호',width:150, editor:'text'}
	 		                ,{field:'대분류',title:'대분류',width:100, editor:'text'}
	 		                ,{field:'소분류',title:'소분류',width:220, editor:'text'}
	 		                ,{field:'글제목',title:'글제목',width:130, editor:'text'}
	 		                ,{field:'해시태그',title:'해시태그',width:80, editor:'text'}
	 		                ,{field:'게시일',title:'게시일',width:130, editor:'text'}
	 		                ,{field:'조회수',title:'조회수',width:60, editor:'text'}
	 		                ,{field:'게시물상태',title:'게시물상태',width:120, editor:'text'}
	 		                ,{field:'아이디',title:'아이디',width:50, editor:'text'}
	 		                ,{field:'닉네임',title:'닉네임',width:220, editor:'text'}
	 		                ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
	 		       ]]	
	 			});
}

function china(){
	var keyword=$("#china").val();
	$("#board").datagrid({
	 			   url: "/admin/boardList.np?category="+"CATEGORY"+"&keyword="+keyword	
	 			  ,toolbar:'#tbar_board'
	 			  ,rownumbers:true
	 			  ,method:'get'
	 		   	  ,columns:[[
	 		   				 {field:'CK',checkbox:true, width:50, align:'center'}	
	 		                ,{field:'게시번호',title:'게시번호',width:150, editor:'text'}
	 		                ,{field:'대분류',title:'대분류',width:100, editor:'text'}
	 		                ,{field:'소분류',title:'소분류',width:220, editor:'text'}
	 		                ,{field:'글제목',title:'글제목',width:130, editor:'text'}
	 		                ,{field:'해시태그',title:'해시태그',width:80, editor:'text'}
	 		                ,{field:'게시일',title:'게시일',width:130, editor:'text'}
	 		                ,{field:'조회수',title:'조회수',width:60, editor:'text'}
	 		                ,{field:'게시물상태',title:'게시물상태',width:120, editor:'text'}
	 		                ,{field:'아이디',title:'아이디',width:50, editor:'text'}
	 		                ,{field:'닉네임',title:'닉네임',width:220, editor:'text'}
	 		                ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
	 		       ]]	
	 			});
}

function japan(){
	var keyword=$("#japan").val();
	$("#board").datagrid({
	 			   url: "/admin/boardList.np?category="+"CATEGORY"+"&keyword="+keyword	
	 			  ,toolbar:'#tbar_board'
	 			  ,rownumbers:true
	 			  ,method:'get'
	 		   	  ,columns:[[
	 		   				 {field:'CK',checkbox:true, width:50, align:'center'}	
	 		                ,{field:'게시번호',title:'게시번호',width:150, editor:'text'}
	 		                ,{field:'대분류',title:'대분류',width:100, editor:'text'}
	 		                ,{field:'소분류',title:'소분류',width:220, editor:'text'}
	 		                ,{field:'글제목',title:'글제목',width:130, editor:'text'}
	 		                ,{field:'해시태그',title:'해시태그',width:80, editor:'text'}
	 		                ,{field:'게시일',title:'게시일',width:130, editor:'text'}
	 		                ,{field:'조회수',title:'조회수',width:60, editor:'text'}
	 		                ,{field:'게시물상태',title:'게시물상태',width:120, editor:'text'}
	 		                ,{field:'아이디',title:'아이디',width:50, editor:'text'}
	 		                ,{field:'닉네임',title:'닉네임',width:220, editor:'text'}
	 		                ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
	 		       ]]	
	 			});
}

function usa(){
	var keyword=$("#usa").val();
	$("#board").datagrid({
	 			   url: "/admin/boardList.np?category="+"CATEGORY"+"&keyword="+keyword	
	 			  ,toolbar:'#tbar_board'
	 			  ,rownumbers:true
	 			  ,method:'get'
	 		   	  ,columns:[[
	 		   				 {field:'CK',checkbox:true, width:50, align:'center'}	
	 		                ,{field:'게시번호',title:'게시번호',width:150, editor:'text'}
	 		                ,{field:'대분류',title:'대분류',width:100, editor:'text'}
	 		                ,{field:'소분류',title:'소분류',width:220, editor:'text'}
	 		                ,{field:'글제목',title:'글제목',width:130, editor:'text'}
	 		                ,{field:'해시태그',title:'해시태그',width:80, editor:'text'}
	 		                ,{field:'게시일',title:'게시일',width:130, editor:'text'}
	 		                ,{field:'조회수',title:'조회수',width:60, editor:'text'}
	 		                ,{field:'게시물상태',title:'게시물상태',width:120, editor:'text'}
	 		                ,{field:'아이디',title:'아이디',width:50, editor:'text'}
	 		                ,{field:'닉네임',title:'닉네임',width:220, editor:'text'}
	 		                ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
	 		       ]]	
	 			});
}

function popular(){
	var keyword=$("#popular").val();
	$("#board").datagrid({
	 			   url: "/admin/boardList.np?category="+"B_STATUS"+"&keyword="+keyword	
	 			  ,toolbar:'#tbar_board'
	 			  ,rownumbers:true
	 			  ,method:'get'
	 		   	  ,columns:[[
	 		   				 {field:'CK',checkbox:true, width:50, align:'center'}	
	 		                ,{field:'게시번호',title:'게시번호',width:150, editor:'text'}
	 		                ,{field:'대분류',title:'대분류',width:100, editor:'text'}
	 		                ,{field:'소분류',title:'소분류',width:220, editor:'text'}
	 		                ,{field:'글제목',title:'글제목',width:130, editor:'text'}
	 		                ,{field:'해시태그',title:'해시태그',width:80, editor:'text'}
	 		                ,{field:'게시일',title:'게시일',width:130, editor:'text'}
	 		                ,{field:'조회수',title:'조회수',width:60, editor:'text'}
	 		                ,{field:'게시물상태',title:'게시물상태',width:120, editor:'text'}
	 		                ,{field:'아이디',title:'아이디',width:50, editor:'text'}
	 		                ,{field:'닉네임',title:'닉네임',width:220, editor:'text'}
	 		                ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
	 		       ]]	
	 			});
}

function general(){
	var keyword=$("#general").val();
	$("#board").datagrid({
	 			   url: "/admin/boardList.np?category="+"B_STATUS"+"&keyword="+keyword	
	 			  ,toolbar:'#tbar_board'
	 			  ,rownumbers:true
	 			  ,method:'get'
	 		   	  ,columns:[[
	 		   				 {field:'CK',checkbox:true, width:50, align:'center'}	
	 		                ,{field:'게시번호',title:'게시번호',width:150, editor:'text'}
	 		                ,{field:'대분류',title:'대분류',width:100, editor:'text'}
	 		                ,{field:'소분류',title:'소분류',width:220, editor:'text'}
	 		                ,{field:'글제목',title:'글제목',width:130, editor:'text'}
	 		                ,{field:'해시태그',title:'해시태그',width:80, editor:'text'}
	 		                ,{field:'게시일',title:'게시일',width:130, editor:'text'}
	 		                ,{field:'조회수',title:'조회수',width:60, editor:'text'}
	 		                ,{field:'게시물상태',title:'게시물상태',width:120, editor:'text'}
	 		                ,{field:'아이디',title:'아이디',width:50, editor:'text'}
	 		                ,{field:'닉네임',title:'닉네임',width:220, editor:'text'}
	 		                ,{field:'회원상태',title:'회원상태',width:70, editor:'text'}
	 		       ]]	
	 			});
}


//===================================memberControl END===========================
//===================================cookClassControl===========================
function cookall(){
	$("#cookclass").datagrid({
	 			   url: "/admin/classList.np?category="+"GENERAL"	
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
	 		                ,{field:'쿠킹클래스주소',title:'쿠킹클래스주소',width:150, editor:'text'}
	 		                ,{field:'상세주소',title:'상세주소',width:90, editor:'text'}
	 		       ]]	
	 			});	
}

function cookclasschef(){
	var keyword=$("#cookclasschef").val();
	$("#cookclass").datagrid({
	 			   url: "/admin/classList.np?category="+"M_STATUS"	+"&keyword="+keyword	
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
	 		                ,{field:'쿠킹클래스주소',title:'쿠킹클래스주소',width:150, editor:'text'}
	 		                ,{field:'상세주소',title:'상세주소',width:90, editor:'text'}
	 		       ]]	
	 			});	
}

function progressing(){
	var keyword=$("#progressing").val();
	$("#cookclass").datagrid({
	 			   url: "/admin/classList.np?category="+"M_STATUS"+"&keyword="+keyword	
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
	 		                ,{field:'쿠킹클래스주소',title:'쿠킹클래스주소',width:150, editor:'text'}
	 		                ,{field:'상세주소',title:'상세주소',width:90, editor:'text'}
	 		       ]]	
	 			});	
}

function ok(){
	var keyword=$("#ok").val();
	$("#cookclass").datagrid({
	 			   url: "/admin/classList.np?category="+"M_STATUS"+"&keyword="+keyword		
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
	 		                ,{field:'쿠킹클래스주소',title:'쿠킹클래스주소',width:150, editor:'text'}
	 		                ,{field:'상세주소',title:'상세주소',width:90, editor:'text'}
	 		       ]]	
	 			});	
}

function no(){
	var keyword=$("#no").val();
	$("#cookclass").datagrid({
	 			   url: "/admin/classList.np?category="+"M_STATUS"+"&keyword="+keyword		
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
	 		                ,{field:'쿠킹클래스주소',title:'쿠킹클래스주소',width:150, editor:'text'}
	 		                ,{field:'상세주소',title:'상세주소',width:90, editor:'text'}
	 		       ]]	
	 			});	
}

//===================================cookClassControl END===========================