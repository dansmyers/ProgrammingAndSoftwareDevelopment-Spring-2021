/**
 * NOTAKTO
 *
 * Notakto is like tic-tac-toe but uses only X's. The first player who completes a line of X's is the LOSER.
 *
 * @author CMS 121
 *
 */

import java.util.Scanner;

public class Notakto {

	/**
	 * Print the board
	 * 
	 * @param  board  the 3x3 Notakto board
	 */
	public static void print(boolean[][] board) {

	}


  /**
   * Convert a position 1-9 into the corresponding row number
   *
   * @param  position   the user's choice, which must be 1-9
   * @return            the row associated with that position
   */
  public static int convertToRow(int position) {

  }

	
	/**
	 * Check for three X's in any row
	 * 
	 * @param  board  the 3x3 boolean game board
	 * 
	 * @return true if the board contains three X's in any row, false otherwise
	 */
	public static boolean checkRows(boolean[][] board) {
		
	}
	
  
	//*** Add more methods to check columns and diagonals ***//	
  
	
	/**
	 * Main -- run the main game loop
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 3x3 grid of booleans
		boolean[][] board = new boolean[3][3];
		
		// Create one Scanner to use for all input
		Scanner input = new Scanner(System.in);

		// Use a variable to keep track of the current player
		int player = 1;
		
		// Main game loop
		boolean playing = true;
		
		while (playing) {
			
			// Print the game board
			print(board);
			
			// Read the player's move -- use a loop to force valid input
      boolean readingInput = true;
      int position;
      
      while (readingInput) {

      }
			
			// Update the board
      int row = convertToRow(position);
      int col = convertToCol(position);
      board[row][col] = true; 
    	
			// Check for three X's in any row, column, or diagonal
      if (checkRows[board] || checkCols(board} || checkDiags(board)) {
          // Print losing message and end the game loop
          
      } else {
          // Switch to the other player
      }
			
		}	
		
		// Close the input Scanner at the end of the program
		input.close();
	}
	
}
