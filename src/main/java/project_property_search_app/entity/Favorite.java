package project_property_search_app.entity;

public class Favorite {
	private int favorite_id;
	private int buyerId;
    private int propertyId;
    
    public Favorite() {}

	public Favorite(int favorite_id, int buyerId, int propertyId) {
		super();
		this.favorite_id = favorite_id;
		this.buyerId = buyerId;
		this.propertyId = propertyId;
	}

	public int getFavorite_id() {
		return favorite_id;
	}

	public void setFavorite_id(int favorite_id) {
		this.favorite_id = favorite_id;
	}

	public int getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	@Override
	public String toString() {
		return "Favorites [favorite_id=" + favorite_id + ", buyerId=" + buyerId + ", propertyId=" + propertyId + "]";
	}
    
    

}
