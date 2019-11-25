package web_application;
import java.sql.*;

public class DataBaseAccess {
	public static void main(String[] args) {
		// Load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager
			          .getConnection("jdbc:mysql://localhost:8889/users?user=Java&password=Java");
			// Next we create a statement to access the database
			Statement statement = conn.createStatement();
			// Now create a simple query to get all records from the database
			String query = "SELECT * FROM EmployeeRecord";
			
			// And then get the results from executing the query
			ResultSet results = statement.executeQuery(query);
			// Loop until no records are left
			while (results.next())
			{
				// Retrieve each field of the currently selected record
				String matric = results.getString("EmployeeName");
				String name = results.getString("EmployeeID");
				String programme = results.getString("AccessLevel");
				// Display the student details
				System.out.println(matric);
				System.out.println(name);
				System.out.println(programme);
				System.out.println();
			}
			// Release resources held by statement
			statement.close();
			// Release resources held by DB connection
			conn.close();
		} catch (ClassNotFoundException cfe) {
			System.err.println("Could not load driver");
			System.err.println(cfe.getMessage());
			System.exit(-1);
			// TODO Auto-generated catch block
		} catch(SQLException sqe) {
			System.out.println("Error performing SQL Query");
			System.out.println(sqe.getMessage());
			System.exit(-1);
		}
	}
}
