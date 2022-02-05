<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		Title: <input type="text" name="title"><br> User: <input
			type="text" name="user"><br> Content: <br>
		<textarea name="content"></textarea>
		<br> <input type="submit" value="Call Servlet">
	</form>
</body>
</html>