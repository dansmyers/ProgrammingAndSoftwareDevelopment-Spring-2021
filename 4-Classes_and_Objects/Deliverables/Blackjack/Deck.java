/**
 * A deck of 52 playing cards
 * 
 * @author dmyers
 *
 */
 

// To get access to ArrayList, you must import it from java.util
import java.util.ArrayList;
import java.util.Collections;


public class Deck {

    private ArrayList<Card> cards;
	
    /**
     * Constructor -- initialize the Deck of cards
     */
    public Deck() {
		
        // Create a new ArrayList<Card>
        this.cards = new ArrayList<Card>();
		
	// Loop through all Suit and Rank combinations and insert a Card of each
	// combination into the deck
	for (Suit s : Suit.values()) {
	    for (Rank r : Rank.values()) {
	        Card c = new Card(s, r);
	        this.cards.add(c);
	    }
	}
    }
	
    /**
     * Shuffle the deck of cards
     */
    public void shuffle() {
	// Use the built-in Collections.shuffle method -- as lazy as possible
	Collections.shuffle(this.cards);
    }
	
	
    /**
     * Deal the next card in the deck
     */
    public Card deal() {
	Card nextCard = this.cards.remove(0);
	return nextCard;
    }
	
	
    /**
     * toString -- return a String representation of the cards
     */
    public String toString() {
	return this.cards.toString();  // Use built-in ArrayList toString to get a String representation
    }
	
	
    /**
     * main -- internal testing for the Deck class
     */
    public static void main(String[] args) {

	// Initialize a new deck of 52 cards
	Deck d = new Deck();

	// Make the deck d shuffle itself
	d.shuffle();

	// Print the deck
	System.out.println(d);

	// Deal the first card from the deck
	Card c = d.deal();
	System.out.println(c);

	// Print the deck again and show that the first card has been removed
	System.out.println(d);

    }
	
}
