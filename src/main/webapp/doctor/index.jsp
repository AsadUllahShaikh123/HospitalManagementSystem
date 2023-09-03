<%@page import="com.entities.Doctor"%>
<%@page import="com.db.DbConnection"%>
<%@page import="com.dao.CountDao"%>
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
	<c:if test="${ empty doctorObj }">
		<p>Redirecting not working</p>
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<p class="text-center fs-3 fw-bold mt-2">Doctor Dashboard</p>

	<%   CountDao dao = new CountDao(DbConnection.getConnection());
		 Doctor doctor = (Doctor)session.getAttribute("doctorObj");
		 int doctorCount = dao.countAppointmentByDoctorId(doctor.getId());
	%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-2">
				<div class="card card-paint">
					<div class="card-body text-center text-success">
						<i class="fas fa-user-md fa-3x"></i><br/>
						<p class="fs-4 text-center">Doctor<br/> <%= dao.countDoctor() %></p>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card card-paint">
					<div class="card-body text-center text-success">
						<i class="far fa-calendar-check fa-3x"></i>
						<br>
						<p class="fs-4 text-center">Total Appointment <br><%= doctorCount %> </p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>