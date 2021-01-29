<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구글차트API</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	var Year;
	var Sales;
	var Expenses;
		
function drawChart() {
	Year = session.getAttribute('Year');
	Sales = session.getAttribute('Sales');
	Expenses = session.getAttribute('Expenses');
	var data = google.visualization.arrayToDataTable([
		 ['Year', 'Sales', 'Expenses'],
		 [Year,  Sales, Expenses],
		 [Year,  Sales, Expenses],
		 [Year,  Sales, Expenses],
		 [Year,Salesc2, Expenses]
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