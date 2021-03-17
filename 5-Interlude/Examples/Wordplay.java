/**
 * Write code to interact with a file of words
 * 
 * @author dmyers
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Wordplay {
	
	// Basic issue: file we want to open might not exist
	// Java "throws" a FileNotFoundException if that error occurs at runtime
	
	// Our program must include code to handle any thrown exceptions that
	// might occur while the program executes
	
	// Two ways to deal with thrown exceptions
	//
	// 1. Continue throwing the exception to a higher level part of the
	//    program that can handle it.
	//
	// Here, if an exception occurs we can "throw" it out of
	// readWords and up to main to deal with it there
	//
	// 2. Write code to "catch" and handle the exception close to where
	//    it occurs
	//
	// Use try-catch block
	
	public static void readWords() {
		
		// Recall: Java uses block scoping
		// Variables declared in a block are only visible in that block
		// Declare Scanner before the try block
		
		// null is the Java keyword for a deliberately
		// uninitialized object
		//
		// Declaring fileInput to be a deliberately uninitialized object
		// satisfies Java's expectations that it must exist
		Scanner fileInput = null;
		
		try {
		    fileInput = new Scanner(new File("words.txt"));
		} catch (FileNotFoundException e) {
			// catch block contains code to handle any exception that gets
			// generated by the try block
			
			// In this case, print a stack trace and exit
			e.printStackTrace();
		}
		
		// Read lines from the file
		// The hasNext() method returns true when there is more stuff to read
		while (fileInput.hasNext()) {
			String line = fileInput.nextLine();
			
			if (line.charAt(0) == 'q' && line.charAt(1) != 'u') {
			    System.out.println(line);
			}
		}
		
	}

	public static void main(String[] args) {
		readWords();
	}

}
