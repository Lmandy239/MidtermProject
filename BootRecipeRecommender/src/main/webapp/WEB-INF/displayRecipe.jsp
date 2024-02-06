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
</head>
<body>
    <h2>Recipes</h2>

    <ul>
        <c:forEach items="${topRecipes}" var="recipe" varStatus="loop">
                <li>${recipe.name}</li>
        </c:forEach>
    </ul>
</body>
</html>