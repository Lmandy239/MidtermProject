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
							</div>
<<<<<<< HEAD
						</c:forEach>
					</div>
				</div>
				<div class="row mb-3 px-3">
					<div class="col-md-4 offset-md-4 text-center">
						<form action="rerouteToPantry.do" method="POST">
							<button type="submit" class="btn btn-blue btn-block w-100">Choose
								Different Ingredients</button>
						</form>
					</div>
					<div class="col-md-4 offset-md-4 text-center">
						<form action="getAllFavorites.do" method="POST">
							<button type="submit" class="btn btn-blue btn-block w-100">My
								Recipe Book</button>
						</form>
					</div>
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


=======
						</div>
					</form>
				</div>
			</c:forEach>
>>>>>>> 978a06d5318789fc0d25567e0277d99e3686384c
		</div>
	</div>
</body>
</html>