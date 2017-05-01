<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Page</title>
<link rel="stylesheet" type="text/css" href="../Styles/pretty.css">
<link rel="stylesheet" type="text/css" href="../Styles/customclasses.css">
</head>
<body id="game">
	<div class="masterHeader"><jsp:include page="Master.jsp" /></div>

	<%@ page import="businessClasses.User"%>
	<%
		if (session.getAttribute("User") == null) {
	%>
	<div class="images required">You must log in to play rock paper scissors</div>
	

	<%
		} else {
			
	%>
	
	
	
	<div id="gaming">Please Select Rock, Paper, or Scissors</div>
	<br>       
	<table>
		<thead>
			<tr>
				<td></td>
				<td></td>
				<td>Victories</td>
				<td></td>
				<td>Losses</td>
				<td></td>
				<td>Ties</td>
				<td></td>
				<td>Games Played</td>
				<td></td>
				<td>Winning Percentage</td>
			</tr>

		</thead>

	<tbody>

		<tr>
			<%if (session.getAttribute("wins") == null){ 
				session.setAttribute("wins", 0);
				session.setAttribute("losses", 0);
				session.setAttribute("ties", 0);
				session.setAttribute("gamesPlayed", 0);
				session.setAttribute("percentageWon", 0);
				}%>

				<td>Your Stats</td>
				<td></td>
				<td><%=session.getAttribute("wins")%></td>
				<td></td>
				<td><%=session.getAttribute("losses")%></td>
				<td></td>
				<td><%=session.getAttribute("ties")%></td>
				<td></td>
				<td><%=session.getAttribute("gamesPlayed")%></td>
				<td></td>
				<td><%=session.getAttribute("percentageWon")%></td>
			</tr>

		</tbody>

	</table>
	<img alt="Rock" src="../images/rock.jpg" width="200" height="200">
	<img alt="Paper" src="../images/paper.jpg" width="200" height="200">
	<img alt="Scissors" src="../images/scissors.jpg" width="200"
		height="200">
	<br>
	<form method="post" action="../RockPaperScissors">
		<button type="submit" name="Rock" value="Rock">Rock</button>
		<button type="submit" name="Paper" value="Paper">Paper</button>
		<button type="submit" name="Scissors" value="Scissors">Scissors</button>
		<button type="submit" name="Reset" value="Reset">Reset The
			Scoreboard</button>
	</form>
	<p>Result: ${message}</p>
	
	<%
		}
	%>
</body>
</html>
