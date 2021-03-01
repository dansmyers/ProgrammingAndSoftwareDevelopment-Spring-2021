# Conway's Game of Life

![](https://upload.wikimedia.org/wikipedia/commons/e/e5/Gospers_glider_gun.gif)


## Description

**Life**, invented by the mathematician John Conway in 1970, is a zero-player game that simulates the evolution of a collection of cells. It is the best-known example of a **cellular automaton** and has attracted interest from computer scientists and mathematician because it is capable of generating complex patterns from a short set of rules. In this project, you’ll write a Java class that implements the rules of the Game of Life.

## Rules

The Game of Life is not a competition; rather, it’s a simulation of an idealized universe that obeys certain rules. The only role of the human programmer is to create the initial configuration of cells in the Game’s universe. Once the simulation begins, the cells grow and die according to the rules of the Game.

The universe of Life is an infinite two-dimensional grid of cells. At each moment in time, a cell is either **alive** or **dead**. Each cell has eight neighbors: the cells to its left, right, top, bottom, and to its four corners. At each step in time, cells change state from alive to dead or vice versa based on the following rules:

- A living cell that has fewer than two living neighbors dies from isolation

- A living cell that has two or three living neighbors remains alive into the next iteration

- A living cell with more than three living neighbors dies from overcrowding

- A dead cell with exactly three live neighbors comes to life

All births and deaths happen **simultaneously**.

<img src="http://33.media.tumblr.com/tumblr_ky8qn3m5dm1qav3uso1_500.gif" width="50%" />

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

- The upper-left cell remains dead, because it has exactly two neighbors.

- The upper-middle cell comes to life in the next generation, because it is currently dead and has exactly three neighbors.

- The upper-right cell remains dead, because it has exactly two neighbors.

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

## Submission and Grading

Turn in your repo to GitHub. I'll download your project and use the `main` method of `RunLife` to test it. If your program handles every case correctly, you'll get full credit. You must have at least three of the four patterns working to receive satisfactory credit.
