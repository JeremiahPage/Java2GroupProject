<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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