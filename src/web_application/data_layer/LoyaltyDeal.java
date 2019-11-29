package web_application.data_layer;

public class LoyaltyDeal {
	
	private Integer StoreID;
	private Integer ProductID;
	private Integer ReqPoints;
	private String DealName;
	private Integer DealID;
	
	public Integer getStoreID() {
		return StoreID;
	}
	public void setStoreID(Integer storeID) {
		StoreID = storeID;
	}
	public Integer getProductID() {
		return ProductID;
	}
	public void setProductID(Integer producttID) {
		ProductID = producttID;
	}
	public Integer getReqPoints() {
		return ReqPoints;
	}
	public void setReqPoints(Integer reqPoints) {
		ReqPoints = reqPoints;
	}
	public String getDealName() {
		return DealName;
	}
	public void setDealName(String dealName) {
		DealName = dealName;
	}
	public Integer getDealID() {
		return DealID;
	}
	public void setDealID(Integer dealID) {
		DealID = dealID;
	}

}
