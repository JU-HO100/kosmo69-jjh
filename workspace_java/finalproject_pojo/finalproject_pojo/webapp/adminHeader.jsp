<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String nick = (String)session.getAttribute("nick");%>
	<table style="width: 100%;">
		<tr>
			<td style="width: 25%; text-align: center;">
				<a href="/member/index.jsp">
				<input type="image" src="/images/logo.jpg"  style="width: 200px">
				</a>
			</td>
			<td style="width: 30%;  padding-top: 32px; text-align: right;">
				<p style="font-family: Black Han Sans, sans-serif; color: black;"><%=nick%>님 환영합니다</p>
			</td>
			<td style="width: 8%;  padding-top: 15px; text-align: right">
				<a href="/adminControl.jsp" style="font-family: Black Han Sans, sans-serif; color: black;">
					관리자페이지
				</a>
				&nbsp;&nbsp;&nbsp;
			</td>
			<td style="width: 8%; padding-top: 15px; padding-left:5px; text-align: left; ">
				<a href="javascript:logout();" style="font-family: Black Han Sans, sans-serif; color: black;">
					로그아웃
				</a>
			</td>
		</tr>
	</table>
