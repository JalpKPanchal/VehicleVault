package com.grownited.controller;

import com.grownited.entity.UserEntity;
import com.grownited.entity.UserEntity.Role;
import com.grownited.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

  

    // Handle Login
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<UserEntity> userOpt = authService.authenticateUser(email, password);
        
        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            model.addAttribute("user", user);

            Role userRole = user.getRole(); // Use ENUM instead of String
            if (userRole != null) {
                switch (userRole) {
                    case ADMIN:
                        return "AdminDashboard"; 
                    case USER:
                        return "UserDashboard"; 
                    case TECHNICIAN:
                        return "TechnicianDashboard"; 
                }
            }
            model.addAttribute("error", "Invalid role assigned.");
            return "Login";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "Login";
        }
    }



    // Show Register Page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "Register"; // Corresponding JSP page
    }

    // Handle User Registration
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserEntity user, Model model) {
        authService.registerUser(user);
        model.addAttribute("message", "Registration successful! Please log in.");
        return "Login";
    }

    // Show Forgot Password Page
    @GetMapping("/forgot-password")
    public String showForgotPasswordPage() {
        return "ForgotPassword"; // Corresponding JSP page
    }

 
}
