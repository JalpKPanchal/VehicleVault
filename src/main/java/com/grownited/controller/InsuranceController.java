package com.grownited.controller;

import com.grownited.entity.InsuranceEntity;
import com.grownited.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @GetMapping
    public String listInsurance(Model model) {
        List<InsuranceEntity> insurances = insuranceService.getAllInsurance();
        model.addAttribute("insurances", insurances);
        return "InsuranceList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("insurance", new InsuranceEntity());
        model.addAttribute("insuranceTypes", InsuranceEntity.InsuranceType.values());
        return "AddInsurance";
    }

    @PostMapping("/save")
    public String saveInsurance(@ModelAttribute("insurance") InsuranceEntity insurance, RedirectAttributes redirectAttributes) {
        insuranceService.addInsurance(insurance);
        redirectAttributes.addFlashAttribute("successMessage", "Insurance added successfully!");
        return "redirect:/insurance";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return insuranceService.getInsuranceById(id)
                .map(insurance -> {
                    model.addAttribute("insurance", insurance);
                    model.addAttribute("insuranceTypes", InsuranceEntity.InsuranceType.values());
                    return "EditInsurance";
                })
                .orElseGet(() -> {
                    redirectAttributes.addFlashAttribute("errorMessage", "Insurance not found!");
                    return "redirect:/insurance";
                });
    }

    @PostMapping("/update/{id}")
    public String updateInsurance(@PathVariable Long id, @ModelAttribute("insurance") InsuranceEntity updatedInsurance, RedirectAttributes redirectAttributes) {
        InsuranceEntity updated = insuranceService.updateInsurance(id, updatedInsurance);
        if (updated != null) {
            redirectAttributes.addFlashAttribute("successMessage", "Insurance updated successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update insurance!");
        }
        return "redirect:/insurance";
    }

    @GetMapping("/delete/{id}")
    public String deleteInsurance(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        insuranceService.deleteInsurance(id);
        redirectAttributes.addFlashAttribute("successMessage", "Insurance deleted successfully!");
        return "redirect:/insurance";
    }
}
