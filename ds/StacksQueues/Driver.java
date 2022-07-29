// Date: 7/29/22
// Group 11
// Collaborators: Alana R., Seth. A., Théa W., Joel B

import java.io.*;
import java.util.*;

public class Driver{

    public static void main(String[] args) {

      System.out.println("\nWelcome to Stacks & Queues!");

      System.out.println("\n\n----------TESTS FOR STACK METHODS----------");
      System.out.println("\nNew Stack created!");
    	Stack s = new Stack();
      System.out.println("Stack s: " + s);

      System.out.println("\nTesting pop() on an empty stack");
    	System.out.println(s.pop());

      System.out.println("\nPopulating stack with pop() method, with 1 first in (bottom of stack), and 10 last in (top of stack)");
      for(int i = 1; i <= 10; i++){
        s.push(i);
      }
      System.out.println("Stack s: " + s);

      System.out.println("\nTesting pop() again");
    	System.out.println(s.pop());
      System.out.println("Stack s: " + s);

      System.out.println("\nWhat is the top item now? ");
    	System.out.println(s.top());
      System.out.println("Stack s: " + s);

      System.out.println("\nIs it empty? ");
    	System.out.println(s.isEmpty());

      System.out.println("\nSize of the stack: ");
    	System.out.println(s.size());      

      
      System.out.println("\n\n----------TESTS FOR QUEUE METHODS----------");
      System.out.println("\nNew Queue created!");
    	Queue q = new Queue();
      System.out.println("Queue q: " + q);

      System.out.println("\nTesting dequeue() on an empty queue");
    	System.out.println(q.dequeue());

      System.out.println("\nPopulating queue with enqueue() method, with 1 first in (front of line), and 10 last in (back of line)");
      for(int i = 1; i <= 10; i++){
        q.enqueue(i);
      }
      System.out.println("Queue q: " + q);

      System.out.println("\nTesting dequeue() again");
    	System.out.println(q.dequeue());
      System.out.println("Queue q: " + q);

      System.out.println("\nWhat is the front item now? ");
    	System.out.println(q.front());
      System.out.println("Queue q: " + q);

      System.out.println("\nIs it empty? ");
    	System.out.println(q.isEmpty());

      System.out.println("\nSize of the queue: ");
    	System.out.println(q.size()); 

      
      System.out.println("\nProgram finished");    
      
    }
}
