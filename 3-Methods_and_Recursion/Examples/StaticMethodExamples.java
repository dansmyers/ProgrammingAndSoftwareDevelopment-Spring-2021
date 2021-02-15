/**
 * Writing examples of static methods
 * 
 * @author dmyers
 *
 */

public class MethodExamples {
	
	// Java requires that every path through the method return
	// the given type
	//
	// If you have an if-else if-else block you must return
	// a value of the given type (boolean in this case)
	
	public static boolean isEven(int n) {
		if (n % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Calculate the area of a circle
	 * 
	 * @param radius  The radius of the circle
	 * @return        The calculated area
	 */
	public static double areaOfCircle(double radius) {
		double area = Math.PI * radius * radius;
		return area;
	}
	
	
	// areaOfRectangle that takes two int values as input and
	// returns an int
	
	// Recall variables declared in a method are LOCAL to the method
	// (they are encapsulated) -- they only exist while the method
	// is being executed
	//
	// When the method ends, local variables go OUT OF SCOPE and
	// cannot be accessed by other parts of the program
	
	// It is possible to make a GLOBAL variable that's visible 
	// everywhere in the program -- this is bad idea
	//
	// Why? It breaks encapsulation, anybody can change global
	// data without going through a well-defined interface
	
	
	/**
	 * Calculate the area of a rectangle
	 * 
	 * @param width   The width of the rectangle
	 * @param height  The height of the rectangle
	 * @return        The calculated area
	 */
	
	public static int areaOfRectangle(int width, int height) {
		int area = width * height;
		return area;
	}

	
	// void is the special return type for a method that does
	// not return any value
	//
	// String[] args is the input parameter for main
	// It's used to pass command-line input to a program
	//
	// Any extra parameters typed at the command line if you run
	// the program in a terminal are passed through the args array
	//
	// args is not that important for Java programs
	// Much more common in C language programs
	public static void main(String[] args) {
		double a = areaOfCircle(5.0);
		System.out.println(a);
	}

}
