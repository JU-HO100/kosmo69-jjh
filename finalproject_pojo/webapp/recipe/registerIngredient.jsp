<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript">
function finalclose() {
	opener.document.getElementById("aabb").value = document.getElementById("jealyo").value
	window.close();
}
</script>
</head>
<body>
<table align="center"  style="width: 100%; text-align: center;">
	<tr>
		<td>
			<input type="button" value="재료등록 완료" class="btn btn-secondary" onclick="javascript:finalclose()">
		</td>
	</tr>	
	<tr>
		<td>
			<div id="jaelyoAppend" style="float: left; width: 100%;">
					재료:
					<input class="easyui-tagbox"  style="width:80%" id="jaelyoTag" >			
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<table style="width: 100%;">
				<tr>
					<td style="width: 100%">
						<input id ="inp_keyword"  class="form-control"  type="search"  name="keyword" placeholder="재료를 입력해주세요."  style="width: 85%; float: left;">
						<input type="button" class="btn btn-secondary"  onclick ="getKeyword()" value="검색" style="float: left;">
					</td>
				</tr>
				<tr>
					<td>
						<div id="ingredient">
							<script type="text/javascript">
							var test = [];
							function getKeyword(){
								keyword = $("#inp_keyword").val();
							    $.ajax({
								      type : "GET",
								      url : "/recipe/jaelyoList.np?keyword="+keyword,
								      dataType : "text",
								      success : function(data) {
								        $('#ingredient').html(data);
								      },
								      error : function() {
								        alert('재료레시피를 불러오지 못했습니다!!');
								      }
								    });
							}
							</script>
						</div>
					</td>
				</tr>
			</table>
		</td>	
	</tr>
</table>
</body>
</html>