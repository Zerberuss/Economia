<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/bootstrapMeta.inc"%>
<title>Economia Recruits</title>
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
						<li><a href="buildings">Buildings</a></li>
						<li class="active"><a href="recruits">Recruits</a></li>
						<li><a href="trade">Trade</a></li>
						<li><a href="fight">Fight</a></li>



					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a class="btn btn-info" href="history"><font
								color=#fff>History</font></a></li>
						<li>`</li>
						<li><a class="btn btn-danger" href="logout"><font
								color=#fff>Logout</font></a></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
	</div>

	<div class="container">
		<div class="well">
			<br><br>
			<h2>Prepare for fight.</h2>
			<p>Drill militants to win against your enemys and save your
				castle</p>
			<c:if test="${errorRess != null}">
				<div class="alert alert-dismissible alert-danger">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Oh snap!</strong> <a href="#" class="alert-link">You
						have to less ressources.</a>
				</div>

			</c:if>
			<c:if test="${success != null}">

				<div class="alert alert-dismissible alert-success">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<strong>Well done!</strong> Your units have been added.<a
						href="#" class="alert-link"></a>.

				</div>
			</c:if>
			<h2>Your Recruits</h2>
			<div class="row">
				<div class="col-md-12">
					<form action="submitrecruits" method="get" modelAttribute="player">

						<div class="col-md-12">

							<table data-toggle="table"
								class="table table-striped table-hover">

								<thead>
									<tr>
										<th align="center" valign="middle">Icon</th>
										<th align="center" valign="middle">Name</th>
										<th align="center" valign="middle">Quantity</th>
										<th align="center" valign="middle">Attack <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/sword-icon.png"></th>
										<th align="center" valign="middle">Defense <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/shield-icon.png"></th>
										<th align="center" valign="middle">Accuracy <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/accuracy-icon.png"></th>
										
										<th align="center" valign="middle">Wood<img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/wood-icon.png"></th>
										<th align="center" valign="middle">Stone <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/stone-icon.png"></th>
										<th align="center" valign="middle">Food <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/food-icon.png"></th>
										<th align="center" valign="middle">Gold <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/gold-icon.png"></th>
										<th align="center" valign="middle">Add Units</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${recruits}" var="recruit">
										<tr>
											<td><img src="${recruit.icon}" align="center"
												alt="${recruit.name}-Icon" style="${recruit.size}"></td>
											<td><p class="coll-md-1">${recruit.name}</p></td>
											<td><p align="center" valign="middle">${recruit.count}</p></td>
											<td><p align="center" valign="middle">${recruit.attackPower}</p></td>
											<td><p align="center" valign="middle">${recruit.deffPower}</p></td>
											<td><p align="center" valign="middle">${recruit.accuracy}
												</p></td>
										
											<td><p align="center" valign="middle">${recruit.neededWood}</p></td>
											<td><p align="center" valign="middle">${recruit.neededStone}</p></td>
											<td><p align="center" valign="middle">${recruit.neededFood}</p></td>
											<td><p align="center" valign="middle">${recruit.neededGold}</p></td>
											<td><input align="center"
												onkeypress='return event.charCode >= 48 && event.charCode <= 57'
												valign="middle" type="text" placeholder="0" autofocus
												value="0" class="form-control" id="addUnits${recruit.name}"
												name="addUnit${recruit.unitID}"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<br>
							<button type="submit"
								class="btn btn-primary btn-success btn-lg pull-right"
								action="submitrecruits" autofocus>prepare troops for
								action</button>

							<hr>
						</div>

					</form>

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