package project_property_search_app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;
import project_property_search_app.controller.HomeController;
import project_property_search_app.exception.HomeControllerException;

class HomeControllerTest {

    private HomeController homeController;

    @BeforeEach
    public void setup() {
        homeController = new HomeController();
    }

    @Test
    void testRedirectToHome() {
        String viewName = homeController.redirectToHome();
        assertEquals("redirect:/home", viewName);
    }

    @Test
    void testHome() {
        String viewName = homeController.home();
        assertEquals("home", viewName);
    }

    @Test
    void testOpenLoginPage() {
        String viewName = homeController.openLoginPage();
        assertEquals("login", viewName);
    }

    @Test
    void testOpenSignupPage() {
        String viewName = homeController.openSignupPage();
        assertEquals("signup", viewName);
    }

    @Test
    void testHandleHomeControllerException() {
        HomeControllerException exception = new HomeControllerException("Test exception");
        ModelAndView mav = homeController.handleHomeControllerException(exception);
        assertEquals("error", mav.getViewName());
        assertEquals("Test exception", mav.getModel().get("message"));
    }
}