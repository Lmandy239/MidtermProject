<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Ingredients</title>

<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
  rel="stylesheet"
  integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
  crossorigin="anonymous">

<link rel="stylesheet" href="css/stylesheet.css">
<style>
.logo {
  height: 150px;
}

.colored-card {
  background-color: #e0e0e0;
  
  margin-bottom: 0px;
  overflow: auto;
  height: 380px;
  width: 100%;
  max-height: 380px;
}

.colored-card2 {
  background-color: #e0e0e0;
  margin-bottom: 0px;
  overflow: auto;
  height: 140px;
  width: 100%;
  max-height: 140px;
}
</style>
</head>
<body>
  <div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
    <div class="card card0 border-0">
      <div class="row d-flex">
      <form action="logout.do" method="POST"
        class="d-flex justify-content-end">
        <button type="submit" class="btn btn-blue text-center">Log
          out</button>
      </form>
      <div class="row">
        <img src="images/logoSpark.png" class="logo">
      </div>
        <div class="col-lg-6">
          <div class="card1 pb-5">

            <div class="row px-3 justify-content-center mt-4 mb-5 border-line">
              <div class="col-md-6 offset-md-3 text-center">
              <br>
                <h3>Your Cart:</h3>
				<br>
                <div class="colored-card card border-0 px-4 py-5">
                  <ul class="ingredient-list">
                    <c:forEach var="ingredient"
                      items="${user.ingredientsInPantry}">
                      <form action="removeFromCart.do" method="GET">
                        <li
                          class="d-flex justify-content-between align-items-center">
                          ${ingredient.name} <input type="hidden" name="id"
                          value="${ingredient.id}">
                          <button type="submit" class="btn btn-danger">-</button>
                        </li>
                      </form>
                    </c:forEach>
                  </ul>

                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-6">
          <div class="card2 card border-0 px-4 py-5">
            <div class="col-md-6 offset-md-3 text-center">
              <h3>Search Ingredient</h3>
            </div>
            <div class="row px-3">
              <form action="searchIngredientFromStore.do" method="GET">
                <label for="searchResults" class="mb-1" class="mb-0 text-sm"></label>
                <input class="mb-4" type="text" name="searchResults"
                  placeholder="Search for Ingredient" required><br>
                <input type="submit" value="Search">
              </form>
            </div>
            <hr class="my-4">
            <div class="row px-3 justify-content-center mt-4 mb-5 border-line">
              <div class="col-lg-12 text-center">
                <h3>Search Results:</h3>
                <div class="colored-card2 card border-0 px-4 py-5">
                  <ul class="ingredient-list">
                    <c:forEach var="ingredient" items="${ingredients}">
                      <form action="addToCart.do" method="GET">
                        <li
                          class="d-flex justify-content-between align-items-center">
                          ${ingredient.name} <input type="hidden" name="id"
                          value="${ingredient.id}">
                          <button type="submit" class="btn btn-success">+</button>
                        </li>
                      </form>
                    </c:forEach>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>       
        <div class="row mb-3 px-3">
          <div class="col-md-4 offset-md-4 text-center ">
            <form action="generateRecipes.do" method="POST">
              <button type="submit" class="btn btn-blue btn-block w-100">Find
                Recipe</button>
            </form>
          </div>
          <br>
          <div class="col-md-4 offset-md-4 text-center ">
            <form action="addRecipeRedirect.do" method="POST">
              <button type="submit" class="btn btn-blue btn-block w-100">Add
                New Recipe</button>
            </form>
          </div>
          <br>
          <div class="col-md-4 offset-md-4 text-center ">
            <form action="getAllFavorites.do" method="POST">
              <button type="submit" class="btn btn-blue btn-block w-100">My
                Recipe Book</button>
            </form>
          </div>
          <br>
          <div class="col-md-4 offset-md-4 text-center">
            <small class="font-weight-bold">Or <a href="findall.do">Show
                All Recipes</a></small>
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
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
      crossorigin="anonymous"></script>
  </div>
</body>
</html>
