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
	// System.out.println(ss);
	// ss.sort();
	// System.out.println(ss);
	

  }
}