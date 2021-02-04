<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <form action="/recipe/recipeInsert.np"  method="post"  name="recipeRegister" id="recipeRegister" enctype="multipart/form-data">
<table style="width: 100%; " align="center">
	<tr>
		<td align="center">
			  <div class="input-group mb-3" style="width: 60%">
			    <div class="input-group-prepend">
			      <span class="input-group-text">제목</span>
			    </div>
			    <input type="text" id="foodname" name="foodname" class="form-control" placeholder="어떤요리인지 알 수 있도록 작성해주세요." >
				 <select class="easyui-combobox"  style="width:13%; height: 100%" id="category" name="category">
					<option value="한식">한식</option>
				    <option value="중식">중식</option>
				    <option value="일식">일식</option>
				    <option value="양식">양식</option>
				</select>
				<select class="easyui-combobox" style="width:13%; height: 100%" id="foodgroup" name="foodgroup">
					<option value="찜">찜</option>
				    <option value="구이">구이</option>
				    <option value="찌개">찌개</option>
				    <option value="국">국</option>
				    <option value="조림">조림</option>
				    <option value="데침">데침</option>
				    <option value="튀김">튀김</option>
				    <option value="삶기">삶기</option>
				    <option value="반찬">반찬</option>
				    <option value="탕">탕</option>
				    <option value="볶음">볶음</option>
				    <option value="샐러드">샐러드</option>
				    <option value="디저트">디저트</option>
				</select>
			  </div>
		</td>
	</tr>
	<tr>
		<td align="center">
			  <div class="input-group mb-3" style="width: 60%">
			    <div class="input-group-prepend">
			      <span class="input-group-text">재료</span>
			   </div>
			     <input type="text" id="jaelyo" name="jaelyo" class="form-control" placeholder="재료 등록 버튼을 클릭해서 재료를 등록해주세요" >
				  <input  type="button"  class="btn btn-outline-secondary"   value="재료 등록"  onclick="ingredient()">
			    </div>
		</td>
	</tr>
	<tr>
		<td>
			<table align="center">
				<tr>
					<td style="padding-top: 5%; width: 100%" >
						<p style="font-family: 'Single Day', cursive; font-size: 22px;">대표 이미지 선택</p>
						<input type="file" id="mainFile" name="mainFile" />
						<img id="main_img" name="main_img" src="#" alt="대표 이미지를 선택해주세요." width="150" height="100" />
						<br><br>
					</td>
				</tr>
			</table>

		</td>
	</tr>
	
	<tr>
		<td style="padding-top: 5%">
			<p style="font-family: 'Single Day', cursive; font-size: 22px;">조리법 작성(조리법 추가 버튼을 눌러 작성해주세요)</p>
			<div id="g_main" style="width: 100%"></div>
			<input type="button"  style="text-align: center;" class="btn btn-outline-secondary"  onclick="add()"  value="조리법 추가">
		</td>
	</tr>
	<tr>
		<td style="padding-top: 4%">
			<p style="font-family: 'Single Day', cursive; font-size: 22px;">해시태그</p>
			<input class="easyui-tagbox"  value="해시태그" style="width:30%" id="hashtag" name="hashtag">
		</td>	
	</tr>
	<tr>
		<td>
			<br><br>
			<input type="reset"  class="btn btn-info"  value="다시작성">
			<button  type="button" class="btn btn-info"  onclick="gosubmit()">등록하기</button>
		</td>
	</tr>
</table>
</form>