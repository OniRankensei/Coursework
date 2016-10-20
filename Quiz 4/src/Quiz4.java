import java.util.Scanner;

public class Quiz4 {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		char continueFlag; // to test whether to continue
		
		// will run at least once pending condition at the end of branch
		do {
			// prompting user to type a number in binary
			System.out.println("Type a number in binary: ");
			
			// creating a String from user input
			String userInput = input.nextLine();
			
			// validating String to ensure the input is a binary number
			// and storing it to String variable binary
			String binary = userInputValidation(userInput);
			
			// parsing the String binary into an integer using the Integer.parse(String s, int radix) method
			int decimal = Integer.parseInt(binary, 2);
			
			// printing the conversion from binary to decimal to console
			System.out.printf("%s in binary base equals %d in decimal base.\n", binary, decimal);
			
			// prompting user to decide to continue or to exit
			System.out.println("\nPress y/Y to continue or press any other key to exit.");
			
			// reading user input and assigning to String variable userInput
			userInput = input.nextLine();
			
			// assigning the first character in the String input to variable cocntinueFlag
			continueFlag = userInput.charAt(0);
			System.out.println();
			
			// will continue while the char in continueFlag is y/Y
		} while (continueFlag == 'y' || continueFlag == 'Y');
		
		input.close();
		
		}
	
	public static String userInputValidation(String userInput) {
		
		int userInputLength = userInput.length(); // length of the String input
		int counter = 0; // used to iterate through a String's indexes 
		
		Scanner keyboardInput = new Scanner(System.in);
		
		// will continue to loop while the String is empty
		while (userInputLength == 0) {
			System.out.println("This is an invalid entry.");
			System.out.println("Please type a number in binary: ");
			userInput = keyboardInput.nextLine();
			userInputLength = userInput.length();			
		}
		
		// checking each index in a String from 0 to length of String - 1 (or last index)
		while (counter < userInputLength) {
			
			// validates that each character is either a 0 or a 1 at each index in a String
			if ( !(userInput.charAt(counter) == '0') && !(userInput.charAt(counter) == '1') ) {
				
				// prompts the user to try another entry
				System.out.println("This is an invalid entry.");
				System.out.println("Please type a number in binary: ");
				
				// reading input assigning it to userInput variable
				userInput = keyboardInput.nextLine();
				
				// getting the length of the string
				userInputLength = userInput.length();
				
				// resetting the counter to check each index from the beginning (at index 0)
				counter = 0;
				
			// will iterate to the next index if it satisfies both conditions
			} else {
				counter++;
				
			// double checking that the user does not type an empty String	
			} while (userInputLength == 0) {
				System.out.println("This is an invalid entry.");
				System.out.println("Please type a number in binary: ");
				userInput = keyboardInput.nextLine();
				userInputLength = userInput.length();
			}
		}
		return userInput; // returns the String after validation
	}
	
	

}
