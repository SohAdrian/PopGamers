<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Post Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/DetailsServlet/dashboard"
				class="nav-link">Back to Discussion Page</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${details != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${details == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${details != null}">
Edit Post
</c:if>
						<c:if test="${details == null}">
Add New Post
</c:if>
					</h2>
				</caption>
				<c:if test="${details != null}">
					<input type="hidden" name="oriDiscussion"
						value="<c:out
value='${details.discussion}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Post</label> <input type="text"
						value="<c:out
value='${details.discussion}' />" class="form-control"
						name="discussion" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Date</label> <input type="text"
						value="<c:out
value='${details.time}' />" class="form-control"
						name="time">
				</fieldset>
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>