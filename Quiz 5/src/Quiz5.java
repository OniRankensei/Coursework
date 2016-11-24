import java.util.*;
import java.io.*;

public class Quiz5 {
	
	public static void main(String[] args) throws IOException, NoSuchElementException{
		
		// creating an instance of a Student object called list
		Student list = new Student();
		
		// creates an array of the Student type with a size of 20
		Student[] array = list.createArray(20);
		
		// opens file, scans data and populates data fields of each instance
		list.openFile();
		
		// creates a file with an instance of a Student's data in the format specified
		list.printToFile();
		
		
	} // end of main

} // end of Quiz5 class


class Student {
		
		// member fields
		private String firstName;
		private String lastName;
		private int testScore;
		private char grade;
		
		// array of the Student type
		Student[] studentArray;
		
		// default constructor
		public Student() {	
		}
		
		// sets data for an instance of a Student
		public void setData(String firstName, String lastName, int testScore) {
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.testScore = testScore;
			
		} // end of setData()
		
		/**
		 * Concatenates an instance of a Student's first name and last name
		 * in the following format:
		 * 
		 * Last Name, First Name
		 * 
		 * @return
		 * 		a String that concatenates the first and last name of a Student instance.
		 */
		public String fullName() {
			String str = this.lastName + ", " + this.firstName;
			return str;
		}
		
		/**
		 * Prints an instance of a Student's full name, test score and grade.
		 * @param writeFile
		 * 					an instance of a PrintWriter object to write to a file.
		 */
		public void printList(PrintWriter writeFile) {
			
			writeFile.printf("%-29s%-5d%4c \n",
					fullName(), this.testScore, this.grade);
		}
		
		/**
		 * Returns the test score of an instance of a Student.
		 * @return an int. The test score of an instance of a Student.
		 */
		public int getTestScore() {
			return this.testScore;
		}
		
		/**
		 * It invokes the calcuateGrade() method to calculate the grade of
		 * an instance of a Student object based on the object's test score.
		 * 
		 * @return an instance of a Student's grade represented by a letter
		 * A through F in the form of a primitive character type.
		 */
		public char getGrade() {
			this.grade = calculateGrade(testScore);
			return this.grade;
		}
		
		// sets the Grade of an instance of a Student
		public void setGrade() {
			this.grade = calculateGrade(testScore);
		}
		
		/**
		 * Creates an array of the Student type given the size of the array. In
		 * addition it creates an instance of a Student and adds the instance 
		 * reference as elements in each of the index of the array.
		 * 
		 * @param sizeOfArray the size of the array.
		 * 
		 * @return an array of the Student type with instances of a Student
		 * at each element.
		 */
		public Student[] createArray(int sizeOfArray) {
			
			/*
			 * Declares, creates and initializes an array
			 * of the Student type based on the
			 * size passes down as the argument in the parameter.
			 */
			studentArray = new Student[sizeOfArray];
			
			/*
			 * Creates and initializes an instance of a Student
			 * and stores each instance reference as an element in
			 * each of the array's indexes. 
			 */
			for (int i = 0; i < sizeOfArray; i++) {
				
				studentArray[i] = new Student();
				
			}
			
			return studentArray;
		}
		
		/**
		 * Opens a text file named "Data.txt" and read its contents. The contents of 
		 * this text file are read a Scanner object and its data is stored in each instance
		 * of a Student according to each instances field members. This information is stored
		 * in each Student instance in the array of the Student type.
		 * 
		 * @throws IOException
		 * @throws NoSuchElementException
		 * @throws InputMismatchException
		 */
		public void openFile() throws IOException, NoSuchElementException,InputMismatchException {
			
			File file = new File("Data.txt");
			
			if ( !file.exists() ) {
				System.out.println("This file does not exist.");
			}
			
			if (file.exists()) {
				
				try {
					// Scanner object to read from file
				Scanner readFile = new Scanner(file);
				
				/* 
				* Reads data from the file and stores it in each instance of 
				* a Student in the array of the Student type.
				*/
				for (Student student: this.studentArray) {
					
					/*
					 * The Scanner object reads the first of each data  type in 
					 * the file and stores this information in appropriate member
					 * variables for each instance of a Student in the array of the
					 * Student type.
					 */
					student.firstName = readFile.next();
					student.lastName = readFile.next();
					student.testScore = readFile.nextInt();
					
					// sets the grade in each instance of a Student in the array
					student.setGrade();
				}
				
				readFile.close();
			} catch (InputMismatchException e) {

			} catch (NoSuchElementException e){}
			
			} // end of if block
		
			exitMessage();
		
		} // end of openFile method
		
		
		/**
		 * Calculates the letter grade of an instance of a Student.
		 * @param testScore the test score of an instance of a Student.
		 * @return a char representation of the grade based on the test score.
		 */
		public char calculateGrade(int testScore) {
			
				

					if (testScore >= 90) {
						this.grade = 'A';
						return grade;
					} else if (testScore >= 80 && testScore < 90) {
						this.grade = 'B';
						return grade;
					} else if (testScore >= 70 && testScore < 80) {
						this.grade = 'C';
						return grade;
					} else if (testScore >= 60 && testScore < 70) {
						this.grade = 'D';
						return grade;
					} else {
						this.grade = 'F';
						return grade;
					} 
	
				
		}
		
		/**
		 * Writes a text file named Out.txt a list containing all
		 * the names of the Students, their test score and their letter grade
		 * formatted as specified. In addition, it checks for the highest 
		 * test score and writes to the file what the highest score is and
		 * the names of the Student(s) who earned such score.
		 * 
		 * 
		 * @throws IOException
		 */
		public void printToFile() throws IOException {
			
			FileWriter fileToWrite = new FileWriter("Out.txt");
			
			// creates an instance of a PrintWriter object to write to a file
			PrintWriter writeFile = new PrintWriter(fileToWrite);
			
			// header of the file
			writeFile.printf("%-23s%-5s%7s\n","Student Name", "Test Score", "Grade");
			
			// prints out to a file the list of Students from the Student array
			for (Student student: studentArray) {
				student.printList(writeFile);
			}
			
			// variable will hold the high score
			int highScore = studentArray[0].testScore;
			
			/*
			 * Iterates through each instance of a Student in the 
			 * array of the Student type and checks each testScore
			 * per each instance is higher than the testScore stored
			 * in the first instance of a Student, and the first element
			 * of the array at index 0.
			 */
			for (int i = 1; i < studentArray.length; i++) {
				if (studentArray[i].testScore > highScore) {
					highScore = studentArray[i].testScore;
				}
			}
			
			// prints out the highest score to the file
			writeFile.printf("\nHighest Test Score: %d.\n" , highScore);
			writeFile.println("Students having the highest test score:");
			
			/*
			 * Iterates through the array of the Student type to check
			 * for which instances of the Student class have the highest
			 * score and prints out their name to the file.
			 */
			for (int i = 0; i < studentArray.length; i++) {
				if (studentArray[i].testScore == highScore) {
					writeFile.printf("%s, %s\n", 
							studentArray[i].lastName, studentArray[i].firstName);
				}
			}
			
			writeFile.close();

			
		} // end of printToFile()
		
		public void exitMessage() {
			System.out.println("The file has been created.");
		}
		
	} // end of Student class
