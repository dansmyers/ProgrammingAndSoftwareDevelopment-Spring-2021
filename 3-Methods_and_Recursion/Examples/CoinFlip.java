// Use a method to test if a number is even or odd
// CMS 167

// Example of using an if statement inside a method

// There are multiple ways to represent and implement a two-value variable
// like a coin flip. This example uses 1 for heads and 0 for tails.

public class CoinFlip {

    public static int flip() {
        double r = Math.random();
        
        if (r < .5) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        int coin = flip();
        
        if (coin == 1) {
            System.out.println("Heads!");
        } else {
            System.out.println("Tails!);
        }
    }

}
