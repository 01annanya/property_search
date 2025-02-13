package project_property_search_app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_property_search_app.entity.Seller;
import project_property_search_app.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.getAllSellers();
    }

    @Override
    public Seller addNewSeller(Seller seller) {
        return sellerRepository.addNewSeller(seller);
    }

    @Override
    public Seller authenticate(String email, String password) {
        Seller seller = sellerRepository.findByEmail(email);
        if (seller != null && seller.getPassword().equals(password)) {
            return seller;
        }
        return null;
    }

    @Override
    public void updateSellerProfile(int seller_id, String email, String password) {
        sellerRepository.updateSellerProfile(seller_id, email, password);
    }

    @Override
    public Seller getSellerbySellerId(int seller_id) {
        return sellerRepository.getSellerbySellerId(seller_id);
    }

    @Override
    public void respondToInquiry(int sellerId, int inquiryId, String response) {
        sellerRepository.respondToInquiry(sellerId, inquiryId, response);
    }

    public void save(Seller seller) {
        sellerRepository.save(seller);
    }

    public Seller findByEmail(String email) {
        return sellerRepository.findByEmail(email);
    }
    
    @Override
    public Seller getSellerProfile(int seller_id) {
        return sellerRepository.getSellerProfile(seller_id);
    }
    
    @Override
    public boolean isValidPassword(String password) {
        // Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a special character
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(passwordPattern);
    }
}