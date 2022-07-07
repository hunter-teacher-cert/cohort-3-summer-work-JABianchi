public class GradeDriver{


  public static void main(String[] animals){

    //Construct a Grade object with a String, int, and double
    Grade g1 = new Grade("3456", 95, 0.10);

    //Display the information from the g1 Grade object
    g1.showInfo();

    //Construct another Grade object using the default constructor
    Grade g2 = new Grade();
    g2.showInfo();
    
    //set an actual ID value for the g2 Grade object
    g2.setID("123456789");
    g2.showInfo();

    //change it again!
    g2.setID("123");

    //print out just the ID... after getting the ID
    System.out.println( g2.getID() );

    
  }


  
}