<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/easyui_common.jsp" %>
<table border="0">
	<tr>
		<td>
			<%="이순신"%>님 환영합니다.
			<br>
			<a id="btn_logout" class="easyui-linkbutton" onClick="logout()">로그아웃</a>
			<a id="btn_member" class="easyui-linkbutton" onClick="memberUpdate">정보수정</a>
		</td>
	</tr>
</table>
