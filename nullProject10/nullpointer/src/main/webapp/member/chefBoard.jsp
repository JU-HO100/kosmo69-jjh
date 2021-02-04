<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 먹지?</title>
<%@ include file="/common/bootstrap_common.jsp"%>
</head>
<body>
	<div style="width: 100%;" id="recipeCard1" >
	</div>
	<div style="width: 100%;" id="recipeCard2" >
	</div>
	<div style="width: 100%;" id="recipeCard3" >
</div>
<script type="text/javascript">
 $.ajax({
	 url : "/member/chefBoard.np?m_id=hodol30"
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
<script type="text/javascript">
$.ajax({
	url : "/member/chefBoard.np?m_id=hodol30"
	         ,success : function (result) { 
	        	    var imsi = JSON.stringify(result);//json포맷형식
	        	    var arrayObj  = JSON.parse(imsi);//[objejct,object]
	        	    for(var i=0;i<arrayObj.length;i++){
	        	    	if(Math.floor(i/4)==0){
	        	    		var str = '<div class="card" style="height: 400px; width:280px; float: left; margin :15px;">';
			        	      str += '<img class="card-img-top" src="/images/goodFood.jpg" style="width:100%">';
			        	      str += '<div class="card-body text-left">';
			        	      str += '<p class="card-text">제목 : ' +arrayObj[i].FOODNAME+ '</p>';
			        	      str += '<table><tr><td>' +arrayObj[i].M_NICK+ '님의 게시물</td></tr>';
			        	      str += '<tr><td><img src="/images/likeOn.png" style="width: 25px; float: left; margin-right: 2px; ">';
			        	      str += '<p style="float: left;">' +arrayObj[i].LIKECOUNT+ '</p></td>';
			        	      str += '<td> <button type="button" class="btn btn-outline-dark" style="float: right;">보기</button></td>';
			        	      str += '</tr></table></div></div>'; 
			        	      $('#recipeCard1').append(str);
		        	      
//	        	    		arrayObj[i].empno 나 arrayObj[i].ename 이런식으로
	        	    	}else if(Math.floor(i/4)==1){
	        	    		var str = '<div class="card" style="height: 400px; width:280px; float: left; margin :15px;">';
			        	      str += '<img class="card-img-top" src="/images/goodFood.jpg" style="width:100%">';
			        	      str += '<div class="card-body text-left">';
			        	      str += '<p class="card-text" style="word-break:keep-all">제목 : ' +arrayObj[i].FOODNAME+ '</p>';
			        	      str += '<table><tr><td>' +arrayObj[i].M_NICK+ '님의 게시물</td></tr>';
			        	      str += '<tr><td><img src="/images/likeOn.png" style="width: 25px; float: left; margin-right: 2px; ">';
			        	      str += '<p style="float: left;">' +arrayObj[i].LIKECOUNT+ '</p></td>';
			        	      str += '<td> <button type="button" class="btn btn-outline-dark" style="float: right;">보기</button></td>';
			        	      str += '</tr></table></div></div>'; 
			        	      $('#recipeCard2').append(str);
		        	      						        	    		
	        	    	}else if(Math.floor(i/4)==2){
	        	    		var str = '<div class="card" style="height: 400px; width:280px; float: left;">';
			        	      str += '<img class="card-img-top" src="/images/goodFood.jpg" style="width:100%">';
			        	      str += '<div class="card-body text-left">';
			        	      str += '<p class="card-text">제목 : ' +arrayObj[i].FOODNAME+ '</p>';
			        	      str += '<table><tr><td>' +arrayObj[i].M_NICK+ '님의 게시물</td></tr>';
			        	      str += '<tr><td><img src="/images/likeOn.png" style="width: 25px; float: left; margin-right: 2px; ">';
			        	      str += '<p style="float: left;">' +arrayObj[i].LIKECOUNT+ '</p></td>';
			        	      str += '<td> <button type="button" class="btn btn-outline-dark" style="float: right;">보기</button></td>';
			        	      str += '</tr></table></div></div>'; 
			        	      $('#recipeCard3').append(str);
	        	    		}
	        	   			}//for문
		        	   }//	success			        	    		
				});//아작스
</script>
</body>
</html>