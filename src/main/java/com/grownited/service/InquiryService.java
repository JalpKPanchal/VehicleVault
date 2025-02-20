package com.grownited.service;

import com.grownited.entity.InquiryEntity;
import com.grownited.repository.InquiryRepository;
import com.grownited.entity.CarEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CarRepository;
import com.grownited.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    // Get all inquiries
    public List<InquiryEntity> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    // Get inquiry by ID
    public Optional<InquiryEntity> getInquiryById(Long id) {
        return inquiryRepository.findById(id);
    }

    // Add a new inquiry
    public void addInquiry(InquiryEntity inquiry, Long carId, UUID userId) {
        CarEntity car = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        inquiry.setCar(car);
        inquiry.setUser(user);
        inquiryRepository.save(inquiry);
    }

    // Update an inquiry
    public void updateInquiry(Long id, InquiryEntity updatedInquiry) {
        Optional<InquiryEntity> existingInquiryOpt = inquiryRepository.findById(id);
        if (existingInquiryOpt.isPresent()) {
            InquiryEntity existingInquiry = existingInquiryOpt.get();
            existingInquiry.setStatus(updatedInquiry.getStatus());
            existingInquiry.setMessage(updatedInquiry.getMessage());
            inquiryRepository.save(existingInquiry);
        }
    }

    // Delete an inquiry
    public void deleteInquiry(Long id) {
        inquiryRepository.deleteById(id);
    }
}
