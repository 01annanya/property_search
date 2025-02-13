package project_property_search_app.entity;

import org.springframework.stereotype.Component;

@Component
public class Seller {
    private int seller_id;
    private String username;
    private String password;
    private String email;

    public Seller() {}

    public Seller(int seller_id, String username, String password, String email) {
        this.seller_id = seller_id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
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
        return "Seller [seller_id=" + seller_id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
    }
}
