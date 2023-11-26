import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ParseCSV {

    private static class Bear {
        private String BearID;
        private String Latitude;
        private String Longitude;
        private String DateTime;
        private  String Sex;

        public Bear(String BearID, String Latitude, String Longitude, 
        String DateTime, String Sex){
            this.BearID = BearID;
            this.Latitude = Latitude;
            this.Longitude = Longitude;
            this.DateTime = DateTime;
            this.Sex = Sex;
        }
        public String print() {
            StringBuilder bear = new StringBuilder();
            bear.append("Bear: ");
            bear.append(" BearID: ");
            bear.append(BearID);
            bear.append(" Latitude: ");
            bear.append(Latitude);
            bear.append(" Longitude: ");
            bear.append(Longitude);
            bear.append(" DateTime of capture: ");
            bear.append(DateTime);
            bear.append(" Sex: ");
            bear.append(Sex);
            return bear.toString();
        }
    }
// inspired by https://www.baeldung.com/java-csv-file-array 
    private List<String> getRecordFromLine(String line){
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)){
            rowScanner.useDelimiter(",");
            while(rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
            Bear bear = new Bear(values.get(0), values.get(6), values.get(7),
            values.get(8), values.get(9));
            System.out.println(bear.print());
        }
        return values;
    }

    public static void main(String[] args){
        ParseCSV myParser = new ParseCSV();
        List<String> values = new ArrayList<String>();
        try (Scanner input = new Scanner(Paths.get("polarbears.csv"))) {
            System.out.println("opening file");
            while (input.hasNextLine()){
               values.addAll(myParser.getRecordFromLine(input.nextLine()));
                values.clear();
            }
            System.out.println("closing file");
        }
        catch (IOException | NoSuchElementException | IllegalStateException e){
            e.printStackTrace();
        }
    }
}
