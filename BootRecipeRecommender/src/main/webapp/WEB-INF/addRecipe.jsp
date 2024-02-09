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
<style>
.logo {
	height: 150px;
}

.colored-block {
	background-color: #e0e0e0;
	height: 150px;
	/* 	width: 600px; */
}

.scroll-container {
	overflow: auto;
	margin-top: 5px;
	margin-bottom: 5px;
	margin-right: 10px;
	margin-left: 10px;
}
</style>
</head>
<body>
	<div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
		<div class="card card0 border-0">
			<div class="row d-flex">
				<form action="logout.do" method="POST"
					class="d-flex justify-content-end">
					<button type="submit" class="btn btn-blue text-center">Log
						out</button>
				</form>
				<!-- Search Ingredients Column -->
				<div class="row">
					<img src="images/logoSpark.png" class="logo">
				</div>
				<div class="col-lg-6">
					<h3 class="text-center">Search Ingredient</h3>
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<form action="searchIngredientFromStore.do" method="GET"
								class="d-flex">
								<input class="form-control mr-2" type="text"
									name="searchResults" placeholder="Search for Ingredient"
									required> <input type="hidden" name="formSource"
									value="addRecipe">
								<button type="submit" style="outline: none !important;">Search</button>

							</form>
							<!-- 							<form action="searchIngredientFromStore.do" method="GET">
								<input class="mb-4 form-control" type="text"
									name="searchResults" placeholder="Search for Ingredient"
									required> <input type="hidden" name="formSource"
									value="addRecipe"> <input type="submit" value="Search">
							</form>
 -->

							<h3 class="text-center">Search Results:</h3>
							<div class="colored-block scroll-container text-center">
								<ul class="ingredient-list">
									<c:forEach var="ingredient" items="${ingredients}">
										<form action="addIngredientToRecipe.do" method="GET">
											<li class="d-flex justify-content-between align-items-center">
												${ingredient.name} <input type="hidden" name="id"
												value="${ingredient.id}">
												<button type="submit" class="btn btn-success">+</button>
											</li>
										</form>
									</c:forEach>
								</ul>
							</div>

							<!-- Recipe Ingredients Column -->
							<h3 class="text-center">Recipe Ingredients:</h3>
							<div class="colored-block scroll-container pb-10">
								<ul class="ingredient-list">
									<c:forEach var="ingredient" items="${tempIngredientList}">
										<form action="removeIngredientFromRecipe.do" method="GET">
											<li class="d-flex justify-content-between align-items-center">
												${ingredient.name} <input type="hidden" name="id"
												value="${ingredient.id}">
												<button type="submit" class="btn btn-danger">-</button>
											</li>
										</form>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!--  Remainder of Form -->
				<div class="col-lg-6  ">

					<form id="recipeForm" action="addRecipe.do" method="POST">
						<div class="col-lg-10 mb-3 mx-auto">
							<div class="d-flex flex-column align-items-center">
								<label for="recipeName" class="form-label h3 text-center">Recipe
									Name</label> <input
									placeholder="Herb-Infused Lemon Chicken with Roasted Vegetables"
									type="text" class="form-control" id="recipeName"
									name="recipeName">
							</div>
						</div>
						<br>
						<div class="col-lg-10 mb-3 mx-auto">
							<div class="d-flex flex-column align-items-center">
								<label for="recipeDescription" class="form-label h3 text-center">Preparation
									Instruction</label>
								<textarea class="form-control" id="recipeDescription"
									name="recipeDescription" rows="5"
									placeholder="To make Herb-Infused Lemon Chicken with Roasted Vegetables, start by preheating the oven to 400°F (200°C). In a small bowl, mix together chopped herbs such as rosemary, thyme, and parsley with lemon zest and a drizzle of olive oil..."></textarea>
							</div>
						</div>


						<!-- Hidden input field -->
						<input type="hidden" id="tempIngredientList"
							name="tempIngredientList" value="${tempIngredientList}">
				</div>
				<div class="row justify-content-center">
					<div class="col-md-4 text-center">
						<button type="submit" class="btn btn-blue btn-block w-100">Add
							Recipe</button>
					</div>
				</div>
				</form>
				<br> <br>
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
</body>

</html>
