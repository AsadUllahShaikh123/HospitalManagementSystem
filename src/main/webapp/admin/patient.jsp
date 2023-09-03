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
<%@include file="../components/allCss.jsp"%>
<style>
.card-paint {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="col-md-12 ">
		<div class="card card-paint">
			<div class="card-body">
				<p class="text-center fs-3 fw-bold">Patient Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor Name</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						AppointmentDao dao = new AppointmentDao();
						List<Appointment> list = dao.getAllAppointment();
						for (Appointment app : list) {
							DoctorDao d_dao = new DoctorDao();
							Doctor doctor = d_dao.getDoctorById(app.getDoctorId());
						%>
						<tr>
							<td><%= app.getFullName() %></td>
							<td><%= app.getGender() %></td>
							<td><%= app.getAge() %></td>
							<td><%= app.getAppointDate() %></td>
							<td><%= app.getEmail() %></td>
							<td><%= app.getPhoneNo() %></td>
							<td><%= app.getDiseases() %></td>
							<td><%= doctor.getFullName() %></td>
							<td><%= app.getAddress() %></td>
							<td><%= app.getStatus() %></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>