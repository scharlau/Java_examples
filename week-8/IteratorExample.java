import java.util.*;
// https://docs.oracle.com/javase/8/docs/api/java/util/Map.html

public class IteratorExample {


public static void main(String[] args) {

 Map <String,String> map = new HashMap <String,String>(); 

 map.put ("key1", "value1");
 map.put ("key2", "value2");

 Iterator <String> it = map.keySet().iterator(); 

 while (it.hasNext()) {
     String key = it.next();
     if (key.equals("key1")) {
         System.out.println(map.get(key));
         map.put("key1","value1-a");
         System.out.println(map.get(key));
     }
 }

}
}