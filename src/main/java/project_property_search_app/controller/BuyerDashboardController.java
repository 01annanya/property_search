package project_property_search_app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import project_property_search_app.entity.Buyer;
import project_property_search_app.entity.Inquiry;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Visit;
import project_property_search_app.service.BuyerService;
import project_property_search_app.service.PropertyService;

@Controller
@RequestMapping("/buyer")
public class BuyerDashboardController {

    @Autowired
	public BuyerService buyerService;

    @Autowired
	public PropertyService propertyService;

    @RequestMapping("/buyerDashboard")
    public String showBuyerDashboard(Model model) {
        return "buyerDashboard";
    }
        
    @GetMapping("/buyerProfile")
    public String viewProfile(Model model, HttpSession session) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        model.addAttribute("buyer", buyer);
        return "buyerprofile";
    }

    @GetMapping("/changePassword")
    public String showChangePasswordForm(Model model) {
        String userType = "buyer";
        model.addAttribute("userType", userType);
        return "changePassword";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(HttpSession session, @RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String confirmNewPassword, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        if (!buyer.getPassword().equals(oldPassword)) {
            model.addAttribute("error", "Old password is incorrect.");
            model.addAttribute("userType", "buyer");
            return "changePassword";
        }
        if (newPassword.equals(oldPassword)) {
            model.addAttribute("error", "Old password and new password should be different.");
            model.addAttribute("userType", "buyer");
            return "changePassword";
        }
        if (!newPassword.equals(confirmNewPassword)) {
            model.addAttribute("error", "New passwords do not match.");
            model.addAttribute("userType", "buyer");
            return "changePassword";
        }
        buyerService.updateBuyerProfile(buyerId, buyer.getEmail(), newPassword);
        model.addAttribute("message", "Password updated successfully.");
        model.addAttribute("userType", "buyer");
        return "changePassword";
    }

    @GetMapping("/changeEmail")
    public String showChangeEmailForm(Model model) {
        String userType = "buyer";
        model.addAttribute("userType", userType);
        return "changeEmail";
    }

    @PostMapping("/updateEmail")
    public String updateEmail(HttpSession session, @RequestParam String password, @RequestParam String oldEmail, @RequestParam String newEmail, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        if (!buyer.getPassword().equals(password)) {
            model.addAttribute("error", "Password is incorrect.");
            model.addAttribute("userType", "buyer");
            return "changeEmail";
        }
        if (!buyer.getEmail().equals(oldEmail)) {
            model.addAttribute("error", "Old email is incorrect.");
            model.addAttribute("userType", "buyer");
            return "changeEmail";
        }
        if (oldEmail.equals(newEmail)) {
            model.addAttribute("error", "Old email and new email should be different.");
            model.addAttribute("userType", "buyer");
            return "changeEmail";
        }
        buyerService.updateBuyerProfile(buyerId, newEmail, buyer.getPassword());
        model.addAttribute("message", "Email updated successfully.");
        model.addAttribute("userType", "buyer");
        return "changeEmail";
    }
        
    @GetMapping("/searchProperties")
    public String searchProperties(@RequestParam("location") String location, Model model) {
        List<Property> properties = buyerService.searchProperties(location);
        model.addAttribute("properties", properties);
        model.addAttribute("location", location);
        return "searchResults";
    }

    @GetMapping("/propertyDetails")
    public String viewPropertyDetails(@RequestParam("propertyId") int propertyId, Model model, HttpSession session) {
        Property property = propertyService.getPropertyByPropertyId(propertyId);
        model.addAttribute("property", property);
        
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId != null) {
            Buyer buyer = buyerService.getBuyerProfile(buyerId);
            model.addAttribute("buyer", buyer);
        }
        
        return "propertyDetails";
    }

    @GetMapping("/filterProperties")
    public String filterProperties(@RequestParam("location") String location,
                                   @RequestParam("minPrice") double minPrice,
                                   @RequestParam("maxPrice") double maxPrice,
                                   @RequestParam("amenities") String amenities,
                                   Model model) {
        List<Property> properties = buyerService.filterProperties(location, minPrice, maxPrice, amenities);
        model.addAttribute("properties", properties);
        model.addAttribute("location", location);
        return "filterResults";
    }

    @RequestMapping("/filterPropertiesForm")
    public String showFilterPropertiesForm(Model model) {
        return "filterPropertiesForm";
    }

    @PostMapping("/addFavorite")
    public String addFavorite(HttpSession session, @RequestParam("propertyId") int propertyId, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        boolean isAdded = buyerService.addFavorite(buyer.getUsername(), propertyId);
        model.addAttribute("isAdded", isAdded);
        model.addAttribute("message", "This property has been added to favorites.");
        return "redirect:/buyer/propertyDetails?propertyId=" + propertyId + "&message=Property added to favorites";
    }
    
    @GetMapping("/favoriteProperties")
    public String getFavoriteProperties(HttpSession session, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        List<Property> favoriteProperties = buyerService.getFavoritePropertiesByBuyerId(buyerId);
        model.addAttribute("favoriteProperties", favoriteProperties);
        return "favoriteProperties";
    }
    @PostMapping("/addInquiry")
    public String addInquiry(@RequestParam("propertyId") int propertyId,
                             @RequestParam("message") String message,
                             HttpSession session,
                             Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        Property property = propertyService.getPropertyByPropertyId(propertyId);
        boolean isAdded = buyerService.addInquiry(buyer.getUsername(), property.getTitle(), message);
        model.addAttribute("isAdded", isAdded);
        model.addAttribute("message", "Inquiry has been sent to the seller.");
        return "redirect:/buyer/propertyDetails?propertyId=" + propertyId + "&message=Inquiry sent";
    }
    
    @GetMapping("/inquiries")
    public String viewInquiries(HttpSession session, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        List<Inquiry> inquiries = buyerService.getInquiriesByBuyerId(buyerId);
        model.addAttribute("inquiries", inquiries);
        return "inquiries";
    }

    @PostMapping("/scheduleVisit")
    public String scheduleVisit(HttpSession session,
                                @RequestParam("propertyId") int propertyId,
                                @RequestParam("visitDate") String visitDate,
                                Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate scheduledDate = LocalDate.parse(visitDate, DateTimeFormatter.ISO_DATE);
        if (scheduledDate.isBefore(currentDate)) {
            model.addAttribute("error", "Visit date cannot be in the past.");
            return "propertyDetails";
        }
        Buyer buyer = buyerService.getBuyerProfile(buyerId);
        Property property = propertyService.getPropertyByPropertyId(propertyId);
        boolean isScheduled = buyerService.scheduleVisit(buyer.getUsername(), property.getTitle(), visitDate, "Pending");
        String statusMessage;

        if (isScheduled) {
            statusMessage = "Visit request sent. Waiting for seller confirmation.";
        } else {
            statusMessage = "Failed to schedule visit. Please try again.";
        }

        model.addAttribute("isScheduled", isScheduled);
        model.addAttribute("statusMessage", statusMessage);
        return "redirect:/buyer/propertyDetails?propertyId=" + propertyId + "&message=Visit requested";
    }
    
    @GetMapping("/visits")
    public String viewVisits(HttpSession session, Model model) {
        Integer buyerId = (Integer) session.getAttribute("buyerId");
        if (buyerId == null) {
            return "redirect:/login"; // Redirect to login page if buyerId is not in session
        }
        List<Visit> visits = buyerService.getVisitsByBuyerId(buyerId);
        model.addAttribute("visits", visits);
        return "visits";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session to log out the user
        return "redirect:/login"; // Redirect to the login page after logout
    }
}