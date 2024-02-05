<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Ingredient</title>
</head>
<body>
	  
	<h2>Go Shopping</h2>

	<form action="selectIngredient.do" method="POST">
		<label for="name">Search for Ingredient: </label> <input type="text"
			name="name" required> <br> <input type="submit"
			value="Add Ingredient">
	</form>
	<form action="removeIngredient.do" method="POST">
		<label for="name">Remove an Ingredient: </label> <input type="text"
			name="name"><br> <input type="submit"
			value="Remove Ingredient">
	</form>
	<br>
	<br>
	<div class="info">
		<table>
			<tr id="th">
				<th>Your Cart</th>
			</tr>
			<c:forEach items="${user.getIngredients()}" var="ingredient">
				<tr>
					<td>${ingredient.name}</td>
				</tr>
			</c:forEach>
			<tr>
				<td>Cart size ${user.getIngredients().size()}</td>
			</tr>
		</table>
	</div>

	<br>
	<a href="home">Return to Login</a>

</body>
</html>