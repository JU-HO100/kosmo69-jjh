<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user=1"> -->
<title>가변그리드-1-4</title>
<style type="text/css">
*{margin:0; padding:0;}
	#wrap{/* 가장 바깥쪽에 있는 div영역 */
		width:90%;
		height:500px;
		margin:0 auto;
		border: 5px solid #6E6E6E
	}
	#wrap div{/* div내부에 있는 div전체 적용 */
		width:31.25%;	/* 900/960 */
		height:100%;
		display:inline-block;
	}
	#wrap div:first-child {/* div안의 첫번째 div에 적용 */
		margin-right: 37.5%;
		background:red;
	}
	#wrap div:first-child + div{/* div안의 2번째 div에 적용 */
		background:blue; /* 색상만 다르게 표시 */
	}/* padding */
</style>
	
</head>
<body>
	<div id="wrap">
			<div></div><div></div>
	</div>
</body>
</html>