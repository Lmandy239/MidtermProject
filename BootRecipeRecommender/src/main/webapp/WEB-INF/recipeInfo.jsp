<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

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
<style>
        .comment {
	            margin-bottom: 20px;
	            padding: 10px;
	            border: 1px solid #ccc;
	            border-radius: 5px;
	        
}

        .comment p {
	            margin-bottom: 5px;
	        
}

        .comment p.username {
	            font-weight: bold;
	            color: #007bff;
	        
}

        #add-comment-form {
	            margin-top: 20px;
	        
}

        #add-comment-form textarea {
	            width: 100%;
	            max-width: 100%;
	            padding: 10px;
	            border-radius: 5px;
	            resize: vertical;
	        
}

        #add-comment-form input[type="submit"] {
	            margin-top: 10px;
	            padding: 10px 20px;
	            background-color: #007bff;
	            color: #fff;
	            border: none;
	            border-radius: 5px;
	            cursor: pointer;
	        
}

        #add-comment-form input[type="submit"]:hover {
	            background-color: #0056b3;
	        
}
    
</style>
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
					<c:if test="${!user.getFavoriteRecipes().contains(recipe)}">
						<form action="favoriteRecipe.do" method="POST">
							<input type="hidden" name="recipeId" value="${recipe.id}">
							<a href="favoriteRecipe.do?recipeId=${recipe.id}"><button
									class="btn btn-blue text-center">Like This Recipe</button></a>
						</form>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<c:if test="${user.getFavoriteRecipes().contains(recipe)}">
		<div class="favorite-button">
			<div class="container mt-4">
				<div class="row justify-content-center">
					<div class="col-lg-12 text-center">
						<form action="unfavoriteRecipe.do" method="POST">
							<input type="hidden" name="recipeId" value="${recipe.id}">
							<a href="unfavoriteRecipe.do?recipeId=${recipe.id}"><button
									class="btn btn-blue text-center">Unlike This Recipe</button></a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<br>
	<div class="favorite-button">
		<div class="container mt-4">
			<div class="row justify-content-center">
				<div class="col-lg-12 text-center">
					<form action="getAllFavorites.do" method="POST">
						<button class="btn btn-blue text-center">See Your Recipe
							Book</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	</div>
	</div>
	</div>
	</div>

	<h2>Comments</h2>

	<c:forEach items="${recipe.comments}" var="comment">
    <div class="comment">
			        
			<p class="username">Username: ${comment.user.username} Posted:
				${comment.comment}</p>
			    
		</div>
	</c:forEach>

	<form id="add-comment-form" action="addComment.do" method="POST">
		    
		<textarea name="content" rows="4" placeholder="Add a comment here"></textarea>
		<br>     <input type="hidden" name="recipeId"
			value="${recipe.id}">     <input type="hidden" name="userId"
			value="${user.id}">     <input type="submit"
			value="Submit Comment">
	</form>
</body>
</html>