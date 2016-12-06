import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class FinalV4 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		TicTacToeV4 game = new TicTacToeV4();

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

class TicTacToeV4 {

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
	int[] currentBoard = new int[SIZE_OF_ARRAY];

	/**
	 * Default constructor. It sets the current player to the human player and
	 * sets the current turn to the first turn.
	 */

	public TicTacToeV4() {
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
	 * Creates an array of integers of the same size of the game's
	 * array of the String type. For each position taken by the human
	 * player, this array named currentBoard stores a 5 in the same
	 * index as the one occupied by the human player in the String array.
	 * Similarly, for each position taken by the computer player, a number
	 * 3 will be stored in the currentBoard and a 0 will be stored if the
	 * space is unoccupied. The purpose of these integer values will be used
	 * to determine which best move should be taken by the computer player.
	 * 
	 */
	
	public void updateBoard() {

		int state;

		for (int index = 0; index < SIZE_OF_ARRAY; index++) {

			if (array[index].equals(HUMAN_PLAYER)) {

				state = 5; // indicates a human player has chosen this space

			} else if (array[index].equals(COMPUTER_PLAYER)) {

				state = 3; // indicates that the computer has chosen a space here

			} else {

				state = 0; // indicates that the space is empty
			}

			currentBoard[index] = state;
		}
	}

	/**
	 * Changes the currentTurn. If the currentTurn exceeds the maximum
	 * NUMBER_OF_TURNS, the game is declared as a tie and the current game in
	 * progress ends.
	 */

	public void changeTurn() {

		this.currentTurn++;

		if (currentTurn >= NUMBER_OF_TURNS + 1) {
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

		updateBoard();
	}

	/**
	 * Allows the current player to make a selection of which space to occupy in
	 * the board. The selection is validated to ensure that the move is a legal
	 * move by verifying that the choice is one space in the board and that the
	 * selection has not been selected by the other player.
	 * 
	 * If it is the computer's turn, this method will invoke the
	 * calculateComputerMove() method to verify whether there are any winning
	 * moves the computer can make and whether there are any scenarios where
	 * the computer will move if it does not block the human's next turn.
	 */

	public void playerMakeMove() {

		int indexSelected;
		String userInput;

		if (currentPlayer.equals(HUMAN_PLAYER)) {
			System.out.printf("\nIt is %s's turn.\n", this.username);
		} else if (currentPlayer.equals(COMPUTER_PLAYER)) {
			System.out.println("\nIt is the computer's turn.");
		}

		// prompts the user to make a selection if it is the human's turn
		if (currentPlayer.equals(HUMAN_PLAYER)) {
			System.out.println("Please choose a space.");
			userInput = input.nextLine();
			indexSelected = validatePlayersMove(userInput);
			indexSelected = checkPositionAvailability(indexSelected);
			array[indexSelected] = HUMAN_PLAYER;

		// invokes the calculateComputerMove() if it is the computer's turn
		} else {
			indexSelected = calculateComputerMove();
			array[indexSelected] = COMPUTER_PLAYER;
		}

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

		while (!(isMoveLegal(indexSelected))) {

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
	 * @param currentPlayer
	 *            - the current player. -
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
	 * Ends the current game by setting the instance variable inProgress to
	 * false.
	 */

	public void exit() {
		displayBoard();
		this.inProgress = false;
	}

	/**
	 * Asks whether the user wishes to continue and validates the user's choice
	 * to make sure that it is a valid choice. It only verifies whether the
	 * user's choice is "y" or "Y" to continue, otherwise the game ends and
	 * message is displayed notifying the user that the game has ended.
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
	 * Validates the user's choice to continue the game. It verifies that the
	 * choice entered is only one character and only accepts the following
	 * characters: 'y', 'Y', 'n', and 'N'
	 * 
	 * @param userInput
	 *            - the user's input collected as a String.
	 * 
	 * @return - the user's choice consisting of only one of the accepted
	 *         characters as a String.
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
	 * Validates the player's choice for position on the board. The only choices
	 * allowed are integers from 0 to 8 inclusive. It does not allow any spaces,
	 * special characters, or alphabetic characters. In addition to only
	 * accepting integers 0 to 8, it only allows for one integer to be entered
	 * as a choice.
	 * 
	 * @param userInput
	 *            - the user's choice as a String.
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

	/**
	 * Calculates the computer player's next move taking into account
	 * a couple of factors. 
	 * 
	 * For the computer's first turn (the game's
	 * second turn), the computer will always select index 4 if the
	 * human player did not select it first, and will choose the index
	 * 0 if index 4 has already been selected by the human player.
	 * 
	 * Next the computer will calculate whether there any winning moves
	 * it can make by getting three in a row. It accomplishes this by
	 * searching through a second array named currentBoard which represents
	 * the game's current state. 
	 * 
	 * There are three states in the game represented by an integer value. The 
	 * number 5 represents that the human player has selected a particular index, the
	 * number 3 represents that the computer player has selected a particular index,
	 * and the number 0 represents that a particular index is currently empty.
	 * 
	 * By checking through each  row, column and diagonal represented by integers
	 * in the currentBoard array, the computer can calculate whether there are any
	 * two given spaces selected by either player that will allow them to win. For
	 * example:
	 * 
	 * If the human player has two spaces in any given row, column, or diagonal,
	 * the updateBoard will have two values of 5 as elements for that particular
	 * row, column or diagonal. When those values are added together, the sum of 
	 * these spaces in any given row, column or diagonal will equal to 10. The 
	 * computer player will then search all possible winning scenarios for any rows,
	 * columns or diagonals where this condition has already been met, which will
	 * instruct the computer to choose an empty space in the row, column, or diagonal
	 * to block the human player from winning on the next turn.
	 * 
	 * This same process is calculated for the computer's occupied spaces, which
	 * when added, will be equal to 6. The computer will search for any rows,
	 * columns or diagonals where it has a chance to win.
	 * 
	 * The method will first take into account any spaces where the computer can win
	 * followed by spaces where the human player can win.
	 * 
	 * 
	 * @return - the index representing the computer's move.
	 */
	
	public int calculateComputerMove() {

		int indexSelected;

		// computer chooses 4 as its first choice if it is available
		if (currentTurn == 2 && !array[4].equals(HUMAN_PLAYER)) {
			indexSelected = 4;

			if (isMoveLegal(indexSelected)) {

				return indexSelected;
			}

		// computer chooses 0 as its first choice if 4 was already chosen
		} else if (currentTurn == 2 && array[4].equals(HUMAN_PLAYER)) {

			indexSelected = 0;

			if (isMoveLegal(indexSelected))

				return indexSelected;

		}

		// moves to consider on its subsequent turns 
		else if (currentTurn > 2) {
			
			
			// win for row 1
			if (currentBoard[0] + currentBoard[1] + currentBoard[2] == 6) {

				indexSelected = computerCheckIndex(0, 1, 2);

					return indexSelected;
						}
			// win for row 2
			if (currentBoard[3] + currentBoard[4] + currentBoard[5] == 6) {

				indexSelected = computerCheckIndex(3, 4, 5);

				return indexSelected;
						}
			// win for row 3
			if (currentBoard[6] + currentBoard[7] + currentBoard[8] == 6) {

				indexSelected = computerCheckIndex(6, 7, 8);

				return indexSelected;
			}
			
			// win for column 1
			else if (currentBoard[0] + currentBoard[3] + currentBoard[6] == 6) {

				indexSelected = computerCheckIndex(0, 3, 6);

				return indexSelected;
			}
			// win for column 2
			else if (currentBoard[1] + currentBoard[4] + currentBoard[7] == 6) {

				indexSelected = computerCheckIndex(1, 4, 7);

				return indexSelected;
			}
			// win for column 3
			else if (currentBoard[2] + currentBoard[5] + currentBoard[8] == 6) {

				indexSelected = computerCheckIndex(2, 5, 8);

				return indexSelected;
			}
			// win for diagonal
			else if (currentBoard[0] + currentBoard[4] + currentBoard[8] == 6) {

				indexSelected = computerCheckIndex(0, 4, 8);

				return indexSelected;
			}
			
			// win for reverse diagonal
			else if (currentBoard[2] + currentBoard[4] + currentBoard[6] == 6) {

				indexSelected = computerCheckIndex(2, 4, 6);

				return indexSelected;
			}
			
			// lose for row 1
			else if (currentBoard[0] + currentBoard[1] + currentBoard[2] == 10) {

				indexSelected = computerCheckIndex(0, 1, 2);

				return indexSelected;

			}

			else if (currentBoard[3] + currentBoard[4] + currentBoard[5] == 10) {

				indexSelected = computerCheckIndex(3, 4, 5);

				return indexSelected;
			}

			else if (currentBoard[6] + currentBoard[7] + currentBoard[8] == 10) {

				indexSelected = computerCheckIndex(6, 7, 8);

				return indexSelected;
			}
			
			else if (currentBoard[0] + currentBoard[3] + currentBoard[6] == 10) {

				indexSelected = computerCheckIndex(0, 3, 6);

				return indexSelected;
			}
			else if (currentBoard[1] + currentBoard[4] + currentBoard[7] == 10) {

				indexSelected = computerCheckIndex(1, 4, 7);

				return indexSelected;
			}
			else if (currentBoard[2] + currentBoard[5] + currentBoard[8] == 10) {

				indexSelected = computerCheckIndex(2, 5, 8);

				return indexSelected;
			}
			else if (currentBoard[0] + currentBoard[4] + currentBoard[8] == 10) {

				indexSelected = computerCheckIndex(9, 4, 8);

				return indexSelected;
			}
			else if (currentBoard[2] + currentBoard[4] + currentBoard[6] == 10) {

				indexSelected = computerCheckIndex(2, 4, 6);

				return indexSelected;
			}

		}  else {
			
			indexSelected = emptySpace();
			
			return indexSelected;

	}
		indexSelected = emptySpace();
		return indexSelected;

	}
	
	/**
	 * Iterates through the current state of the array of the String type
	 * to verify whether there are any empty spaces, meaning whether there
	 * are any indexes in the array where the array's element is not one that
	 * belongs to either the human (the letter "H") or the computer player (
	 * the letter "C").
	 * 
	 * @return - an index of an empty space.
	 */
	public int emptySpace() {
		
		
		for (int index = 0; index < array.length; index++) {
			
			if (isMoveLegal(index)) {
				return index;
			}
		}
		System.out.println("The emptySpace() method did not work.");
		return -1;
		
		
	}

	/**
	 * Takes in three indexes as the argument and checks which move is legal
	 * or which index represents an empty space in the array of the String type.
	 * 
	 * @param index1 - first index to be checked.
	 * @param index2 - second index to be checked.
	 * @param index3 - third index to be checked
	 * 
	 * @return - the index that represents an empty space among the three
	 * indexes searched.
	 */
	public int computerCheckIndex(int index1, int index2, int index3) {

		if (isMoveLegal(index1)) {
			return index1;
		} else if (isMoveLegal(index2)) {
			return index2;
		} else {
			return index3;
		}
	}

	/**
	 * Verifies whether a move is a legal move by getting passing an index of
	 * the array. This method verifies whether the element at the selected index
	 * is either an "H" or a "C", thus indicating whether choosing this index as
	 * a move is legal or not.
	 * 
	 * @param indexSelected
	 *            - the index to be checked.
	 * 
	 * @return - true if the element in the target index is either "H" or "C",
	 *         and false if the element in the target index is either a "H" or
	 *         "C".
	 */

	public boolean isMoveLegal(int indexSelected) {

		if (array[indexSelected].equals(COMPUTER_PLAYER) || array[indexSelected].equals(HUMAN_PLAYER)) {
			return false;
		}
		return true;
	}

} // end of TicTacToe

