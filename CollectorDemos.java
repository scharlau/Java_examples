import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// examples based on ideass at 
// https://www.logicbig.com/how-to/code-snippets/jcode-java-8-streams-collectors-tomap.html 
public class CollectorDemos {
    public static String[] simpleFruit = {"apple", "banana", "orange", "mango"};
    public static String[] moreFruit = {"apple", "apricot", "banana", "orange", 
                                        "mango", "pear", "pineapple"};
    // basic sorting of collection to a map
    // doesn't handle duplicate keys
    public static void basicMap(){
        Stream<String> s = Stream.of(simpleFruit);
        Map<Character, String> m = s.collect(
                            Collectors.toMap(s1 -> s1.charAt(0),
                                                s1 -> s1));
        System.out.println(m);
    }

    // deal with duplicates by adding them to similar group
    public static void duplicateMap(){
        Stream<String> s = Stream.of(moreFruit);
        Map<Character, String> m = s.collect(
                            Collectors.toMap(s1 -> s1.charAt(0),
                                                s1 -> s1,
                                                (s1, s2) -> s1 + "|" + s2));
        System.out.println(m);
    }

    // pass items to LinkedHashMap as mapSupplier
    public static void useLinkedMap(){
        Stream<String> s = Stream.of(moreFruit);
        LinkedHashMap<Character, String> m = s.collect(
        Collectors.toMap(s1 -> s1.charAt(0),
                            s1 -> s1,
                            (s1, s2) -> s1 + "|" + s2,
                            LinkedHashMap::new));
        System.out.println(m);
    }

    public static void main (String[] args) {
        basicMap();
        duplicateMap();
        useLinkedMap();

    }
}
    
