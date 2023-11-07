import java.util.Scanner;
public class TokenTest{
public static void main(String[] args ){
    Scanner scanner = new Scanner(System.in);
    System.out.println("enter a sentence and press enter");
    String sentence = scanner.nextLine();
    String[] tokens = sentence.split("\\s+");
    System.out.printf("number of elements; %d%n the tokens are:%n", tokens.length);
    for (String token:tokens){
        System.out.println(token);
    }
}

}
// password validation
// 8-15 characters length()
// 1 uppercase - copntains(U)
// 1 number - copntains (DIGIT)
// starts with alphabet charAt(0)