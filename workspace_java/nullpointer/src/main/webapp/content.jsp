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
<div class="container" style="background-color: white;">
	<table style="width: 100%">
  		<tr>
  			<td>
  				<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">신규 레시피</h1>
  			</td>
  			<td style="text-align: right; padding-top: 20px;">
  				<a href="#" style="font-family: 'Nanum Pen Script', cursive; font-size: 20px; color: black;">더보기</a>
  			</td>
  		</tr>
	</table>
  <table class="table table-hover">
    <tbody>
<!--       <tr style="cursor: pointer;"> -->
<!--       	<td style="width: 30%"> -->
<!--       		<input type="image" src="/images/food.jpg" style="width: 100%"> -->
<!--       	</td> -->
<!--         <td style="width: 55%">요리1</td> -->
<!--         <td style="width: 15%">셰프1</td> -->
<!--       </tr> -->
<%
			for(int i=0;i<4;i++){
			//Map<String,Object> rmap = boardList.get(i);
%>
	<tr style="cursor: pointer;">
	<td style="width: 30%">
		<input type="image" src="/images/food.jpg" style="width: 100%">
	</td>
		<td style="width: 55%">요리1</td>
		 <td style="width: 15%">셰프1</td>
	</tr>
<%
			}
%>
    </tbody>
  </table>
</div>