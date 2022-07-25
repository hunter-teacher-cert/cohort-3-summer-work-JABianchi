//public class 06_scaffold_solution{
public class PrintMethodsClass {

  public static void main(String[] ants ){

    /* Test code to be provided */
    //1. Printing

    //2. Searching & Replacing

    //3. 
    
    //4. Testing Equality

    //5. String Traversal

    
  }


  //1a. Print all the characters in a String
  public static void printLetters(String word){

    //loop through each letter in the String
    for(int i=0; i<word.length(); i++){

      //get each letter
      String letter = word.substring(i,i+1);
      
      //print each letter
      System.out.print(letter);
    }
  }
  
  //1b. Print all the elements of the array
  public static void printArray(int[] arr){

    
    
  }

  //2a. Search a String for a letter and replace
  public static void searchReplaceString(String word, String searchLetter, String replaceLetter){


    
  }
  
  //2b. Searching & Replacing
  public static void searchReplaceArray(int[] arr, int searchNum, int replaceNum){


    
  }

  //3a. Check if 2 Strings have the same letters
  public static boolean isSameString(String word1, String word2){

    //check if the words have the same length


    //if so, loop through each index


      //compare the letters from each word


        //return false if letters aren't the same


    //return true if the whole words have the same letters
    return false; //change
  }
  
  //3b. Test if 2 arrays have the same values
  public static boolean isSame(int[] arr1, int[] arr2){


        return false; //update later!
    
  }

  //4a. Reverse a word
  public static String reverseString(String word){


    return "";
  } 
  
  //4b. Reverse the given Array
  public static int[] reverseArray(int[] arr){



    return new int[0]; //update later!
  }
  

  
  
}