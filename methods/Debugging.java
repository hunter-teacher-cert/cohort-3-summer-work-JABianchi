import java.util.*;

public class Debugging{

  public static final String[] OPPONENTS = {"Dave", "Jenna", "Jerusha", "Joel"};

  public static void main(String[] antarctica){
    System.out.println("Nim class starting!");

    String stones = 12;
      int stonesTaken
    playerFirst = true;
    boolean playerTurn = true
    int oppIndex = (int) (Math.random() * OPPONENTS.length);
    
    String userResponse = "";
    Scanner eyes = new Scanner(System.in);

  System.out.println("Would you like to go first? [Y/N]");
    userResponse = eyes.nextLine().toLowerCase();
        if( userresponse.equals("n")){
      playerFirst = false;
    
    }

    //loop until game ends
    while(stones > 0){

      //prompt user input (user turn)
      System.out.println("How many stones would you like to take?");
      stonesTaken = eyes.nextInt();
      eyes.nextLine();
      
      //calculate numbers of stone remaining
      stones -= stonesTaken;
      System.out.println("Number of stones remaining: " + stones);

      //check for win
      if(stones <= 0){
            System.out.println("You win!");
            break;
          }
      
      //machine turn: if 3 or fewer, take all the remaining stones
      if(stones <=3){
        stonesTaken = stones;
       
      else{
        stonesTaken = (int) (Math.random() * 3) + 1;        
  }
      
      System.out.println("Computer takes " + stonesTaken  " stones");
      
      //calculate numbers of stone remaining
      stones -= stonesTaken;
      System.out.println("Number of stones remaining:"  + stones);

//check win
if(stones <= 0{
  System.out.println("You lose!);
  break;

      }
    }

        System.out.println(Game over!");

    
    
        }

  
