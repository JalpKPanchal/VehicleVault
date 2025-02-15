package com.grownited.controller;

import com.grownited.entity.FeatureEntity;
import com.grownited.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @GetMapping
    public String listFeatures(Model model) {
        List<FeatureEntity> features = featureService.getAllFeatures();
        model.addAttribute("features", features);
        return "FeatureList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("feature", new FeatureEntity());
        return "AddFeature";
    }

    @PostMapping("/save")
    public String saveFeature(@ModelAttribute("feature") FeatureEntity feature) {
        featureService.addFeature(feature);
        return "redirect:/features";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<FeatureEntity> feature = featureService.getFeatureById(id);
        if (feature.isPresent()) {
            model.addAttribute("feature", feature.get());
            return "EditFeature";
        } else {
            return "redirect:/features";
        }
    }

    @PostMapping("/update/{id}")
    public String updateFeature(@PathVariable Long id, @ModelAttribute("feature") FeatureEntity updatedFeature) {
        featureService.updateFeature(id, updatedFeature);
        return "redirect:/features";
    }

    @GetMapping("/delete/{id}")
    public String deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
        return "redirect:/features";
    }
}
