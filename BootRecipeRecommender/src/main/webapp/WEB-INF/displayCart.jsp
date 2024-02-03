<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.skilldistillery.reciperecommender.entities.Ingredient" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>
</head>
<body>
<% List<Ingredient> cart = (List<Ingredient>) request.getSession().getAttribute("userCart");
for (Ingredient ingredient : cart) { %>
<%= ingredient.getName() %>
<% } %>
 
 
 
</body>
</html>