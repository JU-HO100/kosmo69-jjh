<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <button type="button" class="btn btn-outline-dark" value="한식" onclick="javascript:category('한식')">한식</button>
    <button type="button" class="btn btn-outline-dark" value="중식" onclick="javascript:category('중식')">중식</button>
    <button type="button" class="btn btn-outline-dark" value="일식" onclick="javascript:category('일식')">일식</button>
    <button type="button" class="btn btn-outline-dark" value="양식" onclick="javascript:category('양식')">양식</button>
    <button type="button" class="btn btn-outline-danger" style="float: right; width: 200px;" onclick="javacript:goRecipe()">레시피 등록하기</button>
    <button type="button" class="btn btn-outline-info" style="float: right; width: 200px;" onclick="javascript:goPopRecipe()">인기 레시피 보기</button>
