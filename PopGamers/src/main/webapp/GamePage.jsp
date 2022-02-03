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
<title>Insert title here</title>
</head>
<body>
	<div>
		<button class="button"
			href="<%=request.getContextPath()%>/DiscussionPage.jsp">Game
			Forum</button>
	</div>
	<h1>PopGamers Home Page</h1>
	<div class="row center" style="float: none; margin: 0 auto;">
		<div class="card">
			<c:forEach var="game" items="${listGames}">
				<!-- <a href="#"> -->
				<img class="img-fluid img-thumbnail" src="${game.gamePicture}"
					width="400px" height="200px" />
				<br>
				<p>
					Game Name: <b>${game.gameName}</b>
				</p>
				<p>Description: ${game.gameDescription}</p>
				 <p>Genre: ${game.genre}</p>
				<!-- </a> -->
				<div>
					<button class="button"
						href="<%=request.getContextPath()%>/GameReview.jsp">See
						Review</button>
					<br>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>