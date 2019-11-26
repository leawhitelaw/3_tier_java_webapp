package web_application.data_layer;
import java.sql.*;

public class DatabaseConnector {
		
		static Connection connUsers =null;
		static Connection connStores =null;
		static Connection connPurchases = null;
		
		public static Connection getUsersCon() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connUsers = DriverManager
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
			return connUsers;

		}
		
		public static Connection getStoresCon() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connStores = DriverManager
				          .getConnection("jdbc:mysql://localhost:8889/stores?user=Java&password=Java");
				
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
			return connStores;

		}
		
		public static Connection getPurchasesCon() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connPurchases = DriverManager
				          .getConnection("jdbc:mysql://localhost:8889/purchasehistory?user=Java&password=Java");
				
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
			return connPurchases;

		}
		
}
