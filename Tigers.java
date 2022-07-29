import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tigers {

    public static void main(String args []){
        // filter example
        String[] input = {"tiger", "cat", "TIGER", "Tiger", "leopard"}; 
        List<String> cats = Arrays.asList(input);
        String search = "tiger";
        String tigers = cats.stream()
                                    .filter(s -> s.equalsIgnoreCase(search))
                                    .collect(Collectors.joining(", ")); 
        System.out.println(tigers);

        // map example
        List<Integer> namesLength = cats.stream() 
                                                .map(String::length)
                                                .collect(Collectors.toList()); 
        System.out.println(namesLength);

        // for each example
        cats.stream().forEach(System.out::println);

        // reduce example
        double sumPrimes = ((double)Stream.of(2, 3, 5, 7, 11, 13, 17, 19, 23)
                .reduce(0, (x, y) -> {return x + y;}));
        System.out.println("Sum of some primes: " + sumPrimes);

    }
}
