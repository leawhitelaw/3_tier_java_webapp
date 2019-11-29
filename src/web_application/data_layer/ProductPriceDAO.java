package web_application.data_layer;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

public interface ProductPriceDAO {
	
	public void updateProductPrice(ProductPrice p, Integer price, String deal);
	
	public ProductPrice getProductPrice(Integer productID, Integer storeID);
	
	
	List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
	
	public static List<ProductPrice> getProducts(Integer storeID) {
		return productPrices;
	}
	
	//List<String> 

}
