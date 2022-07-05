import java.io.*;
import java.util.*;

/**
 * Array2DPractice by Team LucidThinkeren
 * Joel Bianchi JABianchi
 * collaborators:
 *   Joshua Higgins Mr-Higgins
 *   Vanessa Hou qvzou
 *   Yenmin Young yenminyoung
 */

/**
   INSTRUCTIONS:
   Place this file in a folder named programming/3/.
   This file contains the following completed method. Use it as a model
   to help you with the other methods:
   - buildBoard
   This file also contains stubs (empty methods) for the following
   methods (split into 3 levels):
   Basic level (complete all):
   - printBoard *
   - copyBoard *
   Intermediate level (complete Basic methods plus this method):
   - explodeSquare *
   Advanced level (complete Basic + Intermediate + these two methods):
   - explodeAllChar *
   - downString
   The routines with the * will be particularly helpful for the
   Conway's Game of Life project that you'll work on after this one.
*/


/**
   creates and returns a 2D array of size rowsxcols chars. All elements
   in the 2D array will be set to the char value.
   Ex: buildBoard(3,4,'x') will return this 2D array:
   xxxx
   xxxx
   xxxx
   xxxx
   Use this completed method as an example to help you with some of the
   other methods.
*/

public class Array2DPractice
{

  public static void main( String[] args )
  {
    System.out.println("Building board b with 5 rows, 10 columns:");
    char[][] b = buildBoard(5,10,'z');
    printBoard(b);

    System.out.println("Board c (copied from board b)");
    char[][] c = copyBoard(b);
    printBoard(c);

    System.out.println("Changing row 3 of array b to @  symbol");
    setRow(b,3,'@');
    printBoard(b);

    System.out.println("Expoding a square around 1,1 on c");
    explodeSquare(c, 1, 1);
    printBoard(c);

    System.out.println("Exploding a square around 0,9 on c");
    explodeSquare(c, 0, 9);
    printBoard(c);

    System.out.println("Exploding all @ symbols on b");
    explodeAllChar(b, '@');
    printBoard(b);

    System.out.println("Writing \"GOODBYE\" downwards starting @ 1,3 on board b");
    downString(b,1,3,"GOODBYE");
    printBoard(b);

    

    
    
    /*
      Note, you can directly set elements in the board
      using array notation like b[3][2]='z' and you
      can use array notation to also access individual
      elements
    */
  }
  
  public static char[][] buildBoard( int rows, int cols, char value )
  {
    char[][] board = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j]=value;
      }
    }
    return board;
  }

  /**
     pretty prints a 2D array of characters
     This should print the array as a grid
  */
  public static void printBoard( char[][] board )
  {
   
    //traverse each row and column
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){

        //print each element with a tab to space out the columns
        System.out.print(board[r][c] + "\t");
      }

      //add a new line one time after each row
      System.out.println("");
    }
    
    //add an extra row after printing the 2D array
    System.out.println("");
    
  }

  /**
     Parameters:
     board - a 2D array of char
     row - the row you want to set
     value - the value to set all the elements in row
     Returns:
     Nothing
     Change the 2D array board so that all the elements in the
     specified row are set to value.
     Ex: Given array:
     xxxx
     xxxx
     xxxx
     xxxx
     setRow(board,2,'@') will change board to
     xxxx
     xxxx
     @@@@
     xxxx
  */
  public static void setRow( char[][] board, int row, char value )
  {
    //loop through just one row by examining each column in that row
    for(int c=0; c<board[row].length; c++){
      
      //assign each element of that row to the value
      board[row][c] = value;
      
    }
  }


  /**
     creates and returns a new 2D array of char the same size as
     original and copies all the elements
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


  /**
     Parameters:
     board - a 2D array of char
     row,col - ints specifying a location in board
     Returns:
     nothing
     A location in a 2D array can be though of as having 6
     neighbors.  In the below 2D array, the neighbors of the element
     marked Q are the numbered elements.
     oooooo
     o123oo
     o4Q5oo
     o678oo
     oooooo
     This method should change all the neighbor cells (elements) to an X
     but not change the element at row,col
     Ex:
     Given the 2D array
     QQQQQ
     QQQQQ
     QQQQQ
     QQQQQ
     explodeSquare(board,1,1) will change the array to
     XXXQQ
     XQXQQ
     XXXQQ
     QQQQQ
     Note: Make sure to correctly handle the cases when you try
     to explode an element on the edges.
  */
  public static void explodeSquare( char[][] board, int row, int col )
  {
    //determine the indices for the 4 main directions
    int up = row - 1;
    int down = row + 1;
    int right = col + 1;
    int left = col - 1;

    //loop through a 3x3 box surrounding the desired element
    for(int r=up; r<=down; r++){
      for(int c=left; c<=right; c++){

        //check if r and c are in bounds
        if(r>=0 && r<board.length
          && c>=0 && c<board[r].length){

          //also check that you don't erase the middle
          if(r != row || c != col){

            //Change it to an X
            board[r][c] = 'X';          
          }                
        }  
      }
    }
  }

  /**
     This method will search through the 2D array board and it will
     explode each square that contains the char c (using the above
     definition of exploding).
     Example:
     Given the array
     qXzXq
     qXXXq
     qqqqq
     XXXqq
     XzXqq
     XXXXX
     qqqXz
     explodeAllchar(board,'z') will change board to:
  */
  public static void explodeAllChar(char[][] board, char ch)
  {
    //traverse through the 2D array
    for(int r=0; r<board.length; r++){
      for(int c=0; c<board[r].length; c++){

        //check if you see character ch
        if(board[r][c] == ch){

          //run the explodeSquare method
          explodeSquare(board,r,c);
          
        }        
      }
    }
  }


  /**
     Parameters:
     board - a 2D array of char
     row,col - ints specifying a location in board
     word - a String that you want to insert into the board.
     This will insert the parameter word into board in the downward
     direction. See examples below
     Example:
     Given this array
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     xxxxxx
     downString(board,1,1,"Hello") will change board to:
     xxxxxx
     xHxxxx
     xExxxx
     xLxxxx
     xLxxxx
     xOxxxx
     xxxxxx
     Given the above array, downString(board,4,3,"World") will
     change board to:
     xxxxxx
     xHxxxx
     xExxxx
     xLxxxx
     xLxWxx
     xOxOxx
     xxxRxx
     Note that the method has to stop at the bottom of the array.
  */
  public static void downString( char[][] board, int row, int col, String word )
  {
    //Determine number of characters that will fit on the board
    int printableLetters = word.length();
    int lettersThatCanFit = board.length - row;
    if(printableLetters > lettersThatCanFit){
      printableLetters = lettersThatCanFit;
      word = word.substring(0,printableLetters);  //shorten word accordingly
    }

    //loop through each character in the printable String word
    for(int i=0; i < printableLetters; i++){

      //Determine the letter
      char letter = word.charAt(i);

      //which row should it be on?
      int rowPrint = row + i;
      
      //Assign the letter to the board
      board[rowPrint][col] = letter;     
      
    }    
  }
  
}