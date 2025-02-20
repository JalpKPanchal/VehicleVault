package com.grownited.service;

import com.grownited.entity.CarEntity;
import com.grownited.entity.ReviewEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CarRepository;
import com.grownited.repository.ReviewRepository;
import com.grownited.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<ReviewEntity> getReviewsByCarId(Long carId) {
        return reviewRepository.findByCarCarId(carId);
    }

    public void addReview(ReviewEntity review, Long carId, UUID userId) {
        CarEntity car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        review.setCar(car);
        review.setUser(user);
        reviewRepository.save(review);
    }

    public Optional<ReviewEntity> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public void updateReview(Long id, ReviewEntity updatedReview) {
        Optional<ReviewEntity> existingReviewOpt = reviewRepository.findById(id);
        if (existingReviewOpt.isPresent()) {
            ReviewEntity existingReview = existingReviewOpt.get();
            existingReview.setRating(updatedReview.getRating());
            existingReview.setReviewText(updatedReview.getReviewText());
            existingReview.setAnyExtraComment(updatedReview.getAnyExtraComment());
            reviewRepository.save(existingReview);
        }
    }
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
