# Rock, Paper, Scissors


<img src="https://static.vecteezy.com/system/resources/previews/000/693/105/original/cartoon-rock-paper-scissors-vector-characters.jpg" width="50%" />

## Overview

This document will lead you guide you through the implementation of an RPS game. This program will tie together pretty much everything that we've done so far in the class:

- Printing
- Variables
- Constants
- User input
- Relational operators
- Conditional execution
- Randomness
- Logical operations

This version of the game will play one round of human vs. computer. A little later, we can talk about how to modify the program to play something like best two-out-of-three.

Here's an example play session.

```
Welcome to Rock, Paper, Scissors.
1. Rock
2. Paper
3. Scissors
Select your move:
1
I choose Scissors.
Rock crushes Scissors!
My failure...does not compute...
```

## Skeleton

Use the code below as a starting point. Each of the sections below will ask you to add a new part to the skeleton program. Put the new code for each section **under** its
associated comment in the program.

```
/** 
* Rock, paper, scissors
* Plays a single round of human vs. computer
*
* CMS 121
*/

public class RockPaperScissors {

    public static void main(String[] args) {

        // 1. Declare final variables representing the three moves
    
        // 2. Create a new Scanner
    
        // 3. Print the welcome message and list the three moves
    
        // 4. Read the user's move
    
        // 5. If the move is not 1, 2, or 3, exit the program with return
            
        // 6. Randomly generate the CPU's move
    
        // 7. Print the CPU's move
    
        // Determine the outcome and print an appropriate message

    }
  
}
```

## Step 1: Declare Constants

We have to decide how to represent the player and computer move. There are many different ways to do this. We could, for example, have the player type in a `String` for their chosen move, like `"Rock"`. This approach could work, but we'd have to deal with the complexity of raw text input.

A more structured approach is to **assign each move a number**. Now, we can read the user's move by prompting him or her to type 1, 2, or 3 and generate the computer's move by picking a random value 1, 2, or 3.

Use `final` variables to declare constants for each move:

```
final int ROCK = 1;
```

Add two more lines for `PAPER` and `SCISSORS`.

Now you can use the name `ROCK` in your program instead of always remembering "1 stands for rock."


## Step 2: Scanner

Add the line `import java.util.Scanner;` to the top of your program, then add a line to create a `new Scanner` that reads from `System.in`.

## Step 3: Print the Welcome Message and List the Three Moves

Add four print statements that print the opening text for the game.

## Step 4: Read the Player's Move

Prompt the player to select one of the moves, then read the response using `nextInt()`:

```
int playerMove = input.nextInt();
```

## Step 5: Check for Valid Input

The only legal moves are 1, 2 or 3. Add some code to check if the user enters a value outside that range, and if so exit the program.

```
// Use || for logical OR
if (playerMove < 1 || playerMove > 3) {
    System.out.println("That's not a valid move, meatbag.");
    return;
}
```

Remember that the `return` statement automatically ends the `main` method, which is the same as exiting the program.


## Step 6: Randomly Generate the CPU's Move

Use `Math.random()` to generate a 1, 2, or 3 and save it into a variable named `cpuMove`.

## Step 7: Print the CPU's Move

Add`if` statements to print a message for each possible computer move.

```
if (cpuMove == ROCK) {
    System.out.println("I choose Rock.");
}
```

Add two more cases for `PAPER` and `SCISSORS`.

## Step 8: Determine the Outcome

This is the most complex part. You need to write a set of conditional statements that will compare the player and CPU moves and print the appropriate outcome message.

One case is easy: if the moves are the same, it's a draw.

```
if (playerMove == cpuMove) {
    System.out.println("Draw! I'll get you next time, human.");
}
```

Add more statements to test for the other possible combinations.

```
// Use && for logical AND
if (playerMove == ROCK && cpuMove == PAPER) {
    System.out.println("Paper covers Rock!");
    System.out.println("Humans...so soft...so weak.");
}
```
