<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String MSG = (String)request.getAttribute("msg"); %>
<table align="center" style="text-align: center;">
	<tr>
		<td style="height: 160px;">
			<%if(MSG.equals("조건을 검색하지 못하였습니다")){ %>
		<%= MSG %>
		<%}else{ %>
			비밀번호는<%= MSG %>입니다.
		<%} %>
		</td>
	</tr>
	<tr>
		<td>
			<input class="btn btn-outline-dark" type="button" value="돌아가기" onclick="back();">
			<input class="btn btn-outline-dark" type="button" value="로그인 하러가기" onclick="goLogin();">
		</td>
	</tr>
</table>