// Smoot calculator using variables
// CMS 121

// What is the height of the Burj Khalifa (2722 feet) in Smoots?
// Each Smoot is about 5.5833 feet.

public class Smoots {

    public static void main(String[] args) {
    
        // Variable naming tips:
        // 1. Use descriptive names. For the most part, avoid single letters.
        // 2. Start with a lowercase letter.
        // 3. Capitalize any words after the first (you can't use spaces in a variable name).
    
        int heightInFeet = 2722;
    
        // Use the double type for decimal numbers
        // double stands for "double precision floating point" and refers to the way the number is represented in memory
      
        // A final variable is a constant and is named using ALL_CAPS
    
        final double FEET_PER_SMOOT = 5.5833;
    
        double heightInSmoots = heightInFeet / feetPerSmoot;
    
        // Use System.out.printf for formatted printing.
        // %.2f is a *format specifier*
        // When this statement prints, Java replaces %.2f with the value of heightInSmoots
        // The f indicates that the variable is a floating point type
        // The .2 tells Java to print only two values after the decimal point
    
        System.out.printf("The Burj Khalifa is %.2f Smoots tall.", heightInSmoots);
    
    }

}
