# Blackjack

<img src="https://upload.wikimedia.org/wikipedia/commons/3/33/Blackjack21.jpg" width="50%" />

## Description

Use the `Card` and `Deck` classes to implement [a game of Blackjack](https://www.youtube.com/watch?v=HkzMA1jrm00). This project will let you practice using object-oriented programming (OOP) to implement a non-trivial interactive game.
You have broad freedom to decide how you want the game to play: how you want the output to appear, how you want to collect input, etc.

## Rules

Here is a quick summary of the basic rules of Blackjack. You can also read more at the [Wizard of Odds](https://wizardofodds.com/games/blackjack/basics/#toc-Rules),
my go to resource for obscure gambling knowledge. If you aren't familiar with the game, take some time to understand how it's played 
before diving into the code.

Blackjack is played against a dealer. The player’s goal is to collect a hand of cards that beats the dealer’s hand. There are three ways to win:

1. Achieving a score of 21 with the first two cards (a **blackjack**)
2. Achieving a score greater than the dealer’s without exceeding 21 
3. Letting the dealer draw cards until his score exceeds 21

Our version of Blackjack will play a single round of the game between a single player and dealer using a 52-card deck.

### 1. Set-up

The set-up phase of the game is as follows:

1. Shuffle the deck
2. Deal two cards to the player and two to the dealer
3. Reveal the player's cards and announce their score: if the total is 21 the player automatically wins
4. Reveal the dealer's first card, but keep the second one hidden

### 2. Hitting and Standing

Once the cards are revealed, the player may add additional cards to her hand:

1. The player chooses to **hit** or **stand**
2. If the player stands, her turn ends and she keeps her current hand
3. If the player hits, she receives an additional card and the score of the new hand is announced
4. If the player’s hand goes over 21, she **busts** and immediately loses
5. These steps repeat until the player either busts or stands

Once the player stands, the dealer will draw cards from the deck according to the following rules:

1. If the dealer’s hand is less than 17, he hits
2. Otherwise the dealer stands
3. If the dealer’s hand exceeds 21, he busts and the player wins

If the dealer stands without busting, then the highest hand is the winner. A draw occurs if the hands are equal.

### 3. Scoring Hands

The score of a hand is determined as follows:

- Numbered cards count for their value
- Face cards count for 10
- An ace counts for 11, unless this would make the player’s score greater than 21, in which case it counts for 1

Note that a hand of two aces would have one count for 11 and the other count for 1, for a total score of 12.

### Features You Do Not Need To Implement

Casino Blackjack is always played for stakes, typically paying 1:1 on a win and 3:2 on a blackjack. Do not implement any wagering. 
Most casinos also offer choices to the player besides hit or stand: purchasing insurance, splitting, and doubling down are the
most common. You don’t need to implement any of these features.

## Classes

You need to create four classes.

- `Card`, representing a single card with a suit and rank
- `Deck`, representing a deck of 52 cards
- `Hand`, representing a hand of cards
- `Blackjack`, the main class

We built the first two in class and they're included in this repository.

### `Hand`

The `Hand` class should use an `ArrayList<Card>` to keep track of the `Card` objects in the hand. Here is a template:

```
/**
 * A blackjack hand
 */
 
import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;
    
    
    /**
     * Constructor
     */
    public Hand() {
        this.cards = new ArrayList<Card>();
    }
    
    
    /**
     * Add a new card to the hand
     * 
     * @param newCard    the new Card object to append to this Hand
     * @return           nothing, the card is added to the Hand
     */
    public void addCard(Card newCard) {
        this.cards.add(newCard);    
    }
    
    
    /**
     * Calculate the value of the cards
     *
     * @return        The value of this Hand, scored according to the rules of Blackjack
     */
    public int score() {
        // TODO: add code to iterate through this.cards
        // and determine their score
    }

}
```

### `Blackjack`

`Blackjack` is the driver class and will have only a `main` method. Here's some code to help you get started, but you'll have to add more to it.

```
/**
 * BLACKJACK
 */
 
import java.util.Scanner; 
 
public class Blackjack {

    public static void main(String[] args) {
    
        System.out.println("WELCOME TO BLACKJACK.");
    
        // Initialize a Scanner for input
    
        // Create a Deck and two empty Hands
        System.out.println("Shuffling the deck...");
        Deck deck = new Deck();
        
        Hand player = new Hand();
        Hand dealer = new Hand();
        
        // Deal two cards to the player
        player.addCard(deck.deal());
        player.addCard(deck.deal());
        
        // Deal two cards to the dealer
        
        
        // Print the player's two cards
        // Tip: think about adding a method to the Hand class to make this easier
       
        
        // Print the dealer's first card
        // Again, think about adding a method to Hand to print only the first card
        
        
        // Use a loop to prompt the player to hit or stand
        boolean looping = true;
        
        while (looping) {
            // Calculate and print the player's score
            // You'll need to complete the score method in the Hand class
            int playerScore = player.score();
            
            System.out.println("\nYour score is " + playerScore + ".");
            
            // Print choices
            System.out.println("1. Hit");
            System.out.println("2. Stand");
            System.out.println("Hit or Stand?");
            
            // Read the player's move
            
            // If the player chooses to hit,
            //     Deal a new card
            //     Add it to the player's hand
            //     Calculate the score of the hand using the Hand class's score method
            //     Check if the score is greater than 21. If so, the player loses immediately
            
            // Else if the player chooses stand,
            //     Set looping = false to end the loop
            
            // Else, the player has chosen an option that isn't 1 or 2,
            //     Print an error message and allow the loop to repeat
        }
        
        
        // Use a second loop to make the dealer hit as long as his score is < 17
        //     If the dealer's score goes over 21, he busts and the player wins immediately
        
        
        // If neither player nor dealer has busted, compare the scores of their two hands
        // The hand with the higher score is the winner
    
    }

}
```

## Scoring and Aces
The trickiest part of the program is probably keeping track of the score of each hand and dealing with Aces. My recommendation is to loop through the `Card` objects in the
`Hand` each time the `score` method is called.

The code below loops through the `Hand` add adds up the value of all non-Ace cards. It counts the number of Aces in the `Hand`, then decides on their values at the end: Each
Ace counts for 11 unless that would make the player bust, in which case the Ace counts for only 1. Note that a hand with multiple Aces could have the first one count for 11 and
the second one count for 1, depending on the values of the other cards.

- A hand with only two Aces has a score of 12 (the first Ace counts for 11 and the second for 1)
- A hand with a King and two Aces also counts for 12 (the King counts for 10 and the two Aces each count for 1)
- A hand with a Five and two Aces counts for 17 (the first Ace counts for 11 and the second counts for 1)

```
public int score() {

    // Declare an int to hold the final score calculated for the hand
    int score = 0;
    
    // Count the number of Aces and determine their values at the end
    int numAces = 0;
    
    // Loop through all of the cards in the Hand and add up their
    // individual values
    
    for (Card c : this.cards) {
        Rank r = c.getRank();
        
        if (r == Rank.TWO) {
            score += 2;
        }
        
        // Similar for other card Ranks
        
        // All face cards count for 10
        
        if (r == Rank.ACE) {
            numAces++;
        }
    }
    
    // Each Ace counts for 11, unless counting for 11 would make the score > 21, then the Ace
    // counts for only 1
    while (numAces > 0) {
        // Add 11 to the score unless that would make score > 21, in which case
        // this Ace only counts for 1
        
        numAces--;
    }
    
    return score;
}
```

### Example Output

You don't have to exactly copy this output, but here's an example of how the game might play.

```
Welcome to Blackjack.

Shuffling the deck...

Your two cards are 
    ACE of HEARTS
    TWO of CLUBS

The dealer's face-up card is
    NINE of DIAMONDS
    
Your current score is 13.
1. Hit
2. Stand
Hit or Stand? 1

Your next card is
    NINE of SPADES
    
Your current score is 12.
1. Hit
2. Stand
Hit or Stand? 1

Your next card is
    SEVEN of CLUBS
    
Your current score is 19.
1. Hit
2. Stand
Hit or Stand? 2

You stand with 19.

The dealer's second card is
    FIVE of HEARTS
    
The dealer's score is 14.

Dealer hits.
    FOUR of CLUBS.
    
The dealer's score is 18.

Dealer stands with 18.

Your 19 beats the dealer's 18.

You win!
```
