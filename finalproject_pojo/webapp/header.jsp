<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<table style="width: 100%;">
		<tr>
			<td style="width: 30%; text-align: center;">
				<a href="/member/index.jsp">
					<input type="image" src="/images/logo.jpg"  style="width: 200px">
				</a>
			</td>
			<td style="width: 45%; text-align: center;">
				<form class="form-inline" name="headerSearch"  id="headerSearch" action="/recipe/nickSearch.np" method="get">
						<select class="easyui-combobox" name="field"  id="field" style="width: 20%;height: 100%">
							<option value="FOODNAME">제목</option>
							<option value="RECIPE_INFO">내용</option>
							<option value="JAELYO">재료명</option>
							<option value="M_NICK">닉네임</option>
						</select>
				<input id="keyword" name="keyword" class="form-control mr-sm-2" type="text" placeholder="Search..."  style="width: 55%">
				<script type="text/javascript">
				function headerSubmit() {
					var field = document.getElementById('field').value;
					var keyword = document.getElementById('keyword').value;
					location.href="/recipe/searchIndex.jsp?field="+field+"&keyword="+keyword+"&m_id="+"-";
				}
				</script>
				<button type="button" class="btn btn-secondary" onclick="javascript:headerSubmit()">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
						  <path fill-rule="evenodd"d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z" />
						  <path fill-rule="evenodd"d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z" />
						</svg>
				</button>
				</form>
			</td>
			<td style="width: 12%;  padding-top: 15px; text-align: right">
				<a href="/member/login.jsp" style="font-family: Black Han Sans, sans-serif; color: black;">
					로그인
				</a>
				&nbsp;&nbsp;&nbsp;
			</td>
			<td style="width: 13%; padding-top: 15px; padding-left:5px; text-align: left; ">
				<a href="/member/joinMembership.jsp" style="font-family: Black Han Sans, sans-serif; color: black;">
					회원가입
				</a>
			</td>
		</tr>
	</table>
