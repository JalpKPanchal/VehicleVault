package com.grownited.service;

import com.grownited.entity.InsuranceEntity;
import com.grownited.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;

    public List<InsuranceEntity> getAllInsurance() {
        return insuranceRepository.findAll();
    }

    public Optional<InsuranceEntity> getInsuranceById(Long id) {
        return insuranceRepository.findById(id);
    }

    public InsuranceEntity addInsurance(InsuranceEntity insurance) {
        return insuranceRepository.save(insurance);
    }

    public InsuranceEntity updateInsurance(Long id, InsuranceEntity newInsurance) {
        return insuranceRepository.findById(id).map(insurance -> {
            insurance.setInsuranceType(newInsurance.getInsuranceType());
            return insuranceRepository.save(insurance);
        }).orElse(null);
    }

    public void deleteInsurance(Long id) {
        insuranceRepository.deleteById(id);
    }
}
