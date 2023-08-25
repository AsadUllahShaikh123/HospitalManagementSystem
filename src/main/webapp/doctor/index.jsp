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
	<c:if test="${ empty doctorObj }">
	<p>Redirecting not working</p>
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>
    <p>The vlaue of obj is ${ doctorObj } here</p>
	<%@include file="navbar.jsp"%>
	<h1>Hello from Index inside Doctor</h1>
</body>
</html>