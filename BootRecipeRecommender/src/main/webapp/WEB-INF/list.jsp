<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Recipe List</title>
</head>
<body>
    <h2>Recipe List</h2>
  <ul>
    <c:forEach var="recipe" items="${recipes}">
        <li>${recipe.name}</li>
    </c:forEach>
</ul>

</body>
</html>
