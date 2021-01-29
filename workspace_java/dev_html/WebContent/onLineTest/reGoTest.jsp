<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%
	Map<String,Object> rmap = (Map<String,Object>)session.getAttribute("rmap");
	String smem_name = null;
	String smem_id = null;
	if(rmap!=null){
	    smem_name = rmap.get("smem_name").toString();
	    smem_id   = rmap.get("smem_id").toString();
	}else{
	    smem_name = "";
	    smem_id = "";
	}	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var g_subcd = null;
	function examStrart(){
		//사용자가 입력한 수험 번호가져오기
		var u_exam_no = $().val();
		var param = "mem_id=<%=smem_id%>&exam_no="+u_exam_no
		$.ajax({
			method:"post"
			,url:"isOk.sp2"
			,param:param
			,success:function(data){
				alert("data:"+data);
				
			}
		});
		
	}
</script>
<%@ include file="/common/easyui_common.jsp" %>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#cb_subject").combobox({
			url:"/onLineTest2/subjectList.sp2?timestamp="+new Date().getTime()
		   ,valueField:'SUB_CD'
		   ,textField:'SUB_NAME'
		   ,onSelect: function(rec){
		    	g_subcd = rec.SUB_CD;
		    }
		});
	});
</script>
    <div class="easyui-panel" title="Test Takers" style="width:100%;max-width:400px;padding:30px 60px;">
       <form id="f_exam">
       <input type="hidden" id="work" name="work" value="onLineTest">
        <div style="margin-bottom:20px">
            <select class="easyui-combobox" id="cb_subject" label="수험과목선택:" labelPosition="top" data-options="prompt:'수험과목을 선택하세요'" style="width:100%;">
            </select>
        </div>
        <div style="margin-bottom:20px">
            <input class="easyui-textbox" label="수험번호:" value="1908020010" id="exam_no" name="exam_no" labelPosition="top" style="width:100%;">
        </div>
        <div>
            <a href="javascript:examStart()" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">시험시작</a>
        </div>
       </form>
    </div>
    <!-- 승인 후 시험문제 1번을 가져와서 출력할 부분임. --> 
       <div id="d_test1"></div>
</body>
</html>