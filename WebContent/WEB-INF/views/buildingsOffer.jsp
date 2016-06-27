<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/bootstrapMeta.inc"%>
<title>Economia Building Offers</title>
<%@include file="includes/bootstrapCss.css"%>
<%@include file="includes/treeView.css"%>
<body class="" sytle="">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="container">
				<div class="navbar-header">
					<p class="navbar-text">
						<font color=#ee4d2e><b>Economia</b></font>
					</p>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="list">My Castle</a></li>
						<li class="active"><a href="buildings">Buildings</a></li>
						<li><a href="recruits">Recruits</a></li>
						<li><a href="trade">Trade</a></li>
						<li><a href="fight">Fight</a></li>



					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a class="btn btn-info" href="history"><font
								color=#fff>History</font></a></li>
						<li>`</li>
						<li><a class="btn btn-danger" href="logout"><font
								color=#fff>Logout</font>							
						</a></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
				
	<div class="container" role="main">
		<div class="jumbotron">
					<h2>Following buildings are available:</h2>
					<p>The agony of choice.</p>
					<br>
					
					<a class="btn btn-primary btn-large" href="buildings"> Back </a>
					
					<div align = "center">
						<div class="label label-primary" align = "center">output/5min</div>
					</div>
					<br>
					
					<c:forEach items="${buildings}" var="building">
					<div class="row">
						<div class="col-md-10 col-md-offset-1">
							<table data-toggle="table" class="table table-striped">
								<thead>
									<tr>
										<th>Type</th>
										<th>Level <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/level-icon.png"></th>
										<th>Wood <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/wood-icon.png"></th>
										<th>Stone<img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/stone-icon.png"></th>
										<th>Food<img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/food-icon.png"></th>
										<th>Gold<img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/gold-icon.png"></th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									
										<tr>
											<td colspan="3"><img src="${building.icon}" alt="${building.name}" style="width:100;height:85px;">
												<br><h5 align="center">${building.name}</h5></td>		
											<td>${building.level}</td>
											<td>${building.woodOutput}</td>
											<td>${building.stoneOutput}</td>
											<td>${building.foodOutput}</td>
											<td>${building.goldOutput}</td>
											<td><a class="btn btn-success btn-large" href="addOrUpgradeBuilding?id=${building.id}">Buy</a></td>
										</tr>	
										<tr>
										<td></td>
										<td> <h5 align="center"><b>Costs:</b>  </h5></td>
											
											
											<td><h5>Wood</h5></td>
											<td><h5>Stone</h5></td>
											<td><h5>Food</h5></td>
											<td><h5>Gold</h5></td>
											
										<td></td>
											
										</tr>
										<tr>
											<td></td>
											<td></td>
											<td>${building.neededWood}</td>
											<td>${building.neededStone}</td>
											<td>${building.neededFood}</td>
											<td>${building.neededGold}</td>
											<td></td>
										</tr>										
									
									
								</tbody>
							</table>
							<hr>
						</div>
					</div>
</c:forEach>
				</div>
			</div>
		</div>
	</div>

    <div id="footer" >
		<div class="row" > <!--  style="z-index:110; -->
			<div class="col-md-6 col-md-offset-3">
				<table class="table" style="background-color:#ee4d2e;">
					<thead>
						<tr>
							<th>
						        <div class="well well-sm" >
								  <center> <img alt="" style="width: 20px; height: 20px;" src="images/ress/wood-icon.png"> Wood: <b>${player.wood}</b></center>
								</div>			
							</th>
							<th>
						        <div class="well well-sm" >
								  <center> <img alt="" style="width: 20px; height: 20px;" src="images/ress/stone-icon.png"> Stone: <b>${player.stone}</b></center>
								</div>			
							</th>
							<th>
						        <div class="well well-sm" >
								  <center> <img alt="" style="width: 20px; height: 20px;" src="images/ress/food-icon.png"> Food: <b>${player.food}</b></center>
								</div>		
							</th>
							<th>
						        <div class="well well-sm" >
								  <center> <img alt="" style="width: 20px; height: 20px;" src="images/ress/gold-icon.png"> Gold: <b>${player.gold} </b></center>
								</div>			
							</th>
						</tr>
					</thead>
				</table>
			</div>
		 </div>
	</div>
<!--  end of container -->
	<%@include file="includes/bootstrapJs.jsp"%>
</body>
</html>