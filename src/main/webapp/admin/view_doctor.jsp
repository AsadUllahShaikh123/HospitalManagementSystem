<%@page import="com.entities.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entities.Specialist"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.SpecialistDao"%>
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
</head>
<body>
	<%@include file="navbar.jsp"%>

	<%-- Form --%>
	<div class="container-fluid p-3">
		<div class="row">
			<%-- Table --%>
			<div class="col-md-12">
				<div class="card shadow">
					<div class="card-body">
						<p class="text-center fs-3">Doctor Details</p>
						<c:if test="${ not empty succMsg }">
							<p class="text-center fs-3 text-success">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${ not empty errorMsg }">
							<p class="text-center text-danger fs-3">${ errorMsg }</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">FullName</th>
									<th scope="col">D.O.B</th>
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
									<%
										DoctorDao doctorDao = new DoctorDao();
										List<Doctor> list2 = doctorDao.getAllDoctors();
										for(Doctor d : list2){
									%>
										<tr>
											<td><%=d.getFullName() %></td>
											<td><%=d.getDate() %></td>
											<td><%=d.getQualification() %></td>
											<td><%=d.getSpecialist() %></td>
											<td><%=d.getEmail() %></td>
											<td><%=d.getMobile() %></td>
											<td>
												<a href="edit_doctor.jsp?id=<%=d.getId() %>" class="btn btn-sm btn-primary text-center">Edit</a>
												<a href="../delete_doctor?id=<%=d.getId() %>" class="btn btn-sm btn-danger">Delete</a>
											</td>
										</tr>
									<% } %>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>