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
<div class = "masterHeader"><jsp:include page="Master.jsp" /></div>
	
	<div id="logon">	
		<%@ page import="businessClasses.User" %>
		<%if(session.getAttribute("User")==null){%>
		
		<form method="post" action="../Login">
			<h1>Logon</h1>
			<div class="line"><label for="username">Username *: </label><input type="text" id="username" name="username" /></div>
			<div class="line"><label for="pwd">Password *: </label><input type="password" id="pwd" name="pwd" /></div>
			<div class="line submit2"> <input type="submit" value="Submit" /> </div>
		</form>
			
			<%}else{
			User user = (User)session.getAttribute("User");
			String fname = user.getFname(); %>
			<div>You are already logged in <%= fname %>.</div>
			<div>If this is not you <a href= "../Logoff">Logout</a></div>
			<%} %>

			<div class="error"><%if(session.getAttribute("Error")==null){%><%}else{%><%=session.getAttribute("Error").toString()%><% session.removeAttribute("Error");%><%}%></div>
			
	</div>
</body>
</html>