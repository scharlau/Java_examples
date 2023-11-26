import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class DbDemo {

    String dbFile;
    //  String url = "jdbc:sqlite:/Users/csc228/Documents/Courses/CS2020-SP/CodeSamples/JavaDemos/"+ dbFile;  
    // use . to signify current directory
    String url = "jdbc:sqlite:."+ dbFile;

    public DbDemo (String fileName) {
        dbFile = this.dbFile;
    }

    private Connection connect(String url){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public void createDatabase(){
        try (Connection con = this.connect(url)){
            if (con!= null) {
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("Product Name: " + meta.getDatabaseProductName());
                System.out.println("Database created");
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createTable(){
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("CREATE TABLE IF NOT EXISTS bears (");
        sqlStatement.append("id integer PRIMARY KEY AUTOINCREMENT,");
        sqlStatement.append(" bearID integer NOT NULL,");
        sqlStatement.append(" capture_latitude string NOT NULL, ");
        sqlStatement.append(" capture_longitude string NOT NULL,");
        sqlStatement.append(" capture_dateTime string NOT NULL, ");
        sqlStatement.append(" sex string NOT NULL,");
        sqlStatement.append(" created_at DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL);");
        String sql = sqlStatement.toString();

        try (Connection con = this.connect(url);
            Statement stmt = con.createStatement()) {
                stmt.execute("DROP TABLE IF EXISTS bears");
                stmt.execute(sql);
                con.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBear(String bearID, String capture_latitude, String capture_longitude,
        String capture_dateTime, String sex){
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("INSERT INTO bears (");
        sqlStatement.append(" bearID, capture_latitude, capture_longitude,");
        sqlStatement.append(" capture_dateTime, sex) ");
        sqlStatement.append(" VALUES(?,?,?,?,?)");
        String sql = sqlStatement.toString();

        try (Connection con = this.connect(url);
          PreparedStatement pstmt = con.prepareStatement(sql)) {
              pstmt.setString(1, bearID);
              pstmt.setString(2, capture_latitude);
              pstmt.setString(3, capture_longitude);
              pstmt.setString(4, capture_dateTime);
              pstmt.setString(5, sex);
              pstmt.executeUpdate();
              System.out.println("bear added");
              con.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBear(int id, String bearID, String capture_latitude, String capture_longitude,
    String capture_dateTime, String sex) {
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE bears SET");
        sqlStatement.append(" bearID = ?, capture_latitude= ?, capture_longitude = ?,");
        sqlStatement.append(" capture_dateTime = ?, sex= ? ");
        sqlStatement.append(" WHERE id =  ?");
        String sql = sqlStatement.toString();

        try (Connection conn = this.connect(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding params
            pstmt.setString(1, bearID);
            pstmt.setString(2, capture_latitude);
            pstmt.setString(3, capture_longitude);
            pstmt.setString(4, capture_dateTime);
            pstmt.setString(5, sex);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            conn.close();
            System.out.println("bear " + bearID + " updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBear(int id) {
        String sql = "DELETE FROM bears WHERE id = ?";

        try (Connection conn = this.connect(url);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
            conn.close();
            System.out.println("bear id: " + id + " deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getBear(int id){
        String sql = "SELECT * FROM bears WHERE id = ?";
        try (Connection conn = this.connect(url);
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1, id);
            ResultSet rs    = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("RSMD columns: " + rsmd.getColumnCount());
        
       
       // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                    rs.getString("bearID") + "\t" +
                                    rs.getString("capture_latitude") + "\t" +
                                    rs.getString("capture_longitude") + "\t" +
                                    rs.getString("capture_dateTime") + "\t" +
                                    rs.getString("sex") + "\t" +
                                    rs.getString("created_at"));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getBears(){
        String sql = "SELECT * FROM bears";
        try (Connection conn = this.connect(url);
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){
       
       // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                    rs.getString("bearID") + "\t" +
                                    rs.getString("capture_latitude") + "\t" +
                                    rs.getString("capture_longitude") + "\t" +
                                    rs.getString("capture_dateTime") + "\t" +
                                    rs.getString("sex") + "\t" +
                                    rs.getString("created_at"));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {

        String dbFile = "bears.db";
     
        System.out.println("Database demo");
        DbDemo myDemo = new DbDemo(dbFile);
        myDemo.createDatabase();
        myDemo.createTable();
        myDemo.addBear("1234", "51.4", "2.45", "20121225 20.05", "f");
        myDemo.addBear("2346", "51.8", "2.46", "20121225 21.05", "m");
        myDemo.getBear(1);
        myDemo.updateBear(1, "4321", "55.4", "2.45", "20141225 20.05", "f");
        myDemo.getBears();
        myDemo.deleteBear(1);
        myDemo.getBears();
    }
}
