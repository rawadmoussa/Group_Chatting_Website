<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html>
<head>
<title>Chat</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<style type="text/css">
	#table{
	border: 1px solid black;
	}
	</style>
</head>
<body>

<nav class="navbar navbar-success bg-success">
<div class="container">

		<ul class="nav navbar-nav">

			<div class="navbar-header">

			<span class="navbar-text">	<h2 style="float: left;">Welcome user ${username}</h2></span>
			
		</ul>
		<ul class="navbar-form navbar-right">
			<a href="Logoutpage" class="btn btn-primary navbar-btn">Log out</a>
			<a href="EditProfile" class="btn btn-primary navbar-btn">edit profile</a>
</ul>

</div>
</nav>
<br>
<br>
		
	<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-8">
   <table  id="table" class="table">
		<tr class="success">
			<th colspan="2">Connected Users</th>
			
			
		</tr>
		<c:forEach items="${loggedinUsers}" var="user" varStatus="status">
			<tr>
				<td>${user.username}</td>
				
			</tr>
		</c:forEach>
	</table>
   <br>
   <br>
   <br>
   <br>
<form action="AddMessage" method='POST' id="userform">
  <div class="form-group">
    <label>Send Message:</label>
    <textarea name='message'></textarea>
    <input type="hidden"  name='firstname' value="${firstname}" >
  </div>
  <button type="submit" class="btn btn-success">Send</button>
</form>
	
	</div>
     <div class="col-sm-4">
     <table class="table" ><tr>
		<th><p>Group Messages:</p></th></tr>
		<c:forEach items="${messages}" var="message" varStatus="status">
			<tr  class="success">
			
				<td><c:out value = "${message}" /></td>
				
			</tr>
		</c:forEach>
	</table>
     </div>
    </div>
    </div>
    
    
</body>
</html>