<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Game Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
</head>
<body>

	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${game != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${game == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${game != null}">Update Game Details</c:if>
						<c:if test="${game == null}">Add a New Game</c:if>
					</h2>
				</caption>
				<c:if test="${game != null}">
					<input type="hidden" name="origameName"
						value="<c:out value='${game.gameName}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Game Name:</label> <input type="text"
						value="<c:out value='${game.gameName}' />" class="form-control"
						name="gameName" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Game Picture:</label> <input type="text"
						value="<c:out value='${game.gamePicture}' />" class="form-control"
						name="gamePicture">
				</fieldset>
				<fieldset class="form-group">
					<label>Game's Description:</label> <input type="text"
						value="<c:out value='${game.gameDescription}' />"
						class="form-control" name="gameDescription">
				</fieldset>
				<fieldset class="form-group">
					<label>Game's Genre: </label> <input type="text"
						value="<c:out value='${game.genre}' />" class="form-control"
						name="genre">
				</fieldset>
				<button type="submit" class="btn btn-success">Update</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>