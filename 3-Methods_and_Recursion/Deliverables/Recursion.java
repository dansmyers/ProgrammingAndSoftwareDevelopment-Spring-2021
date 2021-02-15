/**
 * Starter code for the recursion practice problems
 *
 * @author CMS 121
 */

public class Recursion {

	/** 
   * Return the length of the Collatz sequence with the given start value
   */
	public static int collatz(int start) {

		
	}
	
	
	/** 
   * Calculate the nth Fibonacci number, where n can be positive or negative
   */
	public static int fib(int n) {

		
	}
	
	
	/**
   * Calculate McCarthy's 91 function
   */
	public static int mccarthy(int n) {

		
	}
	
	
	//*** DO NOT EDIT THE CODE BELOW THIS POINT. ***//
	//*** DO NOT EDIT THE CODE BELOW THIS POINT. ***//
	//*** DO NOT EDIT THE CODE BELOW THIS POINT. ***//
	//*** ARE YOU EDITING THE CODE BELOW THIS POINT? STOP IT. ***//
	
	//*** Automated testing ***//
	
	public static boolean validate(int result, int expected) {
	    System.out.println("\tExpected " + expected + "\tGot " + result);
	    if (result == expected) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	
	public static void main(String[] args) {
		
	    int numCorrect = 0;
	    int numTests = 14;
	    
	    // Collatz sequence tests
	    int result = collatz(1);
	    System.out.println("collatz(1)");	
	    if (validate(result, 1)) numCorrect++;
	    
	    result = collatz(8);
	    System.out.println("collatz(8)");
	    if (validate(result, 4)) numCorrect++;
	    
	    result = collatz(6);
	    System.out.println("collatz(6)");
	    if (validate(result, 9)) numCorrect++;
	    
	    result = collatz(11);
	    System.out.println("collatz(11)");
	    if (validate(result, 15)) numCorrect++;
	    
	    System.out.println();
	    
	    // Fibonacci numbers
	    result = fib(0);
	    System.out.println("fib(0)");
	    if (validate(result, 0)) numCorrect++;
	    
	    result = fib(-1);
	    System.out.println("fib(-1)");
	    if (validate(result, 1)) numCorrect++;
	    
	    result = fib(-2);
	    System.out.println("fib(-2)");
	    if (validate(result, -1)) numCorrect++;
	    
	    result = fib(-3);
	    System.out.println("fib(-3)");
	    if (validate(result, 2)) numCorrect++;
	    
	    result = fib(-4);
	    System.out.println("fib(-4)");
	    if (validate(result, -3)) numCorrect++;
	    
	    result = fib(8);
	    System.out.println("fib(8)");
	    if (validate(result, 21)) numCorrect++;
	    
	    System.out.println();
	    
	    // McCarthy's 91 function
	    result = mccarthy(1);
	    System.out.println("mccarthy(1)");
	    if (validate(result, 91)) numCorrect++;
	    
	    result = mccarthy(10);
	    System.out.println("mccarthy(10)");
	    if (validate(result, 91)) numCorrect++;
	    
	    result = mccarthy(91);
	    System.out.println("mccarthy(91)");
	    if (validate(result, 91)) numCorrect++;
	    
	    result = mccarthy(111);
	    System.out.println("mccarthy(111)");
	    if (validate(result, 101)) numCorrect++;
	    
	    // Fraction of successful tests
	    double fraction = (double) numCorrect / (double) numTests;
	    System.out.println();
	    System.out.println("Passed " + numCorrect + " out of " + numTests + " tests.");
	    System.out.println("Fraction passed = " + fraction);

	}

}
