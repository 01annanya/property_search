package project_property_search_app.service;

import java.util.List;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Inquiry;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Visit;

public interface BuyerService {
    List<Buyer> getAllBuyers();
    Buyer addNewBuyer(Buyer buyer);
    Buyer updateBuyer(int buyer_id, String email, String password);
    Buyer getBuyerById(int buyer_id);
    
    void save(Buyer buyer);
    Buyer findByEmail(String email);
    Buyer updateBuyerProfile(int buyerId, String email, String password);
    Buyer getBuyerProfile(int buyerId);
    Buyer authenticate(String email, String password);
    boolean isValidPassword(String password);
    
    List<Property> searchProperties(String location);
    List<Property> filterProperties(String location, double minPrice, double maxPrice, String amenities);
    boolean addFavorite(String username, int propertyId); // Added method for adding favorites
    List<Property> getFavoritePropertiesByBuyerId(int buyerId);
    
    boolean addInquiry(String buyerUsername, String propertyTitle, String message);
    List<Inquiry> getInquiriesByBuyerId(int buyerId);
    List<Inquiry> getAllInquiriesBySellerId(int seller_id);
    Inquiry getInquiryById(int inquiryId);
    void updateInquiry(Inquiry inquiry);
    String getBuyerEmailById(int buyerId);
    boolean respondToInquiry(int inquiryId, String response);
    List<Inquiry> getInquiriesBySellerIdAndStatus(int sellerId, String status);
    
    boolean scheduleVisit(String buyerUsername, String propertyTitle, String visitDate, String status);
    List<Visit> getVisitsByBuyerId(int buyerId);
    List<Property> getAllProperties();
    boolean updateVisitStatus(int visitId, String status);
    List<Visit> getPendingVisitsBySellerId(int seller_id);
    String getPropertyTitleById(int propertyId);
    String getBuyerUsernameById(int buyerId);
    List<Visit> getAllVisitsBySellerId(int seller_id);
}