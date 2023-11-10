import java.util.*;

// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collections.html

public class TestListVsSet {


public static void main(String[] args) {
       
     List <String> list = new ArrayList <String> (); 
    
    long start = System.currentTimeMillis();
     for (int i=0;i<1000000;i++) {
     //if (!list.contains("element"+i))
       list.add("element"+i);
     }
     long end = System.currentTimeMillis();
      
    System.out.println("Adding elements to array list took: "+ (end - start));

    start = System.currentTimeMillis();
     System.out.println(list.contains("element23000"));
    end = System.currentTimeMillis();

    System.out.println("Checking if list contains element that is present took: "+ (end - start));
    
    //we need to sort for ninary search
    
    Collections.sort(list);
 
    start = System.currentTimeMillis();
    int index = Collections.binarySearch(list,"element23000");
    
    if (index>=0) {
      System.out.println("Found element at index: " +index + " element:" + list.get(index));  
    }
    else {
        System.out.println("Element not present");
    }
    end = System.currentTimeMillis();

    System.out.println("Searching with binary search for element that is  present took: "+ (end - start));

    start = System.currentTimeMillis();
     index = searchList(list,"element23000");
     if (index>=0) {
      System.out.println("Found element at index: " +index + " element:" + list.get(index));  
    }
    else {
        System.out.println("Element not present");
    }
    end = System.currentTimeMillis();

    System.out.println("Searching with custom search for element that is present took: "+ (end - start));


    start = System.currentTimeMillis();
    list.contains("el23000");
    end = System.currentTimeMillis();

    System.out.println("Checking if list contains element that isn't present took: "+ (end - start));

    start = System.currentTimeMillis();
     index = Collections.binarySearch(list,"el23000");
     if (index>=0) {
      System.out.println("Found element at index: " +index + " element:" + list.get(index));  
    }
    else {
        System.out.println("Element not present");
    }
    end = System.currentTimeMillis();

    System.out.println("Searching with binary search for element that isn't present took: "+ (end - start));

    start = System.currentTimeMillis();
     index = searchList(list,"el23000");
     if (index>=0) {
      System.out.println("Found element at index: " +index + " element:" + list.get(index));  
    }
    else {
        System.out.println("Element not present");
    }
    end = System.currentTimeMillis();

    System.out.println("Searching with custom search for element that isn't present took: "+ (end - start));


    start = System.currentTimeMillis();
    HashSet <String> set = new HashSet <String> ();
    for (int i=0;i<1000000;i++) {
       list.add("element"+i);
     }
      end = System.currentTimeMillis();
    System.out.println("Adding elements to hash set took: "+ (end - start));

    start = System.currentTimeMillis();
    list.contains("element23000");
    end = System.currentTimeMillis();

    System.out.println("Checking if set contains element that is present took: "+ (end - start));

    start = System.currentTimeMillis();
    list.contains("el23000");
    end = System.currentTimeMillis();

    System.out.println("Checking if set contains element that isn't present took: "+ (end - start));

}

private static int searchList (List <String> list, String el) {
  for (int i=0; i< list.size();i++ ) {
    if (list.get(i).equals(el)) {
      return i;    
       }
       
  }
  return -1;
} 
}