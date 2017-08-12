<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <link href = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel = "stylesheet">
           <script src = "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
              <script src = "//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
              <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.css">

              <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
               <link rel="stylesheet" type="text/css" href="/DataTables/datatables.css">

               <script type="text/javascript" charset="utf8" src="/DataTables/datatables.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="style.css">


        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"></script>


        <script type="text/javascript" charset="utf8" src="http://https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<%@ page isELIgnored="false" %>
	<script>
	$(document).ready(function(){
        $('#example').DataTable();
    });
    </script>





<title>View</title>

</head>
<body>


<h1>Employee Entry & Exit Time</h1>


		<table class="table table-bordered" border="1" cellpadding="5" id="example">

        <thead>
			<tr>
				<th>Name</th>
				<th>Entry Of Employee</th>
				<th>Exit Of Employee</th>
				<th>Time Period(mins)</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${arr}" var="item">
				<tr>
					<td><c:out value="${item.name}" /></td>
					<td><c:out value="${item.entry}" /></td>
					<td><c:out value="${item.exit}" /></td>
					<td><c:out value="${item.diff}" /></td>
				</tr>
			</c:forEach>
			</tbody>

		</table>



</body>
</html>