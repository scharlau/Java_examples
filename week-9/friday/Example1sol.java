import java.util.*;

public class Example1sol {


public static double sumArray ( Number [] array) {

double total = 0;

for (int i = 0; i<array.length; i++ ) {
total  +=array[i].doubleValue();
}
return total;
}

public static double sumNumberList (List <Number> list) {

double total = 0;

for (Number element:list) {
total  +=element.doubleValue();
}

return total;
}
// changes here to extend
public static <E extends Number> double sum (List <E> list) {

double total = 0;

for (Number element:list) {
total  +=element.doubleValue();
}

return total;
}


public static  void  addAnyNumber (List list, Number numb) {
     list.add(numb);
  } 

public static void main(String[] args) {
    List <Integer> integers = new ArrayList<Integer> (); 
    integers.add(new Integer(1));
    integers.add(new Integer(1));
    integers.add(new Integer(1));
    //integers.add(new Double(1));

    System.out.println("First sum: "+sum (integers));
    
    addAnyNumber(integers,2);

    System.out.println("Second sum: "+ sum(integers));
    System.out.println("Last integer in the list: "+ (Integer) integers.get(integers.size()-1));
    
    
    List <Double> doubles = new ArrayList<Double> (); 
    doubles.add(new Double(2.0));
    doubles.add(new Double(2.0));
    doubles.add(new Double(2.0));

    addAnyNumber(doubles,new Double(2.0));
    // change here to use sumArray
    System.out.println("Third sum: "+sum(doubles)); 


    Double [] doubleArray = new Double [] {new Double(2.0),new Double(2.0),new Double(2.0)}; 

    System.out.println("Array sum: "+ sumArray(doubleArray));


  }
}
