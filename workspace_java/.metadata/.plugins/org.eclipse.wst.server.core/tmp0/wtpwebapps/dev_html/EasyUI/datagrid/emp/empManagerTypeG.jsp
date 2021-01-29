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
       ////////////////////////////////// [[데이터 그리드에서 입력|수정|삭제 시작]] //////////////////////////////////////////////
       function empUpdate(){
       		$('#dlg_upd').dialog('open');
       		$('#dg_emp').treegrid('update',{
       			id: 2,
       			row: {
       				name: 'new name',
       				iconCls: 'icon-save'
       			}
       		});	
       	  }
       function insert(){
       		var row = $('#dg_emp').datagrid('getSelected');//선택한 로우의 번호를 가져옴 - table
//        		$("#d_msg").append('row:'+row+'<br>');
			if (row){//boolen 0:false , 값이 들어있으면:ture
				var index = $('#dg_emp').datagrid('getRowIndex', row);
			} else {
				index = 0;
			}
			$('#dg_emp').datagrid('insertRow', {
				index: index
				//넥사크로의 DataSet header꾸미기
				,row:{
					CK:0
					,EMPNO:0
					,ENAME:''
					,JOB:''
					,MGR:0
					,SAL:'0.0'
					,COMM:'0.0'
					,DEPTNO:''
				}
			});
//        		$("#d_msg").append('index:'+index);
			$('#dg_emp').datagrid('selectRow',index);
			$('#dg_emp').datagrid('beginEdit',index);
       	  }
       function getRowIndex(target){
//        		$("#d_msg").append('target:'+target);
    	    var tr = $(target).closest('tr.datagrid-row');
    	    return parseInt(tr.attr('datagrid-row-index'));
    	}
    	function editrow(target){
    	    $('#dg_emp').datagrid('beginEdit', getRowIndex(target));
		
    	}
    	function deleterow(target){
    	    $.messager.confirm('Confirm','Are you sure?',function(r){
    	        if (r){
    	        }
    	    });
    	}
    	function saverow(target){
    	    $('#dg_emp').datagrid('endEdit', getRowIndex(target));
    	}
    	function cancelrow(target){
    	    $('#dg_emp').datagrid('cancelEdit', getRowIndex(target));
    	}
       ////////////////////////////////// [[데이터 그리드에서 입력|수정|삭제 끝]] //////////////////////////////////////////////
      var cols;
       function empSearch(){
	        //화면에 갱신처리 하기
	        //페이지를 이동해야 하는가? -이동해야하는 경우, 이동하지 않아도 되는경우?
	        //아니면 현재 보고 있는 페이지에서 처리 가능한가? -갱신처리 가능
	        //datagrid를 활용함. -url을 통해서 jsp 혹은 서블릿을 경유(갔다가 다시 온다)할수 있다.
	    	$("#dg_emp").datagrid({
	    		url:'../../getEmpList3.jsp?cols='+$("#cb_gubun").val()+"&keyword="+$("#sb_keyword").val()/* 전체조회와 조건검색 조회를 하나의 메소드로 할 것인지, 아니면 다른 메소드로 할것인지 결정해야 한다. */
	    		,method:'post'
	    		,onloadSuccess:function(data){
	    			var result = JSON.stringify(data);
// 	    			var jsonDoc = JSON.parse(result);
	    			alert(result);
// 					for(var i=0;i<jsonDoc.length;i++)
// 	    				alert("empno:"+jsonDoc[i].EMPNO);
	    		}
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
//        function onClickCell(index, field){
//            if (editIndex != index){
//                if (endEditing()){
//                    $('#dg_emp').datagrid('selectRow', index)
//                            .datagrid('beginEdit', index);
//                    var ed = $('#dg_emp').datagrid('getEditor', {index:index,field:field});
//                    if (ed){
//                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
//                    }
//                    editIndex = index;
//                } else {
//                    setTimeout(function(){
//                        $('#dg_emp').datagrid('selectRow', editIndex);
//                    },0);
//                }
//            }
//        }
       function onEndEdit(index, row){
           var ed = $(this).datagrid('getEditor', {
               index: index,
               field: 'EMPNO'
           });
//            row.DEPTNO = $(ed.target).textrbox('getText');
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
//             url: "../emp2.json"/* 서버의 이전이나 소스의 재사용성을 고려하여 상대경로로 작성할것. */   
            url: "../../getEmpList3.jsp"/* 서버의 이전이나 소스의 재사용성을 고려하여 상대경로로 작성할것. */   
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
            toolbar:'#tbar_emp'
			,columns:[[
					   {field:'CK'		,checkbox:'true',width:50,  align:'center'}
					   ,{field:'EMPNO'	,title:'사원번호'	,width:100, editor:'text'}
					   ,{field:'ENAME'	,title:'사원이름'	,width:100, editor:'text'}
					   ,{field:'JOB'  	,title:'job'	,width:130, editor:'text'
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
					   ,{field:'action',title:'Action',width:120,align:'center'
			                ,formatter:function(value,row,index){
			                    if (row.editing){
			                        var s = '<a href="javascript:void(0)" onclick="saverow(this)">Save</a> ';
			                        var c = '<a href="javascript:void(0)" onclick="cancelrow(this)">Cancel</a>';
			                        return s+c;
			                    }
			                    else {
			                        var e = '<a href="javascript:void(0)" onclick="editrow(this)">Edit</a> ';
			                        var d = '<a href="javascript:void(0)" onclick="deleterow(this)">Delete</a>';
			                        return e+d;
			                    }
			                }
			            }
			]]
//          	,onClickSel: onClickSel
         	,onEndEdit: onEndEdit
////////////////////////////////////////// [[데이터 그리드관련 이벤트핸들러 이름 시작]] ///////////////////////////////////////////////////////////         	
//          	,onEndEdit:function(index,row){
//                 var ed = $(this).datagrid('getEditor', {
//                     index: index,
//                     field: 'productid'
//                 });
//                 row.productname = $(ed.target).combobox('getText');
//             }
            ,onBeforeEdit:function(index,row){
            	alert(index);
                row.editing = true;
                $(this).datagrid('refreshRow', index);
            }
            ,onAfterEdit:function(index,row){
                row.editing = false;
                $(this).datagrid('refreshRow', index);
            }
            ,onCancelEdit:function(index,row){
                row.editing = false;
                $(this).datagrid('refreshRow', index);
            }
            ,onDblClickRow: function(index, row){
            	$('#dlg_upd').dialog('open');
        		$('#u_empno').numberbox("setValue",row.EMPNO);
        		$('#u_ename').textbox("setValue",row.ENAME);
        		$('#u_job').textbox("setValue",row.JOB);
        		$('#u_hiredate').textbox("setValue",row.HIREDATE);
        		$('#u_sal').numberbox("setValue",row.SAL);
        		$('#u_comm').numberbox("setValue",row.COMM);
        		$('#u_deptno').combobox("setValue",row.DEPTNO);
//         		$('#zipcode').textbox("setValue",row.EMPNO);
//         		$('#mem_addr').textbox("setValue",row.EMPNO);
        		
        	}
////////////////////////////////////////// [[데이터 그리드관련 이벤트핸들러 이름 끝]] ///////////////////////////////////////////////////////////         	
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
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="insert()">Insert Row</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="empList()">조회</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" 	 plain="true" onclick="addEmp()">입력</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" 	 plain="true" onclick="empUpdate()">수정</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeEmp()">삭제</a>
				</td>
			</tr>	
		</table>
		<!-- 업무관련 끝 -->
</div>
<!-- ================================ [[ToolBar 추가하기 끝]] =================================================== -->
<table id="dg_emp" class="esayui-datagrid"  width="1200" title="사원관리">
</table>
<!-- ==========================================[[사원카드 등록 하기 시작]]======================================================================== -->
<!-- <div id="dlg_ins" class="esayui-dialog" style="width:600px; padding:30px 30px" data-options="closed:true, title:'사원정보 입력'"> -->
<!-- 	<form id="f_empins"> -->
			
<!-- 	</form> -->
<!-- 	<div> -->
<!-- 		<a href="javascript:insAction()" class="easyui-linkbutton" iconCls="icon-save">저장</a> -->
<!-- 		<a href="javascript:$('#dlg_ins').dialog('close')" class="easyui-linkbutton" iconCls="icon-cancel" onclick="cancelEmp()">닫기</a> -->
<!-- 	</div> -->
<!-- </div> -->
<!-- ==========================================[[사원카드 등록 하기 끝]]======================================================================== -->

<!-- ==========================================[[사원카드 수정 하기 시작]]======================================================================== -->
<div id="dlg_upd" name="dlg_upd" style="width:600px; padding:30px 30px;" class="easyui-dialog" data-options="closed:'true', title:'사원정보 수정', footer:'#d_upd'">
   <form id="f_empupd">
               <div style="margin-bottom:10px">
         <input class="easyui-numberbox" id="u_empno" name="empno" label="사원번호" data-options="prompt:'Enter a EmpNO'" style="width:150px">
         </div>
         <div style="margin-bottom:10px">
         <input class="easyui-textbox" id="u_ename" name="ename" label="사원명" data-options="prompt:'Enter a ENAME'" style="width:250px">
         </div>
         <div style="margin-bottom:10px">
         <input class="easyui-textbox" id="u_job" name="job" label="JOB" data-options="prompt:'Enter a JOB'" style="width:250px">
         </div>
         <div style="margin-bottom:10px">
         <input class="easyui-textbox" id="u_hiredate" name="hiredate" label="입사일자" data-options="prompt:'Enter a 입사일자'" style="width:250px">
         </div>
         <div style="margin-bottom:10px">
         <input class="easyui-numberbox" id="u_sal" name="sal" label="급여" data-options="prompt:'Enter a 급여'" style="width:250px">
         </div>         
         <div style="margin-bottom:10px">
         <input class="easyui-numberbox" id="u_comm" name="comm" label="인센티브"  data-options="prompt:'Enter a 인센티브'" style="width:250px">
         </div>         
         <div style="margin-bottom:10px">
         <input class="easyui-combobox" id="u_deptno" name="deptno" label="부서번호" style="width:250px"
          data-options="prompt:'Enter a 부서번호'
                      	,valueField: 'DEPTNO'
                         ,textField: 'DNAME'
                         ,url: 'http://192.168.0.38:9000/EasyUI/getDeptList.jsp'
                         ,onSelect: function(rec){
                      }" 
         >
         </div>         
         <div style="margin-bottom:10px">
         <input class="easyui-textbox" id="zipcode" name="zipcode" label="우편번호"  data-options="prompt:'Enter a ZIPCODE'" style="width:160px">
         <a id="btn_zipcode" href="#" class="easyui-linkbutton">우편번호찾기</a>
         </div>
         <div style="margin-bottom:10px">
         <input class="easyui-textbox" id="mem_addr" name="mem_addr" label="주소"  data-options="prompt:'Enter a ADDRESS'" style="width:420px">
         </div>
   </form>
   <div>
      <!-- a태그는 문단이동 혹은 링크 마지막 자바스크립트 함수 호출이 가능함.(특정한 지점으로 바로 이동가능)  이클립스 ctrl + l 앵커
      data-options="toolbar:#tbar_emp", footer:'#d_upd'
      -->
       <a href="javascript:updAction()" class="easyui-linkbutton" iconCls="icon-save" plain="true">저장</a>
        <a href="javascript:$('#dlg_upd').dialog('close')" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">닫기</a>
       
   </div>
</div>
<!-- ==========================================[[사원카드 수정 하기 끝]]======================================================================== -->
</body>
</html>









