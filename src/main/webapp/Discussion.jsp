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
<form action="DiscussionServlet" method="post">
<div class="card" style="width: 50rem;"> 

<div class="card-body">
    <h5 class="card-title">Start Discussion</h5>
    <p class="card-text">Any discussion should be fine</p>
  </div>
  Discussion: <input type="text" name="discussion">
  Date Posted: <input type="date" name="date">
  <input type="submit" value="Post your topics">
  
  
 </div>


</form>

</body>
</html>