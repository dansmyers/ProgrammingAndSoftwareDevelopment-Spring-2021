// Verifying that input is valid
// CMS 167

// Example problem: convert miles to kilometers

import java.util.Scanner;

public class InputValidation {

    public static void main(String[] args) {
        
        // There are about 1.60934 km per mile
        final double KM_PER_MILE = 1.60934;
        
        // Create a new Scanner
        Scanner input = new Scanner(System.in);
        
        // Read a double valued number of miles
        System.out.println("Enter a number of miles:");
        double miles = input.nextDouble();
        
        // Check if the input is reasonable
        // If not, print a message and exit immediately
        if (miles < 0) {
            System.out.println("Please enter a non-neagtive number of miles.");
            return;
        }
        
        // Convert
        double km = miles * KM_PER_MILE;
        
        // Formatted output
        System.out.printf("There are about %.2f km in %.2f miles.\n", km, miles);
        
    }
    
}
