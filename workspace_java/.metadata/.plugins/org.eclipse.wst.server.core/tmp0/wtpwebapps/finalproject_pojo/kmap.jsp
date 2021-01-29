<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	String c_map = request.getParameter("c_map");
	System.out.print(c_map);
 	String c_detail = request.getParameter("c_detail");
 	System.out.print(c_detail);
// 	String c_map = "가산동 371-16 IT캐슬2차";
// 	String c_map = "가산디지털1로 137";
// 	String c_detail = "2층 kosmo 한국소프트웨어 인재개발원";
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카카오 맵</title>
<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=15f5287d753e527b86e1f231f7128313"></script> -->
</head>
<body>
<div id="map" style="width:100%;height:950px;"></div>
	<!-- services 라이브러리 불러오기 -->

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=15f5287d753e527b86e1f231f7128313&libraries=services"></script>
	<script type="text/javascript">
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(37.521655, 126.924241), // 지도의 중심좌표 -
		        level: 4, // 지도의 확대 레벨
		        mapTypeId : kakao.maps.MapTypeId.ROADMAP //지도 종류
		    };
		// 지도를 생성합니다    
		let map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 지도에 확대 축소 컨트롤을 생성한다
		let zoomControl = new kakao.maps.ZoomControl();
		// 지도의 우측에 확대 축소 컨트롤을 추가한다
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
		
		// 장소 검색 객체를 생성합니다
		let ps = new kakao.maps.services.Places(); 

		// 주소로 좌표를 검색합니다
<%-- 		geocoder.addressSearch("<%=c_map%>", function(result, status) { --%>
		geocoder.addressSearch("<%=c_map%>", function(result, status) {

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
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">"<%=c_detail%>"</div>'
		        });
		        infowindow.open(map, marker);
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		}); 

		
		// 키워드로 장소를 검색합니다
<%--  		ps.keywordSearch("<%=c_map%>", placesSearchCB);   --%>
// 		ps.keywordSearch('가산역', placesSearchCB); // 중심좌표가 다른 곳이여도 검색한곳으로 뜸

		// 키워드 검색 완료 시 호출되는 콜백함수 입니다
// 		function placesSearchCB (data, status, pagination) {
// 		    if (status === kakao.maps.services.Status.OK) {

// 		        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
// 		        // LatLngBounds 객체에 좌표를 추가합니다
// 		        var bounds = new kakao.maps.LatLngBounds();

// 		        for (var i=0; i<data.length; i++) {
// 		            displayMarker(data[i]);    
// 		            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
// 		        }       

// 		        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
// 		        map.setBounds(bounds);
// 		    } 
// 		}

		// 지도에 마커를 표시하는 함수입니다
// 		function displayMarker(place) {
		    
// 			// 마커를 생성하고 지도에 표시합니다
// 		    var marker = new kakao.maps.Marker({
// 		        map: map,
// // 		    	var iwContent = '<div style="padding:5px;">실습장소<br><a href="https://map.kakao.com/link/map/안녕!,37.554577363425814,126.98810984875148" style="color:blue" target="_blank">큰지도보기</a></div>',
<%--  		    	var iwContent = <%=c_map%>, --%> 
// 		        position: new kakao.maps.LatLng(place.y, place.x) 
// 		    });
		    
// 			// 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
// 			var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 		    // 마커에 클릭이벤트를 등록합니다
// 		    kakao.maps.event.addListener(marker, 'click', function() {
// 		        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
<%-- 		        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name+"<%=c_detail%>" + '</div>'); --%>
// 		        infowindow.open(map, marker);
// 		    });
// 		}
		
	</script>
	
</body>
</html>