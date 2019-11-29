package web_application.data_layer;
import java.util.ArrayList;
import java.util.List;

public interface LoyaltyDealDAO {
	List<LoyaltyDeal> loyaltyDeals = new ArrayList<LoyaltyDeal>();
	
	public int insertDeal(Integer storeID, Integer productID, Integer points, String dealName, Integer dealID);
	
	public LoyaltyDeal getDeal(Integer productID, Integer storeID, Integer dealID);
	
	public void updateDeal(Integer productID, Integer storeID, Integer points, Integer dealID, String newDealName);
	
	public int deleteDeal(Integer productID, Integer storeID, Integer dealID);
	
	public static List<LoyaltyDeal> getProducts(Integer storeID) {
		return loyaltyDeals;
	}
	
	public int getMaxDealID(List<LoyaltyDeal> deals);

}
