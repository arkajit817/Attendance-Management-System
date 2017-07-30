<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#date1" ).datepicker();
    $("#date2").datepicker();
  } );
  </script>

<script type="text/javascript" src="./script.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Adminview" method="post" >

<!-- From<input type="date" name="from" required="required" placeholder="mm/dd/yyyy">
 --> 
 <div></div>
 From: <input type="text" name="from" required="required"id="date1" name="date1"/> <br/>
 </div>
 <div></div>
 Upto<input type="text" name="upto" required="required" id="date2" placeholder="mm/dd-yyyy"> <br/>
 </div>
 
 <div>
 
Id No<input type="text" name="empid">

</div>

<button type="submit">Click here to see</button>
</form>
</body>
</html>