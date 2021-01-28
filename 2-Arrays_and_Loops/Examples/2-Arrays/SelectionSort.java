/**
 * Sort an array using the selection sort algorithm
 *
 * @author dmyers
 */
 
// Selection sort is one of the simplest sorting algorithms to code,
// though it's performance is not great.
//
// The algorithm loops through all of the elements in the array to identify the
// minimum value, then swaps the minimum into the first position.
//
// It then repeats, finding the second smallest value, and swapping it into the
// second position.
//
// This process continues until every element has been sorted into its correct
// position.
 
public class SelectionSort {

    /**
     * Main
     */
    public static void main(String[] args) {
        
        // Declare an example array
        int[] a = {2, 5, 3, 7, 1, 0, 4, 6};
        
        // Outer loop searches for the smallest, second smallest, third smallest,
        // etc. until all elements are in their correct positions
        for (int i = 0; i < a.length - 1; i++) {
            int minValue = a[i];
            int minIndex = i;
            
            // Search for the smallest remaining value in the array
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < minValue) {
                    minValue = a[j];
                    minIndex = j;
                }
            }
            
            // Swap the smallest remaining value into position i
            //
            // After this step, position i now has its correct value and
            // doesn't need to be considered further
            a[minIndex] = a[i];
            a[i] = minValue;
        }
    
    }

}
