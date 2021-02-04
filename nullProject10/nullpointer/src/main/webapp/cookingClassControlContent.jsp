<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table style="width: 100%">
	<tr>
		<td style="width: 100%; height: 100%">
			<table id="cookclass"  title="쿠킹클래스관리" style="width: 100%; height: 1000px" ></table>
			
			<!-- 툴바 시작하기========================================================================================== -->
<div id="tbar_cookclass">
	<!-- 테이블 태그를 활용하여 조건 검색하는 화면을 추가하고 그 아래 버튼을 배치하시오. -->
	<table border="0" width="100%">
	<!-- 조건 검색 화면 시작 -->	
		<tr>
			<td>
			<table border="0">
				<tr>
					<td>
						<button type="button" class="btn btn-outline-warning" style="width: 200px;" onclick="cookall()">전체보기</button>
						<button id="cookclasschef" type="button" class="btn btn-outline-dark" style="width: 200px;" value="셰프" onclick="cookclasschef()">쿠킹클래스 개설 셰프</button>
						<button id="progressing" type="button" class="btn btn-outline-danger" style="width: 200px;" value="신청중" onclick="progressing()">신청중인 수강생</button>
						<button id="ok" type="button" class="btn btn-outline-danger" style="width: 200px;" value="수락" onclick="ok()">수락 수강생</button>
						<button id="no" type="button" class="btn btn-outline-danger" style="width: 200px;" value="반려" onclick="no()">반려 수강생</button>
						<button class="btn btn-outline-info" style="width: 200px;" onclick="out()">관리자모드 나가기</button>
					 </td>
				</tr>
				<tr>
			<!-- combobox추가 시작(위치선택, 공간 확보, 코드 추가) 이름|job|부서번호-->				
								<td width="100%" colspan="3">
        								<input class="easyui-searchbox" data-options="menu:'#cookCombo',searcher:doSearchCookingclass" style="width:40%">
									    <div id="cookCombo">
									        <div data-options="name:'C_CLASSCD'">쿠킹클래스번호</div>
									        <div data-options="name:'M_ID'">회원아이디</div>
									        <div data-options="name:'CHEF_ID'">개설한 세프아이디</div>
									        <div data-options="name:'M_NICK'">닉네임</div>
									        <div data-options="name:'CHEF_NICK'">개섵한 셰프 닉네임</div>
									        <div data-options="name:'COOK_NAME'">쿠킹클래스 이름</div>
									        <div data-options="name:'C_NEEDS'">준비물</div>
									        <div data-options="name:'C_ZIP'">주소</div>
									        <div data-options="name:'C_ZIPDETAIL'">상세 주소</div>
									    </div>
									 <script type="text/javascript">
								      function doSearchCookingclass(keyword,category){
										$("#cookclass").datagrid({
										   url: "/admin/classList.np?category="+category+"&keyword="+keyword	
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
			   <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeCookclass()">쿠킹클래스 삭제</a>
			</td>
		</tr>
	<!-- 업무관련 버튼   끝   -->	
	</table>
</div>
<!-- 툴바 끝-=========================================================================================================== -->


			<script type="text/javascript">
				//게시판불러오기 스크립트
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
	 		                ,{field:'쿠킹클래스주소',title:'쿠킹클래스주소',width:185, editor:'text'}
	 		                ,{field:'상세주소',title:'상세주소',width:90, editor:'text'}
	 		       ]]	
	 			});	
	        	</script>
		</td>
	</tr>
</table>