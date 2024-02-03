<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Ingredient</title>
</head>
<body>
	  <h2>Your Recipe</h2>

	<form action="selectIngredient.do" method="POST">
		<label for="name">Search for Ingredient: </label> <input type="text"
			name="name" required> <br> <input type="submit"
			value="Search Ingredient">
	</form>
	
	
	<c:choose>
	
		<c:when test="${! empty ingredients}">
			<form action="removeIngredient.do" method="POST">
				<label for="name">Remove an Ingredient: </label> <input type="text"
					name="name" value="${ingredients}"> <br> <input
					type="submit" value="Remove Ingredient">
			</form>
			<h4>Your Cart</h4>
			<c:forEach items="${ingredients}" var="ingredient">
				<ul>
					<li>${ingredient.name}</li>
				</ul>
			</c:forEach>
			<br>
		</c:when>
		<c:otherwise>
			<h4>Your cart is empty</h4>
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<br>

	<br>
	<br>
	<br>
	<a href="home">Return to Login</a>

</body>
</html>