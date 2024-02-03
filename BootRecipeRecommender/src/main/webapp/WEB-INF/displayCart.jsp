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
<title>My Cart</title>
</head>
<body>
	    
	<h2>Your Cart</h2>

	    
	<table>

		<thead>

			<tr>
				<th>Ingredient Name</th>
				</tr>

		</thead>

		<tbody>
		
			<% List<Ingredient> cart = (List<Ingredient>) request.getSession().getAttribute("userCart");
			for (Ingredient ingredient : cart) { %>
			<tr>
				<td><%=ingredient.getName()%></td>
			</tr>
			<%}%>
			
		</tbody>
	</table>
</body>
</html>