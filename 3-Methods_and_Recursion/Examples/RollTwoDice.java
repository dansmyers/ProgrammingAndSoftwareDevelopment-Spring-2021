// Write a method that rolls two dice
// CMS 167

public class RollTwoDice {

    public static int rollOneDie() {
        return (int) (Math.random() * 6 + 1);
    }

    public static int sumOfTwoDice() {
        int die1 = rollOneDie();
        int die2 = rollOneDie();
        return die1 + die2;
    }
    
    public static void main(String[] args) {
        int roll = sumOfTwoDice();
        System.out.println(roll);
        
        // Question: what about die1 and die2?
        // Are they still accessible from within main?
    }

}
