<%@page import="com.entities.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DoctorDao"%>
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
.backImg{
	background-image: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital.jpg");
	height: 40vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
<%@include file="components/allCss.jsp" %>
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
							<c:remove var="errorMsg" scope="session" />
						</c:if>

						<c:if test="${ not empty succMsg }">
							<p class="text-center fs-4 text-success">${ succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<form class="row g-3" action="add_appointment" method="post">

							<input type="hidden" name="userId" value="${userObj.id }" />
							<div class="col-md-6">
								<label class="form-label">FullName</label> <input required
									type="text" class="form-control" name="fullName" />
							</div>
							<div class="col-md-6">
								<label class="form-label">Gender</label> <select
									class="form-control" name="gender" required>
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>
							</div>
							<div class="col-md-6">
								<label class="form-label">Age</label> <input type="number"
									class="form-control" name="age" />
							</div>
							<div class="col-md-6">
								<label class="form-label">Appointment Date</label> <input
									type="date" class="form-control" required name="appoint_date" />
							</div>
							<div class="col-md-6">
								<label class="form-label">Email</label> <input type="email"
									required class="form-control" name="email" />
							</div>
							<div class="col-md-6">
								<label class="form-label">Phone NO</label> <input type="number"
									required class="form-control" name="phone" />
							</div>
							<div class="col-md-6">

								<label class="form-label">Diseases</label> <input type="text"
									required class="form-control" name="diseases" />
							</div>

							<div class="col-md-6">
								<label class="form-label">Doctor</label> <select required
									class="form-control" name="doctor">
									<option value="">--Select--</option>
									
									<%
										DoctorDao dao = new DoctorDao();
										List<Doctor> list = dao.getAllDoctors();
										for(Doctor d : list){			
									%>	
										<option value="<%= d.getId()%>"><%=d.getFullName()%>
										 (<%= d.getSpecialist() %>)
										</option>
									<%} %>
									
									
								</select>
							</div>
							<div class="col-md-12">
								<label class="form-label">Full Address</label>
								<textarea required name="address" class="form-control" rows="3"
									cols=""></textarea>
							</div>
							<c:if test="${ empty userObj }">
								<a href="user_login.jsp" class="col-md-6 offset-md-3 mt-2 btn btn-success">Submit</a>
							</c:if>
							<c:if test="${ not empty userObj }">
								<button class="col-md-6 offset-md-3 mt-2 btn btn-success">Submit</button>
							</c:if>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>
</html>











