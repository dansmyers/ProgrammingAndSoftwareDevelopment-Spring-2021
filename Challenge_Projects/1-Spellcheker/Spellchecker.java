/**
 * Spellchecker
 *
 * CMS 121
 */
 
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Spellchecker {

    // Instance variable: HashSet that holds the set of all words
    private HashSet<String> words;
    
    
    /**
     * Constructor -- initialize the HashSet and read in the words from the given file
     *
     * @param    wordFile    File containing the reference words for the Spellchecker
     */
    public Spellchecker(String wordFile) {
    
        Scanner input = null;
       
        try {
            input = new Scanner(new File(wordFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        while (input.hasNext()) {
            // Read the nextLine from the Scanner
            
            // Add that word to the HashSet (using this.words.add)
        }
        
        input.close();
    
    }
    
    
    /**
     * search -- return true if the set contains the given word, false otherwise
     * 
     * @param    searchWord
     */
    public boolean search(String searchWord) {
        
        // Convert to lowercase
        String lower = searchWord.toLowerCase()
    
        // Use the contains method of HashSet to check if this.words contains lower
        
    }
    
    
    /**
     * suggestions -- given a word, look for alternate spellings that could be valid words
     */
    public ArrayList<String> suggestions(String word) {
        
        // Empty ArrayList<String> to hold the possible replacement words
        ArrayList<String> alternates = new ArrayList<String>();
        
        // Find all valid words that can be created by substituting a letter
        String letters = "abcdefghijklmnopqrstuvwxyz";
        
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < letters.length(); j++) {
            
                // Construct a candidate word
                //
                // The first substring gets the letters from index 0 to i - 1
                // The letter at position i is replaced by a different letter
                // The second substring gets the remaining letters from i + 1 to word.length() - 1
                
                String candidate = word.substring(0, i)
                                   + letters.charAt(j) + word.substring(i+1, word.length());
                
                // Check if the canddiate word is valid by searching the word set
                if (this.search(candidate)) {
                    alternates.add(candidate);
                }
            }
        }
        
        // Find all valid words that can be created by deleting a letter
        
        
        // Find all valid words that can be created by inserting a letter
        
        
        // Return the final list of possible alternate words
        return alternates
    }
    
    
    /**
     * spellcheck -- takes a string as input and spellchecks each word
     *
     * @param    line    a line of text to spellcheck
     */
    public void spellcheck(String line) {
        
        // Create a Scanner to break the line into individual words
        Scanner s = new Scanner(line);
        
        while (s.hasNext()) {
            String w = s.next();
            
            // Use the search method to check if w is in this.words
            
            // If not, it might be misspelled
            //
            // Call the suggestions method to generate an ArrayList<Strring> representing
            // possible correct spellings
            //
            // Print the misspelled word and all of the possible correct spellings
            // returned by suggestions
        }
    }


    /**
     * main -- testing
     * 
     * DO NOT EDIT MAIN
     */
    public static void main(String[] args) {

        // Create a new Spellchecker using the words.txt list
        Spellchecker checker = new Spellchecker("words.txt");
        
        // Check some lines of text
        checker.spellcheck("Tere once wass a grrl named Lenore");
        checker.spellcheck("Annd a brd and a bhst and a dooor");
        checker.spellcheck("And a gux with deprssion");
        checker.spellcheck("And a whole lot of uestions");
        checker.spellcheck("And the bir allways says Nevermore");
    
    }
    
}
