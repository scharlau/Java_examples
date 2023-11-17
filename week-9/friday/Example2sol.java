import java.util.*;

public class Example2sol {





public static double sum (Integer first, MyObject second) {

  double total = first + second.getValue();

  System.out.println("First method called");
return total;
}

public static double sum (Integer first, MyNamedObject second) {

  double total = first + second.getValue();

  System.out.println("Second method called");
return total;
}

public static double sum (Double first, MyObject second) {

  double total = first + second.getValue();

  System.out.println("Third method called");
return total;
}

public static double sum (Double first, MyNamedObject second) {

  double total = first + second.getValue();

  System.out.println("Fourth method called");
return total;
}


public static <E1 extends Number,E2 extends MyObject> double sum (E1 first, E2 second) {

  double total = first.doubleValue() + second.getValue() ;
  
  System.out.println("Generic method called");

return total;
}



public static void main(String[] args) {
   MyObject obj1 = new MyObject (1);

    double res1 = sum(1, new MyObject (1));
    double  res2 = sum(2,new MyNamedObject (1,"object1"));
    double  res3 = sum(2.05,new MyObject (1));
    double  res4 = sum(2.0,new MyNamedObject (1,"object2"));
    
    
    System.out.println(res1);
    System.out.println(res2);
    System.out.println(res3);
    System.out.println(res4);
  }
}
