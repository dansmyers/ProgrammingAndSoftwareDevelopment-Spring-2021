// Convert an input number of inches to cm
// CMS 121

import java.util.Scanner;

public class InchesToCentimeters {

    public static void main(String[] args) {
  
        // There are 2.54 cm per inch
        // Use final to declare a constant value
        // Constants are capitalized and underscored by convention
        final double CM_PER_INCH = 2.54;
    
        // Create a new Scanner
        Scanner input = new Scanner(System.in);
    
        // Use the nextInt method to read an integer from the terminal
        System.out.println("Enter a number of inches:");
        int inches = input.nextInt();
    
        // Convert: there are 2.54 cm per one inch
        double cm = inches * CM_PER_INCH;
   
        // Formatted output using printf
        // %.2f specifies a floating point value with two digits after the decimal place
        System.out.printf("That's %.2f centimeters.", cm);
    
    }

}
