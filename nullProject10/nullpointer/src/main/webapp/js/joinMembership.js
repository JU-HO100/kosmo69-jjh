function check(){
	 var getCheck= RegExp(/^[a-zA-Z0-9]{4,20}$/);
	 var pattern = /\s/g;
	 var m_name =$("#m_name").val();
	 var m_id =$("#m_id").val();
	 var m_pw =$("#m_pw").val();
	 var m_mail =$("#m_mail").val();
	 var m_nick =$("#m_nick").val();
	 var m_hp =$("#m_hp").val();
	 
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

	//이름 띄어쓰기
	  	if(m_name.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#m_name").val("");
	  	  $("#m_name").focus();
	  	  return false; 
	  	  }
	//아이디 띄어쓰기
	  	if(m_id.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#m_id").val("");
	  	  $("#m_id").focus();
	  	  return false; 
	  	  }
	//비밀번호 띄어쓰기
	  	if(m_pw.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#m_pw").val("");
	  	  $("#m_pw").focus();
	  	  return false; 
	  	  }
	//이메일 띄어쓰기
	  	if(m_mail.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#m_mail").val("");
	  	  $("#m_mail").focus();
	  	  return false; 
	  	  }
	//닉네임 띄어쓰기
	  	if(m_nick.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#m_nick").val("");
	  	  $("#m_nick").focus();
	  	  return false; 
	  	  }
	//전화번호 띄어쓰기
	  	if(m_hp.match(pattern)){
	  	  alert("띄어쓰기 없이 입력해주세요");
	  	  $("#m_hp").val("");
	  	  $("#m_hp").focus();
	  	  return false; 
	  	  }
	//이름 공백 확인
	 if(m_name == ""){
	      alert("이름 입력바람");
	      $("#m_name").focus();
	      return false;
	    }
	   //============================byte================================
	 //아이디 byte 확인
	 if(m_id.byteLength() <4 || m_id.byteLength() >20){
	      alert("아이디를4byte~20byte사이 사이즈로 작성해주세여");
	      $("#m_id").focus();
	      return false;
	    }
	 //비밀번호 byte 확인
	 if(m_pw.byteLength() <4 || m_pw.byteLength() >12){
	      alert("비밀번호를 4byte~12byte사이 사이즈로 작성해주세여");
	      $("#m_pw").focus();
	      return false;
	    }
	   //닉네임 byte 확인
	 if(m_nick.byteLength() <4 || m_nick.byteLength() >12){
	      alert("닉네임을 4byte~12byte사이 사이즈로 작성해주세여");
	      $("#m_nick").focus();
	      return false;
	    }
	//============================byte================================ 
	   
	//아이디 공백 확인
	if($("#m_id").val() == ""){
      alert("아이디 입력바람");
      $("#m_id").focus();
      return false;
    }
  //아이디 유효성검사
  	if(!getCheck.test($("#m_id").val())){
	  alert("형식에 맞게 입력해주세요");
	  $("#m_id").val("");
	  $("#m_id").focus();
	  return false; 
	  }

    //아이디랑 비밀번호랑 같은지
    if ($("#m_id").val()==($("#m_pw").val())) {
    alert("비밀번호가 ID와 똑같습니다. 다시 작성해주세요!");
    $("#m_id").val("");
    $("#m_pw").focus();
    return false;
  }

    //비밀번호 똑같은지
    if($("#m_pw").val() != ($("#m_pwcheck").val())){ 
    alert("비밀번호가 다릅니다.");
    $("#m_pw").val("");
    $("#m_pwcheck").val("");
    $("#m_pw").focus();
    return false;
   }
    
    //비밀번호
    if(!getCheck.test($("#m_pw").val())) {
    alert("형식에 맞춰서 PW를 입력해주세요");
    $("#m_pw").val("");
    $("#m_pw").focus();
    return false;
    }
    
  //비밀번호 공백 확인
    if($("#m_pw").val() == ""){
      alert("비밀번호를 입력해주세요");
      $("#m_pw").focus();
      return false;
    }
	
  //이메일 공백 확인
    if($("#m_mail").val() == ""){
      alert("이메일을 입력해주세요");
      $("#m_mail").focus();
      return false;
    }
  //주소 공백 확인
    if($("#m_zip").val() == ""){
      alert("주소를 입력해주세요");
      $("#m_zip").focus();
      return false;
    }
  
    //전화번호 공백 확인
    if($("#m_hp").val() == ""){
      alert("전화번호를 입력해주세요");
      $("#m_hp").focus();
      return false;
    }
  	//생년월일 공백 확인
    if($("#m_birth").val() == ""){
      alert("생년월일을 입력해주세요");
      $("#m_birth").focus();
      return false;
    }
	//닉네임 공백 확인
    if($("#m_nick").val() == ""){
      alert("닉네임을 입력해주세요");
      $("#m_nick").focus();
      return false;
    }
  	alert("회원가입 완료");
  	loginForm.submit();
}
 	function idCheckRegi() {
 		var m_id = $('#m_id').val();
 		var url = "/member/idCheckRegi.np?m_id="+m_id;
 		var left = Math.ceil((window.screen.width - 700)/2);
 	    var top = Math.ceil((window.screen.height - 700)/2);
 		var name = "아이디 중복 체크";
        var option = "width = 300, height = 100, top="+top+", left="+left+", location = no"
  		window.open(url, name, option);
	}
 	function nickCheckRegi() {
 		var m_nick = $('#m_nick').val();
 		var url = "/member/nickCheckRegi.np?m_nick="+m_nick;
 		var left = Math.ceil((window.screen.width - 700)/2);
 	    var top = Math.ceil((window.screen.height - 700)/2);
 		var name = "닉네임 중복 체크";
        var option = "width = 300, height = 100, top="+top+", left="+left+", location = no"
  		window.open(url, name, option);
	}
	



