<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe Recommender</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

	<link rel="stylesheet" href="css/stylesheet.css">

</head>
<body>
   <div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
    <div class="card card0 border-0">
        <div class="row d-flex">
            <div class="col-lg-6">
                <div class="card1 pb-5">
                    <div class="row">
                        <img src="images/image6.png" class="logo">
                    </div>
                    <div class="row px-3 justify-content-center mt-4 mb-5 border-line">
					 <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
					  <div class="carousel-inner">
					    <div class="carousel-item active">
					      <img src="images/food2.jpg" class="d-block w-100">
					    </div>
					    <div class="carousel-item">
					      <img src="images/food3.jpg" class="d-block w-100">
					    </div>
					    <div class="carousel-item">
					      <img src="images/food4.jpg" class="d-block w-100">
					    </div>
					    <div class="carousel-item">
					      <img src="images/food5.jpg" class="d-block w-100">
					    </div>
					  </div>
					</div>
                    </div>
                </div>
            </div>
                  
          
           <div class="col-lg-6">
    <div class="card2 card border-0 px-4 py-5">
        <form action="login.do" method="POST">
        			<br>
        			<br>
        			<br>
        			<br>
        			<br>
        			<br>
        			<br>
        			<br>
            <div class="row px-3">
                <label class="mb-1"><h6 class="mb-0 text-sm">User Name</h6></label>
                <input class="mb-4" type="text" name="username" placeholder="Enter a valid user name">
            </div>
            <div class="row px-3">
                <label class="mb-1"><h6 class="mb-0 text-sm">Password</h6></label>
                <input type="password" name="password" placeholder="Enter password">
            </div>
            <div class="row px-3 mb-4">
                <div class="row mb-3 px-3">
                    <button type="submit" class="btn btn-blue text-center">Login</button>
                </div>
                <div class="row mb-4 px-3">
                    <small class="font-weight-bold">Don't have an account? <a href="register.do">Create new user</a></small>
                </div>
            </div>
        </form>
    </div>
</div>
        <div class="bg-blue py-4">
            <div class="row px-3">
                <small class="ml-4 ml-sm-5 mb-2">Copyright &copy; SD 42 JUNIT-SPARK.</small>
              
            </div>
        </div>
    </div>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>