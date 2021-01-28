/**
 * Creating arrays and accessing elements
 *
 * @author CMS 167
 */
 
public class CreatingArrays {

    /**
     * Main
     */
    public static void main(String[] args) {
    
        // Create an array
        //
        // 1. The type plus square brackets to indicate that it's an array
        // 2. The name, using the same rules as variable names
        // 3. =, for an assignment statement
        // 4. The new keyword
        // 5. Type, brackets, and the size of the array
        
        int[] primes = new int[5];
        
        // Access elements of the array using square brackets
        // THE FIRST ELEMENT IS INDEX ZERO
        
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        primes[3] = 7;
        primes[4] = 11;
        
        // You can use an array access any place you would use a variable name
        System.out.println(primes[0]);
        System.out.println(primes[1]);
     
        // If you know the elements of the array, you can declare them with { }
        int[] scores = {99, 92, 100, 85};
    
    }
    
}
