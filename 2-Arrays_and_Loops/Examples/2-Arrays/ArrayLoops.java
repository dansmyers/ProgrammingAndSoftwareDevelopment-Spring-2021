/**
 * Iterating over an array
 *
 * @author CMS 167
 */
 
public class ArrayLoops {
 
    public static void main(String[] args) {
        int[] primes = new int[5];
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        primes[3] = 7;
        primes[4] = 11;
        
        // Print the contents of the array
        // Use .length to get the number of elements in the array
        // This is the standard loop for iterating over an array  
        for (int i = 0; i < primes.length; i++) {
            System.out.println(primes[i]);
        }
        
        // Sum the elements of an array
        int sum = 0;
        for (int i = 0; i < primes.length; i++) {
            sum += primes[i]
        }
        System.out.println(sum);
     
        // Max element of an array
        int max = primes[0];  // Set initial max to first element
        for (int i = 1; i < primes.length; i++) {
            if (primes[i] > max) {
                max = primes[i]
            }
        }
  
    }

}
