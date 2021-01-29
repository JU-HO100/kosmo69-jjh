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
    <style type="text/css">
		 * {
	 	margin: 0;
	 	padding: 0;
	 	font-family: 'Noto Sans KR', sans-serif;
	 }
	 </style>
</head>
<body>
<script>
		$(document).ready(function (){
		$('#dg_temp').datagrid({
		    url:'getTempData.jsp'
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
				},{
					label: 'month',
					value: '월'
				},{
					label: 'bungi',
					value: '분기'
				}]
			,width: 100
			,panelHeight:'auto'
			,onClick	: function(record){
				$('#cb_gubun').combobox('setValue', record.value)
				if(record.label == 'month'){
					$('#cb_monthStart').combobox('enable');
					$('#cb_monthEnd').combobox('enable');
					$('#cb_bungi').combobox({
						disabled: true
					});
				} else if(record.label == 'bungi'){
					$('#cb_bungi').combobox('enable');
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
			,url: './getYear.jsp'
			,width: 100
			,panelHeight:'auto'
			,editable: false
		});
		$('#cb_yearEnd').combobox({
		  	valueField: 'YEAR'
			,textField: 'YEAR'
			,url: './getYear.jsp'
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
		});
// ==================================== 아직 미구현  ================================================
		$('#sb_temp').searchbox({
		    searcher:function(value,ondo){
		       var startYear = $('#cb_yearStart').combobox('getValue');
		       var endYear = $('#cb_yearEnd').combobox('getValue');
		        alert("  시작연도: "+startYear+"  도착연도: "+endYear+"  입력값: "+value + "  온도조건:  " + ondo)
		       		if (startYear>endYear) {
		       			alert('시작연도는 도착연도보다 이른 연도 여야 합니다.');
		       		}
		       	if(){
		       		
		       	}

		        
		    },//=================end of searcher
		    menu:'#mm',
		    prompt:'조회할 온도를 입력해주세요'
		    ,width:300
		});
// ==================================== 아직 미구현  ================================================
		
		}); //==============================end of ready
</script>
<h1> 기온데이터 조회하기</h1>
	<div id=toolbar>
			<label for="cb_gubun">자료구분: </label>
			<input id="cb_gubun"  class="easyui-combobox" >
			<label for="cb_yearStart">기간: </label>
			<input id="cb_yearStart"  class="easyui-combobox" >년
			<input id="cb_monthStart"  class="easyui-combobox" >월
			~
			<input id="cb_yearEnd"  class="easyui-combobox" > 년
			<input id="cb_monthEnd"  class="easyui-combobox"> 월
			<label for="cb_bungi">분기: </label>
			<input id="cb_bungi"  class="easyui-combobox" >
			
			<input id="sb_temp" class="easyui-searchbox" ></input>
			<div id="mm" style="width:120px">
			    <div data-options="name:'max'">최고기온</div>
			    <div data-options="name:'min'">최저기온</div>
			    <div data-options="name:'average'">평균기온</div>
			</div>
			<input id="cb_minmax"  class="easyui-combobox" >
	</div>
			<table id="dg_temp"></table>
</body>
</html>