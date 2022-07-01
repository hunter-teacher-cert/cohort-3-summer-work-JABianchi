/**
 * ArrayPractice by Team BossCoders
 * Joel Bianchi
 * collaborators: (Group 9)jingxue8303, michaelpark677, ehawkins18
 */

/**
   INSTRUCTIONS:
   This file contains stubs (empty methods) for the following methods:
   1. buildIncreasingArray
   2. buildRandomArray
   3. printArray
   4. arraySum
   5. firstOccurence
   6. isSorted
   7. findMaxValue
   8. countOdds
   9. flip
   The stubs will have comments describing what they should do
   Levels:
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   Basic:
   Complete these methods:
   - buildRandomArray !
   - printArray !
   - arraySum
   - firstOccurence !
   - findMaxValue
   Intermediate:
   Complete all the methods for basic and also
   - buildIncreasingArray !
   - isSorted
   - countOdds
   Advanced:
   - flip !
*/

import java.util.*;
import java.io.*;
import java.lang.reflect.Field;

public class ArrayPractice
{

  public static void main( String[] args )
  {

    // remove the comments as you complete each routine
    // and add more lines as you add additional routines.

    int[] data = buildRandomArray(10, 20);
    int[] data2 = buildIncreasingArray(10,5,3);
    System.out.println("data array: ");
    printArray(data);
    System.out.println("data2 array: ");
    printArray(data2);

    int fo = firstOccurence(data,17);
    System.out.println("First occurrence of 17 is at " + fo);

    int mv =  findMaxValue(data);
    System.out.println("Max value is " + mv);

    int sum = arraySum(data);
    System.out.println("Array sum is " + sum);

    boolean sort = isSorted(data);
    boolean sort2 = isSorted(data2);
    System.out.println( "sorted data?" +  sort );
    System.out.println( "sorted data2?" +  sort2);

    int co = countOdds(data);
    System.out.println("The number of odds in data: " + co);

    flip(data);
    System.out.println("The flipped array:");
    printArray(data);

    // add calls to show that the methods you write work.
  }

  /**
     Parameters:
     size - how large the array should be
     startValue - the value of the first element
     step - the interval to the next value
     Returns:
     a new array of integers
     Examples:
     buildIncreasingArray(5,3,2) will return an array
     with the values 3,5,7,9,11 (five values, starting with 3 with a step size of 2)
  */
  public static int[] buildIncreasingArray( int size, int startValue, int step )
  {
    int[] data = new int[size];

    // loop through each element of the array and
    for(int i=0; i<data.length; i++){
      
      // assign the appropriate value to each one.
      data[i] = startValue + i*step;       
    }
    
    return data;
  }


  /**
     Parameters:
     size - how many elements in the array
     maxValue - the largest possible random value to use
     Returns:
     a new array where each element is an integer between 0
     and up to but not including maxValue
  */
  public static int[] buildRandomArray( int size, int maxValue )
  {
    //create a new array
    int[] data = new int[size];

    //loop through each element
    for(int i=0; i<data.length; i++){

      //Generate a random number
      int num = (int) ( (Math.random() * maxValue) + 1) + 1;

      //Assign a random number to the array
      data[i] = num;
      
    }

    return data;
  }


  /**
     Parameters:
     data - an array of ints
     Returns:
     nothing
     prints out the array
     Note: data.length stores the length of the array
  */
  public static void printArray( int[] data )
  {

    for(int i=0; i<data.length; i++){
      System.out.print(data[i] + " ");
    }
    System.out.println();
  }



  /**
     Parameters:
     data - an array of integers
     value - the value to search for
     Returns:
     the index (location) of the first occurence of value
     Example:
     given array data, containing 1,5,2,7,5,8,5,12,19,5
     firstOccurence(data,5) would return 1
     since the first occurence of the value 5 is at a[1]
  */
  public static int firstOccurence( int[] data, int value )
  {
    //setup a variable to track the first target index
    // (initialize with an index that is not in the array)
    int targetIndex = -1;
    
    //loop through the array backwards
    //(the last time you see the target will be the first occurence)
    for(int i=data.length-1; i>=0; i--){

      //if you see the target...
      if(data[i] == value){

        //record the index
        targetIndex = i;     
      }
            
    }
    return targetIndex; //will return -1 if it did not find the target
  }


  /**
     Parameters: data - an array of ints
     Returns: an integer that is equal to the sum of all the elements in the array
     Ex: If the input array has the values 5,2,4,10 the return
     value will be 21 (5+2+4+10)
  */
  public static int arraySum( int[] data ){
    //initialize sum to be zero
    int sum =0;

    //loop through array
    for (int i = 0; i < data.length; i++){
      
      //add each element to the sum
      sum += data[i];
    }

    return sum; 
  }


  /**
     Parameters:
     data - an array of integers
     Returns:
     true if the array is sorted, false otherwise
     That is, if each element is < the element to its right
     then the array is sorted.
     An array with values 5,6,10,15 is sorted
     An array with values 5,6,10,13,15 is not
  */
  public static boolean isSorted( int[] data ){

    //loop through the array
    for (int i=0; i< data.length -1; i++){
      
      //check if the element to the left is bigger
      if (data[i] >  data[i+1]){
        
        //trigger false if not in order
        return false;
      }
    }

    //return true if it never got triggered
    return true;
  }

  /**
     Parameters:
     data - an array of integers
     Returns:
     value of the largest element in the array
  */
  public static int findMaxValue( int[] data ) {
    
    // will hold the maximum value
    int max= data[0];

    //loop through every int
    for (int i =0; i < data.length; i++){
      //compare current int to the current max
      if (data[i] > max){
        //change max if needed
        max = data [i];
      }
    }

    return max;
  }


  /**
     Parameters:
     data - an array of integers
     Returns:
     the number of odd elements in the array
     Ex: if data holds 5,6,7,8,9,10 then the return value
     will be 3 since three of the elements are odd.
  */
  public static int countOdds( int[] data ) {

    //start counting at zero
    int count = 0;

    //loop through the entire array
    for (int i =0; i < data.length; i++){
      
      //check if the int is odd
      if (data[i] % 2 != 0){
        
        //add it to the count
        count ++;  
      }
    }

    // Note the % operator is the modulo (basically remainder) function
    // in java. Use to determine if an integer is odd.

    return count;
  }

  /**
     Parameters:
     data - an array of integers
     Returns:
     no return value since this is a void function -- but
     you will manipulate the values in the array parameter
     Postcondition:
     elements of the input array are in reverse order
     Example:
     If the input array contains 5,8,13,7,27,2
     After the routine, the array will contain 2,27,7,13,8,5
  */
  public static void flip( int[] data )
  {
    //loop through half of the array
    for(int i=0; i<data.length/2; i++){

      //store the first element
      int temp = data[i];

      //move the last element to the first spot
      data[i] = data[data.length -1 -i];

      //move the first element to the last spot
      data [data.length -1 -i] = temp;
      
    }
  }

}
