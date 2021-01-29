<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table width="100%" height="100%" border="1" borderColor="yellow">
	<tr>
		<td align="center" valign="top">
			<table>
			<!-- 로그인 하기 전 화면 시적 -->
					<tr>
						<td width="190px" height="75px">로그인
				<div id="d_login">
					<table border="0" >
						<tr>
						<td><input id="tb_id" class="easyui-textbox" data-options="iconCls:'icon-man',prompt:'아이디'" style="width:130px"></td>
<!-- 						<td rowspan="2"><input id="btn_login" class="easyui-linkbutton" onClick="login()" type="button" value="로그인"></td> -->
						<td rowspan="2"><a id="btn_login" class="easyui-linkbutton" onclick="login()">로그인</a></td>
	                  </tr>
	                  <tr>
	                  <td><input id="tb_pw" class="easyui-textbox" data-options="iconCls:'icon-lock', prompt:'비밀번호'" style="width:130px"></td>
	                  </tr>
					</table>
				</div>
						</td>
					</tr>
				<!-- 로그인 하기 전 화면 끝 -->
				
				<!-- 로그인 화면 -->			
				<tr>
<!-- 					<td height="25px"><input id="btn_singup" type="button" class="easyui-linkbutton" value="로그아웃"> -->
					<td height="25px"><a id="btn_singup"class="easyui-linkbutton" onclick="logout()">로그아웃</a>
<!-- 					<input id="btn_singup" type="button" class="easyui-linkbutton" value="회원가입"></td> -->
					<a id="btn_singup"  class="easyui-linkbutton" onclick="singup()">회원가입</a></td>
				</tr>
				<tr>
					<td height="25px">게시판</td>
				</tr>
				<tr>
					<td height="420px">Q&A</td>
				</tr>
			</table>
		</td>
	</tr>
</table>