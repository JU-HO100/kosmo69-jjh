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
function proc(result){
   $.each(result, function (index, item) {
            //div에 출력
      $('#tb_ajax').append(item.MASTER_GROUPID + ' : ' + item.MASTER_GROUPNAME+'<br>');
            
            
            
            
       //table에 출력   
      var str = '<tr><td>'+item.MASTER_GROUPID+'</td>';
      str += '<td>' + item.MASTER_GROUPNAME + '</td>';
      $('table').append(str);
   });
}

$(document).ready(function () {
      $.ajax({
         url: '/admin/rightList.np',
         success : function (result) { // each()함수 사용하거나 for문 사용
            //alert(result) // 객체이기 때문에 아래와 같이 출력된다.
                  // [object Object],[object Object],[object Object]
            proc(result); // proc함수 호출
         } // success
      });
   });
</script>
</head>


<body>
   <button type="button">버튼</button>
   <div id="tb_ajax">
   
   </div>
   <br>
   <table border="1">
      <tr>
         <th>이름</th>
         <th>성별</th>
      </tr>
   </table>


</body>
</html>