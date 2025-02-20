package com.grownited.controller;

import com.grownited.entity.ReviewEntity;
import com.grownited.service.AuthService;
import com.grownited.service.CarService;
import com.grownited.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CarService carService;

    @Autowired
    private AuthService authService;

    @GetMapping
    public String listReviews(Model model) {
        List<ReviewEntity> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "ReviewList";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("review", new ReviewEntity());
        model.addAttribute("cars", carService.getAllCars());
        model.addAttribute("users", authService.getAllUsers());	
        return "AddReview";
    }

    @PostMapping("/save")
    public String saveReview(@ModelAttribute("review") ReviewEntity review, @RequestParam Long carId, @RequestParam UUID userId) {
        reviewService.addReview(review, carId, userId);
        return "redirect:/review";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<ReviewEntity> review = reviewService.getReviewById(id);
        if (review.isPresent()) {
            model.addAttribute("review", review.get());
            return "EditReview";
        } else {
            return "redirect:/review";
        }
    }

    @PostMapping("/update/{id}")
    public String updateReview(@PathVariable Long id, @ModelAttribute("review") ReviewEntity updatedReview) {
        reviewService.updateReview(id, updatedReview);
        return "redirect:/review";
    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "redirect:/review";
    }
}
