package com.grownited.controller;

import com.grownited.entity.UserEntity;
import com.grownited.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class OTPVerificationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp, Model model) {
        Optional<UserEntity> userOpt = userRepository.findByEmail(email);
        
        if (userOpt.isEmpty() || !userOpt.get().isOtpValid(otp)) {
            model.addAttribute("error", "Invalid or expired OTP!");
            return "Reset-Password";
        }

        model.addAttribute("email", email);
        return "Reset-Password"; // Redirect to reset password page
    }

}
