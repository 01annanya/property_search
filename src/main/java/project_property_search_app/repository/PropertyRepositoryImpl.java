package project_property_search_app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import project_property_search_app.entity.Property;



@Repository
public class PropertyRepositoryImpl implements PropertyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Property> getAllProperties() {
        String sql = "SELECT * FROM Properties";
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

    @Override
    public Property addNewProperty(Property property) {
        String sql = "INSERT INTO Properties (title, description, price, location, squareft, amenities, status, seller_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, property.getTitle());
                ps.setString(2, property.getDescription());
                ps.setDouble(3, property.getPrice());
                ps.setString(4, property.getLocation());
                ps.setString(5, property.getSquareft());
                ps.setString(6, property.getAmenities());
                ps.setString(7, property.getStatus());
                ps.setInt(8, property.getSellerId());
                return ps;
            }
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            property.setPropertyId(keyHolder.getKey().intValue());
        }
        return property;
    }

	
	
    @Override

    public void updateProperty(int property_id, Double price) {

        String sql = "UPDATE Properties SET price = ? WHERE property_id = ?";

        jdbcTemplate.update(sql, price, property_id);

    }
 


	@Override
	public Property getPropertyByPropertyId(int property_id) {
		 String sql = "select * from Properties  where property_id = ?";
		    try {
		        return jdbcTemplate.queryForObject(sql, new Object[]{property_id}, (rs, rowNum) -> {
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
		    } catch (Exception e) {
		        return null; // Handle the case where no rows match the query
		    }
		
	}
	
	@Override
	public List<Property> getPropertiesBySellerId(int seller_id) {
	    String sql = "SELECT * FROM Properties WHERE seller_id = ?";
	    try {
	        return jdbcTemplate.query(sql, new Object[]{seller_id}, (rs, rowNum) -> {
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
	    } catch (Exception e) {
	        return null;
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
    public List<Property> filterProperties(String location, double minPrice, double maxPrice, String amenities) {
        String sql = "SELECT * FROM Properties WHERE location = ? AND price BETWEEN ? AND ? AND amenities LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{location, minPrice, maxPrice, "%" + amenities + "%"}, (rs, rowNum) -> {
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
	    public Integer getPropertyIdByTitle(String title) {
	        String sql = "SELECT property_id FROM Properties WHERE title = ?";
	        try {
	            return jdbcTemplate.queryForObject(sql, new Object[]{title}, Integer.class);
	        } catch (Exception e) {
	            return null;
	        }
	    }
	 @Override
	    public String getPropertyTitleById(int propertyId) {
	        String sql = "SELECT title FROM Properties WHERE property_id = ?";
	        return jdbcTemplate.queryForObject(sql, new Object[]{propertyId}, String.class);
	    }
	 
	 
	 
	 
}