public class Grade{

  private String ID;
  private int score;
  private double weight;

  public Grade(String ID, int score, double weight ){
    this.ID = ID;
    this.score = score;
    this.weight = weight;
    
  }

  public Grade(){
    ID = "Bob";
    score = 100;
    weight = 0.5;
  }

  

  public String getID(){
    return ID;
  }

  public void setID(String ID){
    this.ID = ID;
  }

  public void showInfo(){
    System.out.println(ID + score + weight);
  }

  
  
}