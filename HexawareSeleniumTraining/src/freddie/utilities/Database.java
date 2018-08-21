package freddie.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	
	// This method will connect to a database (MS SQL Server) and return the data
	public static String[][] get(String query) {
		// Declare initial variables
		int numRows;
		int numCols = 4;
		String dataTable[][] = null;
		
		// Define the connection String
		String server = "jdbc:sqlserver://sql2k801.discountasp.net";
		String databaseName = "";
		String username = "";
		String password = "";
		String connectionString = server + ";databasename=" + databaseName + ";username=" + username + ";password=" + password;
		
		// Define the database driver
		String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		// Perform Database Operations
		try {
			// Connect to Database
			Connection oConnection = DriverManager.getConnection(connectionString);
			
			// Prepare the query
			Statement oStatement = oConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet oResult = oStatement.executeQuery(query);
			
			// Define the size of our double array
			oResult.last();
			numRows = oResult.getRow();
			dataTable = new String[numRows][numCols];
			
			// Read the data
			oResult.beforeFirst();
			int row = 0;
			while (oResult.next()) {
				dataTable[row][0] = oResult.getString(1);
				dataTable[row][1] = oResult.getString(2);
				dataTable[row][2] = oResult.getString(3);
				dataTable[row][3] = oResult.getString(4);
				row++;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataTable;
	}

}
