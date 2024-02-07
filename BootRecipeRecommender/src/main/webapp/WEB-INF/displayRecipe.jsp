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
<title>Recipe List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
	<div class="container mt-4">
		<div class="row">
			<c:forEach items="${topRecipes}" var="recipe" varStatus="loop">
				<div class="col-lg-4 col-md-6 col-sm-12 mb-4">
					<form action="showRecipe.do" method="POST">
						<!-- Hidden input to pass recipe ID or any other data -->
						<input type="hidden" name="recipeId" value="${recipe.id}">
						<div class="card">
							<button type="submit" class="card-button">
								<img
									src="${pageContext.request.contextPath}/images/food_images/${recipe.image}.jpg"
									alt="${recipe.name}" class="card-img-top">
							</button>
							<div class="card-body">
								<h5 class="card-title overflow-text">${recipe.name}</h5>
							</div>
						</div>
					</form>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>