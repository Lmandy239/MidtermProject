<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page
	import="com.skilldistillery.reciperecommender.entities.Ingredient"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<meta charset="UTF-8">
<title>Favorites Page</title>
</head>
<body>
	<h1>Your Favorite Recipes</h1>
	<div class="favorite-recipes">
		<div class="container mt-4">
			<div class="row justify-content-center">
				<div class="col-lg-12 text-center">
					<c:choose>
						<c:when test="${! empty favoritedRecipe}">
							<ol>
								<li>${favoritedRecipe.name}</li>
							</ol>
						</c:when>
						<c:otherwise>
							<h4>No Favorite Recipes</h4>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<a href="showRecipe.do">Choose A Different Recipe</a>
	<br>
	<br>
	<br>
	<br>
	<a href="showRecipe.do">Ingredient Selection</a>
	<br>
	<br>
	<br>
	<br>
	<a href="home">Logout</a>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>