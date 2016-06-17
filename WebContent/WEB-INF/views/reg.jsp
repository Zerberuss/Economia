<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="includes/bootstrapMeta.jsp" />
<title>Registration</title>
<jsp:include page="includes/bootstrapCss.jsp" />
</head>
<body>
	<div class="container" role="main">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">

				<form:form action="regSuccess" method="post"
					commandName="userForm">
					<table border="0">
						<tr>

							<td colspan="2" align="center"><h2>Registration</h2></td>
						</tr>
						<tr>
							<td><label for="inputUsername" class="sr-only">Username</label>
								<input type="text"  class="form-control"
								placeholder="Username" required autofocus name="username">
							</td>
						</tr>
						<tr>

							<td><label for="inputEmail" class="sr-only">Email</label> <input
								type="text"  class="form-control" placeholder="E-mail"
								required autofocus name="email"></td>
						</tr>
						<tr>
							<td><label for="inputPassword" class="sr-only">Password</label>
								<input type="password" class="form-control"
								placeholder="Password" required autofocus name="password"></td>
						</tr>


						<td><form action="processRegistration" method="get">
								<input type="submit" class="btn btn-lg btn-primary btn-block"
									value="Register now!" />
							</form></td>
						</tr>
					</table>


				</form:form>
			</div>
		</div>
	</div>

</body>
</html>