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
	public void updateProductPrice(ProductPrice p, Integer price, String deal) {
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("update productprice set price = ?, deal = ? where storeid = ? and productid = ?");
			ps.setInt(1, price);
			ps.setString(2, deal);
			ps.setInt(3, p.getStoreID());
			ps.setInt(4, p.getProductID());
			ps.executeUpdate();
			
		}catch(Exception er) {
			er.printStackTrace();
		}
	}
	
	@Override
	public ProductPrice getProductPrice(Integer productID, Integer storeID) {
		ProductPrice pp = new ProductPrice();
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("SELECT Product.ProductID, Product.ProductName, Product.RRP, ProductPrice.Price, ProductPrice.StoreID,  ProductPrice.Deal FROM Product LEFT JOIN ProductPrice on ProductPrice.ProductID = Product.ProductID WHERE StoreID = ? AND Product.ProductID = ?");
			ps.setInt(2, productID);
			ps.setInt(1, storeID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pp.setProductID(rs.getInt(1));
				pp.setProductName(rs.getString(2));
				pp.setRrp(rs.getInt(3));
				pp.setPrice(rs.getInt(4));
				pp.setStoreID(rs.getInt(5));
				pp.setDeal(rs.getString(6));
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return pp;
	}
	
	public static List<ProductPrice> getProducts(Integer storeID) {
		List<ProductPrice> products = new ArrayList<ProductPrice>();
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("SELECT Product.ProductID, Product.ProductName, Product.RRP, ProductPrice.Price, ProductPrice.StoreID, ProductPrice.Deal FROM Product LEFT JOIN ProductPrice on ProductPrice.ProductID = Product.ProductID WHERE StoreID = ?");
			ps.setInt(1, storeID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductPrice p = new ProductPrice();
				p.setProductID(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setRrp(rs.getInt(3));
				p.setPrice(rs.getInt(4));
				p.setStoreID(rs.getInt(5));
				p.setDeal(rs.getString(6));
				products.add(p);
				
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return products;
		}

}
