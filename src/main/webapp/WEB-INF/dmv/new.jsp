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
		<title>New Person Entry</title>
	</head>
	<body>
		<div class="d-flex justify-content-center">
			<div class="container">
				<h1>New Person</h1>
				<form:form action="/persons/new" method="post" modelAttribute="person">
				    <p>
				        <form:label path="firstName">First Name</form:label>
				        <form:errors path="firstName" style="color:red;"/>
				        <form:input path="firstName" type="text"/>
				    </p>
				    <p>
				        <form:label path="lastName">Last Name</form:label>
				        <form:errors path="lastName" style="color:red;"/>
				        <form:textarea path="lastName"/>
				    </p>
				    <input type="submit" value="Submit"/>
				</form:form> 
				<h3 class="btn btn-primary"><a href="/licenses/new" class="text-light">Create a New License</a></h3>
			</div>
			<div class="container">
				<h1>All People in Database</h1>
				<table class="table">
				    <thead>
				        <tr>
				            <th>First Name</th>
				            <th>Last Name</th>
				        </tr>
				    </thead>
				    <tbody>
				        <c:forEach items="${persons}" var="person">
				        <tr>
				            <td><a href="/persons/${person.id}"><c:out value="${person.firstName}"/></a></td>
				            <td><c:out value="${person.lastName}"/></td>
				        </tr>
				        </c:forEach>
				    </tbody>
				</table>
			</div>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>