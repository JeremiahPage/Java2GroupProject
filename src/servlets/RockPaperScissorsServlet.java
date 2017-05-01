package servlets;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessClasses.RPS;

/**
 * Servlet implementation class RockPaperScissors
 */
@WebServlet("/RockPaperScissors")
public class RockPaperScissorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Number of wins, losses, ties, result (win-1, loss-2, or tie-0), games played, winning percentage
	static int wins = 0;
	static int losses = 0;
	static int ties = 0;
	static int result = 0;
	static int gamesPlayed = 0;
	static double percentageWon = 0;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	public RockPaperScissorsServlet() {
		super();
	}

	
	
	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("views/Game.jsp");
	}

	/**
	* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create session
		HttpSession session = request.getSession();
		
		if (request.getParameter("Reset") != null){ 	// If user selected reset the Scoreboard
			
			// Reset wins, losses, ties, gamesPlayed, winning percentage to 0
			session.setAttribute("wins", 0);
			session.setAttribute("losses", 0);
			session.setAttribute("ties", 0);
			session.setAttribute("gamesPlayed", 0);
			session.setAttribute("percentageWon", 0);
			
			wins = 0;
			losses = 0;
			ties = 0;
			gamesPlayed = 0;
			percentageWon = 0;
			
			// Display a reset
			String message = "The scoreboard has been reset";
			session.setAttribute("message", message);
			
		} else {
			// Generate random move for computer
			int computerMoveNumber = (int)(Math.random() * 3 + 1);
			String computerMove = "";
			
			// Create game instance
			RPS myGame = new RPS();
			
			// Turn random number into a move
			if (computerMoveNumber == 1){
				computerMove = "Rock";
			} else if (computerMoveNumber == 2){
				computerMove = "Paper";
			} else if (computerMoveNumber == 3){
				computerMove = "Scissors";
			}
			
			String yourMove = "";
			
			// If user selected Rock
			if (request.getParameter("Rock") != null){
				// Get the game result
				result = myGame.userRock(computerMove);
				yourMove = "Rock";
				
			} else if (request.getParameter("Paper") != null){	// If user selected Paper
				// Get the game result
				result = myGame.userPaper(computerMove);
				yourMove = "Paper";
				
			} else if (request.getParameter("Scissors") != null){	// If user selected Scissors
				// Get the game result
				result = myGame.userScissors(computerMove);
				yourMove = "Scissors";
			}
			
			
			// If result is a win
			if (result == 1){
				wins++;
				session.setAttribute("wins", wins);
				
			} else if (result == 2){		// If result is a loss
				losses++;
				session.setAttribute("losses", losses);
				
			} else if (result == 0){	// If result is a tie
				ties++;
				session.setAttribute("ties", ties);
			}
			
			// Message Creation
			String message = "You chose " + yourMove + ", the computer chose " + computerMove;
			if (result == 0){
				message = message + ". It's a Tie!";
			} else if (result == 1){
				message = message + ". You Win!";
			} else if (result == 2){
				message = message + ". You Lose!";
			}
			session.setAttribute("message", message);
			
			// Increment number of games played
			
			gamesPlayed++;
			
			// Decimal Formatting of winning percentage and String concatenation
			
			DecimalFormat df = new DecimalFormat(".00");
			percentageWon = wins * 100.0 / gamesPlayed;
			String percentageWonString = df.format(percentageWon) + " %";
			
			// Set the number of games played and winning percentage
						
			session.setAttribute("gamesPlayed", gamesPlayed);
			
			session.setAttribute("percentageWon", percentageWonString);
		}
		
		doGet(request, response);
	}

}

