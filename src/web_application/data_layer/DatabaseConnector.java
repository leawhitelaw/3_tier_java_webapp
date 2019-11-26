package web_application.data_layer;
import java.sql.*;

public class DatabaseConnector {
		
		static Connection conn=null;
		
		public static Connection getCon() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager
				          .getConnection("jdbc:mysql://localhost:8889/users?user=Java&password=Java");
				
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
			return conn;

		}
		
}
