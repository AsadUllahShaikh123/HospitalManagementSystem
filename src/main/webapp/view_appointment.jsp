<%@page import="com.entities.User"%>
<%@page import="com.entities.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entities.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.AppointmentDao"%>
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
<%@include file="components/allCss.jsp"%>
<style>
.backImg {
	background-image: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital.jpg");
	height: 40vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

.point-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<c:if test="${ empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<div class="container-fluid p-5 backImg">
		<p class="text-center fs-2 text-white"></p>
	</div>

	<div class="container-fluid p-4 border">
		<div class="row">
			<div class="col-md-9">
				<div class="card point-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("userObj");
								AppointmentDao dao = new AppointmentDao();
								DoctorDao dao2 = new DoctorDao();
								List<Appointment> list = dao.getAllAppointmentByLoginUser(user.getId());
								System.out.println("user id " + user.getId());
								for (Appointment app : list) {
									Doctor doctor = dao2.getDoctorById(app.getDoctorId());
								%>
								<tr>
									<td><%=app.getFullName()%></td>
									<td><%=app.getGender()%></td>
									<td><%=app.getAge()%></td>
									<td><%=app.getAppointDate()%></td>
									<td><%=app.getDiseases()%></td>
									<td><%=doctor.getFullName()%></td>
									<td>
										<%
										if ("pending".equals(app.getStatus())) {
										%>
										<a href="#" class="btn btn-sm btn-warning">pending</a>
										<%
										} else {
										%>
											<%=app.getStatus()%>
										<%
										}
										%>
									</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="col-md-3 pe-3 ">
				<img alt="doctorImage" src="img/doc5.png" width="100%" height="100%" />
			</div>

		</div>
	</div>


</body>
</html>