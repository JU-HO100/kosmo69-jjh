<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<table>
	<tr>
		<td  style="width: 100%;">
			<div id="demo" class="carousel slide" data-ride="carousel"  style="width: 100%;">

				<!-- Indicators -->
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<li data-target="#demo" data-slide-to="1"></li>
					<li data-target="#demo" data-slide-to="2"></li>
				</ul>

				<!--The slideshow -->
				<div class="carousel-inner" >
					<div class="carousel-item active">
						<img src="/images/index1.jpg" style="width: 100%; height: 100%">
					</div>
					<div class="carousel-item">
						<img src="/images/index2.jpg" style="width: 100%; height: 100%;">
					</div>
					<div class="carousel-item">
						<img src="/images/index3.jpg" style="width: 100%; height: 100%;">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="carousel-control-prev" href="#demo" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a>
				 <a class="carousel-control-next" href="#demo" data-slide="next">
					<span class="carousel-control-next-icon"></span>
				</a>

			</div>
		</td>
	</tr>
</table>
