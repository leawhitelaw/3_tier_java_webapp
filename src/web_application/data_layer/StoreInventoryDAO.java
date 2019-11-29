package web_application.data_layer;

import java.util.ArrayList;
import java.util.List;

public interface StoreInventoryDAO {
	
	public int updateQuantity(Integer storeID, Integer productID, Integer Quantity);
	
	public StoreInventory getProductStock(Integer storeID, Integer productID);
	
	List<StoreInventory> stock = new ArrayList<StoreInventory>();
	
	public static List<StoreInventory> getStock(Integer storeID) {
		return stock;
	}

}
