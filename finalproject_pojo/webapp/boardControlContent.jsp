<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table style="width: 100%">
	<tr>
		<td style="width: 100%; height: 100%">
			<table id="board"  title="게시판관리" style="width: 100%; height: 1000px" ></table>
			<!-- 툴바 시작하기========================================================================================== -->
<div id="tbar_board">
	<!-- 테이블 태그를 활용하여 조건 검색하는 화면을 추가하고 그 아래 버튼을 배치하시오. -->
	<table border="0" width="100%">
	<!-- 조건 검색 화면 시작 -->	
		<tr>
			<td>
			<table border="0">
				<tr>
					<td>
						<button type="button" class="btn btn-outline-warning" style="width: 200px;" onclick="boardall()">전체보기</button>
						<button id="korea"  type="button" class="btn btn-outline-dark" style="width: 200px;" value="한식" onclick="korea()">한식</button>
						<button id="china"  type="button" class="btn btn-outline-dark" style="width: 200px;" value="중식" onclick="china()">중식</button>
						<button id="japan"  type="button" class="btn btn-outline-dark" style="width: 200px;" value="일식" onclick="japan()">일식</button>
						<button id="usa"  type="button" class="btn btn-outline-dark" style="width: 200px;" value="양식" onclick="usa()">양식</button>
						<button id="popular"  type="button" class="btn btn-outline-success" style="width: 200px;" value="인기게시글" onclick="popular()">인기게시글</button>
						<button id="general"  type="button" class="btn btn-outline-success" style="width: 200px;" value="일반게시글" onclick="general()">일반게시글</button>
						<button class="btn btn-outline-info" style="width: 200px;" onclick="out()">관리자모드 나가기</button>
					</td>
				</tr>
				<tr>
<!-- combobox추가 시작(위치선택, 공간 확보, 코드 추가) 이름|job|부서번호-->				
					<td width="100%" colspan="3">
						<input class="easyui-searchbox" data-options="menu:'#boardCombo',searcher:doSearchBoard" style="width:20%" >
									    <div id="boardCombo">
									        <div data-options="name:'MENUCD'">게시번호</div>
									        <div data-options="name:'M_ID'">아이디</div>
									        <div data-options="name:'FOODNAME'">글제목</div>
									        <div data-options="name:'HASHTAG'">해시태그</div>
									        <div data-options="name:'M_NICK'">닉네임</div>
									        <div data-options="name:'CREATION_DATE'">게시일</div>
									    </div>
								<script type="text/javascript">
								      function doSearchBoard(keyword,category){
										$("#board").datagrid({
										   url: "/admin/boardList.np?category="+category+"&keyword="+keyword	
										  ,toolbar:'#tbar_board'
										  ,rownumbers:true
										  ,singleSelect:true
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
									}
								      </script>	
								      	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;범위검색
									    <select class="easyui-combobox" style="width:8%;" name="category2" id="category2">
									    	<option value="LIKE_CNT">좋아요 수</option>
										    <option value="HIT">조회수</option>
									    </select>
									    <input class="easyui-textbox" style="width: 10%" name="option_keyword_1" id="option_keyword_1">
									    ~
									    <input class="easyui-textbox" style="width: 10%" name="option_keyword_2" id="option_keyword_2">
									    <input type=button value="범위 검색" class="btn btn-outline-dark"  onclick="javascript:scopeSearch2()">
									    <script>
									    function scopeSearch2() {
									    	category2 = $("#category2").val();
									    	option_keyword_1 = $("#option_keyword_1").val();
									    	option_keyword_2 = $("#option_keyword_2").val();
									    	$("#board").datagrid({
												   url: "/admin/boardList.np?category="+category2+"&option_keyword1="+option_keyword_1+"&option_keyword2="+option_keyword_2	
												  ,toolbar:'#tbar_board'
												  ,rownumbers:true
												  ,method:'get'
													  ,singleSelect:true
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
										}
									    </script>
								</td>
							</tr>
						</table>		
						</td>
					</tr>
				<!-- 조건 검색 화면  끝  -->	
				<!-- 업무관련 버튼 시작 -->	
					<tr>
						<td>
						   <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeBoard()">게시판 삭제</a>
						</td>
					</tr>
				<!-- 업무관련 버튼   끝   -->	
				</table>
			</div>
<!-- 툴바 끝-=========================================================================================================== -->
			<script type="text/javascript">
				//게시판불러오기 스크립트
	        	$("#board").datagrid({
	 			   url: "/admin/boardList.np?category="+"GENERAL"	
	 			  ,toolbar:'#tbar_board'
	 			  ,rownumbers:true
	 			  ,method:'get'
	 			,singleSelect:true
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
	        	</script>
		</td>
	</tr>
</table>