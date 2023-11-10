import java.util.*;

public class SecretList<T> extends ArrayList <T> {

public SecretList (){
super();
}

@Override
public boolean contains (Object o) {

Integer el = (Integer) o; 

boolean result = false; 

for (int i =0 ; i < size();i++) {
     SecretElement item = (SecretElement) get(i); 
     
     if (item.getValue() == el.intValue()&&!item.isSecret()) {
          return true;
     }
}

return result; 
}


}