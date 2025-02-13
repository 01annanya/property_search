package project_property_search_app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project_property_search_app.entity.Admin;
import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Seller;
import project_property_search_app.service.AdminService;
import project_property_search_app.service.BuyerService;
import project_property_search_app.service.PropertyService;
import project_property_search_app.service.SellerService;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {
	
	@Autowired
	public AdminService adminService;
	
	@Autowired
    public BuyerService buyerService;
 
    @Autowired
    public SellerService sellerService;
 
    @Autowired
    public PropertyService propertyService;
    
    @GetMapping("/adminDashboard")
    public String showAdminDashboard() {
        return "adminDashboard"; // This will render adminDashboard.jsp
    }
    
    @GetMapping("/adminProfile")
    public String viewProfile(Model model, HttpSession session) {
        Integer adminId = (Integer) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/login"; // Redirect to login page if adminId is not in session
        }
        Admin admin = adminService.getAdminProfile(adminId);
        model.addAttribute("admin", admin);
        return "adminProfile"; // This line returns the "adminProfile" view
    }

    @GetMapping("/changePassword")
    public String showChangePasswordForm(HttpSession session, Model model) {
        String userType = "admin";
        model.addAttribute("userType", userType);
        return "changePassword";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(HttpSession session, @RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String confirmNewPassword, Model model) {
        Integer adminId = (Integer) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/login"; // Redirect to login page if adminId is not in session
        }
        Admin admin = adminService.getAdminProfile(adminId);
        if (!admin.getPassword().equals(oldPassword)) {
            model.addAttribute("error", "Old password is incorrect.");
            return "changePassword";
        }
        if (newPassword.equals(oldPassword)) {
            model.addAttribute("error", "Old password and new password should be different.");
            return "changePassword";
        }
        if (!newPassword.equals(confirmNewPassword)) {
            model.addAttribute("error", "New passwords do not match.");
            return "changePassword";
        }
        adminService.updateAdminProfile(adminId, admin.getEmail(), newPassword);
        model.addAttribute("message", "Password updated successfully.");
        model.addAttribute("userType", "admin");
        return "changePassword";
    }

    @GetMapping("/changeEmail")
    public String showChangeEmailForm(HttpSession session, Model model) {
        String userType = "admin";
        model.addAttribute("userType", userType);
        return "changeEmail";
    }
    @PostMapping("/updateEmail")
    public String updateEmail(HttpSession session, @RequestParam String password, @RequestParam String oldEmail, @RequestParam String newEmail, Model model) {
        Integer adminId = (Integer) session.getAttribute("adminId");
        if (adminId == null) {
            return "redirect:/login"; // Redirect to login page if adminId is not in session
        }
        Admin admin = adminService.getAdminProfile(adminId);
        if (!admin.getPassword().equals(password)) {
            model.addAttribute("error", "Password is incorrect.");
            return "changeEmail";
        }
        if (!admin.getEmail().equals(oldEmail)) {
            model.addAttribute("error", "Old email is incorrect.");
            return "changeEmail";
        }
        if (oldEmail.equals(newEmail)) {
            model.addAttribute("error", "Old email and new email should be different.");
            return "changeEmail";
        }
        adminService.updateAdminProfile(adminId, newEmail, admin.getPassword());
        model.addAttribute("message", "Email updated successfully.");
        model.addAttribute("userType", "admin");
        return "changeEmail";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session to log out the user
        return "redirect:/login"; // Redirect to the login page after logout
    }
    
    // Buyer Management
    @RequestMapping("/getAllBuyers")
    public String getAllBuyers(Model model) {
        List<Buyer> list = buyerService.getAllBuyers();
        model.addAttribute("list", list);
        return "buyerlist";
    }

   
    @GetMapping("/getBuyerByIdForm")
    public String showGetBuyerByIdForm() {
        return "getbuyerbyid-form";
    }

    @GetMapping("/getBuyerById")
    public String getBuyerById(@RequestParam("buyer_id") int buyer_id, Model model) {
        Buyer buyer = buyerService.getBuyerById(buyer_id);
        if(buyer!=null) {
            model.addAttribute("buyer", buyer);
            return "buyer";
        } else {
        	return "error";
        }
    }
    // Seller Management
    @RequestMapping("/getAllSellers")
    public String getAllSellers(Model model) {
        List<Seller> list = sellerService.getAllSellers();
        model.addAttribute("list", list);
        return "sellerlist";
    }

   
  

   
    @RequestMapping(value = "/getSellerByIdForm", method = RequestMethod.GET)
    public String showGetSellerByIdForm() {
        return "getsellerbyid-form";
    }

    @RequestMapping(value = "/getSellerbySellerId", method = RequestMethod.GET)
    public String getSellerbySellerId(@RequestParam("seller_id") int seller_id, Model model) {
        Seller seller = sellerService.getSellerbySellerId(seller_id);
        if (seller != null) {
            model.addAttribute("seller", seller);
            return "seller";
        } else {
            return "error";
        }
    }
    
 
    // Property Management
    @RequestMapping("/getAllProperties")
    public String getAllProperties(Model model) {
        List<Property> list = propertyService.getAllProperties();
        model.addAttribute("list", list);
        return "propertyOverview";
    }

   
  

    @RequestMapping(value = "/getPropertyByIdForm", method = RequestMethod.GET)
    public String showGetPropertyByIdForm() {
        return "getpropertybyid-form";
    }

    @RequestMapping(value = "/getPropertyByPropertyId", method = RequestMethod.GET)
    public String getPropertyByPropertyId(@RequestParam("property_id") int property_id, Model model) {
        Property property = propertyService.getPropertyByPropertyId(property_id);
        if (property != null) {
            model.addAttribute("property", property);
            return "property";
        } else {
            return "error";
        }
    }
}