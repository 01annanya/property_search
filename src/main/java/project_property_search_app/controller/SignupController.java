package project_property_search_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project_property_search_app.entity.Admin;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Seller;
import project_property_search_app.exception.SignupException;
import project_property_search_app.service.AdminService;
import project_property_search_app.service.BuyerService;
import project_property_search_app.service.SellerService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SignupController {

    @Autowired
	public AdminService adminService;

    @Autowired
	public SellerService sellerService;

    @Autowired
	public BuyerService buyerService;

    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestParam("role") String role,
                         HttpServletRequest request) {
        try {
            if (!isValidPassword(password)) {
                request.setAttribute("error", "Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a special character.");
                return "signup"; // Forward back to signup.jsp
            }
            
            switch (role) {
                case "Admin":
                    Admin admin = new Admin();
                    admin.setUsername(username);
                    admin.setEmail(email);
                    admin.setPassword(password);
                    adminService.save(admin);
                    break;
                case "Seller":
                    Seller seller = new Seller();
                    seller.setUsername(username);
                    seller.setEmail(email);
                    seller.setPassword(password);
                    sellerService.save(seller);
                    break;
                case "Buyer":
                    Buyer buyer = new Buyer();
                    buyer.setUsername(username);
                    buyer.setEmail(email);
                    buyer.setPassword(password);
                    buyerService.save(buyer);
                    break;
                default:
                    request.setAttribute("error", "Invalid role: " + role);
                    return "signup"; // Forward back to signup.jsp
            }
            return "redirect:/login";
        } catch (DataIntegrityViolationException e) {
            request.setAttribute("error", "User already exists. Kindly login.");
            return "signup"; // Forward back to signup.jsp
        } catch (Exception e) {
            request.setAttribute("error", "Signup failed: " + e.getMessage());
            return "signup"; // Forward back to signup.jsp
        }
    }

    @ExceptionHandler(SignupException.class)
    public ModelAndView handleSignupException(SignupException e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("error", e.getMessage());
        mav.setViewName("signup"); // Forward back to signup.jsp
        return mav;
    }

    private boolean isValidPassword(String password) {
        // Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a digit, and a special character
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(passwordPattern);
    }
}