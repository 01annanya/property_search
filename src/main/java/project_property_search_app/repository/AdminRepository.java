package project_property_search_app.repository;

import java.util.List;

import project_property_search_app.entity.Admin;
import project_property_search_app.entity.Property;


public interface AdminRepository {
	List<Property> getAllPendingProperties();
    boolean approveProperty(int propertyId);
    boolean rejectProperty(int propertyId);
    void save(Admin admin);
	Admin findByEmail(String email) ;
	  Admin findById(int adminId);
	    void updateAdminProfile(int adminId, String email, String password);
	    Admin getAdminProfile(int adminId);
}
