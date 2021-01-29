<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/recipe/recipeInsert.np" enctype="multipart/form-data">
<input type="text" name="title">
<br>
<input type="file" name="main_img">
    <br>
    <input type="file" name="sub_img">
    <br>
    <input type="file" name="sub_img">
    <br>
    <input type="file" name="sub_img">
    <br>
    <input type="submit" value="등록">
<input type="hidden" name="user_id" value="ahn">
</form>
</body>
</html>