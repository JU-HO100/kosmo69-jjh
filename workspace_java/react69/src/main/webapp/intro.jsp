<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>intro 페이지</title>
</head>
<body>

<div id="root"></div><!-- 블락요소를 추가하여 리액트에서 생성한 컨텐츠를 랜더링하는 위치 -->
<!-- 
MainPage.jsx파일추가 - 리액트 API를 사용한 코드 내장
바벨과 웹팩을 활용하여 표준 스크립트로 변환 처리
js/react/파일명.js

node_modules\.bin\webpack --watch -d 터미널에서 실행하면 표준스크립트로 전환하여 파일을 생성해줌.
하나의 돌립된 컴포넌트가 되어서 페이지에 재사용이 가능하다.

 -->

<script type="text/javascript" src="/js/react/main.bundle.js"></script>
</body>
</html>