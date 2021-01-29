<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="web.mvc.*" %>
<%
   int size = 0;
   //SELECT empno, sal, NVL(comm, 0) as "comm" FROM emp
   EmpDao dDao = new EmpDao();
   List<Map<String, Object>> empList = dDao.getEmpList(null);
   if (empList != null) {
      size = empList.size();
   }
%>
<%
   //emp : 사원번호, 급여, 인센티브
%>
<!DOCTYPE html>
  <html>
  <head>
     <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
       $.ajax({
          url:'./jsonEmpList.jsp'
          ,dataType:'json'
          ,success:function (data) {
             var result = JSON.stringify(data);
             alert(result);
             var docArr = JSON.parse(result);
             alert(docArr);
             for(var i =0; i<docArr.length; i++) {
                var v_empno=docArr[i].EMPNO;
             }
          }
       });
        var data = google.visualization.arrayToDataTable([
          ['EMPNO', 'SAL', 'COMM']
<%
          for(int i=0; i<size; i++){  
             Map<String, Object> rmap = empList.get(i);
%>
             ,['<%=rmap.get("EMPNO").toString()%>', <%=rmap.get("SAL").toString()%>, <%=rmap.get("COMM").toString()%>]
<%
          }
%>
        ]);

        var options = {
          title: 'Company Performance',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="curve_chart" style="width: 900px; height: 500px"></div>
  </body>
</html>