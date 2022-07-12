import java.util.ArrayList;

public class Ds1{

  public static void main(String[] amber){

    ArrayList<String> words = new ArrayList<String>();

    //adding
    words.add("fish");
    words.add("fish2");
    words.add("fish3");
    words.add(1,"somethingelse");

    System.out.println(words);

    System.out.println(words.get(0));
    words.set(0,"notfish");
    System.out.println(words.get(0));
    System.out.println(words);
    System.out.println(words.get(words.size()-1));
    
  }
    
}