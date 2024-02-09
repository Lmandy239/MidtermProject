<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Recipe List</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/stylesheet.css">

</head>
<style>
ul {
	list-style-type: none;
	padding: 0;
}

li {
	list-style-type: none;
	text-align: left;
	margin-bottom: 0px;
	padding: 0;
}
</style>
<body>

	<div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
		<div class="card card0 border-0">
			<div class="row d-flex justify-content-center align-items-center">
				<form action="logout.do" method="POST"
					class="d-flex justify-content-end">
					<button type="submit" class="btn btn-blue text-center">Log
						out</button>
				</form>
				<div class="col-lg-6">
					<div class="card1 pb-5">
						<br>
						<div class="col-md-6 offset-md-3 text-center">
							<h2>Recipe List</h2>
						</div>
						<br>
						<hr>

						<div class="row">
							<c:forEach var="recipe" items="${recipes}" varStatus="loopStatus">
								<div class="col-md-4">
									<a href="showRecipe.do?recipeId=${recipe.id}"
										class="link-button">
										<li class="text-left">${recipe.name}</li>
									</a>
								</div>

								<c:if test="${loopStatus.index % 3 == 2}">
						</div>
						<div class="row">
							</c:if>
							</c:forEach>
						</div>

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
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>

