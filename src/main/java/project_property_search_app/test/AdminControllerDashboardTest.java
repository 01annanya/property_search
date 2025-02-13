package project_property_search_app.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project_property_search_app.controller.AdminDashboardController;

class AdminDashboardControllerTest {

    private AdminDashboardController adminDashboardController;

    @BeforeEach
    public void setup() {
        adminDashboardController = new AdminDashboardController();
    }

    @Test
    void testShowAdminDashboard() {
        String viewName = adminDashboardController.showAdminDashboard();
        assertEquals("adminDashboard", viewName);
    }
}