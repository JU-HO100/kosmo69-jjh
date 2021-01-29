<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<title>last demo</title>
</head>
<body>
	<table align="center" style="width: 70%; height: 100%;">
		<!-- Header -->
		<tr>
			<td colspan="2"
				style="width: 100%; padding-top: 2%; padding-bottom: 2%;"><%@ include
					file="./header.jsp"%></td>
		</tr>
		<!-- END Header -->

		<!-- NavBar -->
		<tr>
			<td colspan="2" style="width: 100%;"><%@ include
					file="./navbar.jsp"%></td>
		</tr>
		<!-- END NavBar -->
	</table>
	<div class="container">
		<div class="card-header card-header-primary">
			<h4 class="card-title">
				<i class="fas fa-square"></i> 관리자 음식 등록 페이지
			</h4>
			<p class="card-catagory"></p>
		</div>
		<form action=""><!-- ###################################################### form 시작 -->
			<table class="table">
				<tr style="line-height: 32px;">
					<td>음식이름</td>
					<td><input type="text" name="food_name" class="form-control"
						value=""></td>
				</tr>
				<tr>
					<td>대표이미지</td>
					<td>
						<table class="table" style="width: 200px; height: 200px"
							border="1px">
							<tbody id="fileTableTbody">
								<tr>
									<td id="dropZone">사진을 드래그 하세요</td>
								</tr>
							</tbody>
						</table>
					</td>
					<td>음식설명</td>
					<td><input type="text" name="food_description"
						class="form-control" value=""
						style="width: 300px; height: 200px; font-size: 10px;"></td>
				</tr>
			</table>
				<table border="1" style="width: 950px">
					<tbody>
						<tr name="trStaff">
						</tr>
					</tbody>
				</table>
			</form><!-- ###################################################### form 끝 -->
			<button name="addStaff" onclick="arrPush()">재료 추가</button>
			<form action=""><!-- ###################################################### form 시작 -->
				<table border="1" style="width: 950px">
					<tbody>
						<tr name="trStep">
						</tr>
					</tbody>
				</table>
			</form><!-- ###################################################### form 끝 -->
			
			
		<button name="addStep">Step 추가</button>
		<h1>완성사진</h1>
		<form action=""><!-- ###################################################### form 시작 -->
			<table class="table" style="width: 200px; height: 200px" border="1px">
				<tbody id="fileTableTbody">
					<tr>
						<td><input type="file"></td>
					</tr>
				</tbody>
			</table>
		</form><!-- ###################################################### form 끝 -->
	<input type="submit" value="등록">
	</div>
	
	
	
	
	
	
	<script>
		var arrNum = [];
		var i = 0;
		function arrPush() {
			var trHtml = $("tr[name=trStaff]:last"); //last를 사용하여 trStaff라는 명을 가진 마지막 태그 호출
			trHtml.after(addStaffText); //마지막 trStaff명 뒤에 붙인다.
		}
		//재료순서 step추가 버튼
		$(document)
				.on(
						"click",
						"button[name=addStep]",
						function() {
							var addStaffText = 
									'<tr name="trStep" id="myTabletr">'
									+ '	<td class="text-center">Step</td> '
										+ '	<td>'
										+ '		<table class="table" style="width: 200px; height: 200px;border:1px">                                               '
										+ '			<tbody id="fileTableTbody">'
										+ '				<tr> '
										+ '					<td id="dropZone">사진을 드래그 하세요</td>'
										+ '				</tr>'
										+ '			</tbody>'
										+ '		</table>'
										+ '		<td class="text-center">설명</td>'
										+ '	<td><input type="text" name="food_description" class="form-control" value=" " style="width: 300px; height: 200px; font-size: 10px;"></td>'
									+ '<td width="100"><button class="btn btn-default" name="delStaff">삭제</button>	</td>'
								+ '	</tr>';

							var trHtml = $("tr[name=trStep]:last"); //last를 사용하여 trStaff라는 명을 가진 마지막 태그 호출

							trHtml.after(addStaffText); //마지막 trStaff명 뒤에 붙인다.

						});

		//삭제 버튼
		$(document).on("click", "button[name=delStep]", function() {

			var trHtml = $(this).parent().parent();

			trHtml.remove(); //tr 테그 삭제

		});
	</script>
</body>
</html>
