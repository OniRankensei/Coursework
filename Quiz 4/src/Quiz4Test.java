import java.io.PrintWriter;
import java.util.*;

public class Quiz4Test {

	public static void main(String[] args) {

		char continueFlag;
		String userInput;
		
		Scanner input = new Scanner(System.in);
		
		Quiz4v1 test = new Quiz4v1();

		/*
		test.addValue(1);
		test.addValue(0);
		test.addValue(0);
		test.addValue(0);
		test.addValue(0);
		test.addValue(1);
		 */
		
		do {
			test.createArray();
			test.printArrayList();
			test.convertTest();
			test.clearArray();
			
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

class Quiz4v1 {

	public ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public ArrayList<Integer> secondArrayList = new ArrayList<Integer>();

	public Quiz4v1() {

	} // Constructor
	
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

	public int lastIndexOf() {

		int lastIndexOf = this.arrayList.size() - 1;
		return lastIndexOf;
	}

	public void addValue(int value) {

		this.arrayList.add(value);

	}

	/**
	 * Returns an element from an Array List object.
	 * 
	 * @param index
	 *		an int. 
	 *
	 * @return
	 * 		an int.
	 */
	public int getValue(int index) {

		int value;
		value = this.arrayList.get(index);

		return value;
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
	
	public void printIndexAt(int index) {
		
		int value = this.arrayList.get(index);
		
		System.out.print(value);
		
	}
	
	public void printIndexAt2(int index) {
		
		System.out.print(this.arrayList.get(index));
	}
	
	// testing 
	public void toDecimalBaseTest() {
		
		int binaryBase = 2;
		int temp;
		
		// iterating through arrayList at each index bases on its size
		for (int counter = 0; counter < this.arrayList.size(); counter++) {
			
			// temp variable stores the value at each index
			temp = this.arrayList.get(counter);
			
			// temp is multiplied times 2^(n-1) per iteration
			temp = temp * (int) Math.pow(binaryBase, counter);
			
			// stores the new value in temp at each index
			this.arrayList.set(counter, (temp));
		}
		
		printArrayList();
		
	}
	
	/**
	 * Prints out the element of an array at each index. Prints out a line per
	 * index.
	 */
	
	public void printPerIndex() {
		
		int counter = 0;
		
		// iterating through each int element in arrayList
		for (int value : this.arrayList) {
			
			//printing out value at each index
			System.out.printf("At index %d: ", counter);
			System.out.println(value);
			
			// iterating through each index
			counter++;
			
		}
	}
	
	
	/**
	 * Prints out the sum of the elements in an Array List whose elements are integers.
	 * 
	 * @return
	 * 		an int.
	 */ 
	public int sumOfElements() {
		
		int sum = 0;
		
		for (int value: this.arrayList) {
			
			sum += value;
			
		}
		
		return sum;
	}
	
	// TESTING the reverse order of the array
	// ALMOST DONE. THIS IS THE MAIN CHALLENGE IN QUIZ 4 WHICH IS TO CONVERT A STRING
	// OF 0'S AND 1'S 
	// AND COVERT IT TO A DECIMAL NUMBER
	public void  convertTest() {
		
		/*
		 *  Reverses the order of the elements in the Array List using an
		 *  existing method reserve() defined in the Collections Class.
		 */
		Collections.reverse(this.arrayList);
		
		int counter = 0;
		int sum = 0;
		
		// adding the elements to a second Array List
		for (int value : this.arrayList) {
			
			secondArrayList.add(value);
			
		}
		
		// converting each element from binary to decimal base
		toDecimalBase();
		
		// getting the sum of the elements in the second Array List
		for (int value: secondArrayList) {
			
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