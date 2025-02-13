package project_property_search_app.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import project_property_search_app.entity.Admin;
import project_property_search_app.entity.Property;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Property> getAllPendingProperties() {
        String sql = "SELECT * FROM Properties WHERE status = 'Pending'";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
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

    public boolean approveProperty(int propertyId) {
        String sql = "UPDATE Properties SET status = 'Approved' WHERE property_id = ?";
        int result = jdbcTemplate.update(sql, propertyId);
        return result > 0;
    }

    public boolean rejectProperty(int propertyId) {
        String sql = "UPDATE Properties SET status = 'Rejected' WHERE property_id = ?";
        int result = jdbcTemplate.update(sql, propertyId);
        return result > 0;
    }

    public void save(Admin admin) {
        String sql = "INSERT INTO Admin (admin_id, username, email, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, admin.getAdminId(), admin.getUsername(), admin.getEmail(), admin.getPassword());
    }

    public Admin findByEmail(String email) {
        String sql = "SELECT * FROM Admin WHERE email = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) -> {
                Admin admin = new Admin();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                return admin;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public Admin findById(int adminId) {
        String sql = "SELECT * FROM Admin WHERE admin_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{adminId}, (rs, rowNum) -> {
                Admin admin = new Admin();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                return admin;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }

    @Override
    public void updateAdminProfile(int adminId, String email, String password) {
        String sql = "UPDATE Admin SET email = ?, password = ? WHERE admin_id = ?";
        jdbcTemplate.update(sql, email, password, adminId);
    }

    @Override
    public Admin getAdminProfile(int adminId) {
        String sql = "SELECT * FROM Admin WHERE admin_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{adminId}, (rs, rowNum) -> {
                Admin admin = new Admin();
                admin.setAdminId(rs.getInt("admin_id"));
                admin.setUsername(rs.getString("username"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
                return admin;
            });
        } catch (EmptyResultDataAccessException e) {
            return null; // Handle the case where no rows match the query
        }
    }
}