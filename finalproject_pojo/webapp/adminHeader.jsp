<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String nick = (String)session.getAttribute("nick");%>
	<table style="width: 100%;">
		<tr>
			<td style="width: 50%; text-align: center;">
				<a href="/member/index.jsp">
				<input type="image" src="/images/logo.jpg"  style="width: 200px">
				</a>
			</td>
			<td valign="middle" align="center">
				<p style="font-family: Black Han Sans, sans-serif; color: black; margin-bottom:0px; white-space: nowrap;"><%=nick%>님 환영합니다</p>
			</td>
			<td>
				<a href="/adminControl.jsp" style="font-family: Black Han Sans, sans-serif; color: black; white-space: nowrap;">
					관리자페이지
				</a>
			</td>
			<td>
				<a href="javascript:logout();"  style="font-family: Black Han Sans, sans-serif; color: black; cursor: pointer; white-space: nowrap;">
					로그아웃
				</a>
			</td>
		</tr>
	</table>
