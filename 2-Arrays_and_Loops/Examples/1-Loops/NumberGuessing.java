/**
 * Number guessing game
 * 
 * @author CMS 167
 */
 
import java.util.Scanner;
 
public class NumberGuessing {
    
    public static void main(String[] args) {
        
        int number = 777;
        int guessesRemaining = 10;
        boolean guessed = false;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("I'm thinking of a number between 1 and 1000. Can you guess it?");
        
        while (guessesRemaining > 0) {
            System.out.printf("You have %d guesses remaining.\n", guessesRemaining); 
            System.out.println("Guess a number:");
            int guess = input.nextInt();
            
            if (guess < number) {
                System.out.println("Too low.");
            } else if (guess > number) {
                System.out.println("Too high.");
            } else {
                System.out.println("That's it!");
                guessed = true;
                break;
            }
            
            guessesRemaining--;
        }
        
        if (!guessed) {
            System.out.println("Sorry. Better luck next time.");
        }
        
    }
    
}
