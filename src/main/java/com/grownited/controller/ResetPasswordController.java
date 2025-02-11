package com.grownited.controller;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class ResetPasswordController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String email, 
                                @RequestParam String otp, 
                                @RequestParam String newPassword, 
                                Model model) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) {
            model.addAttribute("error", "Email not found!");
            return "Reset-Password";
        }

        UserEntity user = userOpt.get();
        if (!user.getOtp().equals(otp)) {
            model.addAttribute("error", "Invalid OTP!");
            return "Reset-Password";
        }

        // Update the password
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
        model.addAttribute("success", "Password reset successfully! Please login.");
        return "Login";
    }


}
