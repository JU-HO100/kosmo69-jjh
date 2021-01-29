<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table style="width: 100%">
	<tr>
		<td style="width: 20%; vertical-align: top;">
			<div class="btn-group-vertical" style="width: 100%;">
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="memberUpdateContent()">회원정보 수정</button>
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="cookingClassCheckContent()">쿠킹클래스 확인</button>
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="joinChefContent()">셰프 등록</button>
				 <button type="button" class="btn btn-outline-dark active" style="text-align: left;" onclick="memberOutContent()">회원 탈퇴</button>
			</div>
		</td>
		<td style="width: 80%">
			<form>
			<table align="left" style="width: 70%">
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p
							style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">아이디</p>
					</td>
					<td><input type="text" name="id" id="id" style="float: left;">
					</td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 50%; text-align: center;">
						<p
							style="font-family: Black Han Sans, sans-serif; color: black; padding-top: 16px;">비밀번호</p>
					</td>
					<td><input type="password" name="pw" id="pw"
						style="float: left;"></td>
				</tr>
				<tr style="height: 120px;">
					<td colspan="2" style="text-align: center;">
						<input class="btn btn-outline-dark" type="reset" value="다시작성">
						<input class="btn btn-outline-dark" type="submit" value="회원탈퇴">
					</td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
</table>