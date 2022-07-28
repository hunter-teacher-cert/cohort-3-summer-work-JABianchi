public class TreeDriver{
  public static void main(String[]args){

    System.out.println("\nEXPRESSION TREES\n---------------------");
    
    //1. Single value trees
    ExpressionTree one = new ExpressionTree(1.0);
    ExpressionTree two = new ExpressionTree(2.0);
    ExpressionTree three = new ExpressionTree(3.0);
    ExpressionTree four = new ExpressionTree(4.0);
    ExpressionTree five = new ExpressionTree(5.0);
    ExpressionTree ten = new ExpressionTree(10.0);

    //2.Trees with children
    ExpressionTree a = new ExpressionTree('+',one,one);//2.0  "(1.0 + 1.0)"
    ExpressionTree b = new ExpressionTree('-',five,ten);//-5.0 "(5.0 - 10.0)"
    ExpressionTree c = new ExpressionTree('*',three,four);//12.0 "(3.0 * 4.0)"
    ExpressionTree d = new ExpressionTree('/',one,two);//0.5 "(1.0 / 2.0)"


    //toString() Tests
    System.out.println("\nTesting toString() on single values");
    System.out.println(one);
    System.out.println(two);
    System.out.println(three);
    System.out.println(four);
    System.out.println(five);
    System.out.println(ten);

    System.out.println("\nTesting toString() on trees with children");
    System.out.println(a);
    System.out.println(a);
    System.out.println(c);
    System.out.println(d);

    //evaluate Tests
    System.out.println("\nTesting evaluate() on single value trees");
    System.out.println(one.evaluate()==1.0);
    System.out.println(two.evaluate()==2.0);
    System.out.println(three.evaluate()==3.0);
    System.out.println(four.evaluate()==4.0);
    System.out.println(five.evaluate()==5.0);
    System.out.println(ten.evaluate()==10.0);
    
    System.out.println("\nTesting evaluate() on trees with children");
    System.out.println("a tree: " + a + " is equal to " + a.evaluate());
    System.out.println("b tree: " + b + " is equal to " + b.evaluate());
    System.out.println("c tree: " + c + " is equal to " + c.evaluate());
    System.out.println("d tree: " + d + " is equal to " + d.evaluate());


    //3. Multi level trees which need to be evaluated:
    System.out.println("\nTesting on multi-level trees");
    ExpressionTree e = new ExpressionTree('/',c,two);
    ExpressionTree f = new ExpressionTree('-',c,ten);
    ExpressionTree g = new ExpressionTree('+',b,c);
    ExpressionTree h = new ExpressionTree('*',a,e);


    System.out.println("e tree: " + e + " is equal to " + e.evaluate());
    System.out.println("f tree: " + f + " is equal to " + f.evaluate());
    System.out.println("g tree: " + g + " is equal to " + g.evaluate());
    System.out.println("h tree: " + h + " is equal to " + h.evaluate());

    
    /** expected output:
    ((3.0*4.0)/2.0) is equal to 6.0
    ((3.0*4.0)-10.0) is equal to 2.0
    ((5.0-10.0)+(3.0*4.0)) is equal to 7.0
    ((1.0+1.0)*(1.0/2.0)) is equal to 1.0
    (((1.0+1.0)*(1.0/2.0))+1.0) is equal to 2.0
    */

    //TOSTRING PREFIX
    System.out.println("\nTesting alternate toStringPrefix() method:");
    System.out.println(f.toStringPrefix());
    System.out.println(g.toStringPrefix());
    System.out.println(h.toStringPrefix());


    //ADDITIONAL OPERATORS
    System.out.println("\nTesting additional operators ^ and s :");
    ExpressionTree i = new ExpressionTree('^',g,two);
    ExpressionTree j = new ExpressionTree('s',i);
    System.out.println("i tree: " + i + " is equal to " + i.evaluate());
    System.out.println("j tree: " + j + " is equal to " + j.evaluate());
    

    //TREE DIAGRAM
    System.out.println("\nTesting in ExpressionTree Diagrams");

    System.out.println(one.toString());
    one.printDiagram();

    
    System.out.println(f.toString());
    f.printDiagram();

  }
}
