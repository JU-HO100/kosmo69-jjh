<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
    <title>Child</title>
 
    <script type="text/javascript">
        function setParentText(){
             opener.document.getElementById("pInput").value = document.getElementById("cInput").value
        }
   </script>
 
</head>
<body>
    <br>
    <b><font size="5" color="gray">자식창</font></b>
    <br><br>
 
    <input type="text" id="cInput"> <input type="button" value="전달하기" onclick="setParentText()">
    <br><br>
    <input type="button" value="창닫기" onclick="window.close()">
</body>
</html>


출처: https://all-record.tistory.com/149 [세상의 모든 기록]