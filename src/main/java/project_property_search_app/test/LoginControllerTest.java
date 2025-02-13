package project_property_search_app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import project_property_search_app.controller.LoginController;
import project_property_search_app.entity.Admin;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Inquiry;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Seller;
import project_property_search_app.entity.Visit;
import project_property_search_app.exception.LoginException;
import project_property_search_app.service.AdminService;
import project_property_search_app.service.BuyerService;
import project_property_search_app.service.SellerService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LoginControllerTest {

    private LoginController loginController;
    private AdminService adminService;
    private SellerService sellerService;
    private BuyerService buyerService;
    private HttpSession session;
    @BeforeEach
    public void setup() {
        adminService = new AdminService() {
            @Override
            public Admin findByEmail(String email) {
                if (email.equals("admin@example.com")) {
                    Admin admin = new Admin();
                    admin.setAdminId(1);
                    admin.setEmail(email);
                    admin.setPassword("password");
                    return admin;
                }
                return null;
            }

			@Override
			public void save(Admin admin) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Admin getAdminProfile(int adminId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void updateAdminProfile(int adminId, String email, String password) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Admin authenticate(String email, String password) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isValidPassword(String password) {
				// TODO Auto-generated method stub
				return false;
			}
        };

        sellerService = new SellerService() {
            @Override
            public Seller findByEmail(String email) {
                if (email.equals("seller@example.com")) {
                    Seller seller = new Seller();
                    seller.setSeller_id(1);
                    seller.setEmail(email);
                    seller.setPassword("password");
                    return seller;
                }
                return null;
            }

			@Override
			public List<Seller> getAllSellers() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Seller addNewSeller(Seller seller) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Seller getSellerbySellerId(int seller_id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void respondToInquiry(int sellerId, int inquiryId, String response) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void save(Seller seller) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Seller authenticate(String email, String password) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void updateSellerProfile(int seller_id, String email, String password) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean isValidPassword(String password) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Seller getSellerProfile(int seller_id) {
				// TODO Auto-generated method stub
				return null;
			}
        };

        buyerService = new BuyerService() {
            @Override
            public Buyer findByEmail(String email) {
                if (email.equals("buyer@example.com")) {
                    Buyer buyer = new Buyer();
                    buyer.setBuyerId(1);
                    buyer.setEmail(email);
                    buyer.setPassword("password");
                    return buyer;
                }
                return null;
            }

			@Override
			public List<Buyer> getAllBuyers() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Buyer addNewBuyer(Buyer buyer) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Buyer updateBuyer(int buyer_id, String email, String password) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Buyer getBuyerById(int buyer_id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void save(Buyer buyer) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Buyer updateBuyerProfile(int buyerId, String email, String password) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Buyer getBuyerProfile(int buyerId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Buyer authenticate(String email, String password) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isValidPassword(String password) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Property> searchProperties(String location) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Property> filterProperties(String location, double minPrice, double maxPrice,
					String amenities) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean addFavorite(String username, int propertyId) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Property> getFavoritePropertiesByBuyerId(int buyerId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean addInquiry(String buyerUsername, String propertyTitle, String message) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Inquiry> getInquiriesByBuyerId(int buyerId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Inquiry> getAllInquiriesBySellerId(int seller_id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Inquiry getInquiryById(int inquiryId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void updateInquiry(Inquiry inquiry) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public String getBuyerEmailById(int buyerId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean respondToInquiry(int inquiryId, String response) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Inquiry> getInquiriesBySellerIdAndStatus(int sellerId, String status) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean scheduleVisit(String buyerUsername, String propertyTitle, String visitDate, String status) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Visit> getVisitsByBuyerId(int buyerId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Property> getAllProperties() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean updateVisitStatus(int visitId, String status) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<Visit> getPendingVisitsBySellerId(int seller_id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getPropertyTitleById(int propertyId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getBuyerUsernameById(int buyerId) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Visit> getAllVisitsBySellerId(int seller_id) {
				// TODO Auto-generated method stub
				return null;
			}
        };

        session = new MockHttpSession();
        new MockModel();

        loginController = new LoginController();
        loginController.adminService = adminService;
        loginController.sellerService = sellerService;
        loginController.buyerService = buyerService;
    }

    @Test
    void testShowLoginPage() {
        String viewName = loginController.showLoginPage();
        assertEquals("login", viewName);
    }

    @Test
    void testLoginAdmin() {
        String viewName = loginController.login("admin@example.com", "password", session);
        assertEquals("redirect:/admin/adminDashboard", viewName);
        assertEquals(1, session.getAttribute("adminId"));
    }

    @Test
    void testLoginSeller() {
        String viewName = loginController.login("seller@example.com", "password", session);
        assertEquals("redirect:/seller/sellerDashboard", viewName);
        assertEquals(1, session.getAttribute("seller_id"));
    }

    @Test
    void testLoginBuyer() {
        String viewName = loginController.login("buyer@example.com", "password", session);
        assertEquals("redirect:/buyer/buyerDashboard", viewName);
        assertEquals(1, session.getAttribute("buyerId"));
    }

    @Test
    void testLoginInvalid() {
        assertThrows(LoginException.class, () -> {
            loginController.login("invalid@example.com", "password", session);
        });
    }

    @Test
    void testLogout() {
        session.setAttribute("user", new Admin());
        String viewName = loginController.logout(session);
        assertEquals("redirect:/login", viewName);
        assertEquals(null, session.getAttribute("user"));
    }

    // Mock implementations for HttpSession and Model
    private static class MockHttpSession implements HttpSession {
        private final Map<String, Object> attributes = new HashMap<>();

        @Override
        public Object getAttribute(String name) {
            return attributes.get(name);
        }

        @Override
        public void setAttribute(String name, Object value) {
            attributes.put(name, value);
        }

        @Override
        public void removeAttribute(String name) {
            attributes.remove(name);
        }

        // Implement other methods as needed
        @Override
        public long getCreationTime() { return 0; }
        @Override
        public String getId() { return null; }
        @Override
        public long getLastAccessedTime() { return 0; }
        @Override
        public ServletContext getServletContext() { return null; }
        @Override
        public void setMaxInactiveInterval(int interval) {}
        @Override
        public int getMaxInactiveInterval() { return 0; }
        @Override
        public HttpSessionContext getSessionContext() { return null; }
        @Override
        public Object getValue(String name) { return null; }
        @Override
        public Enumeration<String> getAttributeNames() { return Collections.enumeration(attributes.keySet()); }
        @Override
        public String[] getValueNames() { return new String[0]; }
        @Override
        public void putValue(String name, Object value) {}
        @Override
        public void removeValue(String name) {}
        @Override
        public void invalidate() { attributes.clear(); }
        @Override
        public boolean isNew() { return false; }
    }

    private static class MockModel implements Model {
        private final Map<String, Object> attributes = new HashMap<>();

        @Override
        public Model addAttribute(String attributeName, Object attributeValue) {
            attributes.put(attributeName, attributeValue);
            return this;
        }

        @Override
        public Model addAttribute(Object attributeValue) {
            // Implement as needed
            return this;
        }

        @Override
        public Model addAllAttributes(Collection<?> attributeValues) {
            // Implement as needed
            return this;
        }
//
//        @Override
//        public Model addAllAttributes(Map<String, ?> attributes) {
//            this.attributes.putAll(attributes);
//            return this;
//        }

        @Override
        public Model mergeAttributes(Map<String, ?> attributes) {
            this.attributes.putAll(attributes);
            return this;
        }

        @Override
        public boolean containsAttribute(String attributeName) {
            return attributes.containsKey(attributeName);
        }

        public Object getAttribute(String attributeName) {
            return attributes.get(attributeName);
        }

        @Override
        public Map<String, Object> asMap() {
            return attributes;
        }
//
//		@Override
//		public Model addAllAttributes(Collection<?> attributeValues) {
//			// TODO Auto-generated method stub
//			return null;
//		}

		@Override
		public Model addAllAttributes(Map<String, ?> attributes) {
			// TODO Auto-generated method stub
			return null;
		}
    }
}