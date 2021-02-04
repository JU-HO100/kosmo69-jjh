<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<% List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("list");%>
<% for(Map<String, Object> rmap:list) { %>
<table style="width: 100%">
	<tr>
		<td style="width: 79%" align="center">
			<form method="get" action="/member/memUpd.np" name="updateForm">
			<table align="center" style="width: 70%">
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">아이디</p>
					</td>
					<td>
						<input value="<%=session.getAttribute("id")%>"  id="m_id" name="m_id">
					</td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px; white-space: nowrap;">현재 비밀번호를 입력해주세요</p>
					</td>
					<td>
						<input type="password" name="m_pw" id="m_pw" style="float: left;" value="">
					</td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px; white-space: nowrap;">변경할 비밀번호를 입력해주세요</p>
					</td>
					<td>
						<input type="password" name="c_pw" id="c_pw" style="float: left;" value="">
					</td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p
							style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">이메일</p>
					</td>
					<td><input value="<%=rmap.get("M_MAIL") %>" type="email" name="c_mail" id="c_mail"
						style="float: left;"></td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p
							style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">주소</p>
					</td>
					<td><input value="<%=rmap.get("M_ZIP") %>" type="text" name="c_zip" id="c_zip"
						style="float: left;"></td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p
							style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">닉네임</p>
					</td>
					<td>
						<input value="<%=rmap.get("M_NICK") %>" type="text" name="c_nick" id="c_nick" style="float: left;">
					</td>
					<td>
						<input class="btn btn-outline-dark" type="button" value="중복 확인" onclick="nickCheckRegi()">
					</td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p
							style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">P.H</p>
					</td>
					<td><input value="<%=rmap.get("M_HP") %>" type="tel" name="c_hp" id="c_hp"
						style="float: left;"></td>
				</tr>
				<tr style="height: 120px;">
					<td colspan="2" style="text-align: center;">
					<input class="btn btn-outline-dark" type="reset" value="다시작성">
					<input class="btn btn-outline-dark" type="button" value="회원정보 수정" onclick="updateCheck()">
					</td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
</table>
 <%}%>