import java.util.Scanner;

public class Quiz4TestV2 {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		char continueFlag;
		
		do {
			// prompting user to type a number in binary
			System.out.println("Type a number in binary: ");
			// creating a String from user input
			String userInput = input.nextLine();
			// validating String to ensure the input is a binary number
			String binary = userAnswerValidation(userInput);
			// parsing the input String into an integer
			int decimal = Integer.parseInt(binary, 2);
			System.out.printf("%s in binary base equals %d in decimal base.\n", binary, decimal);
			
			System.out.println("\nPress y/Y to continue or press any other key to exit.");
			userInput = input.nextLine();
			continueFlag = userInput.charAt(0);
			System.out.println();
			
		} while (continueFlag == 'y' || continueFlag == 'Y');
		
		input.close();
		
		}
	
	public static String userAnswerValidation(String userAnswer) {
		int userAnswerLength = userAnswer.length();
		int counter = 0;
		
		Scanner keyboardInput = new Scanner(System.in);
		
		while (userAnswerLength == 0) {
			System.out.println("This is an invalid entry.");
			System.out.println("Please enter your answer as an integer:");
			userAnswer = keyboardInput.nextLine();
			userAnswerLength = userAnswer.length();			
		}
		while (counter < userAnswerLength) {
			/*if (!Character.isDigit(userAnswer.charAt(counter)) || !(userAnswer.matches("[01]+")) ) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter your answer as an integer: ");
				userAnswer = keyboardInput.nextLine();
				userAnswerLength = userAnswer.length();
				counter = 0;
			*/
			
			if ( !(userAnswer.charAt(counter) == '0') && !(userAnswer.charAt(counter) == '1') ) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter your answer as an integer: ");
				userAnswer = keyboardInput.nextLine();
				userAnswerLength = userAnswer.length();
				counter = 0;
				
			} else {
				counter++;
				
			} while (userAnswerLength == 0) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter your answer as an integer: ");
				userAnswer = keyboardInput.nextLine();
				userAnswerLength = userAnswer.length();
			}
		}
		return userAnswer;
	}
	
	

}
