// Use a method to generate and return a die roll
// CMS 167

public class DieRoll {

    // Generate and return a random die roll
    // The return type is int
    public static int roll() {
        int die = (int) (Math.random() * 6 + 1);
        return die;
    }

    public static void main(String[] args) { 
        int die1 = roll();
        int die2 = roll();
        int sum = die1 + die2;
        
        System.out.printf("The two dice are %d and %d. The sum is %d.", die1, die2, sum);  
    }
    
}
