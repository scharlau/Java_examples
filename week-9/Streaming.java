// writing data to file
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Streaming{
  public static void main(String[] args) throws IOException {
    //open mytext.txt, output data to the file and then close
   // Formatter output;
    Scanner input;
    FileWriter fileOut;

    try (Formatter output = new Formatter("mytext.txt")){
      input = new Scanner(new BufferedReader(new FileReader("test-dictionary.txt")));
      fileOut = new BufferedWriter(new FileOutputStream("my-dictionary.txt"));
      System.out.println("opened dictionary");
     // String tempString = "";

      // start parsing the dictionary
      while(input.hasNext()){
        try {
          String tempString = input.next();
          System.out.println(tempString);
          fileOut.write(tempString);
          //    %[argument_index$][flags][width]conversion 
          // https://docs.oracle.com/javase/tutorial/essential/io/formatting.html 
         // output.format(": %0-30f", tempString);
         // output.format("%f, %-$+020.10", tempString);
        }
        catch(IOException | NoSuchElementException e){
            System.err.println("invalid input");
            input.nextLine();
       }
        finally {
          if (input != null) {
              input.close();
          }
        }
      }
    }
    catch(SecurityException | FileNotFoundException | FormatterClosedException e) {
        e.printStackTrace();
    } 
  }
}