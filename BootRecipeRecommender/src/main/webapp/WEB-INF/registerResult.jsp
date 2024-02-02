<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User Result</title>
</head>
<body>

	<c:if test="${not empty username}">
	<h2>Result of adding new User:</h2><br>
	<p>You have created a new User.</p>
	</c:if>
	
	<c:if test="${empty username}">
	<h2>Result of adding new User:</h2><br>
	<p>You were not able to create a new User.</p>
	</c:if>
	
			<a href="home">Return to home page</a>

</body>
</html>