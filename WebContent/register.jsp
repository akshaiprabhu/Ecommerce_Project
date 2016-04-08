<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Login &amp; Register Templates</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/form-style.css">
<link rel="stylesheet" href="css/style-register.css">
</head>
<body>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">

				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>Website name</h1>
						<div class="description">
							<p>Some Description</p>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-5">

						<div class="form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h3>Already registered? Login here</h3>
									<p>Enter username and password to login</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-key"></i>
								</div>
							</div>
							<div class="form-bottom">
								<form role="form"
									action="http://localhost:8181/Ecommerce/rest/loginService"
									method="POST" class="login-form" id="form-login">
									<div style="color: #FF0000;">${errorMessage}</div>
									<div class="form-group">
										<label class="sr-only" for="form-username">Username</label> <input
											type="text" name="form-username" placeholder="Username..."
											class="form-username form-control" id="form-username">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-password">Password</label> <input
											type="password" name="form-password"
											placeholder="Password..." class="form-password form-control"
											id="form-password">
									</div>
									<button type="submit" class="btn">Login</button>
								</form>
							</div>
						</div>

					</div>

					<div class="col-sm-1 middle-border"></div>
					<div class="col-sm-1"></div>

					<div class="col-sm-5">

						<div class="form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h3>New User? Register here</h3>
									<p>Fill in the form below to start shopping</p>
								</div>
								<div class="form-top-right">
									<i class="fa fa-pencil"></i>
								</div>
							</div>
							<div class="form-bottom">
								<form role="form" action="" method="post"
									class="registration-form">
									<div class="form-group">
										<label class="sr-only" for="form-first-name">First
											name</label> <input type="text" name="form-first-name"
											placeholder="First name..."
											class="form-first-name form-control" id="form-first-name">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-last-name">Last name</label>
										<input type="text" name="form-last-name"
											placeholder="Last name..."
											class="form-last-name form-control" id="form-last-name">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-email">Email</label> <input
											type="text" name="form-email" placeholder="Email..."
											class="form-email form-control" id="form-email">
									</div>
									<div class="form-group">
										<label class="sr-only" for="form-about-yourself">Password</label>
										<input type="text" name="form-password" placeholder="Password"
											class="form-password form-control" id="form-password">
									</div>
									<button type="submit" class="btn">Register</button>
								</form>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>

	</div>

	<!-- Footer -->
	<footer>
	<div class="container">
		<div class="row">

			<div class="col-sm-8 col-sm-offset-2">
				<div class="footer-border"></div>
				<p>Copyright &copy; Website name 2016</p>
			</div>

		</div>
	</div>
	</footer>

	<!-- Javascript -->
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/scripts.js"></script>

	<script>
		function validate() {
			var username = document.getElementById("form-username");
			var password = document.getElementById("form-password");

			$.post("http://localhost:8181/Ecommerce/rest/loginService",
					$("#form-login").serialize()).done(function(data) {
				alert(data + "---asdsadas");
				//             if( data === username ) {
				//                 alert( "Success" );
				//             }
				//             else {
				//                 alert( "Wrong username or password" );
				//             }
			})
		}
	</script>
	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

</body>
</html>