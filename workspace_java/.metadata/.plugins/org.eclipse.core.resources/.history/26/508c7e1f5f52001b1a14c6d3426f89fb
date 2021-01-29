<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript">
function check() {
	 var getCheck= RegExp(/^[a-zA-Z0-9]{4,12}$/);
	//이름 공백 확인
	 if($("#M_NAME").val() == ""){
	      alert("이름 입력바람");
	      $("#M_NAME").focus();
	      return false;
	    }
	//아이디 공백 확인
    if($("#M_ID").val() == ""){
      alert("아이디 입력바람");
      $("#M_ID").focus();
      return false;
    }
  //아이디 유효성검사
  if(!getCheck.test($("#M_ID").val())){
	  alert("형식에 맞게 입력해주세요");
	  $("#M_ID").val("");
	  $("#M_ID").focus();
	  return false; 
	  }

    //아이디랑 비밀번호랑 같은지
    if ($("#M_ID").val()==($("#M_PW").val())) {
    alert("비밀번호가 ID와 똑같습니다. 다시 작성해주세요!");
    $("#M_ID").val("");
    $("#M_PW").focus();
    return false;
  }

    //비밀번호 똑같은지
    if($("#M_PW").val() != ($("#M_PWCHECK").val())){ 
    alert("비밀번호가 다릅니다.");
    $("#M_PW").val("");
    $("#M_PWCHECK").val("");
    $("#M_PW").focus();
    return false;
   }
    
    //비밀번호
    if(!getCheck.test($("#M_PW").val())) {
    alert("형식에 맞춰서 PW를 입력해줘용");
    $("#M_PW").val("");
    $("#M_PW").focus();
    return false;
    }
    
  //비밀번호 공백 확인
    if($("#M_PW").val() == ""){
      alert("비밀번호를 입력해주세요");
      $("#M_PW").focus();
      return false;
    }
	
  //이메일 공백 확인
    if($("#M_MAIL").val() == ""){
      alert("이메일을 입력해주세요");
      $("#M_MAIL").focus();
      return false;
    }
  
    //전화번호 공백 확인
    if($("#M_HP").val() == ""){
      alert("전화번호를 입력해주세요");
      $("#M_HP").focus();
      return false;
    }
  //생년월일 공백 확인
    if($("#M_BIRTH").val() == ""){
      alert("생년월일을 입력해주세요");
      $("#M_BIRTH").focus();
      return false;
    }
  	
	alert("회원가입 성공!");
}
</script>
</head>
<body>
<table align="center" style="width: 70% ; height: 100%;">
	<tr>
		<td>
			<%@ include file="./loginHeader.jsp"%>
		</td>
	</tr>
	<tr>
		<td>
			<%@ include file="./jmContent.jsp" %>
		</td>	
	</tr>
	<tr>
		<td>
			<%@ include file="./footer.jsp" %>
		</td>
	</tr>	
</table>
</body>
</html>