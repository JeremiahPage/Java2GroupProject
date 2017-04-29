<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="../Styles/pretty.css">
<link rel="stylesheet" type="text/css" href="../Styles/customclasses.css">
</head>
<body id="reg">
<div class = "masterHeader"><jsp:include page="Master.jsp" /></div>

	    <div id="container">
	    
	    
	    <%@ page import="businessClasses.User" %>
		<%if(session.getAttribute("User")==null){%>
		
            <form method="post" action="../Register">
                <h1>Registration</h1>
                <div class="line"><label for="firstname">First Name *: </label><input type="text" id="firstname" name="firstname" /></div>
                <div class="line"><label for="lastname">Last Name *: </label><input type="text" id="lastname" name = "lastname" /></div>
                <div class="line"><label for="username">Username *: </label><input type="text" id="username" name = "username" /></div>
                <div class="line"><label for="pwd">Password *: </label><input type="password" id="pwd" name = "pwd"/></div>
                <div class="line"><label for="pwd">Verify Password *:</label><input type="password" id="pwd" name = "vpwd" /></div>
                <div class="line"><label for="email">Email *: </label><input type="text" id="email" name = "email"/></div>
                <div class="line submit"><input type="submit" value="Submit" /></div>
            </form>
            
            <%}else{
			User user = (User)session.getAttribute("User");
			String fname = user.getFname(); %>
			<div>You are already logged in <%= fname %>.</div>
			<div>If this is not you <a href= "../Logoff">Logout</a></div>
			<%} %>
            
            <p id="error" class="error">*Please make sure your details are correct before submitting the form and all fields marked with * are required!.</p>
            <div class="error"><%if(session.getAttribute("Error")==null){%><%}else{%><%=session.getAttribute("Error").toString()%><% session.removeAttribute("Error");%><%}%></div>
        </div>




</body>
</html>