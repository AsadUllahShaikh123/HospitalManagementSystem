<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- By Default Expression Language is ignored in JSP  --%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor Page</title>
<%@include file="components/allCss.jsp"%>

</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<%--- Form  --%>

	<div class="container p-5">
		<div class="row justify-content-center">
			<div class="col-md-4">
				<div class="card shadow border-0">
					<div class="card-body">
						<p class="fs-4 text-center">Doctor Login</p>
						<c:if test="${ not empty errorMsg }">
							<p class="text-center fs-3 text-danger">${ errorMsg }</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${ not empty succMsg }">
							<p class="text-center fs-3 text-success">${ succMsg }</p>
							<c:remove var="succMsg" scope="session"/>
						</c:if>
						<form action="doctor_login" method="post">
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input required
									name="email" type="email" class="form-control" />
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control" />
							</div>

							<button type="submit" class="btn bg-primary text-white col-md-12">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>