import java.util.*;

public class Quiz4Test {

	public static void main(String[] args) {

		Quiz4v1 test = new Quiz4v1();

		test.addValue(1);
		test.addValue(0);
		test.addValue(0);
		test.addValue(0);
		test.addValue(0);
		test.addValue(0);

		test.printArrayList();
		
		test.convertTest();
		
		
		
		
	} // end of main

} // end of Quiz4Test class

class Quiz4v1 {

	public ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public ArrayList<Integer> secondArrayList = new ArrayList<Integer>();

	public Quiz4v1() {

	} // Constructor

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
	
} // end of Quiz4 clas