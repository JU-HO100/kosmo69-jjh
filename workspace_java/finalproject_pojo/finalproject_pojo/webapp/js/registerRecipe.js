//Get the button
var mybutton = document.getElementById("myBtn");

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
// 대표이미지 파일 바로 보여주는 스크립트
        $(function() {
            $('#mainFile').on('change', function(){
                readURL(this);
            });
        });
        
        function readURL(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();
 
            reader.onload = function (e) {
                    $('#main_img').attr('src', e.target.result);
                }
              reader.readAsDataURL(input.files[0]);
            }
        }
//=============*********************=======================
// 조리법 이미지 파일 바로 보여주는 스크립트
		
		$(function addImage(g_i) {
		 	for(var y=0;y<g_i;y++){
		 	if(x==g_i){
		     $('"#file'+g_i+'"').on('change', function(){
		         readURL2(this);
		         });
		         };
		     }
		 });
     
     function readURL2(input) {
         if (input.files && input.files[0]) {
         var reader2 = new FileReader();

         reader2.onload = function (e) {
                 $('#sub_img"+g_i+"').attr('src', e.target.result);
             }
           reader2.readAsDataURL(input.files[0]);
         }
     }
//=============*********************=======================

function ingredient() {
    var left = Math.ceil((window.screen.width - 700)/2);
    var top = Math.ceil((window.screen.height - 700)/2);
	var url="./registerIngredient.jsp";
	var name="재료등록";
	var option = "width=700, height = 700, top="+top+", left="+left+", location=no"
	window.open(url, name, option);
}


function gosubmit() {
	/**
	 * 문자열의 바이트수 리턴
	 * @returns {Number}
	 */
	String.prototype.byteLength = function() {
	    var l= 0;
	     
	    for(var idx=0; idx < this.length; idx++) {
	        var c = escape(this.charAt(idx));
	         
	        if( c.length==1 ) l ++;
	        else if( c.indexOf("%u")!=-1 ) l += 2;
	        else if( c.indexOf("%")!=-1 ) l += c.length/3;
	    }
	     
	    return l;
	};

	//title byte 확인
	 if(title.byteLength() <4 ){
	      alert("제목을 4byte 이상 사이즈로 작성해주세요");
	      $("#title").focus();
	      return false;
	    }
	//본문 byte 확인
// 	 if(title.byteLength() <4 ){
// 	      alert("아이디를4byte 이상 사이즈로 작성해주세요");
// 	      $("#title").focus();
// 	      return false;
//	    }
	//재료량 byte 확인
// 	 if(title.byteLength() <4 ){
// 	      alert("아이디를4byte 이상 사이즈로 작성해주세요");
// 	      $("#title").focus();
// 	      return false;
//	    }
	//해시태그 byte 확인
// 	 if(title.byteLength() <4 ){
// 	      alert("아이디를4byte 이상 사이즈로 작성해주세요");
// 	      $("#title").focus();
// 	      return false;
//	    }
}