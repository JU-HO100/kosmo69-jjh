<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <table style="width: 100%">
  		<tr>
  			<td>
  				 <h1 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px;">인기 셰프</h1>
  			</td>
  			<td style="text-align: right; padding-top: 20px;">
  				<a href="/ranking.jsp?ranking=0" style="font-family: 'Nanum Pen Script', cursive; font-size: 20px; color: black;">더보기</a>
  			</td>
  		</tr>
	</table>
<table align="center" style="width: 100%; border-top: solid 1px black;">
	<tr>
		<td style="width: 100%;">
			<div id="demo2" class="carousel slide" data-ride="carousel"   style="width: 100%;">
				<!-- Indicators -->
				<ul class="carousel-indicators">
					<li data-target="#demo2" data-slide-to="0" class="active"></li>
					<li data-target="#demo2" data-slide-to="1"></li>
				</ul>

				<!--The slideshow -->
				<div class="carousel-inner" style="height: 300px;">
					<div class="carousel-item active">
						<div style="margin-left: 140px;">
						<%
							for(int i=0;i<5;i++){
							//Map<String,Object> rmap = boardList.get(i);
						%>
						<div style="float: left;">
							<img src="/images/chef.png" style="width:150px; border-radius: 50%; border: solid 1px black; margin: 30px;">
							<h2 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px; text-align: center">*** 셰프님</h2>
						</div>
						<%
								}
						%>
						</div>
					</div>
					<div class="carousel-item">
						<div style="margin-left: 140px;">
						<%
							for(int i=0;i<5;i++){
							//Map<String,Object> rmap = boardList.get(i);
						%>
						<div style="float: left;">
							<img src="/images/chef2.png" style="width:150px; border-radius: 50%; border: solid 1px black; margin: 30px;">
							<h2 style="font-family: 'Nanum Pen Script', cursive; padding-left: 10px; text-align: center">*** 셰프님</h2>
						</div>
						<%
								}
						%>
					</div>
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="carousel-control-prev" href="#demo2" data-slide="prev">
					<span class="carousel-control-prev-icon" style="padding-bottom: 10px;"></span>
				</a> <a class="carousel-control-next" href="#demo2" data-slide="next">
					<span class="carousel-control-next-icon"></span>
				</a>
			</div>
		</td>
	</tr>
</table>