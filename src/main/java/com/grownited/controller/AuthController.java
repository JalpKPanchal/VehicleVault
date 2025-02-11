package com.grownited.controller;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import com.grownited.service.OtpService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
  

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "Signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(UserEntity.AccountStatus.ACTIVE);
        userRepository.save(user);
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "Login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            if (userOpt.get().getStatus() == UserEntity.AccountStatus.DISABLED) {
                model.addAttribute("error", "Your account is disabled.");
                return "Login";
            }
            session.setAttribute("loggedUser", userOpt.get());
            return "Dashboard";
        }
        model.addAttribute("error", "Invalid credentials");
        return "Login";
    }


    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "Forgot-Password";
    }

   
  

   


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Destroy session
        return "redirect:/auth/login";
 // Redirect to login page
    }
}
