<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String MSG = (String)request.getAttribute("msg"); %>
<% String id = (String)session.getAttribute("id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript" src="<%=path.toString() %>js/cookclass.js"></script>
</head>
<body>
<table align="center" style="width: 70% ; height: 100%;">
<tr>
<td style="width: 100%; padding-top:3% ;padding-left: 5%; padding-right: 5%;">
				<table id="cookclass"  class="table" style="width: 100%;">
					<tr>
						<td style="border: none;">
							<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">쿠킹클래스 신청</h1>
 							<script type="text/javascript">
 									function apply(i) {
 										if (confirm("해당 쿠킹 클래스를 등록하시겠습니까??") == true){    //확인
											location.href="/cookclass/joinClass.np?c_classcd="+i+"&m_id="+"<%=id%>";
 										}else{
 										    return;
 										}
									}
 								      $.ajax({
 									     url : "/cookclass/showClass.np?m_id="+"<%=id%>"
 								         ,success : function (result) { 
 								        	 $.each(result, function (index, item) {
 								        	       //table에 출력   
 								        	      if(item.C_COOK != null){
 									        	      var str = '<table style="width:100%; margin-bottom:5%"><tr><td style="width:50%"> 제목 : '+item.C_COOK+'</td>';
 									        	      str += '<td colspan="2" style="width:50%"> 날짜 : ' + item.C_DATE + '</td></tr>';
 									        	      str += '<tr><td colspan="3"> 준비물 : ' + item.C_INGREDIENTS + '</td></tr>';
 									        	      str += '<tr><td colspan="3"> 주소 : ' + item.C_ZIP + '</td></tr>';
 									        	      str += '<tr><td> 현재인원 : ' + item.NOWPERSONS + '</td>';
 									        	      str += '<td> 최대인원 : ' + item.MAXPERSONS + '</td>';
 									        	      str += '<td style="float: right;"><button class="btn btn-outline-dark" onclick="apply('+item.C_CLASSCD+')">신청하기</button></td></tr></table>'; 
 									        	      $('#cookclass').append(str);
 								        	      }
 								        	   });
 								        	}
 								         });
 							</script>
						</td>
					</tr>
					</table>
</body>
</html>