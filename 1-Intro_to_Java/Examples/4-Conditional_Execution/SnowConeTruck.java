// Snow cone truck -- validating user input 
// CMS 121

import java.util.Scanner;

public class ValidatingInput {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to the Snow Cone Truck.");
        System.out.println("1. Cherry");
        System.out.println("2. Blue Raspberry");
        System.out.println("3. Pina Colada");
        System.out.println("4. Tiger Blood");
        System.out.println("Please choose a flavor:");
        
        int choice = input.nextInt();
        
        if (choice < 1 || choice > 4) {
            System.out.println("That's not a valid choice.");
            return;
        }
        
        System.out.println("Great choice!");
    }
}
