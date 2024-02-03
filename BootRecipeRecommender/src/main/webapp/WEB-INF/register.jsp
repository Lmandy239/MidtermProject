<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Registration</title>
<style>
body {
	background-color: #ffffff;
	color: #1A237E;
	text-align: center;
	padding: 50px;
}

form {
	margin: 0 auto;
	width: 300px;
}

label {
	display: block;
	margin-bottom: 10px;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
}

input[type="submit"] {
	background-color: #1A237E;
	color: #ffffff;
	cursor: pointer;
}
</style>
</head>
<body>

	<form action="registerResult.do" method="POST">
		<label for="username">Enter your username </label> <input type="text"
			name="username" value="${username}" required> <br> <label
			for="password">Enter your password </label> <input type="text"
			name="password" value="${password}" required> <br> <input
			type="hidden" name="role" value="user"> <input type="hidden"
			name="enabled" value="1"> <input type="submit"
			value="Create new user">
	</form>
	<br>
	<a href="home">Return to Login</a>

</body>
</html>