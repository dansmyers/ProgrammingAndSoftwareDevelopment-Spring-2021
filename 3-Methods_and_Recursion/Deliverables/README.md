# Methods and Recursion &ndash; Deliverables

## Recursion Practice

<img src="https://i.imgur.com/Myvtk0G.jpg" width="50%" />

The following three problems ask you to implement non-trivial recursive methods. 

**You must use `Recursion.java` in this directoy as a starting point for your solutions**: It contains stubs for the static methods you need to implement. 
New for this project! **Automated testing**. The  `main` method of `RecursionPractice` contains a series of tests that will evaluate your static methods
for different inputs and report if they are producing the correct outputs.

Each recursive method is worth one point. You'll get credit for each problem if you pass all of its tests.

Tips:

- Don't edit the `main` method.
- **DO NOT USE ANY LOOPS**. Your solutions must be recursive! Using a loop for any of the problems is an automatic unsatisfactory.
- Don't create any global or class variables outside of a method. All of your variables must be **local**.


### The Collatz Sequence

<img src="https://imgs.xkcd.com/comics/collatz_conjecture.png" width="30%" />


Given an arbitrary positive starting integer `n`, it's possible to create a sequence by repeatedly applying the following rules:

```
if n is even, the next number is n / 2
if n is odd, the next number is 3 * n + 1
```

For example, beginning with 6, the sequence is: 6, 3, 10, 5, 16, 8, 4, 2, 1

Lothar Collatz conjectured that this sequence always converges to 1 for any starting positive integer `n`. No counterexample
has ever been found, but the Collatz conjecture has never been formally proven.

Complete the method `collatz(n)`, which recursively calculates the length of the Collatz sequence with starting value `n`. For example,

```
collatz(1) = 1  (because 1 is the base case)
collatz(8) = 4  (because the sequence is 8, 4, 2, 1)
collatz(6) = 9  (because the sequence is 6, 3, 10, 5, 16, 8, 4, 2, 1)
```

Hint: the length of the sequence starting with 6 is 1 plus the length of the sequence starting with 3.

```
collatz(6) = 1 + collatz(3)
```

Likewise,

```
collatz(3) = 1 + collatz(10)
```

Putting those ideas together, here's a sketch of the method you can use as a starting point:

```
public static int collatz(int n) {
    
    // 1 is the base case
    if (n == 1) {
        return 1;
    }
    
    // Recursive case: return 1 + collatz(m)
    // where m is the number that comes after n using the rules of the sequence

}
```

**Do not use any global or class instance variable to count the length of the sequence**. Any variables you use must be **local** within the `collatz` method.



### Negative Fibonacci Numbers

<img src="https://i.imgflip.com/17jtll.jpg" width="30%" />

Recall the definition of the Fibonacci sequence:

```
fib(0) = 0
fib(1) = 1
fib(n) = fib(n - 2) + fib(n - 1)
```

The last rule can be rewritten as

```
fib(n - 2) = fib(n) - fib(n - 1)
```

or equivalently,

```
fib(n) = fib(n + 2) - fib(n + 1)
```

This definition makes it possible to extend the Fibonacci sequence to **negative values of `n`**.

```
fib(-1) = fib(1) - fib(0) = 1
fib(-2) = fib(0) - fib(-1) = -1
fib(-3) = fib(-1) - fib(-2) = 2
fib(-4) = fib(-2) - fib(-3) = -3
```

The negative side of the sequence has the same values as the positive side, but offset by 1 and with alternating signs.

Complete the method `fib(n)` which finds the `n`th Fibonacci number. Your method has to work for both postiive and negative values of
`n`.

### McCarthy's 91 Function

Mathematician John McCarthy and his colleagues defined the following function:

```
M(n) = 

    n - 10        if n > 100
    M(M(n + 11))  if n <= 100
```

This function is interesting because it evaluates to 91 for all inputs `n <= 100`. For larger values,

```
M(101) = 91
M(102) = 92
M(103) = 93

and so forth...
```

Implement the function `mccarthy(n)` to calculate McCarthy's 91 function.

(No, you can't just make it return 91. You have to do the evaluation recursively.)


## Conway's Game of Life

**Life**, invented by the mathematician John Conway in 1970, is a zero-player game that simulates the evolution of a collection of cells. It is the best-known example of a **cellular automaton** and has attracted interest from computer scientists and mathematician because it is capable of generating complex patterns from a short set of rules. In this project, you’ll write a Java class that implements the rules of the Game of Life.

![](https://upload.wikimedia.org/wikipedia/commons/e/e5/Gospers_glider_gun.gif)

## Rules

The Game of Life is not a competition; rather, it’s more of a simulation of an idealized universe that obeys certain rules. The only role of the human programmer is to create the initial configuration of cells in the Game’s universe. Once the simulation begins, the cells grow and die according to the rules of the Game.

The universe of Life is an infinite two-dimensional grid of cells. At each moment in time, a cell is either alive or dead. Each cell interacts with its eight neighbors: The cells to its left, right, top, bottom, and to its four corners.

At each step in time, the states of the cells change according to the following rules:

1. A living cell that has fewer than two living neighbors dies from isolation
2. A living cell that has two or three living neighbors remains alive into the next iteration
3. A living cell with more than three living neighbors dies from overcrowding
4. A dead cell with exactly three live neighbors comes to life

These rules can be simplified into the three cases:

1. Any living cell with exactly two or three living neighbors remains alive in the next generation.
2. Any dead cell with exactly three living neighbors comes to life.
3. Any other living cells die in the next generation and all other dead cells remain dead.

All births and deaths happen **simultaneously**, at the transition from one generation to the next.

## Example

Consider the following 3x3 grid. Assume that cells marked 0 are dead and cells marked 1 are alive.

```
0  0  0

1  1  1

0  0  0
```

We'd like to apply the rules of Life to update this grid to the next state.

The first phase is to count the living neighbors of each cell. Neighbor counting is done by considering all eight surrounding positions. Any neighbors that would fall off of the
grid are automatically treated as dead.

- The cell at position (0, 0) (the upper-left position) has two living neighbors, one directly below and one to its lower right. All of its other neighbors, including the ones
that lie outside the grid, are dead.

- The cell at position (0, 1) (upper-middle position) has three living neighbors, all in the row below.

- The cell at position (0, 2) (upper-right position) has two living neighbors, one directly below and one to its lower-left.

Updates to the other cells are similar. If you want to represent the number of living neighbors in a grid, it would look like the following:

```
2  3  2

1  2  1

2  3  2
```

The next phase applies the rules of Life to determine which cells live and die in the next generation. **Here's an important point: neighbor counting for every cell must be complete *before* deciding which cells live and die in the next generation**.

By the rules,

- The upper-left cell remains dead, because it it currently dead and has only two living neighbors.

- The upper-middle cell comes to life in the next generation, because it is currently dead and has exactly three living neighbors.

- The upper-right cell remains dead, because it is currently dead and has only two living neighbors.

- The center-left cell dies, because it is currently alive and has fewer than two living neighbors.

- The center-middle cell survives, because it is currently alive and has two living neighbors.

- And so forth.

Take a moment to verify the reasoning for each cell in the grid. When you're done, you should be certain that the state of the grid in the next generation is:

```
0  1  0

0  1  0

0  1  0
```

Repeating the steps will show that this grid will return to the original horizontal line configuation in its next generation. This simple pattern, alternating between horizontal
and vertical, is called a **blinker**. There are a number of other standard Life patterns, which often emerge spontaneously from more complex configurations.

<img src="https://evolvingweb.ca/sites/default/files/inline-images/68747470733a2f2f6d656469612e67697068792e636f6d2f6d656469612f3456565a547654717a5252304255774e49482f67697068792e676966.gif" width="50%" />

## Code

The project repo contains two files: `RunLife.java` and `StdDraw.java`. These classes contain code to test your Life implementation. Don't modify them!

You will write a class called `Life` (in a file named `Life.java`) that implements the following:

- `private boolean[][] grid`: holds the current state of the Life universe. An entry in the grid is `true` if its corresponding cell is alive and `false` otherwise.
- `public Life(int nRows, int nCols)`: constructor. Initializes the `grid` to the given dimensions.
- `public void clear()`: set all entries in the `grid` to `false`.
- `public void set(int r, int c)`: set the cell at row `r` and column `c` to
`true`.
- `public boolean isAlive(int r, int c)`: return the state of the cell at position (`r`, `c`)
- `public int numRows()`: return the number of rows in the grid
- `public int numCols()`: return the number of columns in the grid
- `public void update()`: use the rules of Life to compute the next state of the `grid`.

To test your class, run `RunLife`, which will instantiate a copy of your `Life` class and use it to run and display four popular Life patterns. The `StdDraw` class handles the graphics. **You don't need to write any graphics code for this project**.

## Tips
Most of the methods are straightforward. Start by writing everything other than `update` and verifying that you can run the test class and display the initial configurations of each pattern.

The `update` method is the most complex part of the project. It needs to check every cell in the grid, determine that cell’s number of living neighbors, then use the number of neighbors to determine whether the cell lives or dies in the next generation.

Remember that all births and deaths happen **simultaneously**. Don’t modify the grid while you’re checking to see if cells should live or die! Create a second `boolean[][]` called `next` to hold the state of each cell in the next generation. As you check each cell in the current grid, set its corresponding value in `next` to be alive or dead. At the end of `update` set `this.grid = next`.

You assume that any cells that lie outside the grid are permanently dead. You'll need to think about how to handle the top and bottom rows and the left and right columns.



## Notakto

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Three-board_Notakto.svg/1920px-Three-board_Notakto.svg.png" width="50%" />

### Description

Notakto is a Tic-Tac-Toe variant where there are only X's. Both players take turns marking X's on the board and the first player who 
completes a line of X's **loses**.

Implement a Java program to play Notakto using `Notakto.java`as your starting point.

This project will let you practice:

- Creating, accessing, and iterating over two-dimensional arrays
- Writing and using static methods
- Reading user input
- Implementing game logic

### Specifications

- Correct, well-formatted printouts of the game board
- Reading user input from the console
- Checking for valid input and prompting the user to retry until a valid response is received
- Marking the board with X's
- Identifying the losing condition in a row, column, or diagonal and printing an appropriate response

If your program plays correctly, you'll get full credit for the project.


### Variables

The board is a 3x3 grid of `boolean` values.

```
boolean[][] board = new boolean[3][3]
```

Using booleans is appropriate because each position can have only two values: open or marked with an X.

You'll also need to create a `Scanner` to read input from the terminal.

### Printing and Input

Print the current game board on each turn. Use the following format.

```
 1 | 2 | 3
---|---|---
 4 | 5 | 6
---|---|---
 7 | 8 | 9
```

The user will enter one of the numbers 1-9 to select the location of the next X. Once a location has been selected, print an X in its spot:

```
 1 | X | 3
---|---|---
 4 | X | 6
---|---|---
 7 | 8 | X
```

Spots that have been filled can't be selected again. Use a loop to force the use to enter a valid location.

### Turns

Use a variable to keep track of the current player. Both players use the same logic, but **don't** create two huge blocks of 
nearly identical code. Use one main game loop and change the player variable on each iteration.

## Tips

**Work in small phases**. Don't try to code the entire game in one step. Implement one small piece at a time, test it, and move on to the next piece only when things are working correctly.

Start by creating the main game loop in the `play` method, then fill in the other methods one at a time:

- `print` to print the board

- `readMove` to prompt the user for a location

- Add other methods to check for a line of X's in a row, column, or diagonal
