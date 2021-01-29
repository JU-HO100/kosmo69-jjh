<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <form action=""  method="get">
<table style="width: 100%; margin-left: 25%">
	<tr>
		<td>
			  <div class="input-group mb-3" style="width: 50%">
			    <div class="input-group-prepend">
			      <span class="input-group-text">제목</span>
			    </div>
			    <input type="text" class="form-control" placeholder="어떤요리인지 알 수 있도록 작성해주세요." >
			  </div>
		</td>
	</tr>
	<tr>
		<td>
			  <div class="input-group mb-3" style="width: 50%">
			    <div class="input-group-prepend">
			      <span class="input-group-text">재료</span>
			    </div>
				  <input  type="button"  class="btn btn-outline-secondary"  id="" name=""  value="재료 등록하러 가기"  onclick="ingredient()">
			    </div>
		</td>
	</tr>
	<tr>
		<td>
			대표 이미지 선택:
			<input type='file' id="mainFile" name="mainFile" />
			<img id="mainImage" src="#" alt="대표 이미지를 선택해주세요." width="150" height="100" />
		</td>
	</tr>
	<tr>
		<td>
			<ol id="list">
			</ol>
			<input type="button"   class="btn btn-outline-secondary"  id="add"  value="조리법 추가">
		</td>
	</tr>
	<tr>
		<td>
			<button  style="margin-left: 45%" type="button" class="btn btn-outline-secondary"  onclick="gosubmit()">등록하기</button>
		</td>
	</tr>
</table>
</form>