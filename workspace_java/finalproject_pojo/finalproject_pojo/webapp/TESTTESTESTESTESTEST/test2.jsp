<%@ page contentType="text/html; charset=UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8"); 
   String cp = request.getContextPath(); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>

//코드의 양이 많아서 result값 받아서 실행하는 proc(result) 함수 생성
$(document).ready(function () {
      $.ajax({
    	  url : "/member/chefRanking.np",
         success : function (result) { 
        	  $.each(result, function (index, item) {
             $('#tb_ajax').append(
           		'순위 : '+item.RANKING+'like : '+item.M_LIKE+'셰프님 : '+item.M_NAME+'<br>'
             );
          });
         } 
      });
   });
</script>
</head>
<body>
   <div id="tb_ajax">
   </div>
</body>
</html>