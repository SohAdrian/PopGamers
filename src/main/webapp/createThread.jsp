<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thread Creation</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> PopGamers </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/FeedServlet/dashboard"
				class="nav-link">Back to Feed</a></li>
		</ul>
	</nav>
	<h1>Create Thread</h1>
	<form action="CreateThreadServlet" method="post">
		Title: <input type="text" name="title" id="title"><br> User: <input
			type="text" name="user" id="user"><br> Content: <br>
		<textarea name="content" id="content"></textarea>
		<br> <input type="submit" value="Call Servlet" id="threadSubmit">
	</form>
</body>
</html>