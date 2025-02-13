package project_property_search_app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import project_property_search_app.entity.Property;


@Repository
public interface PropertyRepository {
    List<Property> getAllProperties();
    Property addNewProperty(Property property);
    void updateProperty(int property_id, Double price);
    List<Property> getPropertiesBySellerId(int seller_id);

	Property getPropertyByPropertyId(int property_id);
	List<Property> searchProperties(String location);
	List<Property> filterProperties(String location, double minPrice, double maxPrice, String amenities);
	Integer getPropertyIdByTitle(String title);
	
	String getPropertyTitleById(int propertyId);
	
	
	
	

}