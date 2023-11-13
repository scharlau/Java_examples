import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.util.Scanner;

class Dictionary {
    public static void main(String[] args) {
      try {
            // Creates a FileInputStream
            FileInputStream file = new FileInputStream("test-dictionary.txt");
            FileOutputStream outfile = new FileOutputStream("my-dictionary.txt");

            // Creates a BufferedInputStream
            BufferedInputStream input = new BufferedInputStream(file);
            Scanner scanner = new Scanner(input);
            BufferedOutputStream output = new BufferedOutputStream(outfile);

            // Reads first byte from file
            while (scanner.hasNext()){
               String tempString = scanner.nextLine();
               // could clean up output by adding spaces, or line endings here
               System.out.println(tempString);

                // Reads next byte from the file
                byte b[]=tempString.getBytes();
              output.write(b);
            }
            input.close();
            output.close();

      }
      catch (Exception e) {
            e.getStackTrace();
      }
    }
}
