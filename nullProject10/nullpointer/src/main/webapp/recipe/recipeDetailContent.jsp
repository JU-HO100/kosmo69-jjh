<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<% List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("list");%>
<%-- <% int leng = (int)request.getAttribute("leng"); %> --%>
<% int leng = (int)list.get(0).get("leng"); %>
<% for(Map<String, Object> rmap:list) { %>
<table align="center" style="width: 100%;text-align: center;margin-top: 5%" class="table">
	<tr>
		<td style="width: 50%;">
			<p style="font-family: 'Single Day', cursive; font-size: 22px;">제목: <%=rmap.get("FOODNAME") %></p>
		</td>
		<td style="width: 50%;text-align: right; padding-right: 5%">
			조회수: <%=rmap.get("HIT") %>
			등록일:<%=rmap.get("CREATION_DATE") %>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<div id="dolike" style="float: right;">
			<script type="text/javascript">
				var menucd= '<%=rmap.get("MENUCD")%>';
				$.ajax({
					type:"GET"
					,url:"/recipe/checkLike.np?menucd="+menucd+"&m_id=<%=(String)session.getAttribute("id")%>"
					,dataType:"html"
					,success: function(data){
						 $('#dolike').html(data);
					}
				});
				
			</script>
			</div>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<p style="font-family: 'Single Day', cursive; font-size: 22px;">재료: <%=rmap.get("JAELYO")%></p>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<p style="font-family: 'Single Day', cursive; font-size: 22px;">대표이미지</p><br>
			<img src="../<%=rmap.get("MAIN_IMG")%>" style="width: 200px; height: 200px;">
		</td>
	</tr>
	<!-- 조리법이랑 이미지 for문  -->
	<%for(int i=0;i<leng;i++){%>	
	<tr>
		<td colspan="2">
			<p style="font-family: 'Single Day', cursive; font-size: 22px;">조리법</p><br>
			<img src="../<%=rmap.get("sub_img"+i) %>">
			<br/>
			<br/>
			<p style="font-family: 'Single Day', cursive; font-size: 22px;"><%=rmap.get("recipe_info"+i) %></p>
			<br/>
			<br/>
		</td>
	</tr>
	<%} %>
	<tr>
		<td style="width: 50%;">
			<p style="font-family: 'Single Day', cursive; font-size: 22px;">해시태그 : <%=rmap.get("HASHTAG") %></p>
		</td>
		<td style="width: 50%; cursor: pointer;" onclick="javascript:report('<%=rmap.get("M_ID")%>')">
				<img src="../images/siren.png" style="width: 20px;"> 회원신고
		</td>
	</tr>
</table>
<%}%>