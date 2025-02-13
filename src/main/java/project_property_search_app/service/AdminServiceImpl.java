package project_property_search_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_property_search_app.entity.Admin;
import project_property_search_app.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Admin getAdminProfile(int adminId) {
        return adminRepository.findById(adminId);
    }

    @Override
    public void updateAdminProfile(int adminId, String email, String password) {
        adminRepository.updateAdminProfile(adminId, email, password);
    }

    @Override
    public Admin authenticate(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }

    @Override
    public boolean isValidPassword(String password) {
        // Password must be at least  characters long, contain an uppercase letter, a lowercase letter, a digit, and a special character
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(passwordPattern);
    }
}