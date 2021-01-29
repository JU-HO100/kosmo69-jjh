<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원관리(empManagerD2-2Type.html)</title>
<!-- 공통코드 추가 시작 
나중에는 이것들을 include를 사용해서 한 줄 추가로 하면 좋을거 같아요.
-->
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
    <style type="text/css">
        
       #d_msg {
          border: 5px solid gold;
          width: 700px;
          height: 120px;
       }
    </style>
<!-- 공통코드 추가   끝  -->
   <script type="text/javascript">
       var v_date;//사용자가 선택한 날짜 정보를 담을 변수 선언.
       var editIndex = undefined;
       /* param1:사용자가 searchbox에 입력한 값 
       	  param2:searchbox에 등록한 name값 -jsp나 서블릿에서 사용자가 입력한 값을 요청할때 사용한다.
       	  ==>request.getParameter("sb_keyword")
       */
      var cols;
       function empSearch(){
	        //화면에 갱신처리 하기
	        //페이지를 이동해야 하는가? -이동해야하는 경우, 이동하지 않아도 되는경우?
	        //아니면 현재 보고 있는 페이지에서 처리 가능한가? -갱신처리 가능
	        //datagrid를 활용함. -url을 통해서 jsp 혹은 서블릿을 경유(갔다가 다시 온다)할수 있다.
	    	$("#dg_emp").datagrid({
	    		url:'../../getEmpList2.jsp?cols='+$("#cb_gubun").val()+"&keyword="+$("#sb_keyword").val()/* 전체조회와 조건검색 조회를 하나의 메소드로 할 것인지, 아니면 다른 메소드로 할것인지 결정해야 한다. */
	    		,method:'post'
// 	    		,onloadSuccess:function(data){
// 	    			var result = JSON.stringify(data);
// 	    			var jsonDoc = JSON.parse(result);
// 					for(var i=0;i<jsonDoc.length;i++)
// 	    				alert("empno:"+jsonDoc[i].EMPNO);
// 	    		}
	    	});
       	}
       function endEditing(){
           if (editIndex == undefined){return true}
           if ($('#dg_emp').datagrid('validateRow', editIndex)){
               $('#dg_emp').datagrid('endEdit', editIndex);
               editIndex = undefined;
               return true;
           } else {
               return false;
           }
       }
       function onClickCell(index, field){
           if (editIndex != index){
               if (endEditing()){
                   $('#dg_emp').datagrid('selectRow', index)
                           .datagrid('beginEdit', index);
                   var ed = $('#dg_emp').datagrid('getEditor', {index:index,field:field});
                   if (ed){
                       ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                   }
                   editIndex = index;
               } else {
                   setTimeout(function(){
                       $('#dg_emp').datagrid('selectRow', editIndex);
                   },0);
               }
           }
       }
       function onEndEdit(index, row){
           var ed = $(this).datagrid('getEditor', {
               index: index,
               field: 'EMPNO'
           });
//            row.DEPTNO = $(ed.target).combobox('getText');
       }
       function append(){
           if (endEditing()){
               $('#dg_emp').datagrid('appendRow',{status:'P'});
               editIndex = $('#dg_emp').datagrid('getRows').length-1;
               $('#dg_emp').datagrid('selectRow', editIndex)
                       .datagrid('beginEdit', editIndex);
           }
       }
       function removeit(){
           if (editIndex == undefined){return}
           $('#dg_emp').datagrid('cancelEdit', editIndex)
                   .datagrid('deleteRow', editIndex);
           editIndex = undefined;
       }
       function acceptit(){
           if (endEditing()){
               $('#dg_emp').datagrid('acceptChanges');
           }
       }
       function reject(){
           $('#dg_emp').datagrid('rejectChanges');
           editIndex = undefined;
       }
       function getChanges(){
           var rows = $('#dg_emp').datagrid('getChanges');
           alert(rows.length+' rows are changed!');
       }
  
      //너 조회할거야?
      function empList(){
         $("#d_msg").append("empList호출 성공<br>");
         $("#dg_emp").datagrid({
            url: "../emp.json"/* 서버의 이전이나 소스의 재사용성을 고려하여 상대경로로 작성할것. */   
         });

      }                  
   </script>
</head>
<body>
<script type="text/javascript">   
   $(document).ready(function (){
	   //콤보박스 초기화 및 설정하기
         $("#cb_gubun").combobox({
	   		data: [
	   			{cols:'empno', label:'사원번호'},
	   			{cols:'enamo', label:'사원이름'},
	   			{cols:'sal'	 , label:'급여'}
	   		]
         ,onSelect: function(rec){/*  콤보에서 선택 했을때 @param:object로 로우에 주소번지를 갖는다. row.empno ,row.ename */
        	 	alert("선택한로우의 컬럼정보 :"+rec.cols);
// 	            var url = '../../getEmpList.jsp?empno='+rec.cols;
//         	 cols = rec.cols;
	        }
        });
	   //데이터그리드 초기화 및 설정하기
         $("#dg_emp").datagrid({
            url: "../../getEmpList2.jsp"/* 서버의 이전이나 소스의 재사용성을 고려하여 상대경로로 작성할것. */   
            ,toolbar: '#tbar_emp'
			,columns:[[
						{field:'EMPNO'	,title:'사원번호'	,width:100, editor:'text'}
					   ,{field:'ENAME'	,title:'사원이름'	,width:100, editor:'text'}
					   ,{field:'JOB'  	,title:'job'	,width:100, editor:'text'
						   ,formatter:function(value, row){
							   return row.job||value;
						   }
						   ,editor:{
							 type:'combobox'
								 ,options:{
									 valueField: 'JOB'//실제 서버에 넘거가는 필드
									 ,textField: 'JOB'
									 ,data:'JOB'
									 ,url:'../emp2.json'
								 }
							   }
					   }
					   ,{field:'MGR'	 ,title:'그룹번호'	,width:100, editor:'text'}
					   ,{field:'HIREDATE',title:'입사일'	,width:250, editor:'text', hidden:'true'}
					   ,{field:'SAL'	 ,title:'급여'	,width:100, editor:'text'}
					   ,{field:'COMM'	 ,title:'인센티브'	,width:100, editor:'text'}
					   ,{field:'DEPTNO'	 ,title:'부서번호'	,width:100,	editor:'text',
						   formatter:function(value, row){
							   return row.deptno||value;
						   }
						   ,editor:{
							 type:'combobox'
							 ,options:{
								 valueField: 'DEPTNO'//실제 서버에 넘거가는 필드
								 ,textField: 'DNAME'
								 ,data:'DEPTNO'
								 ,url:'../dept.json'
							 }
						   }
					   }
					   ,{field:'action',title:'Action',width:120,align:'center',
			                formatter:function(value,row,index){
			                    if (row.editing){
			                        var s = '<a href="javascript:void(0)" onclick="saverow(this)">Save</a> ';
			                        var c = '<a href="javascript:void(0)" onclick="cancelrow(this)">Cancel</a>';
			                        return s+c;
			                    } else {
			                        var e = '<a href="javascript:void(0)" onclick="editrow(this)">Edit</a> ';
			                        var d = '<a href="javascript:void(0)" onclick="deleterow(this)">Delete</a>';
			                        return e+d;
			                    }
			                }
			            }
			]]
         	,onClickCell: onClickCell
         	,onEndEdit: onEndEdit
         });
        
   });
</script>
<!-- 이 페이지에 대한 에러 메시지나 힌트문을 출력하자. -->
<div id="d_msg"></div>
<!-- ================================ [[ToolBar 추가하기 시작]] =================================================== -->
<div id="tbar_emp">
		<!-- 테이블 태그를 활용하여 조건 검색하는 화면을 추가하고 그 아래 버튼을 배치하시요. -->
		<table border="0" width="100%">
			<!-- 조건 검색 화면 시작 -->
				<tr>
					<td>
					<table border="0">
						<tr>
							<td width="280px">
							<label width="100">사원번호</label>
							<input id="nb_empno" class="easyui-numberbox" style="width:200px;" value="0">
							</td>
							<td width="250px">
							<label width="100">급여</label>
							<input id="nb_sal" class="easyui-numberbox" value="0">
							</td>
							<td width="300px">
							<input id="dd_hiredate"	class="easyui-datebox" label="날짜" style="width:200px;" required="required">
							</td>
							
						</tr>
<!-- combobox추가 시작(위치선택, 공간 확보, 코드추가) 이름|job|부서번호 -->
						<tr>
							<td width="1000px" colspan="3">
							<label width="100">검색분류</label>
<!-- =============================================== 이순신 2020.11.02 추가 시작 ========================================================== -->
					<input id="cb_gubun" class="easyui-combobox" data-options="
			       	 	valueField: 'cols',
			        	textField: 'label'">
<!-- =============================================== 이순신 2020.11.02 추가 시작 ========================================================== -->
					<input id="sb_keyword" name="sb_keyword" class="easyui-searchbox" data-options="searcher:empSearch,prompt:'Please Input Value'" style="width:300px">
							</td>
<!-- combobox추가 시작 -->
						</tr>
					</table>
					</td>
				</tr><!-- &nbsp = 띄어쓰기연산자 -->
			<!-- 조건 검색화면 끝 -->
			<!-- 업무관련 시작 -->
			<tr>
				<td>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="empList()">조회</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" 	 plain="true" onclick="addEmp()">입력</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" 	 plain="true" onclick="editEmp()">수정</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeEmp()">삭제</a>
				</td>
			</tr>	
		</table>
		<!-- 업무관련 끝 -->
</div>
<!-- ================================ [[ToolBar 추가하기 끝]] =================================================== -->
<table id="dg_emp" class="esayui-datagrid"  width="1200" title="사원관리">
</table>
</body>
</html>
