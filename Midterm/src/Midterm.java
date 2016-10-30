import java.util.*;
import java.io.*;

public class Midterm {

	public static void main(String[] args) throws IOException {
		
	Scanner input = new Scanner(System.in);
		
		MathGame mathgame;
		mathgame = new MathGame();
		
		mathgame.setName();
		
		char continueGame;
		
		mathgame.menu();
		
		do {
			
			int choice;
			String userInput;
			
			userInput = input.nextLine();
			
			choice = numberValidation(userInput);
			
			switch (choice) {
			
			case 1: mathgame.addition(input);
					break;
			case 2: mathgame.subtraction(input);
					break;
			case 3: mathgame.product(input);
					break;
			case 4: mathgame.quotient(input);
					break;
			case 5: mathgame.stats();		
			default: 
				System.out.println("That is not a valid entry, please enter another choice.");
				
					break;
					
			}
			
			/*
			mathgame.sum();
			mathgame.subtraction();
			mathgame.product();
			mathgame.quotient();
			 */
			
			System.out.println("Would you like to cotinue?");
			System.out.println("Press 'y/Y' to continue.");
			
			String inputString = input.nextLine();
			
			continueGame = inputString.charAt(0);
			
			System.out.println(); // newline feed
			
		} while (continueGame == 'y' || continueGame == 'Y');
		
		mathgame.printMathGame();
		
		input.close();
		
		
	}
	
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
	public static String nameValidation(String userInput) {
		
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
	}
	
}


class MathGame extends Midterm {
	
	String userName;
	String fileName;
	
	int correct;
	int incorrect;
	
	double totalPoints = 0.0;
	
	// Constructor
	MathGame() {
		
	}
	
	public void setName() {
		
		Scanner input = new Scanner(System.in);
		
		String userInput; 
		
		System.out.println("Please enter your name:");
		
		userInput = input.nextLine();
		
		userInput = nameValidation(userInput);
		
		this.userName = userInput;
		
	}
	
	public void menu() {
		
		// prints out the menu
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
	
	public void increment() {
		correct++;
		totalPoints += 0.05;
	}
	
	public void decrement() {
		incorrect++;
		totalPoints -= 0.03;
	}
	
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	
	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}
	
	public void setPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	public void stats() {
		// DO NOT REMOVE THE LINE WITH TOTAL EARNINGS $0.08
		// THIS LINE IS AN EXAMPLE OF THE LENGTH IT SHOULD BE
		// there are 22 characters in the empty space
		System.out.println("**********************************");
		System.out.println("**********************************");
		System.out.println("**********************************");
		System.out.println("******                      ******");
		System.out.printf("******%-22s******\n", this.userName);
		System.out.printf("******Total Earnings $%.2f  ******\n", this.totalPoints);
		System.out.printf("******Total Correct  %2d     ******\n", this.correct);
		System.out.printf("******Total Incorrect %2d    ******\n", this.incorrect);
		System.out.printf("******Total Earnings $0.08  ******\n");
		System.out.println("******                      ******");
		System.out.println("**********************************");
		System.out.println("**********************************");
		System.out.println("**********************************");
		
		
		System
		
	}
	
	/**
	 * Prompts the user to answer the sum of two randomly generated integers
	 * ranging from 1 to 10.<p>
	 * 
	 * If the user's answer is correct, the instance variable <b>correct</b> increases.</br>
	 * 
	 * If the user's answer is incorrect, the instance variable <b>incorrect</b> increases.
	 */

	public void addition(Scanner input) {
		boolean correct;
		int sum;
		int answer;
		String userInput;

		Scanner keyboardInput = new Scanner(System.in);

		int randomNumberOne = (int) (Math.random() * 10);
		int randomNumberTwo = (int) (Math.random() * 10);

		// addition problem displayed to console 
		System.out.println("*****ADDITION*****");
		System.out.println("******************");
		System.out.printf ("*****%d + %d = ?****\n", randomNumberOne, randomNumberTwo);
		System.out.println("******************");
		System.out.println("******************");
		
		
		
		userInput = input.nextLine();
		
		answer = numberValidation(userInput);
		
		sum = randomNumberOne + randomNumberTwo;

		correct = (sum == answer);

		if (!correct) {

			decrement();

			System.out.println("***********WRONG!***********");
			System.out.println();

			menu();

		} else {
			
			System.out.println("***********RIGHT!***********");
			System.out.println();

			menu();
			
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

	public void product(Scanner input) {

		int randomNumber1, randomNumber2, product, userAnswer;
		String userInput;
		boolean correct;

		// a number 1 through 10 is generated
		randomNumber1 = 1 + (int) (Math.random() * 10);

		// a second number 1 though 10 is generated
		randomNumber2 = 1 + (int) (Math.random() * 10);

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

			menu();
			
		} else {
			System.out.println("***********RIGHT!***********");
			System.out.println();

			menu(); 
			
			increment();
		}

	}
	

	public void quotient(Scanner input) {
		

		int randomNumber1, randomNumber2, product, quotient, userAnswer;
		String userInput;
		boolean correct;

		// a number 1 through 10 is generated
		randomNumber1 = 1 + (int) (Math.random() * 10);

		// a second number 1 though 10 is generated
		randomNumber2 = 1 + (int) (Math.random() * 10);

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

			menu();
			
		} else {
			increment();
			
			System.out.println("***********RIGHT!***********");
			System.out.println();

			menu();
		}

	} // end of quotient
	
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
	public void subtraction(Scanner input) {
		
		boolean correct;
		String userInput;
		int subtractionAnswer, userAnswer;
		int randomNumber1, randomNumber2;
		int temporaryVariable;

		// generating random numbers
		randomNumber1 = 1 + (int) (Math.random() * 10);
		randomNumber2 = 1 + (int) (Math.random() * 10);


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

				menu();
			} else {
				
				increment();
				
				System.out.println("***********RIGHT!***********");
				System.out.println();

				menu();
				
			}



	}
	
	/**
	 * Prints out the instance variables to the console and to a file.
	 * @throws IOException
	 */
	public void printMathGame() throws IOException {
		
		FileWriter file = new FileWriter("MathTextFile.txt", true);
		PrintWriter writeFile = new PrintWriter(file);
		
		System.out.printf("Total number of correct answers: %d\n", correct);
		System.out.printf("Total number of incorrect answers: %d\n", incorrect);
		System.out.printf("Total earnings: %.2f\n", this.totalPoints);
		System.out.printf("Thank you for playing %s!", this.userName);
		System.out.println();
		
		writeFile.printf("Total number of correct answers: %d\n", correct);
		writeFile.printf("Total number of incorrect answers: %d\n", incorrect);
		writeFile.printf("Total earnings: %.2f\n", this.totalPoints);
		writeFile.printf("Thank you for playing %s!", this.userName);
		writeFile.println();
		
		writeFile.close();
	} // end of printMathGame
}
