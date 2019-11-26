package web_application.data_layer;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

public interface ProductPriceDAO {
	List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
	
	public int insertProductPrice(ProductPrice p, Integer price);
	
	public ProductPrice getProductPrice(Integer productID, Integer storeID);
	
	public static List<ProductPrice> getProductPrices() {
		return productPrices;
	}

}
