<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Register</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>

<link rel="stylesheet"
	href="${classpath}/frontend/bootstrap4/bootstrap.min.css">
<link rel="stylesheet" href="${classpath}/frontend/css/signup.css">
</head>

<body>
	<section>
		<form action="${classpath }/register" method="post">
			<div class="form-box">
				<h2 class="text-center">Register</h2>
				<div class="col-md-12">
					<label for="inputUsername4" class="form-label">Username</label> <input
						type="username" id="username" name="username" class="form-control">
				</div>
				<div class="col-md-12">
					<label for="inputPassword4" class="form-label">Password</label> <input
						type="password" id="password" name="password" class="form-control">
				</div>
				<div class="col-md-12">
					<label for="inputEmail4" class="form-label">Email</label> <input
						type="email" id="email" name="email" class="form-control">
				</div>
				<div class="col-md-4">
					<p>Sex :</p>
					<label> <input type="radio" name="gender" value="1" checked>male
					</label> <label> <input type="radio" name="gender" value="2">female
					</label> <label> <input type="radio" name="gender" value="3">another
					</label>
				</div>
				<div class="col-md-12">
					<label for="inputAddress" class="form-label">Address</label> <input
						type="address" id="address" name="address" class="form-control">
				</div>
				<div class="col-md-12">
					<label for="inputCity" class="form-label">City</label> <input
						type="city" id="city" name="city" class="form-control">
				</div>
				<div class="col-12">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="gridCheck">
						<label class="form-check-label" for="gridCheck"> You
							agree to the store's terms </label>
					</div>
				</div>
				<div class="col-12">
					<button role="button" class="btn btn-primary">register</button>
				</div>
				<div class="back_login">
					<a href="${classpath }/login">Back to Login</a>
				</div>
			</div>
		</form>
	</section>
	<script src="./js/jquery-3.3.1.slim.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./bootstrap4/bootstrap.min.js"></script>
</body>

</html>