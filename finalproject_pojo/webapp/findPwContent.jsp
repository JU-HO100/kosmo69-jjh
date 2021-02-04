<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="/member/pwSearch.np" method="get">
<table align="center"  style="width: 70%">
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">아이디</p>
		</td>
		<td>
			<input value="test123" type="text" name="m_id" id="m_id" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;" >전화번호<br/> (- 없이 입력 바랍니다.)</p>
		</td>	
		<td>
			<input value="01012345678" type="text" name="m_hp" id="m_hp" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">메일</p>
		</td>
		<td style="widows: 50%">
			<input value=test5678@gmail.com type="text" name="m_mail" id="m_mail" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:120px; ">
		<td colspan="2" style="text-align: center;">
			<input class="btn btn-outline-dark" type="submit" value="비밀번호 찾기" onclick="findPwAction();">
			<input class="btn btn-outline-dark" type="reset" value="다시작성">
		</td>
	</tr>
</table>
</form>