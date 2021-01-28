/**
 * Print the values less than 100 divisible by 7
 *
 * @author CMS 167
 */
 
public class DivisibleBy7 {

    /**
     * Main
     */
    public static void main(String[] args) {
        int n = 1;
        
        while (n < 100) {
            if (n % 7 == 0) {
                System.out.println(n);
            }
         
            n++;
        }
    }
    
}
