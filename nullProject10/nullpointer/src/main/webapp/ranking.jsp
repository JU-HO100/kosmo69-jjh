<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 먹지?</title>
<%@ include file="/common/bootstrap_common.jsp"%>
<% String ranking = request.getParameter("ranking");%>
<%String indexNick =  (String)session.getAttribute("nick");%>
<script type="text/javascript">
	function chefView(m_id, m_name){
 		var url = "/rankingRecipeContent.jsp?m_id="+m_id+"&m_name="+m_name;
 		var left = Math.ceil((window.screen.width - 700)/2);
 	    var top = Math.ceil((window.screen.height - 700)/2);
        var option = "width = 850, height = 850, top="+top+", left="+left+", location = no"
  		window.open(url, name, option);
  	}
	function rankingChefContent(){
	    $.ajax({
	      type : "GET",
	      url : "rankingChefContent.jsp",
	      dataType : "text",
	      error : function() {
	        alert('통신실패!!');
	      },
	      success : function(data) {
	        $('#tb_ajax').html(data);
	      }

	    });
	  }

	function rankingRecipeContent(){
	    $.ajax({
	      type : "GET",
	      url : "rankingRecipeContent.jsp",
	      dataType : "text",
	      error : function() {
	        alert('통신실패!!');
	      },
	      success : function(data) {
	        $('#tb_ajax').html(data);
	      }

	    });
	  }
	

function logout() {
	location.href="/member/logout.jsp";
}
</script>
</head>
<body>
	<table align="center" style="width: 70% ; height: 100%;">
			<!-- Header -->
		<tr>
			<%if(indexNick!=null && indexNick.equals("총관리자")){ %>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/adminHeader.jsp"%>
			</td>		
			<%}else if(indexNick!=null && indexNick.length() >0 && ! indexNick.equals("총관리자")){ %>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/loginOkHeader.jsp"%>
			</td>
			<%}else{ %>
			<td colspan="3" style="width: 100%; padding-top: 2%; padding-bottom: 2%;">
				<%@ include file="/header.jsp"%>
			</td>
			<%} %>
		</tr>
			<!-- END Header -->
			
			<!-- NavBar -->
		<tr>
			<td style="width: 100%;">
				<%@ include file="/navbar.jsp" %>
			</td>
		</tr>
			<!-- END NavBar -->
			
			<!-- Content -->
		<tr>
			<td style="width: 80%; padding-left: 5%; padding-right: 5%;padding-top: 5%">
				<h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">셰프 랭킹</h1>
					<table id="ranking"  class="table" style="width: 100%;">
						<tr>
							<td style="border: none;">
							<script type="text/javascript">
									$(document).ready(function () {
									      $.ajax({
									    	  url : "/member/chefRanking.np",
									         success : function (result) { 
									        	  $.each(result, function (index, item) {
									        		  var m_id = item.M_ID;
									        		  var m_name = item.M_NAME;
									        		  var str = '<table style="width:100%;"><tr style="cursor:pointer;"onclick="javascript:chefView('+"'"+m_id+"'"+','+"'"+m_name+"'"+')"><td style="width:20%;"> 순위 : '+item.RANKING+'</td>';
									        		  str +='<td style="width:20%;"> 좋아요 수 : '+item.M_LIKE+'</td>';
									        		  str +='<td style="width:20%;"> 셰프님 : '+item.M_NAME+'</td>';
									        		  str +='<td style="width:20%;"> 주력요리 : '+item.MAIN_FOOD+'</td></tr></table>';
									        		  $('#ranking').append(str);
									        	  });
									        	}
									         });
									   });
							</script>
							</td>
						</tr>
					</table>
			</td>
		</tr>			
			<!-- Content -->
			
			<!-- Footer -->
		<tr>
			<td style="padding-top: 18%">
				<%@ include file="/footer.jsp" %>
			</td>
		</tr>
			<!-- End Footer -->
	</table>
<div id="dlg_recipeDetail" closed="true" class="easyui_dialog" style="padding: 20px 50px">
</div>
</body>
</html>