<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>닭봉간장조림~ 십년째 만들어 먹는 양념 공유해요!</title>
</head>
<body>
	<table align="center" style="width: 70%; height: 100%;">
		<!-- Header -->
		<tr>
			<td colspan="2"
				style="width: 100%; padding-top: 2%; padding-bottom: 2%;"><%@ include
					file="./header.jsp"%></td>
		</tr>
		<!-- END Header -->

		<!-- NavBar -->
		<tr>
			<td colspan="2" style="width: 100%;"><%@ include
					file="./navbar.jsp"%></td>
		</tr>
		<!-- END NavBar -->
	</table>
	<div class="card-body text-center">
		<div>
			<img src="images/portfolio/cabin.png" alt="...">
				<br> 
				<a href="#">
					<img width="3%" src="https://recipe1.ezmember.co.kr/cache/rpf/2020/06/25/e95dbdcf4122fe67c45511b5c4f6f4c71.jpg">
					요리하는 라라
				</a>
				<br> 
				<span>(18)</span> <span>조회수 3.3만</span>
		</div>
		<div>
			<h3>닭봉간장조림~ 십년째 만들어 먹는 양념 공유해요!</h3>
			<div id="recipeIntro">
				초간단 조리과정과 집에 있는 착한 양념에 비해
				<br>
				미친 비주얼을 자랑하는 닭봉조림~ 언제 어디에서 누구에게 해줘도 인기만점 레시피예요
			</div>
			<br>
			<div>
				<span>2인분</span>
				<span>60분 이내</span>
				<span>아무나</span>
			</div>
			<div class="btn_list">
				<a href="javascript:void(0)" onclick="copyBbsUrl()">
					<img alt="" src="https://recipe1.ezmember.co.kr/img/mobile/icon_url_copy.gif">
				</a>
				<a href="javascript:void(0)" onclick="snsWriter('kakaoStory')">
					<img alt="" src="https://recipe1.ezmember.co.kr/img/mobile/icon_sns_ks.png">
				</a>
				<a href="javascript:void(0)" onclick="snsWriter('facebook')">
					<img alt="" src="https://recipe1.ezmember.co.kr/img/mobile/icon_sns_f.png">
				</a>
				<a href="javascript:void(0)" onclick="snsWriter('twitter')">
					<img alt="" src="https://recipe1.ezmember.co.kr/img/mobile/icon_sns_t.png">
				</a>
			</div>
			<div>
				<div>
					<b>재료</b>
					<span>Ingredients</span>
						<button>계량법 안내</button>
				</div>
				<div>
					<ul>
						<b>[재료]</b>
						<!--######### 재료 추가할때 시작######## -->
						<a href="" onclick="">
							<li>
							닭봉
								<span>20개</span>
							</li>
						</a>
						<!--######### 재료 추가할때 끝######## -->
					</ul>
					<ul>
						<b>[양념(밥숟가락)]</b>
						<!--######### 양념 추가할때 시작######## -->
						<a href="" onclick="">
							<li>간장<span>5숟가락</span></li>
						</a>
						<!--######### 양념 추가할때 끝######## -->
					</ul>
					
				</div>
			</div>
			<!-- 재료순서 -->
			<div class="blank_bottom"></div>
			<div class="view_step">
				<div class="best_tit">
					<b>조리순서</b>
					<span>Steps</span>
				</div>
				<!-- step 시작 ##########################-->
				<div class="stepDiv1" class="view_step_cont media step1">
					<!-- step 설명 -->
					<div id="stepdescr1" class="media-body"><b>step1</b><br>닭봉 2팩, 갯수로는 20개를 준비해요
					</div>
					<div id="stepimg1" class="media-right">
					<!-- step 이미지 -->
						<img src="https://recipe1.ezmember.co.kr/cache/recipe/2020/08/28/ab1e0aabcb58de52cdba5a5cb4910f661.jpg">
					</div>
				</div>
				<!-- step 끝 ##########################-->
								<!-- step 시작 ##########################-->
				<div class="stepDiv1" class="view_step_cont media step1">
					<!-- step 설명 -->
					<div id="stepdescr1" class="media-body"><b>step1</b><br>닭봉 2팩, 갯수로는 20개를 준비해요
					</div>
					<div id="stepimg1" class="media-right">
					<!-- step 이미지 -->
						<img src="https://recipe1.ezmember.co.kr/cache/recipe/2020/08/28/ab1e0aabcb58de52cdba5a5cb4910f661.jpg">
					</div>
				</div>
				<!-- step 끝 ##########################-->
								<!-- step 시작 ##########################-->
				<div class="stepDiv1" class="view_step_cont media step1">
					<!-- step 설명 -->
					<div id="stepdescr1" class="media-body"><b>step1</b><br>닭봉 2팩, 갯수로는 20개를 준비해요
					</div>
					<div id="stepimg1" class="media-right">
					<!-- step 이미지 -->
						<img src="https://recipe1.ezmember.co.kr/cache/recipe/2020/08/28/ab1e0aabcb58de52cdba5a5cb4910f661.jpg">
					</div>
				</div>
				<!-- step 끝 ##########################-->
			</div>
		</div>
	</div>
	<div class="container">
    <div class="col-xs-12" style="margin:15px auto;">
        <label style="font-size:20px;"><span class="glyphicon glyphicon-list-alt"></span>게시글 상세</label>
    </div>
 
    <div class="col-xs-12">
        <form action="/insertProc" method="post">
            <dl class="dl-horizontal">
              <dt>제목</dt>
              <dd>${detail.subject}</dd>
              
              <dt>작성자</dt>
              <dd>${detail.writer}</dd>
              
              <dt>작성날짜</dt>
              <dd>
                  <fmt:formatDate value="${detail.reg_date}" pattern="yyyy.MM.dd HH:mm:ss"/>
              </dd>
              
              <dt>첨부파일</dt>
              <dd><a href="/fileDown/${files.bno}">${files.fileOriName}</a></dd>
              
              <dt>내용</dt>
              <dd>${detail.content}</dd>
            </dl>
        </form>
        <div class="btn-group btn-group-sm" role="group" style="float:right;">
          <button type="button" class="btn btn-default" onclick="location.href='/delete/${detail.bno}'">삭제</button>
          <button type="button" class="btn btn-default" onclick="location.href='/update/${detail.bno}'">수정</button>
          <button type="button" class="btn btn-default" onclick="location.href='/list'"> 목록 </button>
        </div>
    </div>
    
    <!--                     추가                         -->
    <!--  댓글  -->
    <div class="container">
        <label for="content">comment</label>
        <form name="commentInsertForm">
            <div class="input-group">
               <input type="hidden" name="bno" value="${detail.bno}"/>
               <input type="text" class="form-control" id="content" name="content" placeholder="내용을 입력하세요.">
               <span class="input-group-btn">
                    <button class="btn btn-default" type="button" name="commentInsertBtn">등록</button>
               </span>
              </div>
        </form>
    </div>
    
    <div class="container">
        <div class="commentList"></div>
    </div>
</div>


출처: https://private.tistory.com/65 [공부해서 남 주자]
</body>
</html>