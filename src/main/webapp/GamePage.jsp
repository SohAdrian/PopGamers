<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>PopGamers</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/FeedServlet/dashboard">Back
		to Dashboard</a>
	<a href="<%=request.getContextPath()%>/ReviewServlet/GameListing"
		class="btn btn-info">Back to Game Listing</a>
	<h1>Add a New Game</h1>
	<div class="card">
		<form action="GameServlet" method="post">
			<br> Game Name: <input type="text" name="gameName"><br>
			gamePicture: <input type="text" name="gamePicture"><br>
			gameDescription: <input type="text" name="gameDescription"><br>
			Game's Genre: <input type="text" name="genre"><br> <input
				class="btn btn-info" type="submit" value="Add Game?" />
		</form>
	</div>
</body>
</html>