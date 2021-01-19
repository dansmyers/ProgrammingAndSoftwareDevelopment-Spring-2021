// Test if a number is positive or negative
// CMS 167

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a number and I'll tell you if it's positive, negative, or zero.");
        int value = input.nextInt();
        
        if (value > 0) {
            System.out.println("Positive.");
        } else if (value < 0) {
            System.out.println("Negative.");
        } else {
            System.out.println("Zero.");
        }
    
    }

}
