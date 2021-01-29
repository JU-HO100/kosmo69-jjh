<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 먹지?</title>
<%@ include file="/common/bootstrap_common.jsp"%>
<script>
<%! int  g_i = 1; %>
//Get the button
var mybutton = document.getElementById("myBtn");

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
// 대표이미지 파일 바로 보여주는 스크립트
        $(function() {
            $("#mainFile").on('change', function(){
                
                readURL(this);
            });
        });
        
        function readURL(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();
 
            reader.onload = function (e) {
                    $('#mainImage').attr('src', e.target.result);
                }
              reader.readAsDataURL(input.files[0]);
            }
        }
// 조리법 이미지 파일 바로 보여주는 스크립트
		
        $(function() {
            $("#file").on('change', function(){
                
                readURL2(this);
            });
        });
        
        function readURL2(input) {
            if (input.files && input.files[0]) {
            var reader2 = new FileReader();
 
            reader2.onload = function (e) {
                    $('#image').attr('src', e.target.result);
                }
              reader2.readAsDataURL(input.files[0]);
            }
        }

//테이블 계속 추가하는 스크립트
$(function() {
	var num=0;
	$("#add").on("click", function add() {
		num++;
		$("#list").append(
				"<table>"
		+	"							<tr>"
		+	"								<td>"
		+	"								조리법"+num+"  <textarea onkeyup='adjustHeight();'style='overflow: hidden;width:100%' placeholder='해당 순서의 조리법을 작성해주세요.'></textarea>"
		+	"								</td>"
		+	"							</tr>"
		+	"							<tr>"
		+	"								<td>"
		+	"									조리법"+num+" 사진"
		+  "								</td>"
		+  "							</tr>"
		+	"							<tr>"
		+	"								<td>"
		+  "									<input type='file' id='file' name='file' ><img id='image' alt='이미지를 선택해주세요.' width='150px' height='100px' >"
		+	"								</td>"
		+	"							</tr>"
		+  "	</table>");
	});
});

function ingredient() {
    var left = Math.ceil((window.screen.width - 700)/2);
    var top = Math.ceil((window.screen.height - 700)/2);
	var url="./registerIngredient.jsp";
	var name="재료등록";
	var option = "width=700, height = 700, top="+top+", left="+left+", location=no"
	window.open(url, name, option);
}


</script>
<style>
#myBtn {
  position: fixed;
  bottom: 45px;
  right: 45px;
  z-index: 99;
  font-size: 18px;
  border: 1px solid black;
  outline: none;
  background-color: white;
  color: black;
  cursor: pointer;
  padding: 15px;
  border-radius: 8px;
}
</style>
</head>
<body>
	<table align="center" style="width: 70% ; height: 100%;">
			<!-- Header -->
		<tr>
			<td style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/header.jsp"%>
			</td>
		</tr>
			<!-- END Header -->
			
			<!-- NavBar -->
		<tr>
			<td style="width: 100%;">
				<%@ include file="/navbar.jsp" %>
			</td>
		</tr>
			<!-- END NavBar -->
			<!-- Content -->
		<tr>
			<td style="padding-top: 5%">
				<%@include file="/registerRecipeContent.jsp" %>
			</td>
		</tr>
			<!-- End Content -->	
			<!-- Footer -->
		<tr>
			<td style="padding-top: 8%">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
	</table>
	<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
</body>
</html>