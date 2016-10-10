import java.util.Scanner;
public class Quiz3 {
	public static void main(String[] args) {
		Scanner keyboardInput = new Scanner(System.in);
		
		char sentinelValue;
		
	do {
		// prompting user for input
		System.out.println("Enter a positive integer"
				+ " (quantity of pennies)");
		// taking input
		String inputValue = keyboardInput.nextLine();
		
		int money = validation(inputValue);
		
		// using the monetaryConverter method
		monetaryConverter(money);
		
		System.out.println("To continue, press y/Y. Press any"
				+ " other key to end.");
		
		String userValue = keyboardInput.nextLine();
		sentinelValue = userValue.charAt(0);
		
	} while (sentinelValue == 'y' || sentinelValue == 'Y');
	
	} // end of main method
	
	/**
	 * Given number of an integer totalNumberOfPennies, it calculates the least amount of
	 * quarters, dimes, nickels, and pennies it can be converted to. 
	 * If there is a total of 0 for any denomination, it will not display the denomination
	 * in question.
	 * 
	 * @param totalNumberOfPennies
	 * An integer number of pennies.
	 */

	public static void monetaryConverter(int totalNumberOfPennies) {
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
	 * Given a string, it validates the input to ensure the user entry is an integer.
	 * @param userAnswer
	 * A string.
	 * @return
	 * An int.
	 */
	public static int validation(String userAnswer) {
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
			if (!Character.isDigit(userAnswer.charAt(counter)) ) {
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
		int newInt = Integer.parseInt(userAnswer);
		return newInt;
	}
	
} // end of Quiz2 class