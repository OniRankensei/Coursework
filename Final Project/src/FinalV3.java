import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class FinalV3 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		TicTacToeV3 game = new TicTacToeV3();

		game.spashScreen();
		game.askForUserName();

		do {

			game.setBoard();

			while (game.inProgress) {

				game.displayBoard();
				game.playerMakeMove();
				game.checkForWin(game.currentPlayer);
				game.changePlayer();
				game.changeTurn();

			}

			game.checkWhetherToContinue();
			game.resetGame();

		} while (game.on);

		input.close();

	}

}

class TicTacToeV3 {

	// Scanner object created for user input
	Scanner input = new Scanner(System.in);

	public String username;
	public final int SIZE_OF_ARRAY = 9; // size of the board
	public boolean on; // will control whether to continue playing
	public boolean inProgress; // will control current game
	public final String HUMAN_PLAYER = "H";
	public final String COMPUTER_PLAYER = "C";
	public String currentPlayer;
	public int currentTurn;
	public final int NUMBER_OF_TURNS = 9;

	// creation of a String array with a size of 9 serving as the board
	String[] array = new String[SIZE_OF_ARRAY];

	/**
	 * Default constructor. It sets the current player to the human player and
	 * sets the current turn to the first turn.
	 */

	public TicTacToeV3() {
		this.on = true;
		this.inProgress = true;
		currentPlayer = HUMAN_PLAYER;
		currentTurn = 1;

	}

	/**
	 * Resets the game and changes the currentPlayer to the human player.
	 */

	public void resetGame() {

		this.inProgress = true;
		this.currentPlayer = HUMAN_PLAYER;
		this.currentTurn = 1;
	}

	/**
	 * Populates the array with the numbers 0 through 8 as Strings.
	 */

	public void setBoard() {
		for (int i = 0, j = 0; i < SIZE_OF_ARRAY; i++, j++) {
			this.array[i] = "" + j;
		}
	}

	/**
	 * Changes the currentTurn. If the currentTurn exceeds the maximum
	 * NUMBER_OF_TURNS, the game is declared as a tie and the current game in
	 * progress ends.
	 */

	public void changeTurn() {

		this.currentTurn++;

		if (currentTurn > NUMBER_OF_TURNS) {
			exit();
			System.out.print("The game is a tie!\n");
		}
	}

	/**
	 * Displays the board in its current state.
	 */

	public void displayBoard() {

		System.out.println(" |-----|");
		System.out.printf(" |%s|%s|%s|\n", this.array[0], this.array[1], this.array[2]);
		System.out.printf(" |%s|%s|%s|\n", this.array[3], this.array[4], this.array[5]);
		System.out.printf(" |%s|%s|%s|\n", this.array[6], this.array[7], this.array[8]);
		System.out.println(" |-----|");
	}

	/**
	 * Allows the current player to make a selection of which space to occupy in
	 * the board. The selection is validated to ensure that the move is a legal
	 * move by verifying that the choice is one space in the board and that the
	 * selection has not been selected by the other player.
	 */

	public void playerMakeMove() {

		int indexSelected;
		String userInput;

		if (currentPlayer.equals(HUMAN_PLAYER)) {
			System.out.printf("\nIt is %s's turn.\n", this.username);
		} else if (currentPlayer.equals(COMPUTER_PLAYER)) {
			System.out.println("\nIt is the computer's turn.");
		}

		System.out.println("Please choose a space.");
		userInput = input.nextLine();

		indexSelected = validatePlayersMove(userInput);

		indexSelected = checkPositionAvailability(indexSelected);

		this.array[indexSelected] = currentPlayer;

	}

	/**
	 * Checks for position availability by verifying whether the specified
	 * position has already been selected by either player.
	 * 
	 * @param indexSelected
	 *            - an integer that represents a player's choice for the space
	 *            it chooses to occupy.
	 * 
	 * @return - the player's choice of space if it has not been already chosen
	 *         by either player.
	 */

	public int checkPositionAvailability(int indexSelected) {
		String userInput;

		while (this.array[indexSelected].equals("H") || this.array[indexSelected].equals("C")) {

			System.out.println("This space is already taken.");
			System.out.println("Make a different selection.");
			userInput = input.nextLine();
			indexSelected = validatePlayersMove(userInput);
		}

		return indexSelected;
	}

	/**
	 * Prints out the "Splash" screen.
	 */

	public void spashScreen() { // method is finished

		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("******           ******");
		System.out.println("******TIC TAC TOE******");
		System.out.println("******  By Jose  ******");
		System.out.println("******  Sanchez  ******");
		System.out.println("******           ******");
		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("***********************");

		System.out.println();
		System.out.println("Press <ENTER> to continue . . . ");
		input.nextLine();

	}

	/**
	 * Asks for the user's name and will only accept a name that consists of
	 * alphabetic characters without any spaces.
	 */

	public void askForUserName() {

		String userInput;

		// prompting for user input
		System.out.println("Please enter your name: ");
		userInput = input.nextLine();

		// validating name
		userInput = validateUserName(userInput);

		// the user input is stored in the member variable of the object
		this.username = userInput;

	}

	/**
	 * Changes the current player to the opposite character, that is, if the
	 * current player is the human player, then it sets the current player to
	 * the computer player and vice-versa.
	 */

	public void changePlayer() {

		if (currentPlayer.equals(HUMAN_PLAYER)) {

			currentPlayer = COMPUTER_PLAYER;

		} else if (currentPlayer.equals(COMPUTER_PLAYER)) {

			currentPlayer = HUMAN_PLAYER;

		}
	}

	/**
	 * Checks the current player's choices on the board to see whether the
	 * current player has won the game.
	 * 
	 * @param currentPlayer - the current player.
	 *            -
	 */

	public void checkForWin(String currentPlayer) {

		String winningMessage;

		if (currentPlayer.equals("H")) {

			winningMessage = username + " has won the game!";

		} else {

			winningMessage = "The computer has won the game!";
		}

		// row 1 winning condition
		if (array[0].equals(currentPlayer) && array[1].equals(currentPlayer) && array[2].equals(currentPlayer)) {
			System.out.println(winningMessage);
			exit();
			
		// row 2 winning condition	
		} else if (array[3].equals(currentPlayer) && array[4].equals(currentPlayer) && array[5].equals(currentPlayer)) {
			System.out.println(winningMessage);
			exit();
			
		// row 3 winning condition	
		} else if (array[6].equals(currentPlayer) && array[7].equals(currentPlayer) && array[8].equals(currentPlayer)) {
			System.out.println(winningMessage);
			exit();
			
		// column 1 winning condition
		} else if (array[0].equals(currentPlayer) && array[3].equals(currentPlayer) && array[6].equals(currentPlayer)) {
			System.out.println(winningMessage);
			exit();
			
		// column 2 winning condition
		} else if (array[1].equals(currentPlayer) && array[4].equals(currentPlayer) && array[7].equals(currentPlayer)) {
			System.out.println(winningMessage);
			exit();
			
		// column 3 winning condition
		} else if (array[2].equals(currentPlayer) && array[5].equals(currentPlayer) && array[8].equals(currentPlayer)) {
			System.out.println(winningMessage);
			exit();
			
		// diagonal winning condition
		} else if (array[0].equals(currentPlayer) && array[4].equals(currentPlayer) && array[8].equals(currentPlayer)) {
			System.out.println(winningMessage);
			exit();
			
		// reverse diagonal winning condition
		} else if (array[2].equals(currentPlayer) && array[4].equals(currentPlayer) && array[6].equals(currentPlayer)) {
			System.out.println(winningMessage);
			exit();
		}
	}

	/**
	 * Ends the current game by setting the instance variable inProgress to false.
	 */
	
	public void exit() {
		displayBoard();
		this.inProgress = false;
	}

	/**
	 * Asks whether the user wishes to continue and validates the user's
	 * choice to make sure that it is a valid choice. It only verifies 
	 * whether the user's choice is "y" or "Y" to continue, otherwise
	 * the game ends and message is displayed notifying the user that the
	 * game has ended.
	 */
	
	public void checkWhetherToContinue() {

		String userInput;

		System.out.println("Would you like to continue?Press y/n.");
		userInput = input.nextLine();

		userInput = validateToContinue(userInput);

		if (!(userInput.equalsIgnoreCase("y"))) {

			this.on = false;

			System.out.println("Thank you for playing. Goodbye.");
		}
	}

	/**
	 * Validates the user's choice to continue the game. It verifies
	 * that the choice entered is only one character and only accepts 
	 * the following characters: 'y', 'Y', 'n', and 'N'
	 * 
	 * @param userInput - the user's input collected as a String.
	 * 
	 * @return - the user's choice consisting of only one of the
	 * accepted characters as a String.
	 */
	
	public String validateToContinue(String userInput) {

		int userInputLength = userInput.length();
		int counter = 0;

		while (userInputLength == 0 || userInputLength > 1) {

			System.out.println("This is an invalid entry.");
			System.out.println("Please choose a number y/n to continue.");
			userInput = input.nextLine();
			userInputLength = userInput.length();
		}

		while (counter < userInputLength) {
			if (!(userInput.charAt(counter) == 'y') && !(userInput.charAt(counter) == 'Y')
					&& !(userInput.charAt(counter) == 'n') && !(userInput.charAt(counter) == 'N')) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please choose a number y/n to continue.");
				userInput = input.nextLine();
				userInputLength = userInput.length();
				counter = 0;
			} else {
				counter++;
			}
			while (userInputLength == 0 || userInputLength > 1) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please choose a number y/n to continue.");
				userInput = input.nextLine();
				userInputLength = userInput.length();
			}
		}

		return userInput;
	}

	/**
	 * Validates user input to ensure that the input consists of a String of
	 * letters without any spaces or special characters.
	 * 
	 * @param userInput
	 *            a String for validation.
	 * @return a String consisting of only letters.
	 */
	
	public String validateUserName(String userInput) {

		int userInputLength = userInput.length();
		int counter = 0;

		while (userInputLength == 0) {

			System.out.println("This is an invalid entry.");
			System.out.println("Please enter your name.");
			userInput = input.nextLine();
			userInputLength = userInput.length();
		}

		while (counter < userInputLength) {
			if (!Character.isLetter(userInput.charAt(counter))) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter your name without spaces or special characters.");
				userInput = input.nextLine();
				userInputLength = userInput.length();
				counter = 0;
			} else {
				counter++;
			}
			while (userInputLength == 0) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter your name without spaces or special characters.");
				userInput = input.nextLine();
				userInputLength = userInput.length();
			}
		}

		return userInput;
	} 
	
	/**
	 * Validates the player's choice for position on the board. The only
	 * choices allowed are integers from 0 to 8 inclusive. It does not allow
	 * any spaces, special characters, or alphabetic characters. In addition
	 * to only accepting integers 0 to 8, it only allows for one integer to be
	 * entered as a choice.
	 * 
	 * @param userInput - the user's choice as a String.
	 * 
	 * @return - the user's choice represented as an integer.
	 */

	public int validatePlayersMove(String userInput) {

		int index;
		int userInputLength = userInput.length();
		int counter = 0;

		while (userInputLength == 0 || userInputLength > 1) {

			System.out.println("This is an invalid entry.");
			System.out.println("Please choose a number from 0 to 8.");
			userInput = input.nextLine();
			userInputLength = userInput.length();
		}

		while (counter < userInputLength) {
			if (!(userInput.charAt(counter) == '0') && !(userInput.charAt(counter) == '1')
					&& !(userInput.charAt(counter) == '2') && !(userInput.charAt(counter) == '3')
					&& !(userInput.charAt(counter) == '4') && !(userInput.charAt(counter) == '5')
					&& !(userInput.charAt(counter) == '6') && !(userInput.charAt(counter) == '7')
					&& !(userInput.charAt(counter) == '8')) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please choose a number from 0 to 8.");
				userInput = input.nextLine();
				userInputLength = userInput.length();
				counter = 0;
			} else {
				counter++;
			}
			while (userInputLength == 0 || userInputLength > 1) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please choose a number from 0 to 8.");
				userInput = input.nextLine();
				userInputLength = userInput.length();
			}
		}
		index = Integer.parseInt(userInput);
		return index;
	}

} // end of TicTacToe
