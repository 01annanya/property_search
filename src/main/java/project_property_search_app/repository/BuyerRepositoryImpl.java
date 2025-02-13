package project_property_search_app.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Inquiry;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Visit;

@Repository
public class BuyerRepositoryImpl implements BuyerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Buyer> getAllBuyers() {
        String sql = "SELECT * FROM Buyer";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Buyer buyer = new Buyer();
            buyer.setBuyerId(rs.getInt("buyer_id"));
            buyer.setUsername(rs.getString("username"));
            buyer.setPassword(rs.getString("password"));
            buyer.setEmail(rs.getString("email"));
            return buyer;
        });
    }

    @Override
    public Buyer addNewBuyer(Buyer buyer) {
        String sql = "INSERT INTO Buyer (username, password, email) VALUES (?, ?, ?)";
        int n = jdbcTemplate.update(sql, buyer.getUsername(), buyer.getPassword(), buyer.getEmail());
        return (n > 0) ? buyer : null;
    }

    @Override
    public void updateBuyer(int buyer_id, String email, String password) {
        String sql = "UPDATE Buyer SET email = ?, password = ? WHERE buyer_id = ?";
        jdbcTemplate.update(sql, email, password, buyer_id);
    }

    @Override
    public Buyer getBuyerById(int buyer_id) {
        String sql = "SELECT * FROM Buyer WHERE buyer_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{buyer_id}, (rs, rowNum) -> {
                Buyer buyer = new Buyer();
                buyer.setBuyerId(rs.getInt("buyer_id"));
                buyer.setUsername(rs.getString("username"));
                buyer.setEmail(rs.getString("email"));
                buyer.setPassword(rs.getString("password"));
                return buyer;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public void save(Buyer buyer) {
        String sql = "INSERT INTO Buyer (buyer_id, username, email, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, buyer.getBuyerId(), buyer.getUsername(), buyer.getEmail(), buyer.getPassword());
    }

    @Override
    public Buyer findByEmail(String email) {
        String sql = "SELECT * FROM Buyer WHERE email = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) -> {
                Buyer buyer = new Buyer();
                buyer.setBuyerId(rs.getInt("buyer_id"));
                buyer.setUsername(rs.getString("username"));
                buyer.setEmail(rs.getString("email"));
                buyer.setPassword(rs.getString("password"));
                return buyer;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public void updateBuyerProfile(int buyerId, String email, String password) {
        String sql = "UPDATE Buyer SET email = ?, password = ? WHERE buyer_id = ?";
        jdbcTemplate.update(sql, email, password, buyerId);
    }

    @Override
    public Buyer getBuyerProfile(int buyerId) {
        String sql = "SELECT * FROM Buyer WHERE buyer_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{buyerId}, (rs, rowNum) -> {
                Buyer buyer = new Buyer();
                buyer.setBuyerId(rs.getInt("buyer_id"));
                buyer.setUsername(rs.getString("username"));
                buyer.setEmail(rs.getString("email"));
                buyer.setPassword(rs.getString("password"));
                return buyer;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public List<Property> searchProperties(String location) {
        String sql = "SELECT * FROM Properties WHERE location = ?";
        return jdbcTemplate.query(sql, new Object[]{location}, (rs, rowNum) -> {
            Property property = new Property();
            property.setPropertyId(rs.getInt("property_id"));
            property.setTitle(rs.getString("title"));
            property.setDescription(rs.getString("description"));
            property.setPrice(rs.getDouble("price"));
            property.setLocation(rs.getString("location"));
            property.setSquareft(rs.getString("squareft"));
            property.setAmenities(rs.getString("amenities"));
            property.setStatus(rs.getString("status"));
            property.setSellerId(rs.getInt("seller_id"));
            return property;
        });
    }

    @Override
    public List<Property> filterProperties(double minPrice, double maxPrice, double minSize, double maxSize, String amenities) {
        String sql = "SELECT * FROM Properties WHERE price BETWEEN ? AND ? AND size BETWEEN ? AND ? AND amenities LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{minPrice, maxPrice, minSize, maxSize, "%" + amenities + "%"}, (rs, rowNum) -> {
            Property property = new Property();
            property.setPropertyId(rs.getInt("property_id"));
            property.setTitle(rs.getString("title"));
            property.setDescription(rs.getString("description"));
            property.setPrice(rs.getDouble("price"));
            property.setLocation(rs.getString("location"));
            property.setSquareft(rs.getString("squareft"));
            property.setAmenities(rs.getString("amenities"));
            property.setStatus(rs.getString("status"));
            property.setSellerId(rs.getInt("seller_id"));
            return property;
        });
    }

    @Override
    public Integer getBuyerIdByUsername(String username) {
        String sql = "SELECT buyer_id FROM Buyer WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public Integer getPropertyIdByTitle(String title) {
        String sql = "SELECT property_id FROM Properties WHERE title = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{title}, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public boolean addFavorite(int buyerId, int propertyId) {
        String sql = "INSERT INTO Favorites (buyer_id, property_id) VALUES (?, ?)";
        int result = jdbcTemplate.update(sql, buyerId, propertyId);
        return result > 0;
    }

    @Override
    public boolean addInquiry(int buyerId, int propertyId, String message) {
        String sql = "INSERT INTO Inquiries (buyer_id, property_id, message) VALUES (?, ?, ?)";
        int result = jdbcTemplate.update(sql, buyerId, propertyId, message);
        return result > 0;
    }
    @Override
    public List<Inquiry> getInquiriesByBuyerId(int buyerId) {
        String sql = "SELECT i.inquiry_id, i.buyer_id, i.property_id, i.message, i.response, p.title AS property_title " +
                     "FROM Inquiries i " +
                     "INNER JOIN Properties p ON i.property_id = p.property_id " +
                     "WHERE i.buyer_id = ?";
        return jdbcTemplate.query(sql, new Object[]{buyerId}, (rs, rowNum) -> {
            Inquiry inquiry = new Inquiry();
            inquiry.setInquiryId(rs.getInt("inquiry_id"));
            inquiry.setBuyerId(rs.getInt("buyer_id"));
            inquiry.setPropertyId(rs.getInt("property_id"));
            inquiry.setMessage(rs.getString("message"));
            inquiry.setResponse(rs.getString("response"));
            inquiry.setPropertyTitle(rs.getString("property_title"));
            return inquiry;
        });
    }


    
    @Override
    public List<Inquiry> getAllInquiriesBySellerId(int seller_id) {
        String sql = "SELECT i.*, p.seller_id FROM Inquiries i INNER JOIN Properties p ON i.property_id = p.property_id WHERE p.seller_id = ? AND i.status = 'pending'";
        return jdbcTemplate.query(sql, new Object[]{seller_id}, (rs, rowNum) -> {
            Inquiry inquiry = new Inquiry();
            inquiry.setInquiryId(rs.getInt("inquiry_id"));
            inquiry.setBuyerId(rs.getInt("buyer_id"));
            inquiry.setPropertyId(rs.getInt("property_id"));
            inquiry.setMessage(rs.getString("message"));
            inquiry.setResponse(rs.getString("response"));
            inquiry.setSeller_id(rs.getInt("seller_id"));
            inquiry.setStatus(rs.getString("status"));
            return inquiry;
        });
    }

    @Override
    public boolean respondToInquiry(int inquiryId, String response) {
        String sql = "UPDATE Inquiries SET response = ?, status = 'answered' WHERE inquiry_id = ?";
        int result = jdbcTemplate.update(sql, response, inquiryId);
        return result > 0;
    }
    @Override
    public Inquiry getInquiryById(int inquiryId) {
        String sql = "SELECT * FROM Inquiries WHERE inquiry_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{inquiryId}, (rs, rowNum) -> {
                Inquiry inquiry = new Inquiry();
                inquiry.setInquiryId(rs.getInt("inquiry_id"));
                inquiry.setBuyerId(rs.getInt("buyer_id"));
                inquiry.setPropertyId(rs.getInt("property_id"));
                inquiry.setMessage(rs.getString("message"));
                inquiry.setResponse(rs.getString("response"));
                inquiry.setStatus(rs.getString("status"));
                return inquiry;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public void updateInquiry(Inquiry inquiry) {
        String sql = "UPDATE Inquiries SET response = ?, status = ? WHERE inquiry_id = ?";
        jdbcTemplate.update(sql, inquiry.getResponse(), inquiry.getStatus(), inquiry.getInquiryId());
    }

    @Override
    public String getBuyerEmailById(int buyerId) {
        String sql = "SELECT email FROM Buyer WHERE buyer_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{buyerId}, String.class);
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public List<Property> getFavoritePropertiesByBuyerId(int buyerId) {
        String sql = "SELECT p.property_id, p.title, p.description, p.price, p.location, p.squareft, p.amenities, p.status, p.seller_id " +
                     "FROM Properties p " +
                     "INNER JOIN Favorites f ON p.property_id = f.property_id " +
                     "INNER JOIN Buyer b ON f.buyer_id = b.buyer_id " +
                     "WHERE b.buyer_id = ?";
        return jdbcTemplate.query(sql, new Object[]{buyerId}, (rs, rowNum) -> {
            Property property = new Property();
            property.setPropertyId(rs.getInt("property_id"));
            property.setTitle(rs.getString("title"));
            property.setDescription(rs.getString("description"));
            property.setPrice(rs.getDouble("price"));
            property.setLocation(rs.getString("location"));
            property.setSquareft(rs.getString("squareft"));
            property.setAmenities(rs.getString("amenities"));
            property.setStatus(rs.getString("status"));
            property.setSellerId(rs.getInt("seller_id"));
            return property;
        });
    }
    
    @Override
    public boolean scheduleVisit(Visit visit) {
        String sql = "INSERT INTO Visits (buyer_id, property_id, visit_date, status) VALUES (?, ?, ?, ?)";
        int result = jdbcTemplate.update(sql, visit.getBuyerId(), visit.getPropertyId(), visit.getVisitDate(), visit.getStatus());
        return result > 0;
    }


    @Override
    public List<Visit> getPendingVisitsBySellerId(int seller_id) {
        String sql = "SELECT v.* FROM Visits v INNER JOIN Properties p ON v.property_id = p.property_id WHERE v.status = 'Pending' AND p.seller_id = ?";
        return jdbcTemplate.query(sql, new Object[]{seller_id}, (rs, rowNum) -> {
            Visit visit = new Visit();
            visit.setVisitId(rs.getInt("visit_id"));
            visit.setBuyerId(rs.getInt("buyer_id"));
            visit.setPropertyId(rs.getInt("property_id"));
            visit.setVisitDate(rs.getDate("visit_date"));
            visit.setStatus(rs.getString("status"));
            visit.setMessage(rs.getString("message"));
            return visit;
        });
    }

    @Override
    public boolean updateVisitStatus(int visitId, String status) {
        String sql = "UPDATE Visits SET status = ? WHERE visit_id = ?";
        int result = jdbcTemplate.update(sql, status, visitId);
        return result > 0;
    }
    
    @Override
    public String getBuyerUsernameById(int buyerId) {
        String sql = "SELECT username FROM Buyer WHERE buyer_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{buyerId}, String.class);
    }
    
    @Override
    public List<Visit> getAllVisitsBySellerId(int seller_id) {
        String sql = "SELECT v.visit_id, v.buyer_id, v.property_id, v.visit_date, v.status, v.message " +
                     "FROM Visits v " +
                     "INNER JOIN Properties p ON v.property_id = p.property_id " +
                     "WHERE p.seller_id = ?";
        return jdbcTemplate.query(sql, new Object[]{seller_id}, (rs, rowNum) -> {
            Visit visit = new Visit();
            visit.setVisitId(rs.getInt("visit_id"));
            visit.setBuyerId(rs.getInt("buyer_id"));
            visit.setPropertyId(rs.getInt("property_id"));
            visit.setVisitDate(rs.getDate("visit_date"));
            visit.setStatus(rs.getString("status"));
            visit.setMessage(rs.getString("message"));
            return visit;
        });
    }
    
    @Override
    public List<Visit> getVisitsByBuyerId(int buyerId) {
        String sql = "SELECT v.visit_id, v.buyer_id, v.property_id, v.visit_date, v.status, p.title AS property_title " +
                     "FROM Visits v " +
                     "INNER JOIN Properties p ON v.property_id = p.property_id " +
                     "WHERE v.buyer_id = ?";
        return jdbcTemplate.query(sql, new Object[]{buyerId}, (rs, rowNum) -> {
            Visit visit = new Visit();
            visit.setVisitId(rs.getInt("visit_id"));
            visit.setBuyerId(rs.getInt("buyer_id"));
            visit.setPropertyId(rs.getInt("property_id"));
            visit.setVisitDate(rs.getDate("visit_date"));
            visit.setStatus(rs.getString("status"));
            visit.setPropertyTitle(rs.getString("property_title"));
            return visit;
        });
    }
    @Override
    public List<Inquiry> getInquiriesBySellerIdAndStatus(int seller_id, String status) {
        String sql = "SELECT i.*, p.seller_id FROM Inquiries i INNER JOIN Properties p ON i.property_id = p.property_id WHERE p.seller_id = ? AND i.status = ?";
        return jdbcTemplate.query(sql, new Object[]{seller_id, status}, (rs, rowNum) -> {
            Inquiry inquiry = new Inquiry();
            inquiry.setInquiryId(rs.getInt("inquiry_id"));
            inquiry.setBuyerId(rs.getInt("buyer_id"));
            inquiry.setPropertyId(rs.getInt("property_id"));
            inquiry.setMessage(rs.getString("message"));
            inquiry.setResponse(rs.getString("response"));
            inquiry.setSeller_id(rs.getInt("seller_id"));
            inquiry.setStatus(rs.getString("status"));
            return inquiry;
        });
    }
    
    
}
    
    
