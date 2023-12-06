<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
	
	<jsp:include page="/WEB-INF/views/common/variable.jsp"></jsp:include>
	<link rel="stylesheet"
	href="${classpath }/frontend/bootstrap4/bootstrap.min.css">
	<link rel="stylesheet" href="${classpath }/frontend/css/login.css">

</head>
<body>
	<form method="POST" action="${classpath}/login_processing_url">
		<div class="form-box">
			<div class="form-value">
					<h2 class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Login</h2>
					<c:if test="${not empty param.login_error }">
						<div class="alert alert-danger" role="alert">
						Login attempt was not successful, try again!!!</div>
					</c:if>
					<div class="inputbox">
						<ion-icon name="mail-outline"></ion-icon>
						<input type="text" id="username" name="username" class="form-control"
							required> <label class="form-label" for="username">Username:</label>
					</div>
					<div class="inputbox">
						<ion-icon name="lock-closed-outline"></ion-icon>
						<input type="password" id="password" name="password"
							class="form-control" required> <label for="">Password:</label>
					</div>
					<div class="forget">
						<label class="form-check-label" for="remember-me"> <input class="form-check-input" type="checkbox"
													id="remember-me" name="remember-me">Remember me
							<a href="#">Forgot Password ?</a>
						</label>
					</div>
					<button type="submit" class="btn btn-primary">&nbspLogin&nbsp</button>
					<div class="register">
						<p>
							Don't have a account <a href="${classpath}/signup" role="button">Signup</a>
						</p>
					</div>
			</div>
		</div>
		</form>
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>