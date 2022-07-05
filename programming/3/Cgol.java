import java.io.*;
import java.util.*;

/**
 * Conway's Game of Life Team AreWeSentientYet?
 * Joel Bianchi
 * collaborators: 
 */

/**
   The Rules of Life:

   Survivals:
   * A living cell with 2 or 3 living neighbours will survive for the next generation.

   Deaths:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.

   Births:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.

   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation.
*/


public class Cgol
{

  //Color declarations to help with printing in color
  //https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLUE_BG = "\u001B[44m";
  public static final String ANSI_YELLOW_BG = "\u001B[43m";
  public static final String ANSI_RED = "\u001B[31m";
  

  public static void main( String[] args )
  {
    //create a new board
    char[][] board;
    board = createNewBoard(25,25);
    
    //set the random percentage to populate 
    double pctToPopulate = 0.18;

    //Create X generations of the game
    int numGens = 20;
    for(int i=0; i<=numGens; i++){

      //populate the new board for Gen 0
      if(i == 0){
        //breathe life into some cells:
        randomlyPopulateBoard(board, pctToPopulate);
        // setCell(board, 0, 0, 'X');
        // setCell(board, 0, 1, 'X');
        // setCell(board, 1, 0, 'X');

      //Update the board for future Generations
      } else {
        board = generateNextBoard(board);     
      }

      //print out in console
      System.out.println("\n\n");
      System.out.println(ANSI_YELLOW_BG);
      System.out.println("--------------------------");
      System.out.println("Gen X+" + i +": \tSeed Pct: " + pctToPopulate);
      System.out.println("--------------------------");
      printBoard(board);
      System.out.println("--------------------------");
      printGenReport(board);
    }
 
  }//end main()
  

  //create, initialize, and return  empty board (all cells dead)
  public static char[][] createNewBoard( int rows, int cols )
  {
    //construct new board properly sized
    char[][] board = new char[rows][cols];

    //traverse through entire array
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[0].length; c++){

        //assign a space character for dead cells
        board[r][c] = ' ';
      }
    }  

    return board;
  }


  //print the board to the terminal
  public static void printBoard( char[][] board )
  {

    //Code to turn the printout blue
    System.out.println(ANSI_BLUE_BG);
    
    //traverse 2D array
    for(char[] row : board){
      for(char cell: row){
        //print out cell's char
        System.out.print(cell + "");
      }
      //go to a new line for each row
      System.out.println();
    }

    //Code to reset the printout color
    System.out.println(ANSI_RESET);

  }


  //set cell (r,c) to val
  public static void setCell( char[][] board, int r, int c, char val )
  {
    board[r][c] = val;
  }

  public static void randomlyPopulateBoard(char[][] board, double pct){

    //traverse board
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){

        //Each cell has a random chance of living if over the 'pct' threshhold
        if(Math.random() < pct){
          setCell(board, r, c, 'X');       
        }
  
      }
    }
  }
    


  //return number of living neigbours of board[r][c]
  public static int countNeighbors( char[][] board, int row, int col )
  {
    int count = 0;

     //determine the indices for the 4 main directions
    int up = row - 1;
    int down = row + 1;
    int right = col + 1;
    int left = col - 1;

    //loop through a 3x3 box surrounding the desired cell
    for(int r=up; r<=down; r++){
      for(int c=left; c<=right; c++){

        //check if r and c are in bounds
        if(r>=0 && r<board.length
          && c>=0 && c<board[r].length){

          //also check that you don't count the middle cell
          if(r != row || c != col){

            //finally, check if the cell has a 'X' for a living cell
            if(board[r][c] == 'X'){

              //increment the count if a neighbor is alive
              count++;
              
            }
          }                
        }  
      }
    }
    
    return count;
  }


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell( char[][] board,int r, int c )
  {

    //initialize cell's char as dead by default
    char nextGenCellStatus = ' '; 

    //check if the earlier cell was living
    boolean isLiving = false;
    if(board[r][c] == 'X'){
      isLiving = true;
    }

    //check for number of living neighbors
    int numLivingNeighbors = countNeighbors(board,r,c);
    
    //CASE 1: LIVING --> LIVING
    if(isLiving && (numLivingNeighbors == 2 || numLivingNeighbors == 3)){
      //cell keeps living
      nextGenCellStatus = 'X';      
    }

    //CASE 2: DEAD --> BIRTH
    else if (numLivingNeighbors == 3){
      nextGenCellStatus = 'X';
    }

    //CASE 3: --> DEAD
    //No need to write code for this since all other cases are dead by default

    //return the char
    return nextGenCellStatus;
  }


  //generate and return a new board representing next generation
  public static char[][] generateNextBoard( char[][] board )
  {

    //loop through all the cells in the board
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){

        //assign the correct char to each cell
        board[r][c] = getNextGenCell(board, r, c);
        
      }
    }

    return board;
  }

  public static void printGenReport(char[][] board){

    int total = board.length * board[0].length;
    int living = getTotalLivingCells(board);
    double pctLiving = ( (double) living) / total * 100;
    
    System.out.println("Total Living Cells: " + living );
    System.out.println("Total Cells: " + total);
    System.out.println("Percentage of Cells living: " + pctLiving + "%");

    
  }

  public static int getTotalLivingCells(char[][] board){

    //setup counter
    int count = 0;
    
    //use for each loops to traverse the board
    for(char[] row : board){
      for(char cell : row){

        //count if living cell found
        if(cell == 'X'){
         count++; 
        }     
        
      }
    }
    return count;
    
  }

}//end class