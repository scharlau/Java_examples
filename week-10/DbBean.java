/* Class that manages connections to the database.*/ 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbBean {
	//String dbURL = "jdbc:mysql://mysql.abdn.ac.uk/csc228_bield?user=csc228_bield&password=sidebield08"; Change dbURL as required 	to connect to the required database.

	String dbURL = "jdbc:mysql://localhost/mmr-base?user=root&password=mysecret";
	
	String dbDriver = "com.mysql.jdbc.Driver";			// Driver used to make the connection to the datbase

	private Connection dbCon;
	
	public DbBean() {
		super();
	}

	public boolean connect()
		throws
			ClassNotFoundException,
			SQLException,
			InstantiationException,
			IllegalAccessException {
		// the jdk 1.5 way
				Class.forName(this.getDbDriver()).newInstance();
				dbCon = DriverManager.getConnection(this.getDbURL());
		
	//	 jdk 1.6 method
	//	dbCon = DriverManager.getConnection(dbURL);
				return true;
	}

	public void close() throws SQLException {
		
		dbCon.close();
	}

	public void commit() throws SQLException {
		dbCon.commit();
	}

	public void setAutoCommit(boolean autocommit) throws SQLException {
		dbCon.setAutoCommit(autocommit);
	}

	public void rollback() throws SQLException {
		dbCon.rollback();
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		PreparedStatement s = dbCon.prepareStatement(sql);
		return s;
	}

	public Statement createStatement() throws SQLException {
		Statement s = dbCon.createStatement();
		return s;
	}

	public int executeUpdate(String s) throws SQLException {
		Statement st = dbCon.createStatement();
		int count = st.executeUpdate(s);
		return count;
	}

	public ResultSet execSQL(StringBuffer sqlBuf) throws SQLException {
		Statement s = dbCon.createStatement();
		String sql = sqlBuf.toString();
		ResultSet rs = s.executeQuery(sql);
		return (rs == null) ? null : rs;
	}

	public String getDbDriver() {
		return this.dbDriver;
	}

	public void setDbDriver(String newValue) {
		this.dbDriver = newValue;
	}

	public String getDbURL() {
		return this.dbURL;
	}

	public void setDbURL(String newValue) {
		this.dbURL = newValue;
	}

	public ResultSet doQuery(StringBuffer qry) {
		Connection con = null;
		Statement stmt = null;

		// set variables to take in resultset values
		String returnedUserName = null;
		String returnedPassword = null;
		ResultSet rs = null;

		try {
			// use the DbBean to make the connection to the database
			// now all db connections can be routed through the one place
			//DbBean db = new DbBean();
			connect();
			rs = execSQL(qry);

		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: " + e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: " + e.getMessage());
		}
		return rs;
	}
	
	public int getMaxValue(String table, String column) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
		int maxValue = 0;
		ResultSet rs = null;
		StringBuffer qry = new StringBuffer(1024);
		qry.append("SELECT MAX([");
		qry.append(column);
		qry.append("]) as maxValue FROM ");
		qry.append(table);
		
		connect();
		rs = doQuery(qry);
		while(rs.next()){
			maxValue = rs.getInt("maxValue");
		}
		return maxValue;
	}

}