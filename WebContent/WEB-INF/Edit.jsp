<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<title>Edit</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-success bg-success">
<div class="container">
<a href="Chat" class="btn btn-primary navbar-btn">Back to Chat</a>
<form method='POST' action=''>
				<table >
				<tr><th>Username: </th><td>${username}</td></tr><br>
				<tr><th>Firstname: </th><td>${firstname}</td></tr><br>
				</table>
				</form>
				<ul class="navbar-form navbar-right">
			<a href="DeleteUser" class="btn btn-primary navbar-btn">Delete Profile</a>
			<a href="Logoutpage" class="btn btn-primary navbar-btn">Log out</a>
			<a href="passwordToEdit" class="btn btn-primary navbar-btn">edit profile</a>
</ul>
</div>
</nav>
</body>
</html>