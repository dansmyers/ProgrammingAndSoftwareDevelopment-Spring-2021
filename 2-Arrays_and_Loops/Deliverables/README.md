# Problems

## I Would Like to Say a Few Words

Write a program that uses a loop to prompt the user to enter a `String`. Keep prompting until the user types one of the following words:

```
nitwit
blubber
oddment
tweak
```

Tip:

- Use a `Scanner` with the `next` method to read a `String` input from the terminal.

- Use the `equals()` method to check if the input string is equal to one of the test words. **You can't compare strings using `==`**.


## If They're the Super Mario Bros., Does That Mean His Name is Mario Mario?

At the end of each level in the original *Super Mario Bros.*, Mario jumps up a stair like the following:

```
     ##
    ###
   ####
  #####
 ######
#######
```

Write a set of loops that print Mario-style stairs of arbitrary height. Prompt the user to input the height of the staircase.

Use a `for` loop to iterate over the height of the stairs. Use two inner loops, one to print the number of spaces and another
to print the number of blocks on the line.

```
for (int i = 0; i < height; i++) {

    // Figure out the number of spaces and number of stars on line i

    for (int sp = 0; sp < numSpaces; sp++) {
        // Print a space
    }
    
    for (int st = 0; st < numStars; st++) {
        // Print a star
    }
    
    // Use System.out.println() to go to the next line
    
}

```

Tips: 

- The first line has `height - 1` spaces and 2 blocks. The second line has `height - 2` spaces and 3 blocks.

- Use a `Scanner` with the `nextInt()` method to read the height of the staircase. You can assume the user inputs a valid number.

- You can use `System.out.print()` (not `println`) to print without automatically moving to the next line.

## Subtraction Game

Here's a mathematical strategy game.

Beginning with a pile of 21 stones, players alternate removing stones until none are left. On her turn, a player may take 1, 2,
or 3 stones. The player who takes the last stone is the winner.

This game is known by a few different names, inluding the Subtraction Game and Nim. 
A version was played on an episode of *Survivor*, where they called it Thai 21.

There are lots of variations:

- Changing the number of stones or the numbers that may be removed on each turn.
- Using multiple piles of stones. In classic Nim, a player may take as many stones as he wants, but from only one pile at a time.
- Playing a *misère* game (French for "destitution"), where the player who takes the last stone *loses*.

Write a program that implements the Thai 21 version of the Subtraction Game. Use the skeleton below to get started.

This program shows a useful strategy for game programs.

- You might think that the best way to handle a two-player game is to put both player's turns inside the the loop: on each iteration,
have player 1 make a move, then have player 2 make a move.

- This works, but it makes ending the loop tricky, because you don't want to do player 2's turn if player 1 wins.

- Here, we're going to use the loop to play just one turn. A variable keeps track of which player's turn it is.

- If the current player *doesn't* win, switch to the other player for the next pass through the loop.

```
/**
 * Subtraction Game
 *
 * @author CMS 167
 */

import java.util.Scanner;

public class SubtractionGame {
    
    
    /**
     * Main
     */
    public static void main(String[] args) {
    
        boolean playing = true;  // Guard variable
        int stones = 21;
        int player = 1;
        
        // Initialize a Scanner to read from the terminal
        
        while (playing) {
        
            System.out.println();
            System.out.println("Stones: " + stones):
            System.out.println("It's your turn, Player " + player + ".";
            System.out.println("Take 1, 2, or 3 stones from the pile.");
            
            // Use nextInt() to get the player's move
            
            // Reduce the number of stones
            
            // Check the winning condition
            // If there are 0 stones, print a winning message and set playing = false;
            
            // else, switch to the other player
        
        }
        
    }

}
```

## Magic Squares

### Description

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/D%C3%BCrer_Melancholia_I.jpg/1280px-D%C3%BCrer_Melancholia_I.jpg" width="50%" />

Albrecht Dürer, *Melancholia I*, 1514

A **magic square** is a square matrix where all rows, columns, and diagonals sum to the same value. For example, the Dürer etching shown above includes the following
4 x 4 magic square with sum 34.

<img src="https://upload.wikimedia.org/wikipedia/commons/7/7e/Albrecht_D%C3%BCrer_-_Melencolia_I_%28detail%29.jpg" width="33%" />

There are a number of methods, some of ancient origin, for generating magic squares. [The Wikipedia article has extensive information](https://en.wikipedia.org/wiki/Magic_square). The most well-known is called the **Siamese method**. It was brought to Europe by the French diplomat
Simon de la Loubère in 1688 who learned of it during his trip as an ambassador to the Kingdom of Siam. The method probably originated in India; 
De la Loubère returned from Siam with documents describing other aspects of Indian science, including some of the first information on Indian
astronomy ever brought to Europe. Again, [Wikipedia has you
covered](https://en.wikipedia.org/wiki/Siamese_method) if you want more details.

The Siamese method generates an *n* x *n* magic square where *n* is odd. By default, the square is filled with the numbers from 1 to *n*<sup>2</sup>.

The method proceeds as follows:

1. Initialize the empty *n* x *n* square.

2. Start in the center of the top row and place a 1 there.

3. Move **up and to the right** to find the next square to fill. If moving up and to the right moves you off of the grid, wrap around to the other side.

4. If moving up and to the right would cause you to land on a square that is already occupied, move down by one square instead of moving up and right.

5. Continue this process, placing the numbers in sequential order until the entire square is filled.

Here is the illustration of the 3 x 3 square:

<img src="https://upload.wikimedia.org/wikipedia/commons/7/77/SiameseMethod.gif" width="33%" />

Here is an explanation of the first five steps:

1. Place a 1 in the center of the top row.

2. Move up and to the right, wrapping around to the bottom to place 2 in the lower-right square.

3. Move up and to the right, wrapping around to the left side to place 3 in the middle-left position.

4. Moving up and to the right from the 3 square would land on the 1 square, so move down one square instead and place 4 in the bottom left square.

5. Move up and right from the 4 square to place 5 in the center position.

And so forth.

### Code

Complete the program below to implement the Siamese method for constructing magic squares. Your program should read the number *n* as input, then initialize an *n* by *n*
matrix to hold the square.

```
/**
 * Magic squares
 *
 * CMS 121
 */
 
import java.util.Scanner;
 
public class MagicSquares {

    public static void main(String[] args) {

        // Create a Scanner and read n from the terminal
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a value of n: ");
        int n = input.nextInt();
        
        // n must be odd and positive; if it isn't, quit immediately

        // Initialize an n x n array of int
        int[][] square = 
        
        // Start in the top row, center column
        int row = 0;
        int col = n / 2;  // Integer division yields the correct column
        
        // Place the values from 1 to n ^ 2
        for (int i = 1; i <= n * n; i++) {
        
            // Place value i at square[row][col]
        
            // Try to move up and right, wrapping around if you need to
            
            // If that position is occupied, go back to the old location and move down instead
            
        }
        
        // Print the final magic square
        
    }
}

```


### Specifications

To get full credit for this program, you code must do the following:

- Prompt for and read *n*, the size of the square.
- Exit immediately if *n* is negative or even.
- Successfully construct the squares with inputs of *n* = 3 and *n* = 5.
- Print the final square with reasonable formatting before exiting.

## Treblecross

**Treblecross** is a one-dimensional tic-tac-toe variant. Both players take turns marking X's on a line of *n* squares. The object is to be the first player
to complete a grouping of three X's:

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Treblecross.svg/440px-Treblecross.svg.png" width="20%" />

Finish the implementation of Treblecross given below. Your program should

- Prompt for the size of the playing array
- Quit if the input value is negative.
- Print the board and read input on each turn.
- Successfully alternate between the two players.
- Detect the three winning conditions and declare the appropriate player the winner.

```
/**
 * Treblecross
 */

import java.util.Scanner;

public class Treblecross {

    public static void main(String[] args) {
    
        // Create a Scanner and get an input value of n
        
        // If n is negative, quit the program immediately
        
        // Create a 1-D array of n char
        
        // Use a variable to keep track of the current player
        int player = 1;
        
        // Use a while loop to play until the game is complete
        boolean playing = true;
        while (playing) {
        
            // Print the current board
            
            // Ask the current player to choose an open position
            
            // Read the player's move using the Scanner
            
            // If that square is occupied, use a continue statement to repeat the loop
            
            // Mark the position
            
            // Check if the new move resulted in three in a line
            //
            // There are three ways this can happen:
            //     the new X is the left most of a group of three
            //     the new X is in the middle of a group of three
            //     the new X is on the right of a group of three
            
            // If so, declare the current player the winner and set playing = false
                        
            // In all other cases, switch to the other player
            // Here's a fancy way of switching using the mod operation
            // 1 % 2 + 1 ---> 2
            // 2 % 2 + 1 ---> 1
            player = (player % 2) + 1;
            
            
        }
    
    }

}
```
