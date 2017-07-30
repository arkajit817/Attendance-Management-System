<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Status: ${param.message}</p>

<form action="" method="get">
<input id="empid" name="empid" required="required" type="text" placeholder="1234"/>
<input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
  <button type="submit" formaction="Login">Entry</button>
    <button type="submit" formaction="Logout">Exit</button>
        <button type="submit" formaction="Admin">Adminview</button>
    
  
  
  </form>
  
<%--  <%
String strin = (String) session.getAttribute("Login");
if (strin.equals("in")){     
out.print("alert('Entry done');");
}      
%> --%>
  
  
  
  
  
					<a href="Register.jsp">Register</a>
					

</body>
</html>