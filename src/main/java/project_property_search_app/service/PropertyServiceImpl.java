package project_property_search_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_property_search_app.entity.Property;
import project_property_search_app.repository.PropertyRepository;



@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.getAllProperties();
    }

    @Override
    public Property addNewProperty(Property property) {
        return propertyRepository.addNewProperty(property);
    }

	
	
	@Override
    public Property updateProperty(int property_id, Double price) {
        propertyRepository.updateProperty(property_id, price);
        return propertyRepository.getPropertyByPropertyId(property_id);
    }

	@Override
    public boolean updatePropertyByIdAndPrice(int property_id, Double price) {
        Property property = propertyRepository.getPropertyByPropertyId(property_id);
        if (property != null) {
            property.setPrice(price);
            propertyRepository.updateProperty(property_id, price);
            return true;
        }
        return false;
    }

	@Override
	public Property getPropertyByPropertyId(int property_id) {
		Property property= propertyRepository.getPropertyByPropertyId(property_id);
		return property;
		
	}
	@Override
	public List<Property> getPropertiesBySellerId(int seller_id) {
        return propertyRepository.getPropertiesBySellerId(seller_id);
    }

	@Override
	public List<Property> searchProperties(String location) {
	 return propertyRepository.searchProperties(location);
	}

    @Override
    public Integer getPropertyIdByTitle(String title) {
        return propertyRepository.getPropertyIdByTitle(title);
    }
    
}