/**
 * Examples of working with two-dimensional arrays
 *
 * @author dmyers
 */

public class TwoDimensionalArrays {
  
  public static void main(String[] args) { 
    
    // Declare 2-D array named a
    int[][] a;
    
    // Initialize using the new keyword
    // First dimension is like the number of rows in the matrix
    // Second dimension is like the number of columns in each row
    // a will be a 3x3 matrix of ints
    a = new int[3][3];
    
    // You can use curly braces to create an array and declare its contents
    // Note how this is like an array of arrays
    String[][] stringMatrix = {{"Hello", "World"}, {"One", "Two"}, {"Tyrannosaurus", "Rex"}};
    
    /*** Accessing elements ***/
    
    // 2-D arrays are indexed from 0, just like 1-D arrays
    a[0][0] = 1; // upper left
    a[0][1] = 2; // upper middle
    a[0][2] = 3; // upper right
    a[1][1] = 4; // center
    a[2][0] = 5; // lower left
    a[2][2] = 6; // lower right
    
    // Use a.length to get the number of rows in the matrix
    System.out.println("Number of rows in a = " + a.length); // prints 3
    
    // To get the number of columns in row 0, use a[0].length
    // Similar for row 1, row 2, etc.
    System.out.println("Number of columns in row 0 of a = " + a[0].length);
    
    
    /*** Printing all elements of a 2-D array ***/
    
    // Use a double loop
    // The outer loop increments over the rows
    // The inner loop prints all elements on each row
    for (int r = 0; r < a.length; r++) {
      for (int c = 0; c < a[r].length; c++) {
        
        // Print the element in row c and column c
        // Use \t to put a tab character between values
        System.out.print(a[r][c] + "\t");
      }
      System.out.println(); // advance to the next line
    }
    
  }
}
