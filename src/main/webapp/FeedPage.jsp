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

	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> PopGamers </a>
		</div>
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/ReviewServlet/GameListing"
				class="nav-link" id="returnHome">Back to Home Page</a>
			<li><a href="<%=request.getContextPath()%>/createThread.jsp"
				class="nav-link">Create a Thread</a>
		</ul>
	</nav>

	<h1>PopGamers Discussion Feed</h1>
	<div class="row center" style="float: none; margin: 0 auto;">
		<c:forEach var="thread" items="${listFeed}">
			<div class="col-sm-6">
				<div class="card" style="outline-style: solid;">
					<!-- <a href="#"> -->
					<br>
					<p>
						Thread Name: <b>${thread.title}</b>
					</p>
					<p>Thread Content: ${thread.content}</p>
					<p>Created By: ${thread.user}</p>
					<p>Date Posted: ${thread.date}</p>
					<!-- </a> -->
					<div>
						<ul>
							<li><a href="<%=request.getContextPath()%>/DiscussionPage.jsp">Discuss
								in thread</a>
							
							<li><a href="edit?title=<c:out value='${thread.title}'/>">Edit</a>
							
							<li><a href="delete?title=<c:out value='${thread.title}'/>">Delete</a>
							
						</ul>
					</div>
					<br>
				</div>
				<br>
			</div>
		</c:forEach>
	</div>
</body>
</html>