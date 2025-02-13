package project_property_search_app.repository;

import java.util.List;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Inquiry;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Visit;

public interface BuyerRepository {
    List<Buyer> getAllBuyers();
    Buyer addNewBuyer(Buyer buyer);
    void updateBuyer(int buyer_id, String email, String password);
    Buyer getBuyerById(int buyer_id);
    void save(Buyer buyer);
    Buyer findByEmail(String email);
    void updateBuyerProfile(int buyerId, String email, String password);
    Buyer getBuyerProfile(int buyerId);
    
    List<Property> searchProperties(String location);
    List<Property> filterProperties(double minPrice, double maxPrice, double minSize, double maxSize, String amenities);
    Integer getBuyerIdByUsername(String username);
    Integer getPropertyIdByTitle(String title);
    List<Property> getFavoritePropertiesByBuyerId(int buyerId);
    
    boolean addFavorite(int buyerId, int propertyId); // Added method for adding favorites
    boolean addInquiry(int buyerId, int propertyId, String message);
    List<Inquiry> getInquiriesByBuyerId(int buyerId);
    List<Inquiry> getAllInquiriesBySellerId(int seller_id);
    
    Inquiry getInquiryById(int inquiryId);
    void updateInquiry(Inquiry inquiry);
    boolean respondToInquiry(int inquiryId, String response);
    String getBuyerEmailById(int buyerId);
    
    boolean scheduleVisit(Visit visit);
    boolean updateVisitStatus(int visitId, String status);
    List<Visit> getPendingVisitsBySellerId(int seller_id);
    String getBuyerUsernameById(int buyerId);
    List<Visit> getAllVisitsBySellerId(int seller_id);
    List<Visit> getVisitsByBuyerId(int buyerId);
    List<Inquiry> getInquiriesBySellerIdAndStatus(int seller_id, String status);

}