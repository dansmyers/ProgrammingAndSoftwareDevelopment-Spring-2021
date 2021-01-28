/**
 * Print a table of the powers of 2 using a for loop
 *
 * @author CMS 167
 */
 
public class PowersOfTwo {

    public static void main(String[] args) {
    
        for (int exponent = 0; exponent <= 20; exponent++) {
            int power = Math.pow(2, exponent);
            System.out.prinf("2 ^ %d\t%d\n, exponent, power);
        }
        
    }

}
