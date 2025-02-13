package project_property_search_app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Inquiry;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Visit;
import project_property_search_app.repository.BuyerRepository;
import project_property_search_app.repository.PropertyRepository;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.getAllBuyers();
    }

    @Override
    public Buyer addNewBuyer(Buyer buyer) {
        return buyerRepository.addNewBuyer(buyer);
    }

    @Override
    public Buyer updateBuyer(int buyer_id, String email, String password) {
        buyerRepository.updateBuyer(buyer_id, email, password);
        return buyerRepository.getBuyerById(buyer_id);
    }

    @Override
    public Buyer getBuyerById(int buyer_id) {
        return buyerRepository.getBuyerById(buyer_id);
    }

    @Override
    public void save(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    @Override
    public Buyer findByEmail(String email) {
        return buyerRepository.findByEmail(email);
    }

    @Override
    public Buyer updateBuyerProfile(int buyerId, String email, String password) {
        buyerRepository.updateBuyerProfile(buyerId, email, password);
        return buyerRepository.getBuyerProfile(buyerId);
    }

    @Override
    public Buyer getBuyerProfile(int buyerId) {
        return buyerRepository.getBuyerProfile(buyerId);
    }

    @Override
    public Buyer authenticate(String email, String password) {
        Buyer buyer = buyerRepository.findByEmail(email);
        if (buyer != null && buyer.getPassword().equals(password)) {
            return buyer;
        }
        return null;
    }

    @Override
    public boolean isValidPassword(String password) {
        // Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a special character
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(passwordPattern);
    }

    @Override
    public List<Property> searchProperties(String location) {
        return propertyRepository.searchProperties(location);
    }

    @Override
    public List<Property> filterProperties(String location, double minPrice, double maxPrice, String amenities) {
        return propertyRepository.filterProperties(location, minPrice, maxPrice, amenities);
    }

    @Override
    public boolean addFavorite(String buyerUsername, int propertyId) {
        Integer buyerId = buyerRepository.getBuyerIdByUsername(buyerUsername);
        if (buyerId == null) {
            return false;
        }
        return buyerRepository.addFavorite(buyerId, propertyId);
    }

    @Override
    public List<Property> getFavoritePropertiesByBuyerId(int buyerId) {
        return buyerRepository.getFavoritePropertiesByBuyerId(buyerId);
    }

    @Override
    public boolean addInquiry(String buyerUsername, String propertyTitle, String message) {
        Integer buyerId = buyerRepository.getBuyerIdByUsername(buyerUsername);
        Integer propertyId = propertyRepository.getPropertyIdByTitle(propertyTitle);
        if (buyerId == null || propertyId == null) {
            return false;
        }
        return buyerRepository.addInquiry(buyerId, propertyId, message);
    }

    @Override
    public List<Inquiry> getInquiriesByBuyerId(int buyerId) {
        return buyerRepository.getInquiriesByBuyerId(buyerId);
    }

    @Override
    public List<Inquiry> getAllInquiriesBySellerId(int seller_id) {
        return buyerRepository.getAllInquiriesBySellerId(seller_id);
    }

    @Override
    public boolean respondToInquiry(int inquiryId, String response) {
        return buyerRepository.respondToInquiry(inquiryId, response);
    }
    @Override
    public Inquiry getInquiryById(int inquiryId) {
        return buyerRepository.getInquiryById(inquiryId);
    }

    @Override
    public void updateInquiry(Inquiry inquiry) {
        buyerRepository.updateInquiry(inquiry);
    }

    @Override
    public String getBuyerEmailById(int buyerId) {
        return buyerRepository.getBuyerEmailById(buyerId);
    }

    @Override
    public boolean scheduleVisit(String buyerUsername, String propertyTitle, String visitDate, String status) {
        Integer buyerId = buyerRepository.getBuyerIdByUsername(buyerUsername);
        Integer propertyId = propertyRepository.getPropertyIdByTitle(propertyTitle);
        if (buyerId == null || propertyId == null) {
            return false;
        }
        Visit visit = new Visit();
        visit.setBuyerId(buyerId);
        visit.setPropertyId(propertyId);
        visit.setVisitDate(java.sql.Date.valueOf(visitDate));
        visit.setStatus(status);
        return buyerRepository.scheduleVisit(visit);
    }

    @Override
    public List<Property> getAllProperties() {
        return propertyRepository.getAllProperties();
    }

    @Override
    public List<Visit> getPendingVisitsBySellerId(int seller_id) {
        return buyerRepository.getPendingVisitsBySellerId(seller_id);
    }

    @Override
    public List<Visit> getVisitsByBuyerId(int buyerId) {
        return buyerRepository.getVisitsByBuyerId(buyerId);
    }

    @Override
    public boolean updateVisitStatus(int visitId, String status) {
        return buyerRepository.updateVisitStatus(visitId, status);
    }

    @Override
    public String getPropertyTitleById(int propertyId) {
        return propertyRepository.getPropertyTitleById(propertyId);
    }

    @Override
    public String getBuyerUsernameById(int buyerId) {
        return buyerRepository.getBuyerUsernameById(buyerId);
    }

    @Override
    public List<Visit> getAllVisitsBySellerId(int seller_id) {
        return buyerRepository.getAllVisitsBySellerId(seller_id);
    }
    @Override
    public List<Inquiry> getInquiriesBySellerIdAndStatus(int seller_id, String status) {
        return buyerRepository.getInquiriesBySellerIdAndStatus(seller_id, "answered");
    }
}