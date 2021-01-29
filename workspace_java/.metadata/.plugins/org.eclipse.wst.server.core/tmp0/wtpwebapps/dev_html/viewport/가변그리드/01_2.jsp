<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가변그리드-1</title>
<style type="text/css">
*{margin:0; padding:0;}
	#wrap{
		width:90%;
		height:500px;
		margin:0 auto;
		border: 5px solid #6E6E6E
	}
	#wrap div{
		width:31.25%;	/* 900/960 */
		height:492px;
		display:inline-block;
		
	}
	#wrap div:first-child{
		width: 50px 5.208%;/* 50/960 */
		background:red;
		
	}
	#wrap div:first-child + div{
		padding: 130px 13.541%;/* 130/960 */
		background:blue;
	}
</style>
	
</head>
<body>
	<div id="wrap">
			<div></div><div></div><div></div>
	</div>
</body>
</html>