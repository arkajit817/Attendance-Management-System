<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ page import="java.util.List" %>
 <%@ page import="java.util.*" %>  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>


<div align="center">
        <table border="1" cellpadding="5">
		<tr>
			<th>Name</th>
			<th>Entry Of Employee</th>
			<th>Exit Of Employee</th>
			<th>Time Period(mins)</th>
			</tr>
		<c:forEach items="${arr}" var="item" >
		    <tr>
		    	<td><c:out value="${item.name}"/></td>
          		<td><c:out value="${item.entry}"/></td>
          		<td><c:out value="${item.exit}"/></td>
          		<td><c:out value="${item.diff}"/></td>
          	</tr>
		</c:forEach> 
		
</table>


     <c:if test="${currentPage != 1}">
        <td><a href="Adminview.jsp?page=${currentPage - 1}">Previous</a></td>
    </c:if>
 
  
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="Adminview.jsp?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
     
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="Adminview.jsp?page=${currentPage + 1}">Next</a></td>
    </c:if>





</body>
</html>