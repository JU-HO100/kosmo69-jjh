<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구글 맵</title>
<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
<!-- <script type="text/javascript"src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBRe0llytjxGZ9jki5PwDfjiZdM0PL7_no&callback=initMap&libraries=&v=weekly"defer></script>
</head>
<body>
	<!-- services 라이브러리 불러오기 -->
	<script type="text/javascript">
	
	var map;/* 객체도 var이다. 예)var myCar = new sonata(); */
	var marker;
//		var imsi='';
	function initMap() {
		var infowindow = new google.maps.InfoWindow();
		map = new google.maps.Map(document.getElementById("map"), {//Map 브라우저에서 제공하는 객체
			center : { lat : 37.478828,lng : 126.878616 },
			zoom : 8,
		});
		marker = new google.maps.Marker({
			position : new google.maps.LatLng(37.478828, 126.878616),
			map : map,
			title : "수업 장소"
		});
		infowindow.open(map, marker);
	}
</script>
<div id="map"></div>
</body>
</html>