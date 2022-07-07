import java.io.*;
import java.util.*;


/**
 * Driver class for Time class  by Team LucidThinkeren
 * Joel Bianchi
 * collaborators: Saranii, Kirk, Jessica
 */

/**
   INSTRUCTIONS:

   This file contains the Driver starter code for our Time class.
   
   Add code in main to test all your methods
   
   Place this file in a folder named programming/5/Driver.java

*/


public class Driver {

  public static void main(String[] args) {

  	//declare a var of appropriate type to assign an instance of Time to
  	Time t1;
  
  	//assign var the address of a newly-apportioned Time object
  	t1 = new Time();

    //declare & assign a specific time
    Time t2 = new Time(11,51,9);

    //print out the t1 and t2 times
    System.out.println("T1's time is: " + t1);
    System.out.println("T2's time is: " + t2);

    //Check if t1 and t2 are the same time
    System.out.println("Are T1 & T2 the same time? " +  t1.equals(t2));

    //Add some time to T1
    t1.add(new Time(1,1,1));
    System.out.println("After adding 1 hour, 1 min, and 1 sec, T1's time is: " + t1);

    //Compare the t1 and t2 times
    System.out.println("Comparing T1 & T2 times " +  t1.compareTo(t2));

    //Add some time to T1
    t1.add(new Time(10,50,8));
    System.out.println("After adding 10 hours, 50 min, and 8 sec, T1's time is: " + t1);

    //Check if t1 and t2 are the same time
    System.out.println("Are T1 & T2 the same time? " +  t1.equals(t2));

    
    
    
    
    
  }//end main()

}//end class