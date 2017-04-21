<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        
         
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="../Styles/pretty.css">

</head>
<body id="reg">


	        <div id="container">
            <form>
                <h1>Registration</h1>
                <div class="line"><label for="firstname">First Name *: </label><input type="text" id="firstname" /></div>
                <div class="line"><label for="lastname">Last Name *: </label><input type="text" id="lastname" /></div>
                <div class="line"><label for="username">Username *: </label><input type="text" id="username" /></div>
                <div class="line"><label for="pwd">Password *: </label><input type="password" id="pwd" /></div>
                <div class="line"><label for="pwd">Verify Password *:</label><input type="password" id="pwd" /></div>
                <div class="line"><label for="email">Email *: </label><input type="email" id="email" /></div>
               
                <div class="line submit"><input type="submit" value="Submit" /></div>
 
                <p>*Please make sure your details are correct before submitting the form and all fields marked with * are required!.</p>
                
            </form>
        </div>

<!-- This will hold all of the input for the registration page as well as a register button -->
	<form method = "post" action = "Register">
	<form>Already registered? sign in <a href="registration_reset_goes_here"> here</a>
	
	</form>


</body>
</html>