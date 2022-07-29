// Date: 7/29/22
// Group 11
// Collaborators: Alana R., Seth. A., Théa W., Joel B

import java.util.*;

// A stack is a Last In First Out (Lifo) structure
public class Stack{

  // private instance variable, using an ArrayList
  // Stack will be oriented with:
  //   0 on the bottom
  //   arrayList.size() - 1 on the top
  // Elements are added and popped from the top
  private ArrayList<Integer> stack;
  
  //Constructor #1: Default with no parameters
  public Stack(){
    stack = new ArrayList<Integer>();
  }

  //Push method adds a value to the top of the stack (end of ArrayList)
  public void push(int value){
    stack.add(value);
  }

  //Pop method that removes and returns the top value from the stack
  // What should be returned if there is an error?
  // We are returning an Integer object because it can send a null,
  // while a primitive int will have always have to pass a value
  // (which may be already be an item value in the list)
  public Integer pop(){

    //check case where stack is empty
    if (stack.isEmpty()){
      System.out.println("Cannot pop because stack is empty");
      return null;
    }
    
    // if have an element, return the element
    // AND then removes from the top of the stack (end of arrayList)
    return stack.remove(stack.size()-1); 
  }

  // top method that returns, but does not remove, the top value from the stack (end of the arrayList)
  public Integer top(){
    
    //check case where stack is empty
    if (stack.isEmpty()){
      System.out.println("Cannot return top because stack is empty");
      return null;
    }
    
    // if have an element, return the top element (at end of arrayList)
    return stack.get(stack.size()-1);
  }

  //isEmpty method returns true of the stack is empty, false otherwise
  public boolean isEmpty(){
    return stack.isEmpty();  //use ArrayList's isEmpty() method here
  }

  //size() method returns the number of elements currently in the stack
  public int size(){
    return stack.size();
  }

  //toString() method for a Stack object
  public String toString(){
    return "" + stack;
  }

}
