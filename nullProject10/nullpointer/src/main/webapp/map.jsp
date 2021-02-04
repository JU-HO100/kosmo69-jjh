<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 맵</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=15f5287d753e527b86e1f231f7128313&libraries=services"></script>
</head>
<body>
<%
// 	String zip = (String)session.getAttribute("c_zip");
%>
<div id="map" style="width:100%;height:950px;"></div>
	<!-- services 라이브러리 불러오기 -->
<script type="text/javascript">
// 	alert("호출");
<%-- 		var zip = <%=zip%>; --%>
// 		var zip = "";
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(37.554577363425814, 126.98810984875148), // 지도의 중심좌표 -
		        level: 3 // 지도의 확대 레벨
		    };  
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 장소 검색 객체를 생성합니다
		var ps = new kakao.maps.services.Places(); 

		
		// 주소로 좌표를 검색합니다
<%-- 		geocoder.addressSearch("<%=zip%>", function(result, status) { --%>
		geocoder.addressSearch('서울 송파구 올림픽로 300', function(result, status) {
// 		geocoder.addressSearch('서울특별시 금천구 가산디지털2로 123', function(result, status) {
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {

		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });	

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">한번배워서 맛있게 [간장찜닭] 수업장소</div>'
		        });
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
		// 지도에 마커를 표시하는 함수입니다
		function displayMarker(place) {
		    
		    // 마커를 생성하고 지도에 표시합니다
		    var marker = new kakao.maps.Marker({
		        map: map,
		        position: new kakao.maps.LatLng(place.y, place.x) 
		    });
		    
		 // 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
			var infowindow = new kakao.maps.InfoWindow({zIndex:1});

		    // 마커에 클릭이벤트를 등록합니다
		    kakao.maps.event.addListener(marker, 'click', function() {
		        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
		        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
		        infowindow.open(map, marker);
		    });
		}
	</script>
</body>
</html>