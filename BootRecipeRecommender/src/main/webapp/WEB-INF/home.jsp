<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Hello World!
	<br>
	<br>
	<a href="register.do">Create new user</a>

	<div class="head">
		<form action="login.do" method="POST">
			<input type="text" name="username" /> <input type="text"
				name="password" /> <input type="submit" value="Login" />
		</form>
	</div>
</body>
</html>