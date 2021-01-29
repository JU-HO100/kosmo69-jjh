<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="UTF-8">
	<title>기온데이터 조회</title>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
     <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <script src="https://www.gstatic.com/charts/loader.js"></script>
    <style type="text/css">
		 * {
	 	margin: 0;
	 	padding: 0;
	 	font-family: 'Noto Sans KR', sans-serif;
	 }
	 </style>
	   <script type="text/javascript">
	
    // Load the Visualization API and the piechart package.
    google.charts.load('current', {'packages':['corechart']});
      
    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart);
      
    function drawChart() {
      var jsonData = $.ajax({
          url: "./getTempData.jsp",
          dataType: "json",
          async: false
          }).responseText;
          
      // Create our data table out of JSON data loaded from server.
      var data = new google.visualization.DataTable(jsonData);

      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
      chart.draw(data, {width: 400, height: 240});
    }
	
	$(function(){
		  $('#btn_clear').bind('click', function(e){
			  $('#dg_temp').datagrid({
				    url:'./getTempData.jsp'
			    	,columns:[[
				        {field:'W_DATE',title:'날짜',width:100, align:'center'},
				        {field:'LOCATION',title:'지점',width:100, align:'center'},
				        {field:'AVGTEMP',title:'평균기온',width:100, align:'center'},
				        {field:'MAXTEMP',title:'최고기온',width:100, align:'center'},
				        {field:'MINTEMP',title:'최저기온',width:100, align:'center'}
				    ]]
				});
		  });
		});
    </script>
</head>
<body>
<script>
		$(document).ready(function (){
		$('#dg_temp').datagrid({
		    url:'./getTempData.jsp'
		    ,width: 1500
		    ,height: 800
		    ,columns:[[
		        {field:'W_DATE',title:'날짜',width:100, align:'center'},
		        {field:'LOCATION',title:'지점',width:100, align:'center'},
		        {field:'AVGTEMP',title:'평균기온',width:100, align:'center'},
		        {field:'MAXTEMP',title:'최고기온',width:100, align:'center'},
		        {field:'MINTEMP',title:'최저기온',width:100, align:'center'}
		    ]]
			,toolbar: '#toolbar'
		});
		
		$('#cb_gubun').combobox({
		  	valueField: 'label',
			textField: 'value',
			data: [{
					label: 'year',
					value: '연'
				},
				{
					label: 'years',
					value: '기간'
				},
				{
					label: 'month',
					value: '월'
				},{
					label: 'bungi',
					value: '분기'
				}]
			,width: 100
			,panelHeight:'auto'
			,onUnselect : function(record){
				if(record.label == 'years'){
					$('#cb_yearStart').combobox({
						disabled: true
					});
				}
			}
			,onClick	: function(record){
				$('#cb_gubun').combobox('setValue', record.value)
				if(record.label == 'month'){
					$('#cb_yearStart').combobox('enable');
					$('#cb_monthStart').combobox('enable');
					$('#cb_monthEnd').combobox('enable');
					$('#cb_bungi').combobox({
						disabled: true
					});
				} else if(record.label == 'bungi'){
					$('#cb_yearStart').combobox('enable');
					$('#cb_bungi').combobox('enable');
					$('#cb_monthStart').combobox({
						disabled: true
					});
					$('#cb_monthEnd').combobox({
						disabled: true
					});
				} else if(record.label == 'years'){
					$('#cb_yearStart').combobox('enable');
					$('#cb_monthStart').combobox({
						disabled: true
					});
					$('#cb_monthEnd').combobox({
						disabled: true
					});
				}
			}
		});
		$('#cb_yearStart').combobox({
		  	valueField: 'YEAR'
			,textField: 'YEAR'
			,url: 'getYear.jsp'
			,width: 100
			,panelHeight:'auto'
			,editable: false
			,disabled:true
		});
		$('#cb_yearEnd').combobox({
		  	valueField: 'YEAR'
			,textField: 'YEAR'
			,url: 'getYear.jsp'
			,width: 100
			,panelHeight:'auto'
			,editable: false
		});
		$('#cb_monthStart').combobox({
			url: './tempMonth.json'
			,valueField:'MONTH'
            ,textField:'MONTH'
			,width: 100
			,panelHeight:'auto'
			,editable: false
			,disabled:true
		});
		$('#cb_monthEnd').combobox({
			url: './tempMonth.json'
				,valueField:'MONTH'
		            ,textField:'MONTH'
			,width: 100
			,panelHeight:'auto'
			,editable: false
			,disabled:true
		});
		$('#cb_bungi').combobox({
		  	valueField: 'label',
			textField: 'value',
			data: [
				{
					label: 'first',
					value: '1분기'
				}
				,{
					label: 'second',
					value: '2분기'
				}
				,{
					label: 'third',
					value: '3분기'
				}
				,{
					label: 'fourth',
					value: '4분기'
				}
				]
			,width: 100
			,panelHeight:'auto'
			 ,editable: false
			 ,disabled:true
		});
		$('#cb_minmax').combobox({
		  	valueField: 'label',
			textField: 'value',
			data: [
				{
					label: 'under',
					value: '이하'
				}
				,{
					label: 'over',
					value: '이상'
				}
			]
			,width: 100
			,panelHeight:'auto'
			,editable: false
			,onClick	: function(record){
				if(record.value == '이상'){
					$('#sb_temp').combobox('readonly', false);
					} else if(record.value == '이하'){
					$('#sb_temp').combobox('readonly', false);
					}
			}
		});
		$('#sb_temp').searchbox({
			//readonly:true,
		    searcher:function(value,ondo){
		       var startYear = $('#cb_yearStart').combobox('getValue');
		       var endYear = $('#cb_yearEnd').combobox('getValue');
		       var startMonth = $('#cb_monthStart').combobox('getValue');
		       var endMonth = $('#cb_monthEnd').combobox('getValue');
		       var gubun = $('#cb_gubun').combobox('getValue');
		        alert("  시작연도: "+startYear+"  도착연도: "+endYear+"  입력값: "+value + "  온도조건:  " + ondo + "  구분 값: " + gubun +"  시작월:  "+startMonth+"  도착월:  "+endMonth)
		       		if (startYear>endYear) {
		       			alert('시작연도는 도착연도보다 이른 연도 여야 합니다.');
		       		}
		        	if (endYear!=null && ondo!=null &&gubun=='year'){ //----------------------------단일연도일 경우
		    							//------------------------------테이블 값 변경
						        		$('#dg_temp').datagrid({
						        			url:'./getCalTempList.jsp?eYear='+endYear+'&gubun='+ondo
						        			,columns:[[
					        			        {field:'YEAR',title:'연도',width:100, align:'center'},
					        			        {field:'AVGTEMP',title:'평균기온',width:100, align:'center'},
					        			        {field:'MAXTEMP',title:'최고기온',width:100, align:'center'},
					        			        {field:'MINTEMP',title:'최저기온',width:100, align:'center'}
					        			    ]]
						        		});
			        					//------------------------------테이블 값 변경
		        	}//===========================END OF IF
		        	if (startYear!=null && endYear!=null &&ondo!=null&&gubun=='years'){ //----------------------------기간-연도별일 경우
		    							//------------------------------테이블 값 변경
						        		$('#dg_temp').datagrid({
						        			url:'./getCalTempList.jsp?eYear='+endYear+'&gubun='+ondo+'&sYear='+startYear
						        			,columns:[[
					        			        {field:'YEAR',title:'연도',width:100, align:'center'},
					        			        {field:'AVGTEMP',title:'평균기온',width:100, align:'center'},
					        			        {field:'MAXTEMP',title:'최고기온',width:100, align:'center'},
					        			        {field:'MINTEMP',title:'최저기온',width:100, align:'center'}
					        			    ]]
						        		});
			        					//------------------------------테이블 값 변경
		        	}//===========================END OF IF
		        	if (startMonth!=null && endYear!=null &&ondo!=null&&gubun=='month'){ //----------------------------기간-월별일 경우
		    							//------------------------------테이블 값 변경
						        		$('#dg_temp').datagrid({
						        			url:'./getCalTempList.jsp?eYear='+endYear+'&gubun='+ondo+'&sYear='+startYear+'&sMonth='+startMonth+'&eMonth='+endMonth
						        			 ,columns:[[
						        			        {field:'YEAR',title:'연도',width:100, align:'center'},
						        			        {field:'MONTH',title:'월',width:100, align:'center'	},
						        			        {field:'AVGTEMP',title:'평균기온',width:100, align:'center'},
						        			        {field:'MAXTEMP',title:'최고기온',width:100, align:'center'},
						        			        {field:'MINTEMP',title:'최저기온',width:100, align:'center'}
						        			    ]]
						        		});
			        					//------------------------------테이블 값 변경
		        	}//===========================END OF IF
		    }//=================end of searcher
		    ,menu:'#mm',
		    prompt:'조회할 온도를 입력해주세요'
		    ,width:300
			});
		}); //==============================end of ready
</script>
<h1> 기온데이터 조회하기</h1>
	<div id=toolbar>
			<label for="cb_gubun">자료구분: </label>
			<input id="cb_gubun"  class="easyui-combobox" >
			<label for="cb_yearStart">기간: </label>
			<input id="cb_yearStart"  class="easyui-combobox" >
			~
			<input id="cb_yearEnd"  class="easyui-combobox" > 년
			<input id="cb_monthStart"  class="easyui-combobox" >
			~
			<input id="cb_monthEnd"  class="easyui-combobox"> 월
			<label for="cb_bungi">분기: </label>
			<input id="cb_bungi"  class="easyui-combobox" >
			
			<input id="sb_temp" class="easyui-searchbox" ></input>
			<div id="mm" style="width:120px">
			    <div data-options="name:'MAX'">최고기온</div>
			    <div data-options="name:'MIN'">최저기온</div>
			    <div data-options="name:'AVG'">평균기온</div>
			</div>
			<input id="cb_minmax"  class="easyui-combobox" >
			<a class="easyui-linkbutton"  id="btn_clear" >초기화</a> 
		</div>
			<table id="dg_temp"></table>
			<!-- ============================================차트 여기 -->
			<div id="chart_div"></div>
</body>
</html>