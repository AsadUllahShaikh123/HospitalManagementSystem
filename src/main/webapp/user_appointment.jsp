<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- By Default Expression Language is ignored in JSP  --%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.backImg {
	background: liner-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>

	<%@include file="components/navbar.jsp"%>
	<div class="container-fluid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 p-5">
				<img alt="" src="img/doc5.png" />
			</div>

			<div class="col-md-6">
				<div class="card shadow">
					<div class="card-body">
						<p class="text-center fs-3">User Appointment</p>
						<c:if test="${ not empty errorMsg }">
							<p class="text-center fs-4 text-danger">${ errorMsg }</p>
							<c:remove var="errorMsg" scope ="session"/>
						</c:if>
						
						<c:if test="${ not empty succMsg }">
							<p class="text-center fs-4 text-success">${ succMsg }</p>
							<c:remove var="succMsg" scope="session"/>
						</c:if>
						
						<form class="row" action="add_appoint" method="post">
							
							x
						
						</form>
					</div>
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>











