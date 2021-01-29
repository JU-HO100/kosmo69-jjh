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
		<div class="card-body">
			<div class="table-responsive">
				<table class="table">
					<tbody>
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
					</tbody>
				</table>
			</div>
		</div>
		<button name="addStaff">재료 추가</button>
		<br> <br>
		<table border="1" style="width: 950px">
			<tbody>
				<tr name="trStaff">
					<td style="width: 150px"><strong>재료</strong></td>
					<td style="width: 800px"><input type="text" name="staff_name"
						placeholder="재료이름"> <input type="text"
						name="staff_contact" placeholder="계량숫자"> <select
						name="staff_use_yn">
							<option value="Y">계량단위</option>
							<option value="Y">큰술(1큰술(1T,1Ts))</option>
							<option value="N">작은술(1t,1ts)</option>
							<option value="N">컵(1Cup,1C)</option>
							<option value="N">종이컵(180ml)</option>
							<option value="N">oz(28.3g)</option>
							<option value="N">파운드(lb)</option>
							<option value="N">갤런(gallon 3.78L)</option>
							<option value="N">꼬집</option>
							<option value="N">조금</option>
							<option value="N">적당량</option>
							<option value="N">줌</option>
							<option value="N">주먹(100g)</option>
							<option value="N">토막</option>
							<option value="N">톨(마늘)</option>
							<option value="N">쪽</option>
							<option value="N">톨(생강)</option>
							<option value="N">근(고기600g)</option>
							<option value="N">근(채소400g)</option>
							<option value="N">봉지(채소200g)</option>
					</select></td>
				</tr>
			</tbody>
		</table>
		<div class="container">
			<div class="card-body">
				<div class="table-responsive">
					<table class="table">
						<tbody>
							<tr style="line-height: 32px;">
							</tr>
							<h1>조리순서</h1>
							<button name="addStep">Step 추가</button>
							<tr name="trStep">
								<td>Step1</td>
								<td>
									<table class="table" style="width: 200px; height: 200px"
										border="1px">
										<tbody id="fileTableTbody">
											<tr>
												<td id="dropZone">사진을 드래그 하세요</td>
											</tr>
										</tbody>
									</table>
								<td>설명</td>
								<td><input type="text" name="food_description"
									class="form-control" value=""
									style="width: 300px; height: 200px; font-size: 10px;">
								</td>
							</tr>
						</tbody>
					</table style="text-align: center;">
					<h1>완성사진</h1>
					<table class="table" style="width: 200px; height: 200px"
						border="1px">
						<tbody id="fileTableTbody">
							<tr>
								<td id="dropZone">사진을 드래그 하세요</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div></div>
		<script>
			//재료 추가 버튼
			$(document)
					.on(
							"click",
							"button[name=addStaff]",
							function() {

								var addStaffText = '<tr name="trStaff">'
										+ ' <td style="width:150px"><strong>재료</strong></td>                  '
										+ ' <td style="width:800px">                                            '
										+ '     <input type="text" name="staff_name" placeholder="재료이름">    '
										+ '     <input type="text" name="staff_contact" placeholder="계량(숫자)">     '
										+ '     <select name="staff_use_yn">                                    '
										+ '         <option value="Y">계량단위</option>              '
										+ '         <option value="Y">큰술(1큰술(1T,1Ts))</option>              '
										+ '         <option value="N">작은술(1t,1ts)</option>                   '
										+ '         <option value="N">컵(1Cup,1C)</option>                      '
										+ '         <option value="N">종이컵(180ml)</option>                    '
										+ '         <option value="N">oz(28.3g)</option>                        '
										+ '         <option value="N">파운드(lb)</option>                       '
										+ '         <option value="N">갤런(gallon 3.78L)</option>               '
										+ '         <option value="N">꼬집</option>                             '
										+ '         <option value="N">조금</option>                             '
										+ '         <option value="N">적당량</option>                           '
										+ '         <option value="N">줌</option>                               '
										+ '         <option value="N">주먹(100g)</option>                       '
										+ '         <option value="N">토막</option>                             '
										+ '         <option value="N">톨(마늘)</option>                         '
										+ '         <option value="N">쪽</option>                               '
										+ '         <option value="N">톨(생강)</option>                         '
										+ '         <option value="N">근(고기600g)</option>                     '
										+ '         <option value="N">근(채소400g)</option>                     '
										+ '         <option value="N">봉지(채소200g)</option>                   '
										+ '     </select>                                                       '
										+ '<button class="btn btn-default" name="delStaff">삭제</button>'
										+ ' </td>	' + '</tr>';

								var trHtml = $("tr[name=trStaff]:last"); //last를 사용하여 trStaff라는 명을 가진 마지막 태그 호출

								trHtml.after(addStaffText); //마지막 trStaff명 뒤에 붙인다.

							});

			//삭제 버튼
			$(document).on("click", "button[name=delStaff]", function() {

				var trHtml = $(this).parent().parent();

				trHtml.remove(); //tr 테그 삭제

			});
			//재료순서 step추가 버튼
			$(document)
					.on(
							"click",
							"button[name=addStep]",
							function() {

								var addStaffText = '<tr name="trStep">'
										+ '	<td>Step1</td>                                                      '
										+ '	<td>                                                                '
										+ '		<table class="table" style="width: 200px; height: 200px"        '
								+'			border="1px">                                               '
										+ '			<tbody id="fileTableTbody">                                 '
										+ '				<tr>                                                    '
										+ '					<td id="dropZone">사진을 드래그 하세요</td>         '
										+ '				</tr>                                                   '
										+ '			</tbody>                                                    '
										+ '		</table>                                                        '
										+ '	<td>설명</td>                                                       '
										+ '	<td><input type="text" name="food_description"                      '
								+'		class="form-control" value=""                                   '
								+'		style="width: 300px; height: 200px; font-size: 10px;">			'
										+ '<button class="btn btn-default" name="delStaff">삭제</button>			'
										+ '</td>     															'
										+ '		</tr>                                                           ';

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
