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


 /* Merge Sort Stuff after here */
    /**
       Builds and returns an ArrayList that's already in increasing order.
       You can use this method to test your merge method.
    */
    public ArrayList<Integer> buildIncreasingList(int size){
	ArrayList<Integer>  newlist = new ArrayList<Integer>();
	Random r = new Random();
	int nextval = r.nextInt(20)+1;
	for (int i=0;i<size;i++){
	    newlist.add(nextval);
	    nextval = nextval + r.nextInt(20);
	}

	return newlist;
	}

    /**
       this routine should create and return a new ArrayList of
       integers and fill it by merging list1 and list2 into the new
       list.
       list1 and list2 are already sorted in increasing order.
       Example:
       If list1 contains [1,5,17,25]
       and list2 contains [3,6,10,30,40,50]
       The new list will contain:
       [1, 3, 5, 6, 10, 17, 25, 30, 40, 50]
       
    */    
     public ArrayList<Integer> merge( ArrayList<Integer> list1,
				    ArrayList<Integer> list2){
      
      //create a new ArrayList list3 to hold the values from list1 & list2 
			ArrayList<Integer> list3 = new ArrayList<Integer> ();

      //use i and j to keep track of where we are in list 1 & list2
      int i = 0;
      int j = 0;

      // CASE 1: add the smaller element from one of the lists
      //keep looping until at the end of both lists
      while(i < list1.size() && j < list2.size()){
      
        //check if list1's element is smaller
        if(list1.get(i) < list2.get(j)){

          //add it to the new list
          list3.add(list1.get(i));

          //increment i appropriately
          i++;
        }
        
        //check if list2's element is smaller
        else{
          
          //add it to the new list
          list3.add(list2.get(j));
          
          //increment j appropriately
          j++;
        }

      }

      // Case 2: if at the end of list1, pull from list2
      while(j < list2.size()){
        
          //add it to the new list
          list3.add(list2.get(j));
          
          //increment j appropriately
          j++;
      }

      // Case 3: if at the end of list2, pull from list1
      while(i < list1.size()){
        
          //add it to the new list
          list3.add(list1.get(i));
          
          //increment i appropriately
          i++;
      }

      //return the new list 
      return list3;
    }

public ArrayList<Integer> mergeSort(ArrayList<Integer> list){
  
    //BASE CASE: if the number of elements is less than 2, then stop doing recursion!
    if(list.size() < 2)
      return list;

    //RECURSIVE CASES: split in two lists
    int middle = list.size() / 2;
    
    //fill up the left ArrayList from 0 to middle
    ArrayList<Integer> left = new ArrayList<Integer>();
    for(int i = 0; i < middle; i++){
      left.add(list.get(i));
    }
 
    //fill up the right ArrayList from middle to the end
    ArrayList<Integer> right = new ArrayList<Integer>();
    for(int i = middle; i < list.size(); i++){
      right.add(list.get(i));
    }
    
    // mergeSort the left half
    if(printsOn) System.out.println("LEFT-PRE\t" + left);
    left = mergeSort(left);
    if(printsOn) System.out.println("LEFT-POST\t" + left);
    
    // mergeSort the right half
    if(printsOn) System.out.println("RIGHT-PRE\t" + right);
    right = mergeSort(right);
    if(printsOn) System.out.println("RIGHT-POST\t" + right);
  
    // merge them together into a new list & return
    return merge(left, right);

  }


  public void msort(){
      data =  mergeSort(data);
  }



    
/* ------- HELPER  METHODS -------- */	
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