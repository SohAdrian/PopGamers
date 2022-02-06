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

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Posts</h3>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/ReviewServlet/GameListing"
					class="btn btn-success">Go to Home Page</a>
			</div>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/Discussion.jsp"
					class="btn btn-success">Add New Discussion</a>
			</div>
			
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Discussion</th>
						<th>Time</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="details" items="${listDetails}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${details.discussion}" /></td>
							<td><c:out value="${details.time}" /></td>

							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a
								href="edit?discussion=<c:out value='${details.discussion}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?discussion=<c:out
value='${details.discussion}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>