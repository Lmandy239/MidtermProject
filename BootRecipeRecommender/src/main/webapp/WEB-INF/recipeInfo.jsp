<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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

.container-fluid {
    text-align: center;
}

.colored-block {
    background-color: #e0e0e0;
}

.scroll-container {
    height: 380px;
    overflow-y: auto;
}

.scroll-container2 {
    height: 160px;
    overflow-y: auto;
}

.find-recipe {
    /* margin-top: 20px; */
}

.section-divider {
    border-top: 1px solid #ccc;
    margin-top: 20px;
    margin-bottom: 20px;
}

.center-content {
    display: flex;
    justify-content: center;
    align-items: center;
}

h1 {
    font-size: 4rem;
    margin-bottom: 20px;
}

.card.comment {
    display: flex;
    justify-content: center;
    align-items: center;
}

.logo {
    height: 150px;
    width: auto;
    margin-bottom: 0;
}

.img-fluid {
    max-width: 80%;
    max-height: 600;
    margin_bottom: 20px;
}

/* Added CSS */
.ingredient-list {
    list-style-type: none;
    padding-left: 0;
    text-align: left;
}

.ingredient-list li {
    margin-bottom: 5px;
}

.ingredient-list-container {
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 10px;
    text-align: left;
}
 .card0 form {
      margin-top: -1px;
   }
</style>
</head>
<body>

<div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
    <div class="card card0 border-0">
 <form action="logout.do" method="POST"
        class="d-flex justify-content-end">
        <button type="submit" class="btn btn-blue text-center">Log
          out</button>
      </form>
       <!-- Top Section: Ingredient List -->
<div class="row d-flex justify-content-center">
    <div class="row">
        <img src="images/logoSpark.png" class="logo">
    </div>
    <div class="col-md-8">
        <div class="card1 pb-5">
            <div class="row px-3 justify-content-center mt-4 mb-5">
                <div class="col-md-12 text-center">
                    <h1>${recipe.name}</h1><br>
                    <img src="${pageContext.request.contextPath}/images/food_images/${recipe.image}.jpg" alt="${recipe.name}" class="image_fluid">
                </div>
            </div>
            <div class="row px-3 justify-content-center mb-5">
                <div class="col-md-12 text-center">
                    <div class="scroll-container">
                        <h3>${recipe.name} Ingredients Required</h3><br>
                        <div class="ingredient-list-container">
                            <ul class="ingredient-list">
                                <c:forEach var="ingredient" items="${recipe.ingredientDescriptionList}">
                                    <span>&#8226;</span> ${ingredient}<br>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
        <hr class="section-divider">
      <!-- Bottom Section: Recipe Description -->
<div class="row d-flex justify-content-center">
    <div class="col-md-8">
        <div class="card2 card border-0 px-4 py-5">
            <div class="row px-3 justify-content-center mt-4 mb-5">
                <div class="col-md-12 text-center">
                    <h3>${recipe.name} Instructions</h3>
                    <p>${recipe.description}</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Buttons Section -->
	<!-- <div class="row mb-3 px-3"> -->
			   <div class="col-md-4 offset-md-4 text-center">
			    <c:if test="${!user.getFavoriteRecipes().contains(recipe)}">
			        <form action="favoriteRecipe.do" method="POST">
			            <input type="hidden" name="recipeId" value="${recipe.id}">
			            <button type="submit" class="btn btn-blue btn-block w-100">Like This Recipe</button>
			        </form>
			    </c:if>
			</div>
			
		
			<div class="col-md-4 offset-md-4 text-center">
			    <c:if test="${user.getFavoriteRecipes().contains(recipe)}">
			        <form action="unfavoriteRecipe.do" method="POST">
			            <input type="hidden" name="recipeId" value="${recipe.id}">
			            <button class="btn btn-blue btn-block w-100">Unlike This Recipe</button>
			        </form>
			    </c:if>
			</div>
	
			<div class="col-md-4 offset-md-4 text-center">
			    <form action="getAllFavorites.do" method="POST">
			        <button type="submit" class="btn btn-blue btn-block w-100">My Recipe Book</button>
			    </form>
			</div>
	<!-- 	</div> -->
	
        <hr class="section-divider">
        <!-- Comments Section -->
        <div class="row d-flex justify-content-center">
            <div class="col-md-8">
                <div class="card2 card border-0 px-4 py-5">
                    <div class="row px-3 justify-content-center mt-4 mb-5">
                        <div class="col-md-12 text-center">
                            <h2>${recipe.name} Reviews</h2>
                            <c:forEach items="${recipe.comments}" var="comment">
                                <div class="card comment">
                                    <h5 class="username"><strong>${comment.user.username}</strong></h5>
                                    <h6>${comment.comment}</h6>
                                    <p>${comment.createdAt}</p>
                                </div>
                            </c:forEach>
                            <form id="add-comment-form" action="addComment.do" method="POST" class="center-content">
                                <textarea name="content" rows="3" style="width: 100%;" placeholder="Add a comment here"></textarea><br>
                                <input type="hidden" name="recipeId" value="${recipe.id}">
                                <input type="hidden" name="userId" value="${user.id}">
                                <input type="submit" value="Submit Comment" style="width: 100%;">
                            </form>
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