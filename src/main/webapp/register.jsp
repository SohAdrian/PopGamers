<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login to PopGamers!</title>
</head>
<body>

	<form action="RegisterServlet" method="post">
		UserName: <input type="text" name="userName"> <p> Email: <input
			type="text" name="email"><p> Password: <input type="password"
			name="password"> <input type="submit" value="Register!" />
	</form>

</body>
</html>