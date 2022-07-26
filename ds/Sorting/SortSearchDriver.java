import java.util.*;

public class SortSearchDriver {

  //variables that help us track time
  public static long start = 0;
  public static long elapsed = 0;

  //How big should the list be?
  public static int size = 100000;  // the number of elements in data
  //public static int size = 12000000;  //largest? number that can fit in memory in replit

  
  public static void main(String[] args) {

    //Which index should be tested?
    int testIndex = size-1;
    //int testIndex = size/2 +1;
    //int testIndex = 17;

    
    //Test CONSTRUCTORS
    System.out.println("\nA new ArrayList ss with " + size + " ordered integers:");
  	SortSearch ss = new SortSearch(size, true);
    ss.setPrintsOn(false); //turn off prints that affect timing  
      
    //System.out.println("\nA new ArrayList ss with " + size + " random integers:");
    //SortSearch ss = new SortSearch(size);
  	printList(ss);
    
    // SortSearch ss2 = new SortSearch();
  	//printList(ss2);
  			
  	//Test FINDSMALLEST()
  	int i;
  
    System.out.println("\nFinding index of smallest element in ss ArrayList starting from beginning:");
  	i = ss.findSmallestIndex(0);
    System.out.println("ss["+ i +"] = "+ss.get(i));
  
    System.out.println("\nFinding index of smallest element in ss ArrayList starting from index " + testIndex + " :");
  	i = ss.findSmallestIndex(testIndex);
  	System.out.println("ss["+ i + "] = "+ss.get(i));
  	
  	//Test SELECTION SORT
    if(size < 500001){  //only sort if replit can handle the size in a reasonable amount of time
    	System.out.println("\nUse selection sort on ss:");
      startTimeTest();
    	ss.sort();
      endTimeTest();
      printList(ss);
    }
  
    //Test LINEAR SEARCH
    System.out.println("\nDoing a LINEAR SEARCH for a " + testIndex + " in the ss ArrayList: ");
    startTimeTest();
    int found = ss.linearSearch(testIndex);
    endTimeTest();
    if(found == -1){
      System.out.println("not found");
    } else {
      System.out.println("found at index " + found);
    }
  
    //Test BINARY SEARCH
    System.out.println("\nDoing a BINARY SEARCH for " + testIndex + " in the ss ArrayList: ");
    startTimeTest();
    int found2 = ss.binarySearch(testIndex);
    endTimeTest();
  
    if(found2 == -1){
      System.out.println("not found");
    } else {
      System.out.println("found at index " + found2);
    }


    //Test BINARY SEARCH RECURSIVE
    System.out.println("\nDoing a RECURSIVE BINARY SEARCH for a " + testIndex + " in the ss ArrayList: ");
    startTimeTest();
    int found3 = ss.binarySearchRecursive(testIndex, 0, size);
    endTimeTest();
    if(found3 == -1){
      System.out.println("not found");
    } else {
      System.out.println("found at index " + found3);
    }

    //Test MERGING METHODS
    // System.out.println("\n New list4 ArrayList with a size of " + 3);
    // ArrayList<Integer> list4 = ss.buildIncreasingList(3);
    // System.out.println(list4);

    // System.out.println("\n New list5 ArrayList with a size of " + 3);
    // ArrayList<Integer> list5 = ss.buildIncreasingList(3);
    // System.out.println(list5);
    
    // System.out.println("\nMerging list4 & list5 into a new list6:");
    // ArrayList<Integer> list6 = ss.merge(list4, list5);
    // System.out.println(list6);

    //MERGESORT TEST
    System.out.println("\nCreate a new set of data called ss2 of size " + size);
    SortSearch ss2 = new SortSearch(size);
    printList(ss2);
    System.out.println("\nDoing a MERGE SORT on ss2 ArrayList:");
    startTimeTest();
    ss2.msort();
    endTimeTest();
    printList(ss2);
    
    
    

    

    

	      

  }

  public static void startTimeTest(){
    //start = System.currentTimeMillis();
    start = System.nanoTime();
  }
  public static void endTimeTest(){
    //System.out.println("Size: " + size);
    
    //elapsed = System.currentTimeMillis() - start;
    //System.out.println(" Time: " + elapsed + " ms");
 
    elapsed = System.nanoTime() - start;
    System.out.println(" Time: " + elapsed/1000 + " us");

  }
  public static void printList(SortSearch ss){
    if(size < 50) {
      System.out.println(ss);
    }
  }
}