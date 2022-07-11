/**
   lab skeleton
   encapsulation / SuperArray

   SuperArray is a wrapper class for an array.
   Provides "pass-thru" accessibility to array capabilities:
   - get/set by index
   - get length
   Adds functionality:
   - dynamic capacity
   - auto-grow capacity if necessary
 **/

import java.io.*;
import java.util.*;

public class SuperArray
{
  //instance vars
  private int[] data;           //where the actual data is stored
  private int numElements;   //number of "meaningful" elements


  // ~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~
  //overloaded constructor -- allows specification of initial capacity
  public SuperArray( int size )
  {
    data = new int[size];
    numElements = 0;
  }

  //default constructor -- initializes capacity to 10
  public SuperArray()
  {
    // "this" calls the overloaded constructor and passes 10 as the size
    this(10);
  }


  // ~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~
  public void add( int value )
  {
    // test to see if we need to grow, then grow
    if(isFull()){
      grow();
    }

    // add item
    int lastIndex = numElements - 1;
    data[lastIndex + 1] = value;

    // increment numberElements
    numElements++;


  }//end add()

  //overloaded add method which adds at a specific index
  public void add( int index, int value )
  {
    // test to see if we need to grow, then grow
    if(isFull()){
      grow();
    }

    // increment numberElements
    numElements++;

    //shift over last part of array after the specified index
    for(int i= numElements - 1; i > index; i--){
      data[i] = data[i-1];
    }
    
    //add new item at specified index
    data[index] = value;  

  }//end add()

  public void remove(int index){

    //decrement number of elements
    numElements--;

    //shift to left the elements AFTER the index
    //traverse from left to right
    for(int i=index; i<numElements; i++){
      data[i] = data[i+1]; 
    }    
    
  }

  public boolean isEmpty()
  {
    if(numElements == 0){
      return true;
    }
    return false;
  }

  public boolean isFull(){

    if(numElements == data.length){
      return true;
    }
    return false;
  }  


  public int get(int index)
  {
    return data[index];
  }


  public String toString()
  {
    String out = "Data: [";

    for(int i=0; i<numElements; i++){
      out += data[i] + " ";
    }    
    out += "]";
    return out;
  }//end toString()


  //helper method for debugging/development phase
  public String debug()
  {
    String s = "";
    s = "Size: " + this.data.length;
    s = s + " LastItem: " + numElements + "  Data: ";
    for (int i = 0; i < numElements; i++) {
      s = s + data[i] + ", ";
    }
    s = s + "\n";
    return s;
  }//end debug()


  private void grow()
  {
    // create a new array with extra space  
    // Q: How did you decide how much to increase capacity by?
    int additionalElements = 10;
    int oldLength = data.length;
    int[] data2 = new int[oldLength + additionalElements];

    // copy over all the elements from the old array to the new one
    for(int i=0; i<oldLength; i++){
      data2[i] = data[i]; 
    }

    // point data to the new array
    // Q: How does this look when illustrated using encapsulation diagram?
    data = data2;

  }//end grow()

}//end class
