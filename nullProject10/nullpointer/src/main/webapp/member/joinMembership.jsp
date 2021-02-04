<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/common/bootstrap_common.jsp"%>
<title>오늘 뭐 먹지?</title>
<script type="text/javascript" src="<%=path.toString() %>js/joinMembership.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
    /* =========================================== 다음 우편주소 검색 =========================================================== */
    function daumzip() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

                
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
            if(document.getElementById("m_zip").value != null){
               document.getElementById("m_zip").value = ''
            } 
            document.getElementById("m_zip").value = roadAddr;
                $.ajax({
                  url:location.href
               ,success:function(data){
//                   alert("m_addr:"+roadAddr);
                  $("m_zip").text(roadAddr);
                   }
               });
                   
            }
        }).open();
    }
    
    /* =========================================== 다음 우편주소 검색 =========================================================== */
</script>
</head>
<body>
<table align="center" style="width: 70% ; height: 100%;">
   <tr>
      <td>
         <%@ include file="/loginHeader.jsp"%>
      </td>
   </tr>
   <tr>
      <td>
         <%@ include file="/member/jmContent.jsp" %>
      </td>   
   </tr>
   <tr>
      <td>
         <%@ include file="/footer.jsp" %>
      </td>
   </tr>   
</table>
</body>
</html>
