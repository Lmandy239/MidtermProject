<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Registration</title>
</head>
<body>

	<form action="registerResult.do" method="POST">

		<label for="username">Set username: </label> <input type="text"
			name="username" value="${username}" required> <br> 
		<label for="password">Set password: </label> <input type="text"
			name="password" value="${password}" required> <br> 
			<input type="submit" value="Create new user">
	</form>
	<br>
	<a href="home">Return to Login</a>


</body>
</html>