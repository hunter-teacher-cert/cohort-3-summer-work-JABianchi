import java.io.*;
import java.util.*;

public class SortSearchDriver {
  
  public static void main(String[] args) {

	// Uncomment these to test part 1
  System.out.println("\nA new ArrayList ss with 20 random integers:");
	SortSearch ss = new SortSearch(20);
	System.out.println(ss);

  // SortSearch ss2 = new SortSearch();
	// System.out.println(ss2);
			
	// Uncomment these to test part 2
	int i;

  System.out.println("\nFinding index of smallest element in ss ArrayList starting from beginning:");
	i = ss.findSmallestIndex(0);
  System.out.println("ss["+ i +"] = "+ss.get(i));

  System.out.println("\nFinding index of smallest element in ss ArrayList starting from index 13:");
	i = ss.findSmallestIndex(13);
	System.out.println("ss["+ i + "] = "+ss.get(i));
	
	// Uncomment these to test part 3
	System.out.println("\nUse selection sort on ss:");
	ss.sort();
	System.out.println(ss);

  //LINEAR SEARCH
  System.out.println("\nDoing a LINEAR SEARCH for a 7 in the ss ArrayList: ");
  int found = ss.linearSearch(7);
  if(found == -1){
    System.out.println("not found");
  } else {
    System.out.println("found at index " + found);
  }

  //BINARY SEARCH
  System.out.println("\nDoing a BINARY SEARCH for a 7 in the ss ArrayList: ");
  int found2 = ss.binarySearch(7);
  if(found2 == -1){
    System.out.println("not found");
  } else {
    System.out.println("found at index " + found2);
  }

    //BINARY SEARCH RECURSIVE
    System.out.println("\nDoing a BINARY SEARCH for a 7 in the ss ArrayList: ");
  int found3 = ss.binarySearchRecursive(7, 0, ss.size());
  if(found3 == -1){
    System.out.println("not found");
  } else {
    System.out.println("found at index " + found3);
  }

    binarySearchRecursive(int targetValue, int lo,
                                   int hi){

    
	

  }
}