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
<%@include file="../components/allCss.jsp"%>
<style type="text/css">
.card-paint {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${ empty doctorObj}">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<div class="container p-4">
		<div class="row">

			<div class="col-md-4">
				<div class="card card-paint">
					<p class="text-center fs-3 fw-bold">Change Password</p>
					<c:if test="${ not empty succMsg }">
						<p class="text-center text-success fs-3">${ succMsg }</p>
						<c:remove var="succMsg" scope="session" />
					</c:if>
					<c:if test="${ not empty errorMsg }">
						<p class="text-center text-danger fs-3">${ errorMsg }</p>
						<c:remove var="errorMsg" scope="session" />
					</c:if>
					<div class="card-body">
						<form action="../change_doctor_password" method="post">
							<div class="mb-3">
								<label>Enter New Password</label> <input type="text"
									name="newPassword" class="form-control" required />
							</div>
							<div class="mb-3">
								<label>Enter Old Password</label> <input type="text"
									name="oldPassword" class="form-control" required />
							</div>
							<input type="hidden" value="${doctorObj.id}" name="d_id" />
							<button class="btn btn-success col-md-12">Change
								Password</button>
						</form>
					</div>
				</div>
			</div>

			<div class="col-md-5 offset-md-2">
				<div class="card card-paint">
					<div class="card-body">
						<p class="text-center fs-3 fw-bold">Edit Profile</p>
						<c:if test="${ not empty succMsgd }">
						<p class="text-center text-success fs-3">${ succMsgd }</p>
						<c:remove var="succMsgd" scope="session" />
					</c:if>
					<c:if test="${ not empty errorMsgd }">
						<p class="text-center text-danger fs-3">${ errorMsgd }</p>
						<c:remove var="errorMsgd" scope="session" />
					</c:if>
						<form action="../edit_doctor_profile" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullName" class="form-control" value="${ doctorObj.fullName }"/>
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control" value="${ doctorObj.date }" />
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" name="qualification" class="form-control" value="${ doctorObj.qualification }" />
							</div>

							<div class="mb-3">
								<label class="form-label">Specialist</label> <select
									name="specialist" required class="form-control">
									<option>${ doctorObj.specialist }</option>
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
									readonly required name="email" class="form-control" value="${doctorObj.email }" />
							</div>
							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobile" class="form-control" value="${doctorObj.mobile }"/>
							</div>
							<input type="hidden" name="id" value="${ doctorObj.id }"/>
							<button type="submit" class="btn btn-primary">Update</button>
						</form>
					</div>
				</div>
			</div>

		</div>
	</div>




</body>
</html>

<%
/**


		*/
%>



