//See ASCII Table here: https://www.asciitable.com/

//not working yet...

public class CharAscii{

  public static void main(String[] ants){

    //convert char to ASCII code
    char ch = 'Z';
    System.out.println( (int) ch);

    //convert ASCII code to character
    int anInt = 90;
    System.out.println( (char) anInt);

    //Display ASCII code for all elements of a String
    String someString = "feline";
    System.out.println("The ASCII characters for the String " + someString + " are: ");
    for(int i=0; i<someString.length(); i++){
      int temp = (int) someString.charAt(i);
      System.out.print( temp + " ");
    }

    //Convert a string from lowercase (97-122) to uppercase (65-90)

    String lowerWord = "bianchi";
    int lowerToUpperShift = 32;
    String upperWord = "";
        
    //loop through all the characters
    for(int i=0; i<lowerWord.length(); i++){
      //get ASCII code for lowercase
      int asciiCode = (int) lowerWord.charAt(i);
      
      //if the code is lowercase (97-122)
      if(asciiCode >= 97 && asciiCode <=122){

        //shift the int to the uppercase ascii code
        int upperAsciiCode = asciiCode + lowerToUpperShift;
        char upperAscii = (char) upperAsciiCode;

        //convert code to actual char
        String upperChar = "" + upperAscii;

        //add to new uppercase String
        upperWord += upperChar;
      
      } else {
        char lowerAscii = (char) asciiCode;
        String lowerChar = "" + lowerAscii;
        upperWord += lowerChar;
      }
      
    }
    
    System.out.println("\n\nThe word " + lowerWord + " can change to Upper case as " + upperWord + " !");
        
  }
 
}