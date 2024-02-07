<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page
	import="com.skilldistillery.reciperecommender.entities.Ingredient"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center">
			<!-- Centering the row -->
			<div class="col-lg-12 text-center">
				<!-- Centering the column -->
				<h1 class="display-4">${recipe.name}</h1>
				<!-- Making the header larger -->
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="col-12 text-center">
				<img
					src="${pageContext.request.contextPath}/images/food_images/${recipe.image}.jpg"
					alt="${recipe.name}" class="img-fluid w-25">
			</div>
		</div>
	</div>
	<div class="container mt-4">
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<!-- Taking up the middle 50% of the screen on large devices (col-lg-6) -->
				<ul class="text-center display-3">
					<!-- Centering the list and making the bullet points larger -->
					<c:forEach items="${recipe.ingredientDescriptionList}"
						var="ingredient">
						<!-- Iterate over the list of ingredients -->
						<li>${ingredient}</li>
						<!-- Display each ingredient as a list item with a bullet point -->
					</c:forEach>
				</ul>
			</div>
			<div class="col-lg-10">
				<p class="display-4">${recipe.description}</p>
			</div>
		</div>
	</div>
	<div class="favorite-button">
		<div class="container mt-4">
			<div class="row justify-content-center">
				<div class="col-lg-12 text-center">
					<input type="hidden" name="recipeId" value="${recipe.id}">
					<a href="favoriteRecipe.do?recipeId=${recipe.id}"><button
							class="btn btn-blue text-center">Favorite This Recipe</button></a><br>
					<p class="display-4">${favoritedRecipe.name}</p>

				</div>
			</div>
		</div>
	</div>
</body>
</html>





