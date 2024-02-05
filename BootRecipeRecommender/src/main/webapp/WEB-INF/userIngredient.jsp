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

								<div class="pantry">
									<c:choose>
										<c:when test="${! empty user.getIngredients()}">
											<table>
												<tr id="th">
													<th>Your Pantry</th>
												</tr>

												<c:forEach items="${user.getIngredients()}" var="ingredient">
													<tr>
														<td><a class="btn"
															href="removeIngredientFromPantry.do?ingredient=${ingredient}">-</a>
															${ingredient}</td>
													</tr>
												</c:forEach>
											</table>
										</c:when>
										<c:otherwise>
											<h4>Your pantry is empty</h4>
										</c:otherwise>
									</c:choose>
								</div>
								<br> <a href="home">Return to Login</a> <br>
							</div>
						</div>
					</div>
				</div>



				<div class="col-lg-6">
					<div class="card2 card border-0 px-4 py-5">
						<br> <br> <br> <br>

						<div class="col-md-6 offset-md-3 text-center">
							<h3>Search Ingredient</h3>
						</div>

						<div class="row px-3">
							<form action="searchIngredientFromStore.do" method="POST">
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
									<div class="cart">
										<c:choose>
											<c:when test="${! empty ingredients}">
												<table>
													<tr>
														<th>Grocery Store Inventory</th>
													</tr>
													<c:forEach items="${ingredients}" var="ingredient">
														<tr>
															<td><a class="btn"
																href="populatePantry.do?itemToAdd=${ingredient}">+</a>
																${ingredient}</td>
														</tr>
													</c:forEach>
												</table>

											</c:when>
											<c:otherwise>
												<h4>Your cart is empty</h4>
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<br> <br>
				<div class="row mb-3 px-3">
					<div class="col-md-6 offset-md-3 text-center">
						<button type="submit" class="btn btn-blue btn-block w-100">Find
							Recipe</button>
						<small class="font-weight-bold">Or <a href="findall.do">Show all</a></small>
					</div>
					<br> <br>

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
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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

	<form action="searchIngredientFromStore.do" method="POST">
		<label for="name">Search for Ingredient: </label> <input type="text"
			name="name" required> <br> <input type="submit"
			value="Add Ingredient">
	</form>
	<br>
	<div class="cart">
		<c:choose>
			<c:when test="${! empty ingredients}">
				<table>
					<tr>
						<th>Grocery Store Inventory</th>
					</tr>
					<c:forEach items="${ingredients}" var="ingredient">
						<tr>
							<td><a class="btn"
								href="populatePantry.do?itemToAdd=${ingredient}">+</a>
								${ingredient}</td>
						</tr>
					</c:forEach>
				</table>

			</c:when>
			<c:otherwise>
				<h4>Your cart is empty</h4>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="pantry">
		<c:choose>
			<c:when test="${! empty user.getIngredients()}">
				<table>
					<tr id="th">
						<th>Your Pantry</th>
					</tr>

					<c:forEach items="${user.getIngredients()}" var="ingredient">
						<tr>
							<td><a class="btn"
								href="removeIngredientFromPantry.do?ingredient=${ingredient}">-</a>
								${ingredient}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h4>Your pantry is empty</h4>
			</c:otherwise>
		</c:choose>
	</div>

	<br>
	<a href="home">Return to Login</a>



	<br>
	<a href="generateRecipe.do">Find Recipe</a>

</body>
</html> --%>