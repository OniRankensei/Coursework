import java.util.*;

public class Quiz4Client {

	public static void main(String[] args) {

		char continueFlag;
		String userInput;
		
		Scanner input = new Scanner(System.in);
		
		Quiz4 list = new Quiz4();
		
		do {
			// creates an Array List after validating user input for a binary String
			list.createArray();
			
			// prints the contents of the array
			list.printArrayList();
			
			// converts the integer elements of an Array List into a decimal number
			list.convert();
			
			// clears all the elements in the array
			list.clearArray();
			
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
		
		
		
	} // end of main
	
	

} // end of Quiz4Test class

class Quiz4 {
	
	// two public Array Lists to be accessed by instance methods 
	public ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public ArrayList<Integer> secondArrayList = new ArrayList<Integer>();

	// constructor
	public Quiz4() {

	}
	
	/**
	 * Creates an Array List and adds integer elements from user input. The user is prompted
	 * to enter a String consisting of a binary number consisting only of the numbers "0" and "1".
	 * After validating, each "0" and "1" is individually added to the Array List that was created.
	 */
	
	public void createArray() {

		String userInput;
		int temporaryVariable;

		// creating a new Scanner object referenced by variable input
		Scanner input = new Scanner(System.in);

		// prompting user input
		System.out.println("Enter a positive integer greater" + " than 0.");

		// collecting user input as a String
		userInput = input.nextLine();
		userInput = userInputValidation(userInput);

		// printing out to console the elements of the Array List
		System.out.printf("The original number is: ", userInput);

		// converting each digit character into an int and adding to ArrayList
		for (int counter = 0; counter < userInput.length(); counter++) {

			// converting each digit character into an int
			temporaryVariable = Character.getNumericValue(userInput.charAt(counter));

			// adding int to integerArrayList at index counter
			this.arrayList.add(temporaryVariable);


		} // end of for loop
		

	} // end of integerArrayListTest()
	
	/**
	 * Removes all the elements the instance of the Array List.
	 */
	
	public void clearArray() {
		
		// removes all the elements in the Array List
		this.arrayList.clear();
	}

	/**
	 * Prints out the elements of the ArrayList in sequential order enclosed in "< >" and separated by
	 * commas.
	 */
	public void printArrayList() {

		System.out.print("< ");

		for (int element : this.arrayList) {

			if (element == this.arrayList.get(0)) {

				System.out.printf("%d, ", element);

			} else if (element == this.arrayList.get(this.arrayList.size() - 1)) {

				System.out.printf("%d", element);

			} else {

				System.out.printf("%d, ", element);

			}

		}

		System.out.print(" >\n");
	}
	
	
	// TESTING the reverse order of the array
	// ALMOST DONE. THIS IS THE MAIN CHALLENGE IN QUIZ 4 WHICH IS TO CONVERT A STRING
	// OF 0'S AND 1'S 
	// AND COVERT IT TO A DECIMAL NUMBER
	public void  convert() {
		
		/*
		 *  Reverses the order of the elements in the Array List using an
		 *  existing method reserve() defined in the Collections Class.
		 */
		Collections.reverse(this.arrayList);
		
		int counter = 0;
		int sum = 0;
		
		// iterating through the elements in An Array List
		for (int value : this.arrayList) {
			
			// adds the elements of the first array to a second Array List
			secondArrayList.add(value);
			
		}
		
		/**
		 * The sum of the elements in this second Array List are added which 
		 * will result in the the final decimal conversation.
		 */
		
		// converting each element from binary to decimal base
		toDecimalBase();
		
		// getting the sum of the elements in the second Array List
		for (int value: secondArrayList) {
			
			// adding each binary conversion to a decimal number
			sum += value;
		}
		
		// printing the value of the binary number as a decimal number
		System.out.println("The decimal number is: " + sum);
		
		//clearing the sum for future iterations
		secondArrayList.clear();
		sum = 0;
	}
	
	
	/**
	 * Converts each element in an Array List from a binary base to a 
	 * decimal base. 
	 */
	public void toDecimalBase() {
		
		final int BINARY_BASE = 2; // binary base
		int temp; // temporary variable
		
		// iterating through arrayList at each index bases on its size
		for (int counter = 0; counter < this.secondArrayList.size(); counter++) {
			
			// temp variable stores the value at each index
			temp = this.secondArrayList.get(counter);
			
			// temp is multiplied times 2^(n-1) per iteration
			temp = temp * (int) Math.pow(BINARY_BASE, counter);
			
			// stores the new value in temp at each index
			this.secondArrayList.set(counter, (temp));
		}
		
	}
	
	/**
	 * Validates that a String consists of only digits "0" and "1". If the String is empty,
	 * the user is prompted to make another entry.
	 * 
	 * @param userInput a String taken from user input.
	 * 
	 * @return
	 * 	a String after validation.
	 */
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
	
} // end of Quiz4 clas