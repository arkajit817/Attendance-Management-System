<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javafx.scene.control.Alert"%>
    <%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${id};


<!-- String date=(session.getAttribute("date")).toString();
 
 %> -->
<form action="Logout"  method="get">
<input id="text" name="empid" value="<%= session.getAttribute("empid") %>" type="hidden" />
<input id="text" name="date" value="<%= session.getAttribute("time") %>" type="hidden" />


<button type="submit">Logout</button>

</form>
</body>
</html>