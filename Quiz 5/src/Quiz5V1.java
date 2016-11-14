import java.util.*;
import java.io.*;

public class Quiz5V1 {
	
	public static void main(String[] args) throws IOException, NoSuchElementException{
		
		Student test = new Student();
		
		// creates an array of the Student type with a size of 20
		Student[] array = test.createArray(20);
		
		// opens file, scans data and populate data fields of each instance
		test.openFile();
		
		// prints out to console the formated list of students and their data
		test.printToConsole();
		test.printToFile();
		
	}

}


class Student {
		
		// fields
		private String firstName;
		private String lastName;
		private int testScore;
		private char grade;
		
		Student[] studentArray;
		
		// default constructor
		public Student() {	
		}
		
		public void setData(String firstName, String lastName, int testScore) {
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.testScore = testScore;
			
		} // end of setData()
		
		public void printData() {
			
			System.out.printf("%s, %s %d %c \n",
					this.lastName, this.firstName, this.testScore, this.grade);
			
		} // end of  printData()
		
		public void printList(PrintWriter writeFile) {
			
			writeFile.printf("%s, %s %d %c \n",
					this.lastName, this.firstName, this.testScore, this.grade);
		}
		
		public int getTestScore() {
			return this.testScore;
		}
		
		public char getGrade() {
			this.grade = calculateGrade(testScore);
			return this.grade;
		}
		
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
		
		public void highTestScore() {
			
			int highScore = studentArray[0].testScore;
			
			for (int i = 1; i < studentArray.length; i++) {
				if (studentArray[i].testScore > highScore) {
					highScore = studentArray[i].testScore;
				}
			}
			
			System.out.printf("\nHighest Test Score: %d.\n" , highScore);
			System.out.println("Students having the highest test score:");
			
			for (int i = 0; i < studentArray.length; i++) {
				if (studentArray[i].testScore == highScore) {
					System.out.printf("%s, %s\n", 
							studentArray[i].lastName, studentArray[i].firstName);
				}
			}
		}
		
		
		
		public void printToConsole() {
			
			System.out.printf("Student Name Test Score Grade\n");
			for (Student student: studentArray) {
				student.printData();
			}
			
			highTestScore();
		}
		
		public void printToFile() throws IOException {
			
			FileWriter fileToWrite = new FileWriter("Out.txt");
			
			PrintWriter writeFile = new PrintWriter(fileToWrite);
			
			writeFile.printf("Student Name Test Score Grade\n");
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
		
	} // end of Student class
