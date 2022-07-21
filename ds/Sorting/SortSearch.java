import java.io.*;
import java.util.*;

/*
Joel Bianchi
SORTING: Team 11 Collaborators: A. Cassara, J. Higgins, R. Parker
SEARCHING: Team 12 jihae park ("G")  acassara ("Cassara")	mthomas
*/

/*
Sort Project:
  Part 1:  (BASIC)
  1. Analyze the two constructors - try to figure out how they work.
  2. Compile and run the program (SortProjectDriver.java and SortProject.java) and confirm
  the behavior of the constructors.
  Part 2: (BASIC)
  1. Read the description of findSmallestIndex and complete the method.
  2. Uncomment the lines in SortProjectDriver to test.
  Part 3: (INTERMEDIATE)
  1. Complete the sort method - read comments for description
  2. Uncomment the lines in sortProjectDriver to test.
Search Project:
  1. Complete the linear search (BASIC)
  2. Complete the binary search (Intermediate)
  3. Complete the recursive version of t binary search (Advanced)
*/

public class SortSearch{

    /* Sort project starts here */
    
    /* Instance Variables */
    private ArrayList<Integer> data;  // to store the data
    
    private Random r; 
    private int maxInt = 20;
    boolean printsOn = false;

  // Constructor #1: Default
  public SortSearch(){
    // creates new ArrayList of integers  
    data = new ArrayList<Integer>();

    // generates a random number generator
    r = new Random();

    // create 15 random numbers from 0 -> maxInt
    for (int i = 0; i < 15; i++){
        data.add(r.nextInt(maxInt));
    }

  }

  //Constructor #2: Overloaded allows us to define the size of the ArrayList
  public SortSearch(int size){
    // creates new ArrayList of integers  
    data = new ArrayList<Integer>();

    // generates a random number generator
    r = new Random();

    //create 'size' random numbers from 0 - maxInt
    for (int i = 0; i < size; i++){
        data.add(r.nextInt(maxInt));
    }

  }

  //Constructor #3: Generate a ordered list
  public SortSearch(int size, boolean ordered){
    // creates new ArrayList of integers  
    data = new ArrayList<Integer>(size);

    //create ordered numbers from 0 - 'size'
    for (int i = 0 ; i < size; i++){
      data.add(i);
    }

  }

  /* Convenience function to get data out of the ArrayList
  from the driver */
  public int get(int index){
    return this.data.get(index);
  }
    


  /*
  Return the index of the smallest data idem from index 
  start to the end of the ArrayList. If there are multiple
  of the smallest value, return any of them.
  
  Example, if the arraylist has:
  5,3,10,6,8
  if start was 2 (start at index 2, value 10) then it would
  return 3 which is the index of the value 6 which is the
  index with the smallest value from start to end.
  On the other hand, if start was 0, then the method would
  return 1 since the value 3 is in index 1 and that is the
  smallest.
  
  */
  public int findSmallestIndex(int start){
    //first value initialized as the smallest
    int smallIndex = start;

    //traverse through the ArrayList
   for(int i = start; i < data.size(); i++){

    //compare the values to see which is smallest
    if( data.get(i) < data.get(smallIndex) ){
      
      //set smallIndex to the new value
      smallIndex = i;
    }
   }
  
    //return the smallest
    return smallIndex;
  }

  //my bad guys, I hit the wr

  /**
  SELECTION SORT:
  Implement the selection sort algorithm by sorting the
  ArrayList data in place.
  */
  public void sort(){
  
    // Loop a variable, i, through the ArrayList
    for (int i = 0; i < data.size(); i++){
          
      // get the index of the smallest value to the right of i
      int smallest = findSmallestIndex(i);

      // swap i with the smallest index  
      Collections.swap(data, i, smallest);
       
     }    
  }



  /* Search project starts here */
    
  /**
  Performs a linear search. Returns the index of the
  first occurrence of value in the ArrayList data or
  -1 if not found.
  This works by starting at the first element and
  searching one element at a time 
  until either the element is found or you've looked at
  all the elements.
  This algorithm works on any ArrayList.
  */
  public int linearSearch(int value){

    //loop through all the indices in order
    for(int i=0; i<data.size(); i++){

      //check for target value at each index
      if(data.get(i) == value){

        //return the index if the value is found
        return i;
      }
    }

    //return -1 if the index was not found
    return -1;
  }
    
  /**
  Implement a binary search as specified by the comments   
  This algorithm only works on sorted ArrayLists.
  */
  public int binarySearch(int targetValue){

    // create assign variables representing the high,
    // low and middle indices
    int lo = 0;
    int hi = data.size() - 1;
    int mid = (hi+lo)/2;
    
    //Print out the values of lo:mid:hi for each call
    if(printsOn){
      System.out.println(lo + ":" + mid + ":" + hi);
    }
    
    // while we're not done
    while( lo <= hi ){

      //Print out the values of lo:mid:hi for each loop
      if(printsOn){
        System.out.println(lo + ":" + mid + ":" + hi);
      }
      
      //see the value of the middle
      int checkMid = data.get(mid);
      
      // if the targetValue is in the middle, return mid index
      if(targetValue == checkMid){
        return mid;
      } 

      // if target is below, move hi down
      else if(targetValue < checkMid){
        hi = mid - 1;
      }

      // if target is above, move lo up
      else if(targetValue > checkMid){
        lo = mid + 1;
      }

      //update the new mid
      mid = (hi+lo)/2;
    }

    //return -1 if you didn't find the targetValue
    return -1;
    
  }
    
  /**
    Implement a RECURSIVE binary search as specified by
    the comments
     
    This algorithm only works on sorted ArrayLists.
  */

  public int binarySearchRecursive(int targetValue, int lo,
                                   int hi){
    
    //find the mid
    int mid = (hi + lo)/2;
    int midValue = data.get(mid);

    //Print out the values of lo:mid:hi for each call
    if(printsOn){
      System.out.println(lo + ":" + mid + ":" + hi);
    }
    
    //BASE CASE 1: Found the value
    if(targetValue == midValue){
      return mid;
    }

    //BASE CASE 2: Value not found
    else if(hi == lo){
      return -1;
    }
    
    //RECURSIVE CASE 1: targetValue is higher
    else if(targetValue > midValue){
      return binarySearchRecursive(targetValue, mid+1, hi);
    }

    //RECURSIVE CASE 2: targetValue is lower
    else {
      return binarySearchRecursive(targetValue, lo, mid-1);      
    }

    
  }
    
	
  public String toString(){
    return ""+data;
  };


  public void builtinSort(){
    Collections.sort(data);
  }

  //helper method 
  public int size(){
    return data.size();
  }

  public void setPrintsOn(boolean b){
    printsOn = b;
  }
}