/**
 * Create a class that represents a single playing card
 * Combine with a Deck class to represent a full deck of 52 cards
 * 
 * @author dmyers
 *
 */


// Enumerated suit and rank types

enum Suit {
    CLUBS, DIAMONDS, HEARTS, SPADES;
}

enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
}


public class Card {

    private Suit suit;
    private Rank rank;

    /**
     * Constructor -- create a new card with a specified Suit and Rank
     */
    public Card(Suit newSuit, Rank newRank) {
        this.suit = newSuit;
        this.rank = newRank;
    }

    /**
     * Get methods -- return the value of suit and rank
     */
    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    /**
     * toString -- return a String reprsentation of the object
     */
    public String toString() {
        return this.rank + " of " + this.suit;
    }
	
}
