package web_application.data_layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class LoyaltyDealDAOImpl implements LoyaltyDealDAO {
	static Connection conn;
	static PreparedStatement ps;

	@Override
	public int insertDeal(Integer storeID, Integer productID, Integer points, String dealName, Integer dealID) {
		int status =0;
		try {
			conn = DatabaseConnector.getPurchasesCon();
			ps = conn.prepareStatement("INSERT INTO LoyaltyDeals VALUES( ? , ? , ? , ?, ?)");
			ps.setInt(1, storeID);
			ps.setInt(2, productID);
			ps.setInt(3, points);
			ps.setString(4, dealName);
			ps.setInt(5, dealID);
			status = ps.executeUpdate();
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return status;
	}

	@Override
	public LoyaltyDeal getDeal(Integer productID, Integer storeID, Integer dealID) {
		LoyaltyDeal deal = new LoyaltyDeal();
		try {
			conn = DatabaseConnector.getPurchasesCon();
			ps = conn.prepareStatement("SELECT * FROM LoyaltyDeals WHERE ProductID = ? AND StoreID = ? AND DealID = ?");
			ps.setInt(1, productID);
			ps.setInt(2, storeID);
			ps.setInt(3, dealID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				deal.setStoreID(rs.getInt(1));
				deal.setProductID(rs.getInt(2));
				deal.setReqPoints(rs.getInt(3));
				deal.setDealName(rs.getString(4));
				deal.setDealID(rs.getInt(5));
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return deal;
	}

	@Override
	public void updateDeal(Integer productID, Integer storeID, Integer points, Integer dealID, String newDealName) {
		try {
			conn = DatabaseConnector.getPurchasesCon();
			ps = conn.prepareStatement("UPDATE LoyaltyDeals SET points = ?, dealName = ? WHERE storeid = ? AND productid = ? AND DealID = ?");
			ps.setInt(1, points);
			ps.setString(2, newDealName);
			ps.setInt(3, storeID);
			ps.setInt(4, productID);
			ps.setInt(5, dealID);
			ps.executeUpdate();
			
		}catch(Exception er) {
			er.printStackTrace();
		}

	}

	@Override
	public int deleteDeal(Integer productID, Integer storeID, Integer dealID) {
		int status =0;
		try {
			conn = DatabaseConnector.getPurchasesCon();
			ps = conn.prepareStatement("DELETE FROM LoyaltyDeals WHERE StoreID = ? AND ProductID = ? AND DealID = ?");
			ps.setInt(1, storeID);
			ps.setInt(2, productID);
			ps.setInt(3, dealID);
			status = ps.executeUpdate();
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return status;

	}
	
	public static List<LoyaltyDeal> getProducts(Integer storeID) {
		List<LoyaltyDeal> deals = new ArrayList<LoyaltyDeal>();
		try {
			conn = DatabaseConnector.getPurchasesCon();
			ps = conn.prepareStatement("SELECT * FROM LoyaltyDeals WHERE StoreID = ?");
			ps.setInt(1, storeID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LoyaltyDeal deal = new LoyaltyDeal();
				deal.setStoreID(rs.getInt(1));
				deal.setProductID(rs.getInt(2));
				deal.setReqPoints(rs.getInt(3));
				deal.setDealName(rs.getString(4));
				deal.setDealID(rs.getInt(5));
				deals.add(deal);
				
			}
			
		}catch(Exception er) {
			er.printStackTrace();
		}
		return deals;
		}
	
	public int getMaxDealID(List<LoyaltyDeal> deals) {
		List<Integer> dealIds = new ArrayList<Integer>();
		for(LoyaltyDeal l : deals){
			dealIds.add(l.getDealID());
		}
		return Collections.max(dealIds);
	}

}
