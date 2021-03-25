/**
 * Search Engine Project, v1.0
 * 
 * Open a text file, parse its contents, build an
 * index structure that maps words to the list of lines
 * where they occur
 */

package searchEngine;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class SearchEngineVer1 {
	
	// Declaration of the index structure
	HashMap<String, ArrayList<String>> index;
	
	
	/**
	 * Constructor -- initialize the index
	 */
	public SearchEngine() {
		this.index = new HashMap<String, ArrayList<String>>();
	}
	
	
	/**
	 * toString -- print the index
	 */
	public String toString() {
		return this.index.toString();
	}
	
	
	/**
	 * addFileToIndex -- Parse an input file and add its 
	 * words and lines to the index structure
	 * 
	 * @param fileName
	 */
	public void addFileToIndex(String fileName) {
		Scanner input = null;
		
		try {
			input = new Scanner(new File(fileName));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Iterate over the lines of the file
		while (input.hasNext()) {
			String line = input.nextLine();
			
			// Create a second Scanner to break the line
			// into its component words
			//
			// By default, the Scanner will break the line
			// into whitespace-delimited chunks
			System.out.println(line);
			
			Scanner words = new Scanner(line);
			while (words.hasNext()) {
				String word = words.next();
				
				// Move the word to lowercase
				word = word.toLowerCase();
				
				// Remove any punctuation marks
				word = word.replaceAll(",", "");
				word = word.replaceAll("\"", "");
				
				// Insert a mapping into the index
				
				// Initialize an empty ArrayList if the word is
				// not in the HashMap
				if (!this.index.containsKey(word)) {
					this.index.put(word, new ArrayList<String>());
				}
				
				// Add the word --> line pair into the index
				ArrayList<String> locations = this.index.get(word);
				
				if (!locations.contains(line)) {
					locations.add(line);
					this.index.put(word, locations);
				}
			}
		}
	}
	
	
	/**
	 * lookup -- return the lines associated with a word
	 * @param    word
	 * @return   The set of lines as an ArrayList<String>
	 */
	public ArrayList<String> lookup(String word) {
		return this.index.get(word);
	}
	

	/**
	 * Main -- test the SearchEngine class
	 * @param args
	 */
	public static void main(String[] args) {
		SearchEngine engine = new SearchEngine();
		
		// Add the contents of a file to the engine
		engine.addFileToIndex("test.txt");
		
		// Perform a lookup
		ArrayList<String> query = engine.lookup("bird");
		System.out.println(query);		
	}

}
