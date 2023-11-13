import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile{
    public static void main(String[] args){
        //open named file, output data to file, and then close 
        try(Formatter output = new Formatter("clients.txt")) {
            Scanner input = new Scanner(System.in);
            System.out.printf("%s%n%s%n? ",
            "Enter account number, first name, last name, and balance",
            "Enter end-of-file indicator to end input");

            while (input.hasNext()) { //loop unitl end of file indicator 
            // crtl-z windows or crtrl-d linux or mac
                try {
                    // output new record to file; assume valid input
                    output.format("%d %s %s %.2f%n", input.nextInt(),
                    input.next(), input.next(), input.nextDouble());
                }
                catch (NoSuchElementException elementException){
                    System.err.println("Invalid input. Please try again");
                    input.nextLine(); //discard input so user can try again
                }
                System.out.print("? ");
            }
        }
        catch (SecurityException | FileNotFoundException | FormatterClosedException e){
            e.printStackTrace();
        }
    }
}