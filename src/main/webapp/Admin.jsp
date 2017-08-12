<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style2.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<link href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css">


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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

<script type="text/javascript" src="./script.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Welcome Admin </h1>
<h2> Please type the required dates<h2>
	<form action="Adminview" method="post">
			<p>
    			<label for="a">From</label>

    			<input id="#jQueryValidateTest" type="date" name="from" required="required" id="date1"
			name="date1" placeholder="mm/dd/yyyy" ></br>
			</p>

			<p>
                			<label for="b">Upto</label>
        <input id="#jQueryValidateTest" type="date" name="upto" required="required" id="date2"
			placeholder="mm/dd/yyyy"></br>
			</p>


			<p>
                			<label for="c">Id No</label>
        <input type="text" name="empid" placeholder="1234"></br>

                    </p>

                    <p>
                                    			<label for="d"></label>
		<button type="submit">Click Here To See</button>

	</form>
</body>
</html>