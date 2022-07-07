public class GradeDriver{


  public static void main(String[] animals){

    Grade g2 = new Grade("3456", 95, 0.10);
    g2.showInfo();

    Grade g = new Grade();
    g.showInfo();
    g.setID("123456789");
    g.showInfo();
    g.setID("123");
    System.out.println( g.getID() );

    
  }


  
}