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
		border: 2px solid #6E6E6E
	}
	#wrap div{
		width:31.25%;
		height:500px;
		/* inline속성값 처럼 요소들이 한 줄로 보이고 block태그에 적용할 수 있는 속성들도 사용이 가능한 속성값임. */
		display:inline-block;/* default는 block요소(자체크기가 정해져있는) 이지만 인라인요소도 같이 사용 가능 */
		background:#00FFFF;
	
	}
	#wrap div:first-child{
		margin-right:37.5%;
		background: blue;
 }
 	#wrap div:first-child + div{
		background: red;
 }
</style>
	
</head>
<body>
	<div id="wrap">
		<div></div><div></div>
	</div>
</body>
</html>