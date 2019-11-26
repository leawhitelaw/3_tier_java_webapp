package web_application.data_layer;

public interface StoreDAO {
	
	public int insertStore(Store s);
	
	public Store getStore(Integer storeID);


}
