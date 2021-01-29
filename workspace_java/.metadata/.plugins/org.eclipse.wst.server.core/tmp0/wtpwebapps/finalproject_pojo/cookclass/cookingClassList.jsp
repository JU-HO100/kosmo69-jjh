<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String MSG = (String)request.getAttribute("msg"); %>
<% String id = (String)session.getAttribute("id"); %>
<%! int[] c_classcdArr;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript" src="<%=path.toString() %>js/cookclass.js"></script>
</head>
<body>
	<%if(id!=null){ %>
	<table align="center" style="width: 70% ; height: 100%;">
			<!-- Header -->
		<tr>
			<%if(session.getAttribute("nick")!=null){ %>
			<td colspan="2" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/loginOkHeader.jsp"%>
			</td>
			<%}else{ %>
			<td colspan="2" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
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
 										$.ajax({
 										     url : "/kmap.jsp?c_map="+c_map+"&c_detail="+c_detail
//  										     url : "/kmap.jsp"
 									         ,success : function (data) {
 									        	window.open("http://192.168.0.38:9005/kmap.jsp","실습주소"
 									        			, "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );
 											}
 										});
 									}
 									<%--============================= 전역변수 설정========================== --%>
 									 $.ajax({
									     url : "/cookclass/showClass.np?m_id="+"<%=id%>"
								         ,success : function (data) { 
	 								//jsontext에 JSON객체를 넣는다.
				 						  var result = JSON.stringify(data);
				    				   //alert("result:"+result);
				    				   var arr = JSON.parse(result);
	 								//for문을 돌면서 contact[i]의 key 값을 가져와 value값 출력해준다.
	 										for (var i = 0; i < arr.length; i++) {
	 												c_classcdArr.push(arr[i].C_COOK);
	 												}
	 											}})
 									<%--============================= 전역변수 설정========================== --%>
 								      $.ajax({
 									     url : "/cookclass/showClass.np?m_id="+"<%=id%>"
 								         ,success : function (result) { 
 								        	 $.each(result, function (index, item) {
 								        	       //table에 출력   
 								        	      if(item.C_COOK != null){
 									        	      var str = '<table style="width:100%; margin-bottom:5%"><tr><td style="width:50%"> 제목 : '+item.C_COOK+'</td>';
 									        	      str += '<td colspan="2" style="width:50%"> 날짜 : ' + item.C_DATE + '</td></tr>';
 									        	      str += '<tr><td colspan="3"> 준비물 : ' + item.C_INGREDIENTS + '</td></tr>';
 									        	      str += '<tr><td style="width:40%;"id="c_zip" name="c_zip"> 주소 : ' + item.C_ZIP + '</td>';
 		                                              str += '<td style="width:40%;" id="c_detail" name="c_detail"> 상세주소 : ' + item.C_ZIPDETAIL + '</td>';
 		                                              str += '<td style="width:20%;"><button class="btn btn-outline-dark" onclick="map()">Map</button></td></tr>';
//  		                                              str += '<td style="width:20%;"><button class="btn btn-outline-dark" onclick="map('+ item.C_ZIP+item.C_ZIPDETAIL+')">Map</button></td></tr>';
 									        	      str += '<tr><td> 현재인원 : ' + item.NOWPERSONS + '</td>';
 									        	      str += '<td> 최대인원 : ' + item.MAXPERSONS + '</td>';
 									        	      str += '<td style="float: right;"><button class="btn btn-outline-dark" onclick="apply('+item.C_CLASSCD+')">신청하기</button></td></tr></table>'; 
 									        	      $('#cookclass').append(str);
//  									        	      c_map = item.C_ZIP + item.C_ZIPDETAIL;
 									        	      c_map = item.C_ZIP;//이렇게 하면 List에 있는 모든 정보가 넘어온다.
 									        	      c_detail = item.C_ZIPDETAIL;//이렇게 하면 List에 있는 모든 정보가 넘어온다.
 									        	      
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
<%}else{ %>
<script type="text/javascript">
	alert("로그인 후 이용해주세요.");
 	history.go(-1);
</script>
<%} %>
<div class="modal fade" id="dg_zip" name="dg_zip" role="dialog"  aria-hidden="true">
    <div class="modal-dialog">
		
    </div>
    <div id="modal-testNew" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="테스트정보 등록" aria-describedby="테스트 모달">
    <div class="modal-dialog" style="width:1200px;height:700px">
        <div class="modal-content">
        </div>
    </div>
</div>
</div>
</body>
</html>