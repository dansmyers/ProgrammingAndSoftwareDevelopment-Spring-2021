/**
 * The for loop
 *
 * @author CMS 167
 */
 
// The for loop has four parts:
//
// 1. The keyword for
// 2. An initialization for the loop index variable (we often use i for this)
// 3. A terminating condition, the loop continues as long as this condition is true
// 4. A statement that updates the loop index variable
 
public class ForLoopExample {

    public static void main(String[] args) {
    
        // Sum of the numbers 1 through 100
    
        int sum = 0;
    
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        
        System.out.println(sum);
    }

}
