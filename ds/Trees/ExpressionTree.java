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

  //Constructor #3: Tree with 1 operator and 1 subtree
  public ExpressionTree(char op, ExpressionTree l){
    operator = op;
    left = l;
    right = null;
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

      // RECURSIVE CASE 1: 1 child
      else if(right == null){
        
        // return only the value
        result = apply(left.evaluate(), 0.0, operator);
      }
      
      // RECURSIVE CASE 2: 2 children
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
      
      // RECURSIVE CASE 1: 1 child
      else if(right == null){
        cast += "(" + left + " " + operator + ")";
      }
        
      // RECURSIVE CASE 2: 2 children
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


  //ex. "(* (- (+ 1.0 1.0) (/ 1.0 2.0)) 3.0)"
  /*           `*`
             /    \
          '-'     3.0
        /     \
      '+'      '/'
      /  \     /  \
    1.0  1.0  1.0  2.0
  */
  public String toStringPrefix(){

      //initialize a String variable to be returned later
      String cast="";
            
      // BASE CASE: no children, only a value
      if(isValue()){
        // return the value (i.e. 10)
        cast += "(" + value + ")";
      }
      
      // RECURSIVE CASE 1: 1 child
      else if(right == null){
        cast += "(" + operator + " " + left + ")";
      }
        
      // RECURSIVE CASE 2: 2 children
      else{
        // Add a (
        cast += "(";
        // Add the operator
        cast += operator;
        // Add a SPACE
        cast += " ";
        // Add left
        cast += left.toStringPrefix();
        // Add a SPACE
        cast += " ";
        // Add right
        cast += right.toStringPrefix();
        // Add a )
        cast += ")";

      }
      //return our string
      return cast;
    
  }  

  
  //ex. "(* (- (+ 1.0 1.0) (/ 1.0 2.0)) 3.0)"
  /*
              `*`
             /    \
          '-'     3.0
        /     \
      '+'      '/'
      /  \     /  \
    1.0  1.0  1.0  2.0
  */
  public void printDiagram(){

    // BASE CASE: no children, only a value
    if(isValue()){
      //print the value
      System.out.print(value);
      return;
    }
      
    // RECURSIVE CASE:

    //determine the size of the diagram

    //Create an Array of Strings for each level to be printed

    //
    System.out.println("Recursive case");
  }

  public int getNumLevels(String toStringPrefix){

    return 1;
    
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
   }else if(op == '^'){
    return Math.pow(a,b);
   }else if(op == 's'){
    return Math.sqrt(a);
   }else{ //  if(op == '/'){ //or any invalid operators
    return a/b;
   }

  }


 }
