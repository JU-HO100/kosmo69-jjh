<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.util.Map, java.util.List" %>
<%@ page import="java.util.ArrayList, java.util.HashMap" %>
<!-- application/hwp, application/excel 등 웹에서 볼수 있는 것들도 브라우저가 해석을 해준다. -->
<%
	Gson g = new Gson();
	String imsi = g.toJson(주소번지:List<Map<String,Object>>);//주소번지에서 가져온 List를 json형식으로 바꿔서 imsi에 담았다.
	out.print(imsi);

%>
<script>
	var result = JSON.stringify(imsi);//위에 스크립틀릿 안의 imsi를 result변수 안에 JSON 문자열로 변환해서 담는다 - stringify - Object
	var array = JSON.parse(result);//JSON 문자열의 구문을 분석하고, 그 결과에서 JavaScript 값이나 객체를 생성해서 array에 담았다.
	var temp ='';//결과를 담을 변수 선언
	for(var v=0;v<array.length;v++){//
		temp+="<b>"+array[v].empno+"</b>";//<b> 굵은 글씨
		temp+="<td>"+array[v].ename+"</td>";//테이블 영역일시 td태그 안에 넣기
		
	}
	$("d_msg").html(temp);//이 결과가 웹상에서 표현이 된다. - 테이블<td> 혹은 굵은 글씨<b>
</script>
<div id="d_msg"></div>


