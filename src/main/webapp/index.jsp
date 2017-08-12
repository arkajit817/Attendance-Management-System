<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style3.css">
<%@ page isELIgnored="false" %>
<title>Insert title here</title>
</head>
<body>
    <h1>Attendance Management System</h1>

	<h3> ${param.message}</h3>
<div >
	<form action="" method="get" >
	<p>
                    			<label for="a">ID</label>
		<input id="empid" name="empid" required="required" type="text" placeholder="1234" />
		</p>

		<p>
                            			<label for="b">Password</label>
		<input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" />
		</p>

		<button type="submit" formaction="Login">Entry</button>
		<button type="submit" formaction="Logout">Exit</button>
		<button type="submit" formaction="Admin">Adminview</button>



	</form>
</div>



<div class="register">


	<a href="Register.jsp">Register</a>
            </div>

</body>
</html>