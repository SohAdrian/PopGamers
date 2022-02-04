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
		<a href="<%=request.getContextPath()%>/GamePage.jsp">Back to Home Page</a>
	</div>
	<h1>PopGamers Discussion Feed</h1>
	<div class="row center" style="float: none; margin: 0 auto;width: 200px;">
		<div class="card" style="outline-style: solid">
			<c:forEach var="thread" items="${listFeed}">
				<!-- <a href="#"> -->
				<br>
				<p>Thread Name: <b>${thread.title}</b></p>
				<p>Thread Content: ${thread.content}</p>
				<p>Created By: ${thread.user}</p>
				<p>Date Posted: ${thread.date}</p>
				<!-- </a> -->
				<div>
					<a href="<%=request.getContextPath()%>/DiscussionPage.jsp">Discuss in thread</a>
					<br>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>