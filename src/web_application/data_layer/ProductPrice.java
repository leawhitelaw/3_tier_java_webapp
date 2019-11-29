package web_application.data_layer;

public class ProductPrice {
	private Integer productID;
	private String productName;
	private Integer rrp;
	private Integer price;
	private Integer storeID;
	private String deal;
	
	public String getDeal() {
		return deal;
	}
	public void setDeal(String deal) {
		this.deal = deal;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStoreID() {
		return storeID;
	}
	public void setStoreID(Integer storeID) {
		this.storeID = storeID;
	}
	
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getRrp() {
		return rrp;
	}
	public void setRrp(Integer rrp) {
		this.rrp = rrp;
	}

}