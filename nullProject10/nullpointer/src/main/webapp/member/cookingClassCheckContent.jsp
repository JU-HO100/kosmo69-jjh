<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String id = (String)session.getAttribute("id"); %>
<script>
function memberCheck(c_classcd, chef_id){
		var url = "/cookclass/myClassMemList.jsp?c_classcd="+c_classcd+"&chef_id="+chef_id+"&m_id="+"<%=id%>"
		var left = Math.ceil((window.screen.width - 700)/2);
	    var top = Math.ceil((window.screen.height - 700)/2);
    var option = "width = 500, height = 500, top="+top+", left="+left+", location = no"
		window.open(url, name, option);
}
</script>
<script>
function cookclassUpdate(c_classcd) {
	location.href="/cookclass/cookingClassUpdate.jsp?c_classcd="+c_classcd;
}
function cookclassCancel(c_classcd,m_id){
	if (confirm("해당 쿠킹클래스를 취소하시겠습니까??") == true){    //확인
		location.href="/cookclass/cancelClass.np?c_classcd="+c_classcd+"&m_id="+m_id;
	}else{
	    return;
	}		
}
function cookclassDelete(c_classcd,m_id) {
	if (confirm("해당 쿠킹클래스를 삭제하시겠습니까??") == true){    //확인
		location.href="/cookclass/cancelClass.np?c_classcd="+c_classcd+"&m_id="+m_id;
	}else{
	    return;
	}		
}
</script>
			<script type="text/javascript">
				var id = "<%=id%>";
				$.ajax({
					url : "/member/checkCookClass.np?m_id="+id
					,success : function (result) {
					$.each(result, function (index, item) {
						var imsi = item.STATUS;
						var check = "개설셰프";
					//table에 출력   
					 if(item.C_COOK != null){
							 var str2 = '<table class="table" style="width:80%; margin-bottom:5%"><tr><td style="width:50%"> 제목 : '+item.C_COOK+'</td>';
								str2 += '<td style="width:50%" colspan="2"> 날짜 : ' + item.C_DATE + '</td></tr>';
								str2 += '<tr><td colspan="3"> 준비물 : ' + item.C_INGREDIENTS + '</td></tr>';
								str2 += '<tr><td> 주소 : ' + item.C_ZIP + '</td>';
								str2 += '<td colspan="2"> 상세주소 : ' + item.C_ZIPDETAIL + '</td></tr>';
								str2 += '<tr><td> 현재인원 : ' + item.NOWPERSONS + '</td>';
								str2 += '<td> 최대인원 : ' + item.MAXPERSONS + '</td>'
								str2 += '<td style="text-align:right"><input type="button" class="btn btn-outline-dark" value="신청취소" onclick="javascript:cookclassCancel('+"'"+item.C_CLASSCD+"'"+','+"'"+id+"'"+')"></td>';
								str2 += '</tr></table>';
								
							 var str = '<table class="table" style="width:100%; margin-bottom:5%"><tr><td style="width:50%"> 제목 : '+item.C_COOK+'</td>';
								str += '<td colspan="2" style="width:50%"> 날짜 : ' + item.C_DATE + '</td></tr>';
								str += '<tr><td colspan="2"> 준비물 : ' + item.C_INGREDIENTS + '</td>';
								str += '<td style="text-align:right"><input type="button" class="btn btn-outline-dark" value="삭제하기" onclick="javascript:cookclassDelete('+"'"+item.C_CLASSCD+"'"+','+"'"+id+"'"+')"></td></tr>';
				        	    str += '<tr><td style="width:30%;"> 주소 : ' + item.C_ZIP + '</td>';
					        	str += '<td style="width:30%;"> 상세주소 : ' + item.C_ZIPDETAIL + '</td>';
								str += '<td style="text-align:right"><input type="button" class="btn btn-outline-dark" value="수정하기" onclick="javascript:cookclassUpdate('+item.C_CLASSCD+')"></td></tr>';
								str += '<tr><td> 현재인원 : ' + item.NOWPERSONS + '</td>';
								str += '<td> 최대인원 : ' + item.MAXPERSONS + '</td><td style="text-align:right"><input type="button" class="btn btn-outline-dark" value="신청 현황 보기" onclick="javasrcipt:memberCheck('+"'"+item.C_CLASSCD+"'"+','+"'"+item.CHEF_ID+"'"+')"></td></tr></table>';
							if(imsi==check){
							$('#cookclassRegister').append(str);
							}else{
							$('#cookclassApply').append(str2);
									}
					}
							});
						}
					});
			</script>
			<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">신청쿠킹클래스</h1>
			<div id="cookclassApply">
			</div>
			<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">등록쿠킹클래스</h1>
			<div id="cookclassRegister"></div>