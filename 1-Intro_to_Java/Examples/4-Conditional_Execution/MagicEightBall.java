// A simulation of a magic eight ball
// Produces randomized fortunes each time it's run

public class MagicEightBall {

    public static void main(String[] args) {
    
        // Math.random() generates a uniform random value in (0, 1)
        double r = Math.random();
        
        // Use r to select a fortune
        // A three-part if / else if / else construction covers three cases
        
        if (r < .3333) {
            System.out.println("Things are looking good.");
        } else if (r < .6666) {
            System.out.println("Could be better.");
        } else {
            System.out.println("You have nothing to worry about.");
        }
        
    }

}
