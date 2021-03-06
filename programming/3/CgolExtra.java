import java.io.*;
import java.util.*;

/**
 * Conway's Game of Life Team AreWeSentientYet?
 * Joel Bianchi
 * Uses ANSI escape characters for animation & coloring
 */

public class CgolExtra
{

  //Color declarations to help with printing in color
  //https://www.geeksforgeeks.org/how-to-print-colored-text-in-java-console/
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_GREEN_BG = "\u001B[42m";
  public static final String ANSI_BLUE_BG = "\u001B[44m";
  public static final String ANSI_YELLOW_BG = "\u001B[43m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_BLACK = "\u001B[30m";
  
  public static final String HEADER_BG = ANSI_YELLOW_BG;
  //public static final String FIELD_BG = ANSI_BLUE_BG;
  public static final String CELL_TEXT = ANSI_BLACK;
  public static final String DEAD_COLOR = ANSI_BLUE_BG;
  public static final String ALIVE_COLOR = ANSI_GREEN_BG;  

  //Animation Constants
  public static final String CLEAR_SCREEN =  "\033[2J";
  public static final String TO_TOP_OF_SCREEN = "\033[1;1H";
  public static final String HIDE_CURSOR = "\033[?25l";
  public static final int FRAME_RATE = 100;

  //Grid Constants
  public static final int ROWS = 10;
  public static final int COLUMNS = ROWS * 6;
  public static final char ALIVE = (char) 9633;  // ■
 //public static final char ALIVE = 'O';
  public static final char DEAD = ' ';

  public static final double PCT_TO_POPULATE = 0.25;
  public static final int MAX_GENS = 200; 

  public static boolean isAnimating = true;
  

  public static void main( String[] args )
  {
    //create a new board
    char[][] board;
    board = createNewBoard(ROWS, COLUMNS);

    //setup another board to track the previous generation
    char[][] oldBoard = createNewBoard(board.length, board[0].length);
    
    //Create gens until there are less than 2 changes OR stop after 2
    int numChanges = -1;

    //clear screen before printing out animation
    if(isAnimating){
      System.out.print(CLEAR_SCREEN + HIDE_CURSOR);   
    }
    
    for(int i=0; i <= MAX_GENS && (numChanges > 2 || numChanges == -1); i++){
      
      //populate the new board for Gen 0
      if(i == 0){
        //breathe life into some cells:
        randomlyPopulateBoard(board, PCT_TO_POPULATE);
        wait(1000);

      //Update the board for future Generations
      } else {
        board = generateNextBoard(board);     
      }

      //start the cursor at the top of the screen again
      System.out.print(TO_TOP_OF_SCREEN);
      
      //print out in console with animation
      printGenReport(board, i, PCT_TO_POPULATE);

      //determine how many changes occured from previous gen
      numChanges = totalChanges(board, oldBoard);
      System.out.println("Number of Changes: " + numChanges);


      if(isAnimating){
        //pause the screen for a certain amount of milliseconds
        wait(FRAME_RATE);
  
        //cleanup glitch from initial frame
        if(i==0){
          System.out.print(CLEAR_SCREEN);
        }         
      }
     
      //copy the board to oldBoard to analyze the differences later
      oldBoard = copyBoard(board);
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
        board[r][c] = DEAD;
      }
    }  

    return board;
  }


  //print the board to the terminal
  public static void printBoard( char[][] board )
  {

    //Code to turn the field a background color
    //System.out.print(FIELD_BG);
    System.out.print(CELL_TEXT);
    
    //traverse 2D array
    for(char[] row : board){
      for(char cell: row){

        if(cell == ALIVE){
          System.out.print(ALIVE_COLOR);
        } else {
          System.out.print(DEAD_COLOR);
        }
        
        //print out cell's char
        System.out.print(cell + "");

        
      }
      //go to a new line for each row
      System.out.println();
    }

    //Code to reset the printout color
    System.out.print(ANSI_RESET);

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
          setCell(board, r, c, ALIVE);       
        }
  
      }
    }
  }


  //return number of living neigbours of board[r][c]
  public static int countneighbours( char[][] board, int row, int col )
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

            //finally, check if the cell has a ALIVE for a living cell
            if(board[r][c] == ALIVE){

              //increment the count if a neighbour is alive
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
     (alive ALIVE, dead DEAD)
  */
  public static char getNextGenCell( char[][] board,int r, int c )
  {

    //initialize cell's char as dead by default
    char nextGenCellStatus = DEAD; 

    //check if the earlier cell was living
    boolean isLiving = false;
    if(board[r][c] == ALIVE){
      isLiving = true;
    }

    //check for number of living neighbours
    int numLivingneighbours = countneighbours(board,r,c);
    
    //CASE 1: LIVING --> LIVING
    if(isLiving && (numLivingneighbours == 2 || numLivingneighbours == 3)){
      //cell keeps living
      nextGenCellStatus = ALIVE;      
    }

    //CASE 2: DEAD --> BIRTH
    else if (numLivingneighbours == 3){
      nextGenCellStatus = ALIVE;
    }

    //CASE 3: --> DEAD
    //No need to write code for this since all other cases are dead by default

    //return the char
    return nextGenCellStatus;
  }


  //generate and return a new board representing next generation
  public static char[][] generateNextBoard( char[][] board )
  {

    int row = board.length;
    int col = board[0].length;
    char[][] newBoard = new char[row][col];
    
    //loop through all the cells in the board
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){

        //assign the correct char to each cell
        board[r][c] = getNextGenCell(board, r, c);
        
      }
    }

    return board;
  }

  //method to print out an animated report each generation
  public static void printGenReport(char[][] board, int genNum, double PCT_TO_POPULATE){

    //print yellow header
    System.out.println(HEADER_BG);
    System.out.println("--------------------------");
    System.out.println("Gen X+" + genNum +"    Seed Pct: " + PCT_TO_POPULATE);
    System.out.println("--------------------------");
    
    //print green board
    printBoard(board);

    //print bottom stats report
    System.out.println("--------------------------");
    int total = board.length * board[0].length;
    int living = getTotalLivingCells(board);
    double pctLiving = ( (double) living) / total * 100;
    String pctLivingString = String.format("%.1f%%",pctLiving);
    System.out.println("Total Living Cells: " + living );
    System.out.println("Total Cells: " + total);
    System.out.println("Pct of Cells living: " + pctLivingString);

  }

  public static int getTotalLivingCells(char[][] board){

    //setup counter
    int count = 0;
    
    //use for each loops to traverse the board
    for(char[] row : board){
      for(char cell : row){

        //count if living cell found
        if(cell == ALIVE){
         count++; 
        }     
        
      }
    }
    return count;
    
  }

  /**
     creates and returns a new 2D array of char the same size as
     original and copies all the elements
    //copied from group work with Vanessa, Joshua, and Yenmin
  */
  public static char[][] copyBoard( char[][] original )
  {
    //create an array that's the same size as the original
    int row = original.length;
    int col = original[0].length;
    char[][] food = new char[row][col];

    //copy all the elements over from original to the new array
    for(int r=0; r<food.length; r++){
      for(int c=0; c<food[0].length; c++){
        food[r][c] = original[r][c];
      }
    }

    //return the new array
    return food;
  }

  public static int totalChanges(char[][] board, char[][] oldBoard){
    int changes = 0;
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){
        if(board[r][c] != oldBoard[r][c]){
          changes++;
        }
      }
    }
    return changes;
  }

  //Method used to pause the animation
  //from @AJPRADO
   public static void wait(int millis){
    try{
        Thread.sleep(millis);
    }catch(InterruptedException e){}
  }


}//end class