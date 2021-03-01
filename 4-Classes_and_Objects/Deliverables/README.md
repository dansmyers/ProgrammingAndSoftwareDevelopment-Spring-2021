# Classes and Objects &ndash; Deliverables

## Description

You have two projects to complete:

- An implementation of John Conway's Game of Life, and **artificial life** simulation, that models the births and deaths of cells living on a 2-D grid. 
Life is the best-known example of a **cellular automaton** and is famous for the intricate patterns it can produce without human input.

- Blackjack, a classic example of object-oriented programming. The goal of this program is to illustrate how OOP can be used to **model the parts of
a program**.

The descriptions and starter code for the two projects are in the `Life` and `Blackjack` folders.

Both projects are likely to be more difficult that anything you have developed thus far. They both require you to write a non-trivial program made from the interaction of 
multiple classes.

- Take time to carefully read the descriptions and really understand the requirements for each problem.
 
- **Develop incrementally** and **test your code frequently as you develop**.
 
- **Start early**! Don't wait until the last minute. In particular, you should be able to write most of `Life` right away. We will develop two of the classes you need for `Blackjack`
in class.

## Grading

The complete assignment is worth a total of **ten points**.

### Life

<img src="https://external-preview.redd.it/U38P67RJ7qavOCX3MDmFRoIN1Ht5WXK_O4-zm8IwSpc.jpg?auto=webp&s=002ab4f1c7de99b320f3968b3d8e671b0abf7a50" width="35%" />

*Some people take this stuff really seriously.*

The `Life` project includes a driver class named `RunLife` that implements four automated patterns. You'll get one point for each pattern that your code successfully executes

- A simple three-square blinker that alternates between vertical and horizontal

- A glider, the iconic Life pattern that walks diagonally across the grid

- A more complex flashing pattern

- **Gosper's Glider Gun**, a pattern that produces an infinite stream of gliders. The Gun is named after Bill Gosper, who created it in 1970, winning $50 from 
John Conway for discovering the first Life pattern that could produce an infinite number of living cells.


### Blackjack

You will receive one point for each of the following features:

- Dealing and printing two cards for the player's hand; dealing two cards and printing **one** card for the dealer's hand
- Implementing the `score` method of the `Hand` class
- Correctly implementing hit and stand behaviors for the player
- Using a loop to make the dealer hit until his score is greater than or equal to 17
- Ending the game immediately if the player or dealer score goes over 21
- Comparing the player and dealer scores and choosing the winner

