<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table style="width: 80%" align="center">
	<tr>
		<td style="width: 80%; padding-left: 5%; padding-right: 5%;">
  		<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">셰프 랭킹</h1>
		<table class="table table-hover">
		      <tr style="cursor: pointer;">
							<td>
								<input class ="easyui-textbox"  id="ranking" name="ranking"  label="순위" data-options="prompt:'Enter a ENAME'" style="width:250px"/>
							</td>
					      	<td>
<!-- 					      		<img id="like" src="/images/likeOff.png" style="width: 20%;border: none;cursor:pointer;" onclick="javascript:changeLike(0)"> -->
								<input class ="easyui-textbox"  id="m_like" name="m_like"  label="like" data-options="prompt:'Enter a ENAME'" style="width:250px"/>
					      	</td>
							<td>
								<input class ="easyui-textbox"  id="m_name" name="m_name"  label="셰프님" data-options="prompt:'Enter a ENAME'" style="width:250px"/>
							</td>
<!-- 							<td> -->
<!-- 								<input class ="easyui-textbox"  id="c_cook" name="c_cook"  label="주력요리" data-options="prompt:'Enter a ENAME'" style="width:250px"/> -->
<!-- 							</td> -->
		      </tr>
		</table>
		</td>
	</tr>
</table>
<div id="dlg_chefDetail" closed="true" class="easyui_dialog" style="padding: 20px 50px">
</div>
