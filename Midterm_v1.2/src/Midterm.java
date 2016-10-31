import java.util.*;
import java.io.*;

public class Midterm {

	public static void main(String[] args) throws IOException {
		
	Scanner input = new Scanner(System.in);
		
		// creates a new object as defined in MathGame Class
		MathGame mathgame = new MathGame();
		
		// prints out a welcome message
		mathgame.welcome();
		
		// asks the user to continue
		mathgame.checkToContinue();
		
		// the game will continue as long as the boolean variable on is true
		while (mathgame.on) {

			// get the name of the user
			mathgame.setUserName(input);

			mathgame.openFile();
			
			// display the menu
			mathgame.displayMenu();

			// will perform the choices express in displayMenu
			mathgame.game(input);
		}
		mathgame.saveStats();
		
		
	} // end of main
	
	
	/**
	 * Given a string, it validates the input to ensure the user entry is an integer.
	 * @param userInput
	 * A string.
	 * @return
	 * An int.
	 */
	public static int numberValidation(String userInput) {
		int userInputLength = userInput.length();
		int counter = 0;
		
		Scanner inputt = new Scanner(System.in);
		
		while (userInputLength == 0) {
			System.out.println("This is an invalid entry.");
			System.out.println("Please enter your answer as an integer:");
			userInput = inputt.nextLine();
			userInputLength = userInput.length();			
		}
		while (counter < userInputLength) {
			if (!Character.isDigit(userInput.charAt(counter)) ) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter your answer as an integer: ");
				userInput = inputt.nextLine();
				userInputLength = userInput.length();
				counter = 0;
			} else {
				counter++;
			} while (userInputLength == 0) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter your answer as an integer: ");
				userInput = inputt.nextLine();
				userInputLength = userInput.length();
			}
		}
		
		int answer = Integer.parseInt(userInput);
		
		return answer;
	}
	
	
	/**
	 * Validates user input to ensure that the input consists of a String of letters
	 * without any spaces or special characters. 
	 * 
	 * @param userInput a String.
	 * @return a String.
	 */
	public static String letterValidation(String userInput) {
		
		int userInputLength = userInput.length();
		int counter = 0;
		
		Scanner input = new Scanner(System.in);
		
		while (userInputLength == 0) {
			
			System.out.println("This is an invalid entry.");
			System.out.println("Please enter your name:");
			userInput = input.nextLine();
			userInputLength = userInput.length();	
		}
		
		while (counter < userInputLength) {
			if (!Character.isLetter(userInput.charAt(counter)) ) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter your name without spaces or special characters: ");
				userInput = input.nextLine();
				userInputLength = userInput.length();
				counter = 0;
			} else {
				counter++;
			} while (userInputLength == 0) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter your name without spaces or special characters: ");
				userInput = input.nextLine();
				userInputLength = userInput.length();
			}
		}
		
		return userInput;
	} // end of method
	
	public static char choiceValidation() {
		Scanner keyboardInput = new Scanner(System.in);

		char userChoice;
		int counter = 0;

		String userInput = keyboardInput.nextLine(); 
		int userInputLength = userInput.length();

		while (userInputLength == 0 || userInputLength > 1) {

			// prompt the user to make another entry
			System.out.println("This is an invalid entry.");
			System.out.println("Please make enter your choice.");

			userInput = keyboardInput.nextLine(); 
			userInputLength = userInput.length();

		}
		
		while (counter < userInputLength) {

			if ( !(userInput.charAt(counter) == '1') && 
				!(userInput.charAt(counter) == '2') && 
				!(userInput.charAt(counter) == '3') && 
				!(userInput.charAt(counter) == '4') && 
				!(userInput.charAt(counter) == '5') && 
				!(userInput.charAt(counter) == 'n') && 
				!(userInput.charAt(counter) == 'N') ) {

				// prompt the user to make another entry
				System.out.println("This is an invalid entry.");
				System.out.println("Please make enter your choice.");

				userInput = keyboardInput.nextLine(); 
				userInputLength = userInput.length();

				counter = 0;
			
			} else {

				counter++;
			} while (userInputLength == 0 || userInputLength > 1) {

				// prompt the user to make another entry
				System.out.println("This is an invalid entry.");
				System.out.println("Please make enter your choice.");

				userInput = keyboardInput.nextLine(); 
				userInputLength = userInput.length();

			}

			}
		
		userChoice = userInput.charAt(0);
		
		return userChoice;


	}


	
	
	
} // end of Midterm Class


class MathGame extends Midterm {
	
	String userName;
	String fileName;
	
	int correct;
	int incorrect;
	
	double totalPoints = 0.0;
	
	boolean on = true;
	
	// Constructor
	MathGame() {
		
	}
	
public void welcome() {
		
		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("******           ******");
		System.out.println("******TheMathGame******");
		System.out.println("******  by Jose  ******");
		System.out.println("******  Sanchez  ******");
		System.out.println("******           ******");
		System.out.println("***********************");
		System.out.println("***********************");
		System.out.println("***********************");
	}
	
	public void setUserName(Scanner input) {
		
		
		String userInput; 
		
		System.out.println("Please enter your name and press <ENTER>.");
		
		userInput = input.nextLine();
		
		userInput = letterValidation(userInput);
		
		this.userName = userInput;
		
		//this.fileName = this.userName + ".txt";
		
	}
	
	public void displayMenu() {
		
		// prints out the displayMenu
		System.out.println("******CHOOSE A PROBLEM******");
		System.out.println("****************************");
		System.out.println("******                ******");
		System.out.println("****** 1. ADD         ******");
		System.out.println("****** 2. SUBTRACT    ******");
		System.out.println("****** 3. MULTIPLY    ******");
		System.out.println("****** 4. DIVIDE      ******");
		System.out.println("****** 5. STATS       ******");
		System.out.println("****** n/N to QUIT    ******");
		System.out.println("******                ******");
		System.out.println("****************************");
		System.out.println("****************************");
		System.out.println("****************************");
		
		
	}
	
	
	public void game(Scanner input) {
		
		do {
			
			char choice; // the user's choice will be stored here
			
			// validates that only the valid options are entered
			choice = choiceValidation();
			
			switch (choice) {
			
			case '1': generateAddition(input);
					break;
			case '2': generateSubtraction(input);
					break;
			case '3': generateMultiplication(input);
					break;
			case '4': generateDivision(input);
					break;
			case '5': viewStatistics(input);		
					break;
			case 'n':
					quit();
			case 'N':	
					quit();
			}
			
		} while(this.on);

	}
	
	public void checkToContinue() {
		
		Scanner keyboardInput = new Scanner(System.in);
		
		String userInput;
		char firstCharacter;

		// prompt user to continue
		System.out.println();
		System.out.println("Press y/Y to continue or any other character to quit.");

		// collect user input as a String
		userInput = keyboardInput.nextLine();

		// check whether the input is y/Y
		firstCharacter = userInput.charAt(0);
		

		if ( !(firstCharacter == 'y') && !(firstCharacter == 'Y') ) {

			this.on = false;

		} else {

			this.on = true;

		}

	} // end of checkToContinue()
	
	public void increment() {
		correct++;
		totalPoints += 0.05;
	}
	
	public void decrement() {
		incorrect++;
		totalPoints -= 0.03;
	}
	
	public void viewStatistics(Scanner input) {
		/*
		 * This still needs testing on formatting
		 */
		System.out.println("**********************************");
		System.out.println("**********************************");
		System.out.println("**********************************");
		System.out.println("******                      ******");
		System.out.printf("******%-22s******\n", this.userName);
		System.out.printf("******Total Earnings $%.2f  ******\n", this.totalPoints);
		System.out.printf("******Total Correct  %2d     ******\n", this.correct);
		System.out.printf("******Total Incorrect %2d    ******\n", this.incorrect);
		System.out.println("******                      ******");
		System.out.println("**********************************");
		System.out.println("**********************************");
		System.out.println("**********************************");
		
		System.out.println("Press <ENTER> to continue.");
		input.nextLine();
		
		displayMenu();
		
	} // end of stats()
	
	/**
	 * Prompts the user to answer the sum of two randomly generated integers
	 * ranging from 1 to 10.<p>
	 * 
	 * If the user's answer is correct, the instance variable <b>correct</b> increases.</br>
	 * 
	 * If the user's answer is incorrect, the instance variable <b>incorrect</b> increases.
	 */

	public void generateAddition(Scanner input) {
		boolean correct;
		int sum;
		int userAnswer;
		String userInput;

		Scanner keyboardInput = new Scanner(System.in);

		int randomNumber1 = (int) (Math.random() * 10);
		int randomNumber2 = (int) (Math.random() * 10);

		// addition problem displayed to console 
		System.out.println("*****ADDITION*****");
		System.out.println("******************");
		System.out.printf ("*****%d + %d = ?****\n", randomNumber1, randomNumber2);
		System.out.println("******************");
		System.out.println("******************");
		
		
		
		userInput = input.nextLine();
		
		userAnswer = numberValidation(userInput);
		
		sum = randomNumber1 + randomNumber2;

		correct = (sum == userAnswer);

		if (!correct) {

			decrement();

			System.out.println("***********WRONG!***********");
			System.out.println();

			displayMenu();

		} else {
			
			System.out.println("***********RIGHT!***********");
			System.out.println();

			displayMenu();
			
			// increase the number of correct
			increment();

		}

		System.out.println();
		

	} // end of sum()
	
	/**
	 * Prompts the user to answer the product between two randomly generated
	 * integers ranging from 1 to 10.
	 * 
	 * @return
	 * true if the user answers correctly; false if the user answers incorrectly.
	 */

	public void generateMultiplication(Scanner input) {

		int randomNumber1, randomNumber2, product, userAnswer;
		String userInput;
		boolean correct;

		// a number 1 through 10 is generated
		randomNumber1 = (int) (Math.random() * 10);

		// a second number 1 though 10 is generated
		randomNumber2 = (int) (Math.random() * 10);

		// the product of two random numbers is calculated
		product = randomNumber1 * randomNumber2;

		// prompting the user for an answer
				System.out.println("***MULTIPLICATION***");
				System.out.println("********************");
				System.out.printf("*****%d X %d = ?******\n", randomNumber1, randomNumber2);
				System.out.println("********************");
				System.out.println("********************");

		// collecting user input
		userInput = input.nextLine();
		
		userAnswer = numberValidation(userInput);

		// determining whether userInput is correct

		correct = (product == userAnswer);

		if (!correct) {
			
			decrement();

			System.out.println("***********WRONG!***********");
			System.out.println();

			displayMenu();
			
		} else {
			System.out.println("***********RIGHT!***********");
			System.out.println();

			displayMenu(); 
			
			increment();
		}

	}
	

	public void generateDivision(Scanner input) {
		

		int randomNumber1, randomNumber2, product, quotient, userAnswer;
		String userInput;
		boolean correct;

		// a number 1 through 10 is generated
		randomNumber1 = 1 + (int) (Math.random() * 10);

		// a second number 0 though 9 is generated
		randomNumber2 = (int) (Math.random() * 10);

		product = randomNumber1 * randomNumber2;

		quotient = product / randomNumber1;

		// prompting the user for an answer
		System.out.println("******DIVISION******");
		System.out.println("********************");
		System.out.printf("*****%d / %d = ?*****\n", product, randomNumber1);
		System.out.println("********************");
		System.out.println("********************");

		// collecting user input
		userInput = input.nextLine();
		
		userAnswer = numberValidation(userInput);

		// determining whether userInput is correct

		correct = (quotient == userAnswer);

		if (!correct) {
			
			decrement();

			System.out.println("***********WRONG!***********");
			System.out.println();

			displayMenu();
			
		} else {
			increment();
			
			System.out.println("***********RIGHT!***********");
			System.out.println();

			displayMenu();
		}

	} // end of division
	
	/**
	 * Generates a subtraction math problem between two randomly generated integers whose
	 * difference is greater than or equal to 0. The user is prompted to answer the 
	 * question by entering a number as a String. The user input is validated to
	 * ensure that the input consists of only numbers greater than or equal 0 zero. In 
	 * addition, the input is validated to ensure that an empty String or special characters
	 * are not entered.
	 * <br></br>
	 * If the user answers the problem correctly, the number of correct answers is increased by
	 * one and the total number of points is increased by 0.05. If the user answers the problem
	 * incorrectly, the number of incorrect answers is increased by one and the total number of
	 * points is decreased by 0.03.
	 * 
	 * @param input
	 * a Scanner object used to read user input from the console.
	 */
	public void generateSubtraction(Scanner input) {
		
		boolean correct;
		String userInput;
		int subtractionAnswer, userAnswer;
		int randomNumber1, randomNumber2;
		int temporaryVariable;

		// generating random numbers
		randomNumber1 = (int) (Math.random() * 10);
		randomNumber2 = (int) (Math.random() * 10);


		// making randomNumber1 be greater to avoid a negative answer
		if (randomNumber2 > randomNumber1) {

			temporaryVariable = randomNumber1;

			randomNumber1 = randomNumber2;
			randomNumber2 = temporaryVariable;
		}

			// the answer of the problem is stored in subtraction
			subtractionAnswer = randomNumber1 - randomNumber2;

			// subtraction problem displayed to console 
			System.out.println("****SUBTRACTION****");
			System.out.println("*******************");
			System.out.printf ("*****%d - %d = ?*****\n", randomNumber1, randomNumber2);
			System.out.println("*******************");
			System.out.println("*******************");

			subtractionAnswer = randomNumber1 - randomNumber2;

			// collecting user input
			userInput = input.nextLine();

			// validating user input and storing in userAnswer
			userAnswer = numberValidation(userInput);

			// checking whether the answer is correct
			correct = (subtractionAnswer == userAnswer);

			if ( !correct ) {

				decrement();

				System.out.println("***********WRONG!***********");
				System.out.println();

				displayMenu();
			} else {
				
				increment();
				
				System.out.println("***********RIGHT!***********");
				System.out.println();

				displayMenu();
				
			}



	}
	
	/**
	 * Prints out the instance variables to the console and to a file.
	 * @throws IOException
	 */
	public void saveStats() throws IOException {
		
		String str = userName + ".txt";
		
		FileWriter file = new FileWriter(str, false);
		
		PrintWriter writeFile = new PrintWriter(file);
		
		/*
		System.out.printf("Total number of correct answers: %d\n", correct);
		System.out.printf("Total number of incorrect answers: %d\n", incorrect);
		System.out.printf("Total earnings: %.2f\n", this.totalPoints);
		System.out.printf("Thank you for playing %s!", this.userName);
		System.out.println();
		*/
		
		writeFile.println(correct);
		writeFile.println(incorrect);
		writeFile.printf("%.2f\n",totalPoints);
		writeFile.println(userName);
		writeFile.println();
		
		writeFile.close();
	} // end of printMathGame
	
	public void quit() {
		
		this.on = false;
	}
	
	
	public void openFile() throws IOException {
		
		File file = new File(userName + ".txt");
		
		if (file.exists()) {
			
			// Scanner object to read from file
			Scanner readFile = new Scanner(file);
			
			correct = readFile.nextInt();
			incorrect = readFile.nextInt();
			totalPoints = readFile.nextDouble();
			
			readFile.close();
		
		}
	
	
	}
	
}