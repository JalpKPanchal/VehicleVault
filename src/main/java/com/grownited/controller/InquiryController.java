package com.grownited.controller;

import com.grownited.entity.InquiryEntity;
import com.grownited.service.InquiryService;
import com.grownited.service.AuthService;
import com.grownited.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @Autowired
    private CarService carService;

    @Autowired
    private AuthService authService;

    // List all inquiries
    @GetMapping
    public String listInquiries(Model model) {
        List<InquiryEntity> inquiries = inquiryService.getAllInquiries();
        model.addAttribute("inquiries", inquiries);
        return "InquiryList";
    }

    // Show form to add new inquiry
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("inquiry", new InquiryEntity());
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("users", authService.getAllUsers());
        return "AddInquiry";
    }

    // Save new inquiry
    @PostMapping("/save")
    public String saveInquiry(@ModelAttribute("inquiry") InquiryEntity inquiry, 
                              @RequestParam Long carId, 
                              @RequestParam Long userId) {
        inquiryService.addInquiry(inquiry, carId, userId);
        return "redirect:/inquiry";
    }

    // Show form to edit an existing inquiry
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<InquiryEntity> inquiry = inquiryService.getInquiryById(id);
        if (inquiry.isPresent()) {
            model.addAttribute("inquiry", inquiry.get());
            return "EditInquiry";
        } else {
            return "redirect:/inquiry";
        }
    }

    // Update an inquiry
    @PostMapping("/update/{id}")
    public String updateInquiry(@PathVariable Long id, @ModelAttribute("inquiry") InquiryEntity updatedInquiry) {
        inquiryService.updateInquiry(id, updatedInquiry);
        return "redirect:/inquiry";
    }

    // Delete an inquiry
    @GetMapping("/delete/{id}")
    public String deleteInquiry(@PathVariable Long id) {
        inquiryService.deleteInquiry(id);
        return "redirect:/inquiry";
    }
}
