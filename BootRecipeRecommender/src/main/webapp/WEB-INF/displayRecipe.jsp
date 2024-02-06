<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page
	import="com.skilldistillery.reciperecommender.entities.Ingredient"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recipe List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">

    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
    <h2>Recipes</h2>
    <div class="container mt-4">
        <div class="row">
            <c:forEach items="${topRecipes}" var="recipe" varStatus="loop">
                <div class="col-lg-4 col-md-6 col-sm-12 mb-4">
                    <div class="card">
                        <a href="#"> <!-- Add the link to the recipe page here -->
                            <img src="data/food_images/${recipe.image}.jpg" alt="${recipe.name}" class="card-img-top">
                        </a>
                        <div class="card-body">
                            <h5 class="card-title">${recipe.name}</h5>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>