import java.util.*;

public class SecretListExample {


public static void main(String[] args) {
       
     List <SecretElement> secretList = new SecretList <SecretElement> (); 

     secretList.add(new SecretElement (3,false));
     secretList.add(new SecretElement (4,true));
     secretList.add(new SecretElement (5,true));
      
       secretList.add(new SecretElement (8,false));
       secretList.add(new SecretElement (2,false));

     Collections.sort(secretList, new EvenNumberComparator());

     System.out.println(secretList.contains(4));
     System.out.println(secretList.contains(3));


     for (SecretElement item: secretList) {
         System.out.println(item.getValue());
     }

}

}