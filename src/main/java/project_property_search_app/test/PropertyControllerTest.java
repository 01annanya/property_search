package project_property_search_app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import project_property_search_app.controller.PropertyController;
import project_property_search_app.entity.Property;
import project_property_search_app.service.PropertyService;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PropertyControllerTest {

    private PropertyController propertyController;
    private PropertyService propertyService;
    private Model model;

    @BeforeEach
    public void setup() {
        propertyService = new PropertyService() {
            @Override
            public Property addNewProperty(Property propertyDetails) {
                return null; // Implement as needed
            }

//            public void updateProperty(int propertyId, double price) {
//                // Implement as needed
//            }

            @Override
            public Property getPropertyByPropertyId(int propertyId) {
                return null; // Implement as needed
            }

			@Override
			public List<Property> getAllProperties() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Property updateProperty(int property_id, Double price) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Property> getPropertiesBySellerId(int seller_id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Property> searchProperties(String location) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer getPropertyIdByTitle(String title) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean updatePropertyByIdAndPrice(int property_id, Double price) {
				// TODO Auto-generated method stub
				return false;
			}
        };

        model = new MockModel();
        propertyController = new PropertyController();
        propertyController.propertyService = propertyService;
    }

    @Test
    void testAddNewPropertyForm() {
        String viewName = propertyController.addNewPropertyForm();
        assertEquals("property-form", viewName);
    }

    @Test
    void testGetPropertyByPropertyIdNotFound() {
        int propertyId = 999;

        String viewName = propertyController.getPropertyByPropertyId(propertyId, model);
        assertEquals("error", viewName);
    }

    // Mock implementation for Model
    private static class MockModel implements Model {
        private final Map<String, Object> attributes = new HashMap<>();

        @Override
        public Model addAttribute(String attributeName, Object attributeValue) {
            attributes.put(attributeName, attributeValue);
            return this;
        }

        @Override
        public Model addAttribute(Object attributeValue) {
            // Implement as needed
            return this;
        }

        @Override
        public Model addAllAttributes(Collection<?> attributeValues) {
            // Implement as needed
            return this;
        }

        @Override
        public Model addAllAttributes(Map<String, ?> attributes) {
            this.attributes.putAll(attributes);
            return this;
        }

        @Override
        public Model mergeAttributes(Map<String, ?> attributes) {
            this.attributes.putAll(attributes);
            return this;
        }

        @Override
        public boolean containsAttribute(String attributeName) {
            return attributes.containsKey(attributeName);
        }

        @Override
        public Map<String, Object> asMap() {
            return attributes;
        }
    }
}