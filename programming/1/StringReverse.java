public class StringReverse{

  public static void main(String[] arc){
    String word = "word";

    for(int i=word.length()-1; i>=0; i--){
      System.out.print(word.substring(i,i+1));
    }

    System.out.println();
  }

  
}