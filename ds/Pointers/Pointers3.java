//Driver class for Pointers 3 assignment
//Shared from Marieke Thomas

public class Pointers3{
  public static void main(String[] args){

    //SETTING UP THE LINKEDLIST
    Node p = new Node("5");
    p.setNext(new Node("10"));
    p.getNext().setNext(new Node("15", new Node ("20")));
    printList(p);

    //ACTUAL Part 3 CODE
    //3-1. Create a new Node variable set it to point to the node with the 10 in it.
    
    //get the Node with the 10 in it
    Node p2 = p.getNext();
    
    //creates a new node
    Node p5 = new Node();
    
    //sets the new node to point to the Node with the 10
    p5.setNext(  p2  );
    
    //3-2. Create a new Node variable
    // and instantiate it to a new Node with a value of 30.
    Node p6 = new Node("30");
    
    //3-3. Write the code to insert this new Node between the 10 and the 15

    //point the new p6 node to the 15node
    p6.setNext( p.getNext().getNext() );
    
    //point the 10node to the p6 node
    p.getNext().setNext( p6 );


    printList(p);    

  }

  //helper method
  public static void printList(Node n){
    System.out.println("Checking the setup values");

    //keep repeating until you find a null "next Node"
    while( n.getNext() != null){

      //get the data from the current Node
      String data = n.getData();

      //print out the data
      System.out.println(data);
      
      //make n point to the next Node in the list
      n = n.getNext();
    } 

    //Print the final item
    System.out.println(n.getData());
    

  }

  
}