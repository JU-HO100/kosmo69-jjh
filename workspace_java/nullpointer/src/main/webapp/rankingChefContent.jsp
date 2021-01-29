<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="com.util.PageBar"%>  --%>
<!DOCTYPE html>
<table style="width: 80%" align="center">
	<tr>
		<td style="width: 80%; padding-left: 5%; padding-right: 5%;">
  		<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">셰프 랭킹</h1>
		<table class="table table-hover">
			<tbody>
<%
			for(int i=0;i<10;i++){
			//Map<String,Object> rmap = boardList.get(i);
%>
		      <tr>
		      	<td style="width: 20%;">
			     	<input type="image" src="/images/r1.jpg" style="width: 100%; cursor: default;">
		      		<img id="like" src="/images/likeOff.png" style="width: 20%;border: none;cursor:pointer;" onclick="javascript:changeLike(0)">
		      		<%=100 %>
		      	</td>
				<td style="width: 80%;cursor: pointer;"  onclick="javascript:chefView()" >
					<table style="width: 100%;">
						<tr>
							<td style="width: 100%; border: none;">
								셰프이름 <!-- 데이터이름 -->
							</td>
						</tr>
						<tr>
							<td style="border: none;">
								간단셰프 소개란 <!-- 간단셰프 소개란 -->
							</td>
						</tr>
						<tr>
							<td style="border: none;">
								__셰프님의 주력요리
							</td>
						</tr>
					</table>
				</td>
		      </tr>
<%
			}
%>
		  </tbody>
		</table>
			<table style="width: 100%">
			<tr>
				<td style="width: 100%;text-align: center;">
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<div id="dlg_chefDetail" closed="true" class="easyui_dialog" style="padding: 20px 50px">
</div>
