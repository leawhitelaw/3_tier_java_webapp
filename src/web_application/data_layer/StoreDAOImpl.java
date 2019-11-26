package web_application.data_layer;
import java.sql.*;

public class StoreDAOImpl implements StoreDAO {
	
	static Connection conn;
	static PreparedStatement ps;

	@Override
	public int insertStore(Store s) {
		int status =0;
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("Insert into store value(?,?)");
			ps.setInt(1, s.getStoreID());
			ps.setString(2, s.getRegion());
			ps.setString(3, s.getLocation());
			status = ps.executeUpdate();
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return status;
	}

	@Override
	public Store getStore(Integer storeID) {
		Store s = new Store();
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("select * from store where storeid=?");
			ps.setInt(1, storeID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s.setStoreID(rs.getInt(1));
				s.setRegion(rs.getString(2));
				s.setLocation(rs.getString(3));
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return s;
	}

}
