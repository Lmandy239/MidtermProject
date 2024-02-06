<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page
	import="com.skilldistillery.reciperecommender.entities.Ingredient"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe</title>
</head>
<body>
<c:forEach var="recipe" items="${recipes}">
    <p>${recipe.name}</p>
    <p>${recipe.ingredientDescription}</p>
    <p>${recipe.description}</p>
</c:forEach>
   
</body>
</html>