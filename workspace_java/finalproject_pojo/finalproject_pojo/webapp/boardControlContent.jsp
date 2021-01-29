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
						<input class="easyui-searchbox" data-options="menu:'#boardCombo',searcher:doSearch" style="width:20%">
									    <div id="boardCombo">
									        <div data-options="name:'이름'">게시글번호</div>
									        <div data-options="name:'아이디'">작성자</div>
									        <div data-options="name:'아이디'">제목</div>
									        <div data-options="name:'아이디'">해시태그</div>
									        <div data-options="name:'아이디'">닉네임</div>
									        <div data-options="name:'아이디'">생성일</div>
									    </div>
									    <script>
									        function doSearch(value,name){
									            alert('You input: ' + value+'('+name+')');
									        }
									    </script>
									    &nbsp;&nbsp;&nbsp;범위검색
									    <select class="easyui-combobox" data-options="searcher:doSearch2" style="width:8%;">
									    	<option value="aa">좋아요 수</option>
										    <option>조회수</option>
									    </select>
									    <input class="easyui-textbox" style="width: 10%">
									    ~
									    <input class="easyui-searchbox" data-options="searcher:doSearch2" style="width:10%">
									    <script>
									        function doSearch2(value,name){
									            alert('You input: ' + value+'('+name+')');
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
						   <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addEmp()">입력</a>
						   <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="empUpdate()">수정</a>
						   <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeEmp()">삭제</a>
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
	        	</script>
		</td>
	</tr>
</table>