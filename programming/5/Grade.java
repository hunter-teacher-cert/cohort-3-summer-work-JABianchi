public class Grade{

  //private instance variables
  private String ID;
  private int score;
  private double weight;

  //Constructor #1
  public Grade(String ID, int score, double weight ){
    this.ID = ID;
    this.score = score;
    this.weight = weight;
  }

  //Constructor #2: Default Constructor
  public Grade(){
    ID = "Bob";
    score = 100;
    weight = 0.5;
  }

  //get access to the ID variable 
  public String getID(){
    return ID;
  }

  //set the instance variable for ID
  public void setID(String ID){
    this.ID = ID;
  }

  //print out the grade information
  public void showInfo(){
    System.out.println(ID + score + weight);
  }

}