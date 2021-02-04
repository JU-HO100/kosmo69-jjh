<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String MSG = (String)request.getAttribute("msg"); %>
<% String id = (String)session.getAttribute("id"); %>
<%String indexNick =  (String)session.getAttribute("nick");%>
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
			<td colspan="2" style="width: 100%;">
				<%@ include file="/navbar.jsp" %>
			</td>
		</tr>
			<!-- END NavBar -->
			
			<!-- Content -->
		<tr>
			<td style="width: 19%; vertical-align: top;">
				<div class="btn-group-vertical" style="width: 100%; margin-top: 12%">
					 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="reload()">쿠킹 클래스 신청</button>
					 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="location.href='/member/checkChef.np?m_id=<%=id%>'">쿠킹 클래스 등록</button>
				</div>
			</td>
			<td style="width: 70%; padding-top:3% ;padding-left: 5%; padding-right: 5%;">
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
 									function map(){
										var popUrl = "/map.jsp";	//팝업창에 출력될 페이지 URL
										var popOption = "width=900, height=700, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
											window.open(popUrl,"",popOption);
 									}
 								      $.ajax({
 									     url : "/cookclass/showClass.np?m_id="+"<%=id%>"
 								         ,success : function (result) { 
 								        	 $.each(result, function (index, item) {
 								        	       //table에 출력   
 								        	      if(item.C_COOK != null){
 									        	      var str = '<table style="width:100%; margin-bottom:5%"><tr><td style="width:50%" > 제목 : '+item.C_COOK+'</td>';
 									        	      str += '<td style="width:50%" colspan="2"> 날짜 : ' + item.C_DATE + '</td></tr>';
 									        	      str += '<tr><td colspan="3"> 준비물 : ' + item.C_INGREDIENTS + '</td></tr>';
 									        	      str += '<tr><td style="width:30%;" id="c_zip" name="c_zip"> 주소 : ' + item.C_ZIP + '</td>';
 									        	      str += '<td style="width:30%;"> 상세주소 : ' + item.C_ZIPDETAIL + '</td>';
 									        	      str += '<td style="width:30%;"><button class="btn btn-outline-dark" onclick="map()">MAP</button></td></tr>';
 									        	      str += '<tr><td style="width:30%;"> 현재인원 : ' + item.NOWPERSONS + '</td>';
 									        	      str += '<td style="width:30%;"> 최대인원 : ' + item.MAXPERSONS + '</td>';
 									        	      str += '<td><button class="btn btn-outline-dark" onclick="apply('+item.C_CLASSCD+')">신청하기</button></td></tr></table>'; 
 									        	      $('#cookclass').append(str);
 									        	      
 									        	      zip = item.C_ZIP;
 								        	      }
 								        	   });
 								        	}
 								         });
 							</script>
						</td>
					</tr>
			   </table>
		</tr>
			<!-- End Content -->
			<!-- Footer -->
		<tr>
			<td colspan="2" style="width: 100%;">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
</table>
</body>
</html>