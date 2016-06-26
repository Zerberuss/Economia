<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/bootstrapMeta.inc"%>
<title>Economia Trade Ressources</title>
<%@include file="includes/bootstrapCss.css"%>
<%@include file="includes/treeView.css"%>


<body class="" sytle="">
	<div class="row">
		<div class="col-md-12">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="container">
					<div class="navbar-header">
						 <p class="navbar-text"><font color=#ee4d2e><b>Economia</b></font></p>
					</div>
					
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li>
								<a href="list">My Castle</a>
							</li>
							<li>
								<a href="buildings">Buildings</a>
							</li>
							<li>
								<a href="recruits">Recruits</a>
							</li>
							<li class="active">
								<a href="trade">Trade</a>
							</li>
							<li>
								<a href="fight">Fight</a>
							</li>
	
							
	
						</ul>
						
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a class="btn btn-info" href="history"><font color=#fff>History</font></a>
							</li>
							<li>
							`
							</li>
							<li>
								<a class="btn btn-danger" href="logout"><font color=#fff>Logout</font></a>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</div>
				
	<div class="container" role="main">
		<div class="jumbotron">
			<h2>Trade your resources!</h2>
	
			<c:if test="${not empty errorMessage}">
				<div class="alert alert-danger" role="alert">${errorMessage}</div>
			</c:if>
			<!--  Error message ----------------------------------------------------------- -->
	
			<!--  Warning message ----------------------------------------------------------- -->
			<c:if test="${not empty warningMessage}">
				<div class="alert alert-warning" role="warning">
					${warningMessage}</div>
			</c:if>
			<!--  Warning message ----------------------------------------------------------- -->
	
			<!--   message ----------------------------------------------------------- -->
			<c:if test="${not empty message}">
				<div class="alert alert-success" role="warning">${message}</div>
			</c:if>
	        
	        <img align=right alt=""
			style="width: 250px; height:150px;"
			src="images/bigPics/market.png">
			
			<p>
				Become a dealers and sell your goods to the rest of the world.
			</p>
			<br>
			
			
			<div class="row">
	          <div class="col-lg-6">
	            <div class="well bs-component">
	              <form class="form-horizontal" method="post" action="${formAction}">
					<fieldset>
						<!-- Form Name -->
						<legend>Make an offer they can't refuse:</legend>
						<br>
						<!-- Appended Input-->
						<div class="col-md-1"></div>
						<h4>Your resources:</h4>
						

						<div class="form-group">
						  <div class="col-md-7">
						    <div class="input-group">
						      <input id="trade.player" name="player" class="form-control" min=0 type="hidden" value="<c:out value="${player.username}"/>"> <!-- hidden -->
						    </div>
						  </div>
						</div>
						<%-- <div class="form-group">
						  <div class="col-md-7">
						    <div class="input-group">
						      <input id="trade.date" name="player" class="form-control" min=0 type="date" value="<c:out value="${date}"/>"> <!-- hidden -->
						    </div>
						  </div>
						</div> --%>
						
						<div class="form-group">
						  <label class="col-md-3 control-label" for="wood"></label>
						  <div class="col-md-7">
						    <div class="input-group">
						      <input id="trade.wood" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="wood" class="form-control" placeholder="0" min=0 type="number" value="<c:out value="${trade.wood}"/>">
						      <span class="input-group-addon">Wood</span>
						    </div>
						  </div>
						</div>
						<!-- Appended Input-->
						<div class="form-group">
						  <label class="col-md-3 control-label" for="stone"></label>
						  <div class="col-md-7">
						    <div class="input-group">
						      <input id="trade.stone" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="stone" class="form-control" placeholder="0" min=0 type="number" value="<c:out value="${trade.stone}"/>">
						      <span class="input-group-addon">Stone</span>
						    </div>
						    
						  </div>
						</div>
						<!-- Appended Input-->
						<div class="form-group">
						  <label class="col-md-3 control-label" for="food"></label>
						  <div class="col-md-7">
						    <div class="input-group">
						      <input id="trade.food" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="food" class="form-control" placeholder="0" min=0 type="number" value="<c:out value="${trade.food}"/>">
						      <span class="input-group-addon">Food</span>
						    </div>
						    
						  </div>
						</div>
						<div class="row"></div>
						<br>
						<!-- Appended Input-->
						<div class="col-md-5">
						<h4>Sell them for:</h4>
						</div>
						<div class="form-group">
						  <label class="col-md-5 control-label" for="appendedtext"></label>
						  <div class="col-md-6">
						    <div class="input-group">
						      <input id="trade.price" onkeypress='return event.charCode >= 48 && event.charCode <= 57' name="price" class="form-control" placeholder="0" min=0 type="number" value="<c:out value="${trade.price}"/>">
						      <span class="input-group-addon">Gold</span>
						    </div>
						    
						  </div>
						</div>
						<br>
						<div align="right">
							<button type="submit" class="btn btn-success btn-large">Create</button>
						</div>
						<h5>
							With create your offered resources aren't available anymore.
						</h5>
							
						</fieldset>
						</form>
					</div>
				</div>
			
			
			<div class="col-lg-6 col-lg-offset-0">
	
				
				

				
				<h3>Your offers</h3>

				
				<table data-toggle="table" class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Wood <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/wood-icon.png"></th>
							<th>Stone<img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/stone-icon.png"></th>
							<th>Food<img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/food-icon.png"></th>
							<th>Price <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/gold-icon.png"></th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${myOffers}" var="myOffer">
							<tr>
<%-- 								<td>
								<fmt:formatDate value="${myOffer.date}"
									pattern="dd.MM.yyyy" /></td> --%>
								<td>${myOffer.id}</td>
								<td>${myOffer.wood}</td>
								<td>${myOffer.stone}</td>
								<td>${myOffer.food}</td>
								<td>${myOffer.price}</td>
								<td> 
									<a href="tradeDelete?id=${myOffer.id}"><button type="button"
										class="btn btn-danger">Delete</button></a>
								</td> 
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		
	

				
	
			<br>
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<h3>Offers:</h3>
					<table data-toggle="table" data-pagination="true" data-search="true" class="table table-striped">
						<thead>
							<tr>
								<th>Id</th>
								<th>Player</th>
								<th>Wood <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/wood-icon.png"></th>
								<th>Stone<img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/stone-icon.png"></th>
								<th>Food<img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/food-icon.png"></th>
								<th>Total Cost <img alt=""
											style="width: 35px; height: 35px;"
											src="images/ress/gold-icon.png"></th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${offers}" var="offer">
								<tr>
<%-- 									<td>
									<fmt:formatDate value="${offer.date}"
										pattern="dd.MM.yyyy" /></td> --%>
									<td>${offer.id}</td>
									<td>${offer.player.username}</td>
									<td>${offer.wood}</td>
									<td>${offer.stone}</td>
									<td>${offer.food}</td>
									<td>${offer.price}</td>
									<td>
									<a href="tradeBuy?id=${offer.id}"><button type="button"
											class="btn btn-success">buy</button></a>
									</td> 
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
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