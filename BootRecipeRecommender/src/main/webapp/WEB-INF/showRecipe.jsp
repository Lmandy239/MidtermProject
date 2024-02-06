<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
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
</head>
<body>
	<div class="pantry">
		<c:choose>
			<c:when test="${! empty recipes}">
				<table>
					<tr id="th">
						<th>Top 6 Recipes</th>
					</tr>

					<c:forEach items="${recipes}" var="recipes">
						<tr>
							<td><a class="btn"
								href="displayRecipe.do?recipes=${recipes}">Choose This
									Recipe</a> ${recipes}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h4>No Recipe Found</h4>
			</c:otherwise>
		</c:choose>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

</body>
</html>