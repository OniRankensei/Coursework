import java.util.Scanner;
public class Quiz3 {
	public static void main(String[] args) {
		Scanner keyboardInput = new Scanner(System.in);
		
		// to be used to check whether the program should continue
		char continueFlag;
		
		// using do-while loop to run at least once
	do {
		
		// prompting user for input
		System.out.println("Enter a positive integer"
				+ " (quantity of pennies):");
		
		// taking input
		String inputEntered = keyboardInput.nextLine();
		
		// validating input, parsing to an int and storing in totalPennies
		int totalPennies = validation(inputEntered);
		
		// using the monetaryConverter method
		monetaryConverter(totalPennies);
		
		// prompting the user for a choice to continue
		System.out.println("To continue, press y/Y. Press any"
				+ " other key to end.");
		
		// taking input as a String object
		String userValue = keyboardInput.nextLine();
		
		// printing an empty line after each continuation
		System.out.println();
		
		// getting the character at index 0 and storing in char variable
		continueFlag = userValue.charAt(0);
		
		// determining whether to continue or to end
	} while (continueFlag == 'y' || continueFlag == 'Y');
	
	} // end of main method
	
	/**
	 * Given number a number of pennies, it calculates the least amount of
	 * quarters, dimes, nickels, and pennies it can be converted to. 
	 * If there is a total of 0 for any denomination of change, it will not display the denomination
	 * in question.
	 * 
	 * @param totalNumberOfPennies
	 * An integer number of pennies.
	 */

	public static void monetaryConverter(int totalNumberOfPennies) {
		
		// singular forms of each denomination of coins
		String quarter = "Quarter";
		String dime = "Dime";
		String nickel = "Nickel";
		String penny = "Penny";
		
		// calculating the number of quarters
		int numberOfQuarters = totalNumberOfPennies / 25;
		
		// calculating the remaining number of pennies
		totalNumberOfPennies = totalNumberOfPennies % 25;
		
		// calculating the number of dimes
		int numberOfDimes = totalNumberOfPennies / 10;
		
		// calculating the remaining number of pennies
		totalNumberOfPennies = totalNumberOfPennies % 10;
		
		// calculating the number of nickels
		int numberOfNickels = totalNumberOfPennies / 5;
		
		// calculating the remaining number of pennies
		totalNumberOfPennies = totalNumberOfPennies % 5;
		
		// the final remaining number of pennies
		int numberOfPennies = totalNumberOfPennies;
		
		System.out.println("\nThe least possible number of coins: ");
		
		// using singular or plural forms of monetary units
		// for quarter(s)
		if (!(numberOfQuarters == 0)) {
			
			if (!(numberOfQuarters == 1)) {
				
				quarter = "Quarters";
				
			}
			
			System.out.printf("%d %s\n", numberOfQuarters, quarter);
		}
		
		// using singular or plural forms of monetary units
		// for dime(s)
		if (!(numberOfDimes == 0)) {
			
			if (!(numberOfDimes == 1)) {
				
				dime = "Dimes";
			}
			
			System.out.printf("%d %s\n", numberOfDimes, dime);
			
		}
		
		// using singular or plural forms of monetary units
		// for nickel(s)
		if (!(numberOfNickels == 0)) {
			
			if (!(numberOfNickels == 1)) {
				
				nickel = "Nickels";
			}
			
			System.out.printf("%d %s\n", numberOfNickels, nickel);
			
		}
				
		// using singular or plural forms of monetary units
		// for penny(ies)
		if (!(numberOfPennies == 0)) {
			
			if (!(numberOfPennies == 1)) {
				
				penny = "Pennies";
			}
			
		System.out.printf("%d %s\n", numberOfPennies, penny);
		
		}
		
		System.out.println();
		
	} // end of monetaryConversion method
	
	/**
	 * Given a string, it validates the input to ensure the user entry is an integer greater than or equal to 0.
	 * @param userEntry
	 * A string.
	 * @return
	 * An int.
	 */
	public static int validation(String userEntry) {
		int userEntryLength = userEntry.length(); // length of String object
		int counter = 0; // variable to iterate
		
		Scanner keyboardInput = new Scanner(System.in);
		
		// validating to ensure that the input isn't empty
		while (userEntryLength == 0) {
			
			//prompting the user to make another entry
			System.out.println("This is an invalid entry.");
			System.out.println("Please enter the number of pennies"
					+ " as a positive integer:");
			
			// collecting user input
			userEntry = keyboardInput.nextLine();
			
			// checking the length of the String object
			userEntryLength = userEntry.length();			
		}
		
		// iterating through the index of the String object
		while (counter < userEntryLength) {
			
			// validating that each character is a number
			if (!Character.isDigit(userEntry.charAt(counter)) ) {
				
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter the number of pennies"
						+ " as a positive integer: ");
				
				userEntry = keyboardInput.nextLine();
				userEntryLength = userEntry.length();
				
				counter = 0;
				
			} else {
				
				counter++;
				
			} while (userEntryLength == 0) {
				
				System.out.println("This is an invalid entry.");
				System.out.println("Please enter the number"
						+ " of pennies as a positive integer: ");
				
				userEntry = keyboardInput.nextLine();
				userEntryLength = userEntry.length();
			}
		}
		
		// parsing the String object to an int and storing in intEntered
		int intEntered = Integer.parseInt(userEntry);
		
		return intEntered;
	}
	
} // end of Quiz3 class
