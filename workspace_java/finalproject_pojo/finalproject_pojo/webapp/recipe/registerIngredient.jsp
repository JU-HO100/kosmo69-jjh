<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
</head>
<body>
<table align="center"  style="width: 100%; text-align: center;">
	<tr>
		<td>
			<div id="jaelyoAppend" style="float: left;">
					재료:
					<input class="easyui-tagbox" value="명란젓" style="width:100%">			
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<table style="width: 100%;">
				<tr>
					<td style="width: 100%">
						<input id ="inp_keyword"  class="form-control"  type="search"  name="keyword" placeholder="재료를 입력해주세요."  style="width: 90%; float: left;">
						<input type="button" class="btn btn-secondary"  onclick ="getKeyword()" value="검색" style="float: left;">
					</td>
				</tr>
				<tr>
					<td>
						<div id="ingredient"></div>
						<script type="text/javascript">
						var keyword="";
						var str="";
						
						function getKeyword(){
							keyword = $("#inp_keyword").val();
							
							$.ajax({
								url:"/recipe/jaelyoList.np?keyword="+keyword
									,success : function (result) { 
										$.each(result, function (index, item) {
						        	    	str += '<form action="" name=""><table class="table table-hover" style="margin-bottom:0px"><tr><td style="width:25%">'+item.JAELYO+'</td>';
						        	    	str += '<td style="width:25%"><input type="text" class="form-control" id="WEIGHT" name="WEIGHT"></td>';
						        	    	str += '<td style="width:25%">'+item.UNIT+'</td>';
						        	    	str += '<td style="width:10%"><input type="button" class="btn btn-outline-success"  value="등록"></td></tr></table><form>';
										 });
										$('#ingredient').html(str);
										str="";
						        	}
						         });
						}
					</script>
					</td>
				</tr>
			</table>
		</td>	
	</tr>
</table>
</body>
</html>