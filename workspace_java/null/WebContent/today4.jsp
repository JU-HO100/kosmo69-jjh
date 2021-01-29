<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table style="width: 100%">
	<tr>
		<td style="width: 20%; vertical-align: top;">
			<div class="btn-group-vertical" style="width: 100%;">
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="today1()">한식</button>
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="today2()">중식</button>
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="today3()">일식</button>
				 <button type="button" class="btn btn-outline-dark active" style="text-align: left;" onclick="today4()">양식</button>
			</div>
		</td>
		<td style="width: 80%; padding-left: 5%; padding-right: 5%;">
		  <h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">오늘의 일식</h1>
		  <table class="table table-hover">
		    <tbody>
		      <tr>
		      	<td style="width: 20%">
		      		<input type="image" src="./images/food4.jpg" style="width: 100%;">
		      	</td>
		        <td style="width: 60%">양식 요리1</td>
		        <td style="width: 20%">셰프1</td>
		      </tr>
		      <tr>
		      	<td>
		      		<input type="image" src="./images/food4.jpg" style="width: 100%;">
		      	</td>
		        <td>양식 요리2</td>
		        <td>셰프2</td>
		      </tr>
		      <tr>
		      	<td>
		      		<input type="image" src="./images/food4.jpg" style="width: 100%;">
		      	</td>
		        <td>양식 요리3</td>
		        <td>셰프3</td>
		      </tr>
		      <tr>
		      	<td>
		      		<input type="image" src="./images/food4.jpg" style="width: 100%;">
		      	</td>
		        <td>양식 요리4</td>
		        <td>셰프4</td>
		      </tr>
		    </tbody>	
		  </table>
		</td>
	</tr>
</table>