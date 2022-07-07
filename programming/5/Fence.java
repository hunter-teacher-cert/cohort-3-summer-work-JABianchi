/**
 * Recursion Practice with Strings by Team SweatEquity
 * Joel Bianchi JABianchi
 * collaborators: First Last, First Last
 */

public class Fence
{

  /**
     String fenceR(int) -- recursive fence generator
     precond:  input is a positive integer
     postcond: returns fence with n posts

     eg
     fenceR(1) -> "|"
     fenceR(2) -> "|--|"
     fenceR(3) -> "|--|--|"
     fenceR(4) -> "|--|--|--|"
  */
  public static String fenceR( int n )
  {
    /* YOUR SIMPLE, SMART IMPLEMENTATION HERE */
    
    String fence="";
    
    //BASE CASE: if n is 1, then just get a post, ending with base case
    if (n==1){
      return "|";
    }

    //RECURSIVE CASE: add on a post-dash-dash

    
  }


  public static void main( String[] args )
  {

    for( int i = 1; i < 10; i++ ) {
      System.out.println( i + "-post fences: " );
      System.out.println( fenceR(i) );
    }

    /* feel free to add extra tests... */

  }
}