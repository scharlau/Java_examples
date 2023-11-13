// writing data to file
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io. FileWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
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
    BufferedWriter fileOut;
    

    try {
      FileInputStream file = new FileInputStream("test-dictionary.txt");
      BufferedInputStream input = new BufferedInputStream(file);
      Scanner scanner = new Scanner(input);
      FileOutputStream filestream = new FileOutputStream( new File("my-dictionary.txt"));
      OutputStreamWriter writer = new OutputStreamWriter(filestream);
      fileOut = new BufferedWriter(writer);
      System.out.println("opened dictionary");
      String tempString = "";

      // start parsing the dictionary
      while(scanner.hasNext()){
        try {
          tempString = scanner.next();
          System.out.println(tempString);
          fileOut.write(tempString);
          //    %[argument_index$][flags][width]conversion 
          // https://docs.oracle.com/javase/tutorial/essential/io/formatting.html 
         // output.format(": %0-30f", tempString);
         // output.format("%f, %-$+020.10", tempString);
        }
        catch(IOException | NoSuchElementException e){
            System.err.println("invalid input");
            //input.nextLine();
       }
        finally {
          if (scanner != null) {
              scanner.close();
          }
        }
      }
    }
    catch(SecurityException | FileNotFoundException | FormatterClosedException e) {
        e.printStackTrace();
    } 
  }
}