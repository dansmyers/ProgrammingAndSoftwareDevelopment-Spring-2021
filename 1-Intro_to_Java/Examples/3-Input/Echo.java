// Read from the terminal and echo the input back
// CMS 121

// Use an import statement to add classes to your program
// System and Math are automatically available
// Others, like Scanner, have to be added manually

import java.util.Scanner;

public class Echo {

    public static void main(String[] args) {
  
        // Create a new Scanner to read from the console
        // new is the memory allocation keyword -- tells Java to allocate a new object
        // System.in is the standard console input
        Scanner input = new Scanner(System.in);
    
        // nextLine reads one line of input and returns it as a String
        // Notice: String is capitalized because it's an object, not a primitive type
        String line = input.nextLine();
    
        // Echo the String back
        System.out.println(line);
    }

}
