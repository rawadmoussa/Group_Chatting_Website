<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Sign up</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-success bg-success">
<div class="container">
<h2> Sign Up Page</h2>
<br>
<p>Sign up please </p>
<br>
<form method='POST' action="Signuphandlerpage">
  <div class="form-group">
    <label>Username:</label>
    <input type="text"  name='username' value='' class="form-control" id="email">
    <label>Firstname:</label>
    <input type="text"  name='firstname' value='' class="form-control" id="email">
    <label>Password:</label>
     <input type="password"  name='password' value='' class="form-control" id="email">
  </div>
  <button type="submit" class="btn btn-primary">Sign up</button>
</form>
	<br>
	<br>
	<a href="Loginpage">if you already have an account, click here to login</a>
	<br>
	<br>
	<p> Note: if you already have an account and attempt to sign up, you will get redirected to the login page</p>
	</div>
	</nav>
</body>
</html>