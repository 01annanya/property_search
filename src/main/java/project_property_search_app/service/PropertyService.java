package project_property_search_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import project_property_search_app.entity.Property;


@Service
public interface PropertyService {
    List<Property> getAllProperties();
    Property addNewProperty(Property property);
    Property updateProperty(int property_id, Double price);
    List<Property> getPropertiesBySellerId(int seller_id);


	Property getPropertyByPropertyId(int property_id);
	List<Property> searchProperties(String location);
	Integer getPropertyIdByTitle(String title);
	 boolean updatePropertyByIdAndPrice(int property_id, Double price) ;
	


}