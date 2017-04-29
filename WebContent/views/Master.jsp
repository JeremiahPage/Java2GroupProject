<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../Styles/pretty.css">
<link rel="stylesheet" type="text/css" href="../Styles/customclasses.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<div class="master">

<%@ page import="businessClasses.User"%>
	<%if(session.getAttribute("User")==null){%>
	<div>
	<a href="../Login">Log in</a> or <a href="../Register">Register</a>
	</div>
	
	<%}else{
			User user = (User)session.getAttribute("User");
			String uname = user.getUsername(); %>
			<%= uname %> <a href= "../Logoff">Log out</a>
			<%} %>		
</div>
</body>
</html>