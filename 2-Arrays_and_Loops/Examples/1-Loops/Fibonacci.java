/**
 * Print the first 20 Fibonacci numbers
 *
 * @author CMS 167
 */

public class Fibonacci {

    public static void main(String[] args) {
    
        // Print the first two numbers
        System.out.println(0);
        System.out.println(1);
        
        int prev = 0;
        int curr = 1;
        
        for (int i = 3; i <= 20; i++) {
            
            // Calculate the next number in the sequence
            int next = prev + curr;
            System.out.println(next);
                 
            // Advance      
            prev = curr;
            curr = next;
        }
    
    }

}
