package web_application.data_layer;

import java.util.ArrayList;
import java.util.List;

public class ProductPrice {
	
	private int productID;
	private int storeID;
	private int price;
	private static List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<ProductPrice> retrieveProductPrices(){
		return productPrices;
	}

}
