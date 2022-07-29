// Date: 7/29/22
// Group 11
// Collaborators: Alana R., Seth. A., Théa W., Joel B

import java.util.*;

// a queue is a First In First Out (Fifo) structure (think stack of plates) so you never have to tell it where to remove from
public class Queue{

  //I chose an ArrayList to build the queue because it can accomodate any number of elements.     //I know a linked list can also do this, but I find them more confusing.
    //we decided to make the end of the arraylist our "front" of queue  

  // Place private instance variables here
  private ArrayList<Integer> queue;

  //Constructor #1: Default with no parameters
  public Queue(){
    queue = new ArrayList<Integer>();
  }

  // adds value to the end of the queue
  public void enqueue(int value){
    queue.add(value);
  }
  
  // removes and returns the top value from front of the queue
  //Queue should be FIRST IN, FIRST OUT
  //Oldest item added is now in index 0
  public Integer dequeue()
  {
    if(isEmpty()){
      System.out.println("Cannot dequeue because queue is empty");
      return null;
    }
    return queue.remove(0);
  }
  
  //returns but do not remove the top value from the front of the queue
  public Integer front()
  {
    if(isEmpty()){
      System.out.println("Cannot return front because queue is empty");
      return null;
    }
    return queue.get(0);
  }
  
  // returns true of the queue is empty, false otherwise
  public boolean isEmpty(){
    return queue.size() == 0; 
  }
  
  // returns the number of elements currently in the queue
  public int size(){
    return queue.size();
  }

  // toString for the Queue
  public String toString(){
    return "" + queue;
  } 

}
