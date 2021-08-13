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
			<div>
				<form action="/licenses/new" method="post">
					<p>Person List</p>
					<select name="person">
						<c:forEach items="${persons}" var="person">
				        	<option value="${person.id}"><c:out value="${person.firstName}"/><c:out value="${person.lastName}"/></option>
				        </c:forEach>
					</select>
					<label for="state">State Code<input type="text" name="state"/></label>
					<label for="expirationDate">Expiration Date<input type="date" name="expirationDate"/></label>
					<button class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>