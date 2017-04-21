<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <style type="text/css">
 
            body {font-family:Arial, Sans-Serif;
            background-color: #A9F886;}
 
            #container {width:300px; margin:0 auto;}
 
            /* Nicely lines up the labels. */
            form label {display:inline-block; width:140px;}
 
            
            form input[type="text"],
            form input[type="password"],
            form input[type="email"] {width:160px;}
 
            form .line {clear:both;}
            form .line.submit {text-align:left;}
 
        </style> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logon</title>
<link rel="stylesheet" type="text/css" href="../Styles/pretty.css">
</head>
<body id="log">
	<div id="logon">
		<form>
			<h1>Logon</h1>

			<div class="line">
				<label for="username">Username *: </label><input type="text"
					id="username" />
			</div>
			<div class="line">
				<label for="pwd">Password *: </label><input type="password" id="pwd" />
			</div>


			<div class="line submit2">
				<input type="submit" value="Submit" />
			</div>
			<!-- will need to get the link for pw reset to go into this area below -->

			<p>
				Forgot password? Click <a
					href="http://localhost:8080/Java2GroupProject/views/Logon.jsp">
					here</a>
		</form>
	</div>
</body>
</html>