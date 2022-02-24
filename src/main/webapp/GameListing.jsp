<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GameListing</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
</head>
<body>

	<nav class="navbar navbar-expand-md"
		style="background-image: linear-gradient(to left top, #44fdf3, #71a0e3, #14e49b, #3f59e7, #00d4ff)">
		<ul class="navbar-nav">
			<li><a style="color: white; padding: 14px 16px;"
				href="<%=request.getContextPath()%>/FeedServlet/dashboard">Game
					Forum</a></li>
			<li><a style="color: white; padding: 14px 16px;"
				href="<%=request.getContextPath()%>/GamePage.jsp">Add New Game</a></li>
			<li><a style="color: white; padding: 14px 16px;"
				href="<%=request.getContextPath()%>/DetailsServlet/dashboard">Go
					To Discussions</a></li>
			<li><a style="color: white; padding: 14px 16px;"
				href="<%=request.getContextPath()%>/GameUserServlet/dashboard">List
					of User Profiles</a></li>
		</ul>
		<div style="float: right;">
			<a class="btn btn-warning" style="color: white; margin: 10px;"
				href="<%=request.getContextPath()%>/register.jsp">Sign Up</a> <a
				class="btn btn-danger" style="color: white; margin: 10px;"
				href="<%=request.getContextPath()%>">Login</a>
		</div>
	</nav>
	<br>
	<div class="container">
		<h1 style="color: #3b8cff">PopGamers Home Page</h1>
		<div class="row center" style="float: none; margin: 0 auto;">
			<c:forEach var="game" items="${listGames}">
				<div class="card"
					style="color: white; margin: 10px; padding: 55px; background-image: linear-gradient(to right top, #44fdf3, #71a0e3, #14e49b, #3f59e7, #00d4ff)">
					<img class="img-fluid img-thumbnail" src="${game.gamePicture}"
						width="400px" height="200px" /> <br>
					<p>
						Game Name: <b>${game.gameName}</b>
					</p>
					<p style="width: 400px">Description: ${game.gameDescription}</p>
					<p>Genre: ${game.genre}</p>
					<!-- </a> -->
					<div>
						<a class="btn btn-warning"
							href="edit?gameName=<c:out value='${game.gameName}' />">Edit
							Game</a> | <a class="btn btn-danger"
							href="delete?gameName=<c:out value='${game.gameName}' />">Delete
							Game</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>