public class ArrayString{

  public static void main(String[] anteater){

    String s1 = "";
    String s2 = null;
    String[] bob = new String[5];
    
    System.out.println(s1==s2);    //false
    System.out.println(s1.equals(s2));  //false

    System.out.println("".equals(bob[0]));  //false
    System.out.println(bob[0] == null);  //true
    

    
  }
 
}