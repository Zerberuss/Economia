<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="includes/bootstrapMeta.inc"%>
<%@include file="includes/bootstrapCss.css"%>
<title>Registration</title>
<html>
<body>
	<div class="container" role="main">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">

				<form action="regProcess" method="post" modelAttribute="player">
					<h2 class="form-signin-heading">Please sign up</h2><br><br>
					<h3 class="form-signin-heading">Enter valid information and
						press the Sign up Button</h3>
					<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message != null}">
						<div class="alert alert-danger" role="alert">
							<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
						</div>
					</c:if>
					<input type="text" id="username" name="username"
						class="form-control" autofocus required placeholder="Username">
					<input type="text" id="email" name="email" class="form-control"
						autofocus required placeholder="e-Mail"> <input
						type="password" id="password" name="password" class="form-control"
						autofocus required placeholder="Password">

					<button type="submit" action="regProcess"
						class="btn btn-lg btn-primary btn-block">Sign up!</button>

				</form>
			</div>
		</div>
	</div>

</body>
</html>