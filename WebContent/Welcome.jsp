<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#mobile_no, #password').click(function() {
			$("#loginMessage").hide();
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('register_user').click(function() {
			$("#welcomeMessage").hide();
		});
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$('forgot_password').click(function() {
			$("#forgotPassword").hide();
		});
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="CSS/welcome.css">
<link href="https://fonts.googleapis.com/css?family=Cousine" rel="stylesheet">

<title>Book Store - Welcome</title>

</head>
<body>
	<h1>Welcome to the Landing Page
		We're a start-up that does something</h1>
	<h2>New User ?</h2>
	<a id="register_user" href="Register.html">click here to register and purchase books</a>

	<p></p>
	<p></p>

	<h2>Existing User Login Here :</h2>
	<form action="login_user" method="post">
		<label>Mobile No:</label>
		<input id="mobile_no" type="text" name="mobile_no" />
		<p></p>
		<label>Password:</label>
		<input id="password" type="password" name="password" />
		<p></p>
		<input class="button" id="btn" type="submit" value="Login" />
	</form>

	<p></p>
	<p></p>

	<h2>Forgot Password ?</h2>
	<a id="forgot_password" href="ForgotPassword.html">click here to reset the password</a>

</body>
</html>
