package web_application.data_layer;

public interface ProductDAO {
	
	public int insertProduct(Product p);
	
	public Product getProduct(Integer productID);
	
	public void updateProduct(Integer productID);

}
