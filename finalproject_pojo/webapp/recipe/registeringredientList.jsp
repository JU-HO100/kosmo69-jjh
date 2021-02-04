<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%! int g_weight = 0;
int tot=0;
%>
<% List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("list");
int tarr[] = new int[list.size()];
for(int i=0;i<list.size();i++){
	tarr[i] = i+1;
}
%>
<% for(Map<String, Object> rmap:list) { %>
<% g_weight = g_weight+1; %>
<% String WEIGHT = "WEIGHT"+g_weight; %>
<script>
var jaelyo = [];
var weight = [];
var unit = [];
var i = 0;
function appendIngredient(JAELYO,tid,UNIT) {
 	var wid = '#WEIGHT'+tid;
	var WEIGHT = $(wid).val();
	jaelyo.push(JAELYO);
	weight.push(WEIGHT);
	unit.push(UNIT);
	alert("해당 재료가 등록되었습니다.");
	alert(jaelyo+weight+unit);
// 	$('#jaelyoTag').tagbox('setValues', [jaelyo[i]+weight[i]+unit[i]]);
		test.push(jaelyo[i]+" "+weight[i]+" "+unit[i]);
		$('#jaelyoTag').tagbox('setValues',test);
		opener.document.getElementById("jaelyo").value = test;
	
	i= i+1;
}

</script>
<table class="table table-hover" style="margin-bottom:0px">
	<tr>
		<td style="width: 25%;">
			<%=rmap.get("JAELYO") %>
		</td>
		<td style="width: 25%;">
			<input type="text" class="form-control"  id="<%=WEIGHT%>" >
		</td>
		<td style="width: 25%;">
			<%=rmap.get("UNIT") %>	
		</td>
		<td style="width: 10%;">
			<input type="button" class="btn btn-outline-success" value="등록" onclick="appendIngredient('<%=rmap.get("JAELYO") %>','<%=tarr[g_weight-1]%>','<%=rmap.get("UNIT") %>')">
		</td>
	</tr>
</table>
<%}%>
<% g_weight =0; %>
