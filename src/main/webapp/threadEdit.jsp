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
			<a class="navbar-brand"> User Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/FeedServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${thread != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${thread == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${thread != null}">Edit Thread</c:if>
						<c:if test="${thread == null}">Add New Thread</c:if>
					</h2>
				</caption>
				<c:if test="${thread != null}">
					<input type="hidden" name="oriTitle"
						value="<c:out value='${thread.title}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Thread Name</label> <input type="text"
						value="<c:out value='${thread.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Content</label> <input type="text"
						value="<c:out value='${thread.content}' />" class="form-control"
						name="content">
				</fieldset>
				<fieldset class="form-group">
					<label>User</label> <input type="text"
						value="<c:out value='${thread.user}' />" class="form-control"
						name="user">
				</fieldset>
				<fieldset class="form-group">
					<label>Date</label> <input type="text"
						value="<c:out value='${thread.date}' />" class="form-control"
						name="date">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
			</div>
		</div>
	</div>
</body>
</html>