package project_property_search_app.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import project_property_search_app.entity.Seller;

@Repository
public class SellerRepositoryImpl implements SellerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Seller> getAllSellers() {
        String sql = "SELECT seller_id, username, password, email FROM Seller";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Seller seller = new Seller();
            seller.setSeller_id(rs.getInt("seller_id"));
            seller.setUsername(rs.getString("username"));
            seller.setPassword(rs.getString("password"));
            seller.setEmail(rs.getString("email"));
            return seller;
        });
    }

    @Override
    public Seller addNewSeller(Seller seller) {
        String sql = "INSERT INTO Seller (username, password, email) VALUES (?, ?, ?)";
        int n = jdbcTemplate.update(sql, seller.getUsername(), seller.getPassword(), seller.getEmail());
        return (n > 0) ? seller : null;
    }

    @Override
    public void updateSellerProfile(int seller_id, String email, String password) {
        String sql = "UPDATE Seller SET email = ?, password = ? WHERE seller_id = ?";
        jdbcTemplate.update(sql, email, password, seller_id);
    }

    @Override
    public Seller getSellerbySellerId(int seller_id) {
        String sql = "SELECT seller_id, username, password, email FROM seller WHERE seller_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{seller_id}, (rs, rowNum) -> {
                Seller seller = new Seller();
                seller.setSeller_id(rs.getInt("seller_id"));
                seller.setUsername(rs.getString("username"));
                seller.setPassword(rs.getString("password"));
                seller.setEmail(rs.getString("email"));
                return seller;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public void respondToInquiry(int sellerId, int inquiryId, String response) {
        String sql = "UPDATE Inquiries i INNER JOIN Properties p ON i.property_id = p.property_id " +
                     "SET i.response = ? WHERE i.inquiry_id = ? AND p.seller_id = ?";
        jdbcTemplate.update(sql, response, inquiryId, sellerId);
    }

    public void save(Seller seller) {
        String sql = "INSERT INTO seller (username, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, seller.getUsername(), seller.getEmail(), seller.getPassword());
    }

    public Seller findByEmail(String email) {
        String sql = "SELECT seller_id, username, password, email FROM seller WHERE email = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) -> {
                Seller seller = new Seller();
                seller.setSeller_id(rs.getInt("seller_id"));
                seller.setUsername(rs.getString("username"));
                seller.setEmail(rs.getString("email"));
                seller.setPassword(rs.getString("password"));
                return seller;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }
    @Override
    public Seller getSellerProfile(int seller_id) {
        String sql = "SELECT * FROM Seller WHERE seller_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{seller_id}, (rs, rowNum) -> {
                Seller seller = new Seller();
                seller.setSeller_id(rs.getInt("seller_id"));
                seller.setUsername(rs.getString("username"));
                seller.setEmail(rs.getString("email"));
                seller.setPassword(rs.getString("password"));
                return seller;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

}