<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table style="width: 100%; height: 400px;'">
	<tr>
		<td style="width: 79%">
			<form method="get" name="memberOutForm" action="/member/withDrawal.np">
			<table align="left" style="width: 70%">
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p
							style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">아이디</p>
					</td>
					<td>
						<input value="np1234" type="text" name="m_id" id="m_id" style="float: left;">
					</td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p
							style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">비밀번호</p>
					</td>
					<td>
						<input value="1234" type="password" name="m_pw" id="m_pw" style="float: left;">
					</td>
				</tr>
				<tr style="height: 120px;">
					<td colspan="2" style="text-align: center;">
						<input class="btn btn-outline-dark" type="button" value="회원탈퇴" onclick="check()">
						<input class="btn btn-outline-dark" type="reset" value="다시작성">
					</td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
</table>