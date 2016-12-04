import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class FinalV2 {

	public static void main(String[] args) {

		TicTacToeV2 game = new TicTacToeV2();

		game.spashScreen();

		game.askForUserName();

		game.setBoard();

		while (game.on) {

			game.displayBoard();
			game.playerMakeMove();
			game.checkForWin(game.currentPlayer);
			game.changePlayer();
			game.changeTurn();

		}

	} // end of main

} // end of FinalV1

class TicTacToeV2 {

	// Scanner object created for user input
	Scanner input = new Scanner(System.in);

	// final size of the array
	public final int SIZE_OF_ARRAY = 9;
	public boolean on;
	public final String HUMAN_PLAYER = "H";
	public final String COMPUTER_PLAYER = "C";
	public String currentPlayer;
	public int currentTurn;
	public final int NUMBER_OF_TURNS = 9;

	// testing
	boolean condition;
	boolean[] winningConditions;

	// creation of a String array with a size of 9
	String[] array = new String[SIZE_OF_ARRAY];

	public String username;

	// Conthis.arrayuctor
	public TicTacToeV2() {
		this.on = true;
		currentPlayer = HUMAN_PLAYER;
		currentTurn = 1;

	}

	/**
	 * Populates the array with the numbers 0 through 8 as Strings.
	 */
	public void setBoard() {
		for (int i = 0, j = 0; i < SIZE_OF_ARRAY; i++, j++) {
			this.array[i] = "" + j;
		}
	}
	
	public void changeTurn() {
		
		this.currentTurn++;
		System.out.println("The current turn is " + currentTurn);
		
		if(currentTurn > NUMBER_OF_TURNS) {
			exit();
			//displayBoard();
			System.out.print("The game is a tie!");
		}
	}

	public void displayBoard() {

		System.out.println(" |-----|");
		System.out.printf(" |%s|%s|%s|\n", this.array[0], this.array[1], this.array[2]);
		System.out.printf(" |%s|%s|%s|\n", this.array[3], this.array[4], this.array[5]);
		System.out.printf(" |%s|%s|%s|\n", this.array[6], this.array[7], this.array[8]);
		System.out.println(" |-----|");
	}

	public void playerMakeMove() {

		int indexSelected;
		String userInput;

		if (currentPlayer.equals(HUMAN_PLAYER)) {
			System.out.println("It is the human's turn.");
		} else if (currentPlayer.equals(COMPUTER_PLAYER)) {
			System.out.println("It is the computer's turn.");
		}

		System.out.println("Choose a space.");
		userInput = input.nextLine();

		indexSelected = validatePlayersMove(userInput);

		indexSelected = checkPositionAvailability(indexSelected);

		this.array[indexSelected] = currentPlayer;

	} // end of playerMakeMove

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

	} // end of spashScreen method

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

	public void changePlayer() {

		if (currentPlayer.equals(HUMAN_PLAYER)) {
			currentPlayer = COMPUTER_PLAYER;
			// System.out.println("It is the computer's turn.");
		} else if (currentPlayer.equals(COMPUTER_PLAYER)) {
			currentPlayer = HUMAN_PLAYER;
			// System.out.println("It is the human's turn.");
		}
	}

	public void checkForWin(String str) {

		String player;

		if (str.equals("H")) {
			player = "human";
		} else {
			player = "computer";
		}

		if (array[0].equals(currentPlayer) && array[1].equals(currentPlayer) && array[2].equals(currentPlayer)) {
			System.out.printf("The %s player has won!\n", player);
			exit();
		} else if (array[3].equals(currentPlayer) && array[4].equals(currentPlayer) && array[5].equals(currentPlayer)) {
			System.out.printf("The %s player has won!\n", player);
			exit();
		} else if (array[6].equals(currentPlayer) && array[7].equals(currentPlayer) && array[8].equals(currentPlayer)) {
			System.out.printf("The %s player has won!\n", player);
			exit();
		} else if (array[0].equals(currentPlayer) && array[3].equals(currentPlayer) && array[6].equals(currentPlayer)) {
			System.out.printf("The %s player has won!\n", player);
			exit();
		} else if (array[1].equals(currentPlayer) && array[4].equals(currentPlayer) && array[7].equals(currentPlayer)) {
			System.out.printf("The %s player has won!\n", player);
			exit();
		} else if (array[2].equals(currentPlayer) && array[5].equals(currentPlayer) && array[8].equals(currentPlayer)) {
			System.out.printf("The %s player has won!\n", player);
			exit();
		} else if (array[0].equals(currentPlayer) && array[4].equals(currentPlayer) && array[8].equals(currentPlayer)) {
			System.out.printf("The %s player has won!\n", player);
			exit();
		} else if (array[2].equals(currentPlayer) && array[4].equals(currentPlayer) && array[6].equals(currentPlayer)) {
			System.out.printf("The %s player has won!\n", player);
			exit();
		}
	}

	public void exit() {
		displayBoard();
		this.on = false;
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
	} // end of method

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
	} // end of method

} // end of TicTacToe
