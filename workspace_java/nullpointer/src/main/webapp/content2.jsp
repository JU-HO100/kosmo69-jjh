<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container" style="background-color: white;">
	<table style="width: 100%">
  		<tr>
  			<td>
  				<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">인기 레시피</h1>
  			</td>
  			<td style="text-align: right; padding-top: 20px;">
  				<a href="/ranking.jsp?ranking=1" style="font-family: 'Nanum Pen Script', cursive; font-size: 20px; color: black;">더보기</a>
  			</td>
  		</tr>
	</table>
  <table class="table table-hover">
    <tbody>
<%
			for(int i=0;i<4;i++){
			//Map<String,Object> rmap = boardList.get(i);
%>
	<tr style="cursor: pointer;">
	<td style="width: 30%">
		<input type="image" src="/images/food2.jpg" style="width: 100%">
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