<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 먹지?</title>
<%@ include file="/common/bootstrap_common.jsp"%>
<%String indexNick =  (String)session.getAttribute("nick");%>
<script>
//Get the button
var mybutton = document.getElementById("myBtn");

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
  
}
function goRecipe() {
	location.href="/recipe/registerRecipe.jsp";
}
function goPopRecipe() {
	location.href="/recipe/popRecipe.jsp";
    }
function logout() {
	location.href="/member/logout.jsp";
}
function category(keyword) {
	location.href="/recipe/largeCategoryList.jsp?keyword="+keyword;
}
function smallcategory(keyword) {
	location.href="/recipe/smallCategoryList.jsp?keyword="+keyword;
}
function goDetail(menucd) {
	location.href="/recipe/recipeContentGo.jsp?menucd="+menucd;
}
</script>
<style>
#myBtn {
  position: fixed;
  bottom: 45px;
  right: 45px;
  z-index: 99;
  font-size: 18px;
  border: 1px solid black;
  outline: none;
  background-color: white;
  color: black;
  cursor: pointer;
  padding: 15px;
  border-radius: 8px;
}
</style>
</head>
<body>
	<table align="center" style="width: 70% ; height: 100%;">
			<!-- Header -->
		<tr>
			<%if(indexNick!=null && indexNick.equals("총관리자")){ %>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/adminHeader.jsp"%>
			</td>		
			<%}else if(indexNick!=null && indexNick.length() >0 && ! indexNick.equals("총관리자")){ %>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/loginOkHeader.jsp"%>
			</td>
			<%}else{ %>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/header.jsp"%>
			</td>
			<%} %>
		</tr>
			<!-- END Header -->
			
			<!-- NavBar -->
		<tr>
			<td style="width: 100%;">
				<%@ include file="/navbar.jsp" %>
			</td>
		</tr>
			<!-- END NavBar -->
			<!-- Content -->
		<tr>
			<td style="padding-left: 1%; padding-bottom: 1%; padding-top: 3%; padding-right: 1%;" >
				<%@ include file="/largeCategory.jsp" %>
			</td>
		</tr>
		<tr>
			<td style="padding-left: 1%; padding-bottom: 5%">
				<%@ include file="/smallCategory.jsp" %>
			</td>
		</tr>
		<tr>
			<td align="center">
					<div style="width: 100%; align: center;" id="recipeCard1" >
					</div>
					<div style="width: 100%;" id="recipeCard2" >
					</div>
					<div style="width: 100%;" id="recipeCard3" >
					</div>
					<%--============================= 전역변수 설정========================== --%>
					<script type="text/javascript">
 						 $.ajax({
 							url : "/recipe/recipeList.np"
					         ,success : function (data) { 
	 					//jsontext에 JSON객체를 넣는다.
				 			  var result = JSON.stringify(data);
				   		   //alert("result:"+result);
				   		   var arr = JSON.parse(result);
	 					//for문을 돌면서 contact[i]의 key 값을 가져와 value값 출력해준다.
	 						var recipeListArr = arr.length;
					         }
 						 });
	 				</script>
 					<%--============================= 전역변수 설정========================== --%>
					<script type="text/javascript">
						var keyword = "<%=request.getParameter("keyword")%>";
					    $.ajax({
						      url : "/recipe/smallSearch.np?keyword="+keyword
							         ,success : function (result) { 
							        	    var imsi = JSON.stringify(result);//json포맷형식
							        	    var arrayObj  = JSON.parse(imsi);//[objejct,object]
							        	    for(var i=0;i<arrayObj.length;i++){
							        	    	if(Math.floor(i/4)==0){
							        	    		var str = '<div class="card" style="height: 400px; width:220px; float: left; margin :15px; "">';
							        	    		str += '<img class="card-img-top" src="'+arrayObj[i].MAIN_IMG+'" style="width:100%;height:150px;">';
									        	      str += '<div class="card-body text-left">';
									        	      str += '<p class="card-text" style="white-space: nowrap;overflow:hidden">' +arrayObj[i].FOODNAME+ '</p>';
									        	      str += '<table style="width: 100%; height: 100%;"><tr><td style="white-space: nowrap;">' +arrayObj[i].M_NICK+ '님의 게시물</td></tr>';
									        	      str += '<tr style="bottom: 0px"><td style="white-space: nowrap;">좋아요';
									        	      str +=  +arrayObj[i].CNT+ '</td>';
									        	      str += '<td> <button type="button" class="btn btn-outline-dark" style="float: right;white-space: nowrap;" onclick="javascript:goDetail('+arrayObj[i].MENUCD+')">보기</button></td>';
									        	      str += '</tr></table></div></div>'; 
									        	      $('#recipeCard1').append(str);
								        	      
// 							        	    		arrayObj[i].empno 나 arrayObj[i].ename 이런식으로
							        	    	}else if(Math.floor(i/4)==1){
							        	    		var str = '<div class="card" style="height: 400px; width:220px; float: left; margin :15px; "">';
							        	    		str += '<img class="card-img-top" src="'+arrayObj[i].MAIN_IMG+'" style="width:100%;height:150px;">';
									        	      str += '<div class="card-body text-left">';
									        	      str += '<p class="card-text" style="white-space: nowrap;overflow:hidden">' +arrayObj[i].FOODNAME+ '</p>';
									        	      str += '<table style="width: 100%; height: 100%;"><tr><td style="white-space: nowrap;">' +arrayObj[i].M_NICK+ '님의 게시물</td></tr>';
									        	      str += '<tr style="bottom: 0px"><td style="white-space: nowrap;">좋아요';
									        	      str +=  +arrayObj[i].CNT+ '</td>';
									        	      str += '<td> <button type="button" class="btn btn-outline-dark" style="float: right;white-space: nowrap;" onclick="javascript:goDetail('+arrayObj[i].MENUCD+')">보기</button></td>';
									        	      str += '</tr></table></div></div>'; 
									        	      $('#recipeCard2').append(str);
								        	      						        	    		
							        	    	}else if(Math.floor(i/4)==2){
							        	    		var str = '<div class="card" style="height: 400px; width:220px; float: left; margin :15px; "">';
							        	    		str += '<img class="card-img-top" src="'+arrayObj[i].MAIN_IMG+'" style="width:100%;height:150px;">';
									        	      str += '<div class="card-body text-left">';
									        	      str += '<p class="card-text" style="white-space: nowrap;overflow:hidden">' +arrayObj[i].FOODNAME+ '</p>';
									        	      str += '<table style="width: 100%; height: 100%;"><tr><td style="white-space: nowrap;">' +arrayObj[i].M_NICK+ '님의 게시물</td></tr>';
									        	      str += '<tr style="bottom: 0px"><td style="white-space: nowrap;">좋아요';
									        	      str +=  +arrayObj[i].CNT+ '</td>';
									        	      str += '<td> <button type="button" class="btn btn-outline-dark" style="float: right;white-space: nowrap;" onclick="javascript:goDetail('+arrayObj[i].MENUCD+')">보기</button></td>';
									        	      str += '</tr></table></div></div>'; 
									        	      $('#recipeCard2').append(str);
							        	    		}
							        	   			}//for문
								        	   }//	success			        	    		
					    				});//아작스
					</script>
			</td>
		</tr>
			<!-- End Content -->	
			<!-- Footer -->
		<tr>
			<td style="padding-top: 8%">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
	</table>
	<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
</body>
</html>