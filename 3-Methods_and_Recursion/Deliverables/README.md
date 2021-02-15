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
