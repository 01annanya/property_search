package project_property_search_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import project_property_search_app.exception.HomeControllerException;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToHome() {
        try {
            return "redirect:/home";
        } catch (Exception e) {
            throw new HomeControllerException("Failed to redirect to home: " + e.getMessage());
        }
    }

    @GetMapping("/home")
    public String home() {
        try {
            return "home"; // This will render home.jsp located in WEB-INF/views
        } catch (Exception e) {
            throw new HomeControllerException("Failed to load home page: " + e.getMessage());
        }
    }

    @GetMapping("/openloginpage")
    public String openLoginPage() {
        try {
            return "login"; // This will render login.jsp
        } catch (Exception e) {
            throw new HomeControllerException("Failed to load login page: " + e.getMessage());
        }
    }

    @GetMapping("/signup")
    public String openSignupPage() {
        try {
            return "signup"; // This will render signup.jsp
        } catch (Exception e) {
            throw new HomeControllerException("Failed to load signup page: " + e.getMessage());
        }
    }

    @ExceptionHandler(HomeControllerException.class)
    public ModelAndView handleHomeControllerException(HomeControllerException e) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", e.getMessage());
        mav.setViewName("error");
        return mav;
    }
}