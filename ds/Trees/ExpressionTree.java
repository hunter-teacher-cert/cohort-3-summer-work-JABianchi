//Author: Joel Bianchi
//Collaborators: Jerusha Theobald, Jenna Lin, Dave Ciolino-Volano
//Group 7

public class ExpressionTree{

  private double value;
  private ExpressionTree left,right;
  private char operator;

  //Constructor #1: Tree can be a value
  public ExpressionTree(double val){
   value = val;
   left = null;
   right = null;
  }

  //Constructor #2: Tree can be an operator that connects two sub-trees
  public ExpressionTree(char op, ExpressionTree l, ExpressionTree r){
    operator = op;
    left = l;
    right = r;
  }


   //You must write this method:
    //Calculate the value of the entire tree
    public double evaluate(){

      //initialize a double to be returned later
      double result = 0.0;
      
      // BASE CASE: no children, only a value
      if(isValue()){
        
        // return only the value
        result = value;
      }
      
      // RECURSIVE CASE:
      else{
        // evaluate left side
        double leftSide = left.evaluate();
        
        // evaluate right side
        double rightSide = right.evaluate();
        
        // do the operation
        result = apply(leftSide, rightSide, operator);
      }
      
      //return the double
      return result;
    }

    //You must write this method:
    //Return a string representation of the tree
    //A value is just hte string of the value
    //An operation has parenthesis around
    //such as
    //"12.5"  //just a value
    //"(5.0-8.0)" //a tree with 2 value children
    //"(12.5*(5.0-8.0)) //a tree that is the product of the previous two example trees
    //"(((2.0+1.0)/(8.0*0.43)) - 1.0)" //a tree with more
    
  public String toString(){

      //initialize a String variable to be returned later
      String cast="";
            
      // BASE CASE: no children, only a value
      if(isValue()){
        // return the value (i.e. 10)
        cast += value;
      }
      
      // RECURSIVE CASE:
      else{
        // Add a (
        cast += "(";
        // Add left
        cast += left.toString();
        // Add the operator
        cast += operator;
        // Add right
        cast += right.toString();
        // Add a )
        cast += ")";

      }
      //return our string
      return cast;
    }
  

  //Return true when the node is a value, false when it is an operator
  //when the children are null, the current tree is a value
  private boolean isValue(){
    return left==null && right ==null;
  }

  //Return false when the node is a value, true when it is an operator
  private boolean isOperator(){
    return !isValue();
  }

  //To simplify things, you get a method to use to convert the
  //operator and two values into a result.
  private double apply(double a, double b, char op){
   if(op == '+'){
    return a+b;
   }else if(op == '-'){
    return a-b;
   }else if(op == '*'){
    return a*b;
   }else{ //  if(op == '/'){ //or any invalid operators
    return a/b;
   }

  }

 }
