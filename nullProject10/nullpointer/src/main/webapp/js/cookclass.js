function reload(){
	location.href="/cookclass/cookingClassList.jsp";
}
function check() {
		//제목 공백 확인
	    if($("#c_cook").val() == ""){
	      alert("제목을 입력해주세요.");
	      $("#c_cook").focus();
	      return false;
	    }
		
	  //재료 공백 확인
	    if($("#c_ingredients").val() == ""){
	      alert("재료를 입력해주세요");
	      $("#c_ingredients").focus();
	      return false;
	    }
	  
	  //실습주소 공백 확인
	    if($("#c_zip").val() == ""){
	      alert("실습주소를 입력해주세요");
	      $("#c_zip").focus();
	      return false;
	    }
	    //상세주소 공백 확인
	    if($("#c_zipdetail").val() == ""){
	      alert("상세주소를 입력해주세요");
	      $("#c_zipdetail").focus();
	      return false;
	    }
	  
	  //날짜 공백 확인
	    if($("#c_date").val() == ""){
	      alert("날짜를 입력해주세요");
	      $("#c_date").focus();
	      return false;
	    }
	  
	  //수강 최대 인원 공백 확인
	    if($("#c_ingredients").val() == ""){
	      alert("수강 최대인원을 입력해주세요");
	      $("#c_ingredients").focus();
	      return false;
	    }
	 cookclassRegister.submit();
}
function checkUpdate() {
		//제목 공백 확인
	    if($("#c_cook").val() == ""){
	      alert("제목을 입력해주세요.");
	      $("#c_cook").focus();
	      return false;
	    }
		
	  //준비물 공백 확인
	    if($("#c_ingredients").val() == ""){
	      alert("재료를 입력해주세요");
	      $("#c_ingredients").focus();
	      return false;
	    }
	  
	  //실습주소 공백 확인
	    if($("#c_zip").val() == ""){
	      alert("실습주소를 입력해주세요");
	      $("#c_zip").focus();
	      return false;
	    }
	    
	    //상세주소 공백 확인
	    if($("#c_zipdetail").val() == ""){
	      alert("상세주소를 입력해주세요");
	      $("#c_zipdetail").focus();
	      return false;
	    }
	  
	  //날짜 공백 확인
	    if($("#c_date").val() == ""){
	      alert("날짜를 입력해주세요");
	      $("#c_date").focus();
	      return false;
	    }
	  
	  //수강 최대 인원 공백 확인
	    if($("#c_ingredients").val() == ""){
	      alert("수강 최대인원을 입력해주세요");
	      $("#c_ingredients").focus();
	      return false;
	    }
	 cookclassUpdate.submit();
}
function logout() {
	location.href="/member/logout.jsp";
}