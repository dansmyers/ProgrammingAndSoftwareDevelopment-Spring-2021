/**
 * Recursive countdown program
 */
 
public class Countdown {

    public static void countdown(int n) {
        if (n <= 0) {
            System.out.println("Blastoff!");
        }
        
        System.out.println(n);
        countdown(n - 1);
    }
    
    
    public static void main(String[] args) {
        countdown(3);
    }

}
