<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container">
			<h1><c:out value="${person.firstName}"/><c:out value="${person.lastName}"/></h1>
			<table>
				<tr>
					<td>License Number: </td>
					<td><c:out value="${person.license.number}"/></td>
				</tr>
				<tr>
					<td>State</td>
					<td><c:out value="${person.license.state}"/></td>
				</tr>
				<tr>
					<td>Expiration Date</td>
					<td><c:out value="${person.license.expirationDate}"/></td>
				</tr>
			</table>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html> 