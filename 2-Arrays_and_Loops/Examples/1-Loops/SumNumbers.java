/**
 * Calculate the sum of the first 1000 natural numbers
 *
 * @author CMS 167
 */
 
public class SumNumbers {

    /**
     * Main
     */
    public static void main(String[] args) {
        int n = 1;
        int sum = 0;
        
        while (n <= 1000) {
            sum += n;
            n += 1;
        }
    }

}
