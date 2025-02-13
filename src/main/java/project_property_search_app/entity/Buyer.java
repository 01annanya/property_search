package project_property_search_app.entity;

import org.springframework.stereotype.Component;

@Component
public class Buyer {
	  private int buyerId;
	    private String username;
	    private String password;
	    private String email;
	    
	    public Buyer() {}

		public Buyer(int buyerId, String username, String password, String email) {
			super();
			this.buyerId = buyerId;
			this.username = username;
			this.password = password;
			this.email = email;
		}

		public int getBuyerId() {
			return buyerId;
		}

		public void setBuyerId(int buyerId) {
			this.buyerId = buyerId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Override
		public String toString() {
			return "Buyer [buyerId=" + buyerId + ", username=" + username + ", password=" + password + ", email="
					+ email + "]";
		}


}
