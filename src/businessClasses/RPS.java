package businessClasses;

public class RPS {
	
	// 1 is a win
	// 2 is a loss
	// 0 is a tie

	public int userRock(String computerSelection){	// User selected rock

		if (computerSelection.equalsIgnoreCase("paper")){	// Loss
			return 2;
		} else if (computerSelection.equalsIgnoreCase("scissors")){	// Win
			return 1;
		} else {											// Tie
			return 0;
		}
	}
	
	public int userPaper(String computerSelection){	// User selected paper

		if (computerSelection.equalsIgnoreCase("rock")){	// Win
			return 1;
		} else if (computerSelection.equalsIgnoreCase("scissors")){	// Loss
			return 2;
		} else {
			return 0;										// Tie
		}
	}
	
	public int userScissors(String computerSelection){	// User selected scissors
	
		if (computerSelection.equalsIgnoreCase("paper")){	// Win
			return 1;
		} else if (computerSelection.equalsIgnoreCase("rock")){	// Loss
			return 2;
		} else {
			return 0;										// Tie
		}
	}
}


