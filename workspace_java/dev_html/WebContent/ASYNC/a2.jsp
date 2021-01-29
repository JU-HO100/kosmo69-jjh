<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
<script type="text/javascript">
   var v_name="영업부";
   function refresh(){
	   documet.write("<%=v_name%>"+"님<b>안녕<b>하세요");
	   documet.write("<br>");
	   documet.write("");
	   documet.write("");
	   documet.write("");
   }
</script>
</head>
<body>
<script type="text/javascript">
   var v_gender="남자";
      document.write("<table width='350px' border='1' borderColor='green'>");
      document.write("<tr>");
      document.write("<td>");
      document.write(v_name);/* 10번의 변수 */
      document.write("</td>");
      document.write("<td>");
      document.write(v_gender);/* 11번의 변수 */
      document.write("</td>");
      document.write("</tr>");
      document.write("</table>");

      </script>

</body>
</html>