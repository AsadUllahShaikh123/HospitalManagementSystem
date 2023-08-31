<%@page import="com.entities.Doctor"%>
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
	<c:if test="${ empty doctorObj }">
		<p>Redirecting not working</p>
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-paint">
					<div class="card-body">
						<p class="text-center fs-2 fw-bold">Patient Details</p>
						<c:if test="${ not empty errorMsg }">
							<p class="text-center fs-3 text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${ not empty SuccMsg }">
							<p class="text-center fs-3 text-success">${ succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>


						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appointment Date</th>
									<th scope="col">Email</th>
									<th scope="col">Mobile</th>
									<th scope="col">Disease</th>
									<th scope="col">Status</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								Doctor doctor = (Doctor) session.getAttribute("doctorObj");
								AppointmentDao dao = new AppointmentDao();
								List<Appointment> list = dao.getAllAppointmentByDoctorUser(doctor.getId());
								for (Appointment app : list) {
								%>
								<tr>
									<td><%=app.getFullName()%></td>
									<td><%=app.getGender()%></td>
									<td><%=app.getAge()%></td>
									<td><%=app.getAppointDate()%></td>
									<td><%=app.getEmail()%></td>
									<td><%=app.getPhoneNo()%></td>
									<td><%=app.getDiseases()%></td>
									<td><%=app.getStatus()%></td>
									<td> 
										<a href="comment.jsp" class="btn btn-sm btn-success">Comment</a>
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
		</div>
	</div>

</body>
</html>