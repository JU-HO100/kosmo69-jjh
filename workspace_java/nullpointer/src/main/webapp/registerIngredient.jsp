<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<script type="text/javascript">
function adjustHeight() {
	  var textEle = $('textarea');
	  var textEleHeight = textEle.prop('scrollHeight');
	  textEle.css('height', textEleHeight);
	};

	adjustHeight(); // 함수를 실행하면 자동으로 textarea의 높이 조절
</script>
<title>오늘 뭐 먹지?</title>
</head>
<body>
<table align="center"  style="width: 100%; text-align: center;">
	<tr>
		<td>
			재료태그구현
		</td>
	</tr>
	<tr>
		<td>
			<table style="width: 100%;">
				<tr>
					<td>
						<form class="form-inline" action="#" method="get">
						<input class="form-control mr-sm-2" type="search" placeholder="Search..." aria-label="Search" style="width: 90%">
						<button type="button" class="btn btn-secondary">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
								  <path fill-rule="evenodd" d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z" />
								  <path fill-rule="evenodd"d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z" />
								</svg>
						</button>
						</form>
					</td>
				</tr>
				<tr>
					<td>
						<table class="table table-hover">
							<tr>
								<td>
									재료 리스트 쭉 나오기
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>	
	</tr>
</table>
</body>
</html>