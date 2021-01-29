<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table style="width: 100%">
	<tr>
		<td style="width: 23%; vertical-align: top;">
			<div class="btn-group-vertical" style="width: 100%;">
				 <button type="button" class="btn btn-outline-dark" style="text-align: left;" onclick="memberControl()">회원 관리</button>
				 <button type="button" class="btn btn-outline-dark active" style="text-align: left;" onclick="#">블랙 리스트</button>
			</div>
		</td>
		<td style="width: 77%; padding-left: 5%; padding-right: 5%;">
						<table class="easyui-datagrid" title="블랙 리스트"
							style="width: 100%; height: 250px"
							data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb',footer:'#ft'">
							<thead>
								<tr>
									<th data-options="field:'itemid',width:100">아이디</th>
									<th data-options="field:'productid',width:100">비밀번호</th>
									<th data-options="field:'listprice',width:150">핸드폰 번호</th>
									<th data-options="field:'unitcost',width:100">이름</th>
									<th data-options="field:'attr1',width:100">가입일</th>
									<th data-options="field:'status',width:100">메일</th>
									<th data-options="field:'status',width:100">쉐프 신청현황</th>
									<th data-options="field:'status',width:100">좋아요 수</th>
								</tr>
							</thead>
						</table>
						<div id="tb" style="padding: 2px 5px;">
							<input type="text"  style="margin-left: 3%">
							<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
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