package project_property_search_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project_property_search_app.entity.Property;
import project_property_search_app.service.PropertyService;


@Controller
public class PropertyController {
    @Autowired
	public PropertyService propertyService;

   

    @RequestMapping("/addNewPropertyForm")
    public String addNewPropertyForm() {
        return "property-form";
    }

    @RequestMapping(value = "/addNewProperty", method = RequestMethod.POST)
    public String addNewProperty(@ModelAttribute Property propertyDetails, Model model) {
        Property property = propertyService.addNewProperty(propertyDetails);
        model.addAttribute("property", property);
        return "property";
    }
  
    
    
    @RequestMapping("/updateProperty/{property_id}/{price}")
    public String updateProperty(@PathVariable int property_id, @PathVariable Double price) {
        propertyService.updateProperty(property_id, price);
        return "redirect:/getAllProperties";
    }
    
    @RequestMapping("/getPropertyByPropertyId/{propertyId}")
    public String getPropertyByPropertyId(@PathVariable int propertyId, Model model) {
        Property property = propertyService.getPropertyByPropertyId(propertyId);
        if (property != null) {
            model.addAttribute("property", property);
            return "property";
        } else {
            return "error";
        }
    }
   
}