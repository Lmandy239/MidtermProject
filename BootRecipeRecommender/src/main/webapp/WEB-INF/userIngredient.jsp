<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Ingredient</title>

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
			<div class="row d-flex">
				<div class="col-lg-6">
					<div class="card1 pb-5">


						<div class="row">
							<img src="images/image6.png" class="logo">
						</div>


						<div class="row px-3 justify-content-center mt-4 mb-5 border-line">
							<div class="col-md-8 offset-md-2 text-center">

								<h3>User's Cart</h3>
								<p>test item/ingredient (- button to delete from this side)</p>
								<p>test item/ingredient (- button to delete from this side)</p>
								<p>test item/ingredient (- button to delete from this side)</p>
								<p>test item/ingredient (- button to delete from this side)</p>
								<p>test item/ingredient (- button to delete from this side)</p>
								<p>test item/ingredient (- button to delete from this side)</p>
								<p>test item/ingredient (- button to delete from this side)</p>
								<p>test item/ingredient (- button to delete from this side)</p>
								
							</div>
						</div>
					</div>
				</div>



				<div class="col-lg-6">
					<div class="card2 card border-0 px-4 py-5">
						<br> <br> <br> <br>

						<div class="col-md-6 offset-md-3 text-center">
							<h3>Enter Ingredient</h3>
						</div>

						<div class="row px-3">
							<form action="selectIngredient.do" method="POST">
								<label for="name" class="mb-1" class="mb-0 text-sm"></label> <input
									class="mb-4" type="text" name="name"
									placeholder="Search for Ingredient" required><br>
								<input type="submit" value="Search">
							</form>
						</div>

						<hr class="my-4">

						<div>
							<div class="info">
 							<div class="col-md-6 offset-md-3 text-center">
								
									
											<br>
											
											<h3>Matching Ingredients</h3>
											<br>
										<c:forEach items="${user.getIngredients()}" var="ingredient">

												${ingredient.name}<br>
											
										</c:forEach>
									
								</div>
								</div>
							</div>
						</div>
					</div>
				</div>


				<div class="row mb-3 px-3">
					<div class="col-md-6 offset-md-3 text-center">
						<button type="submit" class="btn btn-blue btn-block w-100">Find
							Recipe</button>
					</div>
					<br> <br> <br>

					<div class="bg-blue py-4">
						<div class="row px-3">
							<small class="ml-4 ml-sm-5 mb-2">Copyright &copy; SD 42
								JUNIT-SPARK.</small>

						</div>
					</div>
				</div>
			</div>
		</div>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script>





		<!-- 	<form action="removeIngredient.do" method="POST">
		<label for="name">Remove an Ingredient: </label> <input type="text"
			name="name"><br> <input type="submit"
			value="Remove Ingredient">
		</form> -->
</body>
</html>