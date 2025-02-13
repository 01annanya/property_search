package project_property_search_app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project_property_search_app.entity.Inquiry;
import project_property_search_app.entity.Property;
import project_property_search_app.entity.Seller;
import project_property_search_app.entity.Visit;
import project_property_search_app.service.BuyerService;
import project_property_search_app.service.PropertyService;
import project_property_search_app.service.SellerService;

@Controller
@RequestMapping("/seller")
public class SellerDashboardController {
    @Autowired
	public SellerService sellerService;
    
    @Autowired
	public BuyerService buyerService;
    
    @Autowired
	public PropertyService propertyService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Seller seller = sellerService.authenticate(email, password);
        if (seller != null) {
            session.setAttribute("seller_id", seller.getSeller_id());
            return "redirect:/seller/sellerDashboard";
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }

    @GetMapping("/sellerDashboard")
    public String showSellerDashboard(HttpSession session, Model model) {
        Integer seller_id = (Integer) session.getAttribute("seller_id");
        if (seller_id == null) {
            return "redirect:/login"; // Redirect to login page if seller_id is not in session
        }
        Seller seller = sellerService.getSellerbySellerId(seller_id);
        model.addAttribute("seller", seller);
        return "sellerDashboard"; // This will render sellerDashboard.jsp
    }

    @GetMapping("/sellerProfile")
    public String viewProfile(HttpSession session, Model model) {
        Integer seller_id = (Integer) session.getAttribute("seller_id");
        if (seller_id == null) {
            return "redirect:/login"; // Redirect to login page if seller_id is not in session
        }
        Seller seller = sellerService.getSellerProfile(seller_id);
        model.addAttribute("seller", seller);
        return "sellerProfile";
    }

    @GetMapping("/changePassword")
    public String showChangePasswordForm(HttpSession session, Model model) {
        String userType = "seller";
        model.addAttribute("userType", userType);
        return "changePassword";
    }

    @PostMapping("/updatePassword")
    public String updatePassword(HttpSession session, @RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String confirmNewPassword, Model model) {
        Integer seller_id = (Integer) session.getAttribute("seller_id");
        if (seller_id == null) {
            return "redirect:/login"; // Redirect to login page if seller_id is not in session
        }
        Seller seller = sellerService.getSellerbySellerId(seller_id);
        if (!seller.getPassword().equals(oldPassword)) {
            model.addAttribute("error", "Old password is incorrect.");
            model.addAttribute("userType", "seller");
            return "changePassword";
        }
        if (newPassword.equals(oldPassword)) {
            model.addAttribute("error", "Old password and new password should be different.");
            model.addAttribute("userType", "seller");
            return "changePassword";
        }
        if (!newPassword.equals(confirmNewPassword)) {
            model.addAttribute("error", "New passwords do not match.");
            model.addAttribute("userType", "seller");
            return "changePassword";
        }
        sellerService.updateSellerProfile(seller_id, seller.getEmail(), newPassword);
        model.addAttribute("message", "Password updated successfully.");
        model.addAttribute("userType", "seller");
        return "changePassword";
    }

    @GetMapping("/changeEmail")
    public String showChangeEmailForm(HttpSession session, Model model) {
        String userType = "seller";
        model.addAttribute("userType", userType);
        return "changeEmail";
    }

    @PostMapping("/updateEmail")
    public String updateEmail(HttpSession session, @RequestParam String password, @RequestParam String oldEmail, @RequestParam String newEmail, Model model) {
        Integer seller_id = (Integer) session.getAttribute("seller_id");
        if (seller_id == null) {
            return "redirect:/login"; // Redirect to login page if seller_id is not in session
        }
        Seller seller = sellerService.getSellerbySellerId(seller_id);
        if (!seller.getPassword().equals(password)) {
            model.addAttribute("error", "Password is incorrect.");
            model.addAttribute("userType", "seller");
            return "changeEmail";
        }
        if (!seller.getEmail().equals(oldEmail)) {
            model.addAttribute("error", "Old email is incorrect.");
            model.addAttribute("userType", "seller");
            return "changeEmail";
        }
        if (oldEmail.equals(newEmail)) {
            model.addAttribute("error", "Old email and new email should be different.");
            model.addAttribute("userType", "seller");
            return "changeEmail";
        }
        sellerService.updateSellerProfile(seller_id, newEmail, seller.getPassword());
        model.addAttribute("message", "Email updated successfully.");
        model.addAttribute("userType", "seller");
        return "changeEmail";
    }

    @GetMapping("/sellerPendingVisits")
    public String showPendingVisits(HttpSession session, Model model) {
        Integer seller_id = (Integer) session.getAttribute("seller_id");
        if (seller_id == null) {
            return "redirect:/login"; // Redirect to login page if seller_id is not in session
        }
        List<Visit> allVisits = buyerService.getAllVisitsBySellerId(seller_id);
        Map<Integer, String> propertyNames = new HashMap<>();
        Map<Integer, String> buyerUsernames = new HashMap<>();
        
        for (Visit visit : allVisits) {
            propertyNames.put(visit.getPropertyId(), buyerService.getPropertyTitleById(visit.getPropertyId()));
            buyerUsernames.put(visit.getBuyerId(), buyerService.getBuyerUsernameById(visit.getBuyerId()));
        }
        
        model.addAttribute("pendingVisits", allVisits);
        model.addAttribute("propertyNames", propertyNames);
        model.addAttribute("buyerUsernames", buyerUsernames);
        return "sellerPendingVisits";
    }
    
    @PostMapping("/updateVisitStatus")
    public String updateVisitStatus(@RequestParam int visitId, @RequestParam String status, Model model) {
        boolean success = buyerService.updateVisitStatus(visitId, status);
        if (success) {
            model.addAttribute("updateSuccess", true);
            return "redirect:sellerPendingVisits";
        } else {
            model.addAttribute("updateSuccess", false);
            return "error"; // Handle error appropriately
        }
    }
    
    @GetMapping("/sellerInquiries")
    public String showSellerInquiries(HttpSession session, Model model) {
        Integer sellerId = (Integer) session.getAttribute("seller_id");
        if (sellerId == null) {
            return "redirect:/login"; // Redirect to login page if seller_id is not in session
        }
        List<Inquiry> allInquiries = buyerService.getAllInquiriesBySellerId(sellerId);
        Map<Integer, String> propertyTitles = new HashMap<>();
        Map<Integer, String> buyerUsernames = new HashMap<>();
        Map<Integer, String> buyerEmails = new HashMap<>();
        
        for (Inquiry inquiry : allInquiries) {
            propertyTitles.put(inquiry.getPropertyId(), buyerService.getPropertyTitleById(inquiry.getPropertyId()));
            buyerUsernames.put(inquiry.getBuyerId(), buyerService.getBuyerUsernameById(inquiry.getBuyerId()));
            buyerEmails.put(inquiry.getBuyerId(), buyerService.getBuyerEmailById(inquiry.getBuyerId()));
        }
        
        model.addAttribute("inquiries", allInquiries);
        model.addAttribute("propertyTitles", propertyTitles);
        model.addAttribute("buyerUsernames", buyerUsernames);
        model.addAttribute("buyerEmails", buyerEmails);
        return "sellerInquiries";
    }
    
    @PostMapping("/respondToInquiry")
    public String respondToInquiry(@RequestParam int inquiryId, @RequestParam String response, RedirectAttributes redirectAttributes) {
        boolean success = buyerService.respondToInquiry(inquiryId, response);
        if (success) {
            Inquiry inquiry = buyerService.getInquiryById(inquiryId);
            inquiry.setStatus("answered");
            buyerService.updateInquiry(inquiry);
        }
        redirectAttributes.addFlashAttribute("responseSuccess", success);
        return "redirect:/seller/responseSuccess";
    }

    @GetMapping("/responseSuccess")
    public String showResponseSuccess(Model model) {
        return "responseSuccess";
    }

    @GetMapping("/myResponses")
    public String showMyResponses(HttpSession session, Model model) {
        Integer seller_id = (Integer) session.getAttribute("seller_id");
        if (seller_id == null) {
            return "redirect:/login"; // Redirect to login page if seller_id is not in session
        }

        String status = "answered"; // Assuming 'status' is defined somewhere in your code
        List<Inquiry> answeredInquiries = buyerService.getInquiriesBySellerIdAndStatus(seller_id, status);
        Map<Integer, String> propertyTitles = new HashMap<>();
        Map<Integer, String> buyerUsernames = new HashMap<>();

        for (Inquiry inquiry : answeredInquiries) {
            propertyTitles.computeIfAbsent(inquiry.getPropertyId(), buyerService::getPropertyTitleById);
            buyerUsernames.computeIfAbsent(inquiry.getBuyerId(), buyerService::getBuyerUsernameById);
        }

        model.addAttribute("inquiries", answeredInquiries);
        model.addAttribute("propertyTitles", propertyTitles);
        model.addAttribute("buyerUsernames", buyerUsernames);
        return "myResponses";
    }
    @RequestMapping("/getAllProperties")
    public String getAllProperties(Model model, HttpSession session) {
        Integer seller_id = (Integer) session.getAttribute("seller_id");
        if (seller_id == null) {
            return "redirect:/login";
        }
        List<Property> list = propertyService.getPropertiesBySellerId(seller_id);
        System.out.println("Fetched properties: " + list); // Debug statement
        model.addAttribute("propertyList", list);
        return "propertylist";
    }
    
//    
  @RequestMapping("/addNewPropertyForm")
  public String addNewPropertyForm() {
        return "property-form";
   }
// 
//    @RequestMapping(value = "/addNewProperty", method = RequestMethod.POST)
//    public String addNewProperty(@ModelAttribute Property propertyDetails, Model model) {
//        Property property = propertyService.addNewProperty(propertyDetails);
//        model.addAttribute("property", property);
//        return "property";
//   
  @PostMapping("/addNewProperty")
  public String addNewProperty(@ModelAttribute Property propertyDetails, HttpSession session, RedirectAttributes redirectAttributes) {
      Integer sellerId = (Integer) session.getAttribute("seller_id");
      
      // Check if sellerId is present in session
      if (sellerId == null) {
          System.out.println("Seller ID is null, redirecting to login.");
          return "redirect:/login"; // Redirect to login page if sellerId is not in session
      }
      
      // Associate property with the seller
      propertyDetails.setSellerId(sellerId);
      System.out.println("Property details before saving: " + propertyDetails); // Debug statement
      
      // Add new property
      Property property = propertyService.addNewProperty(propertyDetails);
      
      // Check if property was successfully added
      if (property != null && property.getPropertyId() != null) {
          System.out.println("Property added with ID: " + property.getPropertyId()); // Debug statement
          redirectAttributes.addFlashAttribute("successMessage", "Property added successfully.");
          System.out.println("Redirecting to addNewPropertyForm with success=true"); // Debug statement
          return "redirect:/seller/addNewPropertyForm?success=true"; // Redirect with success flag
      } else {
          System.out.println("Failed to add property.");
          redirectAttributes.addFlashAttribute("errorMessage", "Failed to add property.");
          return "redirect:/seller/addNewPropertyForm";
      }
  }
  @GetMapping("/property/{property_id}")
    public String getPropertyDetails(@PathVariable("property_id") Integer property_id, Model model) {
        System.out.println("Received property_id: " + property_id); // Debug statement
        Property property = propertyService.getPropertyByPropertyId(property_id);
        if (property != null) {
            System.out.println("Property details: " + property); // Debug statement
            model.addAttribute("property", property);
            return "property";
        } else {
            System.out.println("Property not found for ID: " + property_id); // Debug statement
            return "error";
        }
    }
 
    @GetMapping("/updatePropertyForm")
    public String showUpdatePropertyForm(@RequestParam("property_id") int property_id, Model model) {
        System.out.println("Received property_id: " + property_id); // Debug statement
        Property property = propertyService.getPropertyByPropertyId(property_id);
        if (property != null) {
            model.addAttribute("property", property);
            return "updateproperty-form";
        } else {
            return "error";
        }
    }
    @PostMapping("/updateProperty")
    public String updateProperty(@RequestParam("property_id") int property_id, @RequestParam("price") Double price, RedirectAttributes redirectAttributes) {
        boolean success = propertyService.updatePropertyByIdAndPrice(property_id, price);
        if (success) {
            redirectAttributes.addFlashAttribute("successMessage", "Property updated successfully.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update property.");
        }
        return "redirect:/seller/getAllProperties"; // Redirect to the property list page
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session to log out the user
        return "redirect:/login"; // Redirect to the login page after logout
    }
}