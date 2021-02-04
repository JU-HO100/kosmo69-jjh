<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("id");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<script type="text/javascript">
function memAccept(m_id, chef_id, c_classcd) {
	if (confirm("해당 회원을 수락하시겠습니까?") == true){ //확인
		location.href="/cookclass/myClassMemAccept.np?m_id="+m_id+"&chef_id="+chef_id+"&c_classcd="+c_classcd;
		}else{
		    return;
		}
}
function deny(m_id,chef_id,c_classcd) {
	if (confirm("해당 회원을 반려하시겠습니까?") == true){ //확인
		location.href="/cookclass/myClassMemDeny.np?m_id="+m_id+"&chef_id="+chef_id+"&c_classcd="+c_classcd;
		}else{
		    return;
		}
}
</script>
<title>오늘 뭐 먹지?</title>
</head>
<body>
<script type="text/javascript">
$.ajax({
	url: "/cookclass/myClassMemList.np?c_classcd=<%=request.getParameter("c_classcd")%>&chef_id=<%=request.getParameter("chef_id")%>"
	,success : function (result) { 
		$.each(result, function (index, item) {
			var imsi = item.RGREPORT;
			var no = item.M_ID;
			var check = "수락";
			var check2 = "신청한 회원이 없습니다";
			var check3 = "반려";
			if(item.M_ID != null){
				var str = '<tr><td style="width:50%">'+ item.M_ID+'</td>';
				str += '<td style="width:50%"><input class="btn btn-outline-dark" type="button" value="수락" onclick="javascript:memAccept('+"'"+item.M_ID+"'"+','+"'"+item.CHEF_ID+"'"+','+"'"+item.C_CLASSCD+"'"+')">&nbsp;&nbsp;<input class="btn btn-outline-dark" type="button" value="반려" onclick="javascript:deny('+"'"+item.M_ID+"'"+','+"'"+item.CHEF_ID+"'"+','+"'"+item.C_CLASSCD+"'"+')"></td></tr>';
				
				var str2 = '<tr><td style="width:50%">'+ item.M_ID+'</td>';
				str2 += '<td style="width:50%">수락 완료</td></tr>';	
				
				var str3 = '<tr><td style="width:50%">'+ item.M_ID+'</td></tr>';
				
				var str4 = '<tr><td style="width:50%">'+ item.M_ID+'</td>';
				str4 += '<td style="width:50%">반려 완료</td></tr>';	
				
				if(imsi==check){
				$('#memberList').append(str2);
				}else if(no==check2){
				$('#memberList3').append(str3);
				}else if(imsi==check3){
				$('#memberList4').append(str4);
				}else{
				$('#memberList2').append(str);
				}
						}
				   });
				}
			});
</script>
<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">신청 회원 목록</h1>
<table id="memberList" class="table" ></table>
<table id="memberList2" class="table"></table>
<table id="memberList3" class="table"></table>
<table id="memberList4" class="table"></table>
</body>
</html>