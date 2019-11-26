package web_application.data_layer;

public class Product {
	
	private Integer productID;
	private String productName;
	private Integer rrp;
	
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
