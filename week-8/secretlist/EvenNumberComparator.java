import java.util.*;

public class EvenNumberComparator implements Comparator <SecretElement> {

@Override 
public int compare (SecretElement it1, SecretElement it2) {

if (it1.isSecret() ) {
    return -1;
}

if (!it1.isSecret()) {
    
    if (it2.isSecret()) {
        return 1;
    }
    
    if (it1.getValue() % 2 == 0 && it2.getValue() % 2 !=0 ) {
       return -1;
      }

    
    
}


return it1.getValue() - it2.getValue();

}

}

