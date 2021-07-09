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
<a href="passwordToEdit" class="btn btn-primary navbar-btn">Back</a>
<form action="EditPage" method='POST'>
  <div class="form-group">
    <label> New firstname :</label>
    <input type="text"  name='firstname' value='' class="form-control" id="email">
     <label> New password :</label>
    <input type="password"  name='password' value='' class="form-control" id="email">
    
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
				

</div>
</nav>
</body>
</html>