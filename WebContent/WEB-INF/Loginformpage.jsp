<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-success bg-primary">
<div class="container">
<h2> Login Page</h2>
<br>
<p> Login please</p>
<br>
<div class="container">
<form action="Loginhandlerpage" method='POST'>
  <div class="form-group">
    <label>Username:</label>
    <input type="text"  name='username' value='' class="form-control" id="email">
     <label>Password:</label>
    <input type="password"  name='password' value='' class="form-control" id="email">
  </div>
  <button type="submit" class="btn btn-primary">Login</button>
</form>
	<br>
	<br>
	<a href="Signuppage">if you don't have an account, click here to sign up</a>
	<br>
	<br>
	<p> Note: if you don't have an account and attempt to Login, you will get redirected to the Login page.<br> Please sign up first by clicking the above link </p>
	</div>
	</div>
	</nav>
</body>
</html>