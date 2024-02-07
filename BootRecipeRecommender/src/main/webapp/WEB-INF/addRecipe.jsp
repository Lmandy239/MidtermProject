<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Recipe</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/stylesheet.css">

</head>
<body>


	<div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
		<div class="card card0 border-0">
			<div class="row d-flex justify-content-center align-items-center">
				<div class="col-lg-6">
					<div class="card1 pb-5">
						<div class="col-md-6 offset-md-3 text-center">
							<h2>Add your own recipe</h2>
							<form action="addRecipe.do" method="POST">
								<div class="mb-3">
									<label for="recipeName" class="form-label">Recipe Name</label>
									<input type="text" class="form-control" id="recipeName"
										name="name">
								</div>
								<div class="mb-3">
									<label for="recipeIngredients" class="form-label">Recipe
										Ingredients</label> <input type="text" class="form-control"
										id="recipeIngredients" name="ingredientDescription">
								</div>
								<div class="mb-3">
									<label for="recipeDescription" class="form-label">Recipe Description</label>
									<input type="text" class="form-control" id="recipeDescription"
										name="description">
								</div>
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
