/**
 * Write code to interact with a file of words
 * 
 * @author dmyers
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Wordplay {
	
	public static void readWords() {
		
		Scanner fileInput = null;
		
		try {
		    fileInput = new Scanner(new File("words.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
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
