// writing data to file
import java.io.FileNotFoundException;
import java.io.BufferedInputStream;
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

    try {
      FileInputStream file = new FileInputStream("test-dictionary.txt");
      BufferedInputStream input = new BufferedInputStream(file);
      Scanner scanner = new Scanner(input);
      FileOutputStream filestream = new FileOutputStream( new File("my-dictionary.txt"));
      OutputStreamWriter writer = new OutputStreamWriter(filestream);
      System.out.println("opened dictionary");
      String tempString = "";

      // start parsing the dictionary
      while(scanner.hasNext()){
        try {
          tempString = scanner.next();
          // manipulate text here to make output more readable
          System.out.println(tempString);
          writer.write(tempString);
        }
        catch(IOException | NoSuchElementException e){
            System.err.println("invalid input");
            scanner.nextLine();
       }
        finally {
          if (scanner == null) {
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