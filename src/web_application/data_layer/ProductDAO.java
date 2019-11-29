package web_application.data_layer;

import java.util.ArrayList;
import java.util.List;

public interface ProductDAO {
	List<Product> products = new ArrayList<Product>();
	
	public int insertProduct(Product p);
	
	public Product getProduct(Integer productID);
	
	public void updateProduct(Integer productID);
	
	public static List<Product> getProducts() {
		return products;
	}

}
