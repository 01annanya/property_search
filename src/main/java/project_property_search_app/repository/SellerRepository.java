package project_property_search_app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import project_property_search_app.entity.Seller;


@Repository
public interface SellerRepository {
	List<Seller> getAllSellers();
    Seller addNewSeller(Seller seller);
    Seller getSellerbySellerId(int seller_id);
    void updateSellerProfile(int seller_id, String email, String password);

    void respondToInquiry(int sellerId, int inquiryId, String response);
    void save(Seller seller);
    Seller findByEmail(String email) ;
    Seller getSellerProfile(int seller_id);
   
  
}
