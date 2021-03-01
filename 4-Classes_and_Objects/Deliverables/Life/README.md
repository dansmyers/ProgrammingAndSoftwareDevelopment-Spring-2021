# Conway's Game of Life

![](https://upload.wikimedia.org/wikipedia/commons/e/e5/Gospers_glider_gun.gif)


## Description

**Life**, invented by the mathematician John Conway in 1970, is a zero-player game that simulates the evolution of a collection of cells. It is the best-known example of a **cellular automaton** and has attracted interest from computer scientists and mathematicians because it's capable of generating complex patterns from a short set of rules. In this project, you’ll write a Java class that implements the rules of the Game of Life.

Conway was a professor of mathematics at Cambridge. He had a long academic research career but is best known for his contributions
to recreational mathematics, including Life and [the Doomsday Rule](https://en.wikipedia.org/wiki/Doomsday_rule) for calculating the day of the week for a given date. Conway died of COVID-19 on April 11, 2020. 

## Rules

The Game of Life is not a competition; rather, it’s a simulation of an idealized universe that obeys certain rules. The only role of the human programmer is to create the initial configuration of cells in the Game’s universe. Once the simulation begins, the cells grow and die according to the rules of the Game.

The universe of Life is an infinite two-dimensional grid of cells. At each moment in time, a cell is either **alive** or **dead**. Each cell has eight neighbors: the cells to its left, right, top, bottom, and to its four corners. At each step in time, cells change state from alive to dead or vice versa based on the following rules:

- A living cell that has fewer than two living neighbors dies from isolation
- A living cell with more than three living neighbors dies from overcrowding
- A living cell that has two or three living neighbors remains alive into the next generation
- A dead cell with exactly three live neighbors comes to life in the next generation

All births and deaths happen **simultaneously**.

<img src="http://cis-linux2.temple.edu:8080/SP18_3344_tuh35975/02_advLayout/images/life_rules.gif" width="40%" />

*Graphic from [Brandon Foltz's page at Temple](http://cis-linux2.temple.edu:8080/SP18_3344_tuh35975/02_advLayout/index.html#info). Notice that the two red cells marked in the
last figure come to life at the same time in the next generation because they each have three living blue neighbors in the current generation.*

## Play Around

First, watch this video: https://www.youtube.com/watch?v=C2vgICfQawE.

Then go to the following page, which is a web-based implementation of Life: https://playgameoflife.com/lexicon/bi-block_puffer

- Click on *Explanation* for a review of the rules.
- *Lexicon* contains an extensive collection of patterns and terms developed by the Life community. You can click on any pattern graphic to load it into the window.
- Use the controls at the bottom of the page to change the speed or zoom in and out on the pattern. Many of the spaceship patterns, like the bi-block puffe above, look best
if you run them relatively fast and zoomed out.
- You can also draw on the window to add new cells, then run the program to see how your configuration evolves.

## Detailed Example

Consider the following 3x3 grid. Assume that cells marked 0 are dead and cells marked 1 are alive.

```
-------------
| 0 | 0 | 0 |
-------------
| 1 | 1 | 1 |
-------------
| 0 | 0 | 0 |
-------------
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
-------------
| 2 | 3 | 2 |
-------------
| 1 | 2 | 1 |
-------------
| 2 | 3 | 2 |
-------------
```

The next phase applies the rules of Life to determine which cells live and die in the next generation. **Here's an important point: neighbor counting for every cell must be complete *before* deciding which cells live and die in the next generation**.

By the rules,

- The upper-left cell remains dead, because it has exactly two neighbors.

- The upper-middle cell comes to life in the next generation, because it is currently dead and has exactly three neighbors.

- The upper-right cell remains dead, because it has exactly two neighbors.

- The center-left cell dies, because it is currently alive and has fewer than two living neighbors.

- The center-middle cell survives, because it is currently alive and has two living neighbors.

- And so forth.

Take a moment to verify the reasoning for each cell in the grid. When you're done, you should be certain that the state of the grid in the next generation is:

```
-------------
| 0 | 1 | 0 |
-------------
| 0 | 1 | 0 |
-------------
| 0 | 1 | 0 |
-------------
```

Repeating the steps will show that this grid will return to the original horizontal line configuation in its next generation. This simple pattern, alternating between horizontal
and vertical, is called a **blinker**. There are a number of other standard Life patterns, which often emerge spontaneously from more complex configurations.

<img src="https://evolvingweb.ca/sites/default/files/inline-images/68747470733a2f2f6d656469612e67697068792e636f6d2f6d656469612f3456565a547654717a5252304255774e49482f67697068792e676966.gif" width="66%" />

## Code

This directory contains three files: `Life.java`, `RunLife.java` and `StdDraw.java`.

`RunLife` contains code to test your implementation. Don't modify it! `StdDraw` handles the graphics. You don't need to write any graphical code for this project.

Your job is to finish `Life.java` and implement the following methods:

- `private boolean[][] grid`: holds the current state of the Life universe. An entry in the grid is `true` if its corresponding cell is alive and `false` otherwise.
- `public Life(int nRows, int nCols)`: constructor. Initializes the `grid` to the given dimensions.
- `public void clear()`: set all entries in the `grid` to `false`.
- `public void set(int r, int c)`: set the cell at row `r` and column `c` to
`true`.
- `public boolean isAlive(int r, int c)`: return the state of the cell at position (`r`, `c`)
- `public int numRows()`: return the number of rows in the grid
- `public int numCols()`: return the number of columns in the grid
- `public void update()`: use the rules of Life to compute the next state of the `grid`.

## Easy Methods

Most of the methods in `Life` are easy to implement. For example, the constructor only needs to initialize the `grid` to the given sizes:

```
public Life(int nRows, int nCols) {
    this.grid = new boolean[nRows][nCols];
}
```

`isAlive` returns the value of a cell at a given position:

```
public boolean isAlive(int r, int c) {
    return this.grid[r][c];
}

```

`numRows` returns the number of rows in the grid. `numCols` is very similar.

```
public int numRows() {
    return this.grid.length;
}
```

**Start by implementing the easy methods other than `update`**, then run `RunLife` to verify that you can display each of the four patterns.

## `update`

The `update` method is the most complex. First, make sure that you understand the rules of Life described above. Play with the example page and work through the blinker example.
It will be impossible to code the `update` method if you can't simulate it by hand.

The goal of update is to process each square in the grid, counting up its number of neighbors and then deciding if the square should be alive or dead in the next generation.

```
public void update() {

    // Create a second grid to hold the state in the next generation
    boolean[][] next = new boolean[this.numRows()][this.numCols];
    
    // Loop over all elements in the grid
    for (int r = 0; r < this.numRows(); r++) {
        for (int c = 0; c < this.numCols(); c++) {
            
            // Count the living neighbors of position (r, c)
            int neighbors = 0;
            
            // Upper-left neighbor
            if (r > 0 && c > 0 && this.grid[r - 1][c - 1]) {
                neighbors++:
            }
            
            // Upper-middle neighbor
            if (r > 0 && this.grid[r - 1][c]) {
                neighbors++;
            }
            
            // Add cases for the other six neighbors
        
        
            // Use the rules of life to determine whether position (r, c)
            // is alive or dead in the next generation
            //
            // Set next[r][c] to true or false
            
        }    
    }
    
    // Make the next grid the active grid for the next generation
    this.grid = next;

}
```

Remember that all births and deaths happen **simultaneously**. Don’t modify the grid while you’re checking to see if cells should live or die! Create a second `boolean[][]` called `next` to hold the state of each cell in the next generation. As you check each cell in the current grid, set its corresponding value in `next` to be alive or dead. At the end of `update` set `this.grid = next`.
