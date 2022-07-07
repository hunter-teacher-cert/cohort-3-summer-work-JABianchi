import java.io.*;
import java.util.*;

/**
 * Time class by Team LucidThinkeren
 * Saranii muller who understands nothing AT ALL 
 * collaborators: Kirk Martin, Joel Bianchi, Jessica Novillo
*/

/**
   INSTRUCTIONS:

   This file contains the starter code for our Time class.

   The class here uses ints for hours, minutes, and seconds but you
   could decide to change the internal representation to just store
   an int representing a number of seconds.

   Place this file in a folder named programming/5/Time.java

   Basic level (complete all):
   - public Time(int hrs, int mins, int secs) - constructor
   - public void toString()
   - public void set(int hrs, int mins, int secs)

   Intermediate level (complete Basic methods plus this method):
   - public void add(Time other)
   - public boolean isEquals(Time other)

   
   Advanced level (complete Basic + Intermediate + these two methods):
   - public int compareTo(Time other)
   
*/


public class Time {
    // Instance Variable(s)
    int hours;
    int minutes;
    int seconds;

    // Constructor #1: Default Constructor has no parameters
    public Time(){
    	this.hours = 0;
    	this.minutes = 0;
    	this.seconds = 0;
    }

    /**
       Parameters:
       - hrs, mins, secs - the time you want to create the class as
       Initialize this instance to represent hrs:mins:secs as the time.
     */
    //Constructor #2; takes in 3 different parameters
    public Time(int hrs, int mins, int secs){

    	this.hours = hrs;
    	this.minutes = mins;
    	this.seconds = secs;
	
    }
    
    //Additional Methods

    /**
       returns a string representation of the time
    */
    public String toString(){
	    return("The time is: " + hours + ":" + minutes + ":" + seconds);
    }

    /**
       Parameters:
       - hrs,mins,secs - ints representing a time

       modifies this instance to represent the time hrs:mins:secs
    */
    public void set(int hrs, int mins, int secs){
	// add the code to add the time represented by other
	// to this instance.
      this.hours = hrs;
    	this.minutes = mins;
    	this.seconds = secs;
    }

    /**
       Parameters:
       - other - a variable of type Time

       modifies this instance to represent the result of adding it and
       the time other.
    */
    public void add(Time other){
	// add the code to add the time represented by other
	// to this instance.

      //convert both Time objects -- other and this current one -- to seconds
      int otherSeconds = other.convertToSeconds();
      int currentSeconds = convertToSeconds();

      //add up the total seconds
      int totalSeconds = otherSeconds + currentSeconds;

      //determine the amount of hours, minutes and remaning seconds totalled
      hours = totalSeconds / 3600;
      totalSeconds %= 3600;

      minutes = totalSeconds / 60;
      totalSeconds %= 60;

      seconds = totalSeconds;      

    }

    public int convertToSeconds(){
     
      return (hours *60 *60) + (minutes*60) + (seconds);
      
    }


  

    /**
       Parameters:
       other - a variable of type Time

       Returns:
       True if this instance and other represents the same time
       false otherwise.
    */
    public boolean equals(Time other){
      if(other.hours == hours && other.minutes == minutes && other.seconds == seconds){
        return true;
      }
      return false;      
    }

    /**
       Parameters:
       other - a variable of type Time

       Returns:
       A positive number if this instance represents a time greater
       than the time of other (this > other)

       A negative number if this instance represents a time less
       than the time of other (this < other)

       0 if the two instances represent the same time.

    */
    public int compareTo(Time other){
      
      //convert both Time objects -- other and this current one -- to seconds
      int otherSeconds = other.convertToSeconds();
      int currentSeconds = this.convertToSeconds();

      System.out.println("OtherSec: " + otherSeconds);
      System.out.println("CurrentSec: " + currentSeconds);

      return currentSeconds - otherSeconds;
      /*
      //check if this is > other
      if(currentSeconds > otherSeconds){
        return 1;        
      }

      //check if other is > this
      else if(otherSeconds > currentSeconds){
        return -1;        
      }
      
      //0 if the two instances represent the same time.
      else{
        return 0;
      }
      */

    }
    

    
}//end class