<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table style="width: 100%">
	<tr>
		<td style="width: 23%; vertical-align: top;">
			<div class="btn-group-vertical" style="width: 100%;">
				 <button type="button" class="btn btn-outline-dark active" style="text-align: left;" onclick="#">레시피 관리</button>
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;"  onclick="cookingClassControl()">쿠킹클래스 관리</button>
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="memberControl()">회원 관리</button>
			</div>
		</td>
		<td style="width: 77%; padding-left: 5%; padding-right: 5%;">
						<table class="easyui-datagrid" title="레시피 관리"
							style="width: 100%; height: 250px"
							data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb',footer:'#ft'">
							<thead>
								<tr>
									<th data-options="field:'itemid',width:80">Item ID</th>
									<th data-options="field:'productid',width:100">Product</th>
									<th data-options="field:'listprice',width:80,align:'right'">List Price</th>
									<th data-options="field:'unitcost',width:80,align:'right'">Unit Cost</th>
									<th data-options="field:'attr1',width:240">Attribute</th>
									<th data-options="field:'status',width:60,align:'center'">Status</th>
								</tr>
							</thead>
						</table>
						<div id="tb" style="padding: 2px 5px;">
							Date From: <input class="easyui-datebox" style="width: 110px">
							To: <input class="easyui-datebox" style="width: 110px">
							Language: <select class="easyui-combobox" panelHeight="auto"
								style="width: 100px">
								<option value="java">Java</option>
								<option value="c">C</option>
								<option value="basic">Basic</option>
								<option value="perl">Perl</option>
								<option value="python">Python</option>
							</select> <a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
						</div>
						<div id="ft" style="padding: 2px 5px;">
							<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"></a> 
							<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"></a>
							<a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true"></a>
							<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true"></a>
							<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true"></a>
						</div>
		</td>
	</tr>
</table>