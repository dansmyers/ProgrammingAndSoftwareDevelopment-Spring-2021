/***** DO NOT MODIFY THIS FILE *****/
/***** DO NOT MODIFY THIS FILE *****/
/***** DO NOT MODIFY THIS FILE *****/
/***** DO NOT MODIFY THIS FILE *****/
/***** DO NOT MODIFY THIS FILE *****/
/***** DO NOT MODIFY THIS FILE *****/

/***** ARE YOU MODIFYING THIS FILE? STOP IT. *****/

/**
 * Test program for Life.java
 * 
 * @author DSM, 2020
 */

public class RunLife {
  
  static int pxSize = 12;
  
  public static void initializeBlinker(Life life) {
    life.clear();
    life.set(3, 3);
    life.set(4, 3);
    life.set(5, 3);
  }
  
  public static void initializeGlider(Life life) {
    life.clear();
    life.set(3, 4);
    life.set(4, 5);
    life.set(5, 3);
    life.set(5, 4);
    life.set(5, 5);
  }
  
  public static void initializePulsar(Life life) {
    life.clear();
    life.set(2, 4);
    life.set(2, 5);
    life.set(2, 6);
    life.set(2, 10);
    life.set(2, 11);
    life.set(2, 12);
    
    life.set(7, 4);
    life.set(7, 5);
    life.set(7, 6);
    life.set(7, 10);
    life.set(7, 11);
    life.set(7, 12);
    
    life.set(9, 4);
    life.set(9, 5);
    life.set(9, 6);
    life.set(9, 10);
    life.set(9, 11);
    life.set(9, 12);
    
    life.set(14, 4);
    life.set(14, 5);
    life.set(14, 6);
    life.set(14, 10);
    life.set(14, 11);
    life.set(14, 12);
    
    life.set(4, 2);
    life.set(5, 2);
    life.set(6, 2);
    life.set(4, 7);
    life.set(5, 7);
    life.set(6, 7);
    life.set(4, 9);
    life.set(5, 9);
    life.set(6, 9);
    life.set(4, 14);
    life.set(5, 14);
    life.set(6, 14);
    
    life.set(10, 2);
    life.set(11, 2);
    life.set(12, 2);
    life.set(10, 7);
    life.set(11, 7);
    life.set(12, 7);
    life.set(10, 9);
    life.set(11, 9);
    life.set(12, 9);
    life.set(10, 14);
    life.set(11, 14);
    life.set(12, 14);
  }
  
  public static void initializeGliderGun(Life life) {
    life.clear();
    life.set(5, 1);
    life.set(6, 1);
    life.set(5, 2);
    life.set(6, 2);
    life.set(5, 11);
    life.set(6, 11);
    life.set(7, 11);
    life.set(4, 12);
    life.set(8, 12);
    life.set(3, 13);
    life.set(9, 13);
    life.set(3, 14);
    life.set(9, 14);
    life.set(6, 15);
    life.set(4, 16);
    life.set(8, 16);
    life.set(5, 17);
    life.set(6, 17);
    life.set(7, 17);
    life.set(6, 18);
    life.set(3, 21);
    life.set(4, 21);
    life.set(5, 21);
    life.set(3, 22);
    life.set(4, 22);
    life.set(5, 22);
    life.set(2, 23);
    life.set(6, 23);
    life.set(1, 25);
    life.set(2, 25);
    life.set(6, 25);
    life.set(7, 25);
    life.set(4, 35);
    life.set(5, 35);
    life.set(4, 36);
    life.set(5, 36);
  }
  
  public static void draw(Life life) {
    int nRows = life.numRows();
    int nCols = life.numCols();
    
    StdDraw.clear();
    
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < nCols; j++) {         
        double x = (pxSize * j + pxSize / 2.0) / (512.0); 
        double y = 1.0 - (pxSize * i + pxSize / 2.0) / (512.0);
        double r = pxSize / 512.0 / 2.0;
        
        if (life.isAlive(i ,j)) {
          StdDraw.filledSquare(x, y, r);
        }
        else{
          StdDraw.rectangle(x, y, r, r);
        }
      }
    }
    
    StdDraw.show(200);
  }
 
  
  public static void run(Life life, int numIters) {
    for (int i = 0; i < numIters; i++) {
       draw(life);
       life.update();
    } 
  }
  
  
  public static void main(String[] args) {
    Life life = new Life(40, 40);
    initializeBlinker(life);
    run(life, 25);
    initializeGlider(life);
    run(life, 50);
    initializePulsar(life);
    run(life, 25);
    initializeGliderGun(life);
    run(life, 300);
  }
  
}