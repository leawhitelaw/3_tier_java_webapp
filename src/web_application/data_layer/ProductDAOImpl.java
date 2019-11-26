package web_application.data_layer;
import java.sql.*;

public class ProductDAOImpl implements ProductDAO {
	
	static Connection conn;
	static PreparedStatement ps;

	@Override
	public int insertProduct(Product p) {
		int status =0;
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("Insert into store value(?,?)");
			ps.setInt(1, p.getProductID());
			ps.setString(2, p.getProductName());
			ps.setInt(3, p.getRrp());
			status = ps.executeUpdate();
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return status;
	}

	@Override
	public Product getProduct(Integer productID) {
		Product p = new Product();
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("select * from store where storeid=?");
			ps.setInt(1, productID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				p.setProductID(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setRrp(rs.getInt(3));
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return p;
	}

	@Override
	public void updateProduct(Integer productID) {
		// TODO Auto-generated method stub
		/*
		 * Here possibly pass in an old product and a new product?? IDK come back later lmao
		 * */

	}

}
