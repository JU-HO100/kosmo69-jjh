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
<%
			for(int i=0;i<4;i++){
			//Map<String,Object> rmap = boardList.get(i);
%>
	<tr style="cursor: pointer;">
		<td>
		<script>
			$.ajax({
 			     url : "/recipe/recipeList.np"
 		         ,success : function (result) { 
 		        	 $.each(result, function (index, item) {
 		        	       //table에 출력   
 		        	      if(item.C_COOK != null){
 			        	      var str = '<table style="width:100%; margin-bottom:5%"><tr><td style="width:50%"> 제목 : '+item.C_COOK+'</td>';
 			        	      str += '<td style="float: right;">작성자 : '+item.C_COOK+'</td></tr></table>'; 
 			        	      $('#newRecipe').append(str);
 		        	      }
 		        	   });
 		        	}
 		         });
 		</script>
 		</td>
	</tr>
<%
			}
%>
    </tbody>
  </table>
</div>