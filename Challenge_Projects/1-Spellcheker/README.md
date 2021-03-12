# Challenge Project: Spellcheker

## Description

In this project, you'll use `ArrayList` and file operations to implement a spelling checker tool. On creation, the checker will open a large list of common
English words and construct a `HashSet` to store them. The checker can then search the set to determine if it contains a given input word; if not, the word is either
uncommon or misspelled. For additional fun, your checker will support a method to suggest possible corrections to misspelled words.

This project will allow you to practice the following:

- Working with files.

- Using the documentation to work with a bulit-in Java class.

- Looping over strings and performing string operations.

- Using `Scanner` to parse the contents of a `String`.

Like our other object-oriented programming projects, no individual part will be that complicated. Most of the challenge of this project is in understanding how the
different parts fit together to accomplish the overall goal of spellchecking 


## Submission

Submit your code an assignment that I'll create on Canvas. To get satisfactory credit for the project, implement all of the methods described below and return correct 
spellchecking output for the examples given in the `main` of the `Spellchecker` starter code that I've provided.


## The `Spellchecker` Class

### Methods

Implement a class called `Spellchecker` that provides the following methods:

- `public Spellchecker(String wordFile)`: constructor that opens the given word file and builds a `HashSet` of the words it contains

- `public boolean search(String searchWord)`: search the tree for the given input word; return `true` if it is present and `false` otherwise

- `public ArrayList<String> suggestions(String word)`: return a list of words that could be correct alternatives for the given input word

- `public void spellcheck(String line)`: read the words in the line and spell check each one; print all of the misspelled words along with their suggestions

### Starter Code

The code below is included in `Spellchecker.java` for you to use as a starting point. Use the given `main` to test your program.

```
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
        String lower = searchWord.toLowerCase();
    
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
        return alternates;
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
```

## Tips


### `HashSet`

`HashSet` is a built-in Java class used to represent a **set** of objects. Recall that a mathematical set is defined to be an **unordered collection**. 
Like `HashMap`, `HashSet` is designed to perform quick lookups: It's easy to check if a given word is contained in the set.

To add it to your program, put the line

```
import java.util.HashSet;
```

at the top of the class.

`HashSet` supports two basic methods: `add`, to put a new item into the set, and `contains`, to check if the set contains a given item. Take a look at [the official
Java documentation for `HashSet`](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html) for more information on how to use them.


### Constructor

The code for the constructor is similar to our other file reading programs: use a `try`-`catch` block to open the file, iterate through its lines, and do something with
each one. In this case, you want to `add` each word in the file to `this.words` to build the valid set for the spellchecker to use later.

### `search`

This method is short. Look up the `contains` method of `HashSet` in the documentation and use it to test if the given word is in `this.words`.

### `suggestions`

This is by far the most challenging part of the project. Study the code that I've already given you carefully and use it to help write the two missing parts.

`suggestions` returns an `ArrayList<String>` containing possible corrections to its input `String`. In your implementation, the corrections that are returned will be the words in the set that have an **edit distance** of 1 from the input word. An edit is one of the following operations:

- Inserting a new character into the word, including a new character at the beginning or end. For example, `best` could become `beast` or `bests`, among other options.

- Substituting one character of the word with another character. For example, `cat` could become `tat`, `cut`, or `car`, among many other possibilities.

- Deleting one character from the word. For example, `chain` could become `chin` or `chai`.

Therefore, your `suggestions` method can work by taking the input word, generating all possible `String`s that have an edit distance of 1, and returning the subset of those that exist in the valid word set.

I've given you code to generate all of the possible substitutions. Look at it carefully and use it as a starting point for generating the deletions and insertions, which 
you can do with only a few modifications.

### `spellcheck`

This method uses the technique of creating a `Scanner` to break a `String` into its individual whitespace-delimited words. Use `search` to check if each word is in the
valid set. If it is not, use `suggestions` to get the list of potential alternate words.

Note: You don't need to do anything to process the suggestions or choose the "best" suggestion. Just print the possibly misspelled word and then the list of suggestions.
You should be able to verify that the suggestions are all one edit away from the starting word.

