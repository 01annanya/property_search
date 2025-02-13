package project_property_search_app.entity;

import org.springframework.stereotype.Component;

@Component
public class Property {
    private Integer propertyId;
    private String title;
    private String description;
    private double price;
    private String location;
    private String squareft;
    private String amenities;
    private String status;
    private int sellerId;

    public Property() {}

    public Property(Integer propertyId, String title, String description, double price, String location, String squareft, String amenities, String status, int sellerId) {
        this.propertyId = propertyId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.squareft = squareft;
        this.amenities = amenities;
        this.status = status;
        this.sellerId = sellerId;
    }

   
    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSquareft() {
        return squareft;
    }

    public void setSquareft(String squareft) {
        this.squareft = squareft;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
    
    @Override
   	public String toString() {
   		return "Property [propertyId=" + propertyId + ", title=" + title + ", description=" + description + ", price="
   				+ price + ", location=" + location + ", squareft=" + squareft + ", amenities=" + amenities + ", status="
   				+ status + ", sellerId=" + sellerId + "]";
   	}

    
}

