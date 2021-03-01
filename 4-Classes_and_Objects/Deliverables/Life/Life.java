/**
 * A class implementing the rules of Life
 * 
 * Complete the class according to the instructions in the project write-up.
 *
 */

public class Life {

  // Instance variable representing the grid
  private boolean[][] grid;
  
  
  /**
   * Constructor -- initialize the grid
   */
  public Life(int nRows, nCols) {
    this.grid = new boolean[nRows][nCols]; 
  }
  
  
  /**
   * Clear the grid -- set all entries to false
   *
   * Recall: this.grid.length is the number of rows, this.grid[r].length is the number of columns
   */
  public void clear() {
    for (int r = 0; r < this.grid.length; r++) {
      for (int c = 0; c < this.grid[r].length; c++) {
        this.grid[r][c] = false; 
      }
    }
  }
  
  
  //*** Add code for other methods: set, isAlive, numRows, numCols ***//
  
  
  /**
   * Update for the next generation
   */
  public void update() {
 
    // Create a next grid that will hold the state of the cells in the next generation
    // At the end of the method, set this.grid = nextGrid;
    boolean[][] nextGrid = new boolean[this.numRows()][this.numCols()];
   
    // Loop through the entire grid
    for (int r = 0; r < this.grid.length; r++) {
      for (int c = 0; c < this.grid[r].length; c++) {
        
        // Determine the number of living neighbors of cell (r, c)
        int neighbors = 0;
        
        // Check upper-left cell, position (r - 1, c - 1)
        // Skip the cell if it would fall off the grid
        if (r > 0 && c > 0 && this.grid[r - 1][c - 1] == true) {
          neighbors++: 
        }
        
        // Upper middle, position (r - 1, c)
        if (r > 0 && this.grid[r-1][c] == true) {
         neighbors++; 
        }
        
        // Add cases to check the other six neighbors
        
        // Add rules to determine if cell lives or dies in the next generation
        // Set nextGrid[r][c] to true or false 
       
      }
    }
   
    // Make nextGrid the active grid
    this.grid = nextGrid;
   
  }
  
}
