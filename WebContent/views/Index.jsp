<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
<link rel="stylesheet" type="text/css" href="../Styles/pretty.css">
</head>
<body id="index">
	<div class="masterHeader"><jsp:include page="Master.jsp" /></div>

	<%@ page import="businessClasses.User"%>
	<%if(session.getAttribute("User")==null){%>


	<img src="../images/thumbsup.gif" alt="Thumbs UP!" width="350"
		height="350">
	

<%}else{
			User user = (User)session.getAttribute("User");
			String uname = user.getUsername(); %>
			<%= uname %> <a href= "../Logoff">Logout</a></div>
			<%} %>
			
</body>
</html>