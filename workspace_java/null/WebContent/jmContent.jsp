<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form method="get" action="./login.jsp"><!-- /member/register.np -->
<table align="center"  style="width: 70%">
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">이름</p>
		</td>
		<td style="widows: 50%">
			<input type="text" name="M_NAME" id="M_NAME" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">성별</p>
		</td>
		<td>
			<label><input type="radio" name="M_GENDER" value="남자" checked="checked"> 남자</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     		<label><input type="radio" name="M_GENDER" value="여자"> 여자</label>
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">아이디 <br/>  (4~12자의 영문 대소문자와 숫자로만 입력) </p>
		</td>
		<td>
			<input type="text" name="M_ID" id="M_ID" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">비밀번호 <br/> (4~12자리의 영문 대소문자와 숫자로만 입력)</p>
		</td>
		<td>
			<input type="password" name="M_PW" id="M_PW" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">비밀번호 확인</p>
		</td>
		<td>
			<input type="password" name="M_PWCHECK" id="M_PWCHECK" style="float: left;" >
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">이메일</p>
		</td>
		<td>
			<input type="email" name="M_MAIL" id="M_MAIL" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">닉네임</p>
		</td>
		<td>
			<input type="text" name="M_NICK" id=""M_NICK"" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;" >전화번호</p>
		</td>
		<td>
			<input type="tel" name="M_HP" id="M_HP" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:80px; ">
		<td style="width: 50%; text-align: center; ">
			<p style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">생년월일</p>
		</td>
		<td>
			<input type="date" name="M_BIRTH" id="M_BIRTH" style="float: left;" required="required">
		</td>
	</tr>
	<tr style="height:120px; ">
		<td colspan="2" style="text-align: center;">
			<input class="btn btn-outline-dark" type="submit" value="회원가입" onclick="check()">
			<input class="btn btn-outline-dark" type="reset" value="다시작성">
		</td>
	</tr>
</table>
</form>