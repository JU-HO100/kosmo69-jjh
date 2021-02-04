function cookingClassCheckContent(){
    $.ajax({
      type : "GET",
      url : "/member/cookingClassCheckContent.jsp",
      dataType : "text",
      error : function() {
        alert('통신실패!!');
      },
      success : function(data) {
        $('#tb_ajax').html(data);
      }

    });
  }
function memberOutContent(){
    $.ajax({
      type : "GET",
      url : "/member/memberOutContent.jsp",
      dataType : "text",
      error : function() {
        alert('통신실패!!');
      },
      success : function(data) {
        $('#tb_ajax').html(data);
      }

    });
  }
function myinfo(){
    $.ajax({
      type : "GET",
      url : "/member/myInfo.jsp",
      dataType : "text",
      error : function() {
        alert('통신실패!!');
      },
      success : function(data) {
        $('#tb_ajax').html(data);
      }

    });
  }

function logout() {
	location.href="logout.jsp";
}


function updateCheck(){
	var getCheck= RegExp(/^[a-zA-Z0-9]{4,12}$/);
	 var pattern = /\s/g;
	 var m_id =$("#m_id").val();
	 var m_pw =$("#m_pw").val();
	 var c_pw =$("#c_pw").val();
	 var c_mail =$("#c_mail").val();
	 var c_zip =$("#c_zip").val();
	 var c_nick =$("#c_nick").val();
	 var c_hp =$("#c_hp").val();
	 
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

		//비밀번호 띄어쓰기
	  	if(c_pw.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#c_pw").val("");
	  	  $("#c_pw").focus();
	  	  return false; 
	  	  }
	//이메일 띄어쓰기
	  	if(c_mail.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#c_mail").val("");
	  	  $("#c_mail").focus();
	  	  return false; 
	  	  }
	//닉네임 띄어쓰기
	  	if(c_nick.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#c_nick").val("");
	  	  $("#c_nick").focus();
	  	  return false; 
	  	  }
	//전화번호 띄어쓰기
	  	if(c_hp.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#c_hp").val("");
	  	  $("#c_hp").focus();
	  	  return false; 
	  	  }
	//닉네임 byte 확인
	 if(c_nick.byteLength() <4 || c_nick.byteLength() >12){
	      alert("닉네임을 4byte~12byte사이 사이즈로 작성해주세요");
	      $("#c_nick").focus();
	      return false;
	    }
	    //현재비밀번호 공백 확인
    if($("#m_pw").val() == ""){
      alert("현재 비밀번호를 입력해주세요");
      $("#m_pw").focus();
      return false;
    }
    //바꿀 비밀번호 공백 확인
    if($("#c_pw").val() == ""){
      alert("바꿀 비밀번호를 입력해주세요");
      $("#c_pw").focus();
      return false;
    }
//이메일 공백 확인
    if($("#c_mail").val() == ""){
      alert("이메일을 입력해주세요");
      $("#c_mail").focus();
      return false;
    }
  //주소 공백 확인
    if($("#c_zip").val() == ""){
      alert("주소를 입력해주세요");
      $("#c_zip").focus();
      return false;
    }
  
    //전화번호 공백 확인
    if($("#c_hp").val() == ""){
      alert("전화번호를 입력해주세요");
      $("#c_hp").focus();
      return false;
    }
	//닉네임 공백 확인
    if($("#c_nick").val() == ""){
      alert("닉네임을 입력해주세요");
      $("#c_nick").focus();
      return false;
    }
  	updateForm.submit();
}


 	function nickCheckRegi() {
 		var c_nick = $('#c_nick').val();
 		var url = "/member/nickCheckRegi.np?m_nick="+c_nick;
 		var left = Math.ceil((window.screen.width - 700)/2);
 	    var top = Math.ceil((window.screen.height - 700)/2);
 		var name = "닉네임 중복 체크";
        var option = "width = 300, height = 100, top="+top+", left="+left+", location = no"
  		window.open(url, name, option);
	}
	
	
	
function reload(){
	location.href="/member/mypage.jsp";
 }
 
 

  
  
  
function joinChefCheck() {
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
		var writting =$("#writting").val();
		 //자기소개 양식서 byte 확인
		 if(writting.byteLength() <14){
		      alert("자기소개를 14byte이상으로 작성해주세여");
		      $("#writting").focus();
		      return false;
		    }
		 //닉네임 공백 확인
    if($("#main_food").val() == ""){
      alert("주력요리를 선택해주세요");
      $("#main_food").focus();
      return false;
    }
	    joinchef.submit();
	}
	
//신청 현황 보기 클릭 시 팝업창 뜨게 하는 스크립트
function cookingClassMemberCheck() {
    var left = Math.ceil((window.screen.width - 700)/2);
    var top = Math.ceil((window.screen.height - 700)/2);
	var url="./cookingClassMemberCheck.jsp";
	var name="재료등록";
	var option = "width=700, height = 700, top="+top+", left="+left+", location=no"
	window.open(url, name, option);
}