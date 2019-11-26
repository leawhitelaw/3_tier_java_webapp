package web_application.data_layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductPriceDAOImpl implements ProductPriceDAO {
	
	static Connection conn;
	static PreparedStatement ps;

	@Override
	public int insertProductPrice(ProductPrice p, Integer price) {
		int status =0;
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("update productprice set price = ? where storeid = ? and productid = ?");
			ps.setInt(1, price);
			ps.setInt(2, p.getStoreID());
			ps.setInt(3, p.getProductID());
			status = ps.executeUpdate();
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return status;
	}
	
	@Override
	public ProductPrice getProductPrice(Integer productID, Integer storeID) {
		ProductPrice pp = new ProductPrice();
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("select * from productprice where productid=? and storeid=?");
			ps.setInt(1, productID);
			ps.setInt(2, storeID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pp.setProductID(rs.getInt(1));
				pp.setStoreID(rs.getInt(2));
				pp.setPrice(rs.getInt(3));
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return pp;
	}
	
	public static List<ProductPrice> getProductPrices(){
		List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("select * from productprice");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductPrice pp = new ProductPrice();
				pp.setProductID(rs.getInt(1));
				pp.setStoreID(rs.getInt(2));
				pp.setPrice(rs.getInt(3));
				productPrices.add(pp);
				
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return productPrices;
	}

}
