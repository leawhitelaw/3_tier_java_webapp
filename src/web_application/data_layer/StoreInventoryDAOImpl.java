package web_application.data_layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StoreInventoryDAOImpl implements StoreInventoryDAO {
	
	static Connection conn;
	static PreparedStatement ps;

	@Override
	public int updateQuantity(Integer storeID, Integer productID, Integer quantity) {
		int status =0;
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("update storeinventory set quantity = ? where storeid = ? and productid = ?");
			ps.setInt(1, quantity);
			ps.setInt(2, storeID);
			ps.setInt(3, productID);
			status = ps.executeUpdate();
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return status;
	}

	//SELECT Product.ProductID, Product.ProductName, StoreInventory.Quantity, StoreInventory.StoreID FROM Product LEFT JOIN StoreInventory on StoreInventory.ProductID = Product.ProductID WHERE StoreID = ?
	@Override
	public StoreInventory getProductStock(Integer storeID, Integer productID) {
		StoreInventory si = new StoreInventory();
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("SELECT Product.ProductID, Product.ProductName, StoreInventory.Quantity, StoreInventory.StoreID FROM Product LEFT JOIN StoreInventory on StoreInventory.ProductID = Product.ProductID WHERE StoreID = ? AND Product.ProductID = ?");
			ps.setInt(1, storeID);
			ps.setInt(2, productID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				si.setProductID(rs.getInt(1));
				si.setProductName(rs.getString(2));
				si.setQuantity(rs.getInt(3));
				si.setStoreID(rs.getInt(4));
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return si;
	}
	
	public static List<StoreInventory> getStock(Integer storeID) {
		List<StoreInventory> stock = new ArrayList<StoreInventory>();
		try {
			conn = DatabaseConnector.getStoresCon();
			ps = conn.prepareStatement("SELECT Product.ProductID, Product.ProductName, StoreInventory.Quantity, StoreInventory.StoreID FROM Product LEFT JOIN StoreInventory on StoreInventory.ProductID = Product.ProductID WHERE StoreID = ?");
			ps.setInt(1, storeID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StoreInventory item = new StoreInventory();
				item.setProductID(rs.getInt(1));
				item.setProductName(rs.getString(2));
				item.setQuantity(rs.getInt(3));
				item.setStoreID(rs.getInt(4));
				stock.add(item);
				
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return stock;
		}

}
