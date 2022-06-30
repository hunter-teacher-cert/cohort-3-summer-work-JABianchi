// Tracing
// Useful visualization:
// https://pythontutor.com/visualize.html

//import java.util.*;

public class SpaceLoop {
    public static void main(String[] args) {
      
      //Scanner eyes = new Scanner(System.in);
      String someString = "What is this?";
      System.out.println("Write something");
      //String someString = eyes.nextLine();

      // Go through the first word character by character without displaying anything
      // Precondition: someString does not begin with spaces. Words are separated by spaces.
      // Thus, someString in position 0 is not a space char.
      int i = 0;
      while ( someString.charAt( i ) != ' ')
      {
        i++;
      }
 
      // Postcondition: someString in position i IS a space.
      // Go through all the spaces after the first word
      while (someString.charAt( i ) == ' ')
      {
        i++;
      }

      // Postcondition: someString in position i IS NOT a space.
      // Go through the second word character by character and display each character.
      // Precondition: someString[ i ] is the first letter of the second word
      while (someString.charAt(i) != ' ') // This only works for sentences of three words or more. Try to fix it!
      {
        System.out.print( someString.charAt ( i ) );
        i++;
      }
      System.out.println();

  }
}