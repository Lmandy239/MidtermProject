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
<link rel="stylesheet" href="css/stylesheet.css">


<meta charset="UTF-8">
<title>My Recipe Book Page</title>
</head>
<body class="my-recipebook">

	 
	<div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
		<div class="card card0 border-0">
			<div class="row d-flex justify-content-center">
				<form action="logout.do" method="POST"
					class="d-flex justify-content-end">
					<button type="submit" class="btn btn-blue text-center">Log
						out</button>
				</form>
				<div class="row">
					<img src="images/logoSpark.png" class="logo">
					<div class="favorite-header">
						<h1>${user.username}'s Recipe Book</h1>
					</div>
				</div>
				<div class="container mt-4">
					<div class="row">
						<c:choose>
							<c:when test="${!empty user.getFavoriteRecipes()}">
								<c:forEach var="recipe" items="${user.getFavoriteRecipes()}">
									<div class="col-lg-4 col-md-6 col-sm-12 mb-4">
										<form action="showRecipe.do" method="POST">
											<!-- Hidden input to pass recipe ID or any other data -->
											<input type="hidden" name="recipeId" value="${recipe.id}">
											<div class="card">
												<button type="submit" class="card-button">
    							<c:choose>
       							 <c:when test="${empty recipe.image}">
           						 <img src="${pageContext.request.contextPath}/images/food_images/default.jpg" alt="Default Image" class="card-img-top" style="height: 250px; width: 300px;">
        						</c:when>
       							 <c:otherwise>
            					<img src="${pageContext.request.contextPath}/images/food_images/${recipe.image}.jpg" alt="${recipe.name}" class="card-img-top" style="height: 250px; width: 300px;">
									</c:otherwise>
    								</c:choose>
									</button>
												<div class="card-body">
													<h5 class="card-title overflow-text">${recipe.name}</h5>
													<h6 class="card-title overflow-text">Date added:
														${recipe.createDate}</h6>
												</div>
											</div>
										</form>
									</div>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="emptyRecipe">
									<h4>Your recipe book is empty!</h4>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<br>

				<div class="favorite-links">
					<div class="col-md-4 mx-auto  text-center find-recipe">
						<form action="rerouteToPantry.do" method="POST">
							<button type="submit" class="btn btn-blue btn-block w-100">Choose
								Different Ingredients</button>
						</form>
					</div>
					<br>
				</div>
				<div class="container">
					<div class="bg-blue py-4">
						<div class="row px-3">
							<small class="ml-4 ml-sm-5 mb-2">Copyright &copy; SD 42
								JUNIT-SPARK.</small>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>