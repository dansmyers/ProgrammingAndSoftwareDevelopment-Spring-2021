/**
 * "Driver" class contains the main method that actually
 * starts the application -- in this case, test Book.java
 * 
 * @author dmyers
 *
 */
public class BookDriver {

	public static void main(String[] args) {
		
		// Create a new instance of the Book class
		// Use the new keyword and the Book constructor method
		
		// The constructor is a special method that always has the same
		// name as the class
		//
		// The constructor's job is to perform the initialization of
		// a new object of the particular class

		Book hobbit = new Book("The Hobbit", "J.R.R. Tolkien", 9.99);
		Book austen = new Book("Pride and Prejudice", "Jane Austen", 15.99);
		Book got = new Book("Game of Thrones", "George R.R. Martin", 19.99);	
		
    // Printing an object invokes its custom toString method if one exists
		System.out.println(hobbit);
		System.out.println(austen);
		System.out.println(got);
		
    // Set and get methods for interacting with private instance variables
    hobbit.setPrice(.99);
		System.out.println("The price of the Hobbit is " + hobbit.getPrice());

	}

}
