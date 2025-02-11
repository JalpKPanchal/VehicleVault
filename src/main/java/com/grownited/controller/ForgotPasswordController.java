package com.grownited.controller;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import com.grownited.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class ForgotPasswordController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email, Model model) {
        Optional<UserEntity> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            model.addAttribute("error", "Email not found!");
            return "Forgot-Password";
        }

        UserEntity user = userOptional.get();
        user.generateOtp(); // 🔹 Generate OTP & set expiry
        userRepository.save(user); // 🔹 Save OTP in database

        // Send OTP via Email
        mailService.sendOtpEmail(user.getEmail(), user.getOtp());

        model.addAttribute("email", email);
        return "Reset-Password";
    }
}
