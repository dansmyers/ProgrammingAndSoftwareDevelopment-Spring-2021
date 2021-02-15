
public class Recursion {
	
	// Many problems have self-similar structures
	// For example, binary search or any other divide and conquer algorithm
	// To solve a problem of size N, break it into one or more smaller sub-problems
	// and solve those first
	
	// In many cases, the algorithm for solving a problem with a self-similar structure
	// is easier to express using recursion than using an equivalent algorithm with loops
	
	// countdown is a recursive method
	// a method that calls itself
	public static void countdown(int count) {
		
		// Second part: base case
		// "non-recursive part"
		// Apply a test that stops the recursion
		// The base case doesn't make any recursive calls, it just returns
		if (count <= 0) {
			System.out.println("Blastoff!");
			return;  // return from here when countdown == 0
		}
		
		// Recursive case
		// Key idea: recursive case always contains a call to the method
		// Notice: the argument to the recursive call always changes in a way
		// that moves CLOSER to the base case
		System.out.println(count);
		countdown(count - 1);
		
		// This is the return point
		System.out.println("Back from recursive call. count = " + count);
		return;
	}
	
	
	// Factorial function
	// n! = n * (n-1) * (n-2) * (n-3) * ... * 3 * 2 * 1
	public static int factorial(int n) {
		
		// Base case
		if (n == 1) {
			return 1;
		}
		
		// Recursive case
		int f = n * factorial(n - 1);
		return f;
		
	}
	
	// Calculate and return the nth Fibonacci number
	//
	// 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
	//
	// fib(n) = fib(n - 1) + fib(n - 2)
	//
	// base case: first two numbers are 1
	// fib(0) = 1
	// fib(1) = 1
	public static int fib(int n) {
		
		// Base case
		// Condition will almost always be a test on n
		if (n == 0 || n == 1) {
			return 1;
		}
		
		// Recursive case
		return fib(n - 1) + fib(n - 2);
		
	}
	

	public static void main(String[] args) {
		
		countdown(3);
		System.out.println(fib(200));

	}

}
