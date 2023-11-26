import java.util.Scanner;

public class Addition{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

      //  System.out.print("Enter your name: ");
      //  String name =  input.next();
      //  System.out.printf("Hello %s%n", name);
    

        System.out.print("Enter the first integer: ");
        int number1 = input.nextInt();
       
    
        System.out.print("Enter the second integer: ");
        int number2 = input.nextInt();

        int sum = number1 - number2;

        System.out.printf("Sum is %d%n", sum);

    }
}