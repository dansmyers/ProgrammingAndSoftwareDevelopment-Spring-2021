/**
 * A class that represents a book with a title, author, and price
 * 
 * @author dmyers
 */

public class Book {
	
	/**
	 * Instance variables to represent the title, author, and price
	 * 
	 * Instance variables are the internal data of the object
	 * Also call them fields or attributes
	 * 
	 * Variables declared outside of any method become the instance
	 * variables (internal data) for objects of this class
	 */
	private String title;
	private String author;
	private double price;
	
	
	/**
	 * Constructor -- set the values of the three variables when
	 * the new object is instantiated
	 * 
	 * Name of the constructor method is the same as the name of the class
	 * (including capital letter)
	 * 
	 * Does not have a return type, not even void
	 * 
	 * Three inputs are the values of the new instance variables
	 */
	public Book(String title, String author, double price) {
		// this is the special "object self-reference"
		// Used to refer to a class's internal variables from within
		// the class's own code
		// Not strictly required but I find it useful
		
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	
	/**
	 * "Get" methods -- "Accessor" methods
	 * 
	 * Each method returns the value of a private variable
	 */
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}

    public double getPrice() {
    	return this.price;
    }
	
    
    /**
     * "Set" methods -- "Mutator" methods
     * 
     * Each method changes the value of a private variable
     * 
     * If we do not want a variable to be mutable, we can enforce
     * that rule by not providing a set method
     * 
     * Do not provide setTitle or setAuthor to make those fields
     * read-only
     * 
     * If we do provide a set method for a variable, we can add
     * extra logic to make sure the changes are reasonable
     */
    public void setPrice(double newPrice) {
    	if (newPrice < 0) {
    		System.out.println("Price must be non-negative.");
    		return;
    	}
    	
    	this.price = newPrice;
    }
	
	
	
	/**
	 * toString -- returns a String representation of the object
	 * 
	 * Called automatically when you print an object and whatever
	 * the method returns is what gets printed
	 */
	public String toString() {
		return this.title + " by " + this.author + ", " + this.price;
	}
	

}
