<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

<form action="Register" method="post" >
<input id="name" name="name" required="required" type="text" placeholder="my name "/>
<input id="password" name="password" required="required" type="password" placeholder="password" /> 
<input id="text" name="doj" required="required" type="text" placeholder="DOJ" /> 
<input id="email" name="email" required="required" type="email" placeholder="email@gmail.com"/>
<input id="text" name="empid" required="required" type="text" placeholder="123 "/>
<input id="text" name="Role" required="required" type="text" placeholder="software engineer"/>

<button type="submit">Submit</button>


</body>
</html>