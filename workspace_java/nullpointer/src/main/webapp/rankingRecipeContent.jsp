<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int tot = 0;
	List<Map<String,Object>> boardList = null;
	boardList = (List<Map<String,Object>>)request.getAttribute("boardList");
	if(boardList !=null){
		tot = boardList.size();
	}
	
%>     
<!DOCTYPE html>
<table style="width: 100%">
	<tr>
		<td style="width: 20%; vertical-align: top;">
			<div class="btn-group-vertical" style="width: 100%;">
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="rankingChefContent()">셰프 랭킹</button>
				 <button type="button" class="btn btn-outline-dark active" style="text-align: left;" onclick="rankingRecipeContent()">레시피 랭킹</button>
			</div>
		</td>
		<td style="width: 80%; padding-left: 5%; padding-right: 5%;">
  		<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">레시피 랭킹</h1>
		<table class="table table-hover">
			<tbody>
<%
			for(int i=0;i<5;i++){
			//Map<String,Object> rmap = boardList.get(i);
%>
		      <tr onclick="javascript:recipeView()" style="cursor: pointer;">
		      	<td style="width: 20%;">
		      		<input type="image" src="/images/r1.jpg" style="width: 100%;">
		      	</td>
				<td style="width: 80%">
					<table>
						<tr>
							<td style="width: 85%; border: none;">
								레시피이름 <!-- 데이터이름 -->
							</td>
							<td style="width: 15%; border: none;">
								작성자
							</td>							
						</tr>
						<tr>
							<td style="width: 100%; border: none;" colspan="2">
								레시피 소개란 <!-- 간단셰프 소개란 -->
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
		</td>
	</tr>
</table>
<div id="dlg_recipeDetail" closed="true" class="easyui_dialog" style="padding: 20px 50px">
</div>
