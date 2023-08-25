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
			<div class="col-md-4 offset-md-4">
				<div class="card shadow">
					<div class="card-body">
						<p class="text-center fs-3">Edit Doctor Details</p>
						<c:if test="${ not empty succMsg }">
							<p class="text-center fs-3 text-success">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<c:if test="${ not empty errorMsg }">
							<p class="text-center text-danger fs-3">${ errorMsg }</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						
						<%
							int id = Integer.parseInt(request.getParameter("id"));
							DoctorDao dao2 = new DoctorDao();
							Doctor doctor = dao2.getDoctorById(id);
						%>
						<form action="../edit_doctor" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullName" class="form-control" value=<%=doctor.getFullName() %> />
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control" value=<%=doctor.getDate() %> />
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" name="qualification" class="form-control" value=<%=doctor.getQualification() %>>
							</div>

							<div class="mb-3">
								<label class="form-label">Specialist</label> <select
									name="specialist" required class="form-control">
									<option><%=doctor.getSpecialist() %></option>
									<%
									SpecialistDao dao = new SpecialistDao();
									List<Specialist> list = dao.getAllSpecialist();
									for (Specialist s : list) {
									%>
									<option><%=s.getSpecialistName()%></option>
									<%
									}
									%>
								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									required name="email" class="form-control" value=<%= doctor.getEmail() %> >
							</div>
							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobile" class="form-control" value=<%= doctor.getMobile() %>>
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input
									type="text" required name="password" class="form-control" value=<%=doctor.getPassword() %>>
							</div>
							<input type="hidden" name="id" value="<%= doctor.getId()%>"/>
							<button type="submit" class="btn btn-primary">Edit</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>