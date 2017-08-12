<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css">
<script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.7.0/moment.min.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style2.css">

                 <script>
           $(function() {

             $( "#jQueryValidateTest" ).validate();

             $( "[type=date]" ).datepicker({
               onClose: function() {
                 $( this ).valid();
               }
             });
           });
                 </script>

<title>Register</title>
</head>
<body>
<h1> Please fill the required form</h1>
	<form action="Register" method="post">
		<input id="name" name="name" required="required" type="text"placeholder="my name " /></br>
		 <input id="password" name="password" required="required" type="password" placeholder="password" /></br>
          <input id="email" name="email" required="required" type="email" placeholder="email@gmail.com" /></br>
                    <input id="jQueryValidateTest" type="date" name="doj" required="required" id="date" placeholder="mm/dd/yyyy"></br>

		     <select name="Role" id="text">
             <option value="Software">Software</option>
             <option value="Analyst">Analyst</option>
             <option value="Consultant">Consultant</option>
             </select></br>
		<button type="submit">Submit</button>
		</form>
</body>
</html>