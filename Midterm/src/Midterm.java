import java.util.*;
import java.io.*;

public class Midterm {

	public static void main(String[] args) throws IOException {
		
	Scanner input = new Scanner(System.in);
		
		MathGame mathgame;
		mathgame = new MathGame();
		
		mathgame.setName();
		
		char continueGame;
		
		do {
			
			int choice;
			String userInput;
			
			System.out.println("Choose from the following:");
			System.out.println("1.addition, 2. subtraction");
			System.out.println("3.multiplication, 4. division");
			System.out.println("5.stats");
			
			userInput = input.nextLine();
			
			choice = numberValidation(userInput);
			
			switch (choice) {
			
			case 1: mathgame.sum();
					break;
			case 2: mathgame.difference();
					break;
			case 3: mathgame.product();
					break;
			case 4: mathgame.quotient();
					break;
			case 5: mathgame.stats();		
			default: 
					break;
					
			}
			
			/*
			mathgame.sum();
			mathgame.difference();
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
	 * 
	 * 
	 */
	public void quotient() {
		
		Scanner input = new Scanner(System.in);

		int randomNumber1, randomNumber2, product, quotient;
		int userInput;
		boolean correctAnswer;

		// a number 1 through 10 is generated
		randomNumber1 = 1 + (int) (Math.random() * 10);

		// a second number 1 though 10 is generated
		randomNumber2 = 1 + (int) (Math.random() * 10);

		product = randomNumber1 * randomNumber2;

		quotient = product / randomNumber1;

		// prompting the user for an answer
		System.out.printf("What is %d / %d?:\n", product, randomNumber1);

		// collecting user input
		userInput = input.nextInt();

		// determining whether userInput is correct

		correctAnswer = (quotient == userInput);

		if (!correctAnswer) {
			System.out.printf("Incorrect answer. %d * %d does not equal to %d.\n\n", product, randomNumber1, userInput);
		} else {
			System.out.printf("Correct. %d * %d = %d.\n\n", product, randomNumber1, userInput);
		}

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
		System.out.printf("The number of correct answers: %d\n", this.correct);
		System.out.printf("The number of incorrect answers: %d\n", this.incorrect);
		System.out.printf("Total earnings: %.2f\n", this.totalPoints);
	}
	
	/**
	 * Prompts the user to answer the sum of two randomly generated integers
	 * ranging from 1 to 10.<p>
	 * 
	 * If the user's answer is correct, the instance variable <b>correct</b> increases.</br>
	 * 
	 * If the user's answer is incorrect, the instance variable <b>incorrect</b> increases.
	 */

	public void sum() {
		boolean correct;
		int sum;
		int answer;
		String userInput;

		Scanner keyboardInput = new Scanner(System.in);

		int randomNumberOne = (int) (Math.random() * 10);
		int randomNumberTwo = (int) (Math.random() * 10);

		System.out.printf("What is %d + %d?\n", randomNumberOne, randomNumberTwo);
		
		userInput = keyboardInput.nextLine();
		
		answer = numberValidation(userInput);
		
		sum = randomNumberOne + randomNumberTwo;

		correct = (sum == answer);

		if (!correct) {

			System.out.printf("That is incorrect! %d + %d does not equal %d.\n", randomNumberOne, randomNumberTwo,
					answer);
			
			// increase the number of incorrect
			decrement();

		} else {

			System.out.printf("Correct! %d + %d = %d.\n", randomNumberOne, randomNumberTwo, answer);
			
			// increase the number of correct
			increment();

		}

		System.out.println();
		

	} // end of sum()
	
	/**
	 * Prompts the user to answer the difference between two randomly generated
	 * integers ranging from 1 to 10.
	 * 
	 * @return
	 * true if the user answers correctly; false if the user answers incorrectly.
	 */
	public void difference() {
		boolean correct;
		String userInput;
		int difference;
		int answer;

		Scanner keyboardInput = new Scanner(System.in);

		int randomNumberOne = (int) (Math.random() * 10);
		int randomNumberTwo = (int) (Math.random() * 10);

		if (randomNumberOne >= randomNumberTwo) {

			difference = randomNumberOne - randomNumberTwo;

			System.out.printf("What is %d - %d?\n", randomNumberOne, randomNumberTwo);

			userInput = keyboardInput.nextLine();
			
			answer = numberValidation(userInput);

			correct = (answer == difference);

			if (!correct) {

				System.out.printf("Incorrect! %d - %d does not equal %d.\n", randomNumberOne, randomNumberTwo,
						answer);

				System.out.println();

				decrement();

			} else {

				System.out.printf("Correct! %d - %d = %d.\n", randomNumberOne, randomNumberTwo, answer);
				System.out.println();
				
				increment();
			}

		} else {

			difference = randomNumberTwo - randomNumberOne;

			System.out.printf("What is %d - %d?\n", randomNumberTwo, randomNumberOne);

			userInput = keyboardInput.nextLine();
			
			answer = numberValidation(userInput);

			correct = (answer == difference);

			if (!correct) {

				System.out.printf("Incorrect! %d - %d does not equal %d.\n", randomNumberTwo, randomNumberOne,
						answer);
				
				System.out.println();
				
				decrement();

			} else {
				System.out.printf("Correct! %d - %d = %d.\n", randomNumberTwo, randomNumberOne, answer);
				System.out.println();
				
				increment();
				
			}

		}
		

	} // end of difference
	
	/**
	 * Prompts the user to answer the product between two randomly generated
	 * integers ranging from 1 to 10.
	 * 
	 * @return
	 * true if the user answers correctly; false if the user answers incorrectly.
	 */

	public void product() {
		Scanner input = new Scanner(System.in);

		int randomNumber1, randomNumber2, product;
		String userInput;
		boolean correct;

		// a number 1 through 10 is generated
		randomNumber1 = 1 + (int) (Math.random() * 10);

		// a second number 1 though 10 is generated
		randomNumber2 = 1 + (int) (Math.random() * 10);

		// the product of two random numbers is calculated
		product = randomNumber1 * randomNumber2;

		// prompting the user for an answer
		System.out.printf("What is %d * %d?:\n", randomNumber1, randomNumber2);

		// collecting user input
		userInput = input.nextLine();
		
		int answer = numberValidation(userInput);

		// determining whether userInput is correct

		correct = (product == answer);

		if (!correct) {
			System.out.printf("Incorrect answer. %d * %d does not equal to %d.\n\n", randomNumber1, randomNumber2,
					answer);
			decrement();
			
		} else {
			System.out.printf("Correct. %d * %d = %d.\n\n", randomNumber1, randomNumber2, answer);
			increment();
		}

	}
	

	public void quotient() {
		
		Scanner input = new Scanner(System.in);

		int randomNumber1, randomNumber2, product, quotient;
		String userInput;
		boolean correct;

		// a number 1 through 10 is generated
		randomNumber1 = 1 + (int) (Math.random() * 10);

		// a second number 1 though 10 is generated
		randomNumber2 = 1 + (int) (Math.random() * 10);

		product = randomNumber1 * randomNumber2;

		quotient = product / randomNumber1;

		// prompting the user for an answer
		System.out.printf("What is %d / %d?:\n", product, randomNumber1);

		// collecting user input
		userInput = input.nextLine();
		
		int answer = numberValidation(userInput);

		// determining whether userInput is correct

		correct = (quotient == answer);

		if (!correct) {
			System.out.printf("Incorrect answer. %d * %d does not equal to %d.\n\n",
					product, randomNumber1, answer);
			decrement();
		} else {
			System.out.printf("Correct. %d * %d = %d.\n\n", product, randomNumber1, answer);
			increment();
		}

	} // end of quotient
	
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