package project_property_search_app.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project_property_search_app.entity.Admin;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Seller;
import project_property_search_app.exception.LoginException;
import project_property_search_app.service.AdminService;
import project_property_search_app.service.BuyerService;
import project_property_search_app.service.SellerService;

@Controller
public class LoginController {

    @Autowired
	public AdminService adminService;

    @Autowired
	public SellerService sellerService;

    @Autowired
	public BuyerService buyerService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This will render login.jsp
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session) {
        Admin admin = adminService.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("user", admin);
            session.setAttribute("adminId", admin.getAdminId());
            return "redirect:/admin/adminDashboard";
        }

        Seller seller = sellerService.findByEmail(email);
        if (seller != null && seller.getPassword().equals(password)) {
            session.setAttribute("user", seller);
            session.setAttribute("seller_id", seller.getSeller_id());
            return "redirect:/seller/sellerDashboard";
        }

        Buyer buyer = buyerService.findByEmail(email);
        if (buyer != null && buyer.getPassword().equals(password)) {
            session.setAttribute("user", buyer);
            session.setAttribute("buyerId", buyer.getBuyerId());
            return "redirect:/buyer/buyerDashboard";
        }

        // Throw exception if user not found
        throw new LoginException("Invalid email or password.");
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login"; 
    }

    @ExceptionHandler(LoginException.class)
    public String handleLoginException(LoginException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "login";
    }
}